package org.sidiff.repair.complement.peo.finder;

import org.sidiff.editrule.recognition.RecognitionEngineRecorder;

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
