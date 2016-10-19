package org.sidiff.consistency.repair.lifting.cpo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.henshin.HenshinModuleAnalysis;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.common.henshin.HenshinUnitAnalysis;
import org.sidiff.common.henshin.exceptions.NoMainUnitFoundException;
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.lifting.api.Repair;
import org.sidiff.consistency.repair.lifting.api.RepairJob;
import org.sidiff.consistency.repair.lifting.cpo.complement.ComplementFinder;
import org.sidiff.difference.lifting.api.LiftingFacade;
import org.sidiff.difference.lifting.api.settings.LiftingSettings;
import org.sidiff.difference.lifting.api.settings.LiftingSettings.RecognitionEngineMode;
import org.sidiff.difference.lifting.api.util.PipelineUtils;
import org.sidiff.difference.lifting.recognitionengine.IRecognitionEngine;
import org.sidiff.difference.lifting.recognitionengine.impl.RecognitionEngine;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.rulebase.view.LiftingRuleBase;
import org.sidiff.difference.rulebase.wrapper.EditWrapper2RecognitionWrapper;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.util.DifferenceAnalysis;
import org.sidiff.difference.symmetric.util.DifferenceAnalysisUtil;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.editrule.rulebase.EditRule;
import org.sidiff.editrule.rulebase.RuleBase;
import org.sidiff.editrule.rulebase.RuleBaseItem;
import org.sidiff.editrule.rulebase.RulebaseFactory;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public class CPORepairFacade {
	
	public static long liftingSetup;
	
	/**
	 * Search for partially executed edit-operation which might cause an
	 * inconsistency. A repair complements such a partial edit-operation.
	 * 
	 * @param uriModelA
	 *            The historic model.
	 * @param uriModelB
	 *            The actual model.
	 * @param subEditRules
	 *            All edit-rules which are to be investigated for partial executions.
	 * @param cpEditRules
	 *            All consistency-preserving edit-operations.
	 * @param documentType
	 * @param settings
	 *            The settings for the difference calculation.
	 * @return All found repairs.
	 */
	public static RepairJob getRepairs(
			URI uriModelA, URI uriModelB, 
			Collection<Rule> subEditRules, Collection<Rule> cpEditRules, 
			String documentType, DifferenceSettings settings) {
		
		// Load models:
		long startLoadModels = System.currentTimeMillis();
		
		ResourceSet differenceRSS = new ResourceSetImpl();
		Resource modelA = differenceRSS.getResource(uriModelA, true);
		Resource modelB = differenceRSS.getResource(uriModelB, true);
		
		if (DebugUtil.statistic) {
			System.out.println("#DONE# Loading Models: " + (System.currentTimeMillis() - startLoadModels) + "ms");
		}
		
		return getRepairs(modelA, modelB, subEditRules, cpEditRules, documentType, settings);
	}
	
	/**
	 * Search for partially executed edit-operation which might cause an
	 * inconsistency. A repair complements such a partial edit-operation.
	 * 
	 * @param modelA
	 *            The historic model.
	 * @param modelB
	 *            The actual model.
	 * @param subEditRules
	 *            All edit-rules which are to be investigated for partial executions.
	 * @param cpEditRules
	 *            All consistency-preserving edit-operations.
	 * @param documentType
	 * @param settings
	 *            The settings for the difference calculation.
	 * @return All found repairs.
	 */
	public static RepairJob getRepairs(
			Resource modelA, Resource modelB, 
			Collection<Rule> subEditRules, Collection<Rule> cpEditRules, 
			String documentType, DifferenceSettings settings) {
		
		long repairJobTime = System.currentTimeMillis();
		
		// Initialize:
		assert (modelA.getResourceSet() == modelB.getResourceSet());
		ResourceSet differenceRSS = modelA.getResourceSet(); 
		
		// TODO: Create fresh resource set!?
		// [Workaround] (Cleanup) Remove old difference:
		for (Iterator<Resource> it = differenceRSS.getResources().iterator(); it.hasNext();) {
			Resource res = it.next();
			
			if (res instanceof SymmetricDifference) {
				it.remove();
			}
		}
		
		// Calculate difference:
		SymmetricDifference difference = null;
		IRecognitionEngine recognitionEngine = null;
		ILiftingRuleBase rulebases_sub = null;
		
		try {
			
			// Create a (temporary) CPO rulebase:
			ILiftingRuleBase rulebase_cpo = createRuleBase(cpEditRules, "CPOs"); 
			Set<ILiftingRuleBase> rulebases_cpos = new HashSet<>();
			rulebases_cpos.add(rulebase_cpo);
			
			// Create a (temporary) Sub-EO rulebase:
			rulebases_sub = createRuleBase(subEditRules, "Sub-Rules"); 
			Set<ILiftingRuleBase> rulebases_subs = new HashSet<>();
			rulebases_subs.add(rulebases_sub);
			
			// Common-Lifting settings:
			LiftingSettings liftingSettings = new LiftingSettings(Collections.singleton(documentType));
			liftingSettings.setMatcher(settings.getMatcher());
			liftingSettings.setTechBuilder(PipelineUtils.getDefaultTechnicalDifferenceBuilder(documentType));
			liftingSettings.setCalculateEditRuleMatch(false);
			
			// Create technical difference:
			long calculateDifference = System.currentTimeMillis();
			
			difference = LiftingFacade.deriveTechnicalDifference(modelA, modelB, settings);
			
			if (DebugUtil.statistic) {
				System.out.println("#DONE# Calculate Difference: " + (System.currentTimeMillis() - calculateDifference) + "ms");
			}
			
			// CPO-Lifting:
			long cpoLifting = System.currentTimeMillis();
			
			liftingSettings.setRuleBases(rulebases_cpos);
			liftingSettings.setRecognitionEngineMode(RecognitionEngineMode.LIFTING); // no post-processing
			difference = LiftingFacade.liftTechnicalDifference(difference, liftingSettings);
			
			if (DebugUtil.statistic) {
				System.out.println("------ Change Sets (CPO): " + difference.getChangeSets().size());
//				analyzeDifference(difference);
			}
			
			// Remove CPO change sets:
			// TODO: Parallelize this...
			for (SemanticChangeSet changeSet : difference.getChangeSets()) {
				for (Change change : changeSet.getChanges()) {
					difference.getChanges().remove(change);
				}
			}
			difference.getChangeSets().clear();
			difference.getUnusedChangeSets().clear();
			
			if (DebugUtil.statistic) {
				System.out.println("#DONE# Searching CPOs: " + (System.currentTimeMillis() - cpoLifting) + "ms");
			}
			
			// Sub-EO-Lifting (on reduced difference):
			long subLifting = System.currentTimeMillis();
			
			liftingSettings.setRuleBases(rulebases_subs);
			liftingSettings.setRecognitionEngineMode(RecognitionEngineMode.LIFTING_AND_POST_PROCESSING); 
			// FIXME: post-processing per CPO!?

			// TODO[Optimization]: Reuse of CPO recognition engine possible!?
			//                     At least modelA an B graph! 
			liftingSettings.setRecognitionEngine(null);
			
			difference = LiftingFacade.liftTechnicalDifference(difference, liftingSettings);
			
			if (DebugUtil.statistic) {
				System.out.println("------ Change Sets (Sub-EOs): " + difference.getChangeSets().size());
				System.out.println("#DONE# Searching Sub-EOs: " + (System.currentTimeMillis() - subLifting) + "ms");
			}
			
			// Save used recognition engine:
			recognitionEngine = liftingSettings.getRecognitionEngine();
			
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		// TODO: if (difference.getChangeSets().size() > 0) 
			
		// TODO: Support differences without resource...
		Resource differenceResource = differenceRSS.createResource(URI.createURI(""));
		differenceResource.getContents().add(difference);
		
		// Repair application:
		EngineImpl henshinEngine = new EngineImpl();
		
		// Use the graph of the recognition engine or with merged imports!
//		EGraph modelBGraph = new EGraphImpl(modelB);
		EGraph modelBGraph = ((RecognitionEngine)recognitionEngine).getGraphFactory().getModelBGraph();
		
		// Calculate repairs:
		long calculateComplements = System.currentTimeMillis();
		
		ComplementFinder complementFinder = new ComplementFinder(
				recognitionEngine, rulebases_sub, subEditRules, cpEditRules, 
				difference, modelBGraph);
		
		Map<Rule, List<Repair>> repairs = new LinkedHashMap<>();
		
		if (DebugUtil.statistic) {
			System.out.println("#DONE# Complement Calculation: " + (System.currentTimeMillis() - calculateComplements) + "ms");
		}
		
		long calculateRepairs = System.currentTimeMillis();
		
		for (Rule cpEditRule : complementFinder.getSourceRules()) {
			List<Repair> repairsPerRule = new ArrayList<>();

			for(ComplementRule complement : complementFinder.getComplementRules(cpEditRule)) {
				if (complement.getComplementingChanges().size() > 0) {
					for (ComplementMatch preMatch : complement.getComplementMatches()) {
						repairsPerRule.add(new Repair(complement, preMatch));
					}
					complement.initialize(henshinEngine, modelBGraph);
				}
			}

			if (!repairsPerRule.isEmpty()) {
				repairs.put(cpEditRule, repairsPerRule);
			}
		}

		// Create repair job:
		RepairJob repairJob = new RepairJob();
		repairJob.setDifference(differenceResource);
		repairJob.setModelA(modelA);
		repairJob.setModelB(modelB);
		repairJob.setRepairs(repairs);
		// repairJob.setValidations(); // TODO: Add a common interface...

		if (DebugUtil.statistic) {
			System.out.println("#DONE# Calculate Repairs: " + (System.currentTimeMillis() - calculateRepairs) + "ms");
			System.out.println("#DONE# Full Repair Job: " + (System.currentTimeMillis() - repairJobTime) + "ms");
			
			analyzeSetup(subEditRules, cpEditRules, difference);
		}
		
		return repairJob;
	}
	
	private static void analyzeSetup(
			Collection<Rule> subEditRules, Collection<Rule> cpEditRules,
			SymmetricDifference difference) {
		
		System.out.println("---------------- Difference after CPO changes were removed ---------------- ");
		analyzeDifference(difference);
		
		System.out.println("---------------- Rules ---------------- ");
		System.out.println("Count of preserve, delete and create nodes/edges (integrated).");
		
		System.out.println("---------------- CPO ---------------- ");
		int fullNodeCount_cpo = 0;
		int fullEdgeCount_cpo = 0;
		
		for (Rule cpo : cpEditRules) {
			int nodes = getNodeCount(cpo);
			int edges = getEdgeCount(cpo);
			
			fullNodeCount_cpo += nodes;
			fullEdgeCount_cpo += edges;
			
			System.out.println(cpo.getName());
			System.out.println("  - Nodes: " + nodes);
			System.out.println("  - Edges: " + edges);
		}
		
		System.out.println("################## SUM ##################");
		System.out.println("Rules: " + cpEditRules.size());
		System.out.println("All Nodes: " + fullNodeCount_cpo);
		System.out.println("avg. Nodes: " + ((double) fullNodeCount_cpo / (double) cpEditRules.size()));
		System.out.println("All Edges: " + fullEdgeCount_cpo);
		System.out.println("avg. Edges: " + ((double) fullEdgeCount_cpo / (double) cpEditRules.size()));
		
		System.out.println("---------------- Sub-EO ---------------- ");
		int fullNodeCount_sub = 0;
		int fullEdgeCount_sub = 0;
		
		for (Rule sub : subEditRules) {
			int nodes = getNodeCount(sub);
			int edges = getEdgeCount(sub);
			
			fullNodeCount_sub += nodes;
			fullEdgeCount_sub += edges;
			
			System.out.println(sub.getName());
			System.out.println("  - Nodes: " + nodes);
			System.out.println("  - Edges: " + edges);
		}
		
		System.out.println("################## SUM ##################");
		System.out.println("Rules: " + subEditRules.size());
		System.out.println("All Nodes: " + fullNodeCount_sub);
		System.out.println("avg. Nodes: " + ((double) fullNodeCount_sub / (double) subEditRules.size()));
		System.out.println("All Edges: " + fullEdgeCount_sub);
		System.out.println("avg. Edges: " + ((double) fullEdgeCount_sub / (double) subEditRules.size()));
	}
	
	private static int getNodeCount(Rule rule) {
		return HenshinRuleAnalysisUtilEx.getLHSIntersectRHSNodes(rule).size()
				+ HenshinRuleAnalysisUtilEx.getLHSMinusRHSNodes(rule).size()
				+ HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes(rule).size();
	}
	
	private static int getEdgeCount(Rule rule) {
		return HenshinRuleAnalysisUtilEx.getLHSIntersectRHSEdges(rule).size()
				+ HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges(rule).size()
				+ HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges(rule).size();
	}
	
	/**
	 * Analyze the difference.
	 * 
	 * @param difference
	 *            The Symmetric-Difference.
	 */
	private static void analyzeDifference(SymmetricDifference difference) {
		
		// Analyze models:
		System.out.println("---------------- Models ---------------- ");
		
		System.out.println("Model A: " + difference.getModelA().getURI().lastSegment());
		System.out.println("Model B: " + difference.getModelB().getURI().lastSegment());
		
		System.out.println("Objects Model A: " + getModelObjectCount(difference.getModelA().getAllContents()));
		System.out.println("References Model A: " + getModelReferenceCount(difference.getModelA().getAllContents()));
		
		System.out.println("Objects Model B: " + getModelObjectCount(difference.getModelB().getAllContents()));
		System.out.println("References Model B: " + getModelReferenceCount(difference.getModelB().getAllContents()));
		
		// Analyze difference:
		DifferenceAnalysis analysis = new DifferenceAnalysis(difference);
		
		System.out.println("---------------- Technical Difference ---------------- ");
		System.out.println("Add Objects: " + analysis.getAddObjectCount());
		System.out.println("Remove Objects: " + analysis.getRemoveObjectCount());
		System.out.println("Add References: " + analysis.getAddReferenceCount());
		System.out.println("Remove References: " + analysis.getRemoveReferenceCount());
		System.out.println("Attribute Value Changes: " + analysis.getAttributeValueChangeCount());
		System.out.println("Correspondences: " + analysis.getCorrespondenceCount());
		System.out.println("Change Sets (Sub-EO): " + difference.getChangeSets().size());
		
		int allChanges = difference.getChanges().size();
		int uncoveredChanges = DifferenceAnalysisUtil.getRemainingChanges(difference).size();
		int coveredChanges = allChanges - uncoveredChanges;
		
		System.out.println("All Changes: " + allChanges);
		System.out.println("Changes in Change Sets: " + coveredChanges);
		System.out.println("Changes without Change Sets: " + uncoveredChanges);
	}
	
	private static LiftingRuleBase createRuleBase(Collection<Rule> editRules, String name) {
		LiftingRuleBase rulebaseView = new LiftingRuleBase();
		
		RuleBase rulebase = RulebaseFactory.eINSTANCE.createRuleBase();
		rulebase.setName(name);
		rulebaseView.init(rulebase);
		
		for (Rule subEditRule : editRules) {

			// Add edit rule:
			EditRule editRuleWrapper = createEditRule(subEditRule.getModule());
			RuleBaseItem rulebaseItem = createItem(editRuleWrapper);
			rulebase.getItems().add(rulebaseItem);

			// Transform edit- to recognition-rule:
			try {
				EditWrapper2RecognitionWrapper edit2Recognition = new EditWrapper2RecognitionWrapper();
				edit2Recognition.transform(rulebaseItem);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return rulebaseView;
	}
	
	/**
	 * Counts all object of a model.
	 * 
	 * @param it
	 *            An iterator to iterate over all elements of the model.
	 * @return The counted object of the model.
	 */
	public static int getModelObjectCount(Iterator<EObject> it) {
		int counter = 0;
		
		while (it.hasNext()) {
			it.next();
			counter++;
		}
		return counter;
	}
	
	/**
	 * Counts all references of a model.
	 * 
	 * @param it
	 *            An iterator to iterate over all elements of the model.
	 * @return The counted references of the model.
	 */
	public static int getModelReferenceCount(Iterator<EObject> it) {
		int counter = 0;
		
		while(it.hasNext()) {
			EObject obj = it.next();
			
			for (EReference ref : obj.eClass().getEAllReferences()) {
				if (obj.eGet(ref) != null) {
					if (ref.isMany()) {
						Collection<?> multiRef = (Collection<?>) obj.eGet(ref);
						counter += multiRef.size();
					} else {
						counter++;
					}	
				}
			}
		}
		return counter;
	}
	
	/**
	 * Initializes a rule base edit rule wrapper.
	 * 
	 * @return an edit rule wrapper.
	 * @throws NoMainUnitFoundException 
	 */
	private static EditRule createEditRule(Module editModule) {

		// Create edit rule
		try {
			EditRule editRule = RulebaseFactory.eINSTANCE.createEditRule();
			editRule.setExecuteMainUnit(HenshinUnitAnalysis.findExecuteMainUnit(editModule));
			editRule.setUseDerivedFeatures(HenshinModuleAnalysis.hasDerivedReferences(editModule));
			
			return editRule;
		} catch (NoMainUnitFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Creates a new rule base item which includes an edit rule.
	 * 
	 * @param editRule
	 *            The Henshin edit-rule.
	 * 
	 * @return A new rule base item.
	 */
	private static RuleBaseItem createItem(EditRule editRule) {
		
		// Create rule base element
		RuleBaseItem item = RulebaseFactory.eINSTANCE.createRuleBaseItem();
		item.setEditRule(editRule);
		
		return item;
	}
}
