/**
 */
package org.sidiff.graphpattern.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.graphpattern.DependencyEdge;
import org.sidiff.graphpattern.DependencyGraph;
import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.impl.DependencyGraphImpl#getIndependent <em>Independent</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.DependencyGraphImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.DependencyGraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.DependencyGraphImpl#getEdges <em>Edges</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DependencyGraphImpl extends MinimalEObjectImpl.Container implements DependencyGraph {
	/**
	 * The cached value of the '{@link #getIndependent() <em>Independent</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndependent()
	 * @generated
	 * @ordered
	 */
	protected EList<DependencyNode> independent;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<DependencyNode> nodes;

	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<DependencyEdge> edges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.DEPENDENCY_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DependencyNode> getIndependent() {
		if (independent == null) {
			independent = new EObjectResolvingEList<DependencyNode>(DependencyNode.class, this, GraphpatternPackage.DEPENDENCY_GRAPH__INDEPENDENT);
		}
		return independent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphPattern getGraph() {
		if (eContainerFeatureID() != GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH) return null;
		return (GraphPattern)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(GraphPattern newGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGraph, GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGraph(GraphPattern newGraph) {
		if (newGraph != eInternalContainer() || (eContainerFeatureID() != GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH && newGraph != null)) {
			if (EcoreUtil.isAncestor(this, newGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, GraphpatternPackage.GRAPH_PATTERN__DEPENDENCY_GRAPH, GraphPattern.class, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DependencyNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<DependencyNode>(DependencyNode.class, this, GraphpatternPackage.DEPENDENCY_GRAPH__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DependencyEdge> getEdges() {
		if (edges == null) {
			edges = new EObjectContainmentEList<DependencyEdge>(DependencyEdge.class, this, GraphpatternPackage.DEPENDENCY_GRAPH__EDGES);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGraph((GraphPattern)otherEnd, msgs);
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
			case GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH:
				return basicSetGraph(null, msgs);
			case GraphpatternPackage.DEPENDENCY_GRAPH__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case GraphpatternPackage.DEPENDENCY_GRAPH__EDGES:
				return ((InternalEList<?>)getEdges()).basicRemove(otherEnd, msgs);
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
			case GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH:
				return eInternalContainer().eInverseRemove(this, GraphpatternPackage.GRAPH_PATTERN__DEPENDENCY_GRAPH, GraphPattern.class, msgs);
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
			case GraphpatternPackage.DEPENDENCY_GRAPH__INDEPENDENT:
				return getIndependent();
			case GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH:
				return getGraph();
			case GraphpatternPackage.DEPENDENCY_GRAPH__NODES:
				return getNodes();
			case GraphpatternPackage.DEPENDENCY_GRAPH__EDGES:
				return getEdges();
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
			case GraphpatternPackage.DEPENDENCY_GRAPH__INDEPENDENT:
				getIndependent().clear();
				getIndependent().addAll((Collection<? extends DependencyNode>)newValue);
				return;
			case GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH:
				setGraph((GraphPattern)newValue);
				return;
			case GraphpatternPackage.DEPENDENCY_GRAPH__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends DependencyNode>)newValue);
				return;
			case GraphpatternPackage.DEPENDENCY_GRAPH__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends DependencyEdge>)newValue);
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
			case GraphpatternPackage.DEPENDENCY_GRAPH__INDEPENDENT:
				getIndependent().clear();
				return;
			case GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH:
				setGraph((GraphPattern)null);
				return;
			case GraphpatternPackage.DEPENDENCY_GRAPH__NODES:
				getNodes().clear();
				return;
			case GraphpatternPackage.DEPENDENCY_GRAPH__EDGES:
				getEdges().clear();
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
			case GraphpatternPackage.DEPENDENCY_GRAPH__INDEPENDENT:
				return independent != null && !independent.isEmpty();
			case GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH:
				return getGraph() != null;
			case GraphpatternPackage.DEPENDENCY_GRAPH__NODES:
				return nodes != null && !nodes.isEmpty();
			case GraphpatternPackage.DEPENDENCY_GRAPH__EDGES:
				return edges != null && !edges.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DependencyGraphImpl
