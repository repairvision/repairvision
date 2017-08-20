package org.sidiff.editrule.partialmatcher;

import java.util.Iterator;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.partialmatcher.dependencies.ChangeDependencies;
import org.sidiff.editrule.partialmatcher.dependencies.DependencyEvaluation;
import org.sidiff.editrule.partialmatcher.generator.PartialMatchGenerator;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPatternGenerator;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPatternInitializer;
import org.sidiff.editrule.partialmatcher.pattern.domain.Domain;
import org.sidiff.editrule.partialmatcher.scope.RepairScope;
import org.sidiff.editrule.partialmatcher.scope.RepairScopeConstraint;
import org.sidiff.editrule.partialmatcher.selection.IMatchSelector;
import org.sidiff.editrule.partialmatcher.selection.MatchSelector;
import org.sidiff.editrule.partialmatcher.util.IndexedCrossReferencer;
import org.sidiff.editrule.partialmatcher.util.LiftingGraphDomainMap;
import org.sidiff.editrule.partialmatcher.util.LiftingGraphIndex;
import org.sidiff.editrule.partialmatcher.util.MatchingHelper;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.common.algorithms.IAlgorithm;
import org.sidiff.graphpattern.matcher.IMatching;

/**
 * @author Manuel Ohrndorf
 */
public class PartialEditRuleRecognizer implements IAlgorithm {
	
	// -enableDebugUtil
	// -DLOGCHANNEL="ConsoleLogChannel" -DLOGEVENTS="*"
	
	protected boolean started = false;

	protected SymmetricDifference difference;
	
//	protected MergeImports mergeImports;

	protected LiftingGraphIndex changeIndex;
	
	protected LiftingGraphDomainMap changeDomainMap;
	
	protected MatchingHelper matchingHelper;
	
	public void initialize(SymmetricDifference difference) {
		this.difference = difference;
		
		// Lifting graph optimizations:
		changeDomainMap = new LiftingGraphDomainMap(difference);
		changeIndex = new LiftingGraphIndex(difference);
		
		// Create matching helper:
		IndexedCrossReferencer crossReferencer = new IndexedCrossReferencer();
		crossReferencer.addResource(difference.getModelA());
		crossReferencer.addResource(difference.getModelB());
		
		matchingHelper = new MatchingHelper(crossReferencer);
	}
	
	public RecognitionPattern createRecognitionPattern(Rule editRule) {
		return createRecognitionPattern(editRule, GraphpatternFactory.eINSTANCE.createGraphPattern());
	}
	
	public RecognitionPattern createRecognitionPattern(Rule editRule, GraphPattern graphPattern) {
		
		// Create Constraint-Satisfaction-Problem:
		RecognitionPattern recognitionPattern = RecognitionPatternGenerator
				.createRecognitionPattern(editRule, graphPattern, matchingHelper, changeIndex);
		
		// Create dependency graph:
		// TODO: Support for additional EOpposites per meta-model!
		new ChangeDependencies(editRule, recognitionPattern).calculateDependencyGraph();
		
		return recognitionPattern;
	}
	
	public Iterator<IMatching> recognizePartialEditRule(RecognitionPattern recognitionPattern, RepairScope scope, LogTable runtimeLog) {
		
		if (!started) {
			throw new RuntimeException("Call PartialEditRuleRecognizer start()!");
		}
		
		// Initialize change domains:
		RecognitionPatternInitializer.initializeRecognitionPattern(recognitionPattern, changeDomainMap, matchingHelper);
//		System.out.println("Initial Domains: \n\n" + StringUtil.printSelections(recognitionPattern.getChangeNodePatterns()));

		// Log domain size:
		int domainSize = 0;
		
		for (NodePattern changeNode : recognitionPattern.getChangeNodePatterns()) {
			domainSize += Domain.get(changeNode).getMatchSize();
		}
		
		runtimeLog.append("Change Count (Sum)", domainSize);
		runtimeLog.append("Change Node Count", recognitionPattern.getChangeNodePatterns().size());
		
		// Create Scope-Constraint:
		RepairScopeConstraint repairScopeConstraint = new RepairScopeConstraint(scope, recognitionPattern);
		
		// Create matcher:
		PartialMatchGenerator matchGenerator = new PartialMatchGenerator();
		IMatchSelector matchSelector = new MatchSelector(recognitionPattern);
		
		DependencyEvaluation dependencies = new DependencyEvaluation(recognitionPattern.getGraphPattern());
		matchGenerator.initialize(recognitionPattern.getChangeNodePatterns(), dependencies, matchSelector);
		matchGenerator.setScope(repairScopeConstraint);
		
		LogTime matchingTimer = new LogTime();
		matchGenerator.start();
		matchingTimer.stop();
		
		// Report matching:
		runtimeLog.append("[Time (ms)] Matching Time", matchingTimer);
		
		return matchGenerator.getResults();
	}

	public Iterator<IMatching> recognizePartialEditRule(RecognitionPattern recognitionPattern) {
		
		if (!started) {
			throw new RuntimeException("Call PartialEditRuleRecognizer start()!");
		}
		
		// Initialize change domains:
		RecognitionPatternInitializer.initializeRecognitionPattern(recognitionPattern, changeDomainMap, matchingHelper);
//		System.out.println("Initial Domains: \n\n" + StringUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
		
		// Create matcher:
		PartialMatchGenerator matchGenerator = new PartialMatchGenerator();
		IMatchSelector matchSelector = new MatchSelector(recognitionPattern);
		
		DependencyEvaluation dependencies = new DependencyEvaluation(recognitionPattern.getGraphPattern());
		matchGenerator.initialize(recognitionPattern.getChangeNodePatterns(), dependencies, matchSelector);
		
		matchGenerator.start();
		return matchGenerator.getResults();
	}
	
	@Override
	public void start() {
		
//		// Merge external resources into the difference:
//		mergeImports = new MergeImports(difference, Scope.RESOURCE, true);
//		mergeImports.merge();
		
		// Initialize change/correspondence index:
		changeIndex.initialize();
		
		started = true;
	}

	@Override
	public void finish() {
		
//		// Unmerge external resources into the difference:
//		mergeImports.unmerge();
//		started = false;
	}
}
