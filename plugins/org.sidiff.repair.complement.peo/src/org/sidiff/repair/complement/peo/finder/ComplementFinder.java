package org.sidiff.repair.complement.peo.finder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogMonitor;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.consistency.common.monitor.LogUtil;
import org.sidiff.editrule.recognition.IMatching;
import org.sidiff.editrule.recognition.RecognitionEngine;
import org.sidiff.editrule.recognition.RecognitionEngineMatcher;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.scope.RepairScope;
import org.sidiff.editrule.recognition.util.debug.DebugUtil;
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.matching.RecognitionMatch;
import org.sidiff.repair.complement.peo.finder.util.IRecognitionPatternSerializer;

public class ComplementFinder {
	
	protected ComplementFinderEngine engine;
	
	protected Rule editRule;
	
	protected RepairScope scope;
	
	protected IProgressMonitor monitor;
	
	protected LogTable runtimeLog;
	
	protected RecognitionEngineMatcher recognitionMatcher;
	
	protected RecognitionPattern recognitionPattern;
	
	protected IRecognitionPatternSerializer recognitionPatternSerializer;
		
	public ComplementFinder(ComplementFinderEngine engine, Rule editRule, RepairScope scope, IProgressMonitor monitor, LogTable runtimeLog) {
		this.engine = engine;
		this.editRule = editRule;
		this.scope = scope;
		this.monitor = monitor;
		this.runtimeLog = runtimeLog;
		
		// Create recognition rule:
		RecognitionEngine recognitionEngine = engine.getRecognitionEngine();
		this.recognitionPattern = recognitionEngine.createRecognitionPattern(editRule);
		this.recognitionMatcher = recognitionEngine.createMatcher(recognitionPattern, scope, runtimeLog);
		
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
		if (monitor instanceof LogMonitor) {
			LogUtil.appendTime((LogMonitor) monitor, "[Time (ms)] Recognition Time", recognitionTimer);
		}

		//// Complement Construction ////

		List<ComplementRule> complements = new ArrayList<>(); 

		// Find partially executed edit-operations:
		while(matchIterator.hasNext()) {
			IMatching matching = matchIterator.next();
			DebugUtil.printMatching(recognitionPattern, matching);
			
			// Translate: Create partial edit-rule match from recognition-rule match:
			List<RecognitionMatch> recognitionMatch = engine.getMatchConverter().createEditRuleMatch(recognitionPattern, matching);
			
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
