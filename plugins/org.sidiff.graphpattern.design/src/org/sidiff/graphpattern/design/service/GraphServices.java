package org.sidiff.graphpattern.design.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sidiff.graphpattern.Association;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.design.consistency.ConsistencyChecks;

public class GraphServices {
	
	public void createAdjacentNode(NodePattern node) {
		
		// create node:
		NodePattern adjacent = GraphpatternFactory.eINSTANCE.createNodePattern();
		node.getGraph().getNodes().add(adjacent);
		
		// create edge:
		EdgePattern incident = GraphpatternFactory.eINSTANCE.createEdgePattern();
		node.getOutgoings().add(incident);
		incident.setSource(node);
		incident.setTarget(adjacent);
	}
	
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
	
	public void reconnectAssociation(Association association, GraphElement dragSource, GraphElement dropTarget) {
		if (association.getSource() == dragSource) {
			// Source move:
			if (dropTarget instanceof NodePattern) {
				association.setSource((NodePattern) dropTarget);
			}
		} else {
			// Target move:
			association.setTarget(dropTarget);
		}
	}

	/**
	 * @param graphPattern
	 *            A graph pattern.
	 * @return All edges of the graph pattern that will be shown as navigable edges.
	 */
	public List<EdgePattern> getUndirectedEdgeCandidates(GraphPattern graphPattern) {
		List<EdgePattern> edges = new ArrayList<>();
		Set<EdgePattern> opposite = new HashSet<>();

		for (NodePattern nodePattern : graphPattern.getNodes()) {
			for (EdgePattern edgePattern : nodePattern.getOutgoings()) {
				if (edgePattern.getOpposite() != null) {
					if (!isContainment(edgePattern) && !isContainment(edgePattern.getOpposite())) {

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
		}

		return edges;
	}
	
	/**
	 * @param graphPattern
	 *            A graph pattern.
	 * @return All edges of the graph pattern that will be shown as navigable containment edges.
	 */
	public List<EdgePattern> getUndirectedEdgeContainmentCandidates(GraphPattern graphPattern) {
		List<EdgePattern> edges = new ArrayList<>();
		
		for (NodePattern nodePattern : graphPattern.getNodes()) {
			for (EdgePattern edgePattern : nodePattern.getOutgoings()) {
				if (edgePattern.getOpposite() != null) {
					if (isContainment(edgePattern)) {
						
						// Check for >consistent< opposite:
						if (ConsistencyChecks.checkOpposite(edgePattern)) {
							edges.add(edgePattern);
						}
					}
				}
			}
		}
		
		return edges;
	}

	/**
	 * @param edgePattern An edge.
	 * @return <code>true</code> if the type of the edge is a containment;
	 *         <code>false</code> otherwise.
	 */
	public boolean isContainment(EdgePattern edgePattern) {
		return (edgePattern.getType() != null) && edgePattern.getType().isContainment();
	}
	
	/**
	 * @param graphPattern
	 *            A graph pattern.
	 * @return All edges of the graph pattern that will be shown as none navigable edges.
	 */
	public List<EdgePattern> getDirectedEdgeCandidates(GraphPattern graphPattern) {
		List<EdgePattern> edges = new ArrayList<>();
		
		for (NodePattern nodePattern : graphPattern.getNodes()) {
			for (EdgePattern edgePattern : nodePattern.getOutgoings()) {
				if (!isContainment(edgePattern)) {
					
					// Check if no (consistent) opposite is available:
					if (!ConsistencyChecks.checkOpposite(edgePattern)) {
						edges.add(edgePattern);
					}
				}
			}
		}
		
		return edges;
	}
	
	/**
	 * @param graphPattern
	 *            A graph pattern.
	 * @return All edges of the graph pattern that will be shown as none navigable edges.
	 */
	public List<EdgePattern> getDirectedEdgeContainmentCandidates(GraphPattern graphPattern) {
		List<EdgePattern> edges = new ArrayList<>();
		
		for (NodePattern nodePattern : graphPattern.getNodes()) {
			for (EdgePattern edgePattern : nodePattern.getOutgoings()) {
				if (isContainment(edgePattern)) {
					
					// Check if no (consistent) opposite is available:
					if (!ConsistencyChecks.checkOpposite(edgePattern)) {
						edges.add(edgePattern);
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
