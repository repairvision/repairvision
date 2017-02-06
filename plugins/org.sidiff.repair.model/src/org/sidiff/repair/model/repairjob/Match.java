/**
 */
package org.sidiff.repair.model.repairjob;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.Match#getChange <em>Change</em>}</li>
 *   <li>{@link org.sidiff.repair.model.repairjob.Match#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getMatch()
 * @model
 * @generated
 */
public interface Match extends EObject {
	/**
	 * Returns the value of the '<em><b>Change</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.repair.model.repairjob.Change}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change</em>' reference list.
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getMatch_Change()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<Change> getChange();

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getMatch_Elements()
	 * @model
	 * @generated
	 */
	EList<EObject> getElements();

} // Match
