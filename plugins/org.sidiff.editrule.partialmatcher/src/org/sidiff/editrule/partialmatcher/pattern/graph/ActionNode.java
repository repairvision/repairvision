package org.sidiff.editrule.partialmatcher.pattern.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.henshin.ChangePatternUtil;
import org.sidiff.common.henshin.view.AttributePair;
import org.sidiff.editrule.partialmatcher.pattern.domain.Domain;
import org.sidiff.editrule.partialmatcher.pattern.domain.Domain.SelectionType;
import org.sidiff.editrule.partialmatcher.util.LiftingGraphIndex;
import org.sidiff.editrule.partialmatcher.util.debug.DebugUtil;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.MatchingModelPackage;

public class ActionNode extends ActionGraphElement  {
	
	// Edit-Rule:
	
	protected Action.Type action;
	
	protected Node editRuleNode;
	
	// Action-Graph:
	
	protected ActionGraph actionGraph;
	
	protected ChangePatternObject change;
	
	protected List<ChangePatternAttributeValueChange> attributeChanges;
	
	protected List<ActionNode> adjacents = new ArrayList<>();
	
	protected List<List<ActionEdge>> inzidentsPerAdjacent = new ArrayList<>();
	
	// Change-Pattern:
	
	protected NodePattern nodePatternA;
	
	protected NodePattern correspondence;
	
	protected NodePattern nodePatternB;
	
	// Helper:
	
	protected LiftingGraphIndex changeIndex;
	
	public ActionNode(ActionGraph actionGraph, Node editRuleNode, Map<Node, ActionNode> nodeTrace) {
		this.action = editRuleNode.getAction().getType();
		this.editRuleNode = editRuleNode;
		
		// Update trace:
		nodeTrace.put(editRuleNode, this);
		
		// Get helper:
		this.changeIndex = actionGraph.getChangeIndex();
		
		// Create change-pattern //
		
		// TODO: A attributes? -> A OR B
		
		// B node-pattern:
		this.nodePatternB = GraphpatternFactory.eINSTANCE.createNodePattern();
		this.nodePatternB.setName("B." + editRuleNode.getName());
		this.nodePatternB.setType(editRuleNode.getType());
		
		// B attributes:
		for (Attribute requiredAttribute : ChangePatternUtil.getPreservedAttributes(editRuleNode)) {
			AttributePattern attributePattern = GraphpatternFactory.eINSTANCE.createAttributePattern();
			attributePattern.setNode(nodePatternB);
			attributePattern.setType(requiredAttribute.getType());
			attributePattern.setValue(requiredAttribute.getValue());
		}
		
		if (action.equals(Type.DELETE) || action.equals(Type.PRESERVE)) {
			
			// A node-pattern:
			this.nodePatternA = GraphpatternFactory.eINSTANCE.createNodePattern();
			this.nodePatternA.setName("A." + editRuleNode.getName());
			this.nodePatternA.setType(editRuleNode.getType());
			
			// Correspondence node-pattern:
			this.correspondence = GraphpatternFactory.eINSTANCE.createNodePattern();
			this.correspondence.setName(editRuleNode.getName());
			this.correspondence.setType(MatchingModelPackage.eINSTANCE.getCorrespondence());
			
			EdgePattern matchedA = GraphpatternFactory.eINSTANCE.createEdgePattern();
			matchedA.setType(MatchingModelPackage.eINSTANCE.getCorrespondence_MatchedA());
			matchedA.setSource(correspondence);
			matchedA.setTarget(nodePatternA);
			
			EdgePattern matchedB = GraphpatternFactory.eINSTANCE.createEdgePattern();
			matchedB.setType(MatchingModelPackage.eINSTANCE.getCorrespondence_MatchedB());
			matchedB.setSource(correspondence);
			matchedB.setTarget(nodePatternB);
		}
		
		// Create action-graph //
		this.actionGraph = actionGraph;
		
		// Create node change-pattern:
		if (action.equals(Type.DELETE)) {
			this.change = new ChangePatternRemoveObject(this);
		} else if (action.equals(Type.CREATE)) {
			this.change = new ChangePatternAddObject(this);
		}
		
		// Create attribute value change pattern:
		// Content check: value1->value2
		for (AttributePair attribute : ChangePatternUtil.getChangingAttributes(editRuleNode)) {
			if (attributeChanges == null) {
				attributeChanges = new ArrayList<>(5);
			}
			attributeChanges.add(new ChangePatternAttributeValueChange(this, attribute));
		}
	}

	public Action.Type getAction() {
		return action;
	}

	public Node getEditRuleNode() {
		return editRuleNode;
	}

	public ActionGraph getActionGraph() {
		return actionGraph;
	}

	public ChangePatternObject getChange() {
		return change;
	}
	
	public List<ChangePatternAttributeValueChange> getAttributeChanges() {
		return attributeChanges;
	}

	public NodePattern getNodePatternA() {
		return nodePatternA;
	}

	public NodePattern getCorrespondence() {
		return correspondence;
	}

	public NodePattern getNodePatternB() {
		return nodePatternB;
	}

