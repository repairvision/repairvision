package org.sidiff.editrule.recognition;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.scope.RepairScope;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.history.revision.IRevision;

public interface IRecognitionEngine {

	void initialize(IRevision revision);
	
	void start();

	void finish();

	RecognitionPattern createRecognitionPattern(Rule editRule);

	RecognitionPattern createRecognitionPattern(Rule editRule, GraphPattern graphPattern);
	
	IRecognitionEngineMatcher createMatcher(RecognitionPattern recognitionPattern, RepairScope scope, LogTable runtimeLog);

	IRecognitionEngineMatcher createMatcher(RecognitionPattern recognitionPattern);
}