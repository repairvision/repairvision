package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults;

import static org.sidiff.revision.common.utilities.java.JUtil.notNull;

import java.util.logging.Level;

import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.editrules.generation.difference.Activator;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.DefaultFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.FilterConfiguration;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.IAttributeValueChangeFilter;

public class DefaultAttributeValueChangeFilter extends DefaultFilter implements IAttributeValueChangeFilter {

	public DefaultAttributeValueChangeFilter(FilterConfiguration filters) {
		super(filters);
	}

	@Override
	public boolean filter(AttributeValueChange avc) {
		if (notNull(avc.getObjA(), avc.getObjB(), avc.getType())) {
			Object valueA = avc.getObjA().eGet(avc.getType());
			Object valueB = avc.getObjB().eGet(avc.getType());
			
			if (!getFilters().getAttributeFilter().filter(avc.getObjA(), valueA, avc.getType())) {
				if (!getFilters().getAttributeFilter().filter(avc.getObjB(), valueB, avc.getType())) {
					return false;
				}
			}
		}  else {
			if (Activator.getLog().isLoggable(Level.INFO)) {
				Activator.getLog().log(Level.INFO, "Filtered Attribute Value Change: " + avc);
			}
		}
		return true;
	}
}
