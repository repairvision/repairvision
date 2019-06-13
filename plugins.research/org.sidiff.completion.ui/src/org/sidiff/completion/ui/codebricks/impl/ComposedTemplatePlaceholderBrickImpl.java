/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.ComposedBrick;
import org.sidiff.completion.ui.codebricks.ComposedTemplatePlaceholderBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composed Template Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.ComposedTemplatePlaceholderBrickImpl#getContainerBrick <em>Container Brick</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComposedTemplatePlaceholderBrickImpl extends TemplatePlaceholderBrickImpl implements ComposedTemplatePlaceholderBrick {
	/**
	 * The cached value of the '{@link #getContainerBrick() <em>Container Brick</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerBrick()
	 * @generated
	 * @ordered
	 */
	protected ComposedBrick containerBrick;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedTemplatePlaceholderBrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.COMPOSED_TEMPLATE_PLACEHOLDER_BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposedBrick getContainerBrick() {
		if (containerBrick != null && containerBrick.eIsProxy()) {
			InternalEObject oldContainerBrick = (InternalEObject)containerBrick;
			containerBrick = (ComposedBrick)eResolveProxy(oldContainerBrick);
			if (containerBrick != oldContainerBrick) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodebricksPackage.COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__CONTAINER_BRICK, oldContainerBrick, containerBrick));
			}
		}
		return containerBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedBrick basicGetContainerBrick() {
		return containerBrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContainerBrick(ComposedBrick newContainerBrick) {
		ComposedBrick oldContainerBrick = containerBrick;
		containerBrick = newContainerBrick;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__CONTAINER_BRICK, oldContainerBrick, containerBrick));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodebricksPackage.COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__CONTAINER_BRICK:
				if (resolve) return getContainerBrick();
				return basicGetContainerBrick();
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
			case CodebricksPackage.COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__CONTAINER_BRICK:
				setContainerBrick((ComposedBrick)newValue);
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
			case CodebricksPackage.COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__CONTAINER_BRICK:
				setContainerBrick((ComposedBrick)null);
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
			case CodebricksPackage.COMPOSED_TEMPLATE_PLACEHOLDER_BRICK__CONTAINER_BRICK:
				return containerBrick != null;
		}
		return super.eIsSet(featureID);
	}

} //ComposedTemplatePlaceholderBrickImpl
