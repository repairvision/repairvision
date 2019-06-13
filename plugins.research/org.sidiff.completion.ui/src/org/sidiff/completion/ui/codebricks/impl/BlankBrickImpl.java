/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.sidiff.completion.ui.codebricks.BlankBrick;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Blank Brick</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class BlankBrickImpl extends BrickImpl implements BlankBrick {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlankBrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.BLANK_BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText() {
		return " ";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CodebricksPackage.BLANK_BRICK___GET_TEXT:
				return getText();
		}
		return super.eInvoke(operationID, arguments);
	}

} //BlankBrickImpl
