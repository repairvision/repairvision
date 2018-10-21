package org.sidiff.editrule.recognition;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.designpatterns.IAlgorithm;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.recognition.configuration.RecognitionEngineSettings;
import org.sidiff.editrule.recognition.dependencies.ChangeDependencies;
import org.sidiff.editrule.recognition.impact.PositiveImpactScope;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.util.MatchingHelper;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.history.revision.IRevision;

/**
 * @author Manuel Ohrndorf
 */
public class RecognitionEngine implements IAlgorithm, IRecognitionEngine {
	
	// -enableDebugUtil
	// -DLOGCHANNEL="ConsoleLogChannel" -DLOGEVENTS="*"
	
	protected boolean started = false;

	protected SymmetricDifference difference;
	
//	protected MergeImports mergeImports;
	
	protected MatchingHelper matchingHelper;
	
	@Override
	public void initialize(IRevision revision) {
		matchingHelper = new MatchingHelper(revision);
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
	public RecognitionEngineMatcher createMatcher(
			RecognitionPattern recognitionPattern,
			PositiveImpactScope repairScope,
			PositiveImpactScope overwriteScope,
			RecognitionEngineSettings settings) {
		
		if (!started) {
			throw new RuntimeException("Call PartialEditRuleRecognizer start()!");
		}
		
		// Initialize change domains:
		recognitionPattern.initialize(matchingHelper);
//		System.out.println("Initial Domains: \n\n" + StringUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
		
		// Create matcher:
		return new RecognitionEngineMatcher(recognitionPattern, repairScope, overwriteScope, settings);
	}

	@Override
	public RecognitionEngineMatcher createMatcher(RecognitionPattern recognitionPattern) {
		
		if (!started) {
			throw new RuntimeException("Call PartialEditRuleRecognizer start()!");
		}
		
		// Initialize change domains:
		recognitionPattern.initialize(matchingHelper);
//		System.out.println("Initial Domains: \n\n" + StringUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
		
		// Create matcher:
		return new RecognitionEngineMatcher(this, recognitionPattern);
	}
	
	@Override
	public void start() {
		
//		// Merge external resources into the difference:
//		mergeImports = new MergeImports(difference, Scope.RESOURCE, true);
//		mergeImports.merge();
		
		started = true;
	}

	@Override
	public void finish() {
		
//		// Unmerge external resources into the difference:
//		mergeImports.unmerge();
//		started = false;
	}
}
