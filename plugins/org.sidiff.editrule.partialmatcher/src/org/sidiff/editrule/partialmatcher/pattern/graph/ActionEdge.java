package org.sidiff.editrule.partialmatcher.pattern.graph;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.henshin.ChangePatternUtil;
import org.sidiff.editrule.partialmatcher.pattern.domain.Domain;
import org.sidiff.editrule.partialmatcher.util.MatchingHelper;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternFactory;

public class ActionEdge extends ActionGraphElement {
	
	protected Action.Type action;
	
	protected Edge editRuleEdge;
	
	protected ActionNode source;
	
	protected ActionNode target;
	
	protected ActionEdge opposite;
	
	protected ChangePatternReference change;
	
	protected EdgePattern edgePatternA;
	
	protected EdgePattern edgePatternB;
	
	protected MatchingHelper matchingHelper;
	
	public ActionEdge(Edge editRuleEdge, Map<Node, ActionNode> nodeTrace, Map<Edge, ActionEdge> edgeTrace) {
		this.editRuleEdge = editRuleEdge;
		
		// create action-edge:
		this.action = editRuleEdge.getAction().getType();
		this.source = nodeTrace.get(ChangePatternUtil.tryLHS(editRuleEdge.getSource()));
		this.target = nodeTrace.get(ChangePatternUtil.tryLHS(editRuleEdge.getTarget()));
		
		// update trace:
		edgeTrace.put(editRuleEdge, this);
		
		// get helper:
		this.matchingHelper = source.getActionGraph().getMatchingHelper();
		
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

	public void doEvaluationStep(ChangePattern selected, ActionNode stepSource) {
		
		// evaluate edge-change:
		if ((change != null) && (change != selected)) {
			change.doEvaluationStep(stepSource);
		}
		
		// evaluate opposite-edge-change:
		// TODO: Opposites are filtered by the node -> better solution!?
		if ((opposite != null) && (opposite.getChange() != null)) {
			opposite.getChange().doEvaluationStep(stepSource);
		}

		// evaluate context:
		if (stepSource == source) {
			matchContext(stepSource, target);
		} else {
			assert (stepSource == target);
			matchContext(stepSource, source);
		}
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
				Iterator<? extends EObject> targetMatches = matchingHelper
						.getTargets(sourceMatches.next(), stepSource.getNodePatternA(), edgePatternA);
				
				while (targetMatches.hasNext()) {
					stepTarget.addMatchContextA(targetMatches.next());
				}
			}
		}
	}
	
	private void calculateMatchingB(ActionNode stepSource, ActionNode stepTarget, Iterator<? extends EObject> sourceMatches) {
		
		if (stepTarget.getNodePatternB() != null) {
			while (sourceMatches.hasNext()) {
				Iterator<? extends EObject> targetMatches = matchingHelper
						.getTargets(sourceMatches.next(), stepSource.getNodePatternB(), edgePatternB);
				
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
