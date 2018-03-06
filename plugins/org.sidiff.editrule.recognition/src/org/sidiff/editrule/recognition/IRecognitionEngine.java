package org.sidiff.editrule.recognition;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.scope.RepairScope;
import org.sidiff.graphpattern.GraphPattern;

public interface IRecognitionEngine {

	void initialize(SymmetricDifference difference);
	
	void start();

	void finish();

	RecognitionPattern createRecognitionPattern(Rule editRule);

	RecognitionPattern createRecognitionPattern(Rule editRule, GraphPattern graphPattern);
	
	IRecognitionEngineMatcher createMatcher(RecognitionPattern recognitionPattern, RepairScope scope, LogTable runtimeLog);

	IRecognitionEngineMatcher createMatcher(RecognitionPattern recognitionPattern);
}