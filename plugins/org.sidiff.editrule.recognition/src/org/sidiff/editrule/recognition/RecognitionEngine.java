package org.sidiff.editrule.recognition;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.designpatterns.IAlgorithm;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.recognition.dependencies.ChangeDependencies;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.scope.RepairScope;
import org.sidiff.editrule.recognition.util.IndexedCrossReferencer;
import org.sidiff.editrule.recognition.util.LiftingGraphDomainMap;
import org.sidiff.editrule.recognition.util.LiftingGraphIndex;
import org.sidiff.editrule.recognition.util.MatchingHelper;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;

/**
 * @author Manuel Ohrndorf
 */
public class RecognitionEngine implements IAlgorithm, IRecognitionEngine {
	
	// -enableDebugUtil
	// -DLOGCHANNEL="ConsoleLogChannel" -DLOGEVENTS="*"
	
	protected boolean started = false;

	protected SymmetricDifference difference;
	
//	protected MergeImports mergeImports;

	protected LiftingGraphIndex changeIndex;
	
	protected LiftingGraphDomainMap changeDomainMap;
	
	protected MatchingHelper matchingHelper;
	
	@Override
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
	
	@Override
	public RecognitionPattern createRecognitionPattern(Rule editRule) {
		return createRecognitionPattern(editRule, GraphpatternFactory.eINSTANCE.createGraphPattern());
	}
	
	@Override
	public RecognitionPattern createRecognitionPattern(Rule editRule, GraphPattern graphPattern) {
		
		// Create Constraint-Satisfaction-Problem:
		RecognitionPattern recognitionPattern = new RecognitionPattern(editRule, graphPattern);
		
		// Create dependency graph:
		// TODO: Support for additional EOpposites per meta-model!
		new ChangeDependencies(editRule, recognitionPattern).calculateDependencyGraph();
		
		return recognitionPattern;
	}
	
	@Override
	public RecognitionEngineMatcher createMatcher(RecognitionPattern recognitionPattern, RepairScope scope, LogTable runtimeLog) {
		
		if (!started) {
			throw new RuntimeException("Call PartialEditRuleRecognizer start()!");
		}
		
		// Initialize change domains:
		recognitionPattern.initialize(matchingHelper, changeIndex, changeDomainMap);
//		System.out.println("Initial Domains: \n\n" + StringUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
		
		// Create matcher:
		return new RecognitionEngineMatcher(recognitionPattern, scope, runtimeLog);
	}

	@Override
	public RecognitionEngineMatcher createMatcher(RecognitionPattern recognitionPattern) {
		
		if (!started) {
			throw new RuntimeException("Call PartialEditRuleRecognizer start()!");
		}
		
		// Initialize change domains:
		recognitionPattern.initialize(matchingHelper, changeIndex, changeDomainMap);
//		System.out.println("Initial Domains: \n\n" + StringUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
		
		// Create matcher:
		return new RecognitionEngineMatcher(this, recognitionPattern);
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
