/**
 */
package org.sidiff.graphpattern.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Stereotype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.impl.EdgePatternImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.EdgePatternImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.EdgePatternImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.EdgePatternImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EdgePatternImpl extends GraphElementImpl implements EdgePattern {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected NodePattern target;

	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected EdgePattern opposite;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EReference type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgePatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.EDGE_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodePattern getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (NodePattern)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphpatternPackage.EDGE_PATTERN__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodePattern basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(NodePattern newTarget, NotificationChain msgs) {
		NodePattern oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphpatternPackage.EDGE_PATTERN__TARGET, oldTarget, newTarget);
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
	public void setTarget(NodePattern newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, GraphpatternPackage.NODE_PATTERN__INCOMINGS, NodePattern.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, GraphpatternPackage.NODE_PATTERN__INCOMINGS, NodePattern.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.EDGE_PATTERN__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodePattern getSource() {
		if (eContainerFeatureID() != GraphpatternPackage.EDGE_PATTERN__SOURCE) return null;
		return (NodePattern)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(NodePattern newSource, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSource, GraphpatternPackage.EDGE_PATTERN__SOURCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(NodePattern newSource) {
		if (newSource != eInternalContainer() || (eContainerFeatureID() != GraphpatternPackage.EDGE_PATTERN__SOURCE && newSource != null)) {
			if (EcoreUtil.isAncestor(this, newSource))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, GraphpatternPackage.NODE_PATTERN__OUTGOINGS, NodePattern.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.EDGE_PATTERN__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EdgePattern getOpposite() {
		if (opposite != null && opposite.eIsProxy()) {
			InternalEObject oldOpposite = (InternalEObject)opposite;
			opposite = (EdgePattern)eResolveProxy(oldOpposite);
			if (opposite != oldOpposite) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphpatternPackage.EDGE_PATTERN__OPPOSITE, oldOpposite, opposite));
			}
		}
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgePattern basicGetOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOpposite(EdgePattern newOpposite) {
		EdgePattern oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.EDGE_PATTERN__OPPOSITE, oldOpposite, opposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EReference)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphpatternPackage.EDGE_PATTERN__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(EReference newType) {
		EReference oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.EDGE_PATTERN__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphpatternPackage.EDGE_PATTERN__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, GraphpatternPackage.NODE_PATTERN__INCOMINGS, NodePattern.class, msgs);
				return basicSetTarget((NodePattern)otherEnd, msgs);
			case GraphpatternPackage.EDGE_PATTERN__SOURCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSource((NodePattern)otherEnd, msgs);
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
			case GraphpatternPackage.EDGE_PATTERN__TARGET:
				return basicSetTarget(null, msgs);
			case GraphpatternPackage.EDGE_PATTERN__SOURCE:
				return basicSetSource(null, msgs);
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
			case GraphpatternPackage.EDGE_PATTERN__SOURCE:
				return eInternalContainer().eInverseRemove(this, GraphpatternPackage.NODE_PATTERN__OUTGOINGS, NodePattern.class, msgs);
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
			case GraphpatternPackage.EDGE_PATTERN__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case GraphpatternPackage.EDGE_PATTERN__SOURCE:
				return getSource();
			case GraphpatternPackage.EDGE_PATTERN__OPPOSITE:
				if (resolve) return getOpposite();
				return basicGetOpposite();
			case GraphpatternPackage.EDGE_PATTERN__TYPE:
				if (resolve) return getType();
				return basicGetType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphpatternPackage.EDGE_PATTERN__TARGET:
				setTarget((NodePattern)newValue);
				return;
			case GraphpatternPackage.EDGE_PATTERN__SOURCE:
				setSource((NodePattern)newValue);
				return;
			case GraphpatternPackage.EDGE_PATTERN__OPPOSITE:
				setOpposite((EdgePattern)newValue);
				return;
			case GraphpatternPackage.EDGE_PATTERN__TYPE:
				setType((EReference)newValue);
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
			case GraphpatternPackage.EDGE_PATTERN__TARGET:
				setTarget((NodePattern)null);
				return;
			case GraphpatternPackage.EDGE_PATTERN__SOURCE:
				setSource((NodePattern)null);
				return;
			case GraphpatternPackage.EDGE_PATTERN__OPPOSITE:
				setOpposite((EdgePattern)null);
				return;
			case GraphpatternPackage.EDGE_PATTERN__TYPE:
				setType((EReference)null);
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
			case GraphpatternPackage.EDGE_PATTERN__TARGET:
				return target != null;
			case GraphpatternPackage.EDGE_PATTERN__SOURCE:
				return getSource() != null;
			case GraphpatternPackage.EDGE_PATTERN__OPPOSITE:
				return opposite != null;
			case GraphpatternPackage.EDGE_PATTERN__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		
		// Stereotypes:
		String edgeStereotype = "";
		
		for (Stereotype stereotype : getStereotypes()) {
			edgeStereotype += stereotype.getName() + ","; 
		}
		
		if (edgeStereotype != "") {
			edgeStereotype = "<<" + edgeStereotype.substring(0, edgeStereotype.length() - 1) + ">> ";
		}
	
		// Path:
		String sourceName = getSource() != null ? getSource().getName() != null ? getSource().getName() : "" : "";
		String sourceType = getSource() != null ? getSource().getType() != null ? getSource().getType().getName() : "?" : "?";
		String targetName = getTarget() != null ? getTarget().getName() != null ? getTarget().getName() : "" : "";
		String targetType = getTarget() != null ? getTarget().getType() != null ? getTarget().getType().getName() : "?" : "?";
		
		String edgeType = getType() != null ? getType().getName() : "?";
		
		result.append(" (path: " 
				+ edgeStereotype
				+ "[" + sourceName+ ":" + sourceType + "]"
				+ " - " + edgeType + " -> " 
				+ "[" + targetName + ":" + targetType + "]" 
				+ ")");
		
		return result.toString();
	}

	@Override
	public Iterable<NodePattern> getConnected() {
		List<NodePattern> connected = new ArrayList<>(2);
		
		if (getSource() != null) {
			connected.add(getSource());
		}
		
		if (getTarget() != null) {
			connected.add(getTarget());
		}
		
		return connected;
	}

} //EdgePatternImpl
