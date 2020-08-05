package org.sidiff.revision.difference.api.util;

import java.io.File;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.common.emf.EMFStorage;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;

public class DifferenceUtil {

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

	private static String extractModelName(String filename) {
		String fName = new File(filename).getName();
		return fName.substring(0, fName.lastIndexOf('.'));
	}
}
