/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sidiff.completion.ui.codebricks.Brick;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.BrickImpl#getCodebrick <em>Codebrick</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BrickImpl extends MinimalEObjectImpl.Container implements Brick {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Codebrick getCodebrick() {
		Codebrick codebrick = basicGetCodebrick();
		return codebrick != null && codebrick.eIsProxy() ? (Codebrick)eResolveProxy((InternalEObject)codebrick) : codebrick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Codebrick basicGetCodebrick() {
		EObject container = eContainer();
		
		while ((container != null) && !(container instanceof Codebrick)) {
			container = container.eContainer();
		}
		return (Codebrick) container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodebricksPackage.BRICK__CODEBRICK:
				if (resolve) return getCodebrick();
				return basicGetCodebrick();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CodebricksPackage.BRICK__CODEBRICK:
				return basicGetCodebrick() != null;
		}
		return super.eIsSet(featureID);
	}

} //BrickImpl
