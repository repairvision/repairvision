/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.ValueDomainPolicy;
import org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Domain Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ValueDomainPolicyImpl extends MinimalEObjectImpl.Container implements ValueDomainPolicy {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueDomainPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.VALUE_DOMAIN_POLICY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean isValid(ValuePlaceholderBrick brick, String literalValue, EDataType eDataType) {
		if (eDataType == null) {
			return false;
		}
		
		if ((literalValue != null) && (literalValue != NULL)) {
			try {
				eDataType.getEPackage().getEFactoryInstance().createFromString(eDataType, literalValue);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Object> getDomain(ValuePlaceholderBrick brick) {
		return ECollections.emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object createFromString(ValuePlaceholderBrick brick, String literalValue, EDataType eDataType) {
		if ((literalValue != null) && (literalValue != NULL)) {
			try {
				return eDataType.getEPackage().getEFactoryInstance().createFromString(eDataType, literalValue);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String convertToString(ValuePlaceholderBrick brick, Object instanceValue, EDataType eDataType) {
		if ((instanceValue != null) && (eDataType != null)) {
			try {
				return eDataType.getEPackage().getEFactoryInstance().convertToString(eDataType, instanceValue);
			} catch (Exception e) {
				e.printStackTrace();
				return instanceValue.toString();
			}
		} else {
			return NULL;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void assignValue(Object instanceValue, ValuePlaceholderBrick brick) {
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CodebricksPackage.VALUE_DOMAIN_POLICY___IS_VALID__VALUEPLACEHOLDERBRICK_STRING_EDATATYPE:
				return isValid((ValuePlaceholderBrick)arguments.get(0), (String)arguments.get(1), (EDataType)arguments.get(2));
			case CodebricksPackage.VALUE_DOMAIN_POLICY___GET_DOMAIN__VALUEPLACEHOLDERBRICK:
				return getDomain((ValuePlaceholderBrick)arguments.get(0));
			case CodebricksPackage.VALUE_DOMAIN_POLICY___ASSIGN_VALUE__OBJECT_VALUEPLACEHOLDERBRICK:
				assignValue(arguments.get(0), (ValuePlaceholderBrick)arguments.get(1));
				return null;
			case CodebricksPackage.VALUE_DOMAIN_POLICY___CREATE_FROM_STRING__VALUEPLACEHOLDERBRICK_STRING_EDATATYPE:
				return createFromString((ValuePlaceholderBrick)arguments.get(0), (String)arguments.get(1), (EDataType)arguments.get(2));
			case CodebricksPackage.VALUE_DOMAIN_POLICY___CONVERT_TO_STRING__VALUEPLACEHOLDERBRICK_OBJECT_EDATATYPE:
				return convertToString((ValuePlaceholderBrick)arguments.get(0), arguments.get(1), (EDataType)arguments.get(2));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ValueDomainPolicyImpl
