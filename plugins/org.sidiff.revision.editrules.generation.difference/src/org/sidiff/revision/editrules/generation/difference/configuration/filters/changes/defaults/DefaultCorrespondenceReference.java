package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults;

import static org.sidiff.revision.common.utilities.java.JUtil.notNull;

import java.util.logging.Level;

import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.editrules.generation.difference.Activator;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.DefaultFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.FilterConfiguration;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.ICorrespondenceReferenceFilter;

public class DefaultCorrespondenceReference extends DefaultFilter implements ICorrespondenceReferenceFilter {

	public DefaultCorrespondenceReference(FilterConfiguration filters) {
		super(filters);
	}

	@Override
	public boolean filter(Correspondence source, EReference type, Correspondence target) {
		if (notNull(source.getMatchedA(), source.getMatchedB(), type, target.getMatchedA(), target.getMatchedB())) {
			if (!getFilters().getCorrespondenceObjectFilter().filter(source)) {
				if (!getFilters().getCorrespondenceObjectFilter().filter(target)) {
					if (!getFilters().getReferenceFilter().filter(source.getMatchedA(), type, target.getMatchedA())) {
						if (!getFilters().getReferenceFilter().filter(source.getMatchedB(), type, target.getMatchedB())) {
							return false;
						}
					}
				}
			}
		}  else {
			if (Activator.getLog().isLoggable(Level.INFO)) {
				Activator.getLog().log(Level.INFO, "Filtered Correspondence Reference: " + source + " Type: " + type + " Target: "+ target);
			}
		}
		return true;
	}
}
