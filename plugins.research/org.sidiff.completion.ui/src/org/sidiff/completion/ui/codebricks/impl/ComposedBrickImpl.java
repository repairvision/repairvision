/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.ComposedBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composed Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.ComposedBrickImpl#getCodebrick <em>Codebrick</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.ComposedBrickImpl#getBricks <em>Bricks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComposedBrickImpl extends MinimalEObjectImpl.Container implements ComposedBrick {
	/**
	 * The cached value of the '{@link #getBricks() <em>Bricks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBricks()
	 * @generated
	 * @ordered
	 */
	protected EList<ViewableBrick> bricks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedBrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.COMPOSED_BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Codebrick getCodebrick() {
		if (eContainerFeatureID() != CodebricksPackage.COMPOSED_BRICK__CODEBRICK) return null;
		return (Codebrick)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCodebrick(Codebrick newCodebrick, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCodebrick, CodebricksPackage.COMPOSED_BRICK__CODEBRICK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCodebrick(Codebrick newCodebrick) {
		if (newCodebrick != eInternalContainer() || (eContainerFeatureID() != CodebricksPackage.COMPOSED_BRICK__CODEBRICK && newCodebrick != null)) {
			if (EcoreUtil.isAncestor(this, newCodebrick))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCodebrick != null)
				msgs = ((InternalEObject)newCodebrick).eInverseAdd(this, CodebricksPackage.CODEBRICK__BRICKS, Codebrick.class, msgs);
			msgs = basicSetCodebrick(newCodebrick, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.COMPOSED_BRICK__CODEBRICK, newCodebrick, newCodebrick));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ViewableBrick> getBricks() {
		if (bricks == null) {
			bricks = new EObjectContainmentEList<ViewableBrick>(ViewableBrick.class, this, CodebricksPackage.COMPOSED_BRICK__BRICKS);
		}
		return bricks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText() {
		StringBuilder text = new StringBuilder();
		
		for (ViewableBrick brick : getBricks()) {
			text.append(brick.getText());
		}
		
		return text.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodebricksPackage.COMPOSED_BRICK__CODEBRICK:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCodebrick((Codebrick)otherEnd, msgs);
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
			case CodebricksPackage.COMPOSED_BRICK__CODEBRICK:
				return basicSetCodebrick(null, msgs);
			case CodebricksPackage.COMPOSED_BRICK__BRICKS:
				return ((InternalEList<?>)getBricks()).basicRemove(otherEnd, msgs);
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
			case CodebricksPackage.COMPOSED_BRICK__CODEBRICK:
				return eInternalContainer().eInverseRemove(this, CodebricksPackage.CODEBRICK__BRICKS, Codebrick.class, msgs);
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
			case CodebricksPackage.COMPOSED_BRICK__CODEBRICK:
				return getCodebrick();
			case CodebricksPackage.COMPOSED_BRICK__BRICKS:
				return getBricks();
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
			case CodebricksPackage.COMPOSED_BRICK__CODEBRICK:
				setCodebrick((Codebrick)newValue);
				return;
			case CodebricksPackage.COMPOSED_BRICK__BRICKS:
				getBricks().clear();
				getBricks().addAll((Collection<? extends ViewableBrick>)newValue);
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
			case CodebricksPackage.COMPOSED_BRICK__CODEBRICK:
				setCodebrick((Codebrick)null);
				return;
			case CodebricksPackage.COMPOSED_BRICK__BRICKS:
				getBricks().clear();
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
			case CodebricksPackage.COMPOSED_BRICK__CODEBRICK:
				return getCodebrick() != null;
			case CodebricksPackage.COMPOSED_BRICK__BRICKS:
				return bricks != null && !bricks.isEmpty();
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
			case CodebricksPackage.COMPOSED_BRICK___GET_TEXT:
				return getText();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ComposedBrickImpl
