/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.ObjectDomainPlaceholderBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Domain Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.ObjectDomainPlaceholderBrickImpl#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectDomainPlaceholderBrickImpl extends ObjectPlaceholderBrickImpl implements ObjectDomainPlaceholderBrick {
	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> domain;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectDomainPlaceholderBrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.OBJECT_DOMAIN_PLACEHOLDER_BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EObject> getDomain() {
		if (domain == null) {
			domain = new EObjectResolvingEList<EObject>(EObject.class, this, CodebricksPackage.OBJECT_DOMAIN_PLACEHOLDER_BRICK__DOMAIN);
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodebricksPackage.OBJECT_DOMAIN_PLACEHOLDER_BRICK__DOMAIN:
				return getDomain();
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
			case CodebricksPackage.OBJECT_DOMAIN_PLACEHOLDER_BRICK__DOMAIN:
				getDomain().clear();
				getDomain().addAll((Collection<? extends EObject>)newValue);
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
			case CodebricksPackage.OBJECT_DOMAIN_PLACEHOLDER_BRICK__DOMAIN:
				getDomain().clear();
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
			case CodebricksPackage.OBJECT_DOMAIN_PLACEHOLDER_BRICK__DOMAIN:
				return domain != null && !domain.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ObjectDomainPlaceholderBrickImpl
