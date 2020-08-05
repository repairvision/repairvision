package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults;

import static org.sidiff.revision.common.utilities.java.JUtil.notNull;

import java.util.logging.Level;

import org.eclipse.emf.ecore.EAttribute;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.editrules.generation.difference.Activator;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.DefaultFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.FilterConfiguration;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.ICorrespondenceAttributeFilter;

public class DefaultCorrespondenceAttributeFilter extends DefaultFilter implements ICorrespondenceAttributeFilter {

	public DefaultCorrespondenceAttributeFilter(FilterConfiguration filters) {
		super(filters);
	}

	@Override
	public boolean filter(Correspondence container, EAttribute type) {
		if (notNull(container.getMatchedA(), container.getMatchedB(), type)) {
			Object valueA = container.getMatchedA().eGet(type);
			Object valueB = container.getMatchedB().eGet(type);
			
			if (!getFilters().getCorrespondenceObjectFilter().filter(container)) {
				if (!getFilters().getAttributeFilter().filter(container.getMatchedA(), valueA, type)) {
					if (!getFilters().getAttributeFilter().filter(container.getMatchedB(), valueB, type)) {
						return false;
					}
				}
			}
		}  else {
			if (Activator.getLog().isLoggable(Level.INFO)) {
				Activator.getLog().log(Level.INFO, "Filtered Correspondence Attribute: " + container + " Type: " + type);
			}
		}
		return true;
	}
}