	public void addAdjacent(ActionNode adjacent, ActionEdge incident) {
		
		if (!isIncomingOpposite(incident)) {
			int index = adjacents.indexOf(adjacent);
			
			if (index == -1) {
				index = adjacents.size();
				adjacents.add(adjacent);
				inzidentsPerAdjacent.add(new ArrayList<>());
			}
			
			if (!inzidentsPerAdjacent.get(index).contains(incident)) {
				inzidentsPerAdjacent.get(index).add(incident);
			}
		}
	}
	
	private boolean isIncomingOpposite(ActionEdge incident) {
		return (incident.getTarget() == this) && (incident.getOpposite() != null);
	}
	
	public void addMatchContextA(EObject matchA) {
		if (DebugUtil.ACTIVE) DebugUtil.printEvaluationStepContextA(this, matchA);
		
		// Add match for model A:
		boolean domainHasChanged = false;
		
		if (nodePatternA != null) {
			Domain domainA = Domain.get(nodePatternA);
			
			if (domainA.isCollecting()) {
				domainHasChanged = domainA.addSearchedMatch(matchA);
			} else {
				domainHasChanged = domainA.searched(matchA);
			}
		}
		
		// Add synchronize correspondences and model B:
		if (domainHasChanged && (correspondence != null)) {
			Domain domainCorrespondence = Domain.get(correspondence);
			Domain domainB = Domain.get(nodePatternB);
			
			Correspondence correspondence = changeIndex.getCorrespondenceA(matchA);

			if (correspondence != null) {
				if (!domainCorrespondence.containsMatch(correspondence, SelectionType.SEARCHED)) {
					if (domainCorrespondence.isCollecting()) {
						domainCorrespondence.addSearchedMatch(correspondence);
						domainB.addSearchedMatch(correspondence.getMatchedB());
					}  else {
						domainCorrespondence.searched(correspondence);
						domainB.searched(correspondence.getMatchedB());
					}
				}
			}
		}
	}
	
	public void addMatchContextB(EObject matchB) {
		if (DebugUtil.ACTIVE) DebugUtil.printEvaluationStepContextB(this, matchB);
		
		// Add match for model B:
		boolean domainHasChanged = false;
		
		if (nodePatternB != null) {
			Domain domainB = Domain.get(nodePatternB);
			
			if (domainB.isCollecting()) {
				domainHasChanged = domainB.addSearchedMatch(matchB);
			} else {
				domainHasChanged = domainB.searched(matchB);
			}
		}
		
		// Add synchronize correspondences and model B:
		if (domainHasChanged && (correspondence != null)) {
			Domain domainCorrespondence = Domain.get(correspondence);
			Domain domainA = Domain.get(nodePatternA);
			
			Correspondence correspondence = changeIndex.getCorrespondenceB(matchB);
			
			if (correspondence != null) {
				if (!domainCorrespondence.containsMatch(correspondence, SelectionType.SEARCHED)) {
					if (domainCorrespondence.isCollecting()) {
						domainCorrespondence.addSearchedMatch(correspondence);
						domainA.addSearchedMatch(correspondence.getMatchedA());
					}  else {
						domainCorrespondence.searched(correspondence);
						domainA.searched(correspondence.getMatchedA());
					}
				}
			}
		}
	}

	public void searchPaths(ChangePattern selected, ActionNode start, Set<ActionNode> path) {
		if (DebugUtil.ACTIVE) DebugUtil.printEvaluationStep(this);
		
		path.add(this);
		
		for (int i = 0; i < adjacents.size(); i++) {
			List<ActionEdge> inzidents = inzidentsPerAdjacent.get(i);
			ActionNode adjacent = adjacents.get(i);
			
			// do evaluation step to adjacent node:
			if (!path.contains(adjacent)) {
				
				// evaluate incident edges:
				for (ActionEdge inzident : inzidents) {
					inzident.doEvaluationStep(selected, this);
				}
				
				// evaluate object-change:
				if ((change != null) && (change != selected)) {
					change.doEvaluationStep();
				}
				
				// evaluate attribute-changes:
				if (attributeChanges != null) {
					for (ChangePatternAttributeValueChange attributeChange : attributeChanges) {
						if (attributeChanges != selected) {
							attributeChange.doEvaluationStep();
						}
					}
				}
				
				// DFS: evaluate next node:
				// (Only if the path could be extended.)
				if (hasNewMatches(adjacent)) {
					adjacent.searchPaths(selected, start, path);
				}
			}
		}
		
		// DFS: backtracking:
		path.remove(this);
		
		// Commit searched path to domain:
		if (nodePatternB != null) {
			Domain.get(nodePatternB).markSearched();
		}
		if (nodePatternA != null) {
			Domain.get(nodePatternA).markSearched();
		}
		if (correspondence != null) {
			Domain.get(correspondence).markSearched();
		}
	}
	
	private boolean hasNewMatches(ActionNode adjacent) {
		if (adjacent.getNodePatternA() != null) {
			if (Domain.get(adjacent.getNodePatternA()).containsAnySearched()) {
				return true;
			}
		}
		if (adjacent.getNodePatternB() != null) {
			if (Domain.get(adjacent.getNodePatternB()).containsAnySearched()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "<<" + action.toString() + ">> " + editRuleNode.toString();
	}
}
