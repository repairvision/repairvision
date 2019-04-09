package org.sidiff.graphpattern.tools.editrules.csp;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.csp.solver.ISolution;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.tools.editrules.generator.GEDEditRuleGenerator;

public class GraphConstraintMatch implements ISolution<NodePattern, NodePattern> {

	protected GraphPattern preConstraint;
	
	protected GraphPattern postConstraint;
	
	protected Map<NodePattern, NodePattern> preToPostMatch;
	
	public GraphConstraintMatch(GraphPattern preConstraint, GraphPattern postConstraint, int size) {
		this.preConstraint = preConstraint;
		this.postConstraint = postConstraint;
		this.preToPostMatch = new HashMap<NodePattern, NodePattern>((int) ((float) size / 0.75f + 1.0f));
	}
	
	public GraphPattern getPreConstraint() {
		return preConstraint;
	}
	
	public GraphPattern getPostConstraint() {
		return postConstraint;
	}
	
	@Override
	public void store(NodePattern subject, NodePattern value) {
		preToPostMatch.put(subject, value);
	}
	
	public int getGraphEditDistance() {
		GEDEditRuleGenerator editRuleGenerator = new GEDEditRuleGenerator(preConstraint, postConstraint, preToPostMatch);
		editRuleGenerator.generate(preConstraint.getNodes(), postConstraint.getNodes());
		return editRuleGenerator.getGraphEditDistance();
	}
	
	public Map<NodePattern, NodePattern> getMatch() {
		return preToPostMatch;
	}

	public int size() {
		return preToPostMatch.size();
	}
}
