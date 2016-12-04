/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Pattern Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.NodePatternDependency#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getNodePatternDependency()
 * @model
 * @generated
 */
public interface NodePatternDependency extends DependencyNode {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.NodePattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getNodePatternDependency_Nodes()
	 * @model
	 * @generated
	 */
	EList<NodePattern> getNodes();

} // NodePatternDependency
