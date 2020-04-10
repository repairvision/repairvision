package org.sidiff.revision.editrule.recognition.solver;

import org.sidiff.graphpattern.NodePattern;

public class Variable {
	
	public int index;
	
	public NodePattern node;
	
	@Override
	public String toString() {
		return "<" + index + "> " + node.toString();
	}
}
