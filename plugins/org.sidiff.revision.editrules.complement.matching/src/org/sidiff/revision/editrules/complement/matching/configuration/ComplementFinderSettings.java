package org.sidiff.revision.editrules.complement.matching.configuration;

import org.sidiff.revision.editrules.recognition.configuration.RecognitionSettings;

public class ComplementFinderSettings {

	private ComplementFinderLogger logger = new ComplementFinderLogger();
	
	private RecognitionSettings recognitionSettings = new RecognitionSettings();
	
	public ComplementFinderLogger getLogger() {
		return logger;
	}
	
	public void setMonitor(ComplementFinderLogger monitor) {
		this.logger = monitor;
	}
	
	public RecognitionSettings getRecognitionEngineSettings() {
		return recognitionSettings;
	}
	
	public void setRecognitionEngineSettings(RecognitionSettings recognitionSettings) {
		this.recognitionSettings = recognitionSettings;
	}
}
