package org.sidiff.editrule.recognition;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.editrule.recognition.configuration.RecognitionEngineSettings;
import org.sidiff.editrule.recognition.dependencies.DependencyEvaluation;
import org.sidiff.editrule.recognition.generator.PartialMatchGenerator;
import org.sidiff.editrule.recognition.impact.ImpactScope;
import org.sidiff.editrule.recognition.impact.ImpactScopeConstraint;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.pattern.domain.Domain;
import org.sidiff.editrule.recognition.pattern.graph.ActionEdge;
import org.sidiff.editrule.recognition.pattern.graph.ActionNode;
import org.sidiff.editrule.recognition.pattern.graph.ChangePattern;
import org.sidiff.editrule.recognition.selection.MatchSelector;
import org.sidiff.graphpattern.NodePattern;

public class RecognitionEngineMatcher implements IRecognitionEngineMatcher {

	protected RecognitionEngine engine;
	
	protected RecognitionPattern recognitionPattern; 
	
	protected PartialMatchGenerator matchGenerator;
	
	protected MatchSelector matchSelector;
	
	protected DependencyEvaluation dependencies;
	
	protected RecognitionEngineSettings settings;
	
	public RecognitionEngineMatcher(RecognitionEngine engine, RecognitionPattern recognitionPattern) {
		this.engine = engine;
		this.recognitionPattern = recognitionPattern;
		
		// Create matcher:
		matchGenerator = new PartialMatchGenerator();
		matchSelector = new MatchSelector(recognitionPattern);
		
		dependencies = new DependencyEvaluation(recognitionPattern.getGraphPattern());
		matchGenerator.initialize(
				recognitionPattern.getChangeNodePatterns(),
				matchSelector,
				dependencies,
				ImpactScopeConstraint.DUMMY,
				ImpactScopeConstraint.DUMMY,
				ImpactScopeConstraint.DUMMY);
		
		matchGenerator.start();
	}
	
	public RecognitionEngineMatcher(
			RecognitionPattern recognitionPattern,
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
		
		// Create CSP-Matcher:
		matchGenerator = new PartialMatchGenerator();
		matchGenerator.initialize(
				recognitionPattern.getChangeNodePatterns(),
				matchSelector,
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
	public Iterator<IMatching> recognizeEditRule() {
		
		LogTime matchingTimer = new LogTime();
		matchGenerator.start();
		matchingTimer.stop();
		
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
