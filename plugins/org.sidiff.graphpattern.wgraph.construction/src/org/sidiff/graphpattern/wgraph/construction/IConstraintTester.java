package org.sidiff.graphpattern.wgraph.construction;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.NodePattern;

/**
 * Check types and other constraints.
 * 
 * @author Manuel Ohrndorf
 */
public interface IConstraintTester {
	
	/**
	 * Check types and other constraints.
	 * 
	 * @param node
	 *            The node to test.
	 * @param object
	 *            A potential match for the given node.
	 * @return <code>true</code> if the given object is a potential match;
	 *         <code>false</code> otherwise.
	 */
	public boolean check(NodePattern node, EObject object);
}
