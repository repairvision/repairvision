/**
 */
package org.sidiff.revision.changes.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.revision.changes.ActionType;
import org.sidiff.revision.changes.AttributeChange;
import org.sidiff.revision.changes.AttributeChangeContext;
import org.sidiff.revision.changes.Change;
import org.sidiff.revision.changes.ChangeSet;
import org.sidiff.revision.changes.ChangesPackage;
import org.sidiff.revision.changes.EdgeChange;
import org.sidiff.revision.changes.EdgeChangeContext;
import org.sidiff.revision.changes.NodeChange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.changes.impl.ChangeSetImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.sidiff.revision.changes.impl.ChangeSetImpl#getEdges <em>Edges</em>}</li>
 *   <li>{@link org.sidiff.revision.changes.impl.ChangeSetImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ChangeSetImpl extends MinimalEObjectImpl.Container implements ChangeSet {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeChange> nodes;
	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<EdgeChange> edges;
	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeChange> attributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangeSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangesPackage.Literals.CHANGE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NodeChange> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<NodeChange>(NodeChange.class, this,
					ChangesPackage.CHANGE_SET__NODES, ChangesPackage.NODE_CHANGE__CONTEXT);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EdgeChange> getEdges() {
		if (edges == null) {
			edges = new EObjectContainmentWithInverseEList<EdgeChange>(EdgeChange.class, this,
					ChangesPackage.CHANGE_SET__EDGES, ChangesPackage.EDGE_CHANGE__CONTEXT);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeChange> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<AttributeChange>(AttributeChange.class, this,
					ChangesPackage.CHANGE_SET__ATTRIBUTES, ChangesPackage.ATTRIBUTE_CHANGE__CONTEXT);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Iterator<Change> getChanges() {
		return Stream.concat(Stream.concat(
				getNodes().stream(), 
				getAttributes().stream()), 
				getEdges().stream()).iterator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ActionType getAction(Change change) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EAttribute getType(AttributeChange attributeChange) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EObject getNode(AttributeChange attributeChange) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EClass getNodeType(AttributeChange attributeChange) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<EObject> getNodeDomain(AttributeChange attributeChange) {
		return ECollections.emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EDataType getValueType(AttributeChange attributeChange) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Object> getValueDomain(AttributeChange attributeChange) {
		return ECollections.emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getValue(AttributeChange attributeChange) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EReference getType(EdgeChange edgeChange) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EClass getSourceType(EdgeChange edgeChange) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<EObject> getSourceDomain(EdgeChange edgeChange) {
		return ECollections.emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EObject getSource(EdgeChange edgeChange) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EClass getTargetType(EdgeChange edgeChange) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<EObject> getTargetDomain(EdgeChange edgeChange) {
		return ECollections.emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EObject getTarget(EdgeChange edgeChange) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EObject getNode(NodeChange nodeChange) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<EObject> getNodeDomains(NodeChange nodeChange) {
		return ECollections.emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EClass getType(NodeChange nodeChange) {
		return null;
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
		case ChangesPackage.CHANGE_SET__NODES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getNodes()).basicAdd(otherEnd, msgs);
		case ChangesPackage.CHANGE_SET__EDGES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getEdges()).basicAdd(otherEnd, msgs);
		case ChangesPackage.CHANGE_SET__ATTRIBUTES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getAttributes()).basicAdd(otherEnd, msgs);
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
		case ChangesPackage.CHANGE_SET__NODES:
			return ((InternalEList<?>) getNodes()).basicRemove(otherEnd, msgs);
		case ChangesPackage.CHANGE_SET__EDGES:
			return ((InternalEList<?>) getEdges()).basicRemove(otherEnd, msgs);
		case ChangesPackage.CHANGE_SET__ATTRIBUTES:
			return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
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
		case ChangesPackage.CHANGE_SET__NODES:
			return getNodes();
		case ChangesPackage.CHANGE_SET__EDGES:
			return getEdges();
		case ChangesPackage.CHANGE_SET__ATTRIBUTES:
			return getAttributes();
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
		case ChangesPackage.CHANGE_SET__NODES:
			getNodes().clear();
			getNodes().addAll((Collection<? extends NodeChange>) newValue);
			return;
		case ChangesPackage.CHANGE_SET__EDGES:
			getEdges().clear();
			getEdges().addAll((Collection<? extends EdgeChange>) newValue);
			return;
		case ChangesPackage.CHANGE_SET__ATTRIBUTES:
			getAttributes().clear();
			getAttributes().addAll((Collection<? extends AttributeChange>) newValue);
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
		case ChangesPackage.CHANGE_SET__NODES:
			getNodes().clear();
			return;
		case ChangesPackage.CHANGE_SET__EDGES:
			getEdges().clear();
			return;
		case ChangesPackage.CHANGE_SET__ATTRIBUTES:
			getAttributes().clear();
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
		case ChangesPackage.CHANGE_SET__NODES:
			return nodes != null && !nodes.isEmpty();
		case ChangesPackage.CHANGE_SET__EDGES:
			return edges != null && !edges.isEmpty();
		case ChangesPackage.CHANGE_SET__ATTRIBUTES:
			return attributes != null && !attributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EdgeChangeContext.class) {
			switch (derivedFeatureID) {
			case ChangesPackage.CHANGE_SET__EDGES:
				return ChangesPackage.EDGE_CHANGE_CONTEXT__EDGES;
			default:
				return -1;
			}
		}
		if (baseClass == AttributeChangeContext.class) {
			switch (derivedFeatureID) {
			case ChangesPackage.CHANGE_SET__ATTRIBUTES:
				return ChangesPackage.ATTRIBUTE_CHANGE_CONTEXT__ATTRIBUTES;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EdgeChangeContext.class) {
			switch (baseFeatureID) {
			case ChangesPackage.EDGE_CHANGE_CONTEXT__EDGES:
				return ChangesPackage.CHANGE_SET__EDGES;
			default:
				return -1;
			}
		}
		if (baseClass == AttributeChangeContext.class) {
			switch (baseFeatureID) {
			case ChangesPackage.ATTRIBUTE_CHANGE_CONTEXT__ATTRIBUTES:
				return ChangesPackage.CHANGE_SET__ATTRIBUTES;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == EdgeChangeContext.class) {
			switch (baseOperationID) {
			case ChangesPackage.EDGE_CHANGE_CONTEXT___GET_TYPE__EDGECHANGE:
				return ChangesPackage.CHANGE_SET___GET_TYPE__EDGECHANGE;
			case ChangesPackage.EDGE_CHANGE_CONTEXT___GET_SOURCE_TYPE__EDGECHANGE:
				return ChangesPackage.CHANGE_SET___GET_SOURCE_TYPE__EDGECHANGE;
			case ChangesPackage.EDGE_CHANGE_CONTEXT___GET_SOURCE_DOMAIN__EDGECHANGE:
				return ChangesPackage.CHANGE_SET___GET_SOURCE_DOMAIN__EDGECHANGE;
			case ChangesPackage.EDGE_CHANGE_CONTEXT___GET_SOURCE__EDGECHANGE:
				return ChangesPackage.CHANGE_SET___GET_SOURCE__EDGECHANGE;
			case ChangesPackage.EDGE_CHANGE_CONTEXT___GET_TARGET_TYPE__EDGECHANGE:
				return ChangesPackage.CHANGE_SET___GET_TARGET_TYPE__EDGECHANGE;
			case ChangesPackage.EDGE_CHANGE_CONTEXT___GET_TARGET_DOMAIN__EDGECHANGE:
				return ChangesPackage.CHANGE_SET___GET_TARGET_DOMAIN__EDGECHANGE;
			case ChangesPackage.EDGE_CHANGE_CONTEXT___GET_TARGET__EDGECHANGE:
				return ChangesPackage.CHANGE_SET___GET_TARGET__EDGECHANGE;
			default:
				return -1;
			}
		}
		if (baseClass == AttributeChangeContext.class) {
			switch (baseOperationID) {
			case ChangesPackage.ATTRIBUTE_CHANGE_CONTEXT___GET_TYPE__ATTRIBUTECHANGE:
				return ChangesPackage.CHANGE_SET___GET_TYPE__ATTRIBUTECHANGE;
			case ChangesPackage.ATTRIBUTE_CHANGE_CONTEXT___GET_NODE__ATTRIBUTECHANGE:
				return ChangesPackage.CHANGE_SET___GET_NODE__ATTRIBUTECHANGE;
			case ChangesPackage.ATTRIBUTE_CHANGE_CONTEXT___GET_NODE_TYPE__ATTRIBUTECHANGE:
				return ChangesPackage.CHANGE_SET___GET_NODE_TYPE__ATTRIBUTECHANGE;
			case ChangesPackage.ATTRIBUTE_CHANGE_CONTEXT___GET_NODE_DOMAIN__ATTRIBUTECHANGE:
				return ChangesPackage.CHANGE_SET___GET_NODE_DOMAIN__ATTRIBUTECHANGE;
			case ChangesPackage.ATTRIBUTE_CHANGE_CONTEXT___GET_VALUE_TYPE__ATTRIBUTECHANGE:
				return ChangesPackage.CHANGE_SET___GET_VALUE_TYPE__ATTRIBUTECHANGE;
			case ChangesPackage.ATTRIBUTE_CHANGE_CONTEXT___GET_VALUE_DOMAIN__ATTRIBUTECHANGE:
				return ChangesPackage.CHANGE_SET___GET_VALUE_DOMAIN__ATTRIBUTECHANGE;
			case ChangesPackage.ATTRIBUTE_CHANGE_CONTEXT___GET_VALUE__ATTRIBUTECHANGE:
				return ChangesPackage.CHANGE_SET___GET_VALUE__ATTRIBUTECHANGE;
			default:
				return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case ChangesPackage.CHANGE_SET___GET_CHANGES:
			return getChanges();
		case ChangesPackage.CHANGE_SET___GET_ACTION__CHANGE:
			return getAction((Change) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_TYPE__ATTRIBUTECHANGE:
			return getType((AttributeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_NODE__ATTRIBUTECHANGE:
			return getNode((AttributeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_NODE_TYPE__ATTRIBUTECHANGE:
			return getNodeType((AttributeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_NODE_DOMAIN__ATTRIBUTECHANGE:
			return getNodeDomain((AttributeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_VALUE_TYPE__ATTRIBUTECHANGE:
			return getValueType((AttributeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_VALUE_DOMAIN__ATTRIBUTECHANGE:
			return getValueDomain((AttributeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_VALUE__ATTRIBUTECHANGE:
			return getValue((AttributeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_TYPE__EDGECHANGE:
			return getType((EdgeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_SOURCE_TYPE__EDGECHANGE:
			return getSourceType((EdgeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_SOURCE_DOMAIN__EDGECHANGE:
			return getSourceDomain((EdgeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_SOURCE__EDGECHANGE:
			return getSource((EdgeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_TARGET_TYPE__EDGECHANGE:
			return getTargetType((EdgeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_TARGET_DOMAIN__EDGECHANGE:
			return getTargetDomain((EdgeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_TARGET__EDGECHANGE:
			return getTarget((EdgeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_NODE__NODECHANGE:
			return getNode((NodeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_NODE_DOMAINS__NODECHANGE:
			return getNodeDomains((NodeChange) arguments.get(0));
		case ChangesPackage.CHANGE_SET___GET_TYPE__NODECHANGE:
			return getType((NodeChange) arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ChangeSetImpl
