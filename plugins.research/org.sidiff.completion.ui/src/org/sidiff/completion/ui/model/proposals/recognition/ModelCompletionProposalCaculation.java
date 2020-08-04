package org.sidiff.completion.ui.model.proposals.recognition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.completion.ui.model.proposals.ModelCompletionProposal;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.editrules.complement.construction.ComplementRule;
import org.sidiff.revision.editrules.complement.matching.configuration.ComplementFinderSettings;
import org.sidiff.revision.editrules.complement.matching.finder.ComplementFinder;
import org.sidiff.revision.editrules.complement.matching.finder.ComplementFinderEngine;
import org.sidiff.revision.editrules.impact.graph.GraphActionImpactAnalysis;
import org.sidiff.revision.editrules.impact.graph.PotentialGraphActionImpactAnalysis;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionSettings;
import org.sidiff.revision.impact.analysis.ImpactAnalyzes;

// org.sidiff.revision.repair.api.peo.PEORepairCaculation
public class ModelCompletionProposalCaculation {
	
	private ComplementFinderEngine complementFinderEngine;
	
	private ComplementFinderSettings complementFinderSettings;
	
	private ComplementFinder complementFinder;
	
	public ModelCompletionProposalCaculation(
			Rule editRule, IRevision revision,
			ImpactAnalyzes historicalImpactAnalyzes, ImpactAnalyzes currentImpactAnalyzes,
			ComplementFinderEngine complementFinderEngine) {
		
		this.complementFinderEngine = complementFinderEngine;
		
		// Create complement finder:
		this.complementFinderSettings = new ComplementFinderSettings();
		RecognitionSettings recognitionSettings = complementFinderSettings.getRecognitionEngineSettings();
		recognitionSettings.setEditRule(editRule);
		recognitionSettings.setRevision(revision);
		recognitionSettings.setImpactAnalyzes(historicalImpactAnalyzes, currentImpactAnalyzes);
		
		if (recognitionSettings.hasPotentialImpact()) {
			this.complementFinder = complementFinderEngine.createComplementFinder(complementFinderSettings);
		}
	}
	
	public List<ModelCompletionProposal> findProposals() {
		RecognitionSettings recognitionSettings = complementFinderSettings.getRecognitionEngineSettings();
		
		PotentialGraphActionImpactAnalysis historicalPotentialImpact = new PotentialGraphActionImpactAnalysis(
				recognitionSettings.getHistoricalImpactAnalyzes().getPotentialImpactAnalysis());
		
		PotentialGraphActionImpactAnalysis currentPotentialImpact = new PotentialGraphActionImpactAnalysis(
				recognitionSettings.getCurrentImpactAnalyzes().getPotentialImpactAnalysis());
		
		GraphActionImpactAnalysis historicalImpact = new GraphActionImpactAnalysis(
				recognitionSettings.getHistoricalImpactAnalyzes().getImpactAnalysis());
		
		if (recognitionSettings.hasPotentialImpact()) {
			List<ModelCompletionProposal> proposals = new ArrayList<>();
			
			for(ComplementRule complement : complementFinder.findComplementRules()) {

				// Filter sub-rule/complement by potential impact:
				if (complement.getComplementingChanges().size() > 0) {
					
					if (currentPotentialImpact.hasImpact(complement.getComplementingChanges())
							&& historicalPotentialImpact.hasImpact(complement.getRecognizedChanges())) {

						// Filter sub-rule by real impact:
						if (historicalImpact.hasImpact(complement.getRecognizedChanges(), complement.getRecognitionMatching())) {
							List<Match> proposalMatches = complementFinderEngine.findComplementMatches(complement);
							
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

	public ComplementFinderSettings getComplementFinderSettings() {
		return complementFinderSettings;
	}
}
