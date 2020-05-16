package org.sidiff.revision.difference.api;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferenceFactory;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.difference.api.settings.MatchingSettings;
import org.sidiff.revision.difference.builder.IDifferenceBuilderProvider;
import org.sidiff.revision.difference.matcher.IMatcherProvider;
import org.sidiff.revision.difference.util.DifferenceUtil;

/**
 * Convenient access to differencing functions.
 */
public class DifferenceFacade {

	public static String DIFFERENCE_FILE_EXTENSION = DifferenceUtil.FILE_EXTENSION;

	/**
	 * @param modelA The origin model.
	 * @param modelB The modified model.
	 * @return A empty difference.
	 */
	public static Difference create(Resource modelA, Resource modelB) {
		Difference difference = DifferenceFactory.eINSTANCE.createDifference();
		difference.setModelA(modelA);
		difference.setModelB(modelB);
		return difference;
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
		IMatcherProvider matcherProvider = settings.getMatcher();
	
		Difference difference = create(modelA, modelB);
		matcherProvider.createMatcher().startMatching(difference, modelA, modelB, settings.getScope());
	
		return difference;
	}

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
		IDifferenceBuilderProvider tdBuilder = settings.getTechBuilder();
		tdBuilder.createDifferenceBuilder().deriveTechDiff(difference, settings.getScope());
		return difference;
	}

}
