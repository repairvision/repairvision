package org.sidiff.editrule.partialmatcher.selection;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionNode;
import org.sidiff.graphpattern.NodePattern;

public interface IMatchSelector {

	void initialSelection(NodePattern selectedNode, EObject selectedMatch);
	
	void selection(NodePattern selectedNode, EObject selectedMatch);
	
	void undoSelection(NodePattern unselectedNode);
	
	boolean isRecording();
	
	void setRecording(boolean recording);
	
	List<List<ActionNode>> getRecording();
}