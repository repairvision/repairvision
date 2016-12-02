package org.sidiff.graphpattern.matching.selection;

import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;

public class Move {
	NodePattern source;
	EdgePattern edge;
	NodePattern target;
	
	public Move(NodePattern source, EdgePattern edge, NodePattern target) {
		super();
		this.source = source;
		this.edge = edge;
		this.target = target;
	}
}