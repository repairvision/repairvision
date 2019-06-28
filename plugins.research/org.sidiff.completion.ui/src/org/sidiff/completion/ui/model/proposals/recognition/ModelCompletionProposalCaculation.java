package org.sidiff.completion.ui.model.proposals.recognition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.completion.ui.model.proposals.ModelCompletionProposal;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.editrule.recognition.impact.ImpactScope;
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.peo.configuration.ComplementFinderSettings;
import org.sidiff.repair.complement.peo.finder.ComplementFinder;
import org.sidiff.repair.complement.peo.finder.ComplementFinderEngine;
import org.sidiff.repair.complement.peo.impact.GraphActionImpactUtil;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

// org.sidiff.repair.api.peo.PEORepairCaculation
public class ModelCompletionProposalCaculation {
	
	protected Rule editRule;
	
	protected ImpactAnalyzes impact;
	
	protected ImpactScope historicalImpactScope;
	
	protected ImpactScope currentImpactScope;
	
	protected ComplementFinderEngine complementFinderEngine;
	
	protected ComplementFinder complementFinder;
	
	public ModelCompletionProposalCaculation(Rule editRule, ImpactAnalyzes impact, ComplementFinderEngine complementFinderEngine) {
		
		this.editRule = editRule;
		this.impact = impact;
		this.complementFinderEngine = complementFinderEngine;
		
		List<GraphElement> changes = ChangePatternUtil.getPotentialChanges(editRule);
		List<Attribute> settingAttributes = ChangePatternUtil.getSettingAttributes(editRule);
		
		// Filter edit-rules by impact (sub-rule -> historical changes, complement-rule -> changes on current model):
		this.historicalImpactScope = new ImpactScope(changes, impact.getHistoricalImpactAnalysis());
		this.currentImpactScope = new ImpactScope(changes, impact.getCurrentImpactAnalysis());
		
		ImpactScope overwriteImpactScope = new ImpactScope(settingAttributes, impact.getCurrentImpactAnalysis());
		
		// Create complement finder:
		if (isPotentialProposal()) {
			complementFinder = complementFinderEngine.createComplementFinder(
					editRule, currentImpactScope, overwriteImpactScope, 
					historicalImpactScope, new ComplementFinderSettings());
		}
	}
	
	public boolean isPotentialProposal() {
		return !currentImpactScope.isEmpty() && !historicalImpactScope.isEmpty();
	}
	
	public List<ModelCompletionProposal> findProposals() {
		
		if (isPotentialProposal()) {
			List<ModelCompletionProposal> proposals = new ArrayList<>();
			
			for(ComplementRule complement : complementFinder.findComplementRules()) {

				// Filter sub-rule/complement by potential impact:
				if (complement.getComplementingChanges().size() > 0) {
					
					if (GraphActionImpactUtil.potential(
							impact.getCurrentPotentialImpactAnalysis(), 
							complement.getComplementingChanges()) 
					 && GraphActionImpactUtil.potential(
							 impact.getHistoricalPotentialImpactAnalysis(), 
							 complement.getRecognizedChanges())) {

						// Filter sub-rule by real impact:
						if (GraphActionImpactUtil.real(
								impact.getHistoricalImpactAnalysis(),
								complement.getRecognizedChanges(),
								complement.getRecognitionMatch())) {
							
							List<Match> complementMatches = complementFinderEngine.findComplementMatches(complement);
							List<Match> proposalMatches = new ArrayList<>(complementMatches.size());
							
							for (Match complementMatch : complementMatches) {
								
								// Filter complement by real impact:
								if (GraphActionImpactUtil.real(
										impact.getCurrentImpactAnalysis(), 
										complement.getComplementingChanges(), 
										complementMatch)) {
									
									proposalMatches.add(complementMatch);
								}
							}
							
							if (!proposalMatches.isEmpty()) {
								proposals.add(new ModelCompletionProposal(complement, proposalMatches));
							}
						}
					}
				}
			}
			
			return proposals;
		} else {
			return Collections.emptyList();
		}
	}
}
