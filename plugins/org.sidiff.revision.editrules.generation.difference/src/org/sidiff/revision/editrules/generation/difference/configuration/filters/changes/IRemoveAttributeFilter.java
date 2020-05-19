package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public interface IRemoveAttributeFilter {

	public static final IRemoveAttributeFilter FILTER_NONE = new IRemoveAttributeFilter() {
		
		@Override
		public boolean filter(EObject obj, EAttribute type) {
			return false;
		}
	};
	
	public static final IRemoveAttributeFilter FILTER_ALL = new IRemoveAttributeFilter() {
		
		@Override
		public boolean filter(EObject obj, EAttribute type) {
			return true;
		}
	};
	
	boolean filter(EObject obj, EAttribute type);
}
