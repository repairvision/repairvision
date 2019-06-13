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
import org.sidiff.completion.ui.codebricks.ComposedBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl#getCodebrick <em>Codebrick</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl#isHighlight <em>Highlight</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl#getChoices <em>Choices</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl#getChoice <em>Choice</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl#getRemainingChoices <em>Remaining Choices</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl#isComposed <em>Composed</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemplatePlaceholderBrickImpl extends MinimalEObjectImpl.Container implements TemplatePlaceholderBrick {
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
	 * The default value of the '{@link #isComposed() <em>Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPOSED_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplatePlaceholderBrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.TEMPLATE_PLACEHOLDER_BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Codebrick getCodebrick() {
		if (eContainerFeatureID() != CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK) return null;
		return (Codebrick)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCodebrick(Codebrick newCodebrick, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCodebrick, CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCodebrick(Codebrick newCodebrick) {
		if (newCodebrick != eInternalContainer() || (eContainerFeatureID() != CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK && newCodebrick != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK, newCodebrick, newCodebrick));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__HIGHLIGHT, oldHighlight, highlight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ViewableBrick> getChoices() {
		if (choices == null) {
			choices = new EObjectResolvingEList<ViewableBrick>(ViewableBrick.class, this, CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICES);
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
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__MANDATORY, oldMandatory, mandatory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ViewableBrick> getChoice() {
		if (choice == null) {
			choice = new EObjectResolvingEList<ViewableBrick>(ViewableBrick.class, this, CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICE);
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
			if ((templateBrick instanceof TemplatePlaceholderBrick) && (templateBrick != this)) {
				List<ViewableBrick> placeholderChoices = ((TemplatePlaceholderBrick) templateBrick).getChoice();
				
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
	public boolean isComposed() {
		for (Brick choice : getChoices()) {
			if (choice instanceof ComposedBrick) {
				return true;
			}
		}
		return false;
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
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK:
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
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK:
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
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK:
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
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK:
				return getCodebrick();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__HIGHLIGHT:
				return isHighlight();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICES:
				return getChoices();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__MANDATORY:
				return isMandatory();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICE:
				return getChoice();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__REMAINING_CHOICES:
				return getRemainingChoices();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__COMPOSED:
				return isComposed();
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
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK:
				setCodebrick((Codebrick)newValue);
				return;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__HIGHLIGHT:
				setHighlight((Boolean)newValue);
				return;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICES:
				getChoices().clear();
				getChoices().addAll((Collection<? extends ViewableBrick>)newValue);
				return;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__MANDATORY:
				setMandatory((Boolean)newValue);
				return;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICE:
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
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK:
				setCodebrick((Codebrick)null);
				return;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__HIGHLIGHT:
				setHighlight(HIGHLIGHT_EDEFAULT);
				return;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICES:
				getChoices().clear();
				return;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__MANDATORY:
				setMandatory(MANDATORY_EDEFAULT);
				return;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICE:
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
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CODEBRICK:
				return getCodebrick() != null;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__HIGHLIGHT:
				return highlight != HIGHLIGHT_EDEFAULT;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICES:
				return choices != null && !choices.isEmpty();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__MANDATORY:
				return mandatory != MANDATORY_EDEFAULT;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICE:
				return choice != null && !choice.isEmpty();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__REMAINING_CHOICES:
				return !getRemainingChoices().isEmpty();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__COMPOSED:
				return isComposed() != COMPOSED_EDEFAULT;
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
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK___GET_TEXT:
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
		result.append(" (highlight: ");
		result.append(highlight);
		result.append(", mandatory: ");
		result.append(mandatory);
		result.append(')');
		return result.toString();
	}

} //TemplatePlaceholderBrickImpl
