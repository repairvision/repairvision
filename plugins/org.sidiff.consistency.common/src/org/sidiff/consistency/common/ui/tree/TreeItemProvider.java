package org.sidiff.consistency.common.ui.tree;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;

public class TreeItemProvider extends LabelProvider implements IContentProvider {

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		IContentProvider.super.inputChanged(viewer, oldInput, newInput);
	}

	@Override
	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getText(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
}
