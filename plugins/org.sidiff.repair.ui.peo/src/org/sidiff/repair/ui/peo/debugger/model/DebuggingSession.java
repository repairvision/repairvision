package org.sidiff.repair.ui.peo.debugger.model;

import java.util.ArrayList;
import java.util.List;

public class DebuggingSession {
	
	private IRecognitionEngine recognitionEngine;

	private List<DebuggingSnapshotItem> snapshots = new ArrayList<>();
	
	public DebuggingSession(IRecognitionEngine recognitionEngine) {
		this.recognitionEngine = recognitionEngine;
	}
	
	public void createSnapshot() {
		// TODO
	}
	
	public List<DebuggingSnapshotItem> getSnapshots() {
		return snapshots;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (DebuggingSnapshotItem snapshot : snapshots) {
			string.append("\n");
			string.append(snapshot.toString());
		}
		
		return string.toString();
	}
}
