/**
 */
package org.sidiff.repair.model.repairjob;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.SubRule#getRepairOperation <em>Repair Operation</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.SubRule#getMatch <em>Match</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getSubRule()
 * @model
 * @generated
 */
public interface SubRule extends PartialRule {
	/**
	 * Returns the value of the '<em><b>Repair Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.repair.model.repairjob.RepairOperation#getSubRule <em>Sub Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repair Operation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repair Operation</em>' container reference.
	 * @see #setRepairOperation(RepairOperation)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getSubRule_RepairOperation()
	 * @see org.sidiff.repair.model.repairjob.RepairOperation#getSubRule
	 * @model opposite="subRule" transient="false"
	 * @generated
	 */
	RepairOperation getRepairOperation();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.SubRule#getRepairOperation <em>Repair Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repair Operation</em>' container reference.
	 * @see #getRepairOperation()
	 * @generated
	 */
	void setRepairOperation(RepairOperation value);

	/**
	 * Returns the value of the '<em><b>Match</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match</em>' containment reference.
	 * @see #setMatch(Match)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getSubRule_Match()
	 * @model containment="true"
	 * @generated
	 */
	Match getMatch();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.SubRule#getMatch <em>Match</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match</em>' containment reference.
	 * @see #getMatch()
	 * @generated
	 */
	void setMatch(Match value);

} // SubRule
