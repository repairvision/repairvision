/**
 */
package org.sidiff.consistency.graphpattern.impl;

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

import org.sidiff.consistency.graphpattern.And;
import org.sidiff.consistency.graphpattern.AttributePattern;
import org.sidiff.consistency.graphpattern.BinaryFormula;
import org.sidiff.consistency.graphpattern.DataStore;
import org.sidiff.consistency.graphpattern.EObjectList;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.Evaluation;
import org.sidiff.consistency.graphpattern.Exists;
import org.sidiff.consistency.graphpattern.ForAll;
import org.sidiff.consistency.graphpattern.Formula;
import org.sidiff.consistency.graphpattern.GraphFormula;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.GraphPatternElement;
import org.sidiff.consistency.graphpattern.GraphpatternFactory;
import org.sidiff.consistency.graphpattern.GraphpatternPackage;
import org.sidiff.consistency.graphpattern.If;
import org.sidiff.consistency.graphpattern.Iff;
import org.sidiff.consistency.graphpattern.NavigableDataStore;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.Not;
import org.sidiff.consistency.graphpattern.Or;
import org.sidiff.consistency.graphpattern.Parameter;
import org.sidiff.consistency.graphpattern.Pattern;
import org.sidiff.consistency.graphpattern.Quantifier;
import org.sidiff.consistency.graphpattern.RuleBase;
import org.sidiff.consistency.graphpattern.UnaryFormula;
import org.sidiff.consistency.graphpattern.Visitor;
import org.sidiff.consistency.graphpattern.Xor;

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
	private EClass unaryFormulaEClass = null;

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
	private EClass formulaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryFormulaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iffEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quantifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forAllEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass existsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphFormulaEClass = null;

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
	private EClass xorEClass = null;

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
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#eNS_URI
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
	public EClass getUnaryFormula() {
		return unaryFormulaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryFormula_Child() {
		return (EReference)unaryFormulaEClass.getEStructuralFeatures().get(0);
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
	public EClass getFormula() {
		return formulaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFormula__GetResult() {
		return formulaEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFormula__GetEmbedding() {
		return formulaEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryFormula() {
		return binaryFormulaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryFormula_Left() {
		return (EReference)binaryFormulaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryFormula_Right() {
		return (EReference)binaryFormulaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnd() {
		return andEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOr() {
		return orEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIff() {
		return iffEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIf() {
		return ifEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNot() {
		return notEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuantifier() {
		return quantifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForAll() {
		return forAllEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExists() {
		return existsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExists_LowerBound() {
		return (EAttribute)existsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExists_UpperBound() {
		return (EAttribute)existsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphFormula() {
		return graphFormulaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphFormula_Predicates() {
		return (EReference)graphFormulaEClass.getEStructuralFeatures().get(0);
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
	public EClass getXor() {
		return xorEClass;
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
	public EReference getPattern_Formula() {
		return (EReference)patternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_Graphs() {
		return (EReference)patternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_Parameters() {
		return (EReference)patternEClass.getEStructuralFeatures().get(2);
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
	public EReference getGraphPatternElement_Formulas() {
		return (EReference)graphPatternElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphPatternElement_Quantifier() {
		return (EReference)graphPatternElementEClass.getEStructuralFeatures().get(2);
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

		nodePatternEClass = createEClass(NODE_PATTERN);
		createEReference(nodePatternEClass, NODE_PATTERN__OUTGOINGS);
		createEReference(nodePatternEClass, NODE_PATTERN__TYPE);
		createEReference(nodePatternEClass, NODE_PATTERN__ATTRIBUTES);
		createEReference(nodePatternEClass, NODE_PATTERN__EVALUATION);
		createEReference(nodePatternEClass, NODE_PATTERN__GRAPH);
		createEReference(nodePatternEClass, NODE_PATTERN__INCOMINGS);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_ATTRIBUTE__EATTRIBUTE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_OUTGOING__EREFERENCE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_OUTGOINGS__EREFERENCE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_INCOMING__EREFERENCE);
		createEOperation(nodePatternEClass, NODE_PATTERN___GET_INCOMINGS__EREFERENCE);

		edgePatternEClass = createEClass(EDGE_PATTERN);
		createEReference(edgePatternEClass, EDGE_PATTERN__TARGET);
		createEReference(edgePatternEClass, EDGE_PATTERN__SOURCE);
		createEReference(edgePatternEClass, EDGE_PATTERN__OPPOSITE);
		createEReference(edgePatternEClass, EDGE_PATTERN__TYPE);
		createEAttribute(edgePatternEClass, EDGE_PATTERN__CROSS_REFERENCE);

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

		unaryFormulaEClass = createEClass(UNARY_FORMULA);
		createEReference(unaryFormulaEClass, UNARY_FORMULA__CHILD);

		ruleBaseEClass = createEClass(RULE_BASE);
		createEReference(ruleBaseEClass, RULE_BASE__PATTERNS);

		formulaEClass = createEClass(FORMULA);
		createEOperation(formulaEClass, FORMULA___GET_RESULT);
		createEOperation(formulaEClass, FORMULA___GET_EMBEDDING);

		binaryFormulaEClass = createEClass(BINARY_FORMULA);
		createEReference(binaryFormulaEClass, BINARY_FORMULA__LEFT);
		createEReference(binaryFormulaEClass, BINARY_FORMULA__RIGHT);

		andEClass = createEClass(AND);

		orEClass = createEClass(OR);

		iffEClass = createEClass(IFF);

		ifEClass = createEClass(IF);

		notEClass = createEClass(NOT);

		quantifierEClass = createEClass(QUANTIFIER);

		xorEClass = createEClass(XOR);

		patternEClass = createEClass(PATTERN);
		createEReference(patternEClass, PATTERN__FORMULA);
		createEReference(patternEClass, PATTERN__GRAPHS);
		createEReference(patternEClass, PATTERN__PARAMETERS);

		graphPatternElementEClass = createEClass(GRAPH_PATTERN_ELEMENT);
		createEAttribute(graphPatternElementEClass, GRAPH_PATTERN_ELEMENT__NAME);
		createEReference(graphPatternElementEClass, GRAPH_PATTERN_ELEMENT__FORMULAS);
		createEReference(graphPatternElementEClass, GRAPH_PATTERN_ELEMENT__QUANTIFIER);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__NAME);

		forAllEClass = createEClass(FOR_ALL);

		existsEClass = createEClass(EXISTS);
		createEAttribute(existsEClass, EXISTS__LOWER_BOUND);
		createEAttribute(existsEClass, EXISTS__UPPER_BOUND);

		graphFormulaEClass = createEClass(GRAPH_FORMULA);
		createEReference(graphFormulaEClass, GRAPH_FORMULA__PREDICATES);

		eObjectListEClass = createEClass(EOBJECT_LIST);
		createEReference(eObjectListEClass, EOBJECT_LIST__CONTENT);
		createEAttribute(eObjectListEClass, EOBJECT_LIST__LABEL);

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
		unaryFormulaEClass.getESuperTypes().add(this.getFormula());
		binaryFormulaEClass.getESuperTypes().add(this.getFormula());
		andEClass.getESuperTypes().add(this.getBinaryFormula());
		orEClass.getESuperTypes().add(this.getBinaryFormula());
		iffEClass.getESuperTypes().add(this.getBinaryFormula());
		ifEClass.getESuperTypes().add(this.getBinaryFormula());
		notEClass.getESuperTypes().add(this.getUnaryFormula());
		xorEClass.getESuperTypes().add(this.getBinaryFormula());
		forAllEClass.getESuperTypes().add(this.getQuantifier());
		existsEClass.getESuperTypes().add(this.getQuantifier());
		graphFormulaEClass.getESuperTypes().add(this.getFormula());

		// Initialize classes, features, and operations; add parameters
		initEClass(graphPatternEClass, GraphPattern.class, "GraphPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphPattern_Nodes(), this.getNodePattern(), this.getNodePattern_Graph(), "nodes", null, 0, -1, GraphPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphPattern_Pattern(), this.getPattern(), this.getPattern_Graphs(), "pattern", null, 1, 1, GraphPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphPattern_Multi(), ecorePackage.getEBoolean(), "multi", null, 0, 1, GraphPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodePatternEClass, NodePattern.class, "NodePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodePattern_Outgoings(), this.getEdgePattern(), this.getEdgePattern_Source(), "outgoings", null, 0, -1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Type(), ecorePackage.getEClass(), null, "type", null, 1, 1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Attributes(), this.getAttributePattern(), this.getAttributePattern_Node(), "attributes", null, 0, -1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Evaluation(), this.getEvaluation(), this.getEvaluation_Node(), "evaluation", null, 0, 1, NodePattern.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Graph(), this.getGraphPattern(), this.getGraphPattern_Nodes(), "graph", null, 1, 1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodePattern_Incomings(), this.getEdgePattern(), this.getEdgePattern_Target(), "incomings", null, 0, -1, NodePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEClass(edgePatternEClass, EdgePattern.class, "EdgePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdgePattern_Target(), this.getNodePattern(), this.getNodePattern_Incomings(), "target", null, 1, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgePattern_Source(), this.getNodePattern(), this.getNodePattern_Outgoings(), "source", null, 1, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgePattern_Opposite(), this.getEdgePattern(), null, "opposite", null, 0, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdgePattern_Type(), ecorePackage.getEReference(), null, "type", null, 1, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEdgePattern_CrossReference(), ecorePackage.getEBoolean(), "crossReference", null, 0, 1, EdgePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEClass(unaryFormulaEClass, UnaryFormula.class, "UnaryFormula", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryFormula_Child(), this.getFormula(), null, "child", null, 1, 1, UnaryFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleBaseEClass, RuleBase.class, "RuleBase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleBase_Patterns(), this.getPattern(), null, "patterns", null, 0, -1, RuleBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formulaEClass, Formula.class, "Formula", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getFormula__GetResult(), ecorePackage.getEBoolean(), "getResult", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getFormula__GetEmbedding(), this.getFormula(), "getEmbedding", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(binaryFormulaEClass, BinaryFormula.class, "BinaryFormula", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryFormula_Left(), this.getFormula(), null, "left", null, 1, 1, BinaryFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryFormula_Right(), this.getFormula(), null, "right", null, 1, 1, BinaryFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andEClass, And.class, "And", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orEClass, Or.class, "Or", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iffEClass, Iff.class, "Iff", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ifEClass, If.class, "If", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notEClass, Not.class, "Not", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(quantifierEClass, Quantifier.class, "Quantifier", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xorEClass, Xor.class, "Xor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPattern_Formula(), this.getFormula(), null, "formula", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Graphs(), this.getGraphPattern(), this.getGraphPattern_Pattern(), "graphs", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphPatternElementEClass, GraphPatternElement.class, "GraphPatternElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGraphPatternElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, GraphPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphPatternElement_Formulas(), this.getGraphFormula(), this.getGraphFormula_Predicates(), "formulas", null, 0, -1, GraphPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphPatternElement_Quantifier(), this.getQuantifier(), null, "quantifier", null, 0, 1, GraphPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forAllEClass, ForAll.class, "ForAll", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(existsEClass, Exists.class, "Exists", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExists_LowerBound(), ecorePackage.getEInt(), "lowerBound", "1", 0, 1, Exists.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExists_UpperBound(), ecorePackage.getEInt(), "upperBound", "-1", 0, 1, Exists.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphFormulaEClass, GraphFormula.class, "GraphFormula", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphFormula_Predicates(), this.getGraphPatternElement(), this.getGraphPatternElement_Formulas(), "predicates", null, 1, -1, GraphFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eObjectListEClass, EObjectList.class, "EObjectList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEObjectList_Content(), ecorePackage.getEObject(), null, "content", null, 0, -1, EObjectList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEObjectList_Label(), ecorePackage.getEString(), "label", "", 0, 1, EObjectList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(eCollectionEDataType, Collection.class, "ECollection", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Collection<? extends org.eclipse.emf.ecore.EObject>");
		initEDataType(eIteratorEDataType, Iterator.class, "EIterator", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Iterator<org.eclipse.emf.ecore.EObject>");

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.obeo.fr/dsl/dnc/archetype
		createArchetypeAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.obeo.fr/dsl/dnc/archetype</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createArchetypeAnnotations() {
		String source = "http://www.obeo.fr/dsl/dnc/archetype";	
		addAnnotation
		  (andEClass, 
		   source, 
		   new String[] {
			 "archetype", "Role"
		   });	
		addAnnotation
		  (orEClass, 
		   source, 
		   new String[] {
			 "archetype", "Role"
		   });
	}

} //GraphpatternPackageImpl
