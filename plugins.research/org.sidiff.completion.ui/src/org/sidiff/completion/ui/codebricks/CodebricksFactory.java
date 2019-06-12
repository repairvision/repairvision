/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage
 * @generated
 */
public interface CodebricksFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CodebricksFactory eINSTANCE = org.sidiff.completion.ui.codebricks.impl.CodebricksFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Codebricks</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Codebricks</em>'.
	 * @generated
	 */
	Codebricks createCodebricks();

	/**
	 * Returns a new object of class '<em>Codebrick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Codebrick</em>'.
	 * @generated
	 */
	Codebrick createCodebrick();

	/**
	 * Returns a new object of class '<em>Placeholder Brick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Placeholder Brick</em>'.
	 * @generated
	 */
	PlaceholderBrick createPlaceholderBrick();

	/**
	 * Returns a new object of class '<em>Model Element Brick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Element Brick</em>'.
	 * @generated
	 */
	ModelElementBrick createModelElementBrick();

	/**
	 * Returns a new object of class '<em>Text Brick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Brick</em>'.
	 * @generated
	 */
	TextBrick createTextBrick();

	/**
	 * Returns a new object of class '<em>Indent Brick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Indent Brick</em>'.
	 * @generated
	 */
	IndentBrick createIndentBrick();

	/**
	 * Returns a new object of class '<em>Line Break Brick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line Break Brick</em>'.
	 * @generated
	 */
	LineBreakBrick createLineBreakBrick();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CodebricksPackage getCodebricksPackage();

} //CodebricksFactory
