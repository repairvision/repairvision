package org.sidiff.revision.editrules.generation.difference.configuration.filters.model.defauls;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.DefaultFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.FilterConfiguration;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IReferenceFilter;

public class DefaultReferenceFilter extends DefaultFilter implements IReferenceFilter {

	public DefaultReferenceFilter(FilterConfiguration filters) {
		super(filters);
	}

	@Override
	public boolean filter(EObject source, EReference type, EObject target) {
		
		if (!getFilters().getObjectFilter().filter(source)) {
			if (!getFilters().getObjectFilter().filter(target)) {
				return false;
			}
		}
		
		return true;
	}
}
