/**
 */
package org.sidiff.repair.historymodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.repair.historymodel.HistoryModelPackage
 * @generated
 */
public interface HistoryModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HistoryModelFactory eINSTANCE = org.sidiff.repair.historymodel.impl.HistoryModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>History</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>History</em>'.
	 * @generated
	 */
	History createHistory();

	/**
	 * Returns a new object of class '<em>Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Version</em>'.
	 * @generated
	 */
	Version createVersion();

	/**
	 * Returns a new object of class '<em>Validation Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validation Error</em>'.
	 * @generated
	 */
	ValidationError createValidationError();

	/**
	 * Returns a new object of class '<em>Change Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Change Set</em>'.
	 * @generated
	 */
	ChangeSet createChangeSet();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HistoryModelPackage getHistoryModelPackage();

} //HistoryModelFactory
