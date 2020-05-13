/**
 */
package org.sidiff.revision.changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Node Domain Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sidiff.revision.changes.ChangesPackage#getAttributeNodeDomainDefinition()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AttributeNodeDomainDefinition extends AttributeDomain {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean nodeDomainContains(EObject node);

} // AttributeNodeDomainDefinition
