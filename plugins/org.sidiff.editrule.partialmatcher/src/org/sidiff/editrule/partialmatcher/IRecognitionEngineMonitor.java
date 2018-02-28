package org.sidiff.editrule.partialmatcher;

import java.util.List;

import org.sidiff.editrule.partialmatcher.pattern.graph.ActionNode;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePattern;

public interface IRecognitionEngineMonitor {

	interface IChangeTag {
		String getName();
	}
	
	List<IChangeTag> getAvailableChangeTags();
	
	List<ChangePattern> getTaggedChanges(IChangeTag tag);

	boolean isMatchingPathRecording();

	void setMatchingPathRecording(boolean matchingPathRecording);

	List<List<ActionNode>> getMatchingPathRecording();
}
