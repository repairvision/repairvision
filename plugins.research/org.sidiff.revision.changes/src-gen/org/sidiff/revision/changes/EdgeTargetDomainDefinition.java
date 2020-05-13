/**
 */
package org.sidiff.revision.changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Target Domain Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sidiff.revision.changes.ChangesPackage#getEdgeTargetDomainDefinition()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EdgeTargetDomainDefinition extends EdgeDomain {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean targetDomainContains(EObject targetNode);

} // EdgeTargetDomainDefinition
