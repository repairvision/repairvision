/**
 */
package org.sidiff.repair.model.repairjob;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repair Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.RepairParameter#getChange <em>Change</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.RepairParameter#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepairParameter()
 * @model
 * @generated
 */
public interface RepairParameter extends Repair {
	/**
	 * Returns the value of the '<em><b>Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change</em>' reference.
	 * @see #setChange(Change)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepairParameter_Change()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Change getChange();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.RepairParameter#getChange <em>Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change</em>' reference.
	 * @see #getChange()
	 * @generated
	 */
	void setChange(Change value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see #setDomain(EObject)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepairParameter_Domain()
	 * @model
	 * @generated
	 */
	EObject getDomain();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.RepairParameter#getDomain <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(EObject value);

} // RepairParameter
