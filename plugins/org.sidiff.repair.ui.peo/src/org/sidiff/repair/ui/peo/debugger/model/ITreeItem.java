package org.sidiff.repair.ui.peo.debugger.model;

import org.eclipse.swt.graphics.Image;

public interface ITreeItem {

	Image getIcon();
	
	String getText();
	
	ITreeItem getParent();
	
	ITreeItem[] getChildren();
}
