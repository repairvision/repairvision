package org.sidiff.repair.ui.peo.debugger.model;

import java.util.List;

import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;

public interface IRecognitionEngine {

	List<NodePattern> getPickedVariables();
	
	List<NodePattern> getRemainingVariables();
	
	List<NodePattern> getRestrictedVariables();
	
	List<NodePattern> getRemovedVariables();
	
	List<NodePattern> getEditRuleNodes();
	
	List<EdgePattern> getEditRuleEdges();
	
	List<EdgePattern> getCurrentMatchingPath();
	
	boolean isRecordingMatching();
	
	void setRecordingMatching();
	
	List<List<EdgePattern>> getMatchingPaths();
}
