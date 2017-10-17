package org.sidiff.repair.ui.provider.model;

import org.eclipse.swt.graphics.Image;

public interface IItemProvider {

	String getText();
	
	Image getIcon();
	
	boolean hasChildren(Object element);
	
	Object[] getChildren();
	
	Object getParent();
	
	void actionDoubleClick();
	
	void actionSelection();
}
