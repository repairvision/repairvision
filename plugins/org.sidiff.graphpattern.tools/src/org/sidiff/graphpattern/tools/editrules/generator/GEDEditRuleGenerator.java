package org.sidiff.graphpattern.tools.editrules.generator;

import java.util.Map;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class GEDEditRuleGenerator extends BasicEditRuleGenerator {

	protected int graphEditDistance = 0;
	
	public GEDEditRuleGenerator(GraphPattern fromGraph, GraphPattern toGraph, Map<NodePattern, NodePattern> match) {
		super(fromGraph, toGraph, match);
	}

	public int getGraphEditDistance() {
		return graphEditDistance;
	}
	
	protected void generateCreate(NodePattern toNode) {
		++graphEditDistance;
	}
	
	protected void generateCreate(EdgePattern toEdge) {
		++graphEditDistance;
	}
	
	protected void generateCreate(AttributePattern toAttribute) {
		++graphEditDistance;
	}
	
	protected void generateDelete(NodePattern fromNode) {
		++graphEditDistance;
	}
	
	protected void generateDelete(EdgePattern fromEdge) {
		++graphEditDistance;
	}
	
	protected void generateDelete(AttributePattern fromAttribute) {
		++graphEditDistance;
	}
}
