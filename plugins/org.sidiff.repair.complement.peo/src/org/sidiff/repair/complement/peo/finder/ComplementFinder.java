package org.sidiff.repair.complement.peo.finder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.consistency.common.monitor.LogMonitor;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.consistency.common.monitor.LogUtil;
import org.sidiff.editrule.recognition.IRecognitionEngineMatcher;
import org.sidiff.editrule.recognition.RecognitionEngine;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.scope.RepairScope;
import org.sidiff.editrule.recognition.util.debug.DebugUtil;
import org.sidiff.graphpattern.matcher.IMatching;
import org.sidiff.graphpattern.util.GraphPatternConstants;
import org.sidiff.repair.api.util.RepairAPIUtil;
import org.sidiff.repair.complement.construction.ComplementRule;
import org.sidiff.repair.complement.matching.RecognitionMatch;

public class ComplementFinder {
	
	private ComplementFinderEngine engine;
	
	private Rule editRule;
	
	private RepairScope scope;
	
	private IProgressMonitor monitor;
	
	private LogTable runtimeLog;
	
	private RecognitionPattern recognitionPattern;
	
	private IRecognitionEngineMatcher recognitionMatcher;
	
	public ComplementFinder(ComplementFinderEngine engine, Rule editRule, RepairScope scope, IProgressMonitor monitor, LogTable runtimeLog) {
		this.engine = engine;
		this.editRule = editRule;
		this.scope = scope;
		this.monitor = monitor;
		this.runtimeLog = runtimeLog;
	}

	/**
	 * @return All complementing operations for the given edit-rule.
	 */
	public List<ComplementRule> findComplementRules() {
		
		//// Lifting ////
		
		RecognitionEngine recognitionEngine = engine.getRecognitionEngine();

		// Create recognition rule:
		recognitionPattern = recognitionEngine.createRecognitionPattern(editRule);
		DebugUtil.printEditRule(editRule);
		
		// Save recognition-rule:
		if (engine.isSaveRecognitionRule()) {
			ChangePatternUtil.saveGraphPattern(RepairAPIUtil.getRecognitionRuleURI(
					editRule.eResource().getURI(), GraphPatternConstants.FILE_EXTENSION),
					recognitionPattern.getGraphPattern());
		}
		
		// Matching:
		LogTime recognitionTimer = new LogTime();
		
		recognitionMatcher = recognitionEngine.createMatcher(recognitionPattern, scope, runtimeLog);
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
	
	public RecognitionPattern getRecognitionPattern() {
		return recognitionPattern;
	}
	
	public IRecognitionEngineMatcher getRecognitionMatcher() {
		return recognitionMatcher;
	}
}
