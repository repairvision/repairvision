package org.sidiff.revision.editrules.recognition.pattern.graph;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;

public class ActionEdge extends ActionGraphElement {
	
	protected ActionGraph actionGraph;
	
	protected Action.Type action;
	
	protected Edge editRuleEdge;
	
	protected ActionNode source;
	
	protected ActionNode target;
	
	protected ActionEdge opposite;
	
	protected ChangePatternReference change;
	
	protected EdgePattern edgePatternA;
	
	protected EdgePattern edgePatternB;
	
	public ActionEdge(Action.Type action, ActionGraph actionGraph, Edge editRuleEdge, Map<Node, ActionNode> nodeTrace, Map<Edge, ActionEdge> edgeTrace) {
		this.actionGraph = actionGraph;
		this.editRuleEdge = editRuleEdge;
		
		// create action-edge:
		this.action = action;
		this.source = nodeTrace.get(HenshinRuleAnalysisUtil.tryLHS(editRuleEdge.getSource()));
		this.target = nodeTrace.get(HenshinRuleAnalysisUtil.tryLHS(editRuleEdge.getTarget()));
		
		// update trace:
		edgeTrace.put(editRuleEdge, this);
		
		// edge-pattern:
		if (action.equals(Type.DELETE) || action.equals(Type.PRESERVE)) {
			
			// A edge-pattern:
			this.edgePatternA = GraphpatternFactory.eINSTANCE.createEdgePattern();
			this.edgePatternA.setSource(source.getNodePatternA());
			this.edgePatternA.setTarget(target.getNodePatternA());
			this.edgePatternA.setType(editRuleEdge.getType());
			
		} 
		
		if (action.equals(Type.CREATE) || action.equals(Type.DELETE) || action.equals(Type.PRESERVE)) {
			
			// B edge-pattern:
			this.edgePatternB = GraphpatternFactory.eINSTANCE.createEdgePattern();
			this.edgePatternB.setSource(source.getNodePatternB());
			this.edgePatternB.setTarget(target.getNodePatternB());
			this.edgePatternB.setType(editRuleEdge.getType());
		}
		
		// create change-pattern:
		if (action.equals(Type.DELETE)) {
			this.change = new ChangePatternRemoveReference(this);
		} else if (action.equals(Type.CREATE)) {
			this.change = new ChangePatternAddReference(this);
		}
		
		// Set opposites:
		if (editRuleEdge.getType().getEOpposite() != null) {
			Edge opposite = editRuleEdge.getTarget().getOutgoing(
					editRuleEdge.getType().getEOpposite(), editRuleEdge.getSource());
			
			if (opposite != null) {
				if (edgeTrace.containsKey(opposite)) {
					this.opposite = edgeTrace.get(opposite);
					
					if (this.opposite != null) {
						this.opposite.setOpposite(this);
						
						if (edgePatternA != null) {
							edgePatternA.setOpposite(this.opposite.getEdgePatternA());
							this.opposite.getEdgePatternA().setOpposite(edgePatternA);
						}
						if (edgePatternB != null) {
							edgePatternB.setOpposite(this.opposite.getEdgePatternB());
							this.opposite.getEdgePatternB().setOpposite(edgePatternB);
						}
					}
				}
			}
		}
	}
	
	public ActionGraph getActionGraph() {
		return actionGraph;
	}

	public Action.Type getAction() {
		return action;
	}

	public Edge getEditRuleEdge() {
		return editRuleEdge;
	}

	public ActionNode getSource() {
		return source;
	}

	public ActionNode getTarget() {
		return target;
	}
	
	public ActionEdge getOpposite() {
		return opposite;
	}
	
	public void setOpposite(ActionEdge opposite) {
		this.opposite = opposite;
	}

	public ChangePatternReference getChange() {
		return change;
	}

	public EdgePattern getEdgePatternA() {
		return edgePatternA;
	}
	
	public EdgePattern getEdgePatternB() {
		return edgePatternB;
	}

	/**
	 * @param stepSource
	 *            The start node of the step (to determine the step direction).
	 * @param stepTarget
	 *            The end node of the step (to determine the step direction).
	 */
	public void doEvaluationStep(ActionNode stepSource, ActionNode stepTarget) {
		
		// evaluate edge-changes:
		if (change != null) {
			change.doEvaluationStep(stepSource, stepTarget);
		}

		// evaluate context node (delete or preserve node):
		matchContext(stepSource, stepTarget);
	}
	
	private void matchContext(ActionNode stepSource, ActionNode stepTarget) {
		if (action.equals(Type.DELETE) || action.equals(Type.PRESERVE)) {
			
			// evaluate model A edge and synchronize correspondences:
			Iterator<? extends EObject> matchedA = Domain.get(stepSource.getNodePatternA()).getSearchedMatchIterator();
			calculateMatchingA(stepSource, stepTarget, matchedA);
			
			// evaluate model B edge and synchronize correspondences:
			Iterator<? extends EObject> matchedB = Domain.get(stepSource.getNodePatternB()).getSearchedMatchIterator();
			calculateMatchingB(stepSource, stepTarget, matchedB);
		}
	}
	
	private void calculateMatchingA(ActionNode stepSource, ActionNode stepTarget, Iterator<? extends EObject> sourceMatches) {
		
		if (stepTarget.getNodePatternA() != null) {
			while (sourceMatches.hasNext()) {
				Iterator<? extends EObject> targetMatches = actionGraph.getMatchingHelper()
						.getTargetsA(sourceMatches.next(), stepSource.getNodePatternA(), edgePatternA);
				
				while (targetMatches.hasNext()) {
					stepTarget.addMatchContextA(targetMatches.next());
				}
			}
		}
	}
	
	private void calculateMatchingB(ActionNode stepSource, ActionNode stepTarget, Iterator<? extends EObject> sourceMatches) {
		
		if (stepTarget.getNodePatternB() != null) {
			while (sourceMatches.hasNext()) {
				Iterator<? extends EObject> targetMatches = actionGraph.getMatchingHelper()
						.getTargetsB(sourceMatches.next(), stepSource.getNodePatternB(), edgePatternB);
				
				while (targetMatches.hasNext()) {
					stepTarget.addMatchContextB(targetMatches.next());
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "<<" + action.toString() + ">> " + editRuleEdge.toString();
	}
}
