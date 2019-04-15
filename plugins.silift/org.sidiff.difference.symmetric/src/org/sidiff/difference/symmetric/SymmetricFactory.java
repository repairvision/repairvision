/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.difference.symmetric;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.difference.symmetric.SymmetricPackage
 * @generated
 */
public interface SymmetricFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SymmetricFactory eINSTANCE = org.sidiff.difference.symmetric.impl.SymmetricFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Difference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Difference</em>'.
	 * @generated
	 */
	SymmetricDifference createSymmetricDifference();

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
	 * Returns a new object of class '<em>Semantic Change Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Semantic Change Set</em>'.
	 * @generated
	 */
	SemanticChangeSet createSemanticChangeSet();

	/**
	 * Returns a new object of class '<em>Attribute Value Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Value Change</em>'.
	 * @generated
	 */
	AttributeValueChange createAttributeValueChange();

	/**
	 * Returns a new object of class '<em>Edit Rule Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edit Rule Match</em>'.
	 * @generated
	 */
	EditRuleMatch createEditRuleMatch();

	/**
	 * Returns a new object of class '<em>EObject Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EObject Set</em>'.
	 * @generated
	 */
	EObjectSet createEObjectSet();

	/**
	 * Returns a new object of class '<em>Fragment Join</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fragment Join</em>'.
	 * @generated
	 */
	FragmentJoin createFragmentJoin();

	/**
	 * Returns a new object of class '<em>Fragment Split</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fragment Split</em>'.
	 * @generated
	 */
	FragmentSplit createFragmentSplit();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SymmetricPackage getSymmetricPackage();

	

} //SymmetricFactory
