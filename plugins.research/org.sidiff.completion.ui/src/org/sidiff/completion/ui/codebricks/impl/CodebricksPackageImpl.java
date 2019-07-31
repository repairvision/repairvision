/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sidiff.completion.ui.codebricks.BlankBrick;
import org.sidiff.completion.ui.codebricks.Brick;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.CodebrickView;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.CodebricksFactory;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.CollapsibleBrick;
import org.sidiff.completion.ui.codebricks.ComposedBrick;
import org.sidiff.completion.ui.codebricks.IndentBrick;
import org.sidiff.completion.ui.codebricks.LineBreakBrick;
import org.sidiff.completion.ui.codebricks.ObjectDomainPolicy;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;
import org.sidiff.completion.ui.codebricks.POJOCodebrickView;
import org.sidiff.completion.ui.codebricks.PlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ResetTemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.StyledBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TextBrick;
import org.sidiff.completion.ui.codebricks.ValueDomainPolicy;
import org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CodebricksPackageImpl extends EPackageImpl implements CodebricksPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codebricksEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codebrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass brickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templatePlaceholderBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectPlaceholderBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indentBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lineBreakBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewableBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blankBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass composedBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass styledBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valuePlaceholderBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placeholderBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pojoCodebrickViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codebrickViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectDomainPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueDomainPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collapsibleBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resetTemplatePlaceholderBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rgbEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CodebricksPackageImpl() {
		super(eNS_URI, CodebricksFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link CodebricksPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CodebricksPackage init() {
		if (isInited) return (CodebricksPackage)EPackage.Registry.INSTANCE.getEPackage(CodebricksPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCodebricksPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CodebricksPackageImpl theCodebricksPackage = registeredCodebricksPackage instanceof CodebricksPackageImpl ? (CodebricksPackageImpl)registeredCodebricksPackage : new CodebricksPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCodebricksPackage.createPackageContents();

		// Initialize created meta-data
		theCodebricksPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCodebricksPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CodebricksPackage.eNS_URI, theCodebricksPackage);
		return theCodebricksPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCodebricks() {
		return codebricksEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCodebricks_Alternatives() {
		return (EReference)codebricksEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCodebricks_Template() {
		return (EReference)codebricksEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCodebricks_Choice() {
		return (EReference)codebricksEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCodebricks__IsChosen() {
		return codebricksEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCodebrick() {
		return codebrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCodebrick_Bricks() {
		return (EReference)codebrickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCodebrick_Codebricks() {
		return (EReference)codebrickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCodebrick_AllBricks() {
		return (EReference)codebrickEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCodebrick__CalculateRows() {
		return codebrickEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCodebrick__CaluclateColumns() {
		return codebrickEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBrick() {
		return brickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBrick_Codebrick() {
		return (EReference)brickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemplatePlaceholderBrick() {
		return templatePlaceholderBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplatePlaceholderBrick_Choices() {
		return (EReference)templatePlaceholderBrickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplatePlaceholderBrick_Choice() {
		return (EReference)templatePlaceholderBrickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplatePlaceholderBrick_RemainingChoices() {
		return (EReference)templatePlaceholderBrickEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTemplatePlaceholderBrick_Composed() {
		return (EAttribute)templatePlaceholderBrickEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplatePlaceholderBrick_AlternativeChoices() {
		return (EReference)templatePlaceholderBrickEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectPlaceholderBrick() {
		return objectPlaceholderBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectPlaceholderBrick_Element() {
		return (EReference)objectPlaceholderBrickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectPlaceholderBrick_Type() {
		return (EReference)objectPlaceholderBrickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectPlaceholderBrick_Domain() {
		return (EReference)objectPlaceholderBrickEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTextBrick() {
		return textBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTextBrick_Text() {
		return (EAttribute)textBrickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTextBrick_Selectable() {
		return (EAttribute)textBrickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIndentBrick() {
		return indentBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIndentBrick_Bricks() {
		return (EAttribute)indentBrickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLineBreakBrick() {
		return lineBreakBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getViewableBrick() {
		return viewableBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getViewableBrick__GetText() {
		return viewableBrickEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBlankBrick() {
		return blankBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComposedBrick() {
		return composedBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComposedBrick_Bricks() {
		return (EReference)composedBrickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStyledBrick() {
		return styledBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStyledBrick_Highlight() {
		return (EAttribute)styledBrickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStyledBrick_Color() {
		return (EAttribute)styledBrickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getStyledBrick__SetColor__int_int_int() {
		return styledBrickEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getStyledBrick__GetColor__RGB() {
		return styledBrickEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValuePlaceholderBrick() {
		return valuePlaceholderBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValuePlaceholderBrick_Type() {
		return (EReference)valuePlaceholderBrickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValuePlaceholderBrick_Domain() {
		return (EReference)valuePlaceholderBrickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValuePlaceholderBrick_InstanceValue() {
		return (EAttribute)valuePlaceholderBrickEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValuePlaceholderBrick_LiteralValue() {
		return (EAttribute)valuePlaceholderBrickEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getValuePlaceholderBrick__SetByLiteralValue__String() {
		return valuePlaceholderBrickEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getValuePlaceholderBrick__SetByInstanceValue__Object() {
		return valuePlaceholderBrickEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPlaceholderBrick() {
		return placeholderBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPlaceholderBrick_Mandatory() {
		return (EAttribute)placeholderBrickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPlaceholderBrick_Placeholder() {
		return (EAttribute)placeholderBrickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPlaceholderBrick_Name() {
		return (EAttribute)placeholderBrickEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPOJOCodebrickView() {
		return pojoCodebrickViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPOJOCodebrickView_Model() {
		return (EAttribute)pojoCodebrickViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCodebrickView() {
		return codebrickViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCodebrickView_Model() {
		return (EReference)codebrickViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectDomainPolicy() {
		return objectDomainPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getObjectDomainPolicy__GetDomain__ObjectPlaceholderBrick() {
		return objectDomainPolicyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getObjectDomainPolicy__AssignObject__ObjectPlaceholderBrick_EObject() {
		return objectDomainPolicyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValueDomainPolicy() {
		return valueDomainPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getValueDomainPolicy__IsValid__ValuePlaceholderBrick_String_EDataType() {
		return valueDomainPolicyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getValueDomainPolicy__GetDomain__ValuePlaceholderBrick() {
		return valueDomainPolicyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getValueDomainPolicy__CreateFromString__ValuePlaceholderBrick_String_EDataType() {
		return valueDomainPolicyEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getValueDomainPolicy__ConvertToString__ValuePlaceholderBrick_Object_EDataType() {
		return valueDomainPolicyEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollapsibleBrick() {
		return collapsibleBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollapsibleBrick_Collapsible() {
		return (EReference)collapsibleBrickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCollapsibleBrick__GetCollapsedText() {
		return collapsibleBrickEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResetTemplatePlaceholderBrick() {
		return resetTemplatePlaceholderBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getResetTemplatePlaceholderBrick_Placeholder() {
		return (EReference)resetTemplatePlaceholderBrickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getResetTemplatePlaceholderBrick_AttachedTo() {
		return (EReference)resetTemplatePlaceholderBrickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getRGB() {
		return rgbEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getValueDomainPolicy__AssignValue__Object_ValuePlaceholderBrick() {
		return valueDomainPolicyEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CodebricksFactory getCodebricksFactory() {
		return (CodebricksFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		codebricksEClass = createEClass(CODEBRICKS);
		createEReference(codebricksEClass, CODEBRICKS__ALTERNATIVES);
		createEReference(codebricksEClass, CODEBRICKS__TEMPLATE);
		createEReference(codebricksEClass, CODEBRICKS__CHOICE);
		createEOperation(codebricksEClass, CODEBRICKS___IS_CHOSEN);

		codebrickEClass = createEClass(CODEBRICK);
		createEReference(codebrickEClass, CODEBRICK__BRICKS);
		createEReference(codebrickEClass, CODEBRICK__CODEBRICKS);
		createEReference(codebrickEClass, CODEBRICK__ALL_BRICKS);
		createEOperation(codebrickEClass, CODEBRICK___CALCULATE_ROWS);
		createEOperation(codebrickEClass, CODEBRICK___CALUCLATE_COLUMNS);

		brickEClass = createEClass(BRICK);
		createEReference(brickEClass, BRICK__CODEBRICK);

		templatePlaceholderBrickEClass = createEClass(TEMPLATE_PLACEHOLDER_BRICK);
		createEReference(templatePlaceholderBrickEClass, TEMPLATE_PLACEHOLDER_BRICK__CHOICES);
		createEReference(templatePlaceholderBrickEClass, TEMPLATE_PLACEHOLDER_BRICK__CHOICE);
		createEReference(templatePlaceholderBrickEClass, TEMPLATE_PLACEHOLDER_BRICK__REMAINING_CHOICES);
		createEAttribute(templatePlaceholderBrickEClass, TEMPLATE_PLACEHOLDER_BRICK__COMPOSED);
		createEReference(templatePlaceholderBrickEClass, TEMPLATE_PLACEHOLDER_BRICK__ALTERNATIVE_CHOICES);

		objectPlaceholderBrickEClass = createEClass(OBJECT_PLACEHOLDER_BRICK);
		createEReference(objectPlaceholderBrickEClass, OBJECT_PLACEHOLDER_BRICK__ELEMENT);
		createEReference(objectPlaceholderBrickEClass, OBJECT_PLACEHOLDER_BRICK__TYPE);
		createEReference(objectPlaceholderBrickEClass, OBJECT_PLACEHOLDER_BRICK__DOMAIN);

		textBrickEClass = createEClass(TEXT_BRICK);
		createEAttribute(textBrickEClass, TEXT_BRICK__TEXT);
		createEAttribute(textBrickEClass, TEXT_BRICK__SELECTABLE);

		indentBrickEClass = createEClass(INDENT_BRICK);
		createEAttribute(indentBrickEClass, INDENT_BRICK__BRICKS);

		lineBreakBrickEClass = createEClass(LINE_BREAK_BRICK);

		viewableBrickEClass = createEClass(VIEWABLE_BRICK);
		createEOperation(viewableBrickEClass, VIEWABLE_BRICK___GET_TEXT);

		blankBrickEClass = createEClass(BLANK_BRICK);

		composedBrickEClass = createEClass(COMPOSED_BRICK);
		createEReference(composedBrickEClass, COMPOSED_BRICK__BRICKS);

		styledBrickEClass = createEClass(STYLED_BRICK);
		createEAttribute(styledBrickEClass, STYLED_BRICK__HIGHLIGHT);
		createEAttribute(styledBrickEClass, STYLED_BRICK__COLOR);
		createEOperation(styledBrickEClass, STYLED_BRICK___SET_COLOR__INT_INT_INT);
		createEOperation(styledBrickEClass, STYLED_BRICK___GET_COLOR__RGB);

		valuePlaceholderBrickEClass = createEClass(VALUE_PLACEHOLDER_BRICK);
		createEReference(valuePlaceholderBrickEClass, VALUE_PLACEHOLDER_BRICK__TYPE);
		createEReference(valuePlaceholderBrickEClass, VALUE_PLACEHOLDER_BRICK__DOMAIN);
		createEAttribute(valuePlaceholderBrickEClass, VALUE_PLACEHOLDER_BRICK__INSTANCE_VALUE);
		createEAttribute(valuePlaceholderBrickEClass, VALUE_PLACEHOLDER_BRICK__LITERAL_VALUE);
		createEOperation(valuePlaceholderBrickEClass, VALUE_PLACEHOLDER_BRICK___SET_BY_LITERAL_VALUE__STRING);
		createEOperation(valuePlaceholderBrickEClass, VALUE_PLACEHOLDER_BRICK___SET_BY_INSTANCE_VALUE__OBJECT);

		placeholderBrickEClass = createEClass(PLACEHOLDER_BRICK);
		createEAttribute(placeholderBrickEClass, PLACEHOLDER_BRICK__MANDATORY);
		createEAttribute(placeholderBrickEClass, PLACEHOLDER_BRICK__PLACEHOLDER);
		createEAttribute(placeholderBrickEClass, PLACEHOLDER_BRICK__NAME);

		pojoCodebrickViewEClass = createEClass(POJO_CODEBRICK_VIEW);
		createEAttribute(pojoCodebrickViewEClass, POJO_CODEBRICK_VIEW__MODEL);

		codebrickViewEClass = createEClass(CODEBRICK_VIEW);
		createEReference(codebrickViewEClass, CODEBRICK_VIEW__MODEL);

		objectDomainPolicyEClass = createEClass(OBJECT_DOMAIN_POLICY);
		createEOperation(objectDomainPolicyEClass, OBJECT_DOMAIN_POLICY___GET_DOMAIN__OBJECTPLACEHOLDERBRICK);
		createEOperation(objectDomainPolicyEClass, OBJECT_DOMAIN_POLICY___ASSIGN_OBJECT__OBJECTPLACEHOLDERBRICK_EOBJECT);

		valueDomainPolicyEClass = createEClass(VALUE_DOMAIN_POLICY);
		createEOperation(valueDomainPolicyEClass, VALUE_DOMAIN_POLICY___IS_VALID__VALUEPLACEHOLDERBRICK_STRING_EDATATYPE);
		createEOperation(valueDomainPolicyEClass, VALUE_DOMAIN_POLICY___GET_DOMAIN__VALUEPLACEHOLDERBRICK);
		createEOperation(valueDomainPolicyEClass, VALUE_DOMAIN_POLICY___ASSIGN_VALUE__OBJECT_VALUEPLACEHOLDERBRICK);
		createEOperation(valueDomainPolicyEClass, VALUE_DOMAIN_POLICY___CREATE_FROM_STRING__VALUEPLACEHOLDERBRICK_STRING_EDATATYPE);
		createEOperation(valueDomainPolicyEClass, VALUE_DOMAIN_POLICY___CONVERT_TO_STRING__VALUEPLACEHOLDERBRICK_OBJECT_EDATATYPE);

		collapsibleBrickEClass = createEClass(COLLAPSIBLE_BRICK);
		createEReference(collapsibleBrickEClass, COLLAPSIBLE_BRICK__COLLAPSIBLE);
		createEOperation(collapsibleBrickEClass, COLLAPSIBLE_BRICK___GET_COLLAPSED_TEXT);

		resetTemplatePlaceholderBrickEClass = createEClass(RESET_TEMPLATE_PLACEHOLDER_BRICK);
		createEReference(resetTemplatePlaceholderBrickEClass, RESET_TEMPLATE_PLACEHOLDER_BRICK__PLACEHOLDER);
		createEReference(resetTemplatePlaceholderBrickEClass, RESET_TEMPLATE_PLACEHOLDER_BRICK__ATTACHED_TO);

		// Create enums
		rgbEEnum = createEEnum(RGB);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		templatePlaceholderBrickEClass.getESuperTypes().add(this.getPlaceholderBrick());
		objectPlaceholderBrickEClass.getESuperTypes().add(this.getPlaceholderBrick());
		textBrickEClass.getESuperTypes().add(this.getStyledBrick());
		indentBrickEClass.getESuperTypes().add(this.getBrick());
		lineBreakBrickEClass.getESuperTypes().add(this.getBrick());
		viewableBrickEClass.getESuperTypes().add(this.getBrick());
		blankBrickEClass.getESuperTypes().add(this.getViewableBrick());
		composedBrickEClass.getESuperTypes().add(this.getViewableBrick());
		styledBrickEClass.getESuperTypes().add(this.getViewableBrick());
		valuePlaceholderBrickEClass.getESuperTypes().add(this.getPlaceholderBrick());
		placeholderBrickEClass.getESuperTypes().add(this.getStyledBrick());
		pojoCodebrickViewEClass.getESuperTypes().add(this.getCodebrick());
		codebrickViewEClass.getESuperTypes().add(this.getCodebrick());
		collapsibleBrickEClass.getESuperTypes().add(this.getComposedBrick());
		resetTemplatePlaceholderBrickEClass.getESuperTypes().add(this.getStyledBrick());

		// Initialize classes, features, and operations; add parameters
		initEClass(codebricksEClass, Codebricks.class, "Codebricks", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodebricks_Alternatives(), this.getCodebrick(), null, "alternatives", null, 0, -1, Codebricks.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodebricks_Template(), this.getCodebrick(), null, "template", null, 0, 1, Codebricks.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodebricks_Choice(), this.getCodebrick(), null, "choice", null, 0, -1, Codebricks.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getCodebricks__IsChosen(), ecorePackage.getEBoolean(), "isChosen", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(codebrickEClass, Codebrick.class, "Codebrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodebrick_Bricks(), this.getBrick(), null, "bricks", null, 0, -1, Codebrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodebrick_Codebricks(), this.getCodebricks(), null, "codebricks", null, 0, 1, Codebrick.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getCodebrick_AllBricks(), this.getBrick(), null, "allBricks", null, 0, -1, Codebrick.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getCodebrick__CalculateRows(), ecorePackage.getEInt(), "calculateRows", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getCodebrick__CaluclateColumns(), ecorePackage.getEInt(), "caluclateColumns", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(brickEClass, Brick.class, "Brick", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBrick_Codebrick(), this.getCodebrick(), null, "codebrick", null, 0, 1, Brick.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(templatePlaceholderBrickEClass, TemplatePlaceholderBrick.class, "TemplatePlaceholderBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplatePlaceholderBrick_Choices(), this.getViewableBrick(), null, "choices", null, 0, -1, TemplatePlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplatePlaceholderBrick_Choice(), this.getViewableBrick(), null, "choice", null, 0, -1, TemplatePlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplatePlaceholderBrick_RemainingChoices(), this.getViewableBrick(), null, "remainingChoices", null, 0, -1, TemplatePlaceholderBrick.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemplatePlaceholderBrick_Composed(), ecorePackage.getEBoolean(), "composed", null, 0, 1, TemplatePlaceholderBrick.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTemplatePlaceholderBrick_AlternativeChoices(), this.getViewableBrick(), null, "alternativeChoices", null, 0, -1, TemplatePlaceholderBrick.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(objectPlaceholderBrickEClass, ObjectPlaceholderBrick.class, "ObjectPlaceholderBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectPlaceholderBrick_Element(), ecorePackage.getEObject(), null, "element", null, 0, 1, ObjectPlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectPlaceholderBrick_Type(), ecorePackage.getEClass(), null, "type", null, 0, 1, ObjectPlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectPlaceholderBrick_Domain(), this.getObjectDomainPolicy(), null, "domain", null, 0, 1, ObjectPlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textBrickEClass, TextBrick.class, "TextBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTextBrick_Text(), ecorePackage.getEString(), "text", null, 0, 1, TextBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextBrick_Selectable(), ecorePackage.getEBoolean(), "selectable", null, 0, 1, TextBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indentBrickEClass, IndentBrick.class, "IndentBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndentBrick_Bricks(), ecorePackage.getEInt(), "bricks", "1", 0, 1, IndentBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lineBreakBrickEClass, LineBreakBrick.class, "LineBreakBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(viewableBrickEClass, ViewableBrick.class, "ViewableBrick", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getViewableBrick__GetText(), ecorePackage.getEString(), "getText", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(blankBrickEClass, BlankBrick.class, "BlankBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(composedBrickEClass, ComposedBrick.class, "ComposedBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComposedBrick_Bricks(), this.getViewableBrick(), null, "bricks", null, 0, -1, ComposedBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(styledBrickEClass, StyledBrick.class, "StyledBrick", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStyledBrick_Highlight(), ecorePackage.getEBoolean(), "highlight", null, 0, 1, StyledBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyledBrick_Color(), theEcorePackage.getEInt(), "color", "0", 0, 1, StyledBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getStyledBrick__SetColor__int_int_int(), null, "setColor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "red", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "green", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "blue", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getStyledBrick__GetColor__RGB(), theEcorePackage.getEInt(), "getColor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRGB(), "rgb", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(valuePlaceholderBrickEClass, ValuePlaceholderBrick.class, "ValuePlaceholderBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValuePlaceholderBrick_Type(), ecorePackage.getEDataType(), null, "type", null, 0, 1, ValuePlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValuePlaceholderBrick_Domain(), this.getValueDomainPolicy(), null, "domain", null, 0, 1, ValuePlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValuePlaceholderBrick_InstanceValue(), ecorePackage.getEJavaObject(), "instanceValue", null, 0, 1, ValuePlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValuePlaceholderBrick_LiteralValue(), ecorePackage.getEString(), "literalValue", null, 0, 1, ValuePlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getValuePlaceholderBrick__SetByLiteralValue__String(), null, "setByLiteralValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "literalValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getValuePlaceholderBrick__SetByInstanceValue__Object(), null, "setByInstanceValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "instanceValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(placeholderBrickEClass, PlaceholderBrick.class, "PlaceholderBrick", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlaceholderBrick_Mandatory(), ecorePackage.getEBoolean(), "mandatory", null, 0, 1, PlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlaceholderBrick_Placeholder(), ecorePackage.getEString(), "placeholder", null, 0, 1, PlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlaceholderBrick_Name(), ecorePackage.getEString(), "name", null, 0, 1, PlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pojoCodebrickViewEClass, POJOCodebrickView.class, "POJOCodebrickView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPOJOCodebrickView_Model(), ecorePackage.getEJavaObject(), "model", null, 0, 1, POJOCodebrickView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(codebrickViewEClass, CodebrickView.class, "CodebrickView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodebrickView_Model(), theEcorePackage.getEObject(), null, "model", null, 0, 1, CodebrickView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectDomainPolicyEClass, ObjectDomainPolicy.class, "ObjectDomainPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getObjectDomainPolicy__GetDomain__ObjectPlaceholderBrick(), ecorePackage.getEObject(), "getDomain", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObjectPlaceholderBrick(), "brick", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getObjectDomainPolicy__AssignObject__ObjectPlaceholderBrick_EObject(), null, "assignObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObjectPlaceholderBrick(), "brick", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "element", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(valueDomainPolicyEClass, ValueDomainPolicy.class, "ValueDomainPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getValueDomainPolicy__IsValid__ValuePlaceholderBrick_String_EDataType(), ecorePackage.getEBoolean(), "isValid", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getValuePlaceholderBrick(), "brick", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "literalValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDataType(), "eDataType", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getValueDomainPolicy__GetDomain__ValuePlaceholderBrick(), ecorePackage.getEJavaObject(), "getDomain", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getValuePlaceholderBrick(), "brick", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getValueDomainPolicy__AssignValue__Object_ValuePlaceholderBrick(), null, "assignValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "instanceValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getValuePlaceholderBrick(), "brick", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getValueDomainPolicy__CreateFromString__ValuePlaceholderBrick_String_EDataType(), theEcorePackage.getEJavaObject(), "createFromString", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getValuePlaceholderBrick(), "brick", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "literalValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDataType(), "eDataType", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getValueDomainPolicy__ConvertToString__ValuePlaceholderBrick_Object_EDataType(), ecorePackage.getEString(), "convertToString", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getValuePlaceholderBrick(), "brick", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "instanceValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDataType(), "eDataType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(collapsibleBrickEClass, CollapsibleBrick.class, "CollapsibleBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollapsibleBrick_Collapsible(), this.getViewableBrick(), null, "collapsible", null, 0, -1, CollapsibleBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getCollapsibleBrick__GetCollapsedText(), ecorePackage.getEString(), "getCollapsedText", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(resetTemplatePlaceholderBrickEClass, ResetTemplatePlaceholderBrick.class, "ResetTemplatePlaceholderBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResetTemplatePlaceholderBrick_Placeholder(), this.getTemplatePlaceholderBrick(), null, "placeholder", null, 1, 1, ResetTemplatePlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResetTemplatePlaceholderBrick_AttachedTo(), this.getViewableBrick(), null, "attachedTo", null, 1, 1, ResetTemplatePlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(rgbEEnum, org.sidiff.completion.ui.codebricks.RGB.class, "RGB");
		addEEnumLiteral(rgbEEnum, org.sidiff.completion.ui.codebricks.RGB.RED);
		addEEnumLiteral(rgbEEnum, org.sidiff.completion.ui.codebricks.RGB.GREEN);
		addEEnumLiteral(rgbEEnum, org.sidiff.completion.ui.codebricks.RGB.BLUE);

		// Create resource
		createResource(eNS_URI);
	}

} //CodebricksPackageImpl
