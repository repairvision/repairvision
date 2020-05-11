package org.sidiff.revision.editrules.recognition.selection;

import org.sidiff.revision.editrules.recognition.pattern.graph.path.MatchingPath;
import org.sidiff.revision.editrules.recognition.pattern.graph.path.MatchingPathFactory;
import org.sidiff.revision.editrules.recognition.pattern.graph.path.MatchingPathRecorder;

public class MatchSelectorMonitor {

	private IMatchSelector matchSelector;
	
	private boolean recording;
	
	private MatchingPathRecorder pathRecording;
	
	public MatchSelectorMonitor(IMatchSelector matchSelector) {
		this.matchSelector = matchSelector;
	}
	
	public boolean isRecording() {
		return recording;
	}
	
	public void setRecording(boolean recording) {
		this.recording = recording;
		
		if (recording) {
			matchSelector.setMatchingPathFactory(new MatchingPathFactory() {
				public MatchingPath createMatchingPath() {
					pathRecording = new MatchingPathRecorder();
					return pathRecording;
				}
			});
		} else {
			matchSelector.setMatchingPathFactory(new MatchingPathFactory());
		}
	}
	
	public MatchingPathRecorder getPathRecording() {
		return pathRecording;
	}
}
