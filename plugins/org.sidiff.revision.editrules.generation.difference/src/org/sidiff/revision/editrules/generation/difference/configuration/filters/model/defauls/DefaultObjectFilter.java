package org.sidiff.revision.editrules.generation.difference.configuration.filters.model.defauls;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.DefaultFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.FilterConfiguration;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IObjectFilter;

public class DefaultObjectFilter extends DefaultFilter implements IObjectFilter {

	public DefaultObjectFilter(FilterConfiguration filters) {
		super(filters);
	}

	@Override
	public boolean filter(EObject object) {
		return false;
	}

}
