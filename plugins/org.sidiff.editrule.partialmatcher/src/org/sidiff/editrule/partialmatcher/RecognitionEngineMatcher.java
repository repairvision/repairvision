package org.sidiff.editrule.partialmatcher;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.editrule.partialmatcher.dependencies.DependencyEvaluation;
import org.sidiff.editrule.partialmatcher.generator.PartialMatchGenerator;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.editrule.partialmatcher.pattern.domain.Domain;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionEdge;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionNode;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePattern;
import org.sidiff.editrule.partialmatcher.scope.RepairScope;
import org.sidiff.editrule.partialmatcher.scope.RepairScopeConstraint;
import org.sidiff.editrule.partialmatcher.selection.IMatchSelector;
import org.sidiff.editrule.partialmatcher.selection.MatchSelector;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.IMatching;

public class RecognitionEngineMatcher implements IRecognitionEngineMatcher {

	private IRecognitionEngineMonitor monitor;
	
	private RecognitionPattern recognitionPattern; 
	
	private PartialMatchGenerator matchGenerator;
	
	private IMatchSelector matchSelector;
	
	private DependencyEvaluation dependencies;
	
	
	public RecognitionEngineMatcher(RecognitionPattern recognitionPattern) {
		this.recognitionPattern = recognitionPattern;
		this.monitor = new RecognitionEngineMonitor(this);
		
		// Create matcher:
		matchGenerator = new PartialMatchGenerator();
		matchSelector = new MatchSelector(recognitionPattern);
		
		dependencies = new DependencyEvaluation(recognitionPattern.getGraphPattern());
		matchGenerator.initialize(recognitionPattern.getChangeNodePatterns(), dependencies, matchSelector);
		
		matchGenerator.start();
	}
	
	public RecognitionEngineMatcher(RecognitionPattern recognitionPattern, RepairScope scope, LogTable runtimeLog) {
		this.recognitionPattern = recognitionPattern;
		this.monitor = new RecognitionEngineMonitor(this);
		
		// Log domain size:
		int domainSize = 0;
		
		for (NodePattern changeNode : recognitionPattern.getChangeNodePatterns()) {
			domainSize += Domain.get(changeNode).getMatchSize();
		}
		
		if (runtimeLog != null) {
			runtimeLog.append("Change Count (Sum)", domainSize);
			runtimeLog.append("Change Node Count", recognitionPattern.getChangeNodePatterns().size());
		}
		
		// Create Scope-Constraint:
		RepairScopeConstraint repairScopeConstraint = new RepairScopeConstraint(scope, recognitionPattern);
		
		// Create matcher:
		matchGenerator = new PartialMatchGenerator();
		matchSelector = new MatchSelector(recognitionPattern);
		
		dependencies = new DependencyEvaluation(recognitionPattern.getGraphPattern());
		matchGenerator.initialize(recognitionPattern.getChangeNodePatterns(), dependencies, matchSelector);
		matchGenerator.setScope(repairScopeConstraint);
		
		LogTime matchingTimer = new LogTime();
		matchGenerator.start();
		matchingTimer.stop();
		
		// Report matching:
		if (runtimeLog != null) {
			runtimeLog.append("[Time (ms)] Matching Time", matchingTimer);
		}
	}
	
	public RecognitionPattern getRecognitionPattern() {
		return recognitionPattern;
	}
	
	protected PartialMatchGenerator getMatchGenerator() {
		return matchGenerator;
	}
	
	protected IMatchSelector getMatchSelector() {
		return matchSelector;
	}
	
	protected DependencyEvaluation getDependencies() {
		return dependencies;
	}
	
	@Override
	public Iterator<IMatching> recognizeEditRule() {
		return matchGenerator.getResults();
	}
	
	@Override
	public IRecognitionEngineMonitor getMonitor() {
		return monitor;
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
