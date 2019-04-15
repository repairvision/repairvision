/**
 * generated by Xtext 2.17.0
 */
package org.sidiff.validation.laguage.fol.firstOrderLogic;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Or#getLeft <em>Left</em>}</li>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Or#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getOr()
 * @model
 * @generated
 */
public interface Or extends Formula
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Formula)
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getOr_Left()
   * @model containment="true"
   * @generated
   */
  Formula getLeft();

  /**
   * Sets the value of the '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Or#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Formula value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Formula)
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getOr_Right()
   * @model containment="true"
   * @generated
   */
  Formula getRight();

  /**
   * Sets the value of the '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Or#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Formula value);

} // Or
