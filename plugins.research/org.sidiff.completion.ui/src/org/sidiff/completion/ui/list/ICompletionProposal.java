package org.sidiff.completion.ui.list;

import org.eclipse.swt.graphics.Image;

public interface ICompletionProposal {

	String getText();
	
	Image getImage();
	
	String getInformation();
	
	ICompletionPreview preview();
	
	boolean apply();
}
