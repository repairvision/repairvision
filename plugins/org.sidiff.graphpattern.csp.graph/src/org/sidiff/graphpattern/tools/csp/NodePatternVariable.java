package org.sidiff.graphpattern.tools.csp;

import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.csp.generic.IDomain;
import org.sidiff.graphpattern.csp.generic.IVariable;
import org.sidiff.graphpattern.csp.generic.impl.Variable;

public class NodePatternVariable extends Variable<NodePattern, NodePattern> {

	private boolean induced;
	
	/**
	 * @param induced Requires to match all edges between assigned nodes
	 *                (https://en.wikipedia.org/wiki/Induced_subgraph).
	 * 
	 * @see Variable#Variable(Object, IDomain, boolean)
	 */
	public NodePatternVariable(
			NodePattern subject, IDomain<NodePattern> domain, 
			boolean removable, boolean maximize, boolean induced) {
		super(subject, domain, removable, maximize);
		this.induced = induced;
	}
	
	@Override
	public boolean assign(NodePattern assignment) {
		
		// Check node against adjacent assignments:
		if (induced) {
			checkOutgoings(assignment);
			checkIncomings(assignment);
		}
		
		return super.assign(assignment);
	}
	
	protected boolean checkOutgoings(NodePattern assignment) {
		
		for (EdgePattern outgoing : subject.getOutgoings()) {
			NodePattern adjacentNode = outgoing.getTarget();
			IVariable<NodePattern, NodePattern> adjacentVariable = csp.getVariable(adjacentNode);
			
			// Allow to exclude nodes of the subject graph from the CSP.
			if (adjacentVariable != null) {
				NodePattern adjacentAssignment = adjacentVariable.getValue();
				
				// Check assigned value:
				if (adjacentAssignment != null) {
					if (!checkOutgoing(assignment, outgoing.getType(), outgoing.getStereotypes(), adjacentAssignment)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	protected boolean checkOutgoing(NodePattern source, EReference type, List<Stereotype> stereotypes, NodePattern target) {
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
	
	protected boolean checkIncomings(NodePattern assignment) {
		
		for (EdgePattern incoming : subject.getIncomings()) {
			NodePattern adjacentNode = incoming.getSource();
			IVariable<NodePattern, NodePattern> adjacentVariable = csp.getVariable(adjacentNode);
			
			// Allow to exclude nodes of the subject graph from the CSP.
			if (adjacentVariable != null) {
				NodePattern adjacentAssignment = adjacentVariable.getValue();
				
				// Check assigned value:
				if (adjacentAssignment != null) {
					if (!checkIncoming(assignment, incoming.getType(), incoming.getStereotypes(), adjacentAssignment)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	protected boolean checkIncoming(NodePattern target, EReference type, List<Stereotype> stereotypes, NodePattern source) {
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
