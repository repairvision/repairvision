package org.sidiff.repair.ui.peo.debugger.model;

import java.util.List;

import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;

public interface IRecognitionEngine {
	
	List<IRecognitionEngineEvent> getAvailableEvents();
	
	void addEventListener(IReconitionEngineEventListener listener);
	
	void removeEventListener(IReconitionEngineEventListener listener);
	
	List<IRecognitionEngineVariableTag> getAvailableVariableTags();

	List<NodePattern> getAllVariables();
	
	List<NodePattern> getTaggedVariables(IRecognitionEngineVariableTag tag);
	
	String getEditRuleName();
	
	List<NodePattern> getEditRuleNodes();
	
	List<EdgePattern> getEditRuleEdges();
	
	List<EdgePattern> getCurrentMatchingPath();
	
	boolean isRecordingMatching();
	
	void setRecordingMatching(boolean recording);
	
	List<List<EdgePattern>> getMatchingPaths();
}
