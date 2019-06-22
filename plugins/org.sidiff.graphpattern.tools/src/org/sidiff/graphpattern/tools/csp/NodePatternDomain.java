package org.sidiff.graphpattern.tools.csp;

import java.util.List;

import org.sidiff.csp.solver.impl.domain.Domain;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;

public class NodePatternDomain extends Domain<NodePattern> {

	public NodePatternDomain(NodePattern subject, List<NodePattern> candidates, boolean maximumSolution, boolean exactSolution) {
		
		// NOTE: maximumSolution: allow/disallow partial solutions for the subject
		// NOTE: exactSolution: search for exact matching between subject and candidate
		
		for (NodePattern value : candidates) {
			boolean structure = !maximumSolution 
					|| (checkOutgoings(subject, value, exactSolution) && checkIncomings(subject, value, exactSolution));
			
			if (checkType(subject, value) && structure) {
				add(value);
			}
		}
	}
	
	protected boolean checkType(NodePattern subject, NodePattern value) {
		return subject.getType().equals(value.getType());
	}
	
	protected boolean checkOutgoings(NodePattern subject, NodePattern value, boolean exactSolution) {
		
		if (exactSolution && (subject.getOutgoings().size() != value.getOutgoings().size())) {
			return false;
		}
		
		if (value.getOutgoings().size() >= subject.getOutgoings().size()) {

			// TODO: Could also check more for exact edge mapping...
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
	
	protected boolean checkIncomings(NodePattern subject, NodePattern value, boolean exactSolution) {
		
		if (exactSolution && (subject.getIncomings().size() != value.getIncomings().size())) {
			return false;
		}
		
		if (value.getIncomings().size() >= subject.getIncomings().size()) {

			// TODO: Could also check more for exact edge mapping...
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
