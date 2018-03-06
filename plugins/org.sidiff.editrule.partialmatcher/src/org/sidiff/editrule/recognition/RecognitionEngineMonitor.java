package org.sidiff.editrule.recognition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.sidiff.editrule.recognition.generator.Variable;
import org.sidiff.editrule.recognition.pattern.graph.ActionNode;
import org.sidiff.editrule.recognition.pattern.graph.ChangePattern;
import org.sidiff.editrule.recognition.selection.MatchSelectorMonitor;
import org.sidiff.graphpattern.NodePattern;

public class RecognitionEngineMonitor {

	public interface IChangeTag {
		String getName();
	}
	
	private RecognitionEngineMatcher matcher;
	
	private MatchSelectorMonitor matchSelectorMonitor;
	
	public RecognitionEngineMonitor(RecognitionEngineMatcher matcher) {
		this.matcher = matcher;
		this.matchSelectorMonitor = new MatchSelectorMonitor(matcher.matchSelector);
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
	
	public List<IChangeTag> getAvailableChangeTags() {
		return Arrays.asList(new IChangeTag[] {remaining, removed, depending, sub});
	}

	public List<ChangePattern> getTaggedChanges(IChangeTag tag) {
		List<ChangePattern> changes = new ArrayList<>();
		Iterator<Variable> variableSet = null;
		
		if (tag == remaining) {
			variableSet = matcher.matchGenerator.getRemainingVariables();
		}
		
		else if (tag == removed) {
			variableSet = matcher.matchGenerator.getRemovedVariables();
		}
		
		else if (tag == depending) {
			variableSet = matcher.matchGenerator.getDependingVariables();
		}
		
		else if (tag == sub) {
			variableSet = matcher.matchGenerator.getSubVariables();
		}
		
		Map<NodePattern, ChangePattern> changePattern = matcher.recognitionPattern.getChangePatternTrace();
		variableSet.forEachRemaining(variable -> changes.add(changePattern.get(variable.node)));

		return changes;
	}
	
	public boolean isMatchingPathRecording() {
		return matchSelectorMonitor.isRecording();
	}
	
	public void setMatchingPathRecording(boolean matchingPathRecording) {
		matchSelectorMonitor.setRecording(true);
	}
	
	public List<List<ActionNode>> getMatchingPathRecording() {
		return matchSelectorMonitor.getPathRecording().getRecording();
	}
}
