package org.sidiff.revision.editrules.recognition.impl;

import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.editrules.recognition.IRecognitionEngineProvider;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionLogger;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionSettings;
import org.sidiff.revision.editrules.recognition.match.util.RecognitionMatchCreator;
import org.sidiff.revision.editrules.recognition.pattern.RecognitionPattern;
import org.sidiff.revision.editrules.recognition.revision.RevisionGraph;
import org.sidiff.revision.editrules.recognition.util.debug.DebugUtil;

/**
 * @author Manuel Ohrndorf
 */
public class RecognitionEngineProvider implements IRecognitionEngineProvider {
	
	@Override
	public RecognitionEngine createMatcher(RecognitionSettings settings) {
		
		// Create recognition pattern:
		RecognitionPattern recognitionPattern = createRecognitionPattern(settings.getEditRule(), settings.getLogger());
		
		// Initialize change domains:
		recognitionPattern.initialize(new RevisionGraph(settings.getRevision()));
		
		if (settings.getLogger().isStepwise()) {
			settings.getLogger().logDomainInitialization(DebugUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
		}
		
		// Create matcher:
		return new RecognitionEngine(
				recognitionPattern,
				new RecognitionMatchCreator(recognitionPattern, settings.getRevision(), settings.getCurrentImpactAnalyzes()),
				settings.getHistoricalScope(), 
				settings.getCurrentScope(),
				settings.getAttributeScope(),
				settings);
	}

	/**
	 * @return A recognition engine without impact analysis, e.g., for debugging or testing.
	 */
	public RecognitionEngine createMatcher(Rule editRule, IRevision revision) {
		RecognitionLogger logger = new RecognitionLogger();
		
		// Create recognition pattern:
		RecognitionPattern recognitionPattern = createRecognitionPattern(editRule, logger);
		
		// Initialize change domains:
		recognitionPattern.initialize(new RevisionGraph(revision));
		
		if (logger.isStepwise()) {
			logger.logDomainInitialization(DebugUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
		}
		
		// Create matcher:
		return new RecognitionEngine(this, recognitionPattern,
				new RecognitionMatchCreator(recognitionPattern, revision), logger);
	}
	
	private RecognitionPattern createRecognitionPattern(Rule editRule, RecognitionLogger logger) {
		return createRecognitionPattern(editRule, GraphpatternFactory.eINSTANCE.createGraphPattern(), logger);
	}
	
	private RecognitionPattern createRecognitionPattern(Rule editRule, GraphPattern graphPattern, RecognitionLogger logger) {
		return new RecognitionPattern(editRule, graphPattern, logger);
	}
	
}
