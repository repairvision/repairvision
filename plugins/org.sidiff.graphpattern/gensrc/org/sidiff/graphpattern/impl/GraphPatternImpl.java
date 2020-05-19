/**
 */
package org.sidiff.graphpattern.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.graphpattern.DependencyGraph;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.SubGraph;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.impl.GraphPatternImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.GraphPatternImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.GraphPatternImpl#getDependencyGraph <em>Dependency Graph</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.GraphPatternImpl#getSubgraphs <em>Subgraphs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphPatternImpl extends PatternElementImpl implements GraphPattern {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<NodePattern> nodes;

	/**
	 * The cached value of the '{@link #getDependencyGraph() <em>Dependency Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencyGraph()
	 * @generated
	 * @ordered
	 */
	protected DependencyGraph dependencyGraph;

	/**
	 * The cached value of the '{@link #getSubgraphs() <em>Subgraphs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubgraphs()
	 * @generated
	 * @ordered
	 */
	protected EList<SubGraph> subgraphs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.GRAPH_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NodePattern> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<NodePattern>(NodePattern.class, this, GraphpatternPackage.GRAPH_PATTERN__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Pattern getPattern() {
		if (eContainerFeatureID() != GraphpatternPackage.GRAPH_PATTERN__PATTERN) return null;
		return (Pattern)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPattern(Pattern newPattern, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPattern, GraphpatternPackage.GRAPH_PATTERN__PATTERN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPattern(Pattern newPattern) {
		if (newPattern != eInternalContainer() || (eContainerFeatureID() != GraphpatternPackage.GRAPH_PATTERN__PATTERN && newPattern != null)) {
			if (EcoreUtil.isAncestor(this, newPattern))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPattern != null)
				msgs = ((InternalEObject)newPattern).eInverseAdd(this, GraphpatternPackage.PATTERN__GRAPHS, Pattern.class, msgs);
			msgs = basicSetPattern(newPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.GRAPH_PATTERN__PATTERN, newPattern, newPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DependencyGraph getDependencyGraph() {
		return dependencyGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependencyGraph(DependencyGraph newDependencyGraph, NotificationChain msgs) {
		DependencyGraph oldDependencyGraph = dependencyGraph;
		dependencyGraph = newDependencyGraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphpatternPackage.GRAPH_PATTERN__DEPENDENCY_GRAPH, oldDependencyGraph, newDependencyGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDependencyGraph(DependencyGraph newDependencyGraph) {
		if (newDependencyGraph != dependencyGraph) {
			NotificationChain msgs = null;
			if (dependencyGraph != null)
				msgs = ((InternalEObject)dependencyGraph).eInverseRemove(this, GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH, DependencyGraph.class, msgs);
			if (newDependencyGraph != null)
				msgs = ((InternalEObject)newDependencyGraph).eInverseAdd(this, GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH, DependencyGraph.class, msgs);
			msgs = basicSetDependencyGraph(newDependencyGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.GRAPH_PATTERN__DEPENDENCY_GRAPH, newDependencyGraph, newDependencyGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubGraph> getSubgraphs() {
		if (subgraphs == null) {
			subgraphs = new EObjectContainmentEList<SubGraph>(SubGraph.class, this, GraphpatternPackage.GRAPH_PATTERN__SUBGRAPHS);
		}
		return subgraphs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public NodePattern getNode(String name) {
		
		for (NodePattern node : getNodes()) {
			if (node.getName().equals(name)) {
				return node;
			}
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPattern((Pattern)otherEnd, msgs);
			case GraphpatternPackage.GRAPH_PATTERN__DEPENDENCY_GRAPH:
				if (dependencyGraph != null)
					msgs = ((InternalEObject)dependencyGraph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphpatternPackage.GRAPH_PATTERN__DEPENDENCY_GRAPH, null, msgs);
				return basicSetDependencyGraph((DependencyGraph)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_PATTERN__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				return basicSetPattern(null, msgs);
			case GraphpatternPackage.GRAPH_PATTERN__DEPENDENCY_GRAPH:
				return basicSetDependencyGraph(null, msgs);
			case GraphpatternPackage.GRAPH_PATTERN__SUBGRAPHS:
				return ((InternalEList<?>)getSubgraphs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				return eInternalContainer().eInverseRemove(this, GraphpatternPackage.PATTERN__GRAPHS, Pattern.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_PATTERN__NODES:
				return getNodes();
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				return getPattern();
			case GraphpatternPackage.GRAPH_PATTERN__DEPENDENCY_GRAPH:
				return getDependencyGraph();
			case GraphpatternPackage.GRAPH_PATTERN__SUBGRAPHS:
				return getSubgraphs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_PATTERN__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends NodePattern>)newValue);
				return;
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				setPattern((Pattern)newValue);
				return;
			case GraphpatternPackage.GRAPH_PATTERN__DEPENDENCY_GRAPH:
				setDependencyGraph((DependencyGraph)newValue);
				return;
			case GraphpatternPackage.GRAPH_PATTERN__SUBGRAPHS:
				getSubgraphs().clear();
				getSubgraphs().addAll((Collection<? extends SubGraph>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_PATTERN__NODES:
				getNodes().clear();
				return;
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				setPattern((Pattern)null);
				return;
			case GraphpatternPackage.GRAPH_PATTERN__DEPENDENCY_GRAPH:
				setDependencyGraph((DependencyGraph)null);
				return;
			case GraphpatternPackage.GRAPH_PATTERN__SUBGRAPHS:
				getSubgraphs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_PATTERN__NODES:
				return nodes != null && !nodes.isEmpty();
			case GraphpatternPackage.GRAPH_PATTERN__PATTERN:
				return getPattern() != null;
			case GraphpatternPackage.GRAPH_PATTERN__DEPENDENCY_GRAPH:
				return dependencyGraph != null;
			case GraphpatternPackage.GRAPH_PATTERN__SUBGRAPHS:
				return subgraphs != null && !subgraphs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GraphpatternPackage.GRAPH_PATTERN___GET_NODE__STRING:
				return getNode((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Iterable<GraphElement> getGraphElements() {
		return new Iterable<GraphElement>() {
			
			@Override
			public Iterator<GraphElement> iterator() {
				return new Iterator<GraphElement>() {
					
					Iterator<EObject> content = eAllContents();
					
					EObject next = null;
					
					@Override
					public GraphElement next() {
						GraphElement nextElement = (GraphElement) next;
						next = null;
						
						while (content.hasNext() && (next == null)) {
							next = content.next();

							if (!(next instanceof GraphElement)) {
								next = null;
							}
						}

						return nextElement;
					}
					
					@Override
					public boolean hasNext() {
						
						if (next == null) {
							next();
						}
							
						return next != null;
					}
				};
			}
		};
	}
	
} //GraphPatternImpl
