/**
 */
package org.sidiff.revision.difference.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferenceFactory;
import org.sidiff.revision.difference.DifferencePackage;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DifferencePackageImpl extends EPackageImpl implements DifferencePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass differenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correspondenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeValueChangeEClass = null;

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
	 * @see org.sidiff.revision.difference.DifferencePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DifferencePackageImpl() {
		super(eNS_URI, DifferenceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DifferencePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DifferencePackage init() {
		if (isInited) return (DifferencePackage)EPackage.Registry.INSTANCE.getEPackage(DifferencePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDifferencePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DifferencePackageImpl theDifferencePackage = registeredDifferencePackage instanceof DifferencePackageImpl ? (DifferencePackageImpl)registeredDifferencePackage : new DifferencePackageImpl();

		isInited = true;

		// Create package meta-data objects
		theDifferencePackage.createPackageContents();

		// Initialize created meta-data
		theDifferencePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDifferencePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DifferencePackage.eNS_URI, theDifferencePackage);
		return theDifferencePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDifference() {
		return differenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDifference_Changes() {
		return (EReference)differenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDifference_UriModelA() {
		return (EAttribute)differenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDifference_UriModelB() {
		return (EAttribute)differenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDifference_ModelA() {
		return (EAttribute)differenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDifference_ModelB() {
		return (EAttribute)differenceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDifference_Correspondences() {
		return (EReference)differenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCorrespondence() {
		return correspondenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCorrespondence_MatchedA() {
		return (EReference)correspondenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCorrespondence_MatchedB() {
		return (EReference)correspondenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getChange() {
		return changeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAddObject() {
		return addObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAddObject_Obj() {
		return (EReference)addObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRemoveObject() {
		return removeObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRemoveObject_Obj() {
		return (EReference)removeObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAddReference() {
		return addReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAddReference_Src() {
		return (EReference)addReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAddReference_Tgt() {
		return (EReference)addReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAddReference_Type() {
		return (EReference)addReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRemoveReference() {
		return removeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRemoveReference_Src() {
		return (EReference)removeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRemoveReference_Tgt() {
		return (EReference)removeReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRemoveReference_Type() {
		return (EReference)removeReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeValueChange() {
		return attributeValueChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeValueChange_ObjA() {
		return (EReference)attributeValueChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeValueChange_ObjB() {
		return (EReference)attributeValueChangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeValueChange_Type() {
		return (EReference)attributeValueChangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DifferenceFactory getDifferenceFactory() {
		return (DifferenceFactory)getEFactoryInstance();
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
		differenceEClass = createEClass(DIFFERENCE);
		createEReference(differenceEClass, DIFFERENCE__CHANGES);
		createEReference(differenceEClass, DIFFERENCE__CORRESPONDENCES);
		createEAttribute(differenceEClass, DIFFERENCE__URI_MODEL_A);
		createEAttribute(differenceEClass, DIFFERENCE__URI_MODEL_B);
		createEAttribute(differenceEClass, DIFFERENCE__MODEL_A);
		createEAttribute(differenceEClass, DIFFERENCE__MODEL_B);

		correspondenceEClass = createEClass(CORRESPONDENCE);
		createEReference(correspondenceEClass, CORRESPONDENCE__MATCHED_A);
		createEReference(correspondenceEClass, CORRESPONDENCE__MATCHED_B);

		changeEClass = createEClass(CHANGE);

		addObjectEClass = createEClass(ADD_OBJECT);
		createEReference(addObjectEClass, ADD_OBJECT__OBJ);

		removeObjectEClass = createEClass(REMOVE_OBJECT);
		createEReference(removeObjectEClass, REMOVE_OBJECT__OBJ);

		addReferenceEClass = createEClass(ADD_REFERENCE);
		createEReference(addReferenceEClass, ADD_REFERENCE__SRC);
		createEReference(addReferenceEClass, ADD_REFERENCE__TGT);
		createEReference(addReferenceEClass, ADD_REFERENCE__TYPE);

		removeReferenceEClass = createEClass(REMOVE_REFERENCE);
		createEReference(removeReferenceEClass, REMOVE_REFERENCE__SRC);
		createEReference(removeReferenceEClass, REMOVE_REFERENCE__TGT);
		createEReference(removeReferenceEClass, REMOVE_REFERENCE__TYPE);

		attributeValueChangeEClass = createEClass(ATTRIBUTE_VALUE_CHANGE);
		createEReference(attributeValueChangeEClass, ATTRIBUTE_VALUE_CHANGE__OBJ_A);
		createEReference(attributeValueChangeEClass, ATTRIBUTE_VALUE_CHANGE__OBJ_B);
		createEReference(attributeValueChangeEClass, ATTRIBUTE_VALUE_CHANGE__TYPE);
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
		addObjectEClass.getESuperTypes().add(this.getChange());
		removeObjectEClass.getESuperTypes().add(this.getChange());
		addReferenceEClass.getESuperTypes().add(this.getChange());
		removeReferenceEClass.getESuperTypes().add(this.getChange());
		attributeValueChangeEClass.getESuperTypes().add(this.getChange());

		// Initialize classes and features; add operations and parameters
		initEClass(differenceEClass, Difference.class, "Difference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDifference_Changes(), this.getChange(), null, "changes", null, 0, -1, Difference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDifference_Correspondences(), this.getCorrespondence(), null, "correspondences", null, 0, -1, Difference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDifference_UriModelA(), ecorePackage.getEString(), "uriModelA", null, 0, 1, Difference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDifference_UriModelB(), ecorePackage.getEString(), "uriModelB", null, 0, 1, Difference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDifference_ModelA(), ecorePackage.getEResource(), "modelA", null, 0, 1, Difference.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDifference_ModelB(), ecorePackage.getEResource(), "modelB", null, 0, 1, Difference.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(differenceEClass, ecorePackage.getEObject(), "getCorrespondingObjectInA", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "objectInB", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(differenceEClass, ecorePackage.getEObject(), "getCorrespondingObjectInB", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "objectInA", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(differenceEClass, this.getCorrespondence(), "getCorrespondenceOfModelA", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "objectInA", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(differenceEClass, this.getCorrespondence(), "getCorrespondenceOfModelB", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "objectInB", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(differenceEClass, null, "addCorrespondence", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getCorrespondence(), "correspondence", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(differenceEClass, null, "addCorrespondence", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "objA", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "objB", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(differenceEClass, null, "removeCorrespondence", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getCorrespondence(), "correspondence", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(differenceEClass, ecorePackage.getEBoolean(), "isUnmatchedA", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "objectInA", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(differenceEClass, ecorePackage.getEBoolean(), "isUnmatchedB", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "objectInB", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(correspondenceEClass, Correspondence.class, "Correspondence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCorrespondence_MatchedA(), ecorePackage.getEObject(), null, "matchedA", null, 1, 1, Correspondence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCorrespondence_MatchedB(), ecorePackage.getEObject(), null, "matchedB", null, 1, 1, Correspondence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(changeEClass, Change.class, "Change", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addObjectEClass, AddObject.class, "AddObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddObject_Obj(), ecorePackage.getEObject(), null, "obj", null, 0, 1, AddObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removeObjectEClass, RemoveObject.class, "RemoveObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemoveObject_Obj(), ecorePackage.getEObject(), null, "obj", null, 0, 1, RemoveObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addReferenceEClass, AddReference.class, "AddReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddReference_Src(), ecorePackage.getEObject(), null, "src", null, 0, 1, AddReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddReference_Tgt(), ecorePackage.getEObject(), null, "tgt", null, 0, 1, AddReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddReference_Type(), ecorePackage.getEReference(), null, "type", null, 0, 1, AddReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removeReferenceEClass, RemoveReference.class, "RemoveReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemoveReference_Src(), ecorePackage.getEObject(), null, "src", null, 0, 1, RemoveReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemoveReference_Tgt(), ecorePackage.getEObject(), null, "tgt", null, 0, 1, RemoveReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemoveReference_Type(), ecorePackage.getEReference(), null, "type", null, 0, 1, RemoveReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeValueChangeEClass, AttributeValueChange.class, "AttributeValueChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeValueChange_ObjA(), ecorePackage.getEObject(), null, "objA", null, 0, 1, AttributeValueChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeValueChange_ObjB(), ecorePackage.getEObject(), null, "objB", null, 0, 1, AttributeValueChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeValueChange_Type(), ecorePackage.getEAttribute(), null, "type", null, 0, 1, AttributeValueChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DifferencePackageImpl
