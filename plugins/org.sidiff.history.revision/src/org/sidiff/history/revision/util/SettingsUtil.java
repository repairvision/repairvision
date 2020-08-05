package org.sidiff.history.revision.util;

import org.sidiff.generic.matcher.uuid.UUIDMatcherProvider;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.api.registry.DifferenceBuilderRegistry;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;

public class SettingsUtil {

	public static DifferenceSettings getDefaultDifferenceSettings() {
		DifferenceSettings settings = new DifferenceSettings();
		settings.setScope(Scope.RESOURCE_SET);
		settings.setMatcher(new UUIDMatcherProvider());
		settings.setTechBuilder(DifferenceBuilderRegistry.getGenericTechnicalDifferenceBuilder());
		
		return settings;
	}
	
}
