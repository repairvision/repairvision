/**
 */
package org.sidiff.graphpattern.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;
import java.util.function.Predicate;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.SubGraph;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.impl.GraphElementImpl#getSubgraphs <em>Subgraphs</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.GraphElementImpl#getGraph <em>Graph</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GraphElementImpl extends PatternElementImpl implements GraphElement {
	/**
	 * The cached value of the '{@link #getSubgraphs() <em>Subgraphs</em>}' reference list.
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
	protected GraphElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.GRAPH_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubGraph> getSubgraphs() {
		if (subgraphs == null) {
			subgraphs = new EObjectWithInverseResolvingEList.ManyInverse<SubGraph>(SubGraph.class, this, GraphpatternPackage.GRAPH_ELEMENT__SUBGRAPHS, GraphpatternPackage.SUB_GRAPH__ELEMENTS);
		}
		return subgraphs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphPattern getGraph() {
		GraphPattern graph = basicGetGraph();
		return graph != null && graph.eIsProxy() ? (GraphPattern)eResolveProxy((InternalEObject)graph) : graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public GraphPattern basicGetGraph() {
		GraphPattern graph = null;
		EObject container = this;
		
		while ((graph == null) && (container != null)) {
			if (container instanceof GraphPattern) {
				graph = (GraphPattern) container;
			} else {
				container = container.eContainer();
			}
		}
		
		return graph;
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
			case GraphpatternPackage.GRAPH_ELEMENT__SUBGRAPHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubgraphs()).basicAdd(otherEnd, msgs);
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
			case GraphpatternPackage.GRAPH_ELEMENT__SUBGRAPHS:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphpatternPackage.GRAPH_ELEMENT__SUBGRAPHS:
				return getSubgraphs();
			case GraphpatternPackage.GRAPH_ELEMENT__GRAPH:
				if (resolve) return getGraph();
				return basicGetGraph();
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
			case GraphpatternPackage.GRAPH_ELEMENT__SUBGRAPHS:
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
			case GraphpatternPackage.GRAPH_ELEMENT__SUBGRAPHS:
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
			case GraphpatternPackage.GRAPH_ELEMENT__SUBGRAPHS:
				return subgraphs != null && !subgraphs.isEmpty();
			case GraphpatternPackage.GRAPH_ELEMENT__GRAPH:
				return basicGetGraph() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public Iterable<GraphElement> getClosure(Predicate<GraphElement> condition) {
		return new Iterable<GraphElement>() {
			
			@Override
			public Iterator<GraphElement> iterator() {
				return new Iterator<GraphElement>() {
					
					Set<GraphElement> visited = new HashSet<>();
					
					Stack<GraphElement> connected = new Stack<>();
					
					GraphElement next = null;
					
					@Override
					public GraphElement next() {
						
						if (visited.isEmpty()) {
							next = GraphElementImpl.this;
							visited.add(next);
							return next;
						} else {
							if (next != null) {
								GraphElement current = next;
								visited.add(current);
								
								for (GraphElement connectedElement : next.getConnected()) {
									if (!visited.contains(connectedElement)) {
										if (condition.test(connectedElement)) {
											connected.push(connectedElement);
										}
									}
								}
								
								if (!connected.isEmpty()) {
									next = connected.pop();
								} else {
									next = null;
								}
								
								return current;
							} else {
								throw new NoSuchElementException();
							}
						}
					}
					
					@Override
					public boolean hasNext() {
						return (next != null) || visited.isEmpty();
					}
				};
			}
		};
	}
	
} //GraphElementImpl
