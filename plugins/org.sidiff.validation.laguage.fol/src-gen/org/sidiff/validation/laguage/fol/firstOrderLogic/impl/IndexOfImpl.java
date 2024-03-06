/**
 * generated by Xtext 2.29.0
 */
package org.sidiff.validation.laguage.fol.firstOrderLogic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sidiff.validation.laguage.fol.firstOrderLogic.FeatureConstant;
import org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage;
import org.sidiff.validation.laguage.fol.firstOrderLogic.IndexOf;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Term;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Of</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.impl.IndexOfImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.impl.IndexOfImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.impl.IndexOfImpl#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndexOfImpl extends TermImpl implements IndexOf
{
  /**
   * The cached value of the '{@link #getContainer() <em>Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContainer()
   * @generated
   * @ordered
   */
  protected Term container;

  /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature()
   * @generated
   * @ordered
   */
  protected FeatureConstant feature;

  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected Term element;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IndexOfImpl()
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
    return FirstOrderLogicPackage.Literals.INDEX_OF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Term getContainer()
  {
    return container;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContainer(Term newContainer, NotificationChain msgs)
  {
    Term oldContainer = container;
    container = newContainer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FirstOrderLogicPackage.INDEX_OF__CONTAINER, oldContainer, newContainer);
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
  public void setContainer(Term newContainer)
  {
    if (newContainer != container)
    {
      NotificationChain msgs = null;
      if (container != null)
        msgs = ((InternalEObject)container).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FirstOrderLogicPackage.INDEX_OF__CONTAINER, null, msgs);
      if (newContainer != null)
        msgs = ((InternalEObject)newContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FirstOrderLogicPackage.INDEX_OF__CONTAINER, null, msgs);
      msgs = basicSetContainer(newContainer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FirstOrderLogicPackage.INDEX_OF__CONTAINER, newContainer, newContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FeatureConstant getFeature()
  {
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFeature(FeatureConstant newFeature, NotificationChain msgs)
  {
    FeatureConstant oldFeature = feature;
    feature = newFeature;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FirstOrderLogicPackage.INDEX_OF__FEATURE, oldFeature, newFeature);
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
  public void setFeature(FeatureConstant newFeature)
  {
    if (newFeature != feature)
    {
      NotificationChain msgs = null;
      if (feature != null)
        msgs = ((InternalEObject)feature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FirstOrderLogicPackage.INDEX_OF__FEATURE, null, msgs);
      if (newFeature != null)
        msgs = ((InternalEObject)newFeature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FirstOrderLogicPackage.INDEX_OF__FEATURE, null, msgs);
      msgs = basicSetFeature(newFeature, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FirstOrderLogicPackage.INDEX_OF__FEATURE, newFeature, newFeature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Term getElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElement(Term newElement, NotificationChain msgs)
  {
    Term oldElement = element;
    element = newElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FirstOrderLogicPackage.INDEX_OF__ELEMENT, oldElement, newElement);
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
  public void setElement(Term newElement)
  {
    if (newElement != element)
    {
      NotificationChain msgs = null;
      if (element != null)
        msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FirstOrderLogicPackage.INDEX_OF__ELEMENT, null, msgs);
      if (newElement != null)
        msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FirstOrderLogicPackage.INDEX_OF__ELEMENT, null, msgs);
      msgs = basicSetElement(newElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FirstOrderLogicPackage.INDEX_OF__ELEMENT, newElement, newElement));
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
      case FirstOrderLogicPackage.INDEX_OF__CONTAINER:
        return basicSetContainer(null, msgs);
      case FirstOrderLogicPackage.INDEX_OF__FEATURE:
        return basicSetFeature(null, msgs);
      case FirstOrderLogicPackage.INDEX_OF__ELEMENT:
        return basicSetElement(null, msgs);
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
      case FirstOrderLogicPackage.INDEX_OF__CONTAINER:
        return getContainer();
      case FirstOrderLogicPackage.INDEX_OF__FEATURE:
        return getFeature();
      case FirstOrderLogicPackage.INDEX_OF__ELEMENT:
        return getElement();
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
      case FirstOrderLogicPackage.INDEX_OF__CONTAINER:
        setContainer((Term)newValue);
        return;
      case FirstOrderLogicPackage.INDEX_OF__FEATURE:
        setFeature((FeatureConstant)newValue);
        return;
      case FirstOrderLogicPackage.INDEX_OF__ELEMENT:
        setElement((Term)newValue);
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
      case FirstOrderLogicPackage.INDEX_OF__CONTAINER:
        setContainer((Term)null);
        return;
      case FirstOrderLogicPackage.INDEX_OF__FEATURE:
        setFeature((FeatureConstant)null);
        return;
      case FirstOrderLogicPackage.INDEX_OF__ELEMENT:
        setElement((Term)null);
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
      case FirstOrderLogicPackage.INDEX_OF__CONTAINER:
        return container != null;
      case FirstOrderLogicPackage.INDEX_OF__FEATURE:
        return feature != null;
      case FirstOrderLogicPackage.INDEX_OF__ELEMENT:
        return element != null;
    }
    return super.eIsSet(featureID);
  }

} //IndexOfImpl
