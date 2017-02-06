/**
 */
package org.sidiff.repair.model.repairjob;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.henshin.model.Rule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edit Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.EditRule#getRule <em>Rule</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.EditRule#getRepairJob <em>Repair Job</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.EditRule#getRepairOperations <em>Repair Operations</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getEditRule()
 * @model
 * @generated
 */
public interface EditRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' reference.
	 * @see #setRule(Rule)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getEditRule_Rule()
	 * @model
	 * @generated
	 */
	Rule getRule();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.EditRule#getRule <em>Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(Rule value);

	/**
	 * Returns the value of the '<em><b>Repair Job</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.repair.model.repairjob.RepairJob#getEditRules <em>Edit Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repair Job</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repair Job</em>' container reference.
	 * @see #setRepairJob(RepairJob)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getEditRule_RepairJob()
	 * @see org.sidiff.repair.model.repairjob.RepairJob#getEditRules
	 * @model opposite="editRules" transient="false"
	 * @generated
	 */
	RepairJob getRepairJob();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.EditRule#getRepairJob <em>Repair Job</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repair Job</em>' container reference.
	 * @see #getRepairJob()
	 * @generated
	 */
	void setRepairJob(RepairJob value);

	/**
	 * Returns the value of the '<em><b>Repair Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.repair.model.repairjob.RepairOperation}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.repair.model.repairjob.RepairOperation#getEditRule <em>Edit Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repair Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repair Operations</em>' containment reference list.
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getEditRule_RepairOperations()
	 * @see org.sidiff.repair.model.repairjob.RepairOperation#getEditRule
	 * @model opposite="editRule" containment="true"
	 * @generated
	 */
	EList<RepairOperation> getRepairOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	double getRating();

} // EditRule
