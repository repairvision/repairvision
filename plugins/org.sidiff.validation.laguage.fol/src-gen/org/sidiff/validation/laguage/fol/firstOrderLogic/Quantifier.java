/**
 * generated by Xtext 2.29.0
 */
package org.sidiff.validation.laguage.fol.firstOrderLogic;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quantifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Quantifier#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Quantifier#getIteration <em>Iteration</em>}</li>
 *   <li>{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Quantifier#getFormula <em>Formula</em>}</li>
 * </ul>
 *
 * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getQuantifier()
 * @model
 * @generated
 */
public interface Quantifier extends Formula
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(Variable)
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getQuantifier_Name()
   * @model containment="true"
   * @generated
   */
  Variable getName();

  /**
   * Sets the value of the '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Quantifier#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Variable value);

  /**
   * Returns the value of the '<em><b>Iteration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Iteration</em>' containment reference.
   * @see #setIteration(Term)
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getQuantifier_Iteration()
   * @model containment="true"
   * @generated
   */
  Term getIteration();

  /**
   * Sets the value of the '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Quantifier#getIteration <em>Iteration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Iteration</em>' containment reference.
   * @see #getIteration()
   * @generated
   */
  void setIteration(Term value);

  /**
   * Returns the value of the '<em><b>Formula</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formula</em>' containment reference.
   * @see #setFormula(Formula)
   * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage#getQuantifier_Formula()
   * @model containment="true"
   * @generated
   */
  Formula getFormula();

  /**
   * Sets the value of the '{@link org.sidiff.validation.laguage.fol.firstOrderLogic.Quantifier#getFormula <em>Formula</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formula</em>' containment reference.
   * @see #getFormula()
   * @generated
   */
  void setFormula(Formula value);

} // Quantifier
