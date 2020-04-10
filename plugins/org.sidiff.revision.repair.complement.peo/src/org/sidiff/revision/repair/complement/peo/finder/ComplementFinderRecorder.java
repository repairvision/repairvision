package org.sidiff.revision.repair.complement.peo.finder;

import org.sidiff.revision.editrules.recognition.RecognitionEngineRecorder;

public class ComplementFinderRecorder extends RecognitionEngineRecorder {
	
	private ComplementFinder complementFinder;
	
	public ComplementFinderRecorder(ComplementFinder complementFinder) {
		super(complementFinder.recognitionMatcher);
		this.complementFinder = complementFinder;
	}
	
	public ComplementFinder getComplementFinder() {
		return complementFinder;
	}
}
