package org.sidiff.revision.editrules.generation.difference.configuration.filters.model.defauls;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.DefaultFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.FilterConfiguration;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IAttributeFilter;

public class DefaultAttributeFilter extends DefaultFilter implements IAttributeFilter {

	public DefaultAttributeFilter(FilterConfiguration filters) {
		super(filters);
	}

	@Override
	public boolean filter(EObject object, Object value, EAttribute type) {
		return getFilters().getObjectFilter().filter(object);
	}

}
