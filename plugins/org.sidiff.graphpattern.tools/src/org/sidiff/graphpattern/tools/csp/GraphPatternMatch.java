package org.sidiff.graphpattern.tools.csp;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.csp.solver.ISolution;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.tools.editrules.generator.GEDEditRuleGenerator;

public class GraphPatternMatch implements ISolution<NodePattern, NodePattern> {

	protected GraphPattern graphPatternA;
	
	protected GraphPattern graphPatternB;
	
	protected Map<NodePattern, NodePattern> preToPostMatch;
	
	public GraphPatternMatch(GraphPattern graphPatternA, GraphPattern graphPatternB, int size) {
		this.graphPatternA = graphPatternA;
		this.graphPatternB = graphPatternB;
		this.preToPostMatch = new HashMap<NodePattern, NodePattern>((int) ((float) size / 0.75f + 1.0f));
	}
	
	public GraphPattern getGraphPatternA() {
		return graphPatternA;
	}
	
	public GraphPattern getGraphPatternB() {
		return graphPatternB;
	}
	
	@Override
	public void store(NodePattern subject, NodePattern value) {
		preToPostMatch.put(subject, value);
	}
	
	public int getGraphEditDistance() {
		GEDEditRuleGenerator editRuleGenerator = new GEDEditRuleGenerator(graphPatternA, graphPatternB, preToPostMatch);
		editRuleGenerator.generate(graphPatternA.getNodes(), graphPatternB.getNodes());
		return editRuleGenerator.getGraphEditDistance();
	}
	
	public Map<NodePattern, NodePattern> getMatch() {
		return preToPostMatch;
	}

	public int size() {
		return preToPostMatch.size();
	}
}
