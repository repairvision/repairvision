package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults;

import static org.sidiff.revision.common.utilities.java.JUtil.notNull;

import java.util.logging.Level;

import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.editrules.generation.difference.Activator;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.DefaultFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.FilterConfiguration;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.IRemoveReferenceFilter;

public class DefaultRemoveReferenceFilter extends DefaultFilter implements IRemoveReferenceFilter {

	public DefaultRemoveReferenceFilter(FilterConfiguration filters) {
		super(filters);
	}

	@Override
	public boolean filter(RemoveReference change) {
		if (notNull(change.getSrc(), change.getTgt(), change.getType())) {
			if (!DocumentType.isUnconsideredStructualFeature(change.getType())) {
				if (!getFilters().getReferenceFilter().filter(change.getSrc(), change.getType(), change.getTgt())) {
					return false;
				}
			}
		} else {
			if (Activator.getLog().isLoggable(Level.INFO)) {
				Activator.getLog().log(Level.INFO, "Filtered Remove-Reference: " + change);
			}
		}
		return true;
	}

}
