package org.sidiff.editrule.partialmatcher;

import java.util.Iterator;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.editrule.partialmatcher.scope.RepairScope;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.matcher.IMatching;

public interface IRecognitionEngine {

	void initialize(SymmetricDifference difference);
	
	void start();

	void finish();

	RecognitionPattern createRecognitionPattern(Rule editRule);

	RecognitionPattern createRecognitionPattern(Rule editRule, GraphPattern graphPattern);
	
	Iterator<IMatching> recognizePartialEditRule(
			RecognitionPattern recognitionPattern, RepairScope scope, LogTable runtimeLog);

	Iterator<IMatching> recognizePartialEditRule(RecognitionPattern recognitionPattern);
}