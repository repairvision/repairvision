/**
 */
package org.sidiff.consistency.graphpattern;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.GraphConstraint#getGraphPredicates <em>Graph Predicates</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphConstraint()
 * @model
 * @generated
 */
public interface GraphConstraint extends Formula {
	/**
	 * Returns the value of the '<em><b>Graph Predicates</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.consistency.graphpattern.GraphPredicate}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.GraphPredicate#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Predicates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph Predicates</em>' reference list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphConstraint_GraphPredicates()
	 * @see org.sidiff.consistency.graphpattern.GraphPredicate#getConstraints
	 * @model opposite="constraints" required="true"
	 * @generated
	 */
	EList<GraphPredicate> getGraphPredicates();

} // GraphConstraint
