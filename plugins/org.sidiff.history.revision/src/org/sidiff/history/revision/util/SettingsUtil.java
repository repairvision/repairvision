package org.sidiff.history.revision.util;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.difference.technical.util.TechnicalDifferenceBuilderUtil;
import org.sidiff.history.revision.uuid.UUIDMatcher;

public class SettingsUtil {

	public static DifferenceSettings getDefaultDifferenceSettings() {
		DifferenceSettings settings = new DifferenceSettings();
		
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
		settings.setMergeImports(false);
		
		return settings;
	}
	
}
