package org.sidiff.graphpattern.tools.csp;

import java.util.List;
import java.util.function.Function;

import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.csp.generic.impl.domain.Domain;

public class NodePatternDomain extends Domain<NodePattern> {

	public enum EdgeMatching {
		
		// https://en.wikipedia.org/wiki/Partial_function
		// https://en.wikipedia.org/wiki/Partial_function#Total_function
		
		/**
		 * - One-to-one mapping (correspondences) 
		 * - Map all subject to candidate edges
		 * - Candidate can have more edges
		 */
		TOTAL_INJECTIVE,
		
		/**
		 * - One-to-one mapping (correspondences) 
		 * - Map all subject to candidate edges
		 * - Subject and candidate have the amount of edges
		 */
		TOTAL_BIJECTIVE,
		
		/**
		 * - One-to-one mapping (correspondences) 
		 * - Partial mapping of subject to candidate edges
		 * - Subject and candidate can have different amount of edges
		 */
		PARTIAL_INJECTIVE
	}
	
	/**
	 * @param subject The node to be matched.
	 * @param candidates Candidates for matchable nodes.
	 * @param incomingMatching Required matching criteria for incoming edges of a node.
	 * @param outgoingMatching Required matching criteria for outgoing edges of a node.
	 * @param edgeFilter Edges that are ignored during edge matching.
	 */
	public NodePatternDomain(
			NodePattern subject, List<NodePattern> candidates,
			EdgeMatching incomingMatching, EdgeMatching outgoingMatching, Function<EdgePattern, Boolean> edgeFilter) {

		for (NodePattern value : candidates) {
			if (checkType(subject, value) 
					&& checkStereotypes(subject, value)
					&& checkAttributes(subject, value)
					&& checkOutgoings(subject, value, incomingMatching, edgeFilter)
					&& checkIncomings(subject, value, outgoingMatching, edgeFilter)) {
				add(value);
			}
		}
	}
	
	/**
	 * 
	 * @see NodePatternDomain#NodePatternDomain(NodePattern, List, EdgeMatching, EdgeMatching, Function)
	 */
	public NodePatternDomain(
			NodePattern subject, List<NodePattern> candidates,
			EdgeMatching incomingMatching, EdgeMatching outgoingMatching) {
		this(subject, candidates, incomingMatching, outgoingMatching, null);
	}

	protected boolean checkType(NodePattern subject, NodePattern value) {
		return subject.getType().equals(value.getType());
	}
	
	protected boolean checkOutgoings(
			NodePattern subject, NodePattern value, 
			EdgeMatching matching, Function<EdgePattern, Boolean> edgeFilter) {
		
		return checkEdges(subject, subject.getOutgoings(), value, value.getOutgoings(), matching, edgeFilter);
	}
	
	protected boolean checkIncomings(
			NodePattern subject, NodePattern value,
			EdgeMatching matching, Function<EdgePattern, Boolean> edgeFilter) {
		
		return checkEdges(subject, subject.getIncomings(), value, value.getIncomings(), matching, edgeFilter);
	}
	
	protected boolean checkEdges(
			NodePattern subject, List<EdgePattern> subjectEdges, NodePattern value, List<EdgePattern> valueEdges,
			EdgeMatching matching, Function<EdgePattern, Boolean> edgeFilter) {
		
		int subjectIncomingSize = subjectEdges.size();
		int valueIncomingSize = valueEdges.size();
		
		// Number of incoming with filter:
		if (edgeFilter != null) {
			for (EdgePattern subjectEdge : subjectEdges) {
				if (!edgeFilter.apply(subjectEdge)) {
					--subjectIncomingSize;
				}
			}
			for (EdgePattern valueEdge : valueEdges) {
				if (!edgeFilter.apply(valueEdge)) {
					--valueIncomingSize;
				}
			}
		}
		
		// Basic (at least one candidate)* edge assignment test for value to subject:
		if (matching.equals(EdgeMatching.TOTAL_BIJECTIVE)) {
			if (valueIncomingSize == subjectIncomingSize) {
				for (EdgePattern valueEdge : valueEdges) {
					if ((edgeFilter == null) || !edgeFilter.apply(valueEdge)) {
						if (!matchEdge(valueEdge, subjectEdges)) {
							return false;
						}
					}
				}
				return true;
			} else {
				return false;
			}
		}
		
		// Basic (at least one candidate)* edge assignment test for subject to value:
		if (matching.equals(EdgeMatching.TOTAL_BIJECTIVE) || matching.equals(EdgeMatching.TOTAL_INJECTIVE)) {
			if (valueIncomingSize >= subjectIncomingSize) {
				for (EdgePattern subjectEdge : subjectEdges) {
					if ((edgeFilter == null) || !edgeFilter.apply(subjectEdge)) {
						if (!matchEdge(subjectEdge, valueEdges)) {
							return false;
						}
					}
				}
				return true;
			} else {
				return false;
			}
		}
		
		// TODO: *asserts that there is just one edge of a specific type between two nodes! 
		return true;
	}
	
	protected boolean matchEdge(EdgePattern edgeToBeMatched, List<EdgePattern> candidateEdges) {
		for (EdgePattern candidateEdge : candidateEdges) {
			if (edgeToBeMatched.getType() == candidateEdge.getType()) {
				return true;
			}
		}
		return false;
	}
	
	protected boolean checkStereotypes(NodePattern subject, NodePattern value) {
		return true;
	}
	
	protected boolean checkAttributes(NodePattern subject, NodePattern value) {
		return true;
	}
}
