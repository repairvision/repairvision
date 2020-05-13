/**
 */
package org.sidiff.revision.changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Source Domain Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.sidiff.revision.changes.ChangesPackage#getEdgeSourceDomainDefinition()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EdgeSourceDomainDefinition extends EdgeDomain {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	boolean sourceDomainContains(EObject sourceNode);

} // EdgeSourceDomainDefinition
