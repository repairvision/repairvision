package org.sidiff.revision.editrules.generation.difference.configuration.filters.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public interface IAttributeFilter {
	
	public static final IAttributeFilter FILTER_NONE = new IAttributeFilter() {
		
		@Override
		public boolean filter(EObject object, Object value, EAttribute type) {
			return false;
		}
	};
	
	public static final IAttributeFilter FILTER_ALL = new IAttributeFilter() {
		
		@Override
		public boolean filter(EObject object, Object value, EAttribute type) {
			return true;
		}
	};
	
	boolean filter(EObject object, Object value, EAttribute type);
}
