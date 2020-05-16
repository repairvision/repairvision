package org.sidiff.revision.difference.api;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferenceFactory;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.difference.api.settings.MatchingSettings;
import org.sidiff.revision.difference.derivation.ITechnicalDifferenceBuilder;
import org.sidiff.revision.difference.matcher.IMatcher;
import org.sidiff.revision.difference.util.DifferenceUtil;

/**
 * Convenient access to differencing functions.
 */
public class TechnicalDifferenceFacade {

	public static String DIFFERENCE_FILE_EXTENSION = DifferenceUtil.FILE_EXTENSION;

	/**
	 * Calculates a matching between models and derives a technical
	 * {@link Difference} between two models.
	 * 
	 * @param difference The matching between the input models.
	 * @param settings   Specifies the settings of the difference algorithm.
	 * @return A technical {@link Difference} between the input models.
	 * 
	 * @see MatchingFacade#match(java.util.Collection,
	 *      org.sidiff.matching.api.settings.MatchingSettings)
	 */
	public static Difference difference(Resource modelA, Resource modelB, DifferenceSettings settings) {
		return deriveDifference(match(modelA, modelB, settings), settings);
	}
	
	/**
	 * Calculates a matching between models.That means a Correspondence for each
	 * preserved object between models.
	 * 
	 * @param modelA   The origin model.
	 * @param modelB   The modified model.
	 * @param settings Specifies the settings of the matching algorithm.
	 * @return A {@link Matching} between the given models
	 */
	public static Difference match(Resource modelA, Resource modelB, MatchingSettings settings) {
		IMatcher matcher = settings.getMatcher();

		Difference difference = DifferenceFactory.eINSTANCE.createDifference();
		matcher.startMatching(difference, modelA, modelB, settings.getScope());

		return difference;
	}

	/**
	 * Derives a technical {@link Difference} between two models.
	 * 
	 * @param difference The matching between the input models.
	 * @param settings   Specifies the settings of the difference algorithm.
	 * @return A technical {@link Difference} between the input models.
	 * 
	 * @see MatchingFacade#match(java.util.Collection,
	 *      org.sidiff.matching.api.settings.MatchingSettings)
	 */
	public static Difference deriveDifference(Difference difference, DifferenceSettings settings) {
		ITechnicalDifferenceBuilder tdBuilder = settings.getTechBuilder();
		tdBuilder.deriveTechDiff(difference, settings.getScope());
		return difference;
	}

}
