package org.sidiff.editrule.recognition;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.editrule.recognition.configuration.RecognitionEngineSettings;
import org.sidiff.editrule.recognition.dependencies.DependencyEvaluation;
import org.sidiff.editrule.recognition.generator.PartialMatchGenerator;
import org.sidiff.editrule.recognition.impact.scope.RepairScope;
import org.sidiff.editrule.recognition.impact.scope.RepairScopeConstraint;
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
		matchGenerator.initialize(recognitionPattern.getChangeNodePatterns(), dependencies, matchSelector);
		
		matchGenerator.start();
	}
	
	public RecognitionEngineMatcher(RecognitionPattern recognitionPattern, RepairScope scope, RecognitionEngineSettings settings) {
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
		
		// Create Scope-Constraint:
		RepairScopeConstraint repairScopeConstraint = new RepairScopeConstraint(scope, recognitionPattern);
		
		// Create matcher:
		matchGenerator = new PartialMatchGenerator();
		matchSelector = new MatchSelector(recognitionPattern);
		
		dependencies = new DependencyEvaluation(recognitionPattern.getGraphPattern());
		matchGenerator.initialize(recognitionPattern.getChangeNodePatterns(), dependencies, matchSelector);
		matchGenerator.setScope(repairScopeConstraint);
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
