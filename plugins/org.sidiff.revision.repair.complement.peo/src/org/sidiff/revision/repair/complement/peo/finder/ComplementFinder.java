package org.sidiff.revision.repair.complement.peo.finder;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.revision.editrules.recognition.RecognitionEngine;
import org.sidiff.revision.editrules.recognition.RecognitionEngineMatcher;
import org.sidiff.revision.editrules.recognition.impact.ImpactScope;
import org.sidiff.revision.editrules.recognition.match.RecognitionMatching;
import org.sidiff.revision.repair.complement.construction.ComplementRule;
import org.sidiff.revision.repair.complement.peo.configuration.ComplementFinderSettings;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public class ComplementFinder {
	
	protected ComplementFinderEngine engine;
	
	protected Rule editRule;
	
	protected ComplementFinderSettings settings;
	
	protected RecognitionEngineMatcher recognitionMatcher;
	
	public ComplementFinder(ComplementFinderEngine engine, Rule editRule, ImpactAnalyzes impact,
			ImpactScope resolvingScope, ImpactScope overwriteScope, ImpactScope introducingScope,
			ComplementFinderSettings settings) {
		
		this.engine = engine;
		this.editRule = editRule;
		this.settings = settings;
		
		// Create recognition rule:
		RecognitionEngine recognitionEngine = engine.getRecognitionEngine();
		
		this.recognitionMatcher = recognitionEngine.createMatcher(
				editRule,
				impact,
				resolvingScope, 
				overwriteScope, 
				introducingScope,
				settings.getRecognitionEngineSettings());
	}

	/**
	 * @return All complementing operations for the given edit-rule.
	 */
	public List<ComplementRule> findComplementRules() {
		
		//// Lifting ////
		
		// Matching:
		LogTime recognitionTimer = new LogTime();
		
		List<RecognitionMatching> recognitionMatchings = recognitionMatcher.recognizeEditRule();
		
		recognitionTimer.stop();
		
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
