package org.sidiff.revision.editrules.complement.matching.finder;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.revision.common.logging.util.LogTime;
import org.sidiff.revision.editrules.recognition.IRecognitionEngineProvider;
import org.sidiff.revision.editrules.complement.construction.ComplementRule;
import org.sidiff.revision.editrules.complement.matching.configuration.ComplementFinderSettings;
import org.sidiff.revision.editrules.recognition.IRecognitionEngine;
import org.sidiff.revision.editrules.recognition.match.RecognitionMatching;

public class ComplementFinder {
	
	protected ComplementFinderEngine engine;
	
	protected ComplementFinderSettings settings;
	
	protected IRecognitionEngine recognitionMatcher;
	
	public ComplementFinder(ComplementFinderEngine engine, ComplementFinderSettings settings) {
		this.engine = engine;
		this.settings = settings;
		
		// Create recognition rule:
		IRecognitionEngineProvider recognitionEngineProvider = engine.getRecognitionEngine();
		this.recognitionMatcher = recognitionEngineProvider.createMatcher(settings.getRecognitionEngineSettings());
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
		if (settings.getLogger().isLogging()) {
			settings.getLogger().logRecognitionTime(recognitionTimer);
		}

		//// Complement Construction ////

		List<ComplementRule> complements = new ArrayList<>(); 
		Rule editRule = settings.getRecognitionEngineSettings().getEditRule();

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
