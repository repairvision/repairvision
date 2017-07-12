package org.sidiff.repair.validation.ui.provider;

import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;

public class RepairTreeContentProvider implements IStructuredContentProvider, ITreeContentProvider {

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
	
	@Override
	public boolean hasChildren(Object element) {
		
		if (element instanceof RepairValidation) {
			return true;
		}
		
		else if (element instanceof IDecisionBranch) {
			return !((IDecisionBranch) element).getChildDecisions().isEmpty();
		}
		
		return false;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		
		if (parentElement instanceof RepairValidation) {
			RepairValidation validation = (RepairValidation) parentElement;
			
			return new Object[] {
					validation.getContext(),
					validation.getRepair()
			};
		}
		
		else if (parentElement instanceof IDecisionBranch) {
			IDecisionBranch repairDecision = (IDecisionBranch) parentElement;
			return repairDecision.getChildDecisions().toArray();
		}
		
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public Object[] getElements(Object inputElement) {

		if (inputElement instanceof Collection<?>) {
			return ((Collection<?>) inputElement).toArray();
		}
		
		return new Object[0];
	}

}
