/**
 */
package org.sidiff.revision.changes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Node Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sidiff.revision.changes.ChangesPackage#getAttributeNodeDomain()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AttributeNodeDomain extends AttributeNodeDomainDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<EObject> getNodeDomain();

} // AttributeNodeDomain
