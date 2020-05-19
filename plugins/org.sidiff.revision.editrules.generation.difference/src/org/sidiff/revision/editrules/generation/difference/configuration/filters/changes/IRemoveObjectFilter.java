package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes;

import org.sidiff.revision.difference.RemoveObject;

public interface IRemoveObjectFilter {

	public static final IRemoveObjectFilter FILTER_NONE = new IRemoveObjectFilter() {
		
		@Override
		public boolean filter(RemoveObject change) {
			return false;
		}
	};
	
	public static final IRemoveObjectFilter FILTER_ALL = new IRemoveObjectFilter() {
		
		@Override
		public boolean filter(RemoveObject change) {
			return true;
		}
	};
	
	boolean filter(RemoveObject change);
}
