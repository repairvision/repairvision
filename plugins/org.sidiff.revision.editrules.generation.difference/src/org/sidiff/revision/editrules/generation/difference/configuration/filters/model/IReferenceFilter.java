package org.sidiff.revision.editrules.generation.difference.configuration.filters.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public interface IReferenceFilter {

	public static final IReferenceFilter FILTER_NONE = new IReferenceFilter() {
		
		@Override
		public boolean filter(EObject source, EReference type, EObject target) {
			return false;
		}
	};
	
	public static final IReferenceFilter FILTER_ALL = new IReferenceFilter() {
		
		@Override
		public boolean filter(EObject source, EReference type, EObject target) {
			return true;
		}
	};
	
	boolean filter(EObject source, EReference type, EObject target);
}
