package org.sidiff.editrule.partialmatcher;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.consistency.common.monitor.LogTable;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.editrule.partialmatcher.dependencies.DependencyEvaluation;
import org.sidiff.editrule.partialmatcher.generator.PartialMatchGenerator;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPatternInitializer;
import org.sidiff.editrule.partialmatcher.pattern.domain.Domain;
import org.sidiff.editrule.partialmatcher.scope.RepairScope;
import org.sidiff.editrule.partialmatcher.scope.RepairScopeConstraint;
import org.sidiff.editrule.partialmatcher.selection.IMatchSelector;
import org.sidiff.editrule.partialmatcher.selection.MatchSelector;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.IMatching;

public class RecognitionEngineMatcher implements IRecognitionEngineMatcher {

	private RecognitionPattern recognitionPattern; 
	
	private PartialMatchGenerator matchGenerator;
	
	private IMatchSelector matchSelector;
	
	private DependencyEvaluation dependencies;
	
	public RecognitionEngineMatcher(RecognitionPattern recognitionPattern) {
		this.recognitionPattern = recognitionPattern;
		
		// Create matcher:
		matchGenerator = new PartialMatchGenerator();
		matchSelector = new MatchSelector(recognitionPattern);
		
		dependencies = new DependencyEvaluation(recognitionPattern.getGraphPattern());
		matchGenerator.initialize(recognitionPattern.getChangeNodePatterns(), dependencies, matchSelector);
		
		matchGenerator.start();
	}
	
	public RecognitionEngineMatcher(RecognitionPattern recognitionPattern, RepairScope scope, LogTable runtimeLog) {
		this.recognitionPattern = recognitionPattern;
		
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
	
	@Override
	public Iterator<IMatching> recognizeEditRule() {
		return matchGenerator.getResults();
	}

	@Override
	public List<NodePattern> getAllChanges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IChangeTag> getAvailableChangeTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NodePattern> getTaggedChanges(IChangeTag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEditRuleName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NodePattern> getEditRuleNodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EdgePattern> getEditRuleEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EdgePattern> getCurrentMatchingPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getEditRuleTrace(NodePattern node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edge getEditRuleTrace(EdgePattern node) {
		// TODO Auto-generated method stub
		return null;
	}

}
