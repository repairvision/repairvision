package org.sidiff.common.henshin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Not;

/**
 * Einige Verwaltungsinformationen zu PACs und NACs.
 * 
 * @author kehrer
 */
public class ApplicationCondition {

	private NestedCondition nestedCondition;
	private boolean inverted;
	
	private Set<Node> lhsBoundaryNodes;
	private Set<Node> acBoundaryNodes;
	private Set<Node> nonBoundaryNodes;
	
	private Map<Node, Node> lhsBoundaryNode2acBoundaryNode;
	private Map<Node, Node> acBoundaryNode2LhsBoundaryNode;
	
	public ApplicationCondition(NestedCondition nestedCondition) {
		this.nestedCondition = nestedCondition;
		
		init();
	}

	public Set<Node> getLhsBoundaryNodes() {
		return lhsBoundaryNodes;
	}

	public Set<Node> getAcBoundaryNodes() {
		return acBoundaryNodes;
	}

	public Set<Node> getNonBoundaryNodes() {
		return nonBoundaryNodes;
	}
	
	public Node getAcBoundaryNode(Node lhsContextNode){
		return lhsBoundaryNode2acBoundaryNode.get(lhsContextNode);
	}
	
	public Node getLhsBoundaryNode(Node acContextNode){
		return acBoundaryNode2LhsBoundaryNode.get(acContextNode);
	}
	
	public NestedCondition getNestedCondition() {
		return nestedCondition;
	}
	
	public boolean isInverted(){
		return inverted;
	}
	
	private void init() {
		lhsBoundaryNodes = new HashSet<Node>();
		acBoundaryNodes = new HashSet<Node>();
		nonBoundaryNodes = new HashSet<Node>();
		acBoundaryNode2LhsBoundaryNode = new HashMap<Node, Node>();
		lhsBoundaryNode2acBoundaryNode = new HashMap<Node, Node>();
		
		inverted = nestedCondition.eContainer() instanceof Not;
		
		for (Node node : nestedCondition.getConclusion().getNodes()) {
			boolean boundary = false;
			for (Mapping mapping : nestedCondition.getMappings()) {
				if (mapping.getImage() == node) {
					// it's a boundary node
					lhsBoundaryNodes.add(mapping.getOrigin());
					acBoundaryNodes.add(mapping.getImage());
					acBoundaryNode2LhsBoundaryNode.put(mapping.getImage(), mapping.getOrigin());
					lhsBoundaryNode2acBoundaryNode.put(mapping.getOrigin(), mapping.getImage());
					boundary = true;
					break;
				} 
			}
			
			if (!boundary){
				nonBoundaryNodes.add(node);
			}
		}
	}

}
