/**
 * generated by Xtext 2.17.0
 */
package org.sidiff.validation.laguage.fol.firstOrderLogic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Get;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Variable;
import org.sidiff.validation.laguage.fol.firstOrderLogic.VariableRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.impl.VariableRefImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.impl.VariableRefImpl#getGet <em>Get</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableRefImpl extends TermImpl implements VariableRef
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected Variable name;

  /**
   * The cached value of the '{@link #getGet() <em>Get</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGet()
   * @generated
   * @ordered
   */
  protected Get get;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableRefImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return FirstOrderLogicPackage.Literals.VARIABLE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Variable getName()
  {
    if (name != null && name.eIsProxy())
    {
      InternalEObject oldName = (InternalEObject)name;
      name = (Variable)eResolveProxy(oldName);
      if (name != oldName)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FirstOrderLogicPackage.VARIABLE_REF__NAME, oldName, name));
      }
    }
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable basicGetName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(Variable newName)
  {
    Variable oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FirstOrderLogicPackage.VARIABLE_REF__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Get getGet()
  {
    return get;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGet(Get newGet, NotificationChain msgs)
  {
    Get oldGet = get;
    get = newGet;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FirstOrderLogicPackage.VARIABLE_REF__GET, oldGet, newGet);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setGet(Get newGet)
  {
    if (newGet != get)
    {
      NotificationChain msgs = null;
      if (get != null)
        msgs = ((InternalEObject)get).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FirstOrderLogicPackage.VARIABLE_REF__GET, null, msgs);
      if (newGet != null)
        msgs = ((InternalEObject)newGet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FirstOrderLogicPackage.VARIABLE_REF__GET, null, msgs);
      msgs = basicSetGet(newGet, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FirstOrderLogicPackage.VARIABLE_REF__GET, newGet, newGet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case FirstOrderLogicPackage.VARIABLE_REF__GET:
        return basicSetGet(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case FirstOrderLogicPackage.VARIABLE_REF__NAME:
        if (resolve) return getName();
        return basicGetName();
      case FirstOrderLogicPackage.VARIABLE_REF__GET:
        return getGet();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FirstOrderLogicPackage.VARIABLE_REF__NAME:
        setName((Variable)newValue);
        return;
      case FirstOrderLogicPackage.VARIABLE_REF__GET:
        setGet((Get)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case FirstOrderLogicPackage.VARIABLE_REF__NAME:
        setName((Variable)null);
        return;
      case FirstOrderLogicPackage.VARIABLE_REF__GET:
        setGet((Get)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case FirstOrderLogicPackage.VARIABLE_REF__NAME:
        return name != null;
      case FirstOrderLogicPackage.VARIABLE_REF__GET:
        return get != null;
    }
    return super.eIsSet(featureID);
  }

} //VariableRefImpl
