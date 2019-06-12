/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sidiff.completion.ui.codebricks.Brick;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.CodebricksFactory;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.IndentBrick;
import org.sidiff.completion.ui.codebricks.LineBreakBrick;
import org.sidiff.completion.ui.codebricks.ModelElementBrick;
import org.sidiff.completion.ui.codebricks.PlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TextBrick;
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
	private EClass placeholderBrickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementBrickEClass = null;

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
	public EClass getPlaceholderBrick() {
		return placeholderBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPlaceholderBrick_Choices() {
		return (EReference)placeholderBrickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPlaceholderBrick_Mandatory() {
		return (EAttribute)placeholderBrickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPlaceholderBrick_Choice() {
		return (EReference)placeholderBrickEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPlaceholderBrick_RemainingChoices() {
		return (EReference)placeholderBrickEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModelElementBrick() {
		return modelElementBrickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelElementBrick_Element() {
		return (EReference)modelElementBrickEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getViewableBrick_Editable() {
		return (EAttribute)viewableBrickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getViewableBrick_Highlight() {
		return (EAttribute)viewableBrickEClass.getEStructuralFeatures().get(1);
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
		createEReference(codebricksEClass, CODEBRICKS__TEMPLATE);
		createEReference(codebricksEClass, CODEBRICKS__ALTERNATIVES);

		codebrickEClass = createEClass(CODEBRICK);
		createEReference(codebrickEClass, CODEBRICK__BRICKS);
		createEReference(codebrickEClass, CODEBRICK__CODEBRICKS);
		createEOperation(codebrickEClass, CODEBRICK___CALCULATE_ROWS);
		createEOperation(codebrickEClass, CODEBRICK___CALUCLATE_COLUMNS);

		brickEClass = createEClass(BRICK);
		createEReference(brickEClass, BRICK__CODEBRICK);

		placeholderBrickEClass = createEClass(PLACEHOLDER_BRICK);
		createEReference(placeholderBrickEClass, PLACEHOLDER_BRICK__CHOICES);
		createEAttribute(placeholderBrickEClass, PLACEHOLDER_BRICK__MANDATORY);
		createEReference(placeholderBrickEClass, PLACEHOLDER_BRICK__CHOICE);
		createEReference(placeholderBrickEClass, PLACEHOLDER_BRICK__REMAINING_CHOICES);

		modelElementBrickEClass = createEClass(MODEL_ELEMENT_BRICK);
		createEReference(modelElementBrickEClass, MODEL_ELEMENT_BRICK__ELEMENT);

		textBrickEClass = createEClass(TEXT_BRICK);
		createEAttribute(textBrickEClass, TEXT_BRICK__TEXT);

		indentBrickEClass = createEClass(INDENT_BRICK);
		createEAttribute(indentBrickEClass, INDENT_BRICK__BRICKS);

		lineBreakBrickEClass = createEClass(LINE_BREAK_BRICK);

		viewableBrickEClass = createEClass(VIEWABLE_BRICK);
		createEAttribute(viewableBrickEClass, VIEWABLE_BRICK__EDITABLE);
		createEAttribute(viewableBrickEClass, VIEWABLE_BRICK__HIGHLIGHT);
		createEOperation(viewableBrickEClass, VIEWABLE_BRICK___GET_TEXT);
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
		placeholderBrickEClass.getESuperTypes().add(this.getViewableBrick());
		modelElementBrickEClass.getESuperTypes().add(this.getViewableBrick());
		textBrickEClass.getESuperTypes().add(this.getViewableBrick());
		indentBrickEClass.getESuperTypes().add(this.getBrick());
		lineBreakBrickEClass.getESuperTypes().add(this.getBrick());
		viewableBrickEClass.getESuperTypes().add(this.getBrick());

		// Initialize classes, features, and operations; add parameters
		initEClass(codebricksEClass, Codebricks.class, "Codebricks", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodebricks_Template(), this.getCodebrick(), null, "template", null, 0, 1, Codebricks.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodebricks_Alternatives(), this.getCodebrick(), null, "alternatives", null, 0, -1, Codebricks.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(codebrickEClass, Codebrick.class, "Codebrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodebrick_Bricks(), this.getBrick(), this.getBrick_Codebrick(), "bricks", null, 0, -1, Codebrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodebrick_Codebricks(), this.getCodebricks(), null, "codebricks", null, 0, 1, Codebrick.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getCodebrick__CalculateRows(), ecorePackage.getEInt(), "calculateRows", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getCodebrick__CaluclateColumns(), ecorePackage.getEInt(), "caluclateColumns", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(brickEClass, Brick.class, "Brick", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBrick_Codebrick(), this.getCodebrick(), this.getCodebrick_Bricks(), "codebrick", null, 0, 1, Brick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(placeholderBrickEClass, PlaceholderBrick.class, "PlaceholderBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlaceholderBrick_Choices(), this.getViewableBrick(), null, "choices", null, 0, -1, PlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlaceholderBrick_Mandatory(), ecorePackage.getEBoolean(), "mandatory", null, 0, 1, PlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlaceholderBrick_Choice(), this.getViewableBrick(), null, "choice", null, 0, -1, PlaceholderBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlaceholderBrick_RemainingChoices(), this.getViewableBrick(), null, "remainingChoices", null, 0, -1, PlaceholderBrick.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(modelElementBrickEClass, ModelElementBrick.class, "ModelElementBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelElementBrick_Element(), ecorePackage.getEObject(), null, "element", null, 0, 1, ModelElementBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textBrickEClass, TextBrick.class, "TextBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTextBrick_Text(), ecorePackage.getEString(), "text", null, 0, 1, TextBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indentBrickEClass, IndentBrick.class, "IndentBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndentBrick_Bricks(), ecorePackage.getEInt(), "bricks", "1", 0, 1, IndentBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lineBreakBrickEClass, LineBreakBrick.class, "LineBreakBrick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(viewableBrickEClass, ViewableBrick.class, "ViewableBrick", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getViewableBrick_Editable(), ecorePackage.getEBoolean(), "editable", null, 0, 1, ViewableBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewableBrick_Highlight(), ecorePackage.getEBoolean(), "highlight", null, 0, 1, ViewableBrick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getViewableBrick__GetText(), ecorePackage.getEString(), "getText", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CodebricksPackageImpl
