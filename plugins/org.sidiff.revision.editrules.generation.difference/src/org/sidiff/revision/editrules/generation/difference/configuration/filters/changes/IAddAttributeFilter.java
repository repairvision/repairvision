package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public interface IAddAttributeFilter {

	public static final IAddAttributeFilter FILTER_NONE = new IAddAttributeFilter() {
		
		@Override
		public boolean filter(EObject obj, EAttribute type) {
			return false;
		}
	};
	
	public static final IAddAttributeFilter FILTER_ALL = new IAddAttributeFilter() {
		
		@Override
		public boolean filter(EObject obj, EAttribute type) {
			return true;
		}
	};
	
	boolean filter(EObject obj, EAttribute type);

}
