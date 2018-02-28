package org.sidiff.editrule.partialmatcher.engine;

import java.util.Iterator;
import java.util.List;

import org.sidiff.editrule.partialmatcher.RecognitionEngine;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.IMatching;
import org.sidiff.graphpattern.matcher.IPatternMatchingEngine;

public class PatternMatchingEngine implements IPatternMatchingEngine<IMatching> {

	protected RecognitionEngine editRuleRecognizer;
	
	protected RecognitionPattern recognitionPattern;
	
	public PatternMatchingEngine(
			RecognitionEngine editRuleRecognizer, 
			RecognitionPattern recognitionPattern) {
		this.editRuleRecognizer = editRuleRecognizer;
		this.recognitionPattern = recognitionPattern;
	}
	
	@Override
	public Iterator<IMatching> getResults() {
		return editRuleRecognizer.createMatcher(recognitionPattern).recognizeEditRule();
	}

	@Override
	public void start() {
		editRuleRecognizer.start();
	}

	@Override
	public void finish() {
		editRuleRecognizer.finish();
	}

	@Override
	public List<NodePattern> getGraphPattern() {
		return recognitionPattern.getGraphNodePatterns();
	}

	@Override
	public List<NodePattern> getVariableNodes() {
		return recognitionPattern.getChangeNodePatterns();
	}
}
