package org.sidiff.consistency.common.ui.widgets;

import org.eclipse.swt.graphics.Image;

public interface ITreeItem {

	/**
	 * @return The icon to show in a tree viewer.
	 */
	Image getIcon();
	
	/**
	 * @return The text to show in a tree viewer.
	 */
	String getText();
	
	/**
	 * @return The parent element in the tree.
	 */
	ITreeItem getParent();
	
	/**
	 * @return All children of this element in the tree.
	 */
	ITreeItem[] getChildren();
}
