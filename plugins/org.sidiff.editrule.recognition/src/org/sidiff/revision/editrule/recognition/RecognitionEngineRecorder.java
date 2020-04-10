package org.sidiff.revision.editrule.recognition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.util.GraphPatternConstants;
import org.sidiff.graphpattern.util.GraphPatternUtil;
import org.sidiff.revision.editrule.recognition.pattern.graph.ActionNode;
import org.sidiff.revision.editrule.recognition.pattern.graph.ChangePattern;
import org.sidiff.revision.editrule.recognition.selection.MatchSelectorMonitor;
import org.sidiff.revision.editrule.recognition.solver.Variable;
import org.sidiff.revision.editrule.recognition.util.debug.IRecognitionPatternSerializer;

public class RecognitionEngineRecorder {

	public interface IChangeTag {
		String getName();
	}
	
	private RecognitionEngineMatcher recognitionEngineMatcher;
	
	private MatchSelectorMonitor matchSelectorMonitor;
	
	/**
	 * Writes the recognition rule to the location of the edit rule (e.g. debugging).
	 */
	private boolean saveRecognitionRule;
	
	public RecognitionEngineRecorder(RecognitionEngineMatcher recognitionEngineMatcher) {
		this.recognitionEngineMatcher = recognitionEngineMatcher;
		this.matchSelectorMonitor = new MatchSelectorMonitor(recognitionEngineMatcher.matchSelector);
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
			variableSet = recognitionEngineMatcher.matchGenerator.getRemainingVariables();
		}
		
		else if (tag == removed) {
			variableSet = recognitionEngineMatcher.matchGenerator.getRemovedVariables();
		}
		
		else if (tag == depending) {
			variableSet = recognitionEngineMatcher.matchGenerator.getDependingVariables();
		}
		
		else if (tag == sub) {
			variableSet = recognitionEngineMatcher.matchGenerator.getSubVariables();
		}
		
		Map<NodePattern, ChangePattern> changePattern = recognitionEngineMatcher.recognitionPattern.getChangePatternTrace();
		variableSet.forEachRemaining(variable -> changes.add(changePattern.get(variable.node)));

		return changes;
	}
	
	public RecognitionEngineMatcher getRecognitionEngineMatcher() {
		return recognitionEngineMatcher;
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
	
	public boolean isSaveRecognitionRule() {
		return saveRecognitionRule;
	}

	public void setSaveRecognitionRule(boolean saveRecognitionRule) {
		this.saveRecognitionRule = saveRecognitionRule;
		
		if (saveRecognitionRule) {
			recognitionEngineMatcher.recognitionPatternSerializer = new IRecognitionPatternSerializer() {
				public void saveRecognitionRule() {
					GraphPatternUtil.saveGraphPattern(getRecognitionRuleURI(
							recognitionEngineMatcher.recognitionPattern.getEditRule().eResource().getURI(), GraphPatternConstants.FILE_EXTENSION),
							recognitionEngineMatcher.recognitionPattern.getGraphPattern());
				}
			};
		} else {
			recognitionEngineMatcher.recognitionPatternSerializer = new IRecognitionPatternSerializer() {
				public void saveRecognitionRule() {}
			};
		}
	}
	
	protected URI getRecognitionRuleURI(URI editRule, String fileExtension) {
		return editRule.trimSegments(1).appendSegment("rr_" + editRule.lastSegment())
				.trimFileExtension().appendFileExtension(fileExtension);
	}
}
