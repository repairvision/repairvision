/**
 */
package org.sidiff.consistency.graphpattern;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.BinaryFormula#getLeft <em>Left</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.BinaryFormula#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getBinaryFormula()
 * @model abstract="true"
 * @generated
 */
public interface BinaryFormula extends Formula {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Formula)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getBinaryFormula_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Formula getLeft();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.BinaryFormula#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Formula value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Formula)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getBinaryFormula_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Formula getRight();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.BinaryFormula#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Formula value);

} // BinaryFormula
