package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes;

import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.difference.Correspondence;

public interface ICorrespondenceReferenceFilter {

	public static final ICorrespondenceReferenceFilter FILTER_NONE = new ICorrespondenceReferenceFilter() {
		
		@Override
		public boolean filter(Correspondence source, EReference type, Correspondence target) {
			return false;
		}
	};
	
	public static final ICorrespondenceReferenceFilter FILTER_ALL = new ICorrespondenceReferenceFilter() {
		
		@Override
		public boolean filter(Correspondence source, EReference type, Correspondence target) {
			return true;
		}
	};
	
	boolean filter(Correspondence source, EReference type, Correspondence target);
}
