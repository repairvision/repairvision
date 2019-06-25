package org.sidiff.completion.ui.model;

import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.generateDecompositionSequenceFromHierarchicals;

import java.util.List;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.swt.graphics.Image;
import org.sidiff.completion.ui.list.ICompletionPreview;
import org.sidiff.completion.ui.list.ICompletionProposal;
import org.sidiff.graphpattern.edit.util.ItemProviderUtil;
import org.sidiff.graphpattern.profile.henshin_extension.RuleExtension;
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
	
	public DecompositionTemplates getDecomposition() {
		return new DecompositionTemplates(this);
	}
	
	@Override
	public String getText() {
		
		// Calculate name based on decomposition
		if ((complement.getComplementRule() instanceof RuleExtension) && (complement.getRecognizedRule() instanceof RuleExtension)) {
			DecompositionTemplates decomposition = getDecomposition();
			
			String complementDecompositionName = generateDecompositionSequenceFromHierarchicals(
					decomposition.getComplementTemplates());
			
			String recognizedDecompositionName = generateDecompositionSequenceFromHierarchicals(
					decomposition.getHistoricTemplates());
			
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
//		System.out.println("Preview: " + complement.getComplementRule().getName());
		return null;
	}

	@Override
	public boolean apply() {
		// TODO: Apply on editing domain
//		System.out.println("Apply: " + complement.getComplementRule().getName());
		return false;
	}

}
