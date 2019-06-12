/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.IndentBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indent Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.IndentBrickImpl#getCodebrick <em>Codebrick</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.IndentBrickImpl#getBricks <em>Bricks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndentBrickImpl extends MinimalEObjectImpl.Container implements IndentBrick {
	/**
	 * The default value of the '{@link #getBricks() <em>Bricks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBricks()
	 * @generated
	 * @ordered
	 */
	protected static final int BRICKS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getBricks() <em>Bricks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBricks()
	 * @generated
	 * @ordered
	 */
	protected int bricks = BRICKS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndentBrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.INDENT_BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Codebrick getCodebrick() {
		if (eContainerFeatureID() != CodebricksPackage.INDENT_BRICK__CODEBRICK) return null;
		return (Codebrick)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCodebrick(Codebrick newCodebrick, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCodebrick, CodebricksPackage.INDENT_BRICK__CODEBRICK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCodebrick(Codebrick newCodebrick) {
		if (newCodebrick != eInternalContainer() || (eContainerFeatureID() != CodebricksPackage.INDENT_BRICK__CODEBRICK && newCodebrick != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.INDENT_BRICK__CODEBRICK, newCodebrick, newCodebrick));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getBricks() {
		return bricks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBricks(int newBricks) {
		int oldBricks = bricks;
		bricks = newBricks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.INDENT_BRICK__BRICKS, oldBricks, bricks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodebricksPackage.INDENT_BRICK__CODEBRICK:
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
			case CodebricksPackage.INDENT_BRICK__CODEBRICK:
				return basicSetCodebrick(null, msgs);
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
			case CodebricksPackage.INDENT_BRICK__CODEBRICK:
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
			case CodebricksPackage.INDENT_BRICK__CODEBRICK:
				return getCodebrick();
			case CodebricksPackage.INDENT_BRICK__BRICKS:
				return getBricks();
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
			case CodebricksPackage.INDENT_BRICK__CODEBRICK:
				setCodebrick((Codebrick)newValue);
				return;
			case CodebricksPackage.INDENT_BRICK__BRICKS:
				setBricks((Integer)newValue);
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
			case CodebricksPackage.INDENT_BRICK__CODEBRICK:
				setCodebrick((Codebrick)null);
				return;
			case CodebricksPackage.INDENT_BRICK__BRICKS:
				setBricks(BRICKS_EDEFAULT);
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
			case CodebricksPackage.INDENT_BRICK__CODEBRICK:
				return getCodebrick() != null;
			case CodebricksPackage.INDENT_BRICK__BRICKS:
				return bricks != BRICKS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (bricks: ");
		result.append(bricks);
		result.append(')');
		return result.toString();
	}

} //IndentBrickImpl
