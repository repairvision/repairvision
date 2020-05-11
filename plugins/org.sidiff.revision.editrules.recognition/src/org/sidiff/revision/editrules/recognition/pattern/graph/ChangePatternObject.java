package org.sidiff.revision.editrules.recognition.pattern.graph;

import org.sidiff.graphpattern.GraphpatternFactory;

public abstract class ChangePatternObject extends ChangePattern {

	protected ActionNode node;
	
	public ChangePatternObject(ActionNode node) {
		this.node = node;
		this.changeNodePattern = GraphpatternFactory.eINSTANCE.createNodePattern();
	}
	
	public ActionNode getNode() {
		return node;
	}
	
	public abstract void doEvaluationStep();
	
	@Override
	public String toString() {
		return "ChangeObject[" + node.toString() + "]";
	}
}
