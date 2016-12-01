/**
 */
package org.sidiff.consistency.graphpattern.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.consistency.graphpattern.Dependency;
import org.sidiff.consistency.graphpattern.DependencyGraph;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.GraphpatternPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.DependencyGraphImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.DependencyGraphImpl#getLast <em>Last</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.DependencyGraphImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.DependencyGraphImpl#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DependencyGraphImpl extends MinimalEObjectImpl.Container implements DependencyGraph {
	/**
	 * The cached value of the '{@link #getFirst() <em>First</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirst()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> first;

	/**
	 * The cached value of the '{@link #getLast() <em>Last</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLast()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> last;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> nodes;

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
	public EList<Dependency> getFirst() {
		if (first == null) {
			first = new EObjectResolvingEList<Dependency>(Dependency.class, this, GraphpatternPackage.DEPENDENCY_GRAPH__FIRST);
		}
		return first;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getLast() {
		if (last == null) {
			last = new EObjectResolvingEList<Dependency>(Dependency.class, this, GraphpatternPackage.DEPENDENCY_GRAPH__LAST);
		}
		return last;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public void setGraph(GraphPattern newGraph) {
		if (newGraph != eInternalContainer() || (eContainerFeatureID() != GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH && newGraph != null)) {
			if (EcoreUtil.isAncestor(this, newGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, GraphpatternPackage.GRAPH_PATTERN__DEPENDENCIES, GraphPattern.class, msgs);
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
	public EList<Dependency> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<Dependency>(Dependency.class, this, GraphpatternPackage.DEPENDENCY_GRAPH__NODES, GraphpatternPackage.DEPENDENCY__GRAPH);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGraph((GraphPattern)otherEnd, msgs);
			case GraphpatternPackage.DEPENDENCY_GRAPH__NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
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
				return eInternalContainer().eInverseRemove(this, GraphpatternPackage.GRAPH_PATTERN__DEPENDENCIES, GraphPattern.class, msgs);
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
			case GraphpatternPackage.DEPENDENCY_GRAPH__FIRST:
				return getFirst();
			case GraphpatternPackage.DEPENDENCY_GRAPH__LAST:
				return getLast();
			case GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH:
				return getGraph();
			case GraphpatternPackage.DEPENDENCY_GRAPH__NODES:
				return getNodes();
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
			case GraphpatternPackage.DEPENDENCY_GRAPH__FIRST:
				getFirst().clear();
				getFirst().addAll((Collection<? extends Dependency>)newValue);
				return;
			case GraphpatternPackage.DEPENDENCY_GRAPH__LAST:
				getLast().clear();
				getLast().addAll((Collection<? extends Dependency>)newValue);
				return;
			case GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH:
				setGraph((GraphPattern)newValue);
				return;
			case GraphpatternPackage.DEPENDENCY_GRAPH__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Dependency>)newValue);
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
			case GraphpatternPackage.DEPENDENCY_GRAPH__FIRST:
				getFirst().clear();
				return;
			case GraphpatternPackage.DEPENDENCY_GRAPH__LAST:
				getLast().clear();
				return;
			case GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH:
				setGraph((GraphPattern)null);
				return;
			case GraphpatternPackage.DEPENDENCY_GRAPH__NODES:
				getNodes().clear();
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
			case GraphpatternPackage.DEPENDENCY_GRAPH__FIRST:
				return first != null && !first.isEmpty();
			case GraphpatternPackage.DEPENDENCY_GRAPH__LAST:
				return last != null && !last.isEmpty();
			case GraphpatternPackage.DEPENDENCY_GRAPH__GRAPH:
				return getGraph() != null;
			case GraphpatternPackage.DEPENDENCY_GRAPH__NODES:
				return nodes != null && !nodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DependencyGraphImpl
