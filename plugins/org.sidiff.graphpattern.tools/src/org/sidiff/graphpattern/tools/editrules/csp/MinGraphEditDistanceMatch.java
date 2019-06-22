package org.sidiff.graphpattern.tools.editrules.csp;

import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatch;
import org.sidiff.graphpattern.tools.editrules.generator.GEDEditRuleGenerator;

public class MinGraphEditDistanceMatch extends GraphPatternMatch {

	public MinGraphEditDistanceMatch(int size) {
		super(size);
	}

	public int getGraphEditDistance(GraphPattern subjectGraph, GraphPattern valueGraph) {
		GEDEditRuleGenerator editRuleGenerator = new GEDEditRuleGenerator(subjectGraph, valueGraph, subjectNodeToValueNodeMatch);
		editRuleGenerator.generate(subjectGraph.getNodes(), valueGraph.getNodes());
		return editRuleGenerator.getGraphEditDistance();
	}
}
