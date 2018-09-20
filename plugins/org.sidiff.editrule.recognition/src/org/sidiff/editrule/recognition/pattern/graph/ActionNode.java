package org.sidiff.editrule.recognition.pattern.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.henshin.view.AttributePair;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.editrule.recognition.pattern.domain.Domain;
import org.sidiff.editrule.recognition.pattern.domain.Domain.SelectionType;
import org.sidiff.editrule.recognition.pattern.graph.path.MatchingPath;
import org.sidiff.editrule.recognition.util.debug.DebugUtil;
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
	
	protected List<ActionAttributeConstraint> attributeConstraints = new ArrayList<>();
	
	// Change-Pattern:
	
	protected NodePattern nodePatternA;
	
	protected NodePattern correspondence;
	
	protected NodePattern nodePatternB;
	
	public ActionNode(ActionGraph actionGraph, Node editRuleNode, Map<Node, ActionNode> nodeTrace) {
		this.action = editRuleNode.getAction().getType();
		this.editRuleNode = editRuleNode;
		
		// Update trace:
		nodeTrace.put(editRuleNode, this);
		
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
	
	public List<ActionEdge> getIncident(ActionNode adjacent) {
		int inzidentIndex = adjacents.indexOf(adjacent);
		
		if (inzidentIndex != -1) {
			return inzidentsPerAdjacent.get(inzidentIndex);
		} else {
			return Collections.emptyList();
		}
	}
	
	public List<ActionAttributeConstraint> getAttributeConstraints() {
		return attributeConstraints;
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
	
	public void addMatchContextA(EObject matchA) {
		if (DebugUtil.ACTIVE) DebugUtil.printEvaluationStepContextA(this, matchA);
		
		// Add match for model A:
		boolean domainHasChanged = false;
		boolean isCollecting = false;
		
		if (nodePatternA != null) {
			Domain domainA = Domain.get(nodePatternA);
			isCollecting = domainA.isCollecting();
			
			if (isCollecting) {
				domainHasChanged = domainA.addSearchedMatch(matchA);
			} else {
				domainHasChanged = domainA.searched(matchA);
			}
		}
		
		// Add synchronize correspondences and model B:
		EObject matchB = null;
		Correspondence correspondenceObj = null;
		
		if (domainHasChanged && (correspondence != null)) {
			Domain domainCorrespondence = Domain.get(correspondence);
			Domain domainB = Domain.get(nodePatternB);
			
			correspondenceObj = actionGraph.getRevision().getDifference().getCorrespondenceA(matchA);

			if (correspondenceObj != null) {
				if (!domainCorrespondence.contains(correspondenceObj, SelectionType.SEARCHED)) {
					matchA = correspondenceObj.getMatchedB();
					
					if (isCollecting) {
						domainCorrespondence.addSearchedMatch(correspondenceObj);
						domainB.addSearchedMatch(matchA);
					}  else {
						domainCorrespondence.searched(correspondenceObj);
						domainB.searched(matchA);
					}
				}
			}
		}
		
		// Check attribute constraints:
		if (domainHasChanged && isCollecting) {
			if (!checkAttributeConstraints(matchA, matchB)) {
				Domain domainA = Domain.get(nodePatternA);
				domainA.remove(matchA);
				
				if (correspondence != null) {
					Domain domainCorrespondence = Domain.get(correspondence);
					domainCorrespondence.remove(correspondenceObj);
					
					Domain domainB = Domain.get(nodePatternB);
					domainB.remove(matchB);
				}
			}
		}
	}
	
	public void addMatchContextB(EObject matchB) {
		if (DebugUtil.ACTIVE) DebugUtil.printEvaluationStepContextB(this, matchB);
		
		// Add match for model B:
		boolean domainHasChanged = false;
		boolean isCollecting = false;
		
		if (nodePatternB != null) {
			Domain domainB = Domain.get(nodePatternB);
			isCollecting = domainB.isCollecting();
			
			if (isCollecting) {
				domainHasChanged = domainB.addSearchedMatch(matchB);
			} else {
				domainHasChanged = domainB.searched(matchB);
			}
		}
		
		// Add synchronize correspondences and model B:
		EObject matchA = null;
		Correspondence correspondenceObj = null;
		
		if (domainHasChanged && (correspondence != null)) {
			Domain domainCorrespondence = Domain.get(correspondence);
			Domain domainA = Domain.get(nodePatternA);
			
			correspondenceObj = actionGraph.getRevision().getDifference().getCorrespondenceB(matchB);
			
			if (correspondenceObj != null) {
				if (!domainCorrespondence.contains(correspondenceObj, SelectionType.SEARCHED)) {
					matchA = correspondenceObj.getMatchedA();
					
					if (isCollecting) {
						domainCorrespondence.addSearchedMatch(correspondenceObj);
						domainA.addSearchedMatch(matchA);
					}  else {
						domainCorrespondence.searched(correspondenceObj);
						domainA.searched(matchA);
					}
				}
			}
		}
		
		// Check attribute constraints:
		if (domainHasChanged && isCollecting) {
			if (!checkAttributeConstraints(matchA, matchB)) {
				Domain domainB = Domain.get(nodePatternB);
				domainB.remove(matchB);
				
				if (correspondence != null) {
					Domain domainCorrespondence = Domain.get(correspondence);
					domainCorrespondence.remove(correspondenceObj);
					
					Domain domainA = Domain.get(nodePatternA);
					domainA.remove(matchA);
				}
			}
		}
	}
	
	private boolean checkAttributeConstraints(EObject matchA, EObject matchB) {
		for (ActionAttributeConstraint attributeConstraint : attributeConstraints) {
			boolean valid = false;
			
			// valid for match A OR match B?
			if (matchA != null) {
				Object valueA = matchA.eGet(attributeConstraint.getType());
				
				if (attributeConstraint.check(valueA)) {
					valid = true;
				}
			}
			
			if (matchB != null) {
				Object valueB = matchB.eGet(attributeConstraint.getType());
				
				if (attributeConstraint.check(valueB)) {
					valid = true;
				}
			}
			
			if (!valid) {
				return false;
			}
		}
		
		return true;
	}
	
	public void searchPaths(ChangePattern selected, MatchingPath path) {
		if (DebugUtil.ACTIVE) DebugUtil.printEvaluationStep(this);
		
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
		
		// DFS-Matching:
		path.add(this);
		
		for (int i = 0; i < adjacents.size(); i++) {
			ActionNode adjacent = adjacents.get(i);
			
			// do evaluation step to adjacent node:
			if (!path.contains(adjacent)) {
				
				// evaluate incident edges:
				List<ActionEdge> inzidents = inzidentsPerAdjacent.get(i);
				
				for (ActionEdge inzident : inzidents) {
					inzident.doEvaluationStep(this, adjacent);
				}
				
				// DFS: evaluate next node:
				// (Only if the path could be extended.)
				if (hasNewMatches(adjacent)) {
					adjacent.searchPaths(selected, path);
				}
			}
		}
		
		// DFS-Backtracking:
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
