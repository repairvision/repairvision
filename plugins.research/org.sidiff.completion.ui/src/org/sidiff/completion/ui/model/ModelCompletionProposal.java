package org.sidiff.completion.ui.model;

import java.util.List;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.swt.graphics.Image;
import org.sidiff.completion.ui.list.ICompletionPreview;
import org.sidiff.completion.ui.list.ICompletionProposal;
import org.sidiff.repair.complement.construction.ComplementRule;

public class ModelCompletionProposal implements ICompletionProposal {

	private ComplementRule complement;
	
	private List<Match> proposalMatches;
	
	public ModelCompletionProposal(ComplementRule complement, List<Match> proposalMatches) {
		this.complement = complement;
		this.proposalMatches = proposalMatches;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return complement.getComplementRule().getName();
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInformation() {
		// TODO Auto-generated method stub
		return complement.getComplementRule().getName();
	}

	@Override
	public ICompletionPreview preview() {
		// TODO Auto-generated method stub
		System.out.println("Preview: " + complement.getComplementRule().getName());
		return null;
	}

	@Override
	public boolean apply() {
		// TODO Auto-generated method stub
		System.out.println("Apply: " + complement.getComplementRule().getName());
		return false;
	}

}
