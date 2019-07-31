/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
			case CodebricksPackage.POJO_CODEBRICK_VIEW: return createPOJOCodebrickView();
			case CodebricksPackage.CODEBRICK_VIEW: return createCodebrickView();
			case CodebricksPackage.OBJECT_DOMAIN_POLICY: return createObjectDomainPolicy();
			case CodebricksPackage.VALUE_DOMAIN_POLICY: return createValueDomainPolicy();
			case CodebricksPackage.COLLAPSIBLE_BRICK: return createCollapsibleBrick();
			case CodebricksPackage.RESET_TEMPLATE_PLACEHOLDER_BRICK: return createResetTemplatePlaceholderBrick();
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
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CodebricksPackage.RGB:
				return createRGBFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CodebricksPackage.RGB:
				return convertRGBToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
	public POJOCodebrickView createPOJOCodebrickView() {
		POJOCodebrickViewImpl pojoCodebrickView = new POJOCodebrickViewImpl();
		return pojoCodebrickView;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public POJOCodebrickView createDelegateToAlternativePOJOCodebrickView() {
		POJOCodebrickViewImpl pojoCodebrickView = new POJOCodebrickViewImpl() {
			
			@Override
			public Object getModel() {
				if (getCodebricks().getAlternatives() != null) {
					
					// TODO: Currently, we only delegate to alternative if choice is unique
					//       and hide parameters if until unique selection of the template.
					//       Later, we can also make template selections based parameter
					//       value selections!
					List<Codebrick> currentChoices = getCodebricks().getChoice();
					
					if (currentChoices.size() == 1) {
						Codebrick choice = getCodebricks().getChoice().get(0);
						
						if (choice instanceof POJOCodebrickView) {
							return ((POJOCodebrickView) choice).getModel();
						}
					}
				}
				return null;
			}
		};
		return pojoCodebrickView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CodebrickView createCodebrickView() {
		CodebrickViewImpl codebrickView = new CodebrickViewImpl();
		return codebrickView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectDomainPolicy createObjectDomainPolicy() {
		ObjectDomainPolicyImpl objectDomainPolicy = new ObjectDomainPolicyImpl();
		return objectDomainPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueDomainPolicy createValueDomainPolicy() {
		ValueDomainPolicyImpl valueDomainPolicy = new ValueDomainPolicyImpl();
		return valueDomainPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CollapsibleBrick createCollapsibleBrick() {
		CollapsibleBrickImpl collapsibleBrick = new CollapsibleBrickImpl();
		return collapsibleBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResetTemplatePlaceholderBrick createResetTemplatePlaceholderBrick() {
		ResetTemplatePlaceholderBrickImpl resetTemplatePlaceholderBrick = new ResetTemplatePlaceholderBrickImpl();
		return resetTemplatePlaceholderBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RGB createRGBFromString(EDataType eDataType, String initialValue) {
		RGB result = RGB.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRGBToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
