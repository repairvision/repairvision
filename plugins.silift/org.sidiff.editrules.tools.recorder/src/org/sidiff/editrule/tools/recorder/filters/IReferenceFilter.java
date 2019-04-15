package org.sidiff.editrule.tools.recorder.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public interface IReferenceFilter {

	public static final IReferenceFilter DUMMY = new IReferenceFilter() {
		
		@Override
		public boolean filter(EObject source, EObject target, EReference type) {
			return false;
		}
	};
	
	boolean filter(EObject source, EObject target, EReference type);
}
