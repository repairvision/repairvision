/**
 */
package org.sidiff.revision.changes.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sidiff.revision.changes.ActionType;
import org.sidiff.revision.changes.Change;
import org.sidiff.revision.changes.ChangeContext;
import org.sidiff.revision.changes.ChangesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ChangeImpl extends MinimalEObjectImpl.Container implements Change {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangesPackage.Literals.CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ActionType getAction() {
		return ((ChangeContext) eContainer()).getAction(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case ChangesPackage.CHANGE___GET_ACTION:
			return getAction();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ChangeImpl
