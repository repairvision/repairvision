package org.sidiff.revision.editrules.complement.matching.finder;

import org.sidiff.revision.editrules.recognition.impl.RecognitionEngine;
import org.sidiff.revision.editrules.recognition.impl.RecognitionEngineRecorder;

public class ComplementFinderRecorder extends RecognitionEngineRecorder {
	
	private ComplementFinder complementFinder;
	
	public ComplementFinderRecorder(ComplementFinder complementFinder) {
		super((RecognitionEngine) complementFinder.recognitionMatcher);
		this.complementFinder = complementFinder;
	}
	
	public ComplementFinder getComplementFinder() {
		return complementFinder;
	}
}
