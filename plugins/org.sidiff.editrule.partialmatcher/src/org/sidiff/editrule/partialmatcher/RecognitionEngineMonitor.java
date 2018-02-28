package org.sidiff.editrule.partialmatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.sidiff.editrule.partialmatcher.generator.Variable;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionNode;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePattern;
import org.sidiff.graphpattern.NodePattern;

public class RecognitionEngineMonitor implements IRecognitionEngineMonitor {

	private RecognitionEngineMatcher matcher;
	
	public RecognitionEngineMonitor(RecognitionEngineMatcher matcher) {
		this.matcher = matcher;
	}

	private IChangeTag remaining = new IChangeTag() {
		public String getName() {
			return "Remaining";
		}
	};
	
	private IChangeTag removed = new IChangeTag() {
		public String getName() {
			return "Removed";
		}
	};
	
	private IChangeTag depending = new IChangeTag() {
		public String getName() {
			return "Depending";
		}
	};
	
	private IChangeTag sub = new IChangeTag() {
		public String getName() {
			return "Picked";
		}
	};
	
	@Override
	public List<IChangeTag> getAvailableChangeTags() {
		return Arrays.asList(new IChangeTag[] {remaining, removed, depending, sub});
	}

	@Override
	public List<ChangePattern> getTaggedChanges(IChangeTag tag) {
		List<ChangePattern> changes = new ArrayList<>();
		Iterator<Variable> variableSet = null;
		
		if (tag == remaining) {
			variableSet = matcher.getMatchGenerator().getRemainingVariables();
		}
		
		else if (tag == removed) {
			variableSet = matcher.getMatchGenerator().getRemovedVariables();
		}
		
		else if (tag == depending) {
			variableSet = matcher.getMatchGenerator().getDependingVariables();
		}
		
		else if (tag == sub) {
			variableSet = matcher.getMatchGenerator().getSubVariables();
		}
		
		Map<NodePattern, ChangePattern> changePattern = matcher.getRecognitionPattern().getChangePatternTrace();
		variableSet.forEachRemaining(variable -> changes.add(changePattern.get(variable.node)));

		return changes;
	}
	
	@Override
	public boolean isMatchingPathRecording() {
		return matcher.getMatchSelector().isRecording();
	}
	
	@Override
	public void setMatchingPathRecording(boolean matchingPathRecording) {
		matcher.getMatchSelector().setRecording(true);
	}
	
	@Override
	public List<List<ActionNode>> getMatchingPathRecording() {
		return matcher.getMatchSelector().getRecording();
	}
}
