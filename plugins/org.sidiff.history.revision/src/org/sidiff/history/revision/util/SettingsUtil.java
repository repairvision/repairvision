package org.sidiff.history.revision.util;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.utilities.emf.Scope;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.generic.matcher.uuid.UUIDMatcher;
import org.sidiff.revision.difference.derivation.api.settings.DifferenceSettings;
import org.sidiff.revision.difference.derivation.util.TechnicalDifferenceBuilderUtil;

public class SettingsUtil {

	public static DifferenceSettings getDefaultDifferenceSettings() {
		DifferenceSettings settings = new DifferenceSettings();
		settings.setScope(Scope.RESOURCE_SET);
		
		settings.setCorrespondencesService(new MatchingModelCorrespondences() {
			
			// Do not throw an exception on elements.length > 2 - just pick some elements...
			public void addCorrespondence(EObject... elements) {
				if (elements.length >= 2) {
					addCorrespondence(elements[0], elements[1]);
				}
			}
		});
		
		settings.setMatcher(new UUIDMatcher());
		settings.setTechBuilder(TechnicalDifferenceBuilderUtil.getGenericTechnicalDifferenceBuilder());
		
		return settings;
	}
	
}
