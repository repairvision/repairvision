package org.sidiff.revision.difference.derivation.api;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.utilities.emf.EMFStorage;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.matcher.IMatcher;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.derivation.ITechnicalDifferenceBuilder;
import org.sidiff.revision.difference.derivation.api.settings.DifferenceSettings;
import org.sidiff.revision.difference.derivation.api.settings.MatchingSettings;
import org.sidiff.revision.difference.util.DifferenceUtil;

/**
 * Convenient access to differencing functions.
 */
public class TechnicalDifferenceFacade {

	public static String DIFFERENCE_FILE_EXTENSION = DifferenceUtil.FILE_EXTENSION;
	
	/**
	 * Computes a {@link Matching} between the given models.
	 * 
	 * @param models
	 *            The models to be matched.
	 * @param settings
	 *            Specifies the settings of the matching algorithm.
	 * @return A {@link Matching} between the given models
	 * @throws NoCorrespondencesException
	 * @throws InvalidModelException
	 */
	public static Difference match(Collection<Resource> models, MatchingSettings settings) {
		IMatcher matcher = settings.getMatcher();	
		matcher.startMatching(models, settings.getScope());	
		
		ICorrespondences correspondences = matcher.getCorrespondencesService();
		Difference difference = ((MatchingModelCorrespondences)correspondences).getDifference();	
		
		return difference;
	}
	
	/**
	 * Derives a technical {@link Difference} based on a given
	 * {@link Matching} between two models.
	 * 
	 * @param difference
	 *            The matching between the input models.
	 * @param settings
	 *            Specifies the settings of the difference algorithm.
	 * @return A technical {@link Difference} between the input models.
	 * 
	 * @see MatchingFacade#match(java.util.Collection, org.sidiff.matching.api.settings.MatchingSettings)
	 */
	public static Difference deriveTechnicalDifference(Difference difference, DifferenceSettings settings) {
		ITechnicalDifferenceBuilder tdBuilder = settings.getTechBuilder();
		tdBuilder.deriveTechDiff(difference, settings.getScope());
		return difference;
	}
	
	/**
	 * Derives a technical {@link Difference} between two models.
	 * Although, a symmetric difference is usually undirected the underlying
	 * difference model of SiLift implies a direction.
	 * 
	 * @param modelA
	 *            The origin model.
	 * @param modelB
	 *            The modified model.
	 * @param settings
	 *            Specifies the settings of the difference algorithm.
	 * @return A technical {@link Difference} between the input models.
	 * @throws InvalidModelException
	 * @throws NoCorrespondencesException 
	 */
	public static Difference deriveTechnicalDifference(Resource modelA, Resource modelB, DifferenceSettings settings) {
		return deriveTechnicalDifference(match(Arrays.asList(modelA, modelB), settings), settings);
	}
	
	/**
	 * Serializes a technical {@link Difference}.
	 * 
	 * @param symDiff
	 *            The difference to be serialized.
	 * @param path
	 *            The serialization path.
	 * @param fileName
	 *            The file name of the difference.
	 */
	public static void serializeTechnicalDifference(Difference symDiff, String path, String fileName) {
		if (!(path.endsWith("/") || path.endsWith("\\"))) {
			path = path + "/";
		}

		if (!(fileName.endsWith("." + DIFFERENCE_FILE_EXTENSION))) {
			fileName = fileName + "." + DIFFERENCE_FILE_EXTENSION;
		}

		EMFStorage.eSaveAs(EMFStorage.pathToUri(path + fileName), symDiff);
	}
	
	/**
	 * Load a technical {@link Difference}.
	 * 
	 * @param path
	 *            The path to the symmetric difference.
	 * @return The loaded technical {@link Difference}.
	 */
	public static Difference loadTechnicalDifference(String path) {
		return (Difference)EMFStorage.eLoad(EMFStorage.pathToUri(path));
	}
}
