package org.sidiff.repair.complement.peo.finder;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.editrule.recognition.RecognitionEngine;
import org.sidiff.editrule.recognition.RecognitionEngineMatcher;
import org.sidiff.editrule.recognition.impact.ImpactScope;
import org.sidiff.editrule.recognition.match.RecognitionMatching;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.util.debug.DebugUtil;
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.peo.configuration.ComplementFinderSettings;
import org.sidiff.repair.complement.peo.finder.util.IRecognitionPatternSerializer;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public class ComplementFinder {
	
	protected ComplementFinderEngine engine;
	
	protected Rule editRule;
	
	protected ComplementFinderSettings settings;
	
	protected RecognitionEngineMatcher recognitionMatcher;
	
	protected RecognitionPattern recognitionPattern;
	
	protected IRecognitionPatternSerializer recognitionPatternSerializer;
		
	public ComplementFinder(ComplementFinderEngine engine, Rule editRule, ImpactAnalyzes impact,
			ImpactScope resolvingScope, ImpactScope overwriteScope, ImpactScope introducingScope,
			ComplementFinderSettings settings) {
		
		this.engine = engine;
		this.editRule = editRule;
		this.settings = settings;
		
		// Create recognition rule:
		RecognitionEngine recognitionEngine = engine.getRecognitionEngine();
		this.recognitionPattern = recognitionEngine.createRecognitionPattern(editRule);
		this.recognitionMatcher = recognitionEngine.createMatcher(
				recognitionPattern,
				impact,
				resolvingScope, 
				overwriteScope, 
				introducingScope,
				settings.getRecognitionEngineSettings());
		
		this.recognitionPatternSerializer = new IRecognitionPatternSerializer() {
			public void saveRecognitionRule() {}
		};
	}

	/**
	 * @return All complementing operations for the given edit-rule.
	 */
	public List<ComplementRule> findComplementRules() {
		DebugUtil.printEditRule(editRule);
		
		//// Lifting ////
		
		// Save recognition-rule:
		recognitionPatternSerializer.saveRecognitionRule();
		
		// Matching:
		LogTime recognitionTimer = new LogTime();
		
		List<RecognitionMatching> recognitionMatchings = recognitionMatcher.recognizeEditRule();
		
		recognitionTimer.stop();
		DebugUtil.printRecognitionTime(recognitionTimer);
		
		// Report:
		if (settings.getMonitor().isLogging()) {
			settings.getMonitor().logRecognitionTime(recognitionTimer);
		}

		//// Complement Construction ////

		List<ComplementRule> complements = new ArrayList<>(); 

		// Find partially executed edit-operations:
		for (RecognitionMatching recognitionMatch : recognitionMatchings) {
			
			// Store new complement rule:
			if (!recognitionMatch.isEmpty()) {
				ComplementRule complementRule = engine.getComplementConstructor().createComplementRule(editRule, recognitionMatch);
				
				if (complementRule != null) {
					complements.add(complementRule);
				}
			}
		}
		
		return complements;
	}
}
