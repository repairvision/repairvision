/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.ResetTemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reset Template Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.ResetTemplatePlaceholderBrickImpl#getPlaceholder <em>Placeholder</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.ResetTemplatePlaceholderBrickImpl#getAttachedTo <em>Attached To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResetTemplatePlaceholderBrickImpl extends StyledBrickImpl implements ResetTemplatePlaceholderBrick {
	/**
	 * The cached value of the '{@link #getPlaceholder() <em>Placeholder</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlaceholder()
	 * @generated
	 * @ordered
	 */
	protected TemplatePlaceholderBrick placeholder;

	/**
	 * The cached value of the '{@link #getAttachedTo() <em>Attached To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachedTo()
	 * @generated
	 * @ordered
	 */
	protected ViewableBrick attachedTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResetTemplatePlaceholderBrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.RESET_TEMPLATE_PLACEHOLDER_BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplatePlaceholderBrick getPlaceholder() {
		if (placeholder != null && placeholder.eIsProxy()) {
			InternalEObject oldPlaceholder = (InternalEObject)placeholder;
			placeholder = (TemplatePlaceholderBrick)eResolveProxy(oldPlaceholder);
			if (placeholder != oldPlaceholder) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodebricksPackage.RESET_TEMPLATE_PLACEHOLDER_BRICK__PLACEHOLDER, oldPlaceholder, placeholder));
			}
		}
		return placeholder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatePlaceholderBrick basicGetPlaceholder() {
		return placeholder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlaceholder(TemplatePlaceholderBrick newPlaceholder) {
		TemplatePlaceholderBrick oldPlaceholder = placeholder;
		placeholder = newPlaceholder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.RESET_TEMPLATE_PLACEHOLDER_BRICK__PLACEHOLDER, oldPlaceholder, placeholder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ViewableBrick getAttachedTo() {
		if (attachedTo != null && attachedTo.eIsProxy()) {
			InternalEObject oldAttachedTo = (InternalEObject)attachedTo;
			attachedTo = (ViewableBrick)eResolveProxy(oldAttachedTo);
			if (attachedTo != oldAttachedTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodebricksPackage.RESET_TEMPLATE_PLACEHOLDER_BRICK__ATTACHED_TO, oldAttachedTo, attachedTo));
			}
		}
		return attachedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewableBrick basicGetAttachedTo() {
		return attachedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttachedTo(ViewableBrick newAttachedTo) {
		ViewableBrick oldAttachedTo = attachedTo;
		attachedTo = newAttachedTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.RESET_TEMPLATE_PLACEHOLDER_BRICK__ATTACHED_TO, oldAttachedTo, attachedTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText() {
		return getAttachedTo().getText();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodebricksPackage.RESET_TEMPLATE_PLACEHOLDER_BRICK__PLACEHOLDER:
				if (resolve) return getPlaceholder();
				return basicGetPlaceholder();
			case CodebricksPackage.RESET_TEMPLATE_PLACEHOLDER_BRICK__ATTACHED_TO:
				if (resolve) return getAttachedTo();
				return basicGetAttachedTo();
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
			case CodebricksPackage.RESET_TEMPLATE_PLACEHOLDER_BRICK__PLACEHOLDER:
				setPlaceholder((TemplatePlaceholderBrick)newValue);
				return;
			case CodebricksPackage.RESET_TEMPLATE_PLACEHOLDER_BRICK__ATTACHED_TO:
				setAttachedTo((ViewableBrick)newValue);
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
			case CodebricksPackage.RESET_TEMPLATE_PLACEHOLDER_BRICK__PLACEHOLDER:
				setPlaceholder((TemplatePlaceholderBrick)null);
				return;
			case CodebricksPackage.RESET_TEMPLATE_PLACEHOLDER_BRICK__ATTACHED_TO:
				setAttachedTo((ViewableBrick)null);
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
			case CodebricksPackage.RESET_TEMPLATE_PLACEHOLDER_BRICK__PLACEHOLDER:
				return placeholder != null;
			case CodebricksPackage.RESET_TEMPLATE_PLACEHOLDER_BRICK__ATTACHED_TO:
				return attachedTo != null;
		}
		return super.eIsSet(featureID);
	}

} //ResetTemplatePlaceholderBrickImpl
