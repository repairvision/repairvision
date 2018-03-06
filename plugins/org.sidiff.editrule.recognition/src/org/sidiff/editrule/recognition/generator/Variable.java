package org.sidiff.editrule.recognition.generator;

import org.sidiff.graphpattern.NodePattern;

public class Variable {
	
	public int index;
	
	public NodePattern node;
	
	@Override
	public String toString() {
		return "<" + index + "> " + node.toString();
	}
}
