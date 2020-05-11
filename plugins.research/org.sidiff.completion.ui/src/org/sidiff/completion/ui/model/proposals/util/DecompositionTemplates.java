package org.sidiff.completion.ui.model.proposals.util;

import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.getDecomposition;
import static org.sidiff.revision.editrules.generation.decompose.DecomposingEditRulesUtil.getFirstLevelTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sidiff.completion.ui.model.proposals.ModelCompletionProposal;
import org.sidiff.graphpattern.profile.henshin_extension.RuleExtension;
import org.sidiff.graphpattern.profile.henshin_extension.SubGraph;

public class DecompositionTemplates {
	
	private ModelCompletionProposal proposal;

	private List<SubGraph> historicDecompositions;
	
	private List<String> historicTemplates;
	
	private List<String> historicFirstLevelTemplates;
	
	private List<SubGraph> complementingDecompositions;
	
	private List<String> complementingTemplates;
	
	private List<String> complementingFirstLevelTemplates;
	
	public DecompositionTemplates(ModelCompletionProposal proposal) {
		this.proposal = proposal;
	}
	
	public ModelCompletionProposal getProposal() {
		return proposal;
	}
	
	public SubGraph getHistoricByTemplate(String template) {
		int index = historicTemplates.indexOf(template);
		return historicDecompositions.get(index);
	}
	
	public SubGraph getHistoricByFirstLevel(String firstLevelTemplate) {
		int index = historicFirstLevelTemplates.indexOf(firstLevelTemplate);
		return historicDecompositions.get(index);
	}
	
	public SubGraph getComplementByFirstLevel(String firstLevelTemplate) {
		int index = complementingFirstLevelTemplates.indexOf(firstLevelTemplate);
		return complementingDecompositions.get(index);
	}
	
	public SubGraph getComplementByTemplate(String template) {
		int index = complementingTemplates.indexOf(template);
		return complementingDecompositions.get(index);
	}
	
	public List<SubGraph> getComplementDecomposition() {
		if (complementingDecompositions == null) {
			if (proposal.getComplement().getComplementRule() instanceof RuleExtension) {
				RuleExtension complementRule = (RuleExtension) proposal.getComplement().getComplementRule();
				complementingDecompositions = getDecomposition(complementRule.getSubgraphs(), proposal.getComplement().getComplementingChanges());
			} else {
				complementingDecompositions = Collections.emptyList();
			}
		}
		return complementingDecompositions;
	}
	
	public List<String> getComplementFirstLevel() {
		if (complementingFirstLevelTemplates == null) {
			List<SubGraph> decompositions = getComplementDecomposition(); 
			complementingFirstLevelTemplates = new ArrayList<>(decompositions.size());
			
			for (SubGraph decomposition : decompositions) {
				complementingFirstLevelTemplates.add(getFirstLevelTemplate(decomposition.getName()));
			}
		}
		return complementingFirstLevelTemplates;
	}
	
	public List<String> getComplementTemplates() {
		if (complementingTemplates == null) {
			List<SubGraph> decompositions = getComplementDecomposition(); 
			complementingTemplates = new ArrayList<>(decompositions.size());
			
			for (SubGraph decomposition : decompositions) {
				complementingTemplates.add(decomposition.getName());
			}
		}
		
		return complementingTemplates;
	}
	
	public List<SubGraph> getHistoricDecomposition() {
		if (historicDecompositions == null) {
			if (proposal.getComplement().getRecognizedRule() instanceof RuleExtension) {
				RuleExtension recognizedRule = (RuleExtension) proposal.getComplement().getRecognizedRule();
				historicDecompositions = getDecomposition(recognizedRule.getSubgraphs(), proposal.getComplement().getRecognizedChanges());
			} else {
				historicDecompositions = Collections.emptyList();
			}
		}
		return historicDecompositions;
	}
	
	public List<String> getHistoricFirstLevel() {
		if (historicFirstLevelTemplates == null) {
			List<SubGraph> decompositions = getHistoricDecomposition(); 
			historicFirstLevelTemplates = new ArrayList<>(decompositions.size());
			
			for (SubGraph decomposition : decompositions) {
				historicFirstLevelTemplates.add(getFirstLevelTemplate(decomposition.getName()));
			}
		}
		
		return historicFirstLevelTemplates;
	}
	
	public List<String> getHistoricTemplates() {
		if (historicTemplates == null) {
			List<SubGraph> decompositions = getHistoricDecomposition(); 
			historicTemplates = new ArrayList<>(decompositions.size());
			
			for (SubGraph decomposition : decompositions) {
				historicTemplates.add(decomposition.getName());
			}
		}
		
		return historicTemplates;
	}
}
