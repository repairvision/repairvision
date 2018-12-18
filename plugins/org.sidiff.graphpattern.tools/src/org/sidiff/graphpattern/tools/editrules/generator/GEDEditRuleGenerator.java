package org.sidiff.graphpattern.tools.editrules.generator;

import java.util.Map;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class GEDEditRuleGenerator extends BasicEditRuleGenerator {

	protected int graphEditDistance = 0;
	
	protected int forbidCount = 0;
	
	protected int contextCount = 0;
	
	public GEDEditRuleGenerator(GraphPattern fromGraph, GraphPattern toGraph, Map<NodePattern, NodePattern> match) {
		super(fromGraph, toGraph, match);
	}

	public int getGraphEditDistance() {
		return graphEditDistance;
	}
	
	public int getForbidCount() {
		return forbidCount;
	}
	
	public int getContextCount() {
		return contextCount;
	}
	
	@Override
	protected void generateCreate(NodePattern toNode) {
		++graphEditDistance;
	}
	
	@Override
	protected void generateCreate(EdgePattern toEdge) {
		++graphEditDistance;
	}
	
	@Override
	protected void generateCreate(AttributePattern toAttribute) {
		++graphEditDistance;
	}
	
	@Override
	protected void generateDelete(NodePattern fromNode) {
		++graphEditDistance;
	}
	
	@Override
	protected void generateDelete(EdgePattern fromEdge) {
		++graphEditDistance;
	}
	
	@Override
	protected void generateDelete(AttributePattern fromAttribute) {
		++graphEditDistance;
	}
	
	@Override
	protected void generateModify(AttributePattern fromAttribute, String toAttributeValue) {
		++graphEditDistance;
	}

	@Override
	protected void generateForbid(AttributePattern toAttribute) {
		++forbidCount;
	}
	
	@Override
	protected void generateForbid(NodePattern toNode) {
		++forbidCount;
	}

	@Override
	protected void generateForbid(EdgePattern toEdge) {
		++forbidCount;
	}

	@Override
	protected void generateContext(NodePattern fromNode, NodePattern toNode) {
		++contextCount;
	}

	@Override
	protected void generateContext(EdgePattern fromEdge, EdgePattern toEdge) {
		++contextCount;
	}

	@Override
	protected void generateContext(AttributePattern fromAttribute, AttributePattern toAttribute) {
		++contextCount;
	}
	
}
