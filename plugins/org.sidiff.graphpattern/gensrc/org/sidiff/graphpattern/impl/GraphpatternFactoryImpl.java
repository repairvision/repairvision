/**
 */
package org.sidiff.graphpattern.impl;

import java.util.Arrays;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sidiff.graphpattern.Assignment;
import org.sidiff.graphpattern.Association;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.DependencyEdge;
import org.sidiff.graphpattern.DependencyGraph;
import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.EObjectList;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.ObjectBinding;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.Profile;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.SubGraph;
import org.sidiff.graphpattern.ValueBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphpatternFactoryImpl extends EFactoryImpl implements GraphpatternFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphpatternFactory init() {
		try {
			GraphpatternFactory theGraphpatternFactory = (GraphpatternFactory)EPackage.Registry.INSTANCE.getEFactory(GraphpatternPackage.eNS_URI);
			if (theGraphpatternFactory != null) {
				return theGraphpatternFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphpatternFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphpatternFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GraphpatternPackage.GRAPH_PATTERN: return createGraphPattern();
			case GraphpatternPackage.NODE_PATTERN: return createNodePattern();
			case GraphpatternPackage.EDGE_PATTERN: return createEdgePattern();
			case GraphpatternPackage.ATTRIBUTE_PATTERN: return createAttributePattern();
			case GraphpatternPackage.BUNDLE: return createBundle();
			case GraphpatternPackage.PATTERN: return createPattern();
			case GraphpatternPackage.PARAMETER: return createParameter();
			case GraphpatternPackage.EOBJECT_LIST: return createEObjectList();
			case GraphpatternPackage.DEPENDENCY_GRAPH: return createDependencyGraph();
			case GraphpatternPackage.DEPENDENCY_NODE: return createDependencyNode();
			case GraphpatternPackage.DEPENDENCY_EDGE: return createDependencyEdge();
			case GraphpatternPackage.ASSOCIATION: return createAssociation();
			case GraphpatternPackage.STEREOTYPE: return createStereotype();
			case GraphpatternPackage.ASSIGNMENT: return createAssignment();
			case GraphpatternPackage.OBJECT_BINDING: return createObjectBinding();
			case GraphpatternPackage.VALUE_BINDING: return createValueBinding();
			case GraphpatternPackage.SUB_GRAPH: return createSubGraph();
			case GraphpatternPackage.PROFILE: return createProfile();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphPattern createGraphPattern() {
		GraphPatternImpl graphPattern = new GraphPatternImpl();
		return graphPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodePattern createNodePattern() {
		NodePatternImpl nodePattern = new NodePatternImpl();
		return nodePattern;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public NodePattern createNodePattern(GraphPattern graph, String name, EClass type, Stereotype... stereotypes) {
		NodePattern node = createNodePattern();
		node.setName(name);
		node.setType(type);
		node.getStereotypes().addAll(Arrays.asList(stereotypes));
		
		graph.getNodes().add(node);
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EdgePattern createEdgePattern() {
		EdgePatternImpl edgePattern = new EdgePatternImpl();
		return edgePattern;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EdgePattern createEdgePattern(NodePattern source, EReference type, NodePattern target, Stereotype... stereotypes) {
		EdgePattern edge = createEdgePattern();
		edge.setSource(source);
		edge.setTarget(target);
		edge.setType(type);
		edge.getStereotypes().addAll(Arrays.asList(stereotypes));
		
		return edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributePattern createAttributePattern() {
		AttributePatternImpl attributePattern = new AttributePatternImpl();
		return attributePattern;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public AttributePattern createAttributePattern(NodePattern node, EAttribute type, String value, Stereotype... stereotypes) {
		AttributePattern attribute = createAttributePattern();
		attribute.setNode(node);
		attribute.setType(type);
		attribute.setValue(value);
		attribute.getStereotypes().addAll(Arrays.asList(stereotypes));
		
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bundle createBundle() {
		BundleImpl bundle = new BundleImpl();
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObjectList createEObjectList() {
		EObjectListImpl eObjectList = new EObjectListImpl();
		return eObjectList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DependencyGraph createDependencyGraph() {
		DependencyGraphImpl dependencyGraph = new DependencyGraphImpl();
		return dependencyGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DependencyNode createDependencyNode() {
		DependencyNodeImpl dependencyNode = new DependencyNodeImpl();
		return dependencyNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DependencyEdge createDependencyEdge() {
		DependencyEdgeImpl dependencyEdge = new DependencyEdgeImpl();
		return dependencyEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Association createAssociation() {
		AssociationImpl association = new AssociationImpl();
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Stereotype createStereotype() {
		StereotypeImpl stereotype = new StereotypeImpl();
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectBinding createObjectBinding() {
		ObjectBindingImpl objectBinding = new ObjectBindingImpl();
		return objectBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueBinding createValueBinding() {
		ValueBindingImpl valueBinding = new ValueBindingImpl();
		return valueBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubGraph createSubGraph() {
		SubGraphImpl subGraph = new SubGraphImpl();
		return subGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Profile createProfile() {
		ProfileImpl profile = new ProfileImpl();
		return profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Pattern createPattern() {
		PatternImpl pattern = new PatternImpl();
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphpatternPackage getGraphpatternPackage() {
		return (GraphpatternPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphpatternPackage getPackage() {
		return GraphpatternPackage.eINSTANCE;
	}

} //GraphpatternFactoryImpl
