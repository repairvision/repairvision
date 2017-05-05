package org.sidiff.editrule.partialmatcher.pattern.graph;

import org.sidiff.graphpattern.GraphpatternFactory;

public abstract class ChangePatternReference extends ChangePattern  {
	
	protected ActionEdge edge;
	
	public ChangePatternReference(ActionEdge edge) {
		this.edge = edge;
		this.changeNodePattern = GraphpatternFactory.eINSTANCE.createNodePattern();
	}
	
	public ActionEdge getEdge() {
		return edge;
	}
	
	public abstract void doEvaluationStep(ActionNode stepSource);
	
	@Override
	public String toString() {
		return "ChangeReference[" + edge.toString() + "]";
	}
}

