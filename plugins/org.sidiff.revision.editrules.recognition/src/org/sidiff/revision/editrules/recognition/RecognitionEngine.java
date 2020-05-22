package org.sidiff.revision.editrules.recognition;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionLogger;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionSettings;
import org.sidiff.revision.editrules.recognition.impact.ImpactScope;
import org.sidiff.revision.editrules.recognition.match.util.RecognitionMatchCreator;
import org.sidiff.revision.editrules.recognition.pattern.RecognitionPattern;
import org.sidiff.revision.editrules.recognition.revision.RevisionGraph;
import org.sidiff.revision.editrules.recognition.util.debug.DebugUtil;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

/**
 * @author Manuel Ohrndorf
 */
public class RecognitionEngine implements IRecognitionEngine {
	
	protected Difference difference;
	
	protected RevisionGraph matchingHelper;
	
	@Override
	public void initialize(IRevision revision) {
		matchingHelper = new RevisionGraph(revision);
	}
	
	@Override
	public RecognitionEngineMatcher createMatcher(
			Rule editRule,
			ImpactAnalyzes impact,
			ImpactScope resolvingScope,
			ImpactScope overwriteScope,
			ImpactScope introducingScope,
			RecognitionSettings settings) {
		
		// Create recognition pattern:
		RecognitionPattern recognitionPattern = createRecognitionPattern(editRule, settings.getLogger());
		
		// Initialize change domains:
		recognitionPattern.initialize(matchingHelper);
		
		if (settings.getLogger().isStepwise()) {
			settings.getLogger().logDomainInitialization(DebugUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
		}
		
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
		RecognitionLogger logger = new RecognitionLogger();
		
		// Create recognition pattern:
		RecognitionPattern recognitionPattern = createRecognitionPattern(editRule, logger);
		
		// Initialize change domains:
		recognitionPattern.initialize(matchingHelper);
		
		if (logger.isStepwise()) {
			logger.logDomainInitialization(DebugUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
		}
		
		// Create matcher:
		return new RecognitionEngineMatcher(this, recognitionPattern,
				new RecognitionMatchCreator(recognitionPattern, matchingHelper.getRevision()), logger);
	}
	
	private RecognitionPattern createRecognitionPattern(Rule editRule, RecognitionLogger logger) {
		return createRecognitionPattern(editRule, GraphpatternFactory.eINSTANCE.createGraphPattern(), logger);
	}
	
	private RecognitionPattern createRecognitionPattern(Rule editRule, GraphPattern graphPattern, RecognitionLogger logger) {
		return new RecognitionPattern(editRule, graphPattern, logger);
	}
	
}
