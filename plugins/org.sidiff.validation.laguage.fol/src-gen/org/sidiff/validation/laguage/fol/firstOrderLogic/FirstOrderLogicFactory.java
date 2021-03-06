/**
 * generated by Xtext 2.21.0
 */
package org.sidiff.validation.laguage.fol.firstOrderLogic;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage
 * @generated
 */
public interface FirstOrderLogicFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FirstOrderLogicFactory eINSTANCE = org.sidiff.validation.laguage.fol.firstOrderLogic.impl.FirstOrderLogicFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Constraint Library</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Library</em>'.
   * @generated
   */
  ConstraintLibrary createConstraintLibrary();

  /**
   * Returns a new object of class '<em>Domain</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Domain</em>'.
   * @generated
   */
  Domain createDomain();

  /**
   * Returns a new object of class '<em>Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint</em>'.
   * @generated
   */
  Constraint createConstraint();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  Variable createVariable();

  /**
   * Returns a new object of class '<em>Formula</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formula</em>'.
   * @generated
   */
  Formula createFormula();

  /**
   * Returns a new object of class '<em>Unary Formula</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Formula</em>'.
   * @generated
   */
  UnaryFormula createUnaryFormula();

  /**
   * Returns a new object of class '<em>Equals</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equals</em>'.
   * @generated
   */
  Equals createEquals();

  /**
   * Returns a new object of class '<em>Greater</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Greater</em>'.
   * @generated
   */
  Greater createGreater();

  /**
   * Returns a new object of class '<em>Greater Equal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Greater Equal</em>'.
   * @generated
   */
  GreaterEqual createGreaterEqual();

  /**
   * Returns a new object of class '<em>Smaller</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Smaller</em>'.
   * @generated
   */
  Smaller createSmaller();

  /**
   * Returns a new object of class '<em>Smaller Equal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Smaller Equal</em>'.
   * @generated
   */
  SmallerEqual createSmallerEqual();

  /**
   * Returns a new object of class '<em>Is Empty</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Is Empty</em>'.
   * @generated
   */
  IsEmpty createIsEmpty();

  /**
   * Returns a new object of class '<em>Is Instance Of</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Is Instance Of</em>'.
   * @generated
   */
  IsInstanceOf createIsInstanceOf();

  /**
   * Returns a new object of class '<em>Is Value Literal Of</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Is Value Literal Of</em>'.
   * @generated
   */
  IsValueLiteralOf createIsValueLiteralOf();

  /**
   * Returns a new object of class '<em>Quantifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Quantifier</em>'.
   * @generated
   */
  Quantifier createQuantifier();

  /**
   * Returns a new object of class '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Term</em>'.
   * @generated
   */
  Term createTerm();

  /**
   * Returns a new object of class '<em>Get</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Get</em>'.
   * @generated
   */
  Get createGet();

  /**
   * Returns a new object of class '<em>Get Container</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Get Container</em>'.
   * @generated
   */
  GetContainer createGetContainer();

  /**
   * Returns a new object of class '<em>Get Containments</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Get Containments</em>'.
   * @generated
   */
  GetContainments createGetContainments();

  /**
   * Returns a new object of class '<em>Get Closure</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Get Closure</em>'.
   * @generated
   */
  GetClosure createGetClosure();

  /**
   * Returns a new object of class '<em>Size</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Size</em>'.
   * @generated
   */
  Size createSize();

  /**
   * Returns a new object of class '<em>Index Of</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Index Of</em>'.
   * @generated
   */
  IndexOf createIndexOf();

  /**
   * Returns a new object of class '<em>Concatenate</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Concatenate</em>'.
   * @generated
   */
  Concatenate createConcatenate();

  /**
   * Returns a new object of class '<em>Capitalize</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Capitalize</em>'.
   * @generated
   */
  Capitalize createCapitalize();

  /**
   * Returns a new object of class '<em>Feature Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feature Constant</em>'.
   * @generated
   */
  FeatureConstant createFeatureConstant();

  /**
   * Returns a new object of class '<em>Classifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classifier</em>'.
   * @generated
   */
  Classifier createClassifier();

  /**
   * Returns a new object of class '<em>Classifier Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classifier Constant</em>'.
   * @generated
   */
  ClassifierConstant createClassifierConstant();

  /**
   * Returns a new object of class '<em>As Classifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>As Classifier</em>'.
   * @generated
   */
  AsClassifier createAsClassifier();

  /**
   * Returns a new object of class '<em>Data Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type</em>'.
   * @generated
   */
  DataType createDataType();

  /**
   * Returns a new object of class '<em>Data Type Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type Constant</em>'.
   * @generated
   */
  DataTypeConstant createDataTypeConstant();

  /**
   * Returns a new object of class '<em>As Data Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>As Data Type</em>'.
   * @generated
   */
  AsDataType createAsDataType();

  /**
   * Returns a new object of class '<em>Int Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Int Constant</em>'.
   * @generated
   */
  IntConstant createIntConstant();

  /**
   * Returns a new object of class '<em>String Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Constant</em>'.
   * @generated
   */
  StringConstant createStringConstant();

  /**
   * Returns a new object of class '<em>Bool Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bool Constant</em>'.
   * @generated
   */
  BoolConstant createBoolConstant();

  /**
   * Returns a new object of class '<em>Iff</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Iff</em>'.
   * @generated
   */
  Iff createIff();

  /**
   * Returns a new object of class '<em>If</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If</em>'.
   * @generated
   */
  If createIf();

  /**
   * Returns a new object of class '<em>Xor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Xor</em>'.
   * @generated
   */
  Xor createXor();

  /**
   * Returns a new object of class '<em>Or</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or</em>'.
   * @generated
   */
  Or createOr();

  /**
   * Returns a new object of class '<em>And</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And</em>'.
   * @generated
   */
  And createAnd();

  /**
   * Returns a new object of class '<em>Not</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Not</em>'.
   * @generated
   */
  Not createNot();

  /**
   * Returns a new object of class '<em>For All</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>For All</em>'.
   * @generated
   */
  ForAll createForAll();

  /**
   * Returns a new object of class '<em>Exists</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exists</em>'.
   * @generated
   */
  Exists createExists();

  /**
   * Returns a new object of class '<em>Variable Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Ref</em>'.
   * @generated
   */
  VariableRef createVariableRef();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  FirstOrderLogicPackage getFirstOrderLogicPackage();

} //FirstOrderLogicFactory
