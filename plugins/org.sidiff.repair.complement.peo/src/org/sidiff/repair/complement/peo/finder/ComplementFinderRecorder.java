package org.sidiff.repair.complement.peo.finder;

import org.sidiff.editrule.recognition.RecognitionEngineRecorder;
import org.sidiff.graphpattern.util.GraphPatternConstants;
import org.sidiff.graphpattern.util.GraphPatternUtil;
import org.sidiff.repair.api.util.RepairAPIUtil;
import org.sidiff.repair.complement.peo.finder.util.IRecognitionPatternSerializer;

public class ComplementFinderRecorder extends RecognitionEngineRecorder {
	
	private ComplementFinder complementFinder;
	
	/**
	 * Writes the recognition rule to the location of the edit rule (e.g. debugging).
	 */
	private boolean saveRecognitionRule;
	
	public ComplementFinderRecorder(ComplementFinder complementFinder) {
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
