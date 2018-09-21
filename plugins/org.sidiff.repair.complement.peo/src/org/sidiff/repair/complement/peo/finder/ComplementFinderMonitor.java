package org.sidiff.repair.complement.peo.finder;

import org.sidiff.editrule.recognition.RecognitionEngineMonitor;
import org.sidiff.graphpattern.util.GraphPatternConstants;
import org.sidiff.graphpattern.util.GraphPatternUtil;
import org.sidiff.repair.api.util.RepairAPIUtil;
import org.sidiff.repair.complement.peo.finder.util.IRecognitionPatternSerializer;

public class ComplementFinderMonitor extends RecognitionEngineMonitor {
	
	private ComplementFinder complementFinder;
	
	/**
	 * Writes the recognition rule to the location of the edit rule (e.g. debugging).
	 */
	private boolean saveRecognitionRule;
	
	public ComplementFinderMonitor(ComplementFinder complementFinder) {
		super(complementFinder.recognitionMatcher);
		this.complementFinder = complementFinder;
	}
	
	public boolean isSaveRecognitionRule() {
		return saveRecognitionRule;
	}

	public void setSaveRecognitionRule(boolean saveRecognitionRule) {
		this.saveRecognitionRule = saveRecognitionRule;
		
		if (saveRecognitionRule) {
			complementFinder.recognitionPatternSerializer = new IRecognitionPatternSerializer() {
				public void saveRecognitionRule() {
					GraphPatternUtil.saveGraphPattern(RepairAPIUtil.getRecognitionRuleURI(
							complementFinder.editRule.eResource().getURI(), GraphPatternConstants.FILE_EXTENSION),
							complementFinder.recognitionPattern.getGraphPattern());
				}
			};
		} else {
			complementFinder.recognitionPatternSerializer = new IRecognitionPatternSerializer() {
				public void saveRecognitionRule() {}
			};
		}
	}
}
