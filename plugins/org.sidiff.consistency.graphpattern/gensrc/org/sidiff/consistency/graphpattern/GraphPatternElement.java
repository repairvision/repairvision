/**
 */
package org.sidiff.consistency.graphpattern;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Pattern Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.GraphPatternElement#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.GraphPatternElement#getFormulas <em>Formulas</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.GraphPatternElement#getQuantifier <em>Quantifier</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphPatternElement()
 * @model abstract="true"
 * @generated
 */
public interface GraphPatternElement extends EObject {
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
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphPatternElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.GraphPatternElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Formulas</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.consistency.graphpattern.GraphFormula}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.GraphFormula#getPredicates <em>Predicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formulas</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formulas</em>' reference list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphPatternElement_Formulas()
	 * @see org.sidiff.consistency.graphpattern.GraphFormula#getPredicates
	 * @model opposite="predicates"
	 * @generated
	 */
	EList<GraphFormula> getFormulas();

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
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphPatternElement_Quantifier()
	 * @model
	 * @generated
	 */
	Quantifier getQuantifier();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.GraphPatternElement#getQuantifier <em>Quantifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantifier</em>' reference.
	 * @see #getQuantifier()
	 * @generated
	 */
	void setQuantifier(Quantifier value);

} // GraphPatternElement
