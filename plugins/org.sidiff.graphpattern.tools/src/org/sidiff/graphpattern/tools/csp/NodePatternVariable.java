package org.sidiff.graphpattern.tools.csp;

import org.eclipse.emf.ecore.EReference;
import org.sidiff.csp.solver.IDomain;
import org.sidiff.csp.solver.IVariable;
import org.sidiff.csp.solver.impl.Variable;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;

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
				if (!checkOutgoing(assignment, outgoing.getType(), adjacentAssignment)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean checkOutgoing(NodePattern nodeA, EReference type, NodePattern nodeB) {
		for (EdgePattern nodeAOutgoing : nodeA.getOutgoings()) {
			if (nodeAOutgoing.getType() == type) {
				if (nodeAOutgoing.getTarget() == nodeB) {
					return true;
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
			
			if (adjacentAssignment != null) {
				// Check assigned value:
				if (!checkIncoming(assignment, incoming.getType(), adjacentAssignment)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean checkIncoming(NodePattern nodeA, EReference type, NodePattern nodeB) {
		for (EdgePattern nodeAIncoming : nodeA.getIncomings()) {
			if (nodeAIncoming.getType() == type) {
				if (nodeAIncoming.getSource() == nodeB) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean applyRestrictions() {
		// TODO: Calculate structural restrictions...
		return super.applyRestrictions();
	}
}
