package org.sidiff.revision.difference.derivation.api.util;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.utilities.emf.EMFStorage;
import org.sidiff.revision.difference.derivation.ITechnicalDifferenceBuilder;
import org.sidiff.revision.difference.derivation.api.settings.DifferenceSettings;
import org.sidiff.revision.difference.derivation.util.TechnicalDifferenceBuilderUtil;

/**
 * Utility functions which are made publicly available to any clients using the
 * SiLift framework. UI components of the SiLift IDE should, if required, also
 * use these utility functions, and not the internal functions of the respective
 * engines.
 * 
 * @author kehrer, mohrndorf, cpietsch
 */
public class TechnicalDifferenceUtils extends MatchingUtils{
	
	/**
	 * Find all available technical difference builders matching the given
	 * document types.
	 * 
	 * @param documentTypes
	 *            The document types, i.e. the package namespace URI of a model. There can be more than one.
	 * @return All available technical difference builders matching the given
	 *         document types.
	 * @see #getAvailableTechnicalDifferenceBuilders(String)
	 */
	public static List<ITechnicalDifferenceBuilder> getAvailableTechnicalDifferenceBuilders(Set<String> documentTypes) {
		return TechnicalDifferenceBuilderUtil.getAvailableTechnicalDifferenceBuilders(documentTypes);
	}
	
	/**
	 * Find all available technical difference builders matching the document types of the given models.
	 * 
	 * @param documentTypes
	 *            The document types, i.e. the package namespace URI of a model. There can be more than one.
	 * @return All available technical difference builders matching the given
	 *         document types.
	 * @see #getAvailableTechnicalDifferenceBuilders(String)
	 */
	public static List<ITechnicalDifferenceBuilder> getAvailableTechnicalDifferenceBuilders(Resource modelA, Resource modelB) {
		return TechnicalDifferenceBuilderUtil.getAvailableTechnicalDifferenceBuilders(modelA, modelB);
	}
	
	public static ITechnicalDifferenceBuilder getGenericTechnicalDifferenceBuilder() {
		return TechnicalDifferenceBuilderUtil.getGenericTechnicalDifferenceBuilder();
	}

	/**
	 * 
	 * Returns the default technical difference builder for the given
	 * documentTypes: <br/>
	 * In case of Ecore: take first non-generics diff builder. <br/>
	 * Otherwise: take first technical difference builder
	 * 
	 * @param documentTypes
	 * @return
	 */
	public static ITechnicalDifferenceBuilder getDefaultTechnicalDifferenceBuilder(Set<String> documentTypes) {
		return TechnicalDifferenceBuilderUtil.getDefaultTechnicalDifferenceBuilder(documentTypes);
	}

	/**
	 * Returns the technical difference builder with the given key.
	 * 
	 * @param name
	 * @return
	 */
	public static ITechnicalDifferenceBuilder getTechnicalDifferenceBuilder(String key){
		return TechnicalDifferenceBuilderUtil.getTechnicalDifferenceBuilder(key);
	}
	
	public static String extractCommonPath(String... paths) {
		String result = null;
		for (String path : paths) {
			File file = new File(path);
			assert (file.isFile()) : "Not a File!" + path;

			if (result == null) {
				result = file.getParent();
			}

			assert (result.equals(file.getParent())) : "Different Paths! " + result + " vs. " + file.getParent();
		}
		return result + "/";
	}

	/**
	 * Generates a file name for a new difference between model A and model B.
	 * 
	 * @param modelA
	 *            The earlier version of the model.
	 * @param modelB
	 *            The later version of the model.
	 * @param settings
	 *            Specifies the settings of the semantic lifting algorithm.
	 * @return A file name MODELAxMODELB_MATCHINGENGINE_LIFTING_POSTPROCESSING.
	 */
	public static String generateDifferenceFileName(Resource modelA, Resource modelB, DifferenceSettings settings) {
		String fileName = extractModelName(EMFStorage.uriToPath(modelA.getURI())) + "_x_"
				+ extractModelName(EMFStorage.uriToPath(modelB.getURI()));

		if (settings.getMatcher() != null) {
			fileName += "_" + settings.getMatcher().getKey();
		}

		fileName += "_technical";

		return fileName;
	}


	/**
	 * Cut of the file extension.
	 * 
	 * @param filename
	 *            The file name with extension.
	 * @return The file name without extension.
	 */
	protected static String extractModelName(String filename) {
		String fName = new File(filename).getName();
		return fName.substring(0, fName.lastIndexOf('.'));
	}
}
