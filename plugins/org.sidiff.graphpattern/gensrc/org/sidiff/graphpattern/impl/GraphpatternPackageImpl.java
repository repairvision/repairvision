/**
 */
package org.sidiff.graphpattern.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.sidiff.graphpattern.Assignment;
import org.sidiff.graphpattern.Association;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.DependencyEdge;
import org.sidiff.graphpattern.DependencyGraph;
import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.EObjectList;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.Extendable;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.Matching;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.ObjectBinding;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.ParameterBinding;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.PatternElement;
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Resource;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.SubGraph;
import org.sidiff.graphpattern.ValueBinding;
import org.sidiff.graphpattern.util.GraphpatternValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphpatternPackageImpl extends EPackageImpl implements GraphpatternPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodePatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgePatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributePatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bundleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eObjectListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueBindingEClass = null;

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
	private EClass graphElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass profileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eIteratorEDataType = null;

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
	 * @see org.sidiff.graphpattern.GraphpatternPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GraphpatternPackageImpl() {
		super(eNS_URI, GraphpatternFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GraphpatternPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GraphpatternPackage init() {
		if (isInited) return (GraphpatternPackage)EPackage.Registry.INSTANCE.getEPackage(GraphpatternPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredGraphpatternPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		GraphpatternPackageImpl theGraphpatternPackage = registeredGraphpatternPackage instanceof GraphpatternPackageImpl ? (GraphpatternPackageImpl)registeredGraphpatternPackage : new GraphpatternPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theGraphpatternPackage.createPackageContents();

		// Initialize created meta-data
		theGraphpatternPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theGraphpatternPackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return GraphpatternValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theGraphpatternPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GraphpatternPackage.eNS_URI, theGraphpatternPackage);
		return theGraphpatternPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGraphPattern() {
		return graphPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphPattern_Nodes() {
		return (EReference)graphPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphPattern_Pattern() {
		return (EReference)graphPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphPattern_DependencyGraph() {
		return (EReference)graphPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphPattern_Subgraphs() {
		return (EReference)graphPatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getGraphPattern__GetNode__String() {
		return graphPatternEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodePattern() {
		return nodePatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodePattern_Outgoings() {
		return (EReference)nodePatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodePattern_Type() {
		return (EReference)nodePatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodePattern_Attributes() {
		return (EReference)nodePatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodePattern_Matching() {
		return (EReference)nodePatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodePattern_Incomings() {
		return (EReference)nodePatternEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodePattern_Associations() {
		return (EReference)nodePatternEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodePattern__GetAttribute__EAttribute() {
		return nodePatternEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodePattern__GetOutgoing__EReference() {
		return nodePatternEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodePattern__GetOutgoing__EReference_NodePattern() {
		return nodePatternEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodePattern__GetOutgoing__EReference_NodePattern_Stereotype() {
		return nodePatternEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodePattern__GetOutgoings__EReference() {
		return nodePatternEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodePattern__GetIncoming__EReference() {
		return nodePatternEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodePattern__GetIncomings__EReference() {
		return nodePatternEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodePattern__GetIncident() {
		return nodePatternEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodePattern__GetIncident__NodePattern() {
		return nodePatternEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodePattern__RemoveIncident() {
		return nodePatternEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodePattern__RemoveIncident__NodePattern() {
		return nodePatternEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getNodePattern__GetAdjacent() {
		return nodePatternEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdgePattern() {
		return edgePatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdgePattern_Target() {
		return (EReference)edgePatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdgePattern_Source() {
		return (EReference)edgePatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdgePattern_Opposite() {
		return (EReference)edgePatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdgePattern_Type() {
		return (EReference)edgePatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributePattern() {
		return attributePatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributePattern_Value() {
		return (EAttribute)attributePatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributePattern_Type() {
		return (EReference)attributePatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributePattern_Node() {
		return (EReference)attributePatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributePattern_Constant() {
		return (EAttribute)attributePatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributePattern_Variables() {
		return (EAttribute)attributePatternEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributePattern__IsVariable() {
		return attributePatternEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributePattern__IsConstant() {
		return attributePatternEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAttributePattern__IsExpression() {
		return attributePatternEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMatching() {
		return matchingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMatching_Matches() {
		return (EReference)matchingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMatching_Node() {
		return (EReference)matchingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMatching__Iterator() {
		return matchingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMatching__Size() {
		return matchingEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMatching__IsEmpty() {
		return matchingEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMatching__Add__EObject() {
		return matchingEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMatching__Remove__EObject() {
		return matchingEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMatching__Contains__EObject() {
		return matchingEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMatching__Clear() {
		return matchingEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBundle() {
		return bundleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBundle_Profiles() {
		return (EReference)bundleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBundle_Domains() {
		return (EReference)bundleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEObjectList() {
		return eObjectListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEObjectList_Content() {
		return (EReference)eObjectListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEObjectList_Label() {
		return (EAttribute)eObjectListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDependencyGraph() {
		return dependencyGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependencyGraph_Independent() {
		return (EReference)dependencyGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependencyGraph_Graph() {
		return (EReference)dependencyGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependencyGraph_Nodes() {
		return (EReference)dependencyGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependencyGraph_Edges() {
		return (EReference)dependencyGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDependencyNode() {
		return dependencyNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependencyNode_Outgoings() {
		return (EReference)dependencyNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependencyNode_Incomings() {
		return (EReference)dependencyNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependencyNode_Nodes() {
		return (EReference)dependencyNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDependencyEdge() {
		return dependencyEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependencyEdge_Source() {
		return (EReference)dependencyEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependencyEdge_Target() {
		return (EReference)dependencyEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssociation() {
		return associationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssociation_Source() {
		return (EReference)associationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssociation_Target() {
		return (EReference)associationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStereotype() {
		return stereotypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStereotype_Name() {
		return (EAttribute)stereotypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStereotype_Profile() {
		return (EReference)stereotypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameterBinding() {
		return parameterBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameterBinding_Parameter() {
		return (EReference)parameterBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssignment() {
		return assignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssignment_Assignment() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssignment_Pattern() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectBinding() {
		return objectBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectBinding_Value() {
		return (EReference)objectBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValueBinding() {
		return valueBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValueBinding_Value() {
		return (EAttribute)valueBindingEClass.getEStructuralFeatures().get(0);
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
	public EReference getSubGraph_Elements() {
		return (EReference)subGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubGraph_Subgraphs() {
		return (EReference)subGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGraphElement() {
		return graphElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphElement_Subgraphs() {
		return (EReference)graphElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphElement_Graph() {
		return (EReference)graphElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProfile() {
		return profileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProfile_Stereotypes() {
		return (EReference)profileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProfile_Name() {
		return (EAttribute)profileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProfile_Description() {
		return (EAttribute)profileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProfile_Id() {
		return (EAttribute)profileEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getProfile__GetStereotype__String() {
		return profileEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getResource_Contents() {
		return (EReference)resourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExtendable() {
		return extendableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExtendable_Stereotypes() {
		return (EReference)extendableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPattern() {
		return patternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPattern_Graphs() {
		return (EReference)patternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPattern_Parameters() {
		return (EReference)patternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPattern_Assignments() {
		return (EReference)patternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPattern_Bundle() {
		return (EReference)patternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPattern_Patterns() {
		return (EReference)patternEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPattern__GetPattern__String() {
		return patternEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPattern__GetAllGraphPatterns() {
		return patternEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPattern__GetGraph__String() {
		return patternEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPattern__GetParameter__String() {
		return patternEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPatternElement() {
		return patternElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPatternElement_Name() {
		return (EAttribute)patternElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPatternElement_Description() {
		return (EAttribute)patternElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameter_Pattern() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getEIterator() {
		return eIteratorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphpatternFactory getGraphpatternFactory() {
		return (GraphpatternFactory)getEFactoryInstance();
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
		graphPatternEClass = createEClass(GRAPH_PATTERN);
		createEReference(graphPatternEClass, GRAPH_PATTERN__NODES);
		createEReference(graphPatternEClass, GRAPH_PATTERN__PATTERN);
		createEReference(graphPatternEClass, GRAPH_PATTERN__DEPENDENCY_GRAPH);
		createEReference(graphPatternEClass, GRAPH_PATTERN__SUBGRAPHS);
		createEOperation(graphPatternEClass, GRAPH_PATTERN___GET_NODE__STRING);

		nodePatternEClass = createEClass(NODE_PATTERN);
		createEReference(nodePatternEClass, NODE_PATTERN__OUTGOINGS);
		createEReference(nodePatternEClass, NODE_PATTERN__TYPE);
		createEReference(nodePatternEClass, NODE_PATTERN__ATTRIBUTES);
		createEReference(nodePatternEClass, NODE_PATTERN__MATCHING);
		createEReference(nodePatternEClass, NODE_PATTERN__INCOMINGS);
		createEReference(nodePatternEClass, NODE_PATTERN__ASSOCIATIONS);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_ATTRIBUTE__EATTRIBUTE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_OUTGOINGS__EREFERENCE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_OUTGOING__EREFERENCE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_OUTGOING__EREFERENCE_NODEPATTERN);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_OUTGOING__EREFERENCE_NODEPATTERN_STEREOTYPE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_INCOMING__EREFERENCE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_INCOMINGS__EREFERENCE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_INCIDENT);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_INCIDENT__NODEPATTERN);
		createEOperation(nodePatternEClass, NODE_PATTERN___REMOVE_INCIDENT);
		createEOperation(nodePatternEClass, NODE_PATTERN___REMOVE_INCIDENT__NODEPATTERN);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_ADJACENT);

		edgePatternEClass = createEClass(EDGE_PATTERN);
		createEReference(edgePatternEClass, EDGE_PATTERN__TARGET);
		createEReference(edgePatternEClass, EDGE_PATTERN__SOURCE);
		createEReference(edgePatternEClass, EDGE_PATTERN__OPPOSITE);
		createEReference(edgePatternEClass, EDGE_PATTERN__TYPE);

		attributePatternEClass = createEClass(ATTRIBUTE_PATTERN);
		createEAttribute(attributePatternEClass, ATTRIBUTE_PATTERN__VALUE);
		createEReference(attributePatternEClass, ATTRIBUTE_PATTERN__TYPE);
		createEReference(attributePatternEClass, ATTRIBUTE_PATTERN__NODE);
		createEAttribute(attributePatternEClass, ATTRIBUTE_PATTERN__CONSTANT);
		createEAttribute(attributePatternEClass, ATTRIBUTE_PATTERN__VARIABLES);
		createEOperation(attributePatternEClass, ATTRIBUTE_PATTERN___IS_CONSTANT);
		createEOperation(attributePatternEClass, ATTRIBUTE_PATTERN___IS_VARIABLE);
		createEOperation(attributePatternEClass, ATTRIBUTE_PATTERN___IS_EXPRESSION);

		matchingEClass = createEClass(MATCHING);
		createEReference(matchingEClass, MATCHING__MATCHES);
		createEReference(matchingEClass, MATCHING__NODE);
		createEOperation(matchingEClass, MATCHING___ITERATOR);
		createEOperation(matchingEClass, MATCHING___SIZE);
		createEOperation(matchingEClass, MATCHING___IS_EMPTY);
		createEOperation(matchingEClass, MATCHING___ADD__EOBJECT);
		createEOperation(matchingEClass, MATCHING___REMOVE__EOBJECT);
		createEOperation(matchingEClass, MATCHING___CONTAINS__EOBJECT);
		createEOperation(matchingEClass, MATCHING___CLEAR);

		bundleEClass = createEClass(BUNDLE);
		createEReference(bundleEClass, BUNDLE__PROFILES);
		createEReference(bundleEClass, BUNDLE__DOMAINS);

		patternEClass = createEClass(PATTERN);
		createEReference(patternEClass, PATTERN__GRAPHS);
		createEReference(patternEClass, PATTERN__PARAMETERS);
		createEReference(patternEClass, PATTERN__ASSIGNMENTS);
		createEReference(patternEClass, PATTERN__BUNDLE);
		createEReference(patternEClass, PATTERN__PATTERNS);
		createEOperation(patternEClass, PATTERN___GET_PATTERN__STRING);
		createEOperation(patternEClass, PATTERN___GET_PARAMETER__STRING);
		createEOperation(patternEClass, PATTERN___GET_GRAPH__STRING);
		createEOperation(patternEClass, PATTERN___GET_ALL_GRAPH_PATTERNS);

		patternElementEClass = createEClass(PATTERN_ELEMENT);
		createEAttribute(patternElementEClass, PATTERN_ELEMENT__NAME);
		createEAttribute(patternElementEClass, PATTERN_ELEMENT__DESCRIPTION);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__PATTERN);

		eObjectListEClass = createEClass(EOBJECT_LIST);
		createEReference(eObjectListEClass, EOBJECT_LIST__CONTENT);
		createEAttribute(eObjectListEClass, EOBJECT_LIST__LABEL);

		dependencyGraphEClass = createEClass(DEPENDENCY_GRAPH);
		createEReference(dependencyGraphEClass, DEPENDENCY_GRAPH__INDEPENDENT);
		createEReference(dependencyGraphEClass, DEPENDENCY_GRAPH__GRAPH);
		createEReference(dependencyGraphEClass, DEPENDENCY_GRAPH__NODES);
		createEReference(dependencyGraphEClass, DEPENDENCY_GRAPH__EDGES);

		dependencyNodeEClass = createEClass(DEPENDENCY_NODE);
		createEReference(dependencyNodeEClass, DEPENDENCY_NODE__OUTGOINGS);
		createEReference(dependencyNodeEClass, DEPENDENCY_NODE__INCOMINGS);
		createEReference(dependencyNodeEClass, DEPENDENCY_NODE__NODES);

		dependencyEdgeEClass = createEClass(DEPENDENCY_EDGE);
		createEReference(dependencyEdgeEClass, DEPENDENCY_EDGE__SOURCE);
		createEReference(dependencyEdgeEClass, DEPENDENCY_EDGE__TARGET);

		associationEClass = createEClass(ASSOCIATION);
		createEReference(associationEClass, ASSOCIATION__SOURCE);
		createEReference(associationEClass, ASSOCIATION__TARGET);

		stereotypeEClass = createEClass(STEREOTYPE);
		createEAttribute(stereotypeEClass, STEREOTYPE__NAME);
		createEReference(stereotypeEClass, STEREOTYPE__PROFILE);

		parameterBindingEClass = createEClass(PARAMETER_BINDING);
		createEReference(parameterBindingEClass, PARAMETER_BINDING__PARAMETER);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEReference(assignmentEClass, ASSIGNMENT__ASSIGNMENT);
		createEReference(assignmentEClass, ASSIGNMENT__PATTERN);

		objectBindingEClass = createEClass(OBJECT_BINDING);
		createEReference(objectBindingEClass, OBJECT_BINDING__VALUE);

		valueBindingEClass = createEClass(VALUE_BINDING);
		createEAttribute(valueBindingEClass, VALUE_BINDING__VALUE);

		subGraphEClass = createEClass(SUB_GRAPH);
		createEReference(subGraphEClass, SUB_GRAPH__ELEMENTS);
		createEReference(subGraphEClass, SUB_GRAPH__SUBGRAPHS);

		graphElementEClass = createEClass(GRAPH_ELEMENT);
		createEReference(graphElementEClass, GRAPH_ELEMENT__SUBGRAPHS);
		createEReference(graphElementEClass, GRAPH_ELEMENT__GRAPH);

		profileEClass = createEClass(PROFILE);
		createEReference(profileEClass, PROFILE__STEREOTYPES);
		createEAttribute(profileEClass, PROFILE__NAME);
		createEAttribute(profileEClass, PROFILE__DESCRIPTION);
		createEAttribute(profileEClass, PROFILE__ID);
		createEOperation(profileEClass, PROFILE___GET_STEREOTYPE__STRING);

		resourceEClass = createEClass(RESOURCE);
		createEReference(resourceEClass, RESOURCE__CONTENTS);

		extendableEClass = createEClass(EXTENDABLE);
		createEReference(extendableEClass, EXTENDABLE__STEREOTYPES);

		// Create data types
		eIteratorEDataType = createEDataType(EITERATOR);
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
		graphPatternEClass.getESuperTypes().add(this.getPatternElement());
		nodePatternEClass.getESuperTypes().add(this.getGraphElement());
		edgePatternEClass.getESuperTypes().add(this.getGraphElement());
		attributePatternEClass.getESuperTypes().add(this.getGraphElement());
		bundleEClass.getESuperTypes().add(this.getPattern());
		patternEClass.getESuperTypes().add(this.getPatternElement());
		patternElementEClass.getESuperTypes().add(this.getExtendable());
		parameterEClass.getESuperTypes().add(this.getPatternElement());
		associationEClass.getESuperTypes().add(this.getPatternElement());
		objectBindingEClass.getESuperTypes().add(this.getParameterBinding());
		valueBindingEClass.getESuperTypes().add(this.getParameterBinding());
		subGraphEClass.getESuperTypes().add(this.getPatternElement());
		graphElementEClass.getESuperTypes().add(this.getPatternElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(graphPatternEClass, GraphPattern.class, "GraphPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphPattern_Nodes(), this.getNodePattern(), null, "nodes", null, 0, -1, GraphPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphPattern_Pattern(), this.getPattern(), this.getPattern_Graphs(), "pattern", null, 1, 1, GraphPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphPattern_DependencyGraph(), this.getDependencyGraph(), this.getDependencyGraph_Graph(), "dependencyGraph", null, 0, 1, GraphPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphPattern_Subgraphs(), this.getSubGraph(), null, "subgraphs", null, 0, -1, GraphPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getGraphPattern__GetNode__String(), this.getNodePattern(), "getNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nodePatternEClass, NodePattern.class, "NodePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodePattern_Outgoings(), this.getEdgePattern(), this.getEdgePattern_Source(), "outgoings", null, 0, -1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Type(), ecorePackage.getEClass(), null, "type", null, 1, 1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Attributes(), this.getAttributePattern(), this.getAttributePattern_Node(), "attributes", null, 0, -1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Matching(), this.getMatching(), this.getMatching_Node(), "matching", null, 0, 1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Incomings(), this.getEdgePattern(), this.getEdgePattern_Target(), "incomings", null, 0, -1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Associations(), this.getAssociation(), this.getAssociation_Source(), "associations", null, 0, -1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getNodePattern__GetAttribute__EAttribute(), this.getAttributePattern(), "getAttribute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEAttribute(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodePattern__GetOutgoings__EReference(), this.getEdgePattern(), "getOutgoings", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEReference(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodePattern__GetOutgoing__EReference(), this.getEdgePattern(), "getOutgoing", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEReference(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodePattern__GetOutgoing__EReference_NodePattern(), this.getEdgePattern(), "getOutgoing", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEReference(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNodePattern(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodePattern__GetOutgoing__EReference_NodePattern_Stereotype(), this.getEdgePattern(), "getOutgoing", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEReference(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNodePattern(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStereotype(), "stereotype", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodePattern__GetIncoming__EReference(), this.getEdgePattern(), "getIncoming", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEReference(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodePattern__GetIncomings__EReference(), this.getEdgePattern(), "getIncomings", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEReference(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getNodePattern__GetIncident(), this.getEdgePattern(), "getIncident", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodePattern__GetIncident__NodePattern(), this.getEdgePattern(), "getIncident", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNodePattern(), "adjacent", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getNodePattern__RemoveIncident(), this.getEdgePattern(), "removeIncident", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodePattern__RemoveIncident__NodePattern(), this.getEdgePattern(), "removeIncident", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNodePattern(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getNodePattern__GetAdjacent(), this.getNodePattern(), "getAdjacent", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(edgePatternEClass, EdgePattern.class, "EdgePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdgePattern_Target(), this.getNodePattern(), this.getNodePattern_Incomings(), "target", null, 1, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgePattern_Source(), this.getNodePattern(), this.getNodePattern_Outgoings(), "source", null, 1, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgePattern_Opposite(), this.getEdgePattern(), null, "opposite", null, 0, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgePattern_Type(), ecorePackage.getEReference(), null, "type", null, 1, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributePatternEClass, AttributePattern.class, "AttributePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributePattern_Value(), ecorePackage.getEString(), "value", null, 0, 1, AttributePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributePattern_Type(), ecorePackage.getEAttribute(), null, "type", null, 1, 1, AttributePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributePattern_Node(), this.getNodePattern(), this.getNodePattern_Attributes(), "node", null, 0, 1, AttributePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributePattern_Constant(), ecorePackage.getEJavaObject(), "constant", null, 0, 1, AttributePattern.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributePattern_Variables(), ecorePackage.getEString(), "variables", null, 0, -1, AttributePattern.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getAttributePattern__IsConstant(), ecorePackage.getEBoolean(), "isConstant", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttributePattern__IsVariable(), ecorePackage.getEBoolean(), "isVariable", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttributePattern__IsExpression(), ecorePackage.getEBoolean(), "isExpression", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(matchingEClass, Matching.class, "Matching", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMatching_Matches(), ecorePackage.getEObject(), null, "matches", null, 0, -1, Matching.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMatching_Node(), this.getNodePattern(), this.getNodePattern_Matching(), "node", null, 0, 1, Matching.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMatching__Iterator(), this.getEIterator(), "iterator", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatching__Size(), ecorePackage.getEInt(), "size", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatching__IsEmpty(), ecorePackage.getEBoolean(), "isEmpty", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatching__Add__EObject(), null, "add", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatching__Remove__EObject(), ecorePackage.getEBoolean(), "remove", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMatching__Contains__EObject(), ecorePackage.getEBoolean(), "contains", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMatching__Clear(), null, "clear", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bundleEClass, Bundle.class, "Bundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBundle_Profiles(), this.getProfile(), null, "profiles", null, 0, -1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBundle_Domains(), ecorePackage.getEPackage(), null, "domains", null, 0, -1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPattern_Graphs(), this.getGraphPattern(), this.getGraphPattern_Pattern(), "graphs", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Parameters(), this.getParameter(), this.getParameter_Pattern(), "parameters", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Assignments(), this.getAssignment(), this.getAssignment_Pattern(), "assignments", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Bundle(), this.getBundle(), null, "bundle", null, 0, 1, Pattern.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Patterns(), this.getPattern(), null, "patterns", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getPattern__GetPattern__String(), this.getPattern(), "getPattern", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPattern__GetParameter__String(), this.getParameter(), "getParameter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPattern__GetGraph__String(), this.getGraphPattern(), "getGraph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPattern__GetAllGraphPatterns(), this.getGraphPattern(), "getAllGraphPatterns", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(patternElementEClass, PatternElement.class, "PatternElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPatternElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, PatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPatternElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, PatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameter_Pattern(), this.getPattern(), this.getPattern_Parameters(), "pattern", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eObjectListEClass, EObjectList.class, "EObjectList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEObjectList_Content(), ecorePackage.getEObject(), null, "content", null, 0, -1, EObjectList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEObjectList_Label(), ecorePackage.getEString(), "label", "", 0, 1, EObjectList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencyGraphEClass, DependencyGraph.class, "DependencyGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependencyGraph_Independent(), this.getDependencyNode(), null, "independent", null, 0, -1, DependencyGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependencyGraph_Graph(), this.getGraphPattern(), this.getGraphPattern_DependencyGraph(), "graph", null, 0, 1, DependencyGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependencyGraph_Nodes(), this.getDependencyNode(), null, "nodes", null, 0, -1, DependencyGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependencyGraph_Edges(), this.getDependencyEdge(), null, "edges", null, 0, -1, DependencyGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencyNodeEClass, DependencyNode.class, "DependencyNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependencyNode_Outgoings(), this.getDependencyEdge(), this.getDependencyEdge_Source(), "outgoings", null, 0, -1, DependencyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependencyNode_Incomings(), this.getDependencyEdge(), this.getDependencyEdge_Target(), "incomings", null, 0, -1, DependencyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependencyNode_Nodes(), this.getNodePattern(), null, "nodes", null, 0, -1, DependencyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencyEdgeEClass, DependencyEdge.class, "DependencyEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependencyEdge_Source(), this.getDependencyNode(), this.getDependencyNode_Outgoings(), "source", null, 0, 1, DependencyEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependencyEdge_Target(), this.getDependencyNode(), this.getDependencyNode_Incomings(), "target", null, 0, 1, DependencyEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociation_Source(), this.getNodePattern(), this.getNodePattern_Associations(), "source", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociation_Target(), this.getGraphElement(), null, "target", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stereotypeEClass, Stereotype.class, "Stereotype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStereotype_Name(), ecorePackage.getEString(), "name", null, 0, 1, Stereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStereotype_Profile(), this.getProfile(), this.getProfile_Stereotypes(), "profile", null, 1, 1, Stereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterBindingEClass, ParameterBinding.class, "ParameterBinding", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterBinding_Parameter(), this.getParameter(), null, "parameter", null, 1, 1, ParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignment_Assignment(), this.getParameterBinding(), null, "assignment", null, 0, -1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignment_Pattern(), this.getPattern(), this.getPattern_Assignments(), "pattern", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectBindingEClass, ObjectBinding.class, "ObjectBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectBinding_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, ObjectBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueBindingEClass, ValueBinding.class, "ValueBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValueBinding_Value(), ecorePackage.getEString(), "value", null, 0, 1, ValueBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subGraphEClass, SubGraph.class, "SubGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubGraph_Elements(), this.getGraphElement(), this.getGraphElement_Subgraphs(), "elements", null, 0, -1, SubGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubGraph_Subgraphs(), this.getSubGraph(), null, "subgraphs", null, 0, -1, SubGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphElementEClass, GraphElement.class, "GraphElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphElement_Subgraphs(), this.getSubGraph(), this.getSubGraph_Elements(), "subgraphs", null, 0, -1, GraphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphElement_Graph(), this.getGraphPattern(), null, "graph", null, 1, 1, GraphElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(profileEClass, Profile.class, "Profile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProfile_Stereotypes(), this.getStereotype(), this.getStereotype_Profile(), "stereotypes", null, 0, -1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfile_Name(), ecorePackage.getEString(), "name", null, 0, 1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfile_Description(), ecorePackage.getEString(), "description", null, 0, 1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfile_Id(), ecorePackage.getEString(), "id", null, 0, 1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getProfile__GetStereotype__String(), this.getStereotype(), "getStereotype", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(resourceEClass, Resource.class, "Resource", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResource_Contents(), ecorePackage.getEObject(), null, "contents", null, 0, -1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendableEClass, Extendable.class, "Extendable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtendable_Stereotypes(), this.getStereotype(), null, "stereotypes", null, 0, -1, Extendable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(eIteratorEDataType, Iterator.class, "EIterator", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Iterator<org.eclipse.emf.ecore.EObject>");

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			   "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			   "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });
		addAnnotation
		  (nodePatternEClass,
		   source,
		   new String[] {
			   "constraints", "TheNameOfANodeMustBeUniqueWithinAGraph"
		   });
		addAnnotation
		  (edgePatternEClass,
		   source,
		   new String[] {
			   "constraints", "TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne TheOppositeMayNotBeItsOwnOpposite TheOppositeTypesAreNotMetaModelConform EdgeSourceAndTypeAreNotMetaModelConform EdgeTargetAndTypeAreNotMetaModelConform"
		   });
		addAnnotation
		  (attributePatternEClass,
		   source,
		   new String[] {
			   "constraints", "TheAttributeTypeAndTheContainingClassAreNotMetaModelConform TheNameOfTheAttributeVariableIsEqualToANameOfANode"
		   });
		addAnnotation
		  (parameterEClass,
		   source,
		   new String[] {
			   "constraints", "TheNameOfTheParameterIsNotUnique"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation
		  (nodePatternEClass,
		   source,
		   new String[] {
			   "TheNameOfANodeMustBeUniqueWithinAGraph", "not(self.graph.nodes->exists(n | n <> self and n.name <> null and n.name = self.name))"
		   });
		addAnnotation
		  (edgePatternEClass,
		   source,
		   new String[] {
			   "TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne", "(self.opposite <> null) implies (self.opposite.opposite = self)",
			   "TheOppositeMayNotBeItsOwnOpposite", "self.opposite <> self",
			   "TheOppositeTypesAreNotMetaModelConform", "((self.opposite <> null) and (self.type.eOpposite <> null)) implies (self.opposite.type = self.type.eOpposite)",
			   "EdgeSourceAndTypeAreNotMetaModelConform", "((self.type <> null) and (self.source <> null) and (self.source.type <> null)) implies self.source.type.eAllReferences->includes(self.type)",
			   "EdgeTargetAndTypeAreNotMetaModelConform", "((self.type <> null) and (self.target <> null) and (self.target.type <> null)) implies ((self.type.eType = self.target.type) or (self.target.type.eAllSuperTypes->includes(self.type.eType) or (self.type.eType.instanceTypeName = \'org.eclipse.emf.ecore.EObject\')))"
		   });
		addAnnotation
		  (attributePatternEClass,
		   source,
		   new String[] {
			   "TheAttributeTypeAndTheContainingClassAreNotMetaModelConform", "((self.type <> null) and (self.node <> null) and (self.node.type <> null)) implies (self.node.type.eAllAttributes->includes(self.type))",
			   "TheNameOfTheAttributeVariableIsEqualToANameOfANode", "not(self.isVariable() and self.graph.nodes->exists(n | (n.name <> null) and n.name = self.name))"
		   });
		addAnnotation
		  (parameterEClass,
		   source,
		   new String[] {
			   "TheNameOfTheParameterIsNotUnique", "not(self.pattern.parameters->exists(p |p <> self and p.name = self.name))"
		   });
	}

} //GraphpatternPackageImpl
