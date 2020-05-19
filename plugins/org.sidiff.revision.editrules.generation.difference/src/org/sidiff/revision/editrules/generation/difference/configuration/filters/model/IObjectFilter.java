package org.sidiff.revision.editrules.generation.difference.configuration.filters.model;

import org.eclipse.emf.ecore.EObject;

public interface IObjectFilter {

	public static final IObjectFilter FILTER_NONE = new IObjectFilter() {

		@Override
		public boolean filter(EObject object) {
			return false;
		}
	};
	
	public static final IObjectFilter FILTER_ALL = new IObjectFilter() {

		@Override
		public boolean filter(EObject object) {
			return true;
		}
	};
	
	boolean filter(EObject object);
}
