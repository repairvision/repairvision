/**
 */
package org.sidiff.consistency.graphpattern.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.consistency.graphpattern.DataStore;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.Evaluation;
import org.sidiff.consistency.graphpattern.GraphpatternPackage;
import org.sidiff.consistency.graphpattern.NavigableDataStore;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Evaluation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.EvaluationImpl#getNode <em>Node</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.EvaluationImpl#getMatches <em>Matches</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.EvaluationImpl#getStore <em>Store</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EvaluationImpl extends MinimalEObjectImpl.Container implements Evaluation {
	/**
	 * The cached value of the '{@link #getStore() <em>Store</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStore()
	 * @generated
	 * @ordered
	 */
	protected DataStore store;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EvaluationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.EVALUATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodePattern getNode() {
		if (eContainerFeatureID() != GraphpatternPackage.EVALUATION__NODE) return null;
		return (NodePattern)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode(NodePattern newNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNode, GraphpatternPackage.EVALUATION__NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(NodePattern newNode) {
		if (newNode != eInternalContainer() || (eContainerFeatureID() != GraphpatternPackage.EVALUATION__NODE && newNode != null)) {
			if (EcoreUtil.isAncestor(this, newNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNode != null)
				msgs = ((InternalEObject)newNode).eInverseAdd(this, GraphpatternPackage.NODE_PATTERN__EVALUATION, NodePattern.class, msgs);
			msgs = basicSetNode(newNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.EVALUATION__NODE, newNode, newNode));
	}
	
	// TODO[TEST]: Show match:
	EList<EObject> match; 
	
	public void testSetMatch(EObject match) {
		if (match != null) {
			this.match = ECollections.singletonEList(match);
		} else {
			this.match = null;
		}
	}
	//-----------------------
	
	/**
	 * <!-- begin-user-doc -->
	 * Returns a fresh modifiable/unreflected list of the actually matched model elements.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EObject> getMatches() {
		EList<EObject> matches = new BasicEList<>();
		
		// TODO[TEST]: Show match:
		if (match != null) {
			return match;
		}
		//------------------------
		
		getStore().getMatchIterator().forEachRemaining(match -> matches.add(match));
		return matches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataStore getStore() {
		if (store != null && store.eIsProxy()) {
			InternalEObject oldStore = (InternalEObject)store;
			store = (DataStore)eResolveProxy(oldStore);
			if (store != oldStore) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphpatternPackage.EVALUATION__STORE, oldStore, store));
			}
		}
		return store;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataStore basicGetStore() {
		return store;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStore(DataStore newStore, NotificationChain msgs) {
		DataStore oldStore = store;
		store = newStore;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphpatternPackage.EVALUATION__STORE, oldStore, newStore);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStore(DataStore newStore) {
		if (newStore != store) {
			NotificationChain msgs = null;
			if (store != null)
				msgs = ((InternalEObject)store).eInverseRemove(this, GraphpatternPackage.DATA_STORE__EVALUATION, DataStore.class, msgs);
			if (newStore != null)
				msgs = ((InternalEObject)newStore).eInverseAdd(this, GraphpatternPackage.DATA_STORE__EVALUATION, DataStore.class, msgs);
			msgs = basicSetStore(newStore, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.EVALUATION__STORE, newStore, newStore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void initialize() {
		// Clients will overwrite this method...
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphpatternPackage.EVALUATION__NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNode((NodePattern)otherEnd, msgs);
			case GraphpatternPackage.EVALUATION__STORE:
				if (store != null)
					msgs = ((InternalEObject)store).eInverseRemove(this, GraphpatternPackage.DATA_STORE__EVALUATION, DataStore.class, msgs);
				return basicSetStore((DataStore)otherEnd, msgs);
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
			case GraphpatternPackage.EVALUATION__NODE:
				return basicSetNode(null, msgs);
			case GraphpatternPackage.EVALUATION__STORE:
				return basicSetStore(null, msgs);
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
			case GraphpatternPackage.EVALUATION__NODE:
				return eInternalContainer().eInverseRemove(this, GraphpatternPackage.NODE_PATTERN__EVALUATION, NodePattern.class, msgs);
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
			case GraphpatternPackage.EVALUATION__NODE:
				return getNode();
			case GraphpatternPackage.EVALUATION__MATCHES:
				return getMatches();
			case GraphpatternPackage.EVALUATION__STORE:
				if (resolve) return getStore();
				return basicGetStore();
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
			case GraphpatternPackage.EVALUATION__NODE:
				setNode((NodePattern)newValue);
				return;
			case GraphpatternPackage.EVALUATION__MATCHES:
				getMatches().clear();
				getMatches().addAll((Collection<? extends EObject>)newValue);
				return;
			case GraphpatternPackage.EVALUATION__STORE:
				setStore((DataStore)newValue);
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
			case GraphpatternPackage.EVALUATION__NODE:
				setNode((NodePattern)null);
				return;
			case GraphpatternPackage.EVALUATION__MATCHES:
				getMatches().clear();
				return;
			case GraphpatternPackage.EVALUATION__STORE:
				setStore((DataStore)null);
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
			case GraphpatternPackage.EVALUATION__NODE:
				return getNode() != null;
			case GraphpatternPackage.EVALUATION__MATCHES:
				return !getMatches().isEmpty();
			case GraphpatternPackage.EVALUATION__STORE:
				return store != null;
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
			case GraphpatternPackage.EVALUATION___INITIALIZE:
				initialize();
				return null;
			case GraphpatternPackage.EVALUATION___ACCEPT__VISITOR:
				accept((Visitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuffer out = new StringBuffer();
		
		out.append("Node-Pattern : " + getNode());
		out.append("\nEvaluation   : " + super.toString());
		out.append("\nData-Store   : " + getStore());
		
		if (getStore() != null) {
			out.append("\n\nMatches: " + "(size: " + getStore().getMatchSize() + ")");

			getStore().getMatchIterator().forEachRemaining(localMatch -> {
				out.append("\n  Local-Match: " + localMatch);

				if ((getStore() instanceof NavigableDataStore) && (getNode() != null)) {
					NavigableDataStore naviDataStore = (NavigableDataStore) getStore();

					for (EdgePattern ougoingEdge : getNode().getOutgoings()) { // TODO: Need all incident edges.
						out.append("\n    Edge: " + ougoingEdge);

						naviDataStore.getRemoteMatchIterator(localMatch, ougoingEdge).forEachRemaining(remoteMatch -> {
							out.append("\n      Remote-Match: " + remoteMatch);
						});
					}
				}
			});			
		}
		
		return out.toString();
	}

} //EvaluationImpl
