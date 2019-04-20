package org.sidiff.repair.complement.peo.finder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.editrule.recognition.IMatching;
import org.sidiff.editrule.recognition.RecognitionEngine;
import org.sidiff.editrule.recognition.RecognitionEngineMatcher;
import org.sidiff.editrule.recognition.impact.ImpactScope;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.util.debug.DebugUtil;
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.matching.RecognitionMatch;
import org.sidiff.repair.complement.peo.configuration.ComplementFinderSettings;
import org.sidiff.repair.complement.peo.finder.util.IRecognitionPatternSerializer;

public class ComplementFinder {
	
	protected ComplementFinderEngine engine;
	
	protected Rule editRule;
	
	protected ComplementFinderSettings settings;
	
	protected RecognitionEngineMatcher recognitionMatcher;
	
	protected RecognitionPattern recognitionPattern;
	
	protected IRecognitionPatternSerializer recognitionPatternSerializer;
		
	public ComplementFinder(ComplementFinderEngine engine, Rule editRule,
			ImpactScope resolvingScope, ImpactScope overwriteScope,
			ImpactScope introducingScope, ComplementFinderSettings settings) {
		
		this.engine = engine;
		this.editRule = editRule;
		this.settings = settings;
		
		// Create recognition rule:
		RecognitionEngine recognitionEngine = engine.getRecognitionEngine();
		this.recognitionPattern = recognitionEngine.createRecognitionPattern(editRule);
		this.recognitionMatcher = recognitionEngine.createMatcher(
				recognitionPattern, resolvingScope, overwriteScope, introducingScope,
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
		
		Iterator<IMatching> matchIterator = recognitionMatcher.recognizeEditRule();
		
		recognitionTimer.stop();
		DebugUtil.printRecognitionTime(recognitionTimer);
		
		// Report:
		if (settings.getMonitor().isLogging()) {
			settings.getMonitor().logRecognitionTime(recognitionTimer);
		}

		//// Complement Construction ////

		List<ComplementRule> complements = new ArrayList<>(); 

		// Find partially executed edit-operations:
		while(matchIterator.hasNext()) {
			IMatching matching = matchIterator.next();
			DebugUtil.printMatching(recognitionPattern, matching);
			
			// Translate: Create partial edit-rule match from recognition-rule match:
			List<RecognitionMatch> recognitionMatch = engine.getMatchConverter().createEditRuleMatch(recognitionPattern, matching);
			List<Change> recognizedChangeSet = engine.getMatchConverter().getChangeSet(recognitionPattern, matching);
			
			// Store new complement rule:
			if (!recognitionMatch.isEmpty()) {
				ComplementRule complementRule = engine.getComplementConstructor().createComplementRule(editRule, recognitionMatch, recognizedChangeSet);
				
				if (complementRule != null) {
					complements.add(complementRule);
				}
			}
		}
		
		return complements;
	}
}
