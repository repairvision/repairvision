package org.sidiff.repair.complement.peo.configuration;

import org.sidiff.revision.editrule.recognition.configuration.RecognitionEngineSettings;

public class ComplementFinderSettings {

	private ComplementFinderMonitor monitor = new ComplementFinderMonitor();
	
	private RecognitionEngineSettings recognitionEngineSettings = new RecognitionEngineSettings();
	
	public ComplementFinderMonitor getMonitor() {
		return monitor;
	}
	
	public void setMonitor(ComplementFinderMonitor monitor) {
		this.monitor = monitor;
	}
	
	public RecognitionEngineSettings getRecognitionEngineSettings() {
		return recognitionEngineSettings;
	}
	
	public void setRecognitionEngineSettings(RecognitionEngineSettings recognitionEngineSettings) {
		this.recognitionEngineSettings = recognitionEngineSettings;
	}
}
