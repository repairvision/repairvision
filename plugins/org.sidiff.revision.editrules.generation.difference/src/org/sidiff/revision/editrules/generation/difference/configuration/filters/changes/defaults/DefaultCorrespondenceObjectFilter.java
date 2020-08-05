package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults;

import static org.sidiff.revision.common.utilities.java.JUtil.notNull;

import java.util.logging.Level;

import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.editrules.generation.difference.Activator;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.DefaultFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.FilterConfiguration;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.ICorrespondenceObjectFilter;

public class DefaultCorrespondenceObjectFilter extends DefaultFilter implements ICorrespondenceObjectFilter {

	public DefaultCorrespondenceObjectFilter(FilterConfiguration filters) {
		super(filters);
	}

	@Override
	public boolean filter(Correspondence correspondence) {
		if (notNull(correspondence.getMatchedA(), correspondence.getMatchedB())) {
			if (!getFilters().getObjectFilter().filter(correspondence.getMatchedA())) {
				if (!getFilters().getObjectFilter().filter(correspondence.getMatchedB())) {
					return false;
				}
			}
		}  else {
			if (Activator.getLog().isLoggable(Level.INFO)) {
				Activator.getLog().log(Level.INFO, "Filtered Correspondence Object: " + correspondence);
			}
		}
		return true;
	}
}
