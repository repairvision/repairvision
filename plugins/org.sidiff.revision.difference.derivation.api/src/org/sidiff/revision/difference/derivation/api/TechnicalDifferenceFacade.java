package org.sidiff.revision.difference.derivation.api;

import java.util.Arrays;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricFactory;
import org.sidiff.matching.api.MatchingFacade;
import org.sidiff.matching.model.Matching;
import org.sidiff.revision.difference.derivation.ITechnicalDifferenceBuilder;
import org.sidiff.revision.difference.derivation.api.settings.DifferenceSettings;

/**
 * Convenient access to differencing functions.
 */
public class TechnicalDifferenceFacade extends MatchingFacade {

	public static String SYMMETRIC_DIFF_EXT = "symmetric";
	
	/**
	 * Derives a technical {@link SymmetricDifference} based on a given
	 * {@link Matching} between two models.
	 * 
	 * @param matching
	 *            The matching between the input models.
	 * @param settings
	 *            Specifies the settings of the difference algorithm.
	 * @return A technical {@link SymmetricDifference} between the input models.
	 * 
	 * @see MatchingFacade#match(java.util.Collection, org.sidiff.matching.api.settings.MatchingSettings)
	 */
	public static SymmetricDifference deriveTechnicalDifference(Matching matching, DifferenceSettings settings) {
		SymmetricDifference symmetricDifference = SymmetricFactory.eINSTANCE.createSymmetricDifference();
		symmetricDifference.setMatching(matching);
		
		// Derive technical difference
		ITechnicalDifferenceBuilder tdBuilder = settings.getTechBuilder();
		tdBuilder.deriveTechDiff(symmetricDifference, settings.getScope());
		
		return symmetricDifference;
	}
	
	/**
	 * Derives a technical {@link SymmetricDifference} between two models.
	 * Although, a symmetric difference is usually undirected the underlying
	 * difference model of SiLift implies a direction.
	 * 
	 * @param modelA
	 *            The origin model.
	 * @param modelB
	 *            The modified model.
	 * @param settings
	 *            Specifies the settings of the difference algorithm.
	 * @return A technical {@link SymmetricDifference} between the input models.
	 * @throws InvalidModelException
	 * @throws NoCorrespondencesException 
	 */
	public static SymmetricDifference deriveTechnicalDifference(Resource modelA, Resource modelB, DifferenceSettings settings) throws InvalidModelException, NoCorrespondencesException{
		return deriveTechnicalDifference(match(Arrays.asList(modelA, modelB), settings), settings);
	}
	
	/**
	 * Serializes a technical {@link SymmetricDifference}.
	 * 
	 * @param symDiff
	 *            The difference to be serialized.
	 * @param path
	 *            The serialization path.
	 * @param fileName
	 *            The file name of the difference.
	 */
	public static void serializeTechnicalDifference(SymmetricDifference symDiff, String path, String fileName) {
		if (!(path.endsWith("/") || path.endsWith("\\"))) {
			path = path + "/";
		}

		if (!(fileName.endsWith("." + SYMMETRIC_DIFF_EXT))) {
			fileName = fileName + "." + SYMMETRIC_DIFF_EXT;
		}

		EMFStorage.eSaveAs(EMFStorage.pathToUri(path + fileName), symDiff);
	}
	
	/**
	 * Load a technical {@link SymmetricDifference}.
	 * 
	 * @param path
	 *            The path to the symmetric difference.
	 * @return The loaded technical {@link SymmetricDifference}.
	 */
	public static SymmetricDifference loadTechnicalDifference(String path) {
		return (SymmetricDifference)EMFStorage.eLoad(EMFStorage.pathToUri(path));
	}
}
