package org.sidiff.graphpattern.tools.editrules.csp;

import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatch;
import org.sidiff.graphpattern.tools.editrules.generator.GEDEditRuleGenerator;
import org.sidiff.graphpattern.tools.editrules.generator.GraphPatternEditRuleGenerator;

public class MinGraphEditDistanceMatch extends GraphPatternMatch {

	private int graphEditDistance = -2;
	
	private Pattern editOperation;
	
	private GraphPattern editRule;
	
	public MinGraphEditDistanceMatch(int size) {
		super(size);
	}

	public int getGraphEditDistance(GraphPattern subjectGraph, GraphPattern valueGraph) {
		
		if (graphEditDistance == -2) {
			GEDEditRuleGenerator editRuleGenerator = new GEDEditRuleGenerator(subjectGraph, valueGraph, subjectNodeToValueNodeMatch);
			editRuleGenerator.generate(subjectGraph.getNodes(), valueGraph.getNodes());
			this.graphEditDistance = editRuleGenerator.getGraphEditDistance();
		}
		
		return graphEditDistance;
	}
	
	public Pattern getEditOperation() {
		return editOperation;
	}

	public GraphPattern getEditRule() {
		return editRule;
	}
	
	public void setName(String name) {
		editOperation.setName(name);
		editRule.setName(name);
	}
	
	void generateEditOperation(GraphPattern subjectGraph, GraphPattern valueGraph) {
		GraphPatternEditRuleGenerator editRuleGenerator = new GraphPatternEditRuleGenerator(subjectGraph, valueGraph, subjectNodeToValueNodeMatch);
		editRuleGenerator.generate(subjectGraph.getNodes(), valueGraph.getNodes());
		this.editOperation = editRuleGenerator.getEditOperation();
		this.editRule = editRuleGenerator.getEditRule();
	}
}
