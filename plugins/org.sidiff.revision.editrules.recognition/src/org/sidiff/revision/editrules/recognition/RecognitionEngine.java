package org.sidiff.revision.editrules.recognition;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionEngineSettings;
import org.sidiff.revision.editrules.recognition.impact.ImpactScope;
import org.sidiff.revision.editrules.recognition.match.util.RecognitionMatchCreator;
import org.sidiff.revision.editrules.recognition.pattern.RecognitionPattern;
import org.sidiff.revision.editrules.recognition.revision.RevisionGraph;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

/**
 * @author Manuel Ohrndorf
 */
public class RecognitionEngine implements IRecognitionEngine {
	
	// -enableDebugUtil
	// -DLOGCHANNEL="ConsoleLogChannel" -DLOGEVENTS="*"
	
	protected boolean started = false;

	protected SymmetricDifference difference;
	
//	protected MergeImports mergeImports;
	
	protected RevisionGraph matchingHelper;
	
	@Override
	public void initialize(IRevision revision) {
		matchingHelper = new RevisionGraph(revision);
	}
	
	protected RecognitionPattern createRecognitionPattern(Rule editRule) {
		return createRecognitionPattern(editRule, GraphpatternFactory.eINSTANCE.createGraphPattern());
	}
	
	protected RecognitionPattern createRecognitionPattern(Rule editRule, GraphPattern graphPattern) {
		
		// Create Constraint-Satisfaction-Problem:
		RecognitionPattern recognitionPattern = new RecognitionPattern(editRule, graphPattern);
		
		return recognitionPattern;
	}
	
	@Override
	public RecognitionEngineMatcher createMatcher(
			Rule editRule,
			ImpactAnalyzes impact,
			ImpactScope resolvingScope,
			ImpactScope overwriteScope,
			ImpactScope introducingScope,
			RecognitionEngineSettings settings) {
		
		if (!started) {
			throw new RuntimeException("Call PartialEditRuleRecognizer start()!");
		}
		
		// Create recognition pattern:
		RecognitionPattern recognitionPattern = createRecognitionPattern(editRule);
		
		// Initialize change domains:
		recognitionPattern.initialize(matchingHelper);
//		System.out.println("Initial Domains: \n\n" + StringUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
		
		// Create matcher:
		return new RecognitionEngineMatcher(
				recognitionPattern,
				new RecognitionMatchCreator(recognitionPattern, matchingHelper.getRevision(), impact),
				resolvingScope, 
				overwriteScope,
				introducingScope,
				settings);
	}

	@Override
	public RecognitionEngineMatcher createMatcher(Rule editRule) {
		
		if (!started) {
			throw new RuntimeException("Call PartialEditRuleRecognizer start()!");
		}
		
		// Create recognition pattern:
		RecognitionPattern recognitionPattern = createRecognitionPattern(editRule);
		
		// Initialize change domains:
		recognitionPattern.initialize(matchingHelper);
//		System.out.println("Initial Domains: \n\n" + StringUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
		
		// Create matcher:
		return new RecognitionEngineMatcher(
				this, 
				recognitionPattern,
				new RecognitionMatchCreator(recognitionPattern, matchingHelper.getRevision()));
	}
	
	public void start() {
		
//		// Merge external resources into the difference:
//		mergeImports = new MergeImports(difference, Scope.RESOURCE, true);
//		mergeImports.merge();
		
		started = true;
	}

	public void finish() {
		
//		// Unmerge external resources into the difference:
//		mergeImports.unmerge();
//		started = false;
	}
}
