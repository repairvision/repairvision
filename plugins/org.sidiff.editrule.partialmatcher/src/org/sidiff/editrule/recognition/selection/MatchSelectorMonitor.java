package org.sidiff.editrule.recognition.selection;

import org.sidiff.editrule.recognition.pattern.graph.path.MatchingPath;
import org.sidiff.editrule.recognition.pattern.graph.path.MatchingPathFactory;
import org.sidiff.editrule.recognition.pattern.graph.path.MatchingPathRecorder;

public class MatchSelectorMonitor {

	private MatchSelector matchSelector;
	
	private boolean recording;
	
	private MatchingPathRecorder pathRecording;
	
	public MatchSelectorMonitor(MatchSelector matchSelector) {
		this.matchSelector = matchSelector;
	}
	
	public boolean isRecording() {
		return recording;
	}
	
	public void setRecording(boolean recording) {
		this.recording = recording;
		
		if (recording) {
			matchSelector.matchingPathFactory = new MatchingPathFactory() {
				public MatchingPath createMatchingPath() {
					pathRecording = new MatchingPathRecorder();
					return pathRecording;
				}
			};
		} else {
			matchSelector.matchingPathFactory = new MatchingPathFactory();
		}
	}
	
	public MatchingPathRecorder getPathRecording() {
		return pathRecording;
	}
}
