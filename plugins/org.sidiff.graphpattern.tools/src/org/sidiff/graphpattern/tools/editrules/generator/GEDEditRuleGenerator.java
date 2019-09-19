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
	protected void generateForbidPrecondition(NodePattern fromNode) {
		++forbidCount;
	}

	@Override
	protected void generateForbidPrecondition(EdgePattern fromEdge) {
		++forbidCount;
	}

	@Override
	protected void generateForbidPrecondition(AttributePattern fromAttribute) {
		++forbidCount;
	}

	@Override
	protected void generateRequirePrecondition(NodePattern fromNode) {
		++forbidCount;
	}

	@Override
	protected void generateRequirePrecondition(EdgePattern fromEdge) {
		++forbidCount;
	}

	@Override
	protected void generateRequirePrecondition(AttributePattern fromAttribute) {
		++forbidCount;
	}

	@Override
	protected void generateForbidPostcondition(NodePattern toNode) {
		++forbidCount;
	}

	@Override
	protected void generateForbidPostcondition(EdgePattern toEdge) {
		++forbidCount;
	}

	@Override
	protected void generateForbidPostcondition(AttributePattern toAttribute) {
		++forbidCount;
	}

	@Override
	protected void generateRequirePostcondition(NodePattern toNode) {
		++forbidCount;
	}

	@Override
	protected void generateRequirePostcondition(EdgePattern toEdge) {
		++forbidCount;
	}

	@Override
	protected void generateRequirePostcondition(AttributePattern toAttribute) {
		++forbidCount;
	}

	@Override
	protected void generateContext(NodePattern fromNode, NodePattern toNode) {
		++contextCount;
	}
	
	@Override
	protected void generatePreContext(NodePattern fromNode) {
		++contextCount;
	}

	@Override
	protected void generatePostContext(NodePattern toNode) {
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
