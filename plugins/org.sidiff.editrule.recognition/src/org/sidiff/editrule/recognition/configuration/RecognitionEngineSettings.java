package org.sidiff.editrule.recognition.configuration;

public class RecognitionEngineSettings {
	
	private RecognitionEngineMonitor monitor = new RecognitionEngineMonitor();
	
	public RecognitionEngineMonitor getMonitor() {
		return monitor;
	}
	
	public void setMonitor(RecognitionEngineMonitor monitor) {
		this.monitor = monitor;
	}
}
