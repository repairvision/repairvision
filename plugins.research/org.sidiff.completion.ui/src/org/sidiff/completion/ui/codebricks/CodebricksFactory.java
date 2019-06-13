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
	 * Returns a new object of class '<em>Template Placeholder Brick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Placeholder Brick</em>'.
	 * @generated
	 */
	TemplatePlaceholderBrick createTemplatePlaceholderBrick();

	/**
	 * Returns a new object of class '<em>Object Placeholder Brick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Placeholder Brick</em>'.
	 * @generated
	 */
	ObjectPlaceholderBrick createObjectPlaceholderBrick();

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
	 * Returns a new object of class '<em>Blank Brick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Blank Brick</em>'.
	 * @generated
	 */
	BlankBrick createBlankBrick();

	/**
	 * Returns a new object of class '<em>Composed Brick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composed Brick</em>'.
	 * @generated
	 */
	ComposedBrick createComposedBrick();

	/**
	 * Returns a new object of class '<em>Value Placeholder Brick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Placeholder Brick</em>'.
	 * @generated
	 */
	ValuePlaceholderBrick createValuePlaceholderBrick();

	/**
	 * Returns a new object of class '<em>Object Domain Placeholder Brick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Domain Placeholder Brick</em>'.
	 * @generated
	 */
	ObjectDomainPlaceholderBrick createObjectDomainPlaceholderBrick();

	/**
	 * Returns a new object of class '<em>Composed Template Placeholder Brick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composed Template Placeholder Brick</em>'.
	 * @generated
	 */
	ComposedTemplatePlaceholderBrick createComposedTemplatePlaceholderBrick();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CodebricksPackage getCodebricksPackage();

} //CodebricksFactory
