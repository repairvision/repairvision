/**
 */
package org.sidiff.repair.model.repairjob;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.difference.symmetric.SymmetricDifference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repair Job</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.RepairJob#getDifference <em>Difference</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.RepairJob#getEditRules <em>Edit Rules</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepairJob()
 * @model
 * @generated
 */
public interface RepairJob extends EObject {
	/**
	 * Returns the value of the '<em><b>Difference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Difference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Difference</em>' reference.
	 * @see #setDifference(SymmetricDifference)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepairJob_Difference()
	 * @model
	 * @generated
	 */
	SymmetricDifference getDifference();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.RepairJob#getDifference <em>Difference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Difference</em>' reference.
	 * @see #getDifference()
	 * @generated
	 */
	void setDifference(SymmetricDifference value);

	/**
	 * Returns the value of the '<em><b>Edit Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.repair.model.repairjob.EditRule}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.repair.model.repairjob.EditRule#getRepairJob <em>Repair Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edit Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edit Rules</em>' containment reference list.
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepairJob_EditRules()
	 * @see org.sidiff.repair.model.repairjob.EditRule#getRepairJob
	 * @model opposite="repairJob" containment="true"
	 * @generated
	 */
	EList<EditRule> getEditRules();

} // RepairJob
