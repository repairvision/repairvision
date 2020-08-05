package org.sidiff.revision.editrules.recognition.pattern.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.common.emf.MetaModelUtil;
import org.sidiff.revision.common.henshin.HenshinChangesUtil;
import org.sidiff.revision.common.henshin.pairs.AttributePair;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.DifferencePackage;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionLogger;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain.SelectionType;
import org.sidiff.revision.editrules.recognition.pattern.graph.path.MatchingPath;

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
	
	// Evaluation logging:
	
	protected RecognitionLogger logger;
	
	public ActionNode(
			Action.Type action,
			ActionGraph actionGraph,
			Node editRuleNode,
			Map<Node, ActionNode> nodeTrace,
			RecognitionLogger logger) {
		
		
		this.action = action;
		this.editRuleNode = editRuleNode;
		this.logger = logger;
		
		// Update trace:
		nodeTrace.put(editRuleNode, this);
		
		// Create change-pattern //
		
		// TODO: A attributes? -> A OR B
		
		// B node-pattern:
		this.nodePatternB = GraphpatternFactory.eINSTANCE.createNodePattern();
		this.nodePatternB.setName("B." + editRuleNode.getName());
		this.nodePatternB.setType(editRuleNode.getType());
		
		// B attributes:
		for (Attribute requiredAttribute : HenshinChangesUtil.getPreservedAttributes(editRuleNode)) {
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
			this.correspondence.setType(DifferencePackage.eINSTANCE.getCorrespondence());
			
			EdgePattern matchedA = GraphpatternFactory.eINSTANCE.createEdgePattern();
			matchedA.setType(DifferencePackage.eINSTANCE.getCorrespondence_MatchedA());
			matchedA.setSource(correspondence);
			matchedA.setTarget(nodePatternA);
			
			EdgePattern matchedB = GraphpatternFactory.eINSTANCE.createEdgePattern();
			matchedB.setType(DifferencePackage.eINSTANCE.getCorrespondence_MatchedB());
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
		for (AttributePair attribute : HenshinChangesUtil.getChangingAttributes(editRuleNode)) {
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
	
	public boolean addMatchContextA(EObject matchA) {
		return addMatchContextA(matchA, false);
	}
	
	// TODO: Cache results of tests for optimization...
	public boolean canMatchContextA(EObject matchA) {
		return addMatchContextA(matchA, true);
	}
	
	private boolean addMatchContextA(EObject matchA, boolean test) {
		if (logger.isStepwise()) logger.logEvaluationStepContextA(this, matchA);
		
		// TODO: Do a full matching of preserve/delete sub-patterns!
		
		// Add match for model B:
		if (nodePatternA != null) {
			Domain domainA = Domain.get(nodePatternA);
			SelectionType selectionType = domainA.get(matchA);
			
			boolean newMatching = domainA.isCollecting() && (selectionType == null);
			boolean selectMatching = SelectionType.isSelected(selectionType) && !selectionType.equals(SelectionType.SEARCHED);
			
			if (newMatching || selectMatching) {
				
				// New matching:
				Correspondence correspondenceObj = null;
				EObject matchB = null;
				
				if (correspondence != null) {
					correspondenceObj = actionGraph.getRevision().getDifference().getCorrespondenceA(matchA);
					matchB = (correspondenceObj != null) ? correspondenceObj.getMatchedB() : null;
				}
				
				// TODO: Do a full matching of preserve/delete sub-patterns!
				// ----> Call checkLocalContext() recursively
				
				// Check only for new matchings:
				boolean isValid = 
						   ((matchA == null) || MetaModelUtil.isAssignableTo(matchA.eClass(), nodePatternA.getType()))
						&& ((matchB == null) || MetaModelUtil.isAssignableTo(matchB.eClass(), nodePatternB.getType()))
						&& checkAttributeConstraints(matchA, matchB) 
						&& checkLocalContext(matchA, matchB);
				
				if (selectMatching || isValid) {
					selectionType = SelectionType.SEARCHED;
					
					if (!test) {
						domainA.add(matchA, selectionType);
						
						// Synchronize context:
						if (correspondenceObj != null) {
							Domain.get(correspondence).add(correspondenceObj, selectionType);
							Domain.get(nodePatternB).add(matchB, selectionType);
						}
					}
				}
			}
			
			return selectionType == SelectionType.SEARCHED;
		} else {
			return false;
		}
	}
	
	public boolean addMatchContextB(EObject matchB) {
		return addMatchContextB(matchB, false);
	}
	
	// TODO: Cache results of tests for optimization...
	public boolean canMatchContextB(EObject matchB) {
		return addMatchContextB(matchB, true);
	}
	
	private boolean addMatchContextB(EObject matchB, boolean test) {
		if (logger.isStepwise()) logger.logEvaluationStepContextB(this, matchB);
		
		// Add match for model B:
		if (nodePatternB != null) {
			Domain domainB = Domain.get(nodePatternB);
			SelectionType selectionType = domainB.get(matchB);
			
			boolean newMatching = domainB.isCollecting() && (selectionType == null);
			boolean selectMatching = SelectionType.isSelected(selectionType) && !selectionType.equals(SelectionType.SEARCHED);
			
			if (newMatching || selectMatching) {
				
				// New matching:
				Correspondence correspondenceObj = null;
				EObject matchA = null;
				
				if (correspondence != null) {
					correspondenceObj = actionGraph.getRevision().getDifference().getCorrespondenceB(matchB);
					matchA = (correspondenceObj != null) ? correspondenceObj.getMatchedA() : null;
				}
				
				// TODO: Do a full matching of preserve/delete sub-patterns!
				// ----> Call checkLocalContext() recursively
				
				// Check only for new matchings:
				boolean isValid = 
						   ((matchA == null) || MetaModelUtil.isAssignableTo(matchA.eClass(), nodePatternA.getType()))
						&& ((matchB == null) || MetaModelUtil.isAssignableTo(matchB.eClass(), nodePatternB.getType()))
						&& checkAttributeConstraints(matchA, matchB) 
						&& checkLocalContext(matchA, matchB);
				
				if (selectMatching || isValid) {
					selectionType = SelectionType.SEARCHED;
					
					if (!test) {
						domainB.add(matchB, selectionType);
						
						// Synchronize context:
						if (correspondenceObj != null) {
							Domain.get(correspondence).add(correspondenceObj, selectionType);
							Domain.get(nodePatternA).add(matchA, selectionType);
						}
					}
				}
			}
			
			return selectionType == SelectionType.SEARCHED;
		} else {
			return false;
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
	
	private boolean checkLocalContext(EObject matchA, EObject matchB) {
		
		// Check for existence of the local context in the model:
		for (List<ActionEdge> actionEdges : inzidentsPerAdjacent) {
			for (ActionEdge actionEdge : actionEdges) {
				if (actionEdge.getAction().equals(Type.PRESERVE) || actionEdge.getAction().equals(Type.DELETE)) {
					
					// Optimization: Filter incoming opposite edges:
					if (!((actionEdge.getOpposite() != null) && (actionEdge.getSource() != this))) {
						
						EClass targetType = (actionEdge.getSource() == this) ? 
								actionEdge.getEditRuleEdge().getTarget().getType() : 
								actionEdge.getEditRuleEdge().getSource().getType();
						boolean exists = false;

						// Search model A:
						if (matchA != null) {
							Iterator<? extends EObject> iterator = actionGraph.getMatchingHelper()
									.getTargetsA(matchA, nodePatternA, actionEdge.getEdgePatternA());
							
							while (iterator.hasNext()) {
								EObject targetA = (EObject) iterator.next();

								if (MetaModelUtil.isAssignableTo(targetA.eClass(), targetType)) {
									exists = true;
									break;
								}
							}
						}

						// Search model B:
						if (!exists && (matchB != null)) {
							for (Iterator<? extends EObject> iterator = actionGraph.getMatchingHelper()
									.getTargetsB(matchB, nodePatternB, actionEdge.getEdgePatternB()); iterator.hasNext();) {
								EObject targetB = (EObject) iterator.next();

								if (MetaModelUtil.isAssignableTo(targetB.eClass(), targetType)) {
									exists = true;
									break;
								}
							}
						}

						if (!exists) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
	
	public void searchPaths(ChangePattern selected, MatchingPath path) {
		if (logger.isStepwise()) logger.logEvaluationStep(this);
		
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
