/**
 */
package org.sidiff.graphpattern.profile.henshin_extension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage
 * @generated
 */
public interface HenshinExtensionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HenshinExtensionFactory eINSTANCE = org.sidiff.graphpattern.profile.henshin_extension.impl.HenshinExtensionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Rule Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Extension</em>'.
	 * @generated
	 */
	RuleExtension createRuleExtension();

	/**
	 * Returns a new object of class '<em>Sub Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Graph</em>'.
	 * @generated
	 */
	SubGraph createSubGraph();

	/**
	 * Returns a new object of class '<em>Node Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Extension</em>'.
	 * @generated
	 */
	NodeExtension createNodeExtension();

	/**
	 * Returns a new object of class '<em>Edge Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge Extension</em>'.
	 * @generated
	 */
	EdgeExtension createEdgeExtension();

	/**
	 * Returns a new object of class '<em>Attribute Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Extension</em>'.
	 * @generated
	 */
	AttributeExtension createAttributeExtension();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HenshinExtensionPackage getHenshinExtensionPackage();

} //HenshinExtensionFactory
