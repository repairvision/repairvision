/**
 */
package org.sidiff.repair.model.repairjob;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.Repair#getRepairOperation <em>Repair Operation</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepair()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Repair extends EObject {
	/**
	 * Returns the value of the '<em><b>Repair Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.repair.model.repairjob.RepairOperation#getRepairs <em>Repairs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repair Operation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repair Operation</em>' container reference.
	 * @see #setRepairOperation(RepairOperation)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepair_RepairOperation()
	 * @see org.sidiff.repair.model.repairjob.RepairOperation#getRepairs
	 * @model opposite="repairs" transient="false"
	 * @generated
	 */
	RepairOperation getRepairOperation();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.Repair#getRepairOperation <em>Repair Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repair Operation</em>' container reference.
	 * @see #getRepairOperation()
	 * @generated
	 */
	void setRepairOperation(RepairOperation value);

} // Repair
