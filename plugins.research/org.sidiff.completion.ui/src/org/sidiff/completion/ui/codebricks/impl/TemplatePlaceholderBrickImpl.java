/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
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
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl#getChoices <em>Choices</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl#getChoice <em>Choice</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl#getRemainingChoices <em>Remaining Choices</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl#isComposed <em>Composed</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.TemplatePlaceholderBrickImpl#getAlternativeChoices <em>Alternative Choices</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemplatePlaceholderBrickImpl extends PlaceholderBrickImpl implements TemplatePlaceholderBrick {
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
	public EList<ViewableBrick> getChoice() {
		if (choice == null) {
			choice = new EObjectResolvingEList<ViewableBrick>(ViewableBrick.class, this, CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICE);
		}
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * Calculates all remaining choices based on the current selection of all
	 * placeholders in template.
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<ViewableBrick> getRemainingChoices() {
		EList<ViewableBrick> remaining = new BasicEList<>();
		
		// Calculate current placeholder selections:
		Set<Codebrick> selection = new HashSet<>(); 
		
		for (Brick templateBrick : getCodebrick().getCodebricks().getTemplate().getAllBricks()) {
			if (templateBrick instanceof TemplatePlaceholderBrick) {
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
			List<ViewableBrick> superSet = getChoice().isEmpty() ? getChoices() : getChoice();
			
			for (ViewableBrick choice : superSet) {
				if (selection.contains(choice.getCodebrick())) {
					remaining.add(choice);
				}
			}
		}
		
		return remaining;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * In comparison with the {@link #getRemainingChoices()} this calculation
	 * ignores the its own choice.
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<ViewableBrick> getAlternativeChoices() {
		EList<ViewableBrick> remaining = new BasicEList<>();
		
		// Calculate current placeholder selections:
		Set<Codebrick> selection = new HashSet<>(); 

		for (Brick templateBrick : getCodebrick().getCodebricks().getTemplate().getAllBricks()) {
			if (templateBrick instanceof TemplatePlaceholderBrick) {
				List<ViewableBrick> placeholderChoices = ((TemplatePlaceholderBrick) templateBrick).getChoice();

				// Anything selected?
				if (!placeholderChoices.isEmpty()) {
					for (Brick placeholderChoice : placeholderChoices) {
						selection.add(placeholderChoice.getCodebrick());
					}
				}
			}
		}
		
		// Ignore own choices:
		selection.removeAll(getChoice().stream().map(ViewableBrick::getCodebrick).collect(Collectors.toList()));

		if (selection.isEmpty()) {
			// No restrictions:
			remaining.addAll(getChoices());
		} else {
			// Filter brick choices by current selection of other placeholders:
			List<ViewableBrick> superSet = getChoice().isEmpty() ? getChoices() : getChoice();
			
			for (ViewableBrick choice : superSet) {
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
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICES:
				return getChoices();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICE:
				return getChoice();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__REMAINING_CHOICES:
				return getRemainingChoices();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__COMPOSED:
				return isComposed();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__ALTERNATIVE_CHOICES:
				return getAlternativeChoices();
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
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICES:
				getChoices().clear();
				getChoices().addAll((Collection<? extends ViewableBrick>)newValue);
				return;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICE:
				getChoice().clear();
				getChoice().addAll((Collection<? extends ViewableBrick>)newValue);
				return;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__ALTERNATIVE_CHOICES:
				getAlternativeChoices().clear();
				getAlternativeChoices().addAll((Collection<? extends ViewableBrick>)newValue);
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
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICES:
				getChoices().clear();
				return;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICE:
				getChoice().clear();
				return;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__ALTERNATIVE_CHOICES:
				getAlternativeChoices().clear();
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
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICES:
				return choices != null && !choices.isEmpty();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__CHOICE:
				return choice != null && !choice.isEmpty();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__REMAINING_CHOICES:
				return !getRemainingChoices().isEmpty();
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__COMPOSED:
				return isComposed() != COMPOSED_EDEFAULT;
			case CodebricksPackage.TEMPLATE_PLACEHOLDER_BRICK__ALTERNATIVE_CHOICES:
				return !getAlternativeChoices().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TemplatePlaceholderBrickImpl
