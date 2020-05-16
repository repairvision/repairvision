package org.sidiff.history.revision.util;

import org.sidiff.common.utilities.emf.Scope;
import org.sidiff.generic.matcher.uuid.UUIDMatcherProvider;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.difference.derivation.util.TechnicalDifferenceBuilderUtil;

public class SettingsUtil {

	public static DifferenceSettings getDefaultDifferenceSettings() {
		DifferenceSettings settings = new DifferenceSettings();
		settings.setScope(Scope.RESOURCE_SET);
		settings.setMatcher(new UUIDMatcherProvider());
		settings.setTechBuilder(TechnicalDifferenceBuilderUtil.getGenericTechnicalDifferenceBuilder());
		
		return settings;
	}
	
}
