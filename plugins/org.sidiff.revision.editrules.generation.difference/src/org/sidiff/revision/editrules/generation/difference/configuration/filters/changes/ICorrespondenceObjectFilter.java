package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes;

import org.sidiff.revision.difference.Correspondence;

public interface ICorrespondenceObjectFilter {

	public static final ICorrespondenceObjectFilter FILTER_NONE = new ICorrespondenceObjectFilter() {
		
		@Override
		public boolean filter(Correspondence correspondence) {
			return false;
		}
	};
	
	public static final ICorrespondenceObjectFilter FILTER_ALL = new ICorrespondenceObjectFilter() {
		
		@Override
		public boolean filter(Correspondence correspondence) {
			return true;
		}
	};
	
	boolean filter(Correspondence correspondence);
}
