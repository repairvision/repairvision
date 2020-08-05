package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults;

import static org.sidiff.revision.common.utilities.java.JUtil.notNull;

import java.util.logging.Level;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.editrules.generation.difference.Activator;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.DefaultFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.FilterConfiguration;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.IRemoveAttributeFilter;

public class DefaultRemoveAttributeFilter extends DefaultFilter implements IRemoveAttributeFilter {

	public DefaultRemoveAttributeFilter(FilterConfiguration filters) {
		super(filters);
	}

	@Override
	public boolean filter(EObject obj, EAttribute type) {
		if (notNull(obj, type)) {
			Object value = obj.eGet(type);
			
			if (!getFilters().getAttributeFilter().filter(obj, value, type)) {
				return false;
			}
		}  else {
			if (Activator.getLog().isLoggable(Level.INFO)) {
				Activator.getLog().log(Level.INFO, "Filtered Remove Attribute: " + obj + " Type: " + type);
			}
		}
		return true;
	}
}
