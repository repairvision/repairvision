/**
 */
package org.sidiff.revision.changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Change Domain Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sidiff.revision.changes.ChangesPackage#getNodeChangeDomainDefinition()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface NodeChangeDomainDefinition extends NodeDomain {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean nodeDomainContains(EObject node);

} // NodeChangeDomainDefinition
