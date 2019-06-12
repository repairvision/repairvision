/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.completion.ui.codebricks.Brick;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.PlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl#getCodebrick <em>Codebrick</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl#isEditable <em>Editable</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl#isHighlight <em>Highlight</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl#getChoices <em>Choices</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl#getChoice <em>Choice</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl#getRemainingChoices <em>Remaining Choices</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlaceholderBrickImpl extends MinimalEObjectImpl.Container implements PlaceholderBrick {
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
	 * The cached value of the '{@link #getChoices() <em>Choices</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoices()
	 * @generated
	 * @ordered
	 */
	protected EList<ViewableBrick> choices;

	/**
	 * The default value of the '{@link #isMandatory() <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMandatory()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANDATORY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMandatory() <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMandatory()
	 * @generated
	 * @ordered
	 */
	protected boolean mandatory = MANDATORY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChoice() <em>Choice</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoice()
	 * @generated
	 * @ordered
	 */
	protected EList<ViewableBrick> choice;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaceholderBrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.PLACEHOLDER_BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Codebrick getCodebrick() {
		if (eContainerFeatureID() != CodebricksPackage.PLACEHOLDER_BRICK__CODEBRICK) return null;
		return (Codebrick)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCodebrick(Codebrick newCodebrick, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCodebrick, CodebricksPackage.PLACEHOLDER_BRICK__CODEBRICK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCodebrick(Codebrick newCodebrick) {
		if (newCodebrick != eInternalContainer() || (eContainerFeatureID() != CodebricksPackage.PLACEHOLDER_BRICK__CODEBRICK && newCodebrick != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.PLACEHOLDER_BRICK__CODEBRICK, newCodebrick, newCodebrick));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.PLACEHOLDER_BRICK__EDITABLE, oldEditable, editable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.PLACEHOLDER_BRICK__HIGHLIGHT, oldHighlight, highlight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ViewableBrick> getChoices() {
		if (choices == null) {
			choices = new EObjectResolvingEList<ViewableBrick>(ViewableBrick.class, this, CodebricksPackage.PLACEHOLDER_BRICK__CHOICES);
		}
		return choices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMandatory() {
		return mandatory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMandatory(boolean newMandatory) {
		boolean oldMandatory = mandatory;
		mandatory = newMandatory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.PLACEHOLDER_BRICK__MANDATORY, oldMandatory, mandatory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ViewableBrick> getChoice() {
		if (choice == null) {
			choice = new EObjectResolvingEList<ViewableBrick>(ViewableBrick.class, this, CodebricksPackage.PLACEHOLDER_BRICK__CHOICE);
		}
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<ViewableBrick> getRemainingChoices() {
		EList<ViewableBrick> remaining = new BasicEList<>();
		
		// Calculate current placeholder selections:
		Set<Codebrick> selection = new HashSet<>(); 
		
		for (Brick templateBrick : getCodebrick().getCodebricks().getTemplate().getBricks()) {
			if ((templateBrick instanceof PlaceholderBrick) && (templateBrick != this)) {
				List<ViewableBrick> placeholderChoices = ((PlaceholderBrick) templateBrick).getChoice();
				
				// Anything selected?
				if (!placeholderChoices.isEmpty()) {
					for (Brick placeholderChoice : placeholderChoices) {
						selection.add(placeholderChoice.getCodebrick());
					}
				}
			}
		}

		if (selection.isEmpty()) {
			// No restrictions:
			remaining.addAll(getChoices());
		} else {
			// Filter brick choices by current selection of other placeholders:
			for (ViewableBrick choice : getChoices()) {
				if (selection.contains(choice.getCodebrick())) {
					remaining.add(choice);
				}
			}
		}
		
		return remaining;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText() {
		if (isMandatory()) {
			return "[+]";
		} else {
			return "[?]";
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodebricksPackage.PLACEHOLDER_BRICK__CODEBRICK:
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
			case CodebricksPackage.PLACEHOLDER_BRICK__CODEBRICK:
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
			case CodebricksPackage.PLACEHOLDER_BRICK__CODEBRICK:
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
			case CodebricksPackage.PLACEHOLDER_BRICK__CODEBRICK:
				return getCodebrick();
			case CodebricksPackage.PLACEHOLDER_BRICK__EDITABLE:
				return isEditable();
			case CodebricksPackage.PLACEHOLDER_BRICK__HIGHLIGHT:
				return isHighlight();
			case CodebricksPackage.PLACEHOLDER_BRICK__CHOICES:
				return getChoices();
			case CodebricksPackage.PLACEHOLDER_BRICK__MANDATORY:
				return isMandatory();
			case CodebricksPackage.PLACEHOLDER_BRICK__CHOICE:
				return getChoice();
			case CodebricksPackage.PLACEHOLDER_BRICK__REMAINING_CHOICES:
				return getRemainingChoices();
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
			case CodebricksPackage.PLACEHOLDER_BRICK__CODEBRICK:
				setCodebrick((Codebrick)newValue);
				return;
			case CodebricksPackage.PLACEHOLDER_BRICK__EDITABLE:
				setEditable((Boolean)newValue);
				return;
			case CodebricksPackage.PLACEHOLDER_BRICK__HIGHLIGHT:
				setHighlight((Boolean)newValue);
				return;
			case CodebricksPackage.PLACEHOLDER_BRICK__CHOICES:
				getChoices().clear();
				getChoices().addAll((Collection<? extends ViewableBrick>)newValue);
				return;
			case CodebricksPackage.PLACEHOLDER_BRICK__MANDATORY:
				setMandatory((Boolean)newValue);
				return;
			case CodebricksPackage.PLACEHOLDER_BRICK__CHOICE:
				getChoice().clear();
				getChoice().addAll((Collection<? extends ViewableBrick>)newValue);
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
			case CodebricksPackage.PLACEHOLDER_BRICK__CODEBRICK:
				setCodebrick((Codebrick)null);
				return;
			case CodebricksPackage.PLACEHOLDER_BRICK__EDITABLE:
				setEditable(EDITABLE_EDEFAULT);
				return;
			case CodebricksPackage.PLACEHOLDER_BRICK__HIGHLIGHT:
				setHighlight(HIGHLIGHT_EDEFAULT);
				return;
			case CodebricksPackage.PLACEHOLDER_BRICK__CHOICES:
				getChoices().clear();
				return;
			case CodebricksPackage.PLACEHOLDER_BRICK__MANDATORY:
				setMandatory(MANDATORY_EDEFAULT);
				return;
			case CodebricksPackage.PLACEHOLDER_BRICK__CHOICE:
				getChoice().clear();
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
			case CodebricksPackage.PLACEHOLDER_BRICK__CODEBRICK:
				return getCodebrick() != null;
			case CodebricksPackage.PLACEHOLDER_BRICK__EDITABLE:
				return editable != EDITABLE_EDEFAULT;
			case CodebricksPackage.PLACEHOLDER_BRICK__HIGHLIGHT:
				return highlight != HIGHLIGHT_EDEFAULT;
			case CodebricksPackage.PLACEHOLDER_BRICK__CHOICES:
				return choices != null && !choices.isEmpty();
			case CodebricksPackage.PLACEHOLDER_BRICK__MANDATORY:
				return mandatory != MANDATORY_EDEFAULT;
			case CodebricksPackage.PLACEHOLDER_BRICK__CHOICE:
				return choice != null && !choice.isEmpty();
			case CodebricksPackage.PLACEHOLDER_BRICK__REMAINING_CHOICES:
				return !getRemainingChoices().isEmpty();
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
			case CodebricksPackage.PLACEHOLDER_BRICK___GET_TEXT:
				return getText();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(", mandatory: ");
		result.append(mandatory);
		result.append(')');
		return result.toString();
	}

} //PlaceholderBrickImpl
