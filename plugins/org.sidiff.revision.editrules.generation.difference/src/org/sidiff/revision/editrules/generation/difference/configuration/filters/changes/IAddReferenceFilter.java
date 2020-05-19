package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes;

import org.sidiff.revision.difference.AddReference;

public interface IAddReferenceFilter {

	public static final IAddReferenceFilter FILTER_NONE = new IAddReferenceFilter() {
		
		@Override
		public boolean filter(AddReference change) {
			return false;
		}
	};
	
	public static final IAddReferenceFilter FILTER_ALL = new IAddReferenceFilter() {
		
		@Override
		public boolean filter(AddReference change) {
			return true;
		}
	};
	
	boolean filter(AddReference change);
}
