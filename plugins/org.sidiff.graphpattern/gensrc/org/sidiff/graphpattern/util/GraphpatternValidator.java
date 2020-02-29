package org.sidiff.graphpattern.util;


import java.util.Iterator;
import java.util.Map;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.sidiff.graphpattern.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.graphpattern.GraphpatternPackage
 * @generated
 */
public class GraphpatternValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final GraphpatternValidator INSTANCE = new GraphpatternValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.sidiff.graphpattern";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphpatternValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return GraphpatternPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case GraphpatternPackage.GRAPH_PATTERN:
				return validateGraphPattern((GraphPattern)value, diagnostics, context);
			case GraphpatternPackage.NODE_PATTERN:
				return validateNodePattern((NodePattern)value, diagnostics, context);
			case GraphpatternPackage.EDGE_PATTERN:
				return validateEdgePattern((EdgePattern)value, diagnostics, context);
			case GraphpatternPackage.ATTRIBUTE_PATTERN:
				return validateAttributePattern((AttributePattern)value, diagnostics, context);
			case GraphpatternPackage.MATCHING:
				return validateMatching((Matching)value, diagnostics, context);
			case GraphpatternPackage.BUNDLE:
				return validateBundle((Bundle)value, diagnostics, context);
			case GraphpatternPackage.PATTERN:
				return validatePattern((Pattern)value, diagnostics, context);
			case GraphpatternPackage.PATTERN_ELEMENT:
				return validatePatternElement((PatternElement)value, diagnostics, context);
			case GraphpatternPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case GraphpatternPackage.EOBJECT_LIST:
				return validateEObjectList((EObjectList)value, diagnostics, context);
			case GraphpatternPackage.DEPENDENCY_GRAPH:
				return validateDependencyGraph((DependencyGraph)value, diagnostics, context);
			case GraphpatternPackage.DEPENDENCY_NODE:
				return validateDependencyNode((DependencyNode)value, diagnostics, context);
			case GraphpatternPackage.DEPENDENCY_EDGE:
				return validateDependencyEdge((DependencyEdge)value, diagnostics, context);
			case GraphpatternPackage.ASSOCIATION:
				return validateAssociation((Association)value, diagnostics, context);
			case GraphpatternPackage.STEREOTYPE:
				return validateStereotype((Stereotype)value, diagnostics, context);
			case GraphpatternPackage.PARAMETER_BINDING:
				return validateParameterBinding((ParameterBinding)value, diagnostics, context);
			case GraphpatternPackage.ASSIGNMENT:
				return validateAssignment((Assignment)value, diagnostics, context);
			case GraphpatternPackage.OBJECT_BINDING:
				return validateObjectBinding((ObjectBinding)value, diagnostics, context);
			case GraphpatternPackage.VALUE_BINDING:
				return validateValueBinding((ValueBinding)value, diagnostics, context);
			case GraphpatternPackage.SUB_GRAPH:
				return validateSubGraph((SubGraph)value, diagnostics, context);
			case GraphpatternPackage.GRAPH_ELEMENT:
				return validateGraphElement((GraphElement)value, diagnostics, context);
			case GraphpatternPackage.PROFILE:
				return validateProfile((Profile)value, diagnostics, context);
			case GraphpatternPackage.RESOURCE:
				return validateResource((Resource)value, diagnostics, context);
			case GraphpatternPackage.EXTENDABLE:
				return validateExtendable((Extendable)value, diagnostics, context);
			case GraphpatternPackage.EITERATOR:
				return validateEIterator((Iterator<EObject>)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGraphPattern(GraphPattern graphPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(graphPattern, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNodePattern(NodePattern nodePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(nodePattern, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(nodePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(nodePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(nodePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(nodePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(nodePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(nodePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(nodePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(nodePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateNodePattern_TheNameOfANodeMustBeUniqueWithinAGraph(nodePattern, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the TheNameOfANodeMustBeUniqueWithinAGraph constraint of '<em>Node Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String NODE_PATTERN__THE_NAME_OF_ANODE_MUST_BE_UNIQUE_WITHIN_AGRAPH__EEXPRESSION = "not(self.graph.nodes->exists(n | n <> self and n.name <> null and n.name = self.name))";

	/**
	 * Validates the TheNameOfANodeMustBeUniqueWithinAGraph constraint of '<em>Node Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNodePattern_TheNameOfANodeMustBeUniqueWithinAGraph(NodePattern nodePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GraphpatternPackage.Literals.NODE_PATTERN,
				 nodePattern,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "TheNameOfANodeMustBeUniqueWithinAGraph",
				 NODE_PATTERN__THE_NAME_OF_ANODE_MUST_BE_UNIQUE_WITHIN_AGRAPH__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEdgePattern(EdgePattern edgePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(edgePattern, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(edgePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(edgePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(edgePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(edgePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(edgePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(edgePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(edgePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(edgePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateEdgePattern_TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne(edgePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateEdgePattern_TheOppositeMayNotBeItsOwnOpposite(edgePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateEdgePattern_TheOppositeTypesAreNotMetaModelConform(edgePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateEdgePattern_EdgeSourceAndTypeAreNotMetaModelConform(edgePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateEdgePattern_EdgeTargetAndTypeAreNotMetaModelConform(edgePattern, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne constraint of '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EDGE_PATTERN__THE_OPPOSITE_OF_THE_OPPOSITE_MAY_NOT_BE_AREFERENCE_DIFFERENT_FROM_THIS_ONE__EEXPRESSION = "(self.opposite <> null) implies (self.opposite.opposite = self)";

	/**
	 * Validates the TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne constraint of '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEdgePattern_TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne(EdgePattern edgePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GraphpatternPackage.Literals.EDGE_PATTERN,
				 edgePattern,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne",
				 EDGE_PATTERN__THE_OPPOSITE_OF_THE_OPPOSITE_MAY_NOT_BE_AREFERENCE_DIFFERENT_FROM_THIS_ONE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the TheOppositeMayNotBeItsOwnOpposite constraint of '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EDGE_PATTERN__THE_OPPOSITE_MAY_NOT_BE_ITS_OWN_OPPOSITE__EEXPRESSION = "self.opposite <> self";

	/**
	 * Validates the TheOppositeMayNotBeItsOwnOpposite constraint of '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEdgePattern_TheOppositeMayNotBeItsOwnOpposite(EdgePattern edgePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GraphpatternPackage.Literals.EDGE_PATTERN,
				 edgePattern,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "TheOppositeMayNotBeItsOwnOpposite",
				 EDGE_PATTERN__THE_OPPOSITE_MAY_NOT_BE_ITS_OWN_OPPOSITE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the TheOppositeTypesAreNotMetaModelConform constraint of '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EDGE_PATTERN__THE_OPPOSITE_TYPES_ARE_NOT_META_MODEL_CONFORM__EEXPRESSION = "((self.opposite <> null) and (self.type.eOpposite <> null)) implies (self.opposite.type = self.type.eOpposite)";

	/**
	 * Validates the TheOppositeTypesAreNotMetaModelConform constraint of '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEdgePattern_TheOppositeTypesAreNotMetaModelConform(EdgePattern edgePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GraphpatternPackage.Literals.EDGE_PATTERN,
				 edgePattern,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "TheOppositeTypesAreNotMetaModelConform",
				 EDGE_PATTERN__THE_OPPOSITE_TYPES_ARE_NOT_META_MODEL_CONFORM__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the EdgeSourceAndTypeAreNotMetaModelConform constraint of '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EDGE_PATTERN__EDGE_SOURCE_AND_TYPE_ARE_NOT_META_MODEL_CONFORM__EEXPRESSION = "((self.type <> null) and (self.source <> null) and (self.source.type <> null)) implies self.source.type.eAllReferences->includes(self.type)";

	/**
	 * Validates the EdgeSourceAndTypeAreNotMetaModelConform constraint of '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEdgePattern_EdgeSourceAndTypeAreNotMetaModelConform(EdgePattern edgePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GraphpatternPackage.Literals.EDGE_PATTERN,
				 edgePattern,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "EdgeSourceAndTypeAreNotMetaModelConform",
				 EDGE_PATTERN__EDGE_SOURCE_AND_TYPE_ARE_NOT_META_MODEL_CONFORM__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the EdgeTargetAndTypeAreNotMetaModelConform constraint of '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EDGE_PATTERN__EDGE_TARGET_AND_TYPE_ARE_NOT_META_MODEL_CONFORM__EEXPRESSION = "((self.type <> null) and (self.target <> null) and (self.target.type <> null)) implies ((self.type.eType = self.target.type) or (self.target.type.eAllSuperTypes->includes(self.type.eType) or (self.type.eType.instanceTypeName = 'org.eclipse.emf.ecore.EObject')))";

	/**
	 * Validates the EdgeTargetAndTypeAreNotMetaModelConform constraint of '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEdgePattern_EdgeTargetAndTypeAreNotMetaModelConform(EdgePattern edgePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GraphpatternPackage.Literals.EDGE_PATTERN,
				 edgePattern,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "EdgeTargetAndTypeAreNotMetaModelConform",
				 EDGE_PATTERN__EDGE_TARGET_AND_TYPE_ARE_NOT_META_MODEL_CONFORM__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributePattern(AttributePattern attributePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributePattern, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(attributePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attributePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attributePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(attributePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(attributePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(attributePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(attributePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attributePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributePattern_TheAttributeTypeAndTheContainingClassAreNotMetaModelConform(attributePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateAttributePattern_TheNameOfTheAttributeVariableIsEqualToANameOfANode(attributePattern, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the TheAttributeTypeAndTheContainingClassAreNotMetaModelConform constraint of '<em>Attribute Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ATTRIBUTE_PATTERN__THE_ATTRIBUTE_TYPE_AND_THE_CONTAINING_CLASS_ARE_NOT_META_MODEL_CONFORM__EEXPRESSION = "((self.type <> null) and (self.node <> null) and (self.node.type <> null)) implies (self.node.type.eAllAttributes->includes(self.type))";

	/**
	 * Validates the TheAttributeTypeAndTheContainingClassAreNotMetaModelConform constraint of '<em>Attribute Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributePattern_TheAttributeTypeAndTheContainingClassAreNotMetaModelConform(AttributePattern attributePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GraphpatternPackage.Literals.ATTRIBUTE_PATTERN,
				 attributePattern,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "TheAttributeTypeAndTheContainingClassAreNotMetaModelConform",
				 ATTRIBUTE_PATTERN__THE_ATTRIBUTE_TYPE_AND_THE_CONTAINING_CLASS_ARE_NOT_META_MODEL_CONFORM__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the TheNameOfTheAttributeVariableIsEqualToANameOfANode constraint of '<em>Attribute Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ATTRIBUTE_PATTERN__THE_NAME_OF_THE_ATTRIBUTE_VARIABLE_IS_EQUAL_TO_ANAME_OF_ANODE__EEXPRESSION = "not(self.isVariable() and self.graph.nodes->exists(n | (n.name <> null) and n.name = self.name))";

	/**
	 * Validates the TheNameOfTheAttributeVariableIsEqualToANameOfANode constraint of '<em>Attribute Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributePattern_TheNameOfTheAttributeVariableIsEqualToANameOfANode(AttributePattern attributePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GraphpatternPackage.Literals.ATTRIBUTE_PATTERN,
				 attributePattern,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "TheNameOfTheAttributeVariableIsEqualToANameOfANode",
				 ATTRIBUTE_PATTERN__THE_NAME_OF_THE_ATTRIBUTE_VARIABLE_IS_EQUAL_TO_ANAME_OF_ANODE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatching(Matching matching, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(matching, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBundle(Bundle bundle, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(bundle, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePattern(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(pattern, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePatternElement(PatternElement patternElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(patternElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(parameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateParameter_TheNameOfTheParameterIsNotUnique(parameter, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the TheNameOfTheParameterIsNotUnique constraint of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PARAMETER__THE_NAME_OF_THE_PARAMETER_IS_NOT_UNIQUE__EEXPRESSION = "not(self.pattern.parameters->exists(p |p <> self and p.name = self.name))";

	/**
	 * Validates the TheNameOfTheParameterIsNotUnique constraint of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter_TheNameOfTheParameterIsNotUnique(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GraphpatternPackage.Literals.PARAMETER,
				 parameter,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "TheNameOfTheParameterIsNotUnique",
				 PARAMETER__THE_NAME_OF_THE_PARAMETER_IS_NOT_UNIQUE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEObjectList(EObjectList eObjectList, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eObjectList, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependencyGraph(DependencyGraph dependencyGraph, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dependencyGraph, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependencyNode(DependencyNode dependencyNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dependencyNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependencyEdge(DependencyEdge dependencyEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dependencyEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociation(Association association, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(association, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotype(Stereotype stereotype, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stereotype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterBinding(ParameterBinding parameterBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameterBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignment(Assignment assignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(assignment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectBinding(ObjectBinding objectBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(objectBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueBinding(ValueBinding valueBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valueBinding, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubGraph(SubGraph subGraph, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subGraph, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGraphElement(GraphElement graphElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(graphElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProfile(Profile profile, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(profile, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResource(Resource resource, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtendable(Extendable extendable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(extendable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEIterator(Iterator<EObject> eIterator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //GraphpatternValidator