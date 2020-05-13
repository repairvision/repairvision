/**
 */
package org.sidiff.revision.difference;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.revision.difference.DifferencePackage
 * @generated
 */
public interface DifferenceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DifferenceFactory eINSTANCE = org.sidiff.revision.difference.impl.DifferenceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Difference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Difference</em>'.
	 * @generated
	 */
	Difference createDifference();

	/**
	 * Returns a new object of class '<em>Correspondence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Correspondence</em>'.
	 * @generated
	 */
	Correspondence createCorrespondence();

	/**
	 * Returns a new object of class '<em>Add Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Object</em>'.
	 * @generated
	 */
	AddObject createAddObject();

	/**
	 * Returns a new object of class '<em>Remove Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Object</em>'.
	 * @generated
	 */
	RemoveObject createRemoveObject();

	/**
	 * Returns a new object of class '<em>Add Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Reference</em>'.
	 * @generated
	 */
	AddReference createAddReference();

	/**
	 * Returns a new object of class '<em>Remove Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Reference</em>'.
	 * @generated
	 */
	RemoveReference createRemoveReference();

	/**
	 * Returns a new object of class '<em>Attribute Value Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Value Change</em>'.
	 * @generated
	 */
	AttributeValueChange createAttributeValueChange();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DifferencePackage getDifferencePackage();

} //DifferenceFactory
