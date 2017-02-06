/**
 */
package org.sidiff.repair.model.repairjob;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repair Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.RepairOperation#getContext <em>Context</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.RepairOperation#getEditRule <em>Edit Rule</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.RepairOperation#getSubRule <em>Sub Rule</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.RepairOperation#getComplementRule <em>Complement Rule</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.RepairOperation#getRepairs <em>Repairs</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepairOperation()
 * @model
 * @generated
 */
public interface RepairOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(EObject)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepairOperation_Context()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	EObject getContext();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.RepairOperation#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(EObject value);

	/**
	 * Returns the value of the '<em><b>Edit Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.repair.model.repairjob.EditRule#getRepairOperations <em>Repair Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edit Rule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edit Rule</em>' container reference.
	 * @see #setEditRule(EditRule)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepairOperation_EditRule()
	 * @see org.sidiff.repair.model.repairjob.EditRule#getRepairOperations
	 * @model opposite="repairOperations" transient="false"
	 * @generated
	 */
	EditRule getEditRule();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.RepairOperation#getEditRule <em>Edit Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edit Rule</em>' container reference.
	 * @see #getEditRule()
	 * @generated
	 */
	void setEditRule(EditRule value);

	/**
	 * Returns the value of the '<em><b>Sub Rule</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.repair.model.repairjob.SubRule#getRepairOperation <em>Repair Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Rule</em>' containment reference.
	 * @see #setSubRule(SubRule)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepairOperation_SubRule()
	 * @see org.sidiff.repair.model.repairjob.SubRule#getRepairOperation
	 * @model opposite="repairOperation" containment="true"
	 * @generated
	 */
	SubRule getSubRule();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.RepairOperation#getSubRule <em>Sub Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Rule</em>' containment reference.
	 * @see #getSubRule()
	 * @generated
	 */
	void setSubRule(SubRule value);

	/**
	 * Returns the value of the '<em><b>Complement Rule</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.repair.model.repairjob.ComplementRule#getRepairOperation <em>Repair Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complement Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complement Rule</em>' containment reference.
	 * @see #setComplementRule(ComplementRule)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepairOperation_ComplementRule()
	 * @see org.sidiff.repair.model.repairjob.ComplementRule#getRepairOperation
	 * @model opposite="repairOperation" containment="true"
	 * @generated
	 */
	ComplementRule getComplementRule();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.RepairOperation#getComplementRule <em>Complement Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Complement Rule</em>' containment reference.
	 * @see #getComplementRule()
	 * @generated
	 */
	void setComplementRule(ComplementRule value);

	/**
	 * Returns the value of the '<em><b>Repairs</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.repair.model.repairjob.Repair}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.repair.model.repairjob.Repair#getRepairOperation <em>Repair Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repairs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repairs</em>' containment reference list.
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getRepairOperation_Repairs()
	 * @see org.sidiff.repair.model.repairjob.Repair#getRepairOperation
	 * @model opposite="repairOperation" containment="true"
	 * @generated
	 */
	EList<Repair> getRepairs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	double getRating();

} // RepairOperation
