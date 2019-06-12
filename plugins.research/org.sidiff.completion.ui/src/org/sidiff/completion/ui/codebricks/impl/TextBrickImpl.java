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
import org.sidiff.completion.ui.codebricks.TextBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TextBrickImpl#getCodebrick <em>Codebrick</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TextBrickImpl#isEditable <em>Editable</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TextBrickImpl#isHighlight <em>Highlight</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TextBrickImpl#getText <em>Text</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TextBrickImpl extends MinimalEObjectImpl.Container implements TextBrick {
	/**
	 * The default value of the '{@link #isEditable() <em>Editable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEditable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EDITABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEditable() <em>Editable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEditable()
	 * @generated
	 * @ordered
	 */
	protected boolean editable = EDITABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isHighlight() <em>Highlight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHighlight()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIGHLIGHT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHighlight() <em>Highlight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHighlight()
	 * @generated
	 * @ordered
	 */
	protected boolean highlight = HIGHLIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextBrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.TEXT_BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Codebrick getCodebrick() {
		if (eContainerFeatureID() != CodebricksPackage.TEXT_BRICK__CODEBRICK) return null;
		return (Codebrick)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCodebrick(Codebrick newCodebrick, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCodebrick, CodebricksPackage.TEXT_BRICK__CODEBRICK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCodebrick(Codebrick newCodebrick) {
		if (newCodebrick != eInternalContainer() || (eContainerFeatureID() != CodebricksPackage.TEXT_BRICK__CODEBRICK && newCodebrick != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.TEXT_BRICK__CODEBRICK, newCodebrick, newCodebrick));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEditable() {
		return editable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEditable(boolean newEditable) {
		boolean oldEditable = editable;
		editable = newEditable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.TEXT_BRICK__EDITABLE, oldEditable, editable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHighlight() {
		return highlight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHighlight(boolean newHighlight) {
		boolean oldHighlight = highlight;
		highlight = newHighlight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.TEXT_BRICK__HIGHLIGHT, oldHighlight, highlight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.TEXT_BRICK__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodebricksPackage.TEXT_BRICK__CODEBRICK:
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
			case CodebricksPackage.TEXT_BRICK__CODEBRICK:
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
			case CodebricksPackage.TEXT_BRICK__CODEBRICK:
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
			case CodebricksPackage.TEXT_BRICK__CODEBRICK:
				return getCodebrick();
			case CodebricksPackage.TEXT_BRICK__EDITABLE:
				return isEditable();
			case CodebricksPackage.TEXT_BRICK__HIGHLIGHT:
				return isHighlight();
			case CodebricksPackage.TEXT_BRICK__TEXT:
				return getText();
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
			case CodebricksPackage.TEXT_BRICK__CODEBRICK:
				setCodebrick((Codebrick)newValue);
				return;
			case CodebricksPackage.TEXT_BRICK__EDITABLE:
				setEditable((Boolean)newValue);
				return;
			case CodebricksPackage.TEXT_BRICK__HIGHLIGHT:
				setHighlight((Boolean)newValue);
				return;
			case CodebricksPackage.TEXT_BRICK__TEXT:
				setText((String)newValue);
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
			case CodebricksPackage.TEXT_BRICK__CODEBRICK:
				setCodebrick((Codebrick)null);
				return;
			case CodebricksPackage.TEXT_BRICK__EDITABLE:
				setEditable(EDITABLE_EDEFAULT);
				return;
			case CodebricksPackage.TEXT_BRICK__HIGHLIGHT:
				setHighlight(HIGHLIGHT_EDEFAULT);
				return;
			case CodebricksPackage.TEXT_BRICK__TEXT:
				setText(TEXT_EDEFAULT);
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
			case CodebricksPackage.TEXT_BRICK__CODEBRICK:
				return getCodebrick() != null;
			case CodebricksPackage.TEXT_BRICK__EDITABLE:
				return editable != EDITABLE_EDEFAULT;
			case CodebricksPackage.TEXT_BRICK__HIGHLIGHT:
				return highlight != HIGHLIGHT_EDEFAULT;
			case CodebricksPackage.TEXT_BRICK__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
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
		result.append(" (editable: ");
		result.append(editable);
		result.append(", highlight: ");
		result.append(highlight);
		result.append(", text: ");
		result.append(text);
		result.append(')');
		return result.toString();
	}

} //TextBrickImpl
