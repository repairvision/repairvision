package org.sidiff.revision.editrules.recognition.match;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.difference.symmetric.Change;

public class RecognitionMatching extends ArrayList<RecognitionMatch> {

	private static final long serialVersionUID = 1L;

	private List<Change> changeSet;
	
	public RecognitionMatching(List<Change> changeSet) {
		this.changeSet = changeSet;
	}

	public List<Change> getChangeSet() {
		return changeSet;
	}
}
