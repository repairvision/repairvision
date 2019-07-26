/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.CollapsibleComposedBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collapsible Composed Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.CollapsibleComposedBrickImpl#getCollapsible <em>Collapsible</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollapsibleComposedBrickImpl extends ComposedBrickImpl implements CollapsibleComposedBrick {
	/**
	 * The cached value of the '{@link #getCollapsible() <em>Collapsible</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollapsible()
	 * @generated
	 * @ordered
	 */
	protected EList<ViewableBrick> collapsible;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollapsibleComposedBrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.COLLAPSIBLE_COMPOSED_BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ViewableBrick> getCollapsible() {
		if (collapsible == null) {
			collapsible = new EObjectResolvingEList<ViewableBrick>(ViewableBrick.class, this, CodebricksPackage.COLLAPSIBLE_COMPOSED_BRICK__COLLAPSIBLE);
		}
		return collapsible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getCollapsedText() {
		StringBuilder text = new StringBuilder();
		
		for (ViewableBrick composed : getBricks()) {
			if (!getCollapsible().contains(composed)) {
				text.append(composed.getText());
			}
		}
		
		return text.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodebricksPackage.COLLAPSIBLE_COMPOSED_BRICK__COLLAPSIBLE:
				return getCollapsible();
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
			case CodebricksPackage.COLLAPSIBLE_COMPOSED_BRICK__COLLAPSIBLE:
				getCollapsible().clear();
				getCollapsible().addAll((Collection<? extends ViewableBrick>)newValue);
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
			case CodebricksPackage.COLLAPSIBLE_COMPOSED_BRICK__COLLAPSIBLE:
				getCollapsible().clear();
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
			case CodebricksPackage.COLLAPSIBLE_COMPOSED_BRICK__COLLAPSIBLE:
				return collapsible != null && !collapsible.isEmpty();
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
			case CodebricksPackage.COLLAPSIBLE_COMPOSED_BRICK___GET_COLLAPSED_TEXT:
				return getCollapsedText();
		}
		return super.eInvoke(operationID, arguments);
	}

} //CollapsibleComposedBrickImpl
