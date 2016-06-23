/**
 */
package org.sidiff.consistency.graphpattern;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getFormula()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Formula extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean getResult();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Formula getEmbedding();

} // Formula
