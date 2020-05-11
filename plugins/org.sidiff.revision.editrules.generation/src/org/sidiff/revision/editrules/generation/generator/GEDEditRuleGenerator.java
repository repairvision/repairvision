package org.sidiff.revision.editrules.generation.generator;

import java.util.Map;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;

public class GEDEditRuleGenerator extends BasicEditRuleGenerator {

	protected int graphEditDistance = 0;
	
	protected int forbidCount = 0;
	
	protected int contextCount = 0;
	
	public GEDEditRuleGenerator(GraphPattern preGraph, GraphPattern postGraph, Map<NodePattern, NodePattern> match) {
		super(preGraph, postGraph, match);
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
	protected void generateCreate(NodePattern postNode) {
		++graphEditDistance;
	}
	
	@Override
	protected void generateCreate(EdgePattern postEdge) {
		++graphEditDistance;
	}
	
	@Override
	protected void generateCreate(AttributePattern postAttribute) {
		++graphEditDistance;
	}
	
	@Override
	protected void generateDelete(NodePattern preNode) {
		++graphEditDistance;
	}
	
	@Override
	protected void generateDelete(EdgePattern preEdge) {
		++graphEditDistance;
	}
	
	@Override
	protected void generateDelete(AttributePattern preAttribute) {
		++graphEditDistance;
	}
	
	@Override
	protected void generateModify(AttributePattern preAttribute, String postAttributeValue) {
		++graphEditDistance;
	}

	@Override
	protected void generateForbidPrecondition(NodePattern preNode) {
		++forbidCount;
	}

	@Override
	protected void generateForbidPrecondition(EdgePattern preEdge) {
		++forbidCount;
	}

	@Override
	protected void generateForbidPrecondition(AttributePattern preAttribute) {
		++forbidCount;
	}

	@Override
	protected void generateRequirePrecondition(NodePattern preNode) {
		++forbidCount;
	}

	@Override
	protected void generateRequirePrecondition(EdgePattern preEdge) {
		++forbidCount;
	}

	@Override
	protected void generateRequirePrecondition(AttributePattern preAttribute) {
		++forbidCount;
	}

	@Override
	protected void generateForbidPostcondition(NodePattern postNode) {
		++forbidCount;
	}

	@Override
	protected void generateForbidPostcondition(EdgePattern postEdge) {
		++forbidCount;
	}

	@Override
	protected void generateForbidPostcondition(AttributePattern postAttribute) {
		++forbidCount;
	}

	@Override
	protected void generateRequirePostcondition(NodePattern postNode) {
		++forbidCount;
	}

	@Override
	protected void generateRequirePostcondition(EdgePattern postEdge) {
		++forbidCount;
	}

	@Override
	protected void generateRequirePostcondition(AttributePattern postAttribute) {
		++forbidCount;
	}

	@Override
	protected void generateContext(NodePattern preNode, NodePattern postNode) {
		++contextCount;
	}
	
	@Override
	protected void generatePreContext(NodePattern preNode) {
		++contextCount;
	}

	@Override
	protected void generatePostContext(NodePattern postNode) {
		++contextCount;
	}

	@Override
	protected void generateContext(EdgePattern preEdge, EdgePattern postEdge) {
		++contextCount;
	}

	@Override
	protected void generateContext(AttributePattern preAttribute, AttributePattern postAttribute) {
		++contextCount;
	}
}
