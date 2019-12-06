package org.sidiff.editrule.recognition;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.editrule.recognition.configuration.RecognitionEngineSettings;
import org.sidiff.editrule.recognition.impact.ImpactScope;
import org.sidiff.history.revision.IRevision;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public interface IRecognitionEngine {

	void initialize(IRevision revision);
	
	void start();

	void finish();
	
	IRecognitionEngineMatcher createMatcher(
			Rule editRule,
			ImpactAnalyzes impact,
			ImpactScope resolvingScope,
			ImpactScope overwriteScope,
			ImpactScope introducingScope,
			RecognitionEngineSettings settings);

	IRecognitionEngineMatcher createMatcher(
			Rule editRule);
}