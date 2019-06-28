package org.sidiff.completion.ui.proposals;

import org.eclipse.swt.graphics.Image;

public interface ICompletionProposal {

	String getText();
	
	Image getImage();
	
	String getInformation();
	
	ICompletionPreview preview();
	
	boolean apply();
}
