/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sidiff.completion.ui.codebricks.BlankBrick;
import org.sidiff.completion.ui.codebricks.Brick;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.CodebricksFactory;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.ComposedBrick;
import org.sidiff.completion.ui.codebricks.IndentBrick;
import org.sidiff.completion.ui.codebricks.LineBreakBrick;
import org.sidiff.completion.ui.codebricks.ObjectDomainPlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;
import org.sidiff.completion.ui.codebricks.PlaceholderBrick;
import org.sidiff.completion.ui.codebricks.StyledBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TextBrick;
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
	private EClass objectDomainPlaceholderBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placeholderBrickEClass = null;

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
	public EAttribute getTemplatePlaceholderBrick_Mandatory() {
		return (EAttribute)templatePlaceholderBrickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplatePlaceholderBrick_Choice() {
		return (EReference)templatePlaceholderBrickEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplatePlaceholderBrick_RemainingChoices() {
		return (EReference)templatePlaceholderBrickEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTemplatePlaceholderBrick_Composed() {
		return (EAttribute)templatePlaceholderBrickEClass.getEStructuralFeatures().get(4);
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
	public EClass getObjectDomainPlaceholderBrick() {
		return objectDomainPlaceholderBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectDomainPlaceholderBrick_Domain() {
		return (EReference)objectDomainPlaceholderBrickEClass.getEStructuralFeatures().get(0);
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

		codebrickEClass = createEClass(CODEBRICK);
		createEReference(codebrickEClass, CODEBRICK__BRICKS);
		createEReference(codebrickEClass, CODEBRICK__CODEBRICKS);
		createEOperation(codebrickEClass, CODEBRICK___CALCULATE_ROWS);
		createEOperation(codebrickEClass, CODEBRICK___CALUCLATE_COLUMNS);

		brickEClass = createEClass(BRICK);
		createEReference(brickEClass, BRICK__CODEBRICK);

		templatePlaceholderBrickEClass = createEClass(TEMPLATE_PLACEHOLDER_BRICK);
		createEReference(templatePlaceholderBrickEClass, TEMPLATE_PLACEHOLDER_BRICK__CHOICES);
		createEAttribute(templatePlaceholderBrickEClass, TEMPLATE_PLACEHOLDER_BRICK__MANDATORY);
		createEReference(templatePlaceholderBrickEClass, TEMPLATE_PLACEHOLDER_BRICK__CHOICE);
		createEReference(templatePlaceholderBrickEClass, TEMPLATE_PLACEHOLDER_BRICK__REMAINING_CHOICES);
		createEAttribute(templatePlaceholderBrickEClass, TEMPLATE_PLACEHOLDER_BRICK__COMPOSED);

		objectPlaceholderBrickEClass = createEClass(OBJECT_PLACEHOLDER_BRICK);
		createEReference(objectPlaceholderBrickEClass, OBJECT_PLACEHOLDER_BRICK__ELEMENT);
		createEReference(objectPlaceholderBrickEClass, OBJECT_PLACEHOLDER_BRICK__TYPE);

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

		valuePlaceholderBrickEClass = createEClass(VALUE_PLACEHOLDER_BRICK);
		createEReference(valuePlaceholderBrickEClass, VALUE_PLACEHOLDER_BRICK__TYPE);

		objectDomainPlaceholderBrickEClass = createEClass(OBJECT_DOMAIN_PLACEHOLDER_BRICK);
		createEReference(objectDomainPlaceholderBrickEClass, OBJECT_DOMAIN_PLACEHOLDER_BRICK__DOMAIN);

		placeholderBrickEClass = createEClass(PLACEHOLDER_BRICK);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		templatePlaceholderBrickEClass.getESuperTypes().add(this.getStyledBrick());
		templatePlaceholderBrickEClass.getESuperTypes().add(this.getPlaceholderBrick());
		objectPlaceholderBrickEClass.getESuperTypes().add(this.getStyledBrick());
		objectPlaceholderBrickEClass.getESuperTypes().add(this.getPlaceholderBrick());
		textBrickEClass.getESuperTypes().add(this.getStyledBrick());
		indentBrickEClass.getESuperTypes().add(this.getBrick());
		lineBreakBrickEClass.getESuperTypes().add(this.getBrick());
		viewableBrickEClass.getESuperTypes().add(this.getBrick());
		blankBrickEClass.getESuperTypes().add(this.getViewableBrick());
		composedBrickEClass.getESuperTypes().add(this.getViewableBrick());
		styledBrickEClass.getESuperTypes().add(this.getViewableBrick());
		valuePlaceholderBrickEClass.getESuperTypes().add(this.getTextBrick());
		valuePlaceholderBrickEClass.getESuperTypes().add(this.getPlaceholderBrick());
		objectDomainPlaceholderBrickEClass.getESuperTypes().add(this.getObjectPlaceholderBrick());
		objectDomainPlaceholderBrickEClass.getESuperTypes().add(this.getPlaceholderBrick());

		// Initialize classes, features, and operations; add parameters
		initEClass(codebricksEClass, Codebricks.class, "Codebricks", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodebricks_Alternatives(), this.getCodebrick(), null, "alternatives", null, 0, -1, Codebricks.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodebricks_Template(), this.getCodebrick(), null, "template", null, 0, 1, Codebricks.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(codebrickEClass, Codebrick.class, "Codebrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodebrick_Bricks(), this.getBrick(), this.getBrick_Codebrick(), "bricks", null, 0, -1, Codebrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodebrick_Codebricks(), this.getCodebricks(), null, "codebricks", null, 0, 1, Codebrick.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getCodebrick__CalculateRows(), ecorePackage.getEInt(), "calculateRows", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getCodebrick__CaluclateColumns(), ecorePackage.getEInt(), "caluclateColumns", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(brickEClass, Brick.class, "Brick", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBrick_Codebrick(), this.getCodebrick(), this.getCodebrick_Bricks(), "codebrick", null, 0, 1, Brick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templatePlaceholderBrickEClass, TemplatePlaceholderBrick.class, "TemplatePlaceholderBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplatePlaceholderBrick_Choices(), this.getViewableBrick(), null, "choices", null, 0, -1, TemplatePlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemplatePlaceholderBrick_Mandatory(), ecorePackage.getEBoolean(), "mandatory", null, 0, 1, TemplatePlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplatePlaceholderBrick_Choice(), this.getViewableBrick(), null, "choice", null, 0, -1, TemplatePlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplatePlaceholderBrick_RemainingChoices(), this.getViewableBrick(), null, "remainingChoices", null, 0, -1, TemplatePlaceholderBrick.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemplatePlaceholderBrick_Composed(), ecorePackage.getEBoolean(), "composed", null, 0, 1, TemplatePlaceholderBrick.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(objectPlaceholderBrickEClass, ObjectPlaceholderBrick.class, "ObjectPlaceholderBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectPlaceholderBrick_Element(), ecorePackage.getEObject(), null, "element", null, 0, 1, ObjectPlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectPlaceholderBrick_Type(), ecorePackage.getEClass(), null, "type", null, 0, 1, ObjectPlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEClass(styledBrickEClass, StyledBrick.class, "StyledBrick", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStyledBrick_Highlight(), ecorePackage.getEBoolean(), "highlight", null, 0, 1, StyledBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valuePlaceholderBrickEClass, ValuePlaceholderBrick.class, "ValuePlaceholderBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValuePlaceholderBrick_Type(), ecorePackage.getEDataType(), null, "type", null, 0, 1, ValuePlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectDomainPlaceholderBrickEClass, ObjectDomainPlaceholderBrick.class, "ObjectDomainPlaceholderBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectDomainPlaceholderBrick_Domain(), ecorePackage.getEObject(), null, "domain", null, 0, -1, ObjectDomainPlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(placeholderBrickEClass, PlaceholderBrick.class, "PlaceholderBrick", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //CodebricksPackageImpl
