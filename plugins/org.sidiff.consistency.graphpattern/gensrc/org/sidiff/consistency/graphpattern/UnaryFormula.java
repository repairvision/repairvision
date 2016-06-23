/**
 */
package org.sidiff.consistency.graphpattern;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.UnaryFormula#getChild <em>Child</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getUnaryFormula()
 * @model abstract="true"
 * @generated
 */
public interface UnaryFormula extends Formula {
	/**
	 * Returns the value of the '<em><b>Child</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child</em>' containment reference.
	 * @see #setChild(Formula)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getUnaryFormula_Child()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Formula getChild();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.UnaryFormula#getChild <em>Child</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child</em>' containment reference.
	 * @see #getChild()
	 * @generated
	 */
	void setChild(Formula value);

} // UnaryFormula
