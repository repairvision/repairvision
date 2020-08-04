package org.sidiff.revision.editrules.recognition.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.common.logging.util.LogTime;
import org.sidiff.revision.editrules.impact.graph.GraphActionImpactScope;
import org.sidiff.revision.editrules.recognition.IRecognitionEngine;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionLogger;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionSettings;
import org.sidiff.revision.editrules.recognition.dependencies.DependencyEvaluation;
import org.sidiff.revision.editrules.recognition.impact.ImpactScopeConstraint;
import org.sidiff.revision.editrules.recognition.match.RecognitionMatching;
import org.sidiff.revision.editrules.recognition.match.util.RecognitionMatchCreator;
import org.sidiff.revision.editrules.recognition.pattern.RecognitionPattern;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionEdge;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionNode;
import org.sidiff.revision.editrules.recognition.pattern.graph.ChangePattern;
import org.sidiff.revision.editrules.recognition.selection.IMatchSelector;
import org.sidiff.revision.editrules.recognition.selection.MatchSelector;
import org.sidiff.revision.editrules.recognition.solver.PartialCSPSolver;
import org.sidiff.revision.editrules.recognition.util.debug.IRecognitionPatternSerializer;

public class RecognitionEngine implements IRecognitionEngine {

	protected RecognitionEngineProvider engine;
	
	protected RecognitionPattern recognitionPattern; 
	
	protected PartialCSPSolver matchGenerator;
	
	protected IMatchSelector matchSelector;
	
	protected DependencyEvaluation dependencies;
	
	protected RecognitionSettings settings;
	
	protected IRecognitionPatternSerializer recognitionPatternSerializer = new IRecognitionPatternSerializer() {
		public void saveRecognitionRule() {}
	};
	
	public RecognitionEngine(
			RecognitionEngineProvider engine,
			RecognitionPattern recognitionPattern,
			RecognitionMatchCreator matchCreator,
			RecognitionLogger logger) {
		
		this.engine = engine;
		this.recognitionPattern = recognitionPattern;
		
		// Save recognition-rule:
		recognitionPatternSerializer.saveRecognitionRule();
		
		// Create matcher:
		matchGenerator = new PartialCSPSolver();
		matchSelector = new MatchSelector(recognitionPattern);
		
		dependencies = new DependencyEvaluation(recognitionPattern.getGraphPattern());
		matchGenerator.initialize(
				recognitionPattern.getChangeNodePatterns(),
				matchSelector,
				matchCreator,
				dependencies,
				ImpactScopeConstraint.DUMMY,
				ImpactScopeConstraint.DUMMY,
				ImpactScopeConstraint.DUMMY,
				logger);
		
		matchGenerator.start();
	}
	
	public RecognitionEngine(
			RecognitionPattern recognitionPattern,
			RecognitionMatchCreator matchCreator,
			GraphActionImpactScope historicalScope,
			GraphActionImpactScope currentScope,
			GraphActionImpactScope attributeScope,
			RecognitionSettings settings) {
		
		this.recognitionPattern = recognitionPattern;
		this.settings = settings;
		
		// Create Repair-Scope-Constraint:
		ImpactScopeConstraint historicalScopeConstraint = new ImpactScopeConstraint(historicalScope, recognitionPattern);
		ImpactScopeConstraint currentScopeConstraint = new ImpactScopeConstraint(currentScope, recognitionPattern);
		ImpactScopeConstraint attributeScopeConstraint = new ImpactScopeConstraint(attributeScope, recognitionPattern);

		// Create Change-Dependency-Constraint: 
		dependencies = new DependencyEvaluation(recognitionPattern.getGraphPattern());

		// Create Structural-Matcher:
		matchSelector = new MatchSelector(recognitionPattern);

		// TODO[EXPERIMENTAL]: Seed initial domains by impact:
//		MatchSeeding matchSeeding = new MatchSeeding(recognitionPattern);
//		matchSeeding.seed(resolvingScope, overwriteScope);
//		matchSelector = matchSeeding;	// Remove old selector!

		// Create CSP-Matcher:
		matchGenerator = new PartialCSPSolver();
		matchGenerator.initialize(
				recognitionPattern.getChangeNodePatterns(),
				matchSelector,
				matchCreator,
				dependencies,
				historicalScopeConstraint,
				currentScopeConstraint,
				attributeScopeConstraint,
				settings.getLogger());
		matchGenerator.setMinimumSolutionSize(settings.getMinimumSolutionSize());
	}

	public RecognitionEngineProvider getEngine() {
		return engine;
	}
	
	@Override
	public List<RecognitionMatching> recognizeEditRule() {
		
		if (isLogging()) {
			settings.getLogger().logEditRule(recognitionPattern.getEditRule());
			settings.getLogger().logChangeCount(getDomainSize(recognitionPattern));
			settings.getLogger().logChangeActionCount(recognitionPattern.getChangeNodePatterns().size());
		}
		
		LogTime matchingTimer = new LogTime();
		matchGenerator.start();
		matchingTimer.stop();

		if (isLogging()) {
			settings.getLogger().logRecognitionTime(matchingTimer);
			settings.getLogger().logMatchingTime(matchingTimer);
		}

		return matchGenerator.getResults();
	}
	
	private boolean isLogging() {
		return (settings != null) && (settings.getLogger().isDebugging());
	}
	
	private int getDomainSize(RecognitionPattern recognitionPattern) {
		int domainSize = 0;
		
		for (NodePattern changeNode : recognitionPattern.getChangeNodePatterns()) {
			domainSize += Domain.get(changeNode).size();
		}
		
		return domainSize;
	}

	public Collection<ChangePattern> getAllChanges() {
		return Collections.unmodifiableCollection(recognitionPattern.getChangePatternTrace().values());
	}

	public String getEditRuleName() {
		return recognitionPattern.getEditRule().getName();
	}

	public Collection<ActionNode> getEditRuleNodes() {
		return Collections.unmodifiableCollection(recognitionPattern.getNodeTrace().values());
	}

	public Collection<ActionEdge> getEditRuleEdges() {
		return Collections.unmodifiableCollection(recognitionPattern.getEdgeTrace().values());
	}
}
