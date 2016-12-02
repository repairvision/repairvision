/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getVisitor()
 * @model abstract="true"
 * @generated
 */
public interface Visitor extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visit(Evaluation evaluation);

} // Visitor
