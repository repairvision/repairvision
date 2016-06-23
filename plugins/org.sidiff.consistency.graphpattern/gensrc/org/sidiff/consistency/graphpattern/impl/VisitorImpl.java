/**
 */
package org.sidiff.consistency.graphpattern.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sidiff.consistency.graphpattern.Constraint;
import org.sidiff.consistency.graphpattern.Evaluation;
import org.sidiff.consistency.graphpattern.GraphpatternPackage;
import org.sidiff.consistency.graphpattern.Mediator;
import org.sidiff.consistency.graphpattern.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Visitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.VisitorImpl#getCovisitors <em>Covisitors</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.VisitorImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.VisitorImpl#getMediator <em>Mediator</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class VisitorImpl extends MinimalEObjectImpl.Container implements Visitor {
	/**
	 * The cached value of the '{@link #getCovisitors() <em>Covisitors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCovisitors()
	 * @generated
	 * @ordered
	 */
	protected EList<Visitor> covisitors;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * The cached value of the '{@link #getMediator() <em>Mediator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediator()
	 * @generated
	 * @ordered
	 */
	protected Mediator mediator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisitorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.VISITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Visitor> getCovisitors() {
		if (covisitors == null) {
			covisitors = new EObjectResolvingEList<Visitor>(Visitor.class, this, GraphpatternPackage.VISITOR__COVISITORS);
		}
		return covisitors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectResolvingEList<Constraint>(Constraint.class, this, GraphpatternPackage.VISITOR__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mediator getMediator() {
		if (mediator != null && mediator.eIsProxy()) {
			InternalEObject oldMediator = (InternalEObject)mediator;
			mediator = (Mediator)eResolveProxy(oldMediator);
			if (mediator != oldMediator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphpatternPackage.VISITOR__MEDIATOR, oldMediator, mediator));
			}
		}
		return mediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mediator basicGetMediator() {
		return mediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMediator(Mediator newMediator, NotificationChain msgs) {
		Mediator oldMediator = mediator;
		mediator = newMediator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphpatternPackage.VISITOR__MEDIATOR, oldMediator, newMediator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediator(Mediator newMediator) {
		if (newMediator != mediator) {
			NotificationChain msgs = null;
			if (mediator != null)
				msgs = ((InternalEObject)mediator).eInverseRemove(this, GraphpatternPackage.MEDIATOR__VISITORS, Mediator.class, msgs);
			if (newMediator != null)
				msgs = ((InternalEObject)newMediator).eInverseAdd(this, GraphpatternPackage.MEDIATOR__VISITORS, Mediator.class, msgs);
			msgs = basicSetMediator(newMediator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.VISITOR__MEDIATOR, newMediator, newMediator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void visit(Evaluation evaluation) {
		// Clients will overwrite this method...
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphpatternPackage.VISITOR__MEDIATOR:
				if (mediator != null)
					msgs = ((InternalEObject)mediator).eInverseRemove(this, GraphpatternPackage.MEDIATOR__VISITORS, Mediator.class, msgs);
				return basicSetMediator((Mediator)otherEnd, msgs);
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
			case GraphpatternPackage.VISITOR__MEDIATOR:
				return basicSetMediator(null, msgs);
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
			case GraphpatternPackage.VISITOR__COVISITORS:
				return getCovisitors();
			case GraphpatternPackage.VISITOR__CONSTRAINTS:
				return getConstraints();
			case GraphpatternPackage.VISITOR__MEDIATOR:
				if (resolve) return getMediator();
				return basicGetMediator();
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
			case GraphpatternPackage.VISITOR__COVISITORS:
				getCovisitors().clear();
				getCovisitors().addAll((Collection<? extends Visitor>)newValue);
				return;
			case GraphpatternPackage.VISITOR__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case GraphpatternPackage.VISITOR__MEDIATOR:
				setMediator((Mediator)newValue);
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
			case GraphpatternPackage.VISITOR__COVISITORS:
				getCovisitors().clear();
				return;
			case GraphpatternPackage.VISITOR__CONSTRAINTS:
				getConstraints().clear();
				return;
			case GraphpatternPackage.VISITOR__MEDIATOR:
				setMediator((Mediator)null);
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
			case GraphpatternPackage.VISITOR__COVISITORS:
				return covisitors != null && !covisitors.isEmpty();
			case GraphpatternPackage.VISITOR__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case GraphpatternPackage.VISITOR__MEDIATOR:
				return mediator != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Evaluation createEvaluation() {
		// Clients will overwrite this method...
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GraphpatternPackage.VISITOR___VISIT__EVALUATION:
				visit((Evaluation)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //VisitorImpl
