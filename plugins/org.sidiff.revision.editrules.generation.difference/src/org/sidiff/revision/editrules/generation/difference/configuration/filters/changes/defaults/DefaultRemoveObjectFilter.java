package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults;

import static org.sidiff.revision.common.utilities.java.JUtil.notNull;

import java.util.logging.Level;

import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.editrules.generation.difference.Activator;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.DefaultFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.FilterConfiguration;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.IRemoveObjectFilter;

public class DefaultRemoveObjectFilter extends DefaultFilter implements IRemoveObjectFilter {

	public DefaultRemoveObjectFilter(FilterConfiguration filters) {
		super(filters);
	}

	@Override
	public boolean filter(RemoveObject change) {
		if (notNull(change.getObj())) {
			if (!getFilters().getObjectFilter().filter(change.getObj())) {
				return false;
			}
		} else {
			if (Activator.getLog().isLoggable(Level.INFO)) {
				Activator.getLog().log(Level.INFO, "Filtered Remove-Object: " + change);
			}
		}
		return true;
	}
}
