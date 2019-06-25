package org.sidiff.completion.ui.model;

import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.generateDecompositionNameFromSubGraphs;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.getDecomposition;
import static org.sidiff.graphpattern.tools.editrules.DecomposingEditRulesUtil.getFirstLevelTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.swt.graphics.Image;
import org.sidiff.completion.ui.list.ICompletionPreview;
import org.sidiff.completion.ui.list.ICompletionProposal;
import org.sidiff.graphpattern.edit.util.ItemProviderUtil;
import org.sidiff.graphpattern.profile.henshin_extension.RuleExtension;
import org.sidiff.graphpattern.profile.henshin_extension.SubGraph;
import org.sidiff.repair.complement.construction.ComplementRule;

public class ModelCompletionProposal implements ICompletionProposal {

	private static Image ICON = (Image) ItemProviderUtil.getImageByType(HenshinPackage.eINSTANCE.getRule());
	
	private ComplementRule complement;
	
	private List<Match> proposalMatches;
	
	public ModelCompletionProposal(ComplementRule complement, List<Match> proposalMatches) {
		this.complement = complement;
		this.proposalMatches = proposalMatches;
	}
	
	public ComplementRule getComplement() {
		return complement;
	}
	
	public List<Match> getProposalMatches() {
		return proposalMatches;
	}
	
	public List<SubGraph> getCurrentDecomposition() {
		if (complement.getComplementRule() instanceof RuleExtension) {
			RuleExtension complementRule = (RuleExtension) complement.getComplementRule();
			return getDecomposition(complementRule.getSubgraphs(), complement.getComplementingChanges());
		} else {
			return Collections.emptyList();
		}
	}
	
	public List<String> getCurrentDecompositionFirstLevelTemplates() {
		List<SubGraph> decompositions = getCurrentDecomposition(); 
		List<String> templates = new ArrayList<>(decompositions.size());
		
		for (SubGraph decomposition : decompositions) {
			templates.add(getFirstLevelTemplate(decomposition.getName()));
		}
		
		return templates;
	}
	
	public List<String> getCurrentDecompositionTemplates() {
		List<SubGraph> decompositions = getCurrentDecomposition(); 
		List<String> templates = new ArrayList<>(decompositions.size());
		
		for (SubGraph decomposition : decompositions) {
			templates.add(decomposition.getName());
		}
		
		return templates;
	}
	
	public List<SubGraph> getHistoricDecomposition() {
		if (complement.getRecognizedRule() instanceof RuleExtension) {
			RuleExtension recognizedRule = (RuleExtension) complement.getRecognizedRule();
			return getDecomposition(recognizedRule.getSubgraphs(), complement.getRecognizedChanges());
		} else {
			return Collections.emptyList();
		}
	}
	
	public List<String> getHistoricDecompositionFirstLevelTemplates() {
		List<SubGraph> decompositions = getHistoricDecomposition(); 
		List<String> templates = new ArrayList<>(decompositions.size());
		
		for (SubGraph decomposition : decompositions) {
			templates.add(getFirstLevelTemplate(decomposition.getName()));
		}
		
		return templates;
	}
	
	public List<String> getHistoricDecompositionTemplates() {
		List<SubGraph> decompositions = getHistoricDecomposition(); 
		List<String> templates = new ArrayList<>(decompositions.size());
		
		for (SubGraph decomposition : decompositions) {
			templates.add(decomposition.getName());
		}
		
		return templates;
	}
	
	@Override
	public String getText() {
		
		// Calculate name based on decomposition
		if ((complement.getComplementRule() instanceof RuleExtension) && (complement.getRecognizedRule() instanceof RuleExtension)) {
			List<SubGraph> complementDecomposition = getCurrentDecomposition();
			String complementDecompositionName = generateDecompositionNameFromSubGraphs(complementDecomposition);
			
			List<SubGraph> recognizedDecomposition = getHistoricDecomposition() ;
			String recognizedDecompositionName = generateDecompositionNameFromSubGraphs(recognizedDecomposition);
			
			return recognizedDecompositionName + " |-> " + complementDecompositionName;
		}
		
		return complement.getComplementRule().getName();
	}
	
	@Override
	public Image getImage() {
		return ICON;
	}

	@Override
	public String getInformation() {
		return "Partial execution of edit operation '" + complement.getComplementRule().getName() + "' recognized.";
	}

	@Override
	public ICompletionPreview preview() {
		// TODO: Apply/undo on editing domain
		System.out.println("Preview: " + complement.getComplementRule().getName());
		return null;
	}

	@Override
	public boolean apply() {
		// TODO open template in Codebricks editor
		System.out.println("Apply: " + complement.getComplementRule().getName());
		return false;
	}

}
