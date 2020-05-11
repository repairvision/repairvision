/**
 */
package org.sidiff.revision.changes.impl;

import java.util.Iterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sidiff.revision.changes.ActionType;
import org.sidiff.revision.changes.AttributeChange;
import org.sidiff.revision.changes.AttributeChangeContext;
import org.sidiff.revision.changes.Change;
import org.sidiff.revision.changes.ChangeContext;
import org.sidiff.revision.changes.ChangeSet;
import org.sidiff.revision.changes.ChangesFactory;
import org.sidiff.revision.changes.ChangesPackage;
import org.sidiff.revision.changes.EdgeChange;
import org.sidiff.revision.changes.EdgeChangeContext;
import org.sidiff.revision.changes.NodeChange;
import org.sidiff.revision.changes.NodeChangeContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChangesPackageImpl extends EPackageImpl implements ChangesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changeSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeChangeContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeChangeContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeChangeContextEClass = null;

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
	private EClass nodeChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changeContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum actionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType changeIteratorEDataType = null;

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
	 * @see org.sidiff.revision.changes.ChangesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ChangesPackageImpl() {
		super(eNS_URI, ChangesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ChangesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ChangesPackage init() {
		if (isInited)
			return (ChangesPackage) EPackage.Registry.INSTANCE.getEPackage(ChangesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredChangesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ChangesPackageImpl theChangesPackage = registeredChangesPackage instanceof ChangesPackageImpl
				? (ChangesPackageImpl) registeredChangesPackage
				: new ChangesPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theChangesPackage.createPackageContents();

		// Initialize created meta-data
		theChangesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theChangesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ChangesPackage.eNS_URI, theChangesPackage);
		return theChangesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getChangeSet() {
		return changeSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getChangeSet__GetChanges() {
		return changeSetEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeChangeContext() {
		return nodeChangeContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeChangeContext_Nodes() {
		return (EReference) nodeChangeContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodeChangeContext__GetNode__NodeChange() {
		return nodeChangeContextEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodeChangeContext__GetNodeDomains__NodeChange() {
		return nodeChangeContextEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodeChangeContext__GetType__NodeChange() {
		return nodeChangeContextEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeChangeContext() {
		return attributeChangeContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeChangeContext_Attributes() {
		return (EReference) attributeChangeContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChangeContext__GetType__AttributeChange() {
		return attributeChangeContextEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChangeContext__GetNode__AttributeChange() {
		return attributeChangeContextEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChangeContext__GetNodeType__AttributeChange() {
		return attributeChangeContextEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChangeContext__GetNodeDomain__AttributeChange() {
		return attributeChangeContextEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChangeContext__GetValueType__AttributeChange() {
		return attributeChangeContextEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChangeContext__GetValueDomain__AttributeChange() {
		return attributeChangeContextEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChangeContext__GetValue__AttributeChange() {
		return attributeChangeContextEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeChangeContext() {
		return edgeChangeContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdgeChangeContext_Edges() {
		return (EReference) edgeChangeContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChangeContext__GetTargetType__EdgeChange() {
		return edgeChangeContextEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChangeContext__GetType__EdgeChange() {
		return edgeChangeContextEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChangeContext__GetSourceType__EdgeChange() {
		return edgeChangeContextEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChangeContext__GetSource__EdgeChange() {
		return edgeChangeContextEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChangeContext__GetSourceDomain__EdgeChange() {
		return edgeChangeContextEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChangeContext__GetTarget__EdgeChange() {
		return edgeChangeContextEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChangeContext__GetTargetDomain__EdgeChange() {
		return edgeChangeContextEClass.getEOperations().get(5);
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
	public EOperation getChange__GetAction() {
		return changeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeChange() {
		return nodeChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeChange_Context() {
		return (EReference) nodeChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodeChange__GetType() {
		return nodeChangeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodeChange__GetNodeDomains() {
		return nodeChangeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodeChange__GetNode() {
		return nodeChangeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeChange() {
		return attributeChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeChange_Context() {
		return (EReference) attributeChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChange__GetType() {
		return attributeChangeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChange__GetNodeType() {
		return attributeChangeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChange__GetNodeDomain() {
		return attributeChangeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChange__GetNode() {
		return attributeChangeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChange__GetValueType() {
		return attributeChangeEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChange__GetValueDomain() {
		return attributeChangeEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeChange__GetValue() {
		return attributeChangeEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeChange() {
		return edgeChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdgeChange_Context() {
		return (EReference) edgeChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChange__GetType() {
		return edgeChangeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChange__GeSourceType() {
		return edgeChangeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChange__GetSourceDomain() {
		return edgeChangeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChange__GetSource() {
		return edgeChangeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChange__GetTargetType() {
		return edgeChangeEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChange__GetTargetDomain() {
		return edgeChangeEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeChange__GetTarget() {
		return edgeChangeEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getChangeContext() {
		return changeContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getChangeContext__GetAction__Change() {
		return changeContextEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getActionType() {
		return actionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getChangeIterator() {
		return changeIteratorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ChangesFactory getChangesFactory() {
		return (ChangesFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		changeSetEClass = createEClass(CHANGE_SET);
		createEOperation(changeSetEClass, CHANGE_SET___GET_CHANGES);

		nodeChangeContextEClass = createEClass(NODE_CHANGE_CONTEXT);
		createEReference(nodeChangeContextEClass, NODE_CHANGE_CONTEXT__NODES);
		createEOperation(nodeChangeContextEClass, NODE_CHANGE_CONTEXT___GET_NODE__NODECHANGE);
		createEOperation(nodeChangeContextEClass, NODE_CHANGE_CONTEXT___GET_NODE_DOMAINS__NODECHANGE);
		createEOperation(nodeChangeContextEClass, NODE_CHANGE_CONTEXT___GET_TYPE__NODECHANGE);

		attributeChangeContextEClass = createEClass(ATTRIBUTE_CHANGE_CONTEXT);
		createEReference(attributeChangeContextEClass, ATTRIBUTE_CHANGE_CONTEXT__ATTRIBUTES);
		createEOperation(attributeChangeContextEClass, ATTRIBUTE_CHANGE_CONTEXT___GET_TYPE__ATTRIBUTECHANGE);
		createEOperation(attributeChangeContextEClass, ATTRIBUTE_CHANGE_CONTEXT___GET_NODE__ATTRIBUTECHANGE);
		createEOperation(attributeChangeContextEClass, ATTRIBUTE_CHANGE_CONTEXT___GET_NODE_TYPE__ATTRIBUTECHANGE);
		createEOperation(attributeChangeContextEClass, ATTRIBUTE_CHANGE_CONTEXT___GET_NODE_DOMAIN__ATTRIBUTECHANGE);
		createEOperation(attributeChangeContextEClass, ATTRIBUTE_CHANGE_CONTEXT___GET_VALUE_TYPE__ATTRIBUTECHANGE);
		createEOperation(attributeChangeContextEClass, ATTRIBUTE_CHANGE_CONTEXT___GET_VALUE_DOMAIN__ATTRIBUTECHANGE);
		createEOperation(attributeChangeContextEClass, ATTRIBUTE_CHANGE_CONTEXT___GET_VALUE__ATTRIBUTECHANGE);

		edgeChangeContextEClass = createEClass(EDGE_CHANGE_CONTEXT);
		createEReference(edgeChangeContextEClass, EDGE_CHANGE_CONTEXT__EDGES);
		createEOperation(edgeChangeContextEClass, EDGE_CHANGE_CONTEXT___GET_TYPE__EDGECHANGE);
		createEOperation(edgeChangeContextEClass, EDGE_CHANGE_CONTEXT___GET_SOURCE_TYPE__EDGECHANGE);
		createEOperation(edgeChangeContextEClass, EDGE_CHANGE_CONTEXT___GET_SOURCE_DOMAIN__EDGECHANGE);
		createEOperation(edgeChangeContextEClass, EDGE_CHANGE_CONTEXT___GET_SOURCE__EDGECHANGE);
		createEOperation(edgeChangeContextEClass, EDGE_CHANGE_CONTEXT___GET_TARGET_TYPE__EDGECHANGE);
		createEOperation(edgeChangeContextEClass, EDGE_CHANGE_CONTEXT___GET_TARGET_DOMAIN__EDGECHANGE);
		createEOperation(edgeChangeContextEClass, EDGE_CHANGE_CONTEXT___GET_TARGET__EDGECHANGE);

		changeEClass = createEClass(CHANGE);
		createEOperation(changeEClass, CHANGE___GET_ACTION);

		nodeChangeEClass = createEClass(NODE_CHANGE);
		createEReference(nodeChangeEClass, NODE_CHANGE__CONTEXT);
		createEOperation(nodeChangeEClass, NODE_CHANGE___GET_TYPE);
		createEOperation(nodeChangeEClass, NODE_CHANGE___GET_NODE_DOMAINS);
		createEOperation(nodeChangeEClass, NODE_CHANGE___GET_NODE);

		attributeChangeEClass = createEClass(ATTRIBUTE_CHANGE);
		createEReference(attributeChangeEClass, ATTRIBUTE_CHANGE__CONTEXT);
		createEOperation(attributeChangeEClass, ATTRIBUTE_CHANGE___GET_TYPE);
		createEOperation(attributeChangeEClass, ATTRIBUTE_CHANGE___GET_NODE_TYPE);
		createEOperation(attributeChangeEClass, ATTRIBUTE_CHANGE___GET_NODE_DOMAIN);
		createEOperation(attributeChangeEClass, ATTRIBUTE_CHANGE___GET_NODE);
		createEOperation(attributeChangeEClass, ATTRIBUTE_CHANGE___GET_VALUE_TYPE);
		createEOperation(attributeChangeEClass, ATTRIBUTE_CHANGE___GET_VALUE_DOMAIN);
		createEOperation(attributeChangeEClass, ATTRIBUTE_CHANGE___GET_VALUE);

		edgeChangeEClass = createEClass(EDGE_CHANGE);
		createEReference(edgeChangeEClass, EDGE_CHANGE__CONTEXT);
		createEOperation(edgeChangeEClass, EDGE_CHANGE___GET_TYPE);
		createEOperation(edgeChangeEClass, EDGE_CHANGE___GE_SOURCE_TYPE);
		createEOperation(edgeChangeEClass, EDGE_CHANGE___GET_SOURCE_DOMAIN);
		createEOperation(edgeChangeEClass, EDGE_CHANGE___GET_SOURCE);
		createEOperation(edgeChangeEClass, EDGE_CHANGE___GET_TARGET_TYPE);
		createEOperation(edgeChangeEClass, EDGE_CHANGE___GET_TARGET_DOMAIN);
		createEOperation(edgeChangeEClass, EDGE_CHANGE___GET_TARGET);

		changeContextEClass = createEClass(CHANGE_CONTEXT);
		createEOperation(changeContextEClass, CHANGE_CONTEXT___GET_ACTION__CHANGE);

		// Create enums
		actionTypeEEnum = createEEnum(ACTION_TYPE);

		// Create data types
		changeIteratorEDataType = createEDataType(CHANGE_ITERATOR);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		changeSetEClass.getESuperTypes().add(this.getChangeContext());
		nodeChangeEClass.getESuperTypes().add(this.getChange());
		attributeChangeEClass.getESuperTypes().add(this.getChange());
		edgeChangeEClass.getESuperTypes().add(this.getChange());
		changeContextEClass.getESuperTypes().add(this.getNodeChangeContext());
		changeContextEClass.getESuperTypes().add(this.getEdgeChangeContext());
		changeContextEClass.getESuperTypes().add(this.getAttributeChangeContext());

		// Initialize classes, features, and operations; add parameters
		initEClass(changeSetEClass, ChangeSet.class, "ChangeSet", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getChangeSet__GetChanges(), this.getChangeIterator(), "getChanges", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nodeChangeContextEClass, NodeChangeContext.class, "NodeChangeContext", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeChangeContext_Nodes(), this.getNodeChange(), this.getNodeChange_Context(), "nodes", null,
				0, -1, NodeChangeContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getNodeChangeContext__GetNode__NodeChange(), ecorePackage.getEObject(),
				"getNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNodeChange(), "nodeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodeChangeContext__GetNodeDomains__NodeChange(), ecorePackage.getEObject(),
				"getNodeDomains", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNodeChange(), "nodeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodeChangeContext__GetType__NodeChange(), ecorePackage.getEClass(), "getType", 0, 1,
				IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNodeChange(), "nodeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeChangeContextEClass, AttributeChangeContext.class, "AttributeChangeContext", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeChangeContext_Attributes(), this.getAttributeChange(),
				this.getAttributeChange_Context(), "attributes", null, 0, -1, AttributeChangeContext.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getAttributeChangeContext__GetType__AttributeChange(), ecorePackage.getEAttribute(),
				"getType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAttributeChange(), "attributeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttributeChangeContext__GetNode__AttributeChange(), ecorePackage.getEObject(), "getNode",
				0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAttributeChange(), "attributeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttributeChangeContext__GetNodeType__AttributeChange(), ecorePackage.getEClass(),
				"getNodeType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAttributeChange(), "attributeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttributeChangeContext__GetNodeDomain__AttributeChange(), ecorePackage.getEObject(),
				"getNodeDomain", 0, -1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getAttributeChange(), "attributeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttributeChangeContext__GetValueType__AttributeChange(), ecorePackage.getEDataType(),
				"getValueType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAttributeChange(), "attributeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttributeChangeContext__GetValueDomain__AttributeChange(), ecorePackage.getEJavaObject(),
				"getValueDomain", 0, -1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getAttributeChange(), "attributeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttributeChangeContext__GetValue__AttributeChange(), ecorePackage.getEJavaObject(),
				"getValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAttributeChange(), "attributeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(edgeChangeContextEClass, EdgeChangeContext.class, "EdgeChangeContext", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdgeChangeContext_Edges(), this.getEdgeChange(), this.getEdgeChange_Context(), "edges", null,
				0, -1, EdgeChangeContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getEdgeChangeContext__GetType__EdgeChange(), ecorePackage.getEReference(), "getType", 0, 1,
				IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEdgeChange(), "edgeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEdgeChangeContext__GetSourceType__EdgeChange(), ecorePackage.getEClass(),
				"getSourceType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEdgeChange(), "edgeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEdgeChangeContext__GetSourceDomain__EdgeChange(), ecorePackage.getEObject(),
				"getSourceDomain", 0, -1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getEdgeChange(), "edgeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEdgeChangeContext__GetSource__EdgeChange(), ecorePackage.getEObject(), "getSource", 0, 1,
				IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEdgeChange(), "edgeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEdgeChangeContext__GetTargetType__EdgeChange(), ecorePackage.getEClass(),
				"getTargetType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEdgeChange(), "edgeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEdgeChangeContext__GetTargetDomain__EdgeChange(), ecorePackage.getEObject(),
				"getTargetDomain", 0, -1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getEdgeChange(), "edgeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEdgeChangeContext__GetTarget__EdgeChange(), ecorePackage.getEObject(), "getTarget", 0, 1,
				IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEdgeChange(), "edgeChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(changeEClass, Change.class, "Change", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getChange__GetAction(), this.getActionType(), "getAction", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nodeChangeEClass, NodeChange.class, "NodeChange", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeChange_Context(), this.getNodeChangeContext(), this.getNodeChangeContext_Nodes(),
				"context", null, 1, 1, NodeChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getNodeChange__GetType(), ecorePackage.getEClass(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getNodeChange__GetNodeDomains(), ecorePackage.getEObject(), "getNodeDomains", 0, -1, IS_UNIQUE,
				IS_ORDERED);

		initEOperation(getNodeChange__GetNode(), ecorePackage.getEObject(), "getNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeChangeEClass, AttributeChange.class, "AttributeChange", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeChange_Context(), this.getAttributeChangeContext(),
				this.getAttributeChangeContext_Attributes(), "context", null, 1, 1, AttributeChange.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAttributeChange__GetType(), ecorePackage.getEAttribute(), "getType", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEOperation(getAttributeChange__GetNodeType(), ecorePackage.getEClass(), "getNodeType", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEOperation(getAttributeChange__GetNodeDomain(), ecorePackage.getEObject(), "getNodeDomain", 0, -1,
				IS_UNIQUE, !IS_ORDERED);

		initEOperation(getAttributeChange__GetNode(), ecorePackage.getEObject(), "getNode", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEOperation(getAttributeChange__GetValueType(), ecorePackage.getEDataType(), "getValueType", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEOperation(getAttributeChange__GetValueDomain(), ecorePackage.getEJavaObject(), "getValueDomain", 0, -1,
				IS_UNIQUE, !IS_ORDERED);

		initEOperation(getAttributeChange__GetValue(), ecorePackage.getEJavaObject(), "getValue", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(edgeChangeEClass, EdgeChange.class, "EdgeChange", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdgeChange_Context(), this.getEdgeChangeContext(), this.getEdgeChangeContext_Edges(),
				"context", null, 1, 1, EdgeChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEdgeChange__GetType(), ecorePackage.getEReference(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getEdgeChange__GeSourceType(), ecorePackage.getEClass(), "geSourceType", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEOperation(getEdgeChange__GetSourceDomain(), ecorePackage.getEObject(), "getSourceDomain", 0, -1, IS_UNIQUE,
				!IS_ORDERED);

		initEOperation(getEdgeChange__GetSource(), ecorePackage.getEObject(), "getSource", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getEdgeChange__GetTargetType(), ecorePackage.getEClass(), "getTargetType", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEOperation(getEdgeChange__GetTargetDomain(), ecorePackage.getEObject(), "getTargetDomain", 0, -1, IS_UNIQUE,
				!IS_ORDERED);

		initEOperation(getEdgeChange__GetTarget(), ecorePackage.getEObject(), "getTarget", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(changeContextEClass, ChangeContext.class, "ChangeContext", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getChangeContext__GetAction__Change(), this.getActionType(), "getAction", 0, 1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, this.getChange(), "change", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(actionTypeEEnum, ActionType.class, "ActionType");
		addEEnumLiteral(actionTypeEEnum, ActionType.CREATE);
		addEEnumLiteral(actionTypeEEnum, ActionType.DELETE);
		addEEnumLiteral(actionTypeEEnum, ActionType.MODIFY);

		// Initialize data types
		initEDataType(changeIteratorEDataType, Iterator.class, "ChangeIterator", !IS_SERIALIZABLE,
				!IS_GENERATED_INSTANCE_CLASS, "java.util.Iterator<org.sidiff.revision.changes.Change>");

		// Create resource
		createResource(eNS_URI);
	}

} //ChangesPackageImpl
