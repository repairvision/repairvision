package org.sidiff.repair.api.cpo.lifting;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.difference.lifting.api.LiftingFacade;
import org.sidiff.difference.lifting.api.settings.LiftingSettings;
import org.sidiff.difference.lifting.api.settings.LiftingSettings.RecognitionEngineMode;
import org.sidiff.difference.lifting.api.util.PipelineUtils;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.util.DifferenceAnalysisUtil;
import org.sidiff.repair.api.cpo.CPORepairSettings;
import org.sidiff.repair.api.cpo.util.PostProcessingUtil;
import org.sidiff.repair.api.cpo.util.RulebaseUtil;

public class FragmentedCPOLifting extends BasicCPOLifting {
	
	@Override
	public void findSubEditRules(Resource modelA, Resource modelB, CPORepairSettings settings) {
		
		try {
			
			// Create a (temporary) CPO rulebase:
			ILiftingRuleBase rulebase_cpo = RulebaseUtil.createRuleBase(settings.getCPOEditRules(), "CPOs"); 
			Set<ILiftingRuleBase> rulebases_cpos = new HashSet<>();
			rulebases_cpos.add(rulebase_cpo);
			
			// Create a (temporary) Sub-EO rulebase:
			rulebases_sub = RulebaseUtil.createRuleBase(settings.getSubEditRules(), "Sub-Rules"); 
			Set<ILiftingRuleBase> rulebases_subs = new HashSet<>();
			rulebases_subs.add(rulebases_sub);
			
			// Common-Lifting settings:
			LiftingSettings liftingSettings = new LiftingSettings(Collections.singleton(settings.getDocumentType()));
			liftingSettings.setMatcher(settings.getDifferenceSettings().getMatcher());
			liftingSettings.setTechBuilder(PipelineUtils.getDefaultTechnicalDifferenceBuilder(Collections.singleton(settings.getDocumentType())));
			liftingSettings.setCalculateEditRuleMatch(false);
			
			// Create technical difference:
			long calculateDifference = System.currentTimeMillis();
			
			difference = LiftingFacade.deriveTechnicalDifference(modelA, modelB, settings.getDifferenceSettings());
			
			if (DebugUtil.statistic) {
				System.out.println("#DONE# Calculate Difference: " + (System.currentTimeMillis() - calculateDifference) + "ms");
			}
			
			// CPO-Lifting:
			long cpoLifting = System.currentTimeMillis();
			
			liftingSettings.setRuleBases(rulebases_cpos);
			liftingSettings.setRecognitionEngineMode(RecognitionEngineMode.LIFTING); // no post-processing
			difference = LiftingFacade.liftTechnicalDifference(difference, liftingSettings);
			
			Set<SemanticChangeSet> cpoCS = new HashSet<>(difference.getChangeSets());
			
			if (DebugUtil.statistic) {
				System.out.println("------ Change Sets (CPO): " + difference.getChangeSets().size());
				System.out.println("#DONE# Searching CPOs: " + (System.currentTimeMillis() - cpoLifting) + "ms");
//				analyzeDifference(difference);
			}
			
			// Sub-EO-Lifting (on reduced difference):
			long subLifting = System.currentTimeMillis();
			
			liftingSettings.setRuleBases(rulebases_subs);
			liftingSettings.setRecognitionEngineMode(RecognitionEngineMode.LIFTING); // no post-processing
			liftingSettings.setRecognitionEngine(null);
			
			// TODO:
			// => adjust (sub) rule filter -> needs minimal a
			//    change that is not covered by CPO change sets
			// => local (restricted) search for Sub-Rules
			//    [FP]-Local-Search -> start with changes that are not covered by CPOs
			//						(-> build "abstract search graph patterns" based on all EOs)
			//						-> exact matching -> run each path only once!?
			difference = LiftingFacade.liftTechnicalDifference(difference, liftingSettings);

			// Post-processing:
			DifferenceAnalysisUtil.analyzeDifferenceStructure(difference);
			
			// Remove properly nested EOs (keep overlapping):
			PostProcessingUtil.removeSubChangeSets(difference);
			
			// Remove all consistent changes:
			removeConsistentChanges(cpoCS);
			
			// TODO: How to deal with duplicates!?
			PostProcessingUtil.removeDuplicatedChangeSets(difference);
			
			if (DebugUtil.statistic) {
				System.out.println("------ Change Sets (Sub-EOs): " + difference.getChangeSets().size());
				System.out.println("#DONE# Searching Sub-EOs: " + (System.currentTimeMillis() - subLifting) + "ms");
			}
			
			// Save used recognition engine:
			recognitionEngine = liftingSettings.getRecognitionEngine();
			
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
	}
	
	private void removeConsistentChanges(Set<SemanticChangeSet> cpoChangeSets) {
		
		// Remove properly nested EOs (keep overlapping):
		Set<SemanticChangeSet> toBeRemoved = new HashSet<SemanticChangeSet>();
		
		// CPOs:
		toBeRemoved.addAll(cpoChangeSets);

		// Keep only EOs that are not covered by CPOs:
		for (SemanticChangeSet cs : difference.getChangeSets()) {
			
			// Is covered by CPOs:
			if (!toBeRemoved.contains(cs)) {
				boolean allChangeCovered = false;
				
				// Is covered exactly by a CPO:
				for (SemanticChangeSet overlaying : cs.getOverlayings()) {
					if (cpoChangeSets.contains(overlaying)) {
						allChangeCovered = true;
						break;
					}
				}
				
				// Is covered by multiple CPOs:
				if (!allChangeCovered) {
					allChangeCovered = true;
					
					for (Change change : cs.getChanges()) {
						boolean changeCovered = false;
						
						// Partially overlapping CPOs:
						for (SemanticChangeSet overlappingCS : cs.getPartiallyOverlappings()) {
							
							// Is CPO?
							if (cpoChangeSets.contains(overlappingCS)) {
								if (overlappingCS.getChanges().contains(change)) {
									changeCovered = true;
									break;
								}
							}
						}
						
						if (!changeCovered) {
							allChangeCovered = false;
							break;
						}
					}
				}

				if (allChangeCovered) {
					toBeRemoved.add(cs);
				}
			}
		}
		
		// Remove all consistent changes:
		difference.getChangeSets().removeAll(toBeRemoved);
	}
}
