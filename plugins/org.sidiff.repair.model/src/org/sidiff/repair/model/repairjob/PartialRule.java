/**
 */
package org.sidiff.repair.model.repairjob;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partial Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.PartialRule#getChange <em>Change</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getPartialRule()
 * @model
 * @generated
 */
public interface PartialRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Change</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.repair.model.repairjob.Change}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change</em>' containment reference list.
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getPartialRule_Change()
	 * @model containment="true"
	 * @generated
	 */
	EList<Change> getChange();

} // PartialRule
