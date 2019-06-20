package org.sidiff.graphpattern.tools.csp;

import java.util.List;

import org.sidiff.csp.solver.impl.domain.Domain;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;

public class NodePatternDomain extends Domain<NodePattern> {

	public NodePatternDomain(NodePattern subject, List<NodePattern> candidates) {
		for (NodePattern value : candidates) {
			if (checkType(subject, value) && checkOutgoings(subject, value) && checkIncomings(subject, value)) {
				add(value);
			}
		}
	}
	
	private boolean checkType(NodePattern subject, NodePattern value) {
		return subject.getType().equals(value.getType());
	}
	
	private boolean checkOutgoings(NodePattern subject, NodePattern value) {
		
		if (subject.getOutgoings().size() == value.getOutgoings().size()) {

			// TODO: We could also check more for exact edge mapping...
			for (EdgePattern subjectEdge : subject.getOutgoings()) {
				if (value.getOutgoing(subjectEdge.getType()) == null) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	private boolean checkIncomings(NodePattern subject, NodePattern value) {
		
		if (subject.getIncomings().size() == value.getIncomings().size()) {

			// TODO: We could also check more for exact edge mapping...
			for (EdgePattern subjectEdge : subject.getIncomings()) {
				if (value.getIncoming(subjectEdge.getType()) == null) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
}
