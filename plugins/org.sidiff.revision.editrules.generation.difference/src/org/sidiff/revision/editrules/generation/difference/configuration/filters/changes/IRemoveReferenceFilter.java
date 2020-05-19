package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes;

import org.sidiff.revision.difference.RemoveReference;

public interface IRemoveReferenceFilter {

	public static final IRemoveReferenceFilter FILTER_NONE = new IRemoveReferenceFilter() {
		
		@Override
		public boolean filter(RemoveReference change) {
			return false;
		}
	};
	
	public static final IRemoveReferenceFilter FILTER_ALL = new IRemoveReferenceFilter() {
		
		@Override
		public boolean filter(RemoveReference change) {
			return true;
		}
	};
	
	boolean filter(RemoveReference change);
}
