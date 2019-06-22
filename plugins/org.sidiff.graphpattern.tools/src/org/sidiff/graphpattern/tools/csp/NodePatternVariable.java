package org.sidiff.graphpattern.tools.csp;

import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.sidiff.csp.solver.IDomain;
import org.sidiff.csp.solver.IVariable;
import org.sidiff.csp.solver.impl.Variable;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;

public class NodePatternVariable extends Variable<NodePattern, NodePattern> {

	public NodePatternVariable(NodePattern subject, IDomain<NodePattern> domain, boolean removable) {
		super(subject, domain, removable);
	}
	
	@Override
	public boolean assign(NodePattern assignment) {
		
		// Check node against adjacent assignments:
		checkOutgoings(assignment);
		checkIncomings(assignment);
		
		return super.assign(assignment);
	}
	
	private boolean checkOutgoings(NodePattern assignment) {
		
		for (EdgePattern outgoing : subject.getOutgoings()) {
			NodePattern adjacentNode = outgoing.getTarget();
			IVariable<NodePattern, NodePattern> adjacentVariable = csp.getVariable(adjacentNode);
			NodePattern adjacentAssignment = adjacentVariable.getValue();
			
			// Check assigned value:
			if (adjacentAssignment != null) {
				if (!checkOutgoing(assignment, outgoing.getType(), outgoing.getStereotypes(), adjacentAssignment)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean checkOutgoing(NodePattern source, EReference type, List<Stereotype> stereotypes, NodePattern target) {
		for (EdgePattern sourceOutgoing : source.getOutgoings()) {
			if (sourceOutgoing.getType() == type) {
				if (sourceOutgoing.getTarget() == target) {
					if (checkStereotypes(stereotypes, sourceOutgoing.getStereotypes())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean checkIncomings(NodePattern assignment) {
		
		for (EdgePattern incoming : subject.getIncomings()) {
			NodePattern adjacentNode = incoming.getSource();
			IVariable<NodePattern, NodePattern> adjacentVariable = csp.getVariable(adjacentNode);
			NodePattern adjacentAssignment = adjacentVariable.getValue();
			
			// Check assigned value:
			if (adjacentAssignment != null) {
				if (!checkIncoming(assignment, incoming.getType(), incoming.getStereotypes(), adjacentAssignment)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean checkIncoming(NodePattern target, EReference type, List<Stereotype> stereotypes, NodePattern source) {
		for (EdgePattern targetIncoming : target.getIncomings()) {
			if (targetIncoming.getType() == type) {
				if (targetIncoming.getSource() == source) {
					if (checkStereotypes(stereotypes, targetIncoming.getStereotypes())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	protected boolean checkStereotypes(List<Stereotype> subject, List<Stereotype> assignment) {
		return true;
	}
	
	@Override
	public boolean applyRestrictions() {
		// TODO[Optimization]: Calculate structural restrictions...
		return super.applyRestrictions();
	}
}
