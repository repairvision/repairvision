package org.sidiff.consistency.repair.lifting.ui.provider;

import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class RepairContentProvider implements IStructuredContentProvider, ITreeContentProvider  {

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		
		if (parentElement instanceof Collection<?>) {
			return ((Collection<?>) parentElement).toArray();
		}
		
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		
		if (element instanceof Collection<?>) {
			return true;
		}
		
		return false;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		
		if (inputElement instanceof Collection<?>) {
			return ((Collection<?>) inputElement).toArray();
		}
		
		return new Object[0];
	}
}
