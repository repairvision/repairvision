/**
 */
package org.sidiff.repair.model.repairjob;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage
 * @generated
 */
public interface RepairjobFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RepairjobFactory eINSTANCE = org.sidiff.repair.model.repairjob.impl.RepairjobFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Repair Job</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repair Job</em>'.
	 * @generated
	 */
	RepairJob createRepairJob();

	/**
	 * Returns a new object of class '<em>Edit Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edit Rule</em>'.
	 * @generated
	 */
	EditRule createEditRule();

	/**
	 * Returns a new object of class '<em>Repair Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repair Operation</em>'.
	 * @generated
	 */
	RepairOperation createRepairOperation();

	/**
	 * Returns a new object of class '<em>Partial Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partial Rule</em>'.
	 * @generated
	 */
	PartialRule createPartialRule();

	/**
	 * Returns a new object of class '<em>Sub Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Rule</em>'.
	 * @generated
	 */
	SubRule createSubRule();

	/**
	 * Returns a new object of class '<em>Complement Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complement Rule</em>'.
	 * @generated
	 */
	ComplementRule createComplementRule();

	/**
	 * Returns a new object of class '<em>Repair Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repair Match</em>'.
	 * @generated
	 */
	RepairMatch createRepairMatch();

	/**
	 * Returns a new object of class '<em>Repair Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repair Parameter</em>'.
	 * @generated
	 */
	RepairParameter createRepairParameter();

	/**
	 * Returns a new object of class '<em>Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Change</em>'.
	 * @generated
	 */
	Change createChange();

	/**
	 * Returns a new object of class '<em>Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Match</em>'.
	 * @generated
	 */
	Match createMatch();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RepairjobPackage getRepairjobPackage();

} //RepairjobFactory
