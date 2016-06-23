/**
 */
package org.sidiff.consistency.graphpattern;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NAry Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.NAryFormula#getResults <em>Results</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.NAryFormula#getFormulas <em>Formulas</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getNAryFormula()
 * @model abstract="true"
 * @generated
 */
public interface NAryFormula extends Formula {
	/**
	 * Returns the value of the '<em><b>Results</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Boolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' attribute list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getNAryFormula_Results()
	 * @model
	 * @generated
	 */
	EList<Boolean> getResults();

	/**
	 * Returns the value of the '<em><b>Formulas</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.consistency.graphpattern.Formula}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formulas</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formulas</em>' containment reference list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getNAryFormula_Formulas()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Formula> getFormulas();

} // NAryFormula
