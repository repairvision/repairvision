/**
 */
package org.sidiff.graphpattern.profile.henshin_extension.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.profile.henshin_extension.AttributeExtension;
import org.sidiff.graphpattern.profile.henshin_extension.EdgeExtension;
import org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension;
import org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionFactory;
import org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage;
import org.sidiff.graphpattern.profile.henshin_extension.NodeExtension;
import org.sidiff.graphpattern.profile.henshin_extension.RuleExtension;
import org.sidiff.graphpattern.profile.henshin_extension.SubGraph;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HenshinExtensionPackageImpl extends EPackageImpl implements HenshinExtensionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphElementExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeExtensionEClass = null;

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
	 * @see org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HenshinExtensionPackageImpl() {
		super(eNS_URI, HenshinExtensionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link HenshinExtensionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HenshinExtensionPackage init() {
		if (isInited) return (HenshinExtensionPackage)EPackage.Registry.INSTANCE.getEPackage(HenshinExtensionPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredHenshinExtensionPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		HenshinExtensionPackageImpl theHenshinExtensionPackage = registeredHenshinExtensionPackage instanceof HenshinExtensionPackageImpl ? (HenshinExtensionPackageImpl)registeredHenshinExtensionPackage : new HenshinExtensionPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		GraphpatternPackage.eINSTANCE.eClass();
		HenshinPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theHenshinExtensionPackage.createPackageContents();

		// Initialize created meta-data
		theHenshinExtensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHenshinExtensionPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HenshinExtensionPackage.eNS_URI, theHenshinExtensionPackage);
		return theHenshinExtensionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRuleExtension() {
		return ruleExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRuleExtension_Subgraphs() {
		return (EReference)ruleExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSubGraph() {
		return subGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubGraph_Subgraphs() {
		return (EReference)subGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubGraph_Elements() {
		return (EReference)subGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGraphElementExtension() {
		return graphElementExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphElementExtension_Subgraphs() {
		return (EReference)graphElementExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeExtension() {
		return nodeExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeExtension() {
		return edgeExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeExtension() {
		return attributeExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HenshinExtensionFactory getHenshinExtensionFactory() {
		return (HenshinExtensionFactory)getEFactoryInstance();
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
		ruleExtensionEClass = createEClass(RULE_EXTENSION);
		createEReference(ruleExtensionEClass, RULE_EXTENSION__SUBGRAPHS);

		subGraphEClass = createEClass(SUB_GRAPH);
		createEReference(subGraphEClass, SUB_GRAPH__SUBGRAPHS);
		createEReference(subGraphEClass, SUB_GRAPH__ELEMENTS);

		graphElementExtensionEClass = createEClass(GRAPH_ELEMENT_EXTENSION);
		createEReference(graphElementExtensionEClass, GRAPH_ELEMENT_EXTENSION__SUBGRAPHS);

		nodeExtensionEClass = createEClass(NODE_EXTENSION);

		edgeExtensionEClass = createEClass(EDGE_EXTENSION);

		attributeExtensionEClass = createEClass(ATTRIBUTE_EXTENSION);
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
		HenshinPackage theHenshinPackage = (HenshinPackage)EPackage.Registry.INSTANCE.getEPackage(HenshinPackage.eNS_URI);
		GraphpatternPackage theGraphpatternPackage = (GraphpatternPackage)EPackage.Registry.INSTANCE.getEPackage(GraphpatternPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ruleExtensionEClass.getESuperTypes().add(theHenshinPackage.getRule());
		subGraphEClass.getESuperTypes().add(theGraphpatternPackage.getPatternElement());
		nodeExtensionEClass.getESuperTypes().add(theHenshinPackage.getNode());
		nodeExtensionEClass.getESuperTypes().add(this.getGraphElementExtension());
		edgeExtensionEClass.getESuperTypes().add(theHenshinPackage.getEdge());
		edgeExtensionEClass.getESuperTypes().add(this.getGraphElementExtension());
		attributeExtensionEClass.getESuperTypes().add(theHenshinPackage.getAttribute());
		attributeExtensionEClass.getESuperTypes().add(this.getGraphElementExtension());

		// Initialize classes and features; add operations and parameters
		initEClass(ruleExtensionEClass, RuleExtension.class, "RuleExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleExtension_Subgraphs(), this.getSubGraph(), null, "subgraphs", null, 0, -1, RuleExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subGraphEClass, SubGraph.class, "SubGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubGraph_Subgraphs(), this.getSubGraph(), null, "subgraphs", null, 0, -1, SubGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubGraph_Elements(), this.getGraphElementExtension(), this.getGraphElementExtension_Subgraphs(), "elements", null, 0, -1, SubGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphElementExtensionEClass, GraphElementExtension.class, "GraphElementExtension", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphElementExtension_Subgraphs(), this.getSubGraph(), this.getSubGraph_Elements(), "subgraphs", null, 0, -1, GraphElementExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeExtensionEClass, NodeExtension.class, "NodeExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(edgeExtensionEClass, EdgeExtension.class, "EdgeExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeExtensionEClass, AttributeExtension.class, "AttributeExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //HenshinExtensionPackageImpl
