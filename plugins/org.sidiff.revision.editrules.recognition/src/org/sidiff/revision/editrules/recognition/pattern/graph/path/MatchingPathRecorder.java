package org.sidiff.revision.editrules.recognition.pattern.graph.path;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.sidiff.revision.editrules.recognition.pattern.graph.ActionNode;

public class MatchingPathRecorder extends MatchingPath {

	private static final long serialVersionUID = 1L;
	
	private LinkedList<List<ActionNode>> recording = new LinkedList<>();
	
	private boolean backtracking = false;
	
	public MatchingPathRecorder() {
		recording.add(new ArrayList<>());
	}

	@Override
	public boolean add(ActionNode node) {
		backtracking = false;
		recording.getLast().add(node);
		
		return super.add(node);
	}
	
	@Override
	public boolean remove(Object node) {
		
		if (!backtracking) {
			List<ActionNode> nextPath = new ArrayList<>(recording.getLast());
			recording.add(nextPath);
		}
		
		recording.getLast().remove(node);
		backtracking = true;
		
		return super.remove(node);
	}
	
	public LinkedList<List<ActionNode>> getRecording() {
		return recording;
	}
	
	public void clearRecording() {
		recording = new LinkedList<>();
	}
}
