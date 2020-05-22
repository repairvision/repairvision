package org.sidiff.revision.editrules.recognition;

import org.sidiff.revision.editrules.recognition.configuration.RecognitionSettings;

/**
 * Recognition of partially applied edit rules.
 * 
 * @author Manuel Ohrndorf
 */
public interface IRecognitionEngineProvider {

	/**
	 * @param settings The information about the edit rule and model history.
	 * @return A new initialized matching engine.
	 */
	IRecognitionEngine createMatcher(RecognitionSettings settings);

}