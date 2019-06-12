/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sidiff.completion.ui.codebricks.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CodebricksFactoryImpl extends EFactoryImpl implements CodebricksFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CodebricksFactory init() {
		try {
			CodebricksFactory theCodebricksFactory = (CodebricksFactory)EPackage.Registry.INSTANCE.getEFactory(CodebricksPackage.eNS_URI);
			if (theCodebricksFactory != null) {
				return theCodebricksFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CodebricksFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodebricksFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CodebricksPackage.CODEBRICKS: return createCodebricks();
			case CodebricksPackage.CODEBRICK: return createCodebrick();
			case CodebricksPackage.PLACEHOLDER_BRICK: return createPlaceholderBrick();
			case CodebricksPackage.MODEL_ELEMENT_BRICK: return createModelElementBrick();
			case CodebricksPackage.TEXT_BRICK: return createTextBrick();
			case CodebricksPackage.INDENT_BRICK: return createIndentBrick();
			case CodebricksPackage.LINE_BREAK_BRICK: return createLineBreakBrick();
			case CodebricksPackage.BLANK_BRICK: return createBlankBrick();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Codebricks createCodebricks() {
		CodebricksImpl codebricks = new CodebricksImpl();
		return codebricks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Codebrick createCodebrick() {
		CodebrickImpl codebrick = new CodebrickImpl();
		return codebrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PlaceholderBrick createPlaceholderBrick() {
		PlaceholderBrickImpl placeholderBrick = new PlaceholderBrickImpl();
		return placeholderBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelElementBrick createModelElementBrick() {
		ModelElementBrickImpl modelElementBrick = new ModelElementBrickImpl();
		return modelElementBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TextBrick createTextBrick() {
		TextBrickImpl textBrick = new TextBrickImpl();
		return textBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IndentBrick createIndentBrick() {
		IndentBrickImpl indentBrick = new IndentBrickImpl();
		return indentBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LineBreakBrick createLineBreakBrick() {
		LineBreakBrickImpl lineBreakBrick = new LineBreakBrickImpl();
		return lineBreakBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BlankBrick createBlankBrick() {
		BlankBrickImpl blankBrick = new BlankBrickImpl();
		return blankBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CodebricksPackage getCodebricksPackage() {
		return (CodebricksPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CodebricksPackage getPackage() {
		return CodebricksPackage.eINSTANCE;
	}

} //CodebricksFactoryImpl
