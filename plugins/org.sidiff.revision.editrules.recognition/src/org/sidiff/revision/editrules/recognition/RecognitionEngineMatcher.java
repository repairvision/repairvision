package org.sidiff.revision.editrules.recognition;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.sidiff.common.utilities.monitor.LogTime;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionEngineSettings;
import org.sidiff.revision.editrules.recognition.dependencies.DependencyEvaluation;
import org.sidiff.revision.editrules.recognition.impact.ImpactScope;
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
import org.sidiff.revision.editrules.recognition.util.debug.DebugUtil;
import org.sidiff.revision.editrules.recognition.util.debug.IRecognitionPatternSerializer;

public class RecognitionEngineMatcher implements IRecognitionEngineMatcher {

	protected RecognitionEngine engine;
	
	protected RecognitionPattern recognitionPattern; 
	
	protected PartialCSPSolver matchGenerator;
	
	protected IMatchSelector matchSelector;
	
	protected DependencyEvaluation dependencies;
	
	protected RecognitionEngineSettings settings;

	protected IRecognitionPatternSerializer recognitionPatternSerializer = new IRecognitionPatternSerializer() {
		public void saveRecognitionRule() {}
	};
	
	public RecognitionEngineMatcher(
			RecognitionEngine engine,
			RecognitionPattern recognitionPattern,
			RecognitionMatchCreator matchCreator) {
		
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
				ImpactScopeConstraint.DUMMY);
		
		matchGenerator.start();
	}
	
	public RecognitionEngineMatcher(
			RecognitionPattern recognitionPattern,
			RecognitionMatchCreator matchCreator,
			ImpactScope resolvingScope,
			ImpactScope overwriteScope,
			ImpactScope introducingScope,
			RecognitionEngineSettings settings) {
		
		this.recognitionPattern = recognitionPattern;
		this.settings = settings;
		
		// Log domain size:
		int domainSize = 0;
		
		for (NodePattern changeNode : recognitionPattern.getChangeNodePatterns()) {
			domainSize += Domain.get(changeNode).size();
		}
		
		if ((settings != null) && (settings.getMonitor().isLogging())) {
			settings.getMonitor().logChangeCount(domainSize);
			settings.getMonitor().logChangeActionCount(recognitionPattern.getChangeNodePatterns().size());
		}
		
		// Create Repair-Scope-Constraint:
		ImpactScopeConstraint resolvingScopeConstraint = new ImpactScopeConstraint(resolvingScope, recognitionPattern);
		ImpactScopeConstraint overwriteScopeConstraint = new ImpactScopeConstraint(overwriteScope, recognitionPattern);
		ImpactScopeConstraint introducingScopeConstraint = new ImpactScopeConstraint(introducingScope, recognitionPattern);
		
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
				resolvingScopeConstraint,
				overwriteScopeConstraint,
				introducingScopeConstraint);
		matchGenerator.setMinimumSolutionSize(settings.getMinimumSolutionSize());
	}
	
	@Override
	public RecognitionEngine getEngine() {
		return engine;
	}
	
	@Override
	public List<RecognitionMatching> recognizeEditRule() {
		
		DebugUtil.printEditRule(recognitionPattern.getEditRule());
		
		LogTime matchingTimer = new LogTime();
		matchGenerator.start();
		matchingTimer.stop();
		
		DebugUtil.printRecognitionTime(matchingTimer);
		
		// Report matching:
		if ((settings != null) && (settings.getMonitor().isLogging())) {
			settings.getMonitor().logMatchingTime(matchingTimer);
		}
		
		return matchGenerator.getResults();
	}

	@Override
	public Collection<ChangePattern> getAllChanges() {
		return Collections.unmodifiableCollection(recognitionPattern.getChangePatternTrace().values());
	}

	@Override
	public String getEditRuleName() {
		return recognitionPattern.getEditRule().getName();
	}

	@Override
	public Collection<ActionNode> getEditRuleNodes() {
		return Collections.unmodifiableCollection(recognitionPattern.getNodeTrace().values());
	}

	@Override
	public Collection<ActionEdge> getEditRuleEdges() {
		return Collections.unmodifiableCollection(recognitionPattern.getEdgeTrace().values());
	}
}
