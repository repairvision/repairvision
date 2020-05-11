/**
 */
package org.sidiff.revision.changes;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Context</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sidiff.revision.changes.ChangesPackage#getChangeContext()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ChangeContext extends NodeChangeContext, EdgeChangeContext, AttributeChangeContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ActionType getAction(Change change);

} // ChangeContext
