/**
 */
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
		return validate_EveryDefaultConstraint(nodePattern, diagnostics, context);
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
		return result;
	}

	/**
	 * Validates the TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne constraint of '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateEdgePattern_TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne(EdgePattern edgePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		
		// Inconsistent or missing opposite?
		if ((edgePattern.getOpposite() != null) && (edgePattern.getOpposite().getOpposite() != edgePattern)) {
			if (diagnostics != null) {
				diagnostics.add
				(createDiagnostic
						(Diagnostic.ERROR,
								DIAGNOSTIC_SOURCE,
								0,
								"_UI_GenericConstraint_diagnostic",
								new Object[] { "TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne", getObjectLabel(edgePattern, context) },
								new Object[] { edgePattern },
								context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the TheOppositeMayNotBeItsOwnOpposite constraint of '<em>Edge Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateEdgePattern_TheOppositeMayNotBeItsOwnOpposite(EdgePattern edgePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		
		if ((edgePattern != null) && (edgePattern.getOpposite() == edgePattern)) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "TheOppositeMayNotBeItsOwnOpposite", getObjectLabel(edgePattern, context) },
						 new Object[] { edgePattern },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributePattern(AttributePattern attributePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributePattern, diagnostics, context);
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
		return validate_EveryDefaultConstraint(parameter, diagnostics, context);
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
