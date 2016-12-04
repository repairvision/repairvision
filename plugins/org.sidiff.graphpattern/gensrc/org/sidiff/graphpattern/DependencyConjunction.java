/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Conjunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.DependencyConjunction#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyConjunction()
 * @model
 * @generated
 */
public interface DependencyConjunction extends DependencyNode {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.NodePatternDependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getDependencyConjunction_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<NodePatternDependency> getNodes();

} // DependencyConjunction
