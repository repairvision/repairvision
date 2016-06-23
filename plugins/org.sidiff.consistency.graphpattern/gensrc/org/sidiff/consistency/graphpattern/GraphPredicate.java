/**
 */
package org.sidiff.consistency.graphpattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.GraphPredicate#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.GraphPredicate#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.GraphPredicate#getQuantifier <em>Quantifier</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphPredicate()
 * @model abstract="true"
 * @generated
 */
public interface GraphPredicate extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphPredicate_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.GraphPredicate#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.consistency.graphpattern.GraphConstraint}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.GraphConstraint#getGraphPredicates <em>Graph Predicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' reference list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphPredicate_Constraints()
	 * @see org.sidiff.consistency.graphpattern.GraphConstraint#getGraphPredicates
	 * @model opposite="graphPredicates"
	 * @generated
	 */
	EList<GraphConstraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Quantifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantifier</em>' reference.
	 * @see #setQuantifier(Quantifier)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphPredicate_Quantifier()
	 * @model
	 * @generated
	 */
	Quantifier getQuantifier();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.GraphPredicate#getQuantifier <em>Quantifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantifier</em>' reference.
	 * @see #getQuantifier()
	 * @generated
	 */
	void setQuantifier(Quantifier value);

} // GraphPredicate
