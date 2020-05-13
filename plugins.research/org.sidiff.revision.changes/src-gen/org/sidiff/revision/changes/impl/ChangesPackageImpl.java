/**
 */
package org.sidiff.revision.changes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.sidiff.revision.changes.AttributeBinding;
import org.sidiff.revision.changes.AttributeChange;
import org.sidiff.revision.changes.AttributeDomain;
import org.sidiff.revision.changes.AttributeInstantiation;
import org.sidiff.revision.changes.AttributeNodeBinding;
import org.sidiff.revision.changes.AttributeNodeDomain;
import org.sidiff.revision.changes.AttributeNodeDomainDefinition;
import org.sidiff.revision.changes.AttributeValueBinding;
import org.sidiff.revision.changes.AttributeValueDomain;
import org.sidiff.revision.changes.AttributeValueDomainDefinition;
import org.sidiff.revision.changes.Change;
import org.sidiff.revision.changes.ChangeInstantiation;
import org.sidiff.revision.changes.ChangesFactory;
import org.sidiff.revision.changes.ChangesPackage;
import org.sidiff.revision.changes.EdgeBinding;
import org.sidiff.revision.changes.EdgeChange;
import org.sidiff.revision.changes.EdgeDomain;
import org.sidiff.revision.changes.EdgeInstantiation;
import org.sidiff.revision.changes.EdgeSourceBinding;
import org.sidiff.revision.changes.EdgeSourceDomain;
import org.sidiff.revision.changes.EdgeSourceDomainDefinition;
import org.sidiff.revision.changes.EdgeTargetBinding;
import org.sidiff.revision.changes.EdgeTargetDomain;
import org.sidiff.revision.changes.EdgeTargetDomainDefinition;
import org.sidiff.revision.changes.NodeBinding;
import org.sidiff.revision.changes.NodeChange;
import org.sidiff.revision.changes.NodeChangeDomain;
import org.sidiff.revision.changes.NodeChangeDomainDefinition;
import org.sidiff.revision.changes.NodeDomain;
import org.sidiff.revision.changes.NodeInstantiation;

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
	private EClass nodeDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeDomainEClass = null;

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
	private EClass attributeBindingEClass = null;

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
	private EClass edgeDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeInstantiationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changeInstantiationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeInstantiationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeInstantiationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeNodeDomainDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeValueDomainDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeNodeDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeValueDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeNodeBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeValueBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeSourceDomainDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeTargetDomainDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeSourceDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeTargetDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeSourceBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeTargetBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeChangeDomainDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeChangeDomainEClass = null;

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

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

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
	public EOperation getNodeChange__GetType() {
		return nodeChangeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeDomain() {
		return nodeDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeBinding() {
		return nodeBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodeBinding__GetNode() {
		return nodeBindingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeDomain() {
		return attributeDomainEClass;
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
	public EOperation getAttributeChange__GetValueType() {
		return attributeChangeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeBinding() {
		return attributeBindingEClass;
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
	public EOperation getEdgeChange__GetTargetType() {
		return edgeChangeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeDomain() {
		return edgeDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeBinding() {
		return edgeBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeInstantiation() {
		return attributeInstantiationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getChangeInstantiation() {
		return changeInstantiationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeInstantiation() {
		return nodeInstantiationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeInstantiation() {
		return edgeInstantiationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeNodeDomainDefinition() {
		return attributeNodeDomainDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeNodeDomainDefinition__NodeDomainContains__EObject() {
		return attributeNodeDomainDefinitionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeValueDomainDefinition() {
		return attributeValueDomainDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeValueDomainDefinition__ValueDomainContains__Object() {
		return attributeValueDomainDefinitionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeNodeDomain() {
		return attributeNodeDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeNodeDomain__GetNodeDomain() {
		return attributeNodeDomainEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeValueDomain() {
		return attributeValueDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeValueDomain__GetValueDomain() {
		return attributeValueDomainEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeNodeBinding() {
		return attributeNodeBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeNodeBinding__GetNode() {
		return attributeNodeBindingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeValueBinding() {
		return attributeValueBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributeValueBinding__GetValue() {
		return attributeValueBindingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeSourceDomainDefinition() {
		return edgeSourceDomainDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeSourceDomainDefinition__SourceDomainContains__EObject() {
		return edgeSourceDomainDefinitionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeTargetDomainDefinition() {
		return edgeTargetDomainDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeTargetDomainDefinition__TargetDomainContains__EObject() {
		return edgeTargetDomainDefinitionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeSourceDomain() {
		return edgeSourceDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeSourceDomain__GetSourceDomain() {
		return edgeSourceDomainEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeTargetDomain() {
		return edgeTargetDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeTargetDomain__GetTargetDomain() {
		return edgeTargetDomainEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeSourceBinding() {
		return edgeSourceBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeSourceBinding__GetSource() {
		return edgeSourceBindingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgeTargetBinding() {
		return edgeTargetBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEdgeTargetBinding__GetTarget() {
		return edgeTargetBindingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeChangeDomainDefinition() {
		return nodeChangeDomainDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodeChangeDomainDefinition__NodeDomainContains__EObject() {
		return nodeChangeDomainDefinitionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeChangeDomain() {
		return nodeChangeDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodeChangeDomain__GetNodeDomains() {
		return nodeChangeDomainEClass.getEOperations().get(0);
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
		changeEClass = createEClass(CHANGE);
		createEOperation(changeEClass, CHANGE___GET_ACTION);

		nodeChangeEClass = createEClass(NODE_CHANGE);
		createEOperation(nodeChangeEClass, NODE_CHANGE___GET_TYPE);

		nodeDomainEClass = createEClass(NODE_DOMAIN);

		nodeBindingEClass = createEClass(NODE_BINDING);
		createEOperation(nodeBindingEClass, NODE_BINDING___GET_NODE);

		attributeDomainEClass = createEClass(ATTRIBUTE_DOMAIN);

		attributeChangeEClass = createEClass(ATTRIBUTE_CHANGE);
		createEOperation(attributeChangeEClass, ATTRIBUTE_CHANGE___GET_TYPE);
		createEOperation(attributeChangeEClass, ATTRIBUTE_CHANGE___GET_NODE_TYPE);
		createEOperation(attributeChangeEClass, ATTRIBUTE_CHANGE___GET_VALUE_TYPE);

		attributeBindingEClass = createEClass(ATTRIBUTE_BINDING);

		edgeChangeEClass = createEClass(EDGE_CHANGE);
		createEOperation(edgeChangeEClass, EDGE_CHANGE___GET_TYPE);
		createEOperation(edgeChangeEClass, EDGE_CHANGE___GE_SOURCE_TYPE);
		createEOperation(edgeChangeEClass, EDGE_CHANGE___GET_TARGET_TYPE);

		edgeDomainEClass = createEClass(EDGE_DOMAIN);

		edgeBindingEClass = createEClass(EDGE_BINDING);

		attributeInstantiationEClass = createEClass(ATTRIBUTE_INSTANTIATION);

		changeInstantiationEClass = createEClass(CHANGE_INSTANTIATION);

		nodeInstantiationEClass = createEClass(NODE_INSTANTIATION);

		edgeInstantiationEClass = createEClass(EDGE_INSTANTIATION);

		attributeNodeDomainDefinitionEClass = createEClass(ATTRIBUTE_NODE_DOMAIN_DEFINITION);
		createEOperation(attributeNodeDomainDefinitionEClass,
				ATTRIBUTE_NODE_DOMAIN_DEFINITION___NODE_DOMAIN_CONTAINS__EOBJECT);

		attributeValueDomainDefinitionEClass = createEClass(ATTRIBUTE_VALUE_DOMAIN_DEFINITION);
		createEOperation(attributeValueDomainDefinitionEClass,
				ATTRIBUTE_VALUE_DOMAIN_DEFINITION___VALUE_DOMAIN_CONTAINS__OBJECT);

		attributeNodeDomainEClass = createEClass(ATTRIBUTE_NODE_DOMAIN);
		createEOperation(attributeNodeDomainEClass, ATTRIBUTE_NODE_DOMAIN___GET_NODE_DOMAIN);

		attributeValueDomainEClass = createEClass(ATTRIBUTE_VALUE_DOMAIN);
		createEOperation(attributeValueDomainEClass, ATTRIBUTE_VALUE_DOMAIN___GET_VALUE_DOMAIN);

		attributeNodeBindingEClass = createEClass(ATTRIBUTE_NODE_BINDING);
		createEOperation(attributeNodeBindingEClass, ATTRIBUTE_NODE_BINDING___GET_NODE);

		attributeValueBindingEClass = createEClass(ATTRIBUTE_VALUE_BINDING);
		createEOperation(attributeValueBindingEClass, ATTRIBUTE_VALUE_BINDING___GET_VALUE);

		edgeSourceDomainDefinitionEClass = createEClass(EDGE_SOURCE_DOMAIN_DEFINITION);
		createEOperation(edgeSourceDomainDefinitionEClass,
				EDGE_SOURCE_DOMAIN_DEFINITION___SOURCE_DOMAIN_CONTAINS__EOBJECT);

		edgeTargetDomainDefinitionEClass = createEClass(EDGE_TARGET_DOMAIN_DEFINITION);
		createEOperation(edgeTargetDomainDefinitionEClass,
				EDGE_TARGET_DOMAIN_DEFINITION___TARGET_DOMAIN_CONTAINS__EOBJECT);

		edgeSourceDomainEClass = createEClass(EDGE_SOURCE_DOMAIN);
		createEOperation(edgeSourceDomainEClass, EDGE_SOURCE_DOMAIN___GET_SOURCE_DOMAIN);

		edgeTargetDomainEClass = createEClass(EDGE_TARGET_DOMAIN);
		createEOperation(edgeTargetDomainEClass, EDGE_TARGET_DOMAIN___GET_TARGET_DOMAIN);

		edgeSourceBindingEClass = createEClass(EDGE_SOURCE_BINDING);
		createEOperation(edgeSourceBindingEClass, EDGE_SOURCE_BINDING___GET_SOURCE);

		edgeTargetBindingEClass = createEClass(EDGE_TARGET_BINDING);
		createEOperation(edgeTargetBindingEClass, EDGE_TARGET_BINDING___GET_TARGET);

		nodeChangeDomainDefinitionEClass = createEClass(NODE_CHANGE_DOMAIN_DEFINITION);
		createEOperation(nodeChangeDomainDefinitionEClass,
				NODE_CHANGE_DOMAIN_DEFINITION___NODE_DOMAIN_CONTAINS__EOBJECT);

		nodeChangeDomainEClass = createEClass(NODE_CHANGE_DOMAIN);
		createEOperation(nodeChangeDomainEClass, NODE_CHANGE_DOMAIN___GET_NODE_DOMAINS);
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

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE
				.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		nodeChangeEClass.getESuperTypes().add(this.getChange());
		nodeDomainEClass.getESuperTypes().add(this.getNodeInstantiation());
		nodeBindingEClass.getESuperTypes().add(this.getNodeInstantiation());
		attributeDomainEClass.getESuperTypes().add(this.getAttributeInstantiation());
		attributeChangeEClass.getESuperTypes().add(this.getChange());
		attributeBindingEClass.getESuperTypes().add(this.getAttributeInstantiation());
		edgeChangeEClass.getESuperTypes().add(this.getChange());
		edgeDomainEClass.getESuperTypes().add(this.getEdgeInstantiation());
		edgeBindingEClass.getESuperTypes().add(this.getEdgeInstantiation());
		attributeInstantiationEClass.getESuperTypes().add(this.getChangeInstantiation());
		nodeInstantiationEClass.getESuperTypes().add(this.getChangeInstantiation());
		edgeInstantiationEClass.getESuperTypes().add(this.getChangeInstantiation());
		attributeNodeDomainDefinitionEClass.getESuperTypes().add(this.getAttributeDomain());
		attributeValueDomainDefinitionEClass.getESuperTypes().add(this.getAttributeDomain());
		attributeNodeDomainEClass.getESuperTypes().add(this.getAttributeNodeDomainDefinition());
		attributeValueDomainEClass.getESuperTypes().add(this.getAttributeValueDomainDefinition());
		attributeNodeBindingEClass.getESuperTypes().add(this.getAttributeBinding());
		attributeValueBindingEClass.getESuperTypes().add(this.getAttributeBinding());
		edgeSourceDomainDefinitionEClass.getESuperTypes().add(this.getEdgeDomain());
		edgeTargetDomainDefinitionEClass.getESuperTypes().add(this.getEdgeDomain());
		edgeSourceDomainEClass.getESuperTypes().add(this.getEdgeSourceDomainDefinition());
		edgeTargetDomainEClass.getESuperTypes().add(this.getEdgeTargetDomainDefinition());
		edgeSourceBindingEClass.getESuperTypes().add(this.getEdgeBinding());
		edgeTargetBindingEClass.getESuperTypes().add(this.getEdgeBinding());
		nodeChangeDomainDefinitionEClass.getESuperTypes().add(this.getNodeDomain());
		nodeChangeDomainEClass.getESuperTypes().add(this.getNodeChangeDomainDefinition());

		// Initialize classes, features, and operations; add parameters
		initEClass(changeEClass, Change.class, "Change", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getChange__GetAction(), null, "getAction", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nodeChangeEClass, NodeChange.class, "NodeChange", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getNodeChange__GetType(), ecorePackage.getEClass(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nodeDomainEClass, NodeDomain.class, "NodeDomain", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(nodeBindingEClass, NodeBinding.class, "NodeBinding", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getNodeBinding__GetNode(), ecorePackage.getEObject(), "getNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeDomainEClass, AttributeDomain.class, "AttributeDomain", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeChangeEClass, AttributeChange.class, "AttributeChange", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getAttributeChange__GetType(), ecorePackage.getEAttribute(), "getType", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEOperation(getAttributeChange__GetNodeType(), ecorePackage.getEClass(), "getNodeType", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEOperation(getAttributeChange__GetValueType(), ecorePackage.getEDataType(), "getValueType", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(attributeBindingEClass, AttributeBinding.class, "AttributeBinding", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(edgeChangeEClass, EdgeChange.class, "EdgeChange", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEdgeChange__GetType(), ecorePackage.getEReference(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getEdgeChange__GeSourceType(), ecorePackage.getEClass(), "geSourceType", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEOperation(getEdgeChange__GetTargetType(), ecorePackage.getEClass(), "getTargetType", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(edgeDomainEClass, EdgeDomain.class, "EdgeDomain", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(edgeBindingEClass, EdgeBinding.class, "EdgeBinding", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeInstantiationEClass, AttributeInstantiation.class, "AttributeInstantiation", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(changeInstantiationEClass, ChangeInstantiation.class, "ChangeInstantiation", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nodeInstantiationEClass, NodeInstantiation.class, "NodeInstantiation", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(edgeInstantiationEClass, EdgeInstantiation.class, "EdgeInstantiation", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeNodeDomainDefinitionEClass, AttributeNodeDomainDefinition.class,
				"AttributeNodeDomainDefinition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getAttributeNodeDomainDefinition__NodeDomainContains__EObject(),
				ecorePackage.getEBoolean(), "nodeDomainContains", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeValueDomainDefinitionEClass, AttributeValueDomainDefinition.class,
				"AttributeValueDomainDefinition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getAttributeValueDomainDefinition__ValueDomainContains__Object(),
				ecorePackage.getEBoolean(), "valueDomainContains", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeNodeDomainEClass, AttributeNodeDomain.class, "AttributeNodeDomain", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getAttributeNodeDomain__GetNodeDomain(), ecorePackage.getEObject(), "getNodeDomain", 0, -1,
				IS_UNIQUE, !IS_ORDERED);

		initEClass(attributeValueDomainEClass, AttributeValueDomain.class, "AttributeValueDomain", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getAttributeValueDomain__GetValueDomain(), ecorePackage.getEJavaObject(), "getValueDomain", 0,
				-1, IS_UNIQUE, !IS_ORDERED);

		initEClass(attributeNodeBindingEClass, AttributeNodeBinding.class, "AttributeNodeBinding", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getAttributeNodeBinding__GetNode(), ecorePackage.getEObject(), "getNode", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(attributeValueBindingEClass, AttributeValueBinding.class, "AttributeValueBinding", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getAttributeValueBinding__GetValue(), ecorePackage.getEJavaObject(), "getValue", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(edgeSourceDomainDefinitionEClass, EdgeSourceDomainDefinition.class, "EdgeSourceDomainDefinition",
				IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getEdgeSourceDomainDefinition__SourceDomainContains__EObject(),
				theXMLTypePackage.getBoolean(), "sourceDomainContains", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "sourceNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(edgeTargetDomainDefinitionEClass, EdgeTargetDomainDefinition.class, "EdgeTargetDomainDefinition",
				IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getEdgeTargetDomainDefinition__TargetDomainContains__EObject(), ecorePackage.getEBoolean(),
				"targetDomainContains", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "targetNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(edgeSourceDomainEClass, EdgeSourceDomain.class, "EdgeSourceDomain", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEdgeSourceDomain__GetSourceDomain(), ecorePackage.getEObject(), "getSourceDomain", 0, -1,
				IS_UNIQUE, !IS_ORDERED);

		initEClass(edgeTargetDomainEClass, EdgeTargetDomain.class, "EdgeTargetDomain", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEdgeTargetDomain__GetTargetDomain(), ecorePackage.getEObject(), "getTargetDomain", 0, -1,
				IS_UNIQUE, !IS_ORDERED);

		initEClass(edgeSourceBindingEClass, EdgeSourceBinding.class, "EdgeSourceBinding", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEdgeSourceBinding__GetSource(), ecorePackage.getEObject(), "getSource", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(edgeTargetBindingEClass, EdgeTargetBinding.class, "EdgeTargetBinding", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEdgeTargetBinding__GetTarget(), ecorePackage.getEObject(), "getTarget", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(nodeChangeDomainDefinitionEClass, NodeChangeDomainDefinition.class, "NodeChangeDomainDefinition",
				IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getNodeChangeDomainDefinition__NodeDomainContains__EObject(), ecorePackage.getEBoolean(),
				"nodeDomainContains", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nodeChangeDomainEClass, NodeChangeDomain.class, "NodeChangeDomain", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getNodeChangeDomain__GetNodeDomains(), ecorePackage.getEObject(), "getNodeDomains", 0, -1,
				IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ChangesPackageImpl
