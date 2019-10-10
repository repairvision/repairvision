/**
 */
package org.sidiff.graphpattern.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.attributes.JavaSciptParser;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.impl.AttributePatternImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.AttributePatternImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.AttributePatternImpl#getNode <em>Node</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.AttributePatternImpl#getConstant <em>Constant</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.impl.AttributePatternImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributePatternImpl extends GraphElementImpl implements AttributePattern {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EAttribute type;

	/**
	 * The default value of the '{@link #getConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstant()
	 * @generated
	 * @ordered
	 */
	protected static final Object CONSTANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstant()
	 * @generated
	 * @ordered
	 */
	protected Object constant = CONSTANT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<String> variables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributePatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.ATTRIBUTE_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.ATTRIBUTE_PATTERN__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EAttribute)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphpatternPackage.ATTRIBUTE_PATTERN__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(EAttribute newType) {
		EAttribute oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.ATTRIBUTE_PATTERN__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodePattern getNode() {
		if (eContainerFeatureID() != GraphpatternPackage.ATTRIBUTE_PATTERN__NODE) return null;
		return (NodePattern)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode(NodePattern newNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNode, GraphpatternPackage.ATTRIBUTE_PATTERN__NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNode(NodePattern newNode) {
		if (newNode != eInternalContainer() || (eContainerFeatureID() != GraphpatternPackage.ATTRIBUTE_PATTERN__NODE && newNode != null)) {
			if (EcoreUtil.isAncestor(this, newNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNode != null)
				msgs = ((InternalEObject)newNode).eInverseAdd(this, GraphpatternPackage.NODE_PATTERN__ATTRIBUTES, NodePattern.class, msgs);
			msgs = basicSetNode(newNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphpatternPackage.ATTRIBUTE_PATTERN__NODE, newNode, newNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return The constant as primitive data type or <code>null</code>.
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getConstant() {
		
		if (constant == null) { 
			if (isConstant() && (getType().getEAttributeType() != null)) {
				constant = JavaSciptParser.getConstant(getType().getEAttributeType(), getValue());
			}
		}
		
		return constant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return The variables contained in the expression of the attribute value; an empty list otherwise.
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<String> getVariables() {
		if (variables == null) {
			variables = new EDataTypeUniqueEList<String>(String.class, this, GraphpatternPackage.ATTRIBUTE_PATTERN__VARIABLES);
			
			if (getType().getEAttributeType() != null) {
				variables.addAll(JavaSciptParser.getVariables(getType().getEAttributeType(), getValue()));
			}
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param expression An expression.
	 * @return <code>true</code> if the expression is a single variable;
	 *         <code>false</code> otherwise.
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean isVariable() {
		return JavaSciptParser.isVariable(getValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param type       The type of the expression result.
	 * @param expression An expression.
	 * @return <code>true</code> if the expression contains a single constant
	 *         (quoted) value; <code>false</code> otherwise.
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean isConstant() {
		return JavaSciptParser.isConstant(getValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param expression An expression.
	 * @return <code>true</code> if the expression is a single variable;
	 *         <code>false</code> otherwise.
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isExpression() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphpatternPackage.ATTRIBUTE_PATTERN__NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNode((NodePattern)otherEnd, msgs);
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
			case GraphpatternPackage.ATTRIBUTE_PATTERN__NODE:
				return basicSetNode(null, msgs);
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
			case GraphpatternPackage.ATTRIBUTE_PATTERN__NODE:
				return eInternalContainer().eInverseRemove(this, GraphpatternPackage.NODE_PATTERN__ATTRIBUTES, NodePattern.class, msgs);
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
			case GraphpatternPackage.ATTRIBUTE_PATTERN__VALUE:
				return getValue();
			case GraphpatternPackage.ATTRIBUTE_PATTERN__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case GraphpatternPackage.ATTRIBUTE_PATTERN__NODE:
				return getNode();
			case GraphpatternPackage.ATTRIBUTE_PATTERN__CONSTANT:
				return getConstant();
			case GraphpatternPackage.ATTRIBUTE_PATTERN__VARIABLES:
				return getVariables();
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
			case GraphpatternPackage.ATTRIBUTE_PATTERN__VALUE:
				setValue((String)newValue);
				return;
			case GraphpatternPackage.ATTRIBUTE_PATTERN__TYPE:
				setType((EAttribute)newValue);
				return;
			case GraphpatternPackage.ATTRIBUTE_PATTERN__NODE:
				setNode((NodePattern)newValue);
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
			case GraphpatternPackage.ATTRIBUTE_PATTERN__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case GraphpatternPackage.ATTRIBUTE_PATTERN__TYPE:
				setType((EAttribute)null);
				return;
			case GraphpatternPackage.ATTRIBUTE_PATTERN__NODE:
				setNode((NodePattern)null);
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
			case GraphpatternPackage.ATTRIBUTE_PATTERN__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case GraphpatternPackage.ATTRIBUTE_PATTERN__TYPE:
				return type != null;
			case GraphpatternPackage.ATTRIBUTE_PATTERN__NODE:
				return getNode() != null;
			case GraphpatternPackage.ATTRIBUTE_PATTERN__CONSTANT:
				return CONSTANT_EDEFAULT == null ? constant != null : !CONSTANT_EDEFAULT.equals(constant);
			case GraphpatternPackage.ATTRIBUTE_PATTERN__VARIABLES:
				return variables != null && !variables.isEmpty();
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
			case GraphpatternPackage.ATTRIBUTE_PATTERN___IS_CONSTANT:
				return isConstant();
			case GraphpatternPackage.ATTRIBUTE_PATTERN___IS_VARIABLE:
				return isVariable();
			case GraphpatternPackage.ATTRIBUTE_PATTERN___IS_EXPRESSION:
				return isExpression();
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
		result.append(" (value: ");
		result.append(value);
		result.append(", constant: ");
		result.append(constant);
		result.append(", variables: ");
		result.append(variables);
		result.append(')');
		return result.toString();
	}

	@Override
	public Iterable<NodePattern> getConnected() {
		return Collections.singletonList(getNode());
	}

} //AttributePatternImpl
