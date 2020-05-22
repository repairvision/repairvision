package org.sidiff.revision.editrules.recognition;

import java.util.List;

import org.sidiff.revision.editrules.recognition.match.RecognitionMatching;

/**
 * Recognition of partially applied edit rules.
 * 
 * @author Manuel Ohrndorf
 */
public interface IRecognitionEngine {
	
	/**
	 * @return The changes of the edit rule that were recognized in the difference.
	 */
	List<RecognitionMatching> recognizeEditRule();
}
