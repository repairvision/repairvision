/**
 */
package org.sidiff.repair.model.repairjob;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inconsistency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.Inconsistency#getRepairs <em>Repairs</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getInconsistency()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Inconsistency extends EObject {
	/**
	 * Returns the value of the '<em><b>Repairs</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.repair.model.repairjob.RepairOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repairs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repairs</em>' reference list.
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getInconsistency_Repairs()
	 * @model
	 * @generated
	 */
	EList<RepairOperation> getRepairs();

} // Inconsistency
