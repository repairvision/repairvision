/**
 */
package org.sidiff.graphpattern.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.sidiff.graphpattern.Association;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.DataStore;
import org.sidiff.graphpattern.DependencyEdge;
import org.sidiff.graphpattern.DependencyGraph;
import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.EObjectList;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.Evaluation;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphPatternElement;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.NavigableDataStore;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.RuleBase;
import org.sidiff.graphpattern.Visitor;

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
	private EClass evaluationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataStoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigableDataStoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleBaseEClass = null;

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
	private EClass patternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphPatternElementEClass = null;

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
	private EDataType eCollectionEDataType = null;

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
		GraphpatternPackageImpl theGraphpatternPackage = (GraphpatternPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GraphpatternPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GraphpatternPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGraphpatternPackage.createPackageContents();

		// Initialize created meta-data
		theGraphpatternPackage.initializePackageContents();

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
	public EClass getGraphPattern() {
		return graphPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphPattern_Nodes() {
		return (EReference)graphPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphPattern_Pattern() {
		return (EReference)graphPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphPattern_Multi() {
		return (EAttribute)graphPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphPattern_DependencyGraph() {
		return (EReference)graphPatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodePattern() {
		return nodePatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodePattern_Outgoings() {
		return (EReference)nodePatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodePattern_Type() {
		return (EReference)nodePatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodePattern_Attributes() {
		return (EReference)nodePatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodePattern_Evaluation() {
		return (EReference)nodePatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodePattern_Graph() {
		return (EReference)nodePatternEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodePattern_Incomings() {
		return (EReference)nodePatternEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodePattern_Associations() {
		return (EReference)nodePatternEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNodePattern__GetAttribute__EAttribute() {
		return nodePatternEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNodePattern__GetOutgoing__EReference() {
		return nodePatternEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNodePattern__GetOutgoings__EReference() {
		return nodePatternEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNodePattern__GetIncoming__EReference() {
		return nodePatternEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNodePattern__GetIncomings__EReference() {
		return nodePatternEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNodePattern__GetIncident() {
		return nodePatternEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNodePattern__GetIncident__NodePattern() {
		return nodePatternEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNodePattern__GetAdjacent() {
		return nodePatternEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdgePattern() {
		return edgePatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgePattern_Target() {
		return (EReference)edgePatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgePattern_Source() {
		return (EReference)edgePatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgePattern_Opposite() {
		return (EReference)edgePatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgePattern_Type() {
		return (EReference)edgePatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdgePattern_CrossReference() {
		return (EAttribute)edgePatternEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgePattern_Associations() {
		return (EReference)edgePatternEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributePattern() {
		return attributePatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributePattern_Value() {
		return (EAttribute)attributePatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributePattern_Type() {
		return (EReference)attributePatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributePattern_Node() {
		return (EReference)attributePatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluation() {
		return evaluationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvaluation_Node() {
		return (EReference)evaluationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvaluation_Matches() {
		return (EReference)evaluationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvaluation_Store() {
		return (EReference)evaluationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEvaluation__Initialize() {
		return evaluationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEvaluation__Accept__Visitor() {
		return evaluationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitor() {
		return visitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVisitor__Visit__Evaluation() {
		return visitorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataStore() {
		return dataStoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataStore_Evaluation() {
		return (EReference)dataStoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataStore__Initialize() {
		return dataStoreEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataStore__GetMatchIterator() {
		return dataStoreEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataStore__GetMatchSize() {
		return dataStoreEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataStore__IsEmptyMatch() {
		return dataStoreEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataStore__AddMatch__EObject() {
		return dataStoreEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataStore__RemoveMatch__EObject() {
		return dataStoreEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataStore__ContainsMatch__EObject() {
		return dataStoreEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataStore__ClearMatches() {
		return dataStoreEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNavigableDataStore() {
		return navigableDataStoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNavigableDataStore__GetRemoteMatchIterator__EObject_EdgePattern() {
		return navigableDataStoreEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNavigableDataStore__GetRemoteMatchSize__EObject_EdgePattern() {
		return navigableDataStoreEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNavigableDataStore__IsEmptyRemoteMatch__EObject_EdgePattern() {
		return navigableDataStoreEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNavigableDataStore__AddRemoteMatch__EObject_EObject_EdgePattern() {
		return navigableDataStoreEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNavigableDataStore__RemoveRemoteMatch__EObject_EObject_EdgePattern() {
		return navigableDataStoreEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNavigableDataStore__ContainsRemoteMatch__EObject_EObject_EdgePattern() {
		return navigableDataStoreEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNavigableDataStore__CleanRemoteMatches__EObject_EdgePattern() {
		return navigableDataStoreEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleBase() {
		return ruleBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleBase_Patterns() {
		return (EReference)ruleBaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEObjectList() {
		return eObjectListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEObjectList_Content() {
		return (EReference)eObjectListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEObjectList_Label() {
		return (EAttribute)eObjectListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependencyGraph() {
		return dependencyGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyGraph_Independent() {
		return (EReference)dependencyGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyGraph_Graph() {
		return (EReference)dependencyGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyGraph_Nodes() {
		return (EReference)dependencyGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyGraph_Edges() {
		return (EReference)dependencyGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependencyNode() {
		return dependencyNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyNode_Outgoings() {
		return (EReference)dependencyNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyNode_Incomings() {
		return (EReference)dependencyNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyNode_Nodes() {
		return (EReference)dependencyNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependencyEdge() {
		return dependencyEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyEdge_Source() {
		return (EReference)dependencyEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyEdge_Target() {
		return (EReference)dependencyEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociation() {
		return associationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Source() {
		return (EReference)associationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Target() {
		return (EReference)associationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPattern() {
		return patternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_Graphs() {
		return (EReference)patternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_Parameters() {
		return (EReference)patternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphPatternElement() {
		return graphPatternElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphPatternElement_Name() {
		return (EAttribute)graphPatternElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Name() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getECollection() {
		return eCollectionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEIterator() {
		return eIteratorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
		createEAttribute(graphPatternEClass, GRAPH_PATTERN__MULTI);
		createEReference(graphPatternEClass, GRAPH_PATTERN__DEPENDENCY_GRAPH);

		nodePatternEClass = createEClass(NODE_PATTERN);
		createEReference(nodePatternEClass, NODE_PATTERN__OUTGOINGS);
		createEReference(nodePatternEClass, NODE_PATTERN__TYPE);
		createEReference(nodePatternEClass, NODE_PATTERN__ATTRIBUTES);
		createEReference(nodePatternEClass, NODE_PATTERN__EVALUATION);
		createEReference(nodePatternEClass, NODE_PATTERN__GRAPH);
		createEReference(nodePatternEClass, NODE_PATTERN__INCOMINGS);
		createEReference(nodePatternEClass, NODE_PATTERN__ASSOCIATIONS);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_ATTRIBUTE__EATTRIBUTE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_OUTGOING__EREFERENCE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_OUTGOINGS__EREFERENCE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_INCOMING__EREFERENCE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_INCOMINGS__EREFERENCE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_INCIDENT);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_INCIDENT__NODEPATTERN);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_ADJACENT);

		edgePatternEClass = createEClass(EDGE_PATTERN);
		createEReference(edgePatternEClass, EDGE_PATTERN__TARGET);
		createEReference(edgePatternEClass, EDGE_PATTERN__SOURCE);
		createEReference(edgePatternEClass, EDGE_PATTERN__OPPOSITE);
		createEReference(edgePatternEClass, EDGE_PATTERN__TYPE);
		createEAttribute(edgePatternEClass, EDGE_PATTERN__CROSS_REFERENCE);
		createEReference(edgePatternEClass, EDGE_PATTERN__ASSOCIATIONS);

		attributePatternEClass = createEClass(ATTRIBUTE_PATTERN);
		createEAttribute(attributePatternEClass, ATTRIBUTE_PATTERN__VALUE);
		createEReference(attributePatternEClass, ATTRIBUTE_PATTERN__TYPE);
		createEReference(attributePatternEClass, ATTRIBUTE_PATTERN__NODE);

		evaluationEClass = createEClass(EVALUATION);
		createEReference(evaluationEClass, EVALUATION__NODE);
		createEReference(evaluationEClass, EVALUATION__MATCHES);
		createEReference(evaluationEClass, EVALUATION__STORE);
		createEOperation(evaluationEClass, EVALUATION___INITIALIZE);
		createEOperation(evaluationEClass, EVALUATION___ACCEPT__VISITOR);

		visitorEClass = createEClass(VISITOR);
		createEOperation(visitorEClass, VISITOR___VISIT__EVALUATION);

		dataStoreEClass = createEClass(DATA_STORE);
		createEReference(dataStoreEClass, DATA_STORE__EVALUATION);
		createEOperation(dataStoreEClass, DATA_STORE___INITIALIZE);
		createEOperation(dataStoreEClass, DATA_STORE___GET_MATCH_ITERATOR);
		createEOperation(dataStoreEClass, DATA_STORE___GET_MATCH_SIZE);
		createEOperation(dataStoreEClass, DATA_STORE___IS_EMPTY_MATCH);
		createEOperation(dataStoreEClass, DATA_STORE___ADD_MATCH__EOBJECT);
		createEOperation(dataStoreEClass, DATA_STORE___REMOVE_MATCH__EOBJECT);
		createEOperation(dataStoreEClass, DATA_STORE___CONTAINS_MATCH__EOBJECT);
		createEOperation(dataStoreEClass, DATA_STORE___CLEAR_MATCHES);

		navigableDataStoreEClass = createEClass(NAVIGABLE_DATA_STORE);
		createEOperation(navigableDataStoreEClass, NAVIGABLE_DATA_STORE___GET_REMOTE_MATCH_ITERATOR__EOBJECT_EDGEPATTERN);
		createEOperation(navigableDataStoreEClass, NAVIGABLE_DATA_STORE___GET_REMOTE_MATCH_SIZE__EOBJECT_EDGEPATTERN);
		createEOperation(navigableDataStoreEClass, NAVIGABLE_DATA_STORE___IS_EMPTY_REMOTE_MATCH__EOBJECT_EDGEPATTERN);
		createEOperation(navigableDataStoreEClass, NAVIGABLE_DATA_STORE___ADD_REMOTE_MATCH__EOBJECT_EOBJECT_EDGEPATTERN);
		createEOperation(navigableDataStoreEClass, NAVIGABLE_DATA_STORE___REMOVE_REMOTE_MATCH__EOBJECT_EOBJECT_EDGEPATTERN);
		createEOperation(navigableDataStoreEClass, NAVIGABLE_DATA_STORE___CONTAINS_REMOTE_MATCH__EOBJECT_EOBJECT_EDGEPATTERN);
		createEOperation(navigableDataStoreEClass, NAVIGABLE_DATA_STORE___CLEAN_REMOTE_MATCHES__EOBJECT_EDGEPATTERN);

		ruleBaseEClass = createEClass(RULE_BASE);
		createEReference(ruleBaseEClass, RULE_BASE__PATTERNS);

		patternEClass = createEClass(PATTERN);
		createEReference(patternEClass, PATTERN__GRAPHS);
		createEReference(patternEClass, PATTERN__PARAMETERS);

		graphPatternElementEClass = createEClass(GRAPH_PATTERN_ELEMENT);
		createEAttribute(graphPatternElementEClass, GRAPH_PATTERN_ELEMENT__NAME);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__NAME);

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

		// Create data types
		eCollectionEDataType = createEDataType(ECOLLECTION);
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

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		graphPatternEClass.getESuperTypes().add(this.getGraphPatternElement());
		nodePatternEClass.getESuperTypes().add(this.getGraphPatternElement());
		edgePatternEClass.getESuperTypes().add(this.getGraphPatternElement());
		navigableDataStoreEClass.getESuperTypes().add(this.getDataStore());

		// Initialize classes, features, and operations; add parameters
		initEClass(graphPatternEClass, GraphPattern.class, "GraphPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphPattern_Nodes(), this.getNodePattern(), this.getNodePattern_Graph(), "nodes", null, 0, -1, GraphPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphPattern_Pattern(), this.getPattern(), this.getPattern_Graphs(), "pattern", null, 1, 1, GraphPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphPattern_Multi(), ecorePackage.getEBoolean(), "multi", null, 0, 1, GraphPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphPattern_DependencyGraph(), this.getDependencyGraph(), this.getDependencyGraph_Graph(), "dependencyGraph", null, 0, 1, GraphPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodePatternEClass, NodePattern.class, "NodePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodePattern_Outgoings(), this.getEdgePattern(), this.getEdgePattern_Source(), "outgoings", null, 0, -1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Type(), ecorePackage.getEClass(), null, "type", null, 1, 1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Attributes(), this.getAttributePattern(), this.getAttributePattern_Node(), "attributes", null, 0, -1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Evaluation(), this.getEvaluation(), this.getEvaluation_Node(), "evaluation", null, 0, 1, NodePattern.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Graph(), this.getGraphPattern(), this.getGraphPattern_Nodes(), "graph", null, 1, 1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Incomings(), this.getEdgePattern(), this.getEdgePattern_Target(), "incomings", null, 0, -1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Associations(), this.getAssociation(), this.getAssociation_Source(), "associations", null, 0, -1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getNodePattern__GetAttribute__EAttribute(), this.getAttributePattern(), "getAttribute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEAttribute(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodePattern__GetOutgoing__EReference(), this.getEdgePattern(), "getOutgoing", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEReference(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodePattern__GetOutgoings__EReference(), this.getEdgePattern(), "getOutgoings", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEReference(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodePattern__GetIncoming__EReference(), this.getEdgePattern(), "getIncoming", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEReference(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodePattern__GetIncomings__EReference(), this.getEdgePattern(), "getIncomings", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEReference(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getNodePattern__GetIncident(), this.getEdgePattern(), "getIncident", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNodePattern__GetIncident__NodePattern(), this.getEdgePattern(), "getIncident", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNodePattern(), "adjacent", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getNodePattern__GetAdjacent(), this.getNodePattern(), "getAdjacent", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(edgePatternEClass, EdgePattern.class, "EdgePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdgePattern_Target(), this.getNodePattern(), this.getNodePattern_Incomings(), "target", null, 1, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgePattern_Source(), this.getNodePattern(), this.getNodePattern_Outgoings(), "source", null, 1, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgePattern_Opposite(), this.getEdgePattern(), null, "opposite", null, 0, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgePattern_Type(), ecorePackage.getEReference(), null, "type", null, 1, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEdgePattern_CrossReference(), ecorePackage.getEBoolean(), "crossReference", null, 0, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgePattern_Associations(), this.getAssociation(), this.getAssociation_Target(), "associations", null, 0, -1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributePatternEClass, AttributePattern.class, "AttributePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributePattern_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, AttributePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributePattern_Type(), ecorePackage.getEAttribute(), null, "type", null, 1, 1, AttributePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributePattern_Node(), this.getNodePattern(), this.getNodePattern_Attributes(), "node", null, 0, 1, AttributePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evaluationEClass, Evaluation.class, "Evaluation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvaluation_Node(), this.getNodePattern(), this.getNodePattern_Evaluation(), "node", null, 1, 1, Evaluation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvaluation_Matches(), ecorePackage.getEObject(), null, "matches", null, 0, -1, Evaluation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEvaluation_Store(), this.getDataStore(), this.getDataStore_Evaluation(), "store", null, 1, 1, Evaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEvaluation__Initialize(), null, "initialize", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getEvaluation__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(visitorEClass, Visitor.class, "Visitor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getVisitor__Visit__Evaluation(), null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEvaluation(), "evaluation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataStoreEClass, DataStore.class, "DataStore", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataStore_Evaluation(), this.getEvaluation(), this.getEvaluation_Store(), "evaluation", null, 1, 1, DataStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDataStore__Initialize(), null, "initialize", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataStore__GetMatchIterator(), this.getEIterator(), "getMatchIterator", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataStore__GetMatchSize(), ecorePackage.getEInt(), "getMatchSize", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataStore__IsEmptyMatch(), ecorePackage.getEBoolean(), "isEmptyMatch", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataStore__AddMatch__EObject(), null, "addMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "localMatch", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataStore__RemoveMatch__EObject(), ecorePackage.getEBoolean(), "removeMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "localMatch", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataStore__ContainsMatch__EObject(), ecorePackage.getEBoolean(), "containsMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "localMatch", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataStore__ClearMatches(), null, "clearMatches", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(navigableDataStoreEClass, NavigableDataStore.class, "NavigableDataStore", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getNavigableDataStore__GetRemoteMatchIterator__EObject_EdgePattern(), this.getEIterator(), "getRemoteMatchIterator", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "localMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEdgePattern(), "edge", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNavigableDataStore__GetRemoteMatchSize__EObject_EdgePattern(), ecorePackage.getEInt(), "getRemoteMatchSize", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "localMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEdgePattern(), "edge", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNavigableDataStore__IsEmptyRemoteMatch__EObject_EdgePattern(), ecorePackage.getEBoolean(), "isEmptyRemoteMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "localMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEdgePattern(), "edge", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNavigableDataStore__AddRemoteMatch__EObject_EObject_EdgePattern(), null, "addRemoteMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "localMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "remoteMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEdgePattern(), "edge", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNavigableDataStore__RemoveRemoteMatch__EObject_EObject_EdgePattern(), ecorePackage.getEBoolean(), "removeRemoteMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "localMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "remoteMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEdgePattern(), "edge", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNavigableDataStore__ContainsRemoteMatch__EObject_EObject_EdgePattern(), ecorePackage.getEBoolean(), "containsRemoteMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "localMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "remoteMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEdgePattern(), "edge", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getNavigableDataStore__CleanRemoteMatches__EObject_EdgePattern(), null, "cleanRemoteMatches", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "localMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEdgePattern(), "edge", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(ruleBaseEClass, RuleBase.class, "RuleBase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleBase_Patterns(), this.getPattern(), null, "patterns", null, 0, -1, RuleBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPattern_Graphs(), this.getGraphPattern(), this.getGraphPattern_Pattern(), "graphs", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphPatternElementEClass, GraphPatternElement.class, "GraphPatternElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGraphPatternElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, GraphPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEReference(getAssociation_Target(), this.getEdgePattern(), this.getEdgePattern_Associations(), "target", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(eCollectionEDataType, Collection.class, "ECollection", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Collection<? extends org.eclipse.emf.ecore.EObject>");
		initEDataType(eIteratorEDataType, Iterator.class, "EIterator", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Iterator<org.eclipse.emf.ecore.EObject>");

		// Create resource
		createResource(eNS_URI);
	}

} //GraphpatternPackageImpl
