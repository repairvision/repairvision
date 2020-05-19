package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes;

import org.eclipse.emf.ecore.EAttribute;
import org.sidiff.revision.difference.Correspondence;

public interface ICorrespondenceAttributeFilter {

	public static final ICorrespondenceAttributeFilter FILTER_NONE = new ICorrespondenceAttributeFilter() {
		
		@Override
		public boolean filter(Correspondence container, EAttribute type) {
			return false;
		}
	};
	
	public static final ICorrespondenceAttributeFilter FILTER_ALL = new ICorrespondenceAttributeFilter() {
		
		@Override
		public boolean filter(Correspondence container, EAttribute type) {
			return true;
		}
	};
	
	boolean filter(Correspondence container, EAttribute type);
}
