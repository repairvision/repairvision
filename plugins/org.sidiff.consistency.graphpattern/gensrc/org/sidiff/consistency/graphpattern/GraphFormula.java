/**
 */
package org.sidiff.consistency.graphpattern;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.GraphFormula#getPredicates <em>Predicates</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphFormula()
 * @model
 * @generated
 */
public interface GraphFormula extends Formula {
	/**
	 * Returns the value of the '<em><b>Predicates</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.consistency.graphpattern.GraphPatternElement}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.GraphPatternElement#getFormulas <em>Formulas</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicates</em>' reference list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getGraphFormula_Predicates()
	 * @see org.sidiff.consistency.graphpattern.GraphPatternElement#getFormulas
	 * @model opposite="formulas" required="true"
	 * @generated
	 */
	EList<GraphPatternElement> getPredicates();

} // GraphFormula
