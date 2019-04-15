package org.sidiff.matching.api;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.EMFValidate;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matching.api.settings.MatchingSettings;
import org.sidiff.matching.model.Matching;

/**
 * Convenient access to matching functions.
 */
public class MatchingFacade {

	/**
	 * Matching model file extension.
	 */
	public static String MATCHING_MODEL_EXT = "matching";
	
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
	public static Matching match(Collection<Resource> models, MatchingSettings settings) throws NoCorrespondencesException, InvalidModelException {
		
		LogUtil.log(LogEvent.NOTICE, "Settings:\n" + settings.toString());
		LogUtil.log(LogEvent.NOTICE, "Input models: " + getModelsToString(models));
		
		// Validate models
		if (settings.isValidate()) {
			for(Resource model : models){
				EMFValidate.validateModel(model);
			}
		}

		// Create matching
		IMatcher matcher = settings.getMatcher();	

		LogUtil.log(LogEvent.NOTICE, "Start matching ...");
		matcher.startMatching(models, settings.getScope());	
		LogUtil.log(LogEvent.NOTICE, "[finished]");
		
		// Get Matching
		// In SiLift we assume support of @see{MatchingModelCorrespondences}
		ICorrespondences correspondences = matcher.getCorrespondencesService();
		Matching matching = ((MatchingModelCorrespondences)correspondences).getMatching();	
	
		if (matching.getCorrespondences().size() == 0) {
			throw new NoCorrespondencesException();
		}
		
		LogUtil.log(LogEvent.NOTICE, "Matched elements: " + matching.getCorrespondences().size());
		
		return matching;
	}
	
	/**
	 * Serializes a matching.
	 * 
	 * @param matching
	 *            The matching to be serialized.
	 * @param path
	 *            The serialization path.
	 * @param fileName
	 *            The file name of the matching.
	 */
	public void serializeMatching(Matching matching, String path, String fileName) {
		if (!(path.endsWith("/") || path.endsWith("\\"))) {
			path = path + "/";
		}
		
		if (!(fileName.endsWith("." + MATCHING_MODEL_EXT))) {
			fileName = fileName + "." + MATCHING_MODEL_EXT;
		}

		EMFStorage.eSaveAs(EMFStorage.pathToUri(path + fileName), matching);
	}
	
	/**
	 * Load a {@link Matching}
	 * @param path
	 * 			The path to the matching file
	 * @return The loaded {@link Matching}
	 */
	public static Matching loadMatching(String path){
		return (Matching)EMFStorage.eLoad(EMFStorage.pathToUri(path));
	}
	
	/**
	 * 
	 * @param models
	 * @return
	 */
	private static String getModelsToString(Collection<Resource> models){
		StringBuffer buffer = new StringBuffer();
		for (Iterator<Resource> iterator = models.iterator(); iterator.hasNext();) {
			Resource resource =  iterator.next();
			buffer.append(resource.getURI().lastSegment());
			if(iterator.hasNext()){
				buffer.append(", ");
			}
		}
		return buffer.toString();
	}
}
