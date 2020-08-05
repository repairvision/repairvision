package org.sidiff.revision.repair.ui.debugger;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class TreeItemProvider extends LabelProvider implements IContentProvider, IStructuredContentProvider, ITreeContentProvider  {
	
	@Override
	public Object[] getChildren(Object parentElement) {
		
		if (parentElement instanceof ITreeItem) {
			return ((ITreeItem) parentElement).getChildren();
		}
		
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		
		if (element instanceof ITreeItem) {
			return ((ITreeItem) element).getParent();
		}
		
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		
		if (element instanceof ITreeItem) {
			return ((ITreeItem) element).hasChildren();
		}
		
		return false;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Image getImage(Object element) {
		
		if (element instanceof ITreeItem) {
			return ((ITreeItem) element).getIcon();
		}
		
		return null;
	}
	
	@Override
	public String getText(Object element) {
		
		if (element instanceof ITreeItem) {
			return ((ITreeItem) element).getText();
		}
		
		return null;
	}
}
