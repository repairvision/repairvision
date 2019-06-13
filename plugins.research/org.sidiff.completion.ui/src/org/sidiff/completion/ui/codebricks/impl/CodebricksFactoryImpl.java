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
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK: return createTemplatePlaceholderBrick();
			case CodebricksPackage.OBJECT_PLACEHOLDER_BRICK: return createObjectPlaceholderBrick();
			case CodebricksPackage.TEXT_BRICK: return createTextBrick();
			case CodebricksPackage.INDENT_BRICK: return createIndentBrick();
			case CodebricksPackage.LINE_BREAK_BRICK: return createLineBreakBrick();
			case CodebricksPackage.BLANK_BRICK: return createBlankBrick();
			case CodebricksPackage.COMPOSED_BRICK: return createComposedBrick();
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK: return createValuePlaceholderBrick();
			case CodebricksPackage.OBJECT_DOMAIN_PLACEHOLDER_BRICK: return createObjectDomainPlaceholderBrick();
			case CodebricksPackage.COMPOSED_TEMPLATE_PLACEHOLDER_BRICK: return createComposedTemplatePlaceholderBrick();
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
	public TemplatePlaceholderBrick createTemplatePlaceholderBrick() {
		TemplatePlaceholderBrickImpl templatePlaceholderBrick = new TemplatePlaceholderBrickImpl();
		return templatePlaceholderBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectPlaceholderBrick createObjectPlaceholderBrick() {
		ObjectPlaceholderBrickImpl objectPlaceholderBrick = new ObjectPlaceholderBrickImpl();
		return objectPlaceholderBrick;
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
	public ComposedBrick createComposedBrick() {
		ComposedBrickImpl composedBrick = new ComposedBrickImpl();
		return composedBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValuePlaceholderBrick createValuePlaceholderBrick() {
		ValuePlaceholderBrickImpl valuePlaceholderBrick = new ValuePlaceholderBrickImpl();
		return valuePlaceholderBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectDomainPlaceholderBrick createObjectDomainPlaceholderBrick() {
		ObjectDomainPlaceholderBrickImpl objectDomainPlaceholderBrick = new ObjectDomainPlaceholderBrickImpl();
		return objectDomainPlaceholderBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposedTemplatePlaceholderBrick createComposedTemplatePlaceholderBrick() {
		ComposedTemplatePlaceholderBrickImpl composedTemplatePlaceholderBrick = new ComposedTemplatePlaceholderBrickImpl();
		return composedTemplatePlaceholderBrick;
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
