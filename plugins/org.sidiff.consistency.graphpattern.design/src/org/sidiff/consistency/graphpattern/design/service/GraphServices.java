package org.sidiff.consistency.graphpattern.design.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.design.consistency.ConsistencyChecks;

public class GraphServices {
	
	public void reconnectEdge(EdgePattern edgePattern, NodePattern dragSource, NodePattern dropTarget) {
		if (edgePattern.getSource() == dragSource) {
			// Source move:
			edgePattern.setSource(dropTarget);
			
			if (edgePattern.getOpposite() != null) {
				edgePattern.getOpposite().setTarget(dropTarget);
			}
		} else {
			// Target move:
			edgePattern.setTarget(dropTarget);
			
			if (edgePattern.getOpposite() != null) {
				edgePattern.getOpposite().setSource(dropTarget);
			}
		}
	}

	public List<EdgePattern> getNavigableEdgeCandidates(GraphPattern graphPattern) {
		List<EdgePattern> edges = new ArrayList<>();
		Set<EdgePattern> opposite = new HashSet<>();
		
		for (NodePattern nodePattern : graphPattern.getNodes()) {
			for (EdgePattern edgePattern : nodePattern.getOutgoings()) {
				// Filter cross-reference edges:
				if (!ConsistencyChecks.isEdgeWithCrossReference(edgePattern)) {
					// Check for >consistent< opposite:
					if (ConsistencyChecks.checkOpposite(edgePattern)) {
						if (!opposite.contains(edgePattern)) {
							edges.add(edgePattern);
							
							// Filter the opposite -> as semantic candidate:
							opposite.add(edgePattern.getOpposite());
						}
					}
				}
			}
		}
		
		return edges;
	}
	
	public List<EdgePattern> getNonNavigableEdgeCandidates(GraphPattern graphPattern) {
		List<EdgePattern> edges = new ArrayList<>();
		
		for (NodePattern nodePattern : graphPattern.getNodes()) {
			for (EdgePattern edgePattern : nodePattern.getOutgoings()) {
				// Check if no (consistent) opposite is available:
				if (!ConsistencyChecks.checkOpposite(edgePattern)) {
					// Filter cross-reference edges:
					if (!ConsistencyChecks.isEdgeWithCrossReference(edgePattern)) {
						edges.add(edgePattern);
					} else {
						// Always show inconsistent opposite definitions as separate edges:
						if (!edgePattern.isCrossReference()) {
							edges.add(edgePattern);
						}
					}
				}

			}
		}
		
		return edges;
	}
	
	
	public List<EdgePattern> getNonNavigableWithCrossReferenceEdgeCandidates(GraphPattern graphPattern) {
		List<EdgePattern> edges = new ArrayList<>();
		
		for (NodePattern nodePattern : graphPattern.getNodes()) {
			for (EdgePattern edgePattern : nodePattern.getOutgoings()) {
				// Consider only edges with cross-references:
				if (ConsistencyChecks.isEdgeWithCrossReference(edgePattern)) {
					// Check for >consistent< edge with cross-reference:
					if (ConsistencyChecks.checkOpposite(edgePattern)) {
						// Filter cross-reference it-self -> as semantic candidate:
						if (!edgePattern.isCrossReference()) {
							edges.add(edgePattern);
						}
					} else {
						// Always show inconsistent opposite cross-reference definitions as separate edges:
						if (edgePattern.isCrossReference()) {
							edges.add(edgePattern);
						}
					}

				}
			}
		}
		
		return edges;
	}
	
	public List<EdgePattern> getOppositeEdgeCandidate(EdgePattern edgePattern) {
		
		if (ConsistencyChecks.checkOpposite(edgePattern)) {
			// All entries of the properties -> semantic tab:
			List<EdgePattern> edges = new ArrayList<>(2);
			
			// Fix order:
			if (edgePattern.hashCode() < edgePattern.getOpposite().hashCode()) {
				edges.add(edgePattern);
				edges.add(edgePattern.getOpposite());
			} else {
				edges.add(edgePattern.getOpposite());
				edges.add(edgePattern);
			}

			return edges;
		} else {
			return Collections.singletonList(edgePattern);
		}
	}
}
