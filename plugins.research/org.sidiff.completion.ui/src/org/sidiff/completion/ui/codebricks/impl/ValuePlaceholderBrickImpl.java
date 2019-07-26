/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.ValueDomainPolicy;
import org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Placeholder Brick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.ValuePlaceholderBrickImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.ValuePlaceholderBrickImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.ValuePlaceholderBrickImpl#getInstanceValue <em>Instance Value</em>}</li>
 *   <li>{@link org.sidiff.completion.ui.codebricks.impl.ValuePlaceholderBrickImpl#getLiteralValue <em>Literal Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValuePlaceholderBrickImpl extends PlaceholderBrickImpl implements ValuePlaceholderBrick {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EDataType type;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected ValueDomainPolicy domain;
	/**
	 * The default value of the '{@link #getInstanceValue() <em>Instance Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object INSTANCE_VALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getInstanceValue() <em>Instance Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceValue()
	 * @generated
	 * @ordered
	 */
	protected Object instanceValue = INSTANCE_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLiteralValue() <em>Literal Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralValue()
	 * @generated
	 * @ordered
	 */
	protected static final String LITERAL_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLiteralValue() <em>Literal Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralValue()
	 * @generated
	 * @ordered
	 */
	protected String literalValue = LITERAL_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValuePlaceholderBrickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.VALUE_PLACEHOLDER_BRICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EDataType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodebricksPackage.VALUE_PLACEHOLDER_BRICK__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(EDataType newType) {
		EDataType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.VALUE_PLACEHOLDER_BRICK__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueDomainPolicy getDomain() {
		if (domain != null && domain.eIsProxy()) {
			InternalEObject oldDomain = (InternalEObject)domain;
			domain = (ValueDomainPolicy)eResolveProxy(oldDomain);
			if (domain != oldDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodebricksPackage.VALUE_PLACEHOLDER_BRICK__DOMAIN, oldDomain, domain));
			}
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueDomainPolicy basicGetDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomain(ValueDomainPolicy newDomain) {
		ValueDomainPolicy oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.VALUE_PLACEHOLDER_BRICK__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getInstanceValue() {
		return instanceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstanceValue(Object newInstanceValue) {
		Object oldInstanceValue = instanceValue;
		instanceValue = newInstanceValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.VALUE_PLACEHOLDER_BRICK__INSTANCE_VALUE, oldInstanceValue, instanceValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteralValue() {
		return literalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiteralValue(String newLiteralValue) {
		String oldLiteralValue = literalValue;
		literalValue = newLiteralValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodebricksPackage.VALUE_PLACEHOLDER_BRICK__LITERAL_VALUE, oldLiteralValue, literalValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setByLiteralValue(String literalValue) {
		if (((literalValue == null) && (getLiteralValue() != null)) || !literalValue.equals(getLiteralValue())) {
			boolean isValid = getDomain().isValid(this, literalValue, getType());
			Object instanceValue = null;
			
			if (isValid) {
				instanceValue = getDomain().createFromString(this, literalValue, getType());
			}
			
			// 1. update domain for auto-selection:
			if (isValid) {
				getDomain().assignValue(instanceValue, this);
			}
			
			// 2. update literal for change test:
			setLiteralValue(literalValue);
			
			// 3. store instance:
			if (isValid) {
				setInstanceValue(instanceValue);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setByInstanceValue(Object instanceValue) {
		if (((instanceValue == null) && (getInstanceValue() != null)) || !instanceValue.equals(getInstanceValue())) {
			if (getDomain().isValid(this, literalValue, getType())) {
				
				// 1. update domain for auto-selection:
				getDomain().assignValue(instanceValue, this);
				
				// 2. update literal for change test:
				String literalValue = getDomain().convertToString(this, instanceValue, getType());
				setLiteralValue(literalValue);
				
				// 3. store instance:
				setInstanceValue(instanceValue);
				
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__INSTANCE_VALUE:
				return getInstanceValue();
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__LITERAL_VALUE:
				return getLiteralValue();
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
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__TYPE:
				setType((EDataType)newValue);
				return;
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__DOMAIN:
				setDomain((ValueDomainPolicy)newValue);
				return;
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__INSTANCE_VALUE:
				setInstanceValue(newValue);
				return;
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__LITERAL_VALUE:
				setLiteralValue((String)newValue);
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
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__TYPE:
				setType((EDataType)null);
				return;
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__DOMAIN:
				setDomain((ValueDomainPolicy)null);
				return;
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__INSTANCE_VALUE:
				setInstanceValue(INSTANCE_VALUE_EDEFAULT);
				return;
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__LITERAL_VALUE:
				setLiteralValue(LITERAL_VALUE_EDEFAULT);
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
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__TYPE:
				return type != null;
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__DOMAIN:
				return domain != null;
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__INSTANCE_VALUE:
				return INSTANCE_VALUE_EDEFAULT == null ? instanceValue != null : !INSTANCE_VALUE_EDEFAULT.equals(instanceValue);
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK__LITERAL_VALUE:
				return LITERAL_VALUE_EDEFAULT == null ? literalValue != null : !LITERAL_VALUE_EDEFAULT.equals(literalValue);
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
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK___SET_BY_LITERAL_VALUE__STRING:
				setByLiteralValue((String)arguments.get(0));
				return null;
			case CodebricksPackage.VALUE_PLACEHOLDER_BRICK___SET_BY_INSTANCE_VALUE__OBJECT:
				setByInstanceValue(arguments.get(0));
				return null;
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
		result.append(" (instanceValue: ");
		result.append(instanceValue);
		result.append(", literalValue: ");
		result.append(literalValue);
		result.append(')');
		return result.toString();
	}

} //ValuePlaceholderBrickImpl
