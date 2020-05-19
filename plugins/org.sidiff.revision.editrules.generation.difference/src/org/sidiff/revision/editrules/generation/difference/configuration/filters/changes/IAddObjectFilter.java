package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes;

import org.sidiff.revision.difference.AddObject;

public interface IAddObjectFilter {

	public static final IAddObjectFilter FILTER_NONE = new IAddObjectFilter() {
		
		@Override
		public boolean filter(AddObject change) {
			return false;
		}
	};
	
	public static final IAddObjectFilter FILTER_ALL = new IAddObjectFilter() {
		
		@Override
		public boolean filter(AddObject change) {
			return true;
		}
	};
	
	boolean filter(AddObject change);
}
