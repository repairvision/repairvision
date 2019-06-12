/**
 */
package org.sidiff.completion.ui.codebricks;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sidiff.completion.ui.codebricks.CodebricksFactory
 * @model kind="package"
 * @generated
 */
public interface CodebricksPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "codebricks";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sidiff.org/codebricks/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "codebricks";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CodebricksPackage eINSTANCE = org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.CodebricksImpl <em>Codebricks</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getCodebricks()
	 * @generated
	 */
	int CODEBRICKS = 0;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICKS__ALTERNATIVES = 0;

	/**
	 * The feature id for the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICKS__TEMPLATE = 1;

	/**
	 * The number of structural features of the '<em>Codebricks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICKS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Codebricks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICKS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.CodebrickImpl <em>Codebrick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getCodebrick()
	 * @generated
	 */
	int CODEBRICK = 1;

	/**
	 * The feature id for the '<em><b>Bricks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICK__BRICKS = 0;

	/**
	 * The feature id for the '<em><b>Codebricks</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICK__CODEBRICKS = 1;

	/**
	 * The number of structural features of the '<em>Codebrick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICK_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Calculate Rows</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICK___CALCULATE_ROWS = 0;

	/**
	 * The operation id for the '<em>Caluclate Columns</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICK___CALUCLATE_COLUMNS = 1;

	/**
	 * The number of operations of the '<em>Codebrick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODEBRICK_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.Brick <em>Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.Brick
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getBrick()
	 * @generated
	 */
	int BRICK = 2;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRICK__CODEBRICK = 0;

	/**
	 * The number of structural features of the '<em>Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRICK_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRICK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.ViewableBrick <em>Viewable Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.ViewableBrick
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getViewableBrick()
	 * @generated
	 */
	int VIEWABLE_BRICK = 8;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWABLE_BRICK__CODEBRICK = BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Editable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWABLE_BRICK__EDITABLE = BRICK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWABLE_BRICK__HIGHLIGHT = BRICK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Viewable Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWABLE_BRICK_FEATURE_COUNT = BRICK_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWABLE_BRICK___GET_TEXT = BRICK_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Viewable Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWABLE_BRICK_OPERATION_COUNT = BRICK_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl <em>Placeholder Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getPlaceholderBrick()
	 * @generated
	 */
	int PLACEHOLDER_BRICK = 3;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK__CODEBRICK = VIEWABLE_BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Editable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK__EDITABLE = VIEWABLE_BRICK__EDITABLE;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK__HIGHLIGHT = VIEWABLE_BRICK__HIGHLIGHT;

	/**
	 * The feature id for the '<em><b>Choices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK__CHOICES = VIEWABLE_BRICK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK__MANDATORY = VIEWABLE_BRICK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Choice</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK__CHOICE = VIEWABLE_BRICK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Remaining Choices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK__REMAINING_CHOICES = VIEWABLE_BRICK_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK_FEATURE_COUNT = VIEWABLE_BRICK_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK___GET_TEXT = VIEWABLE_BRICK___GET_TEXT;

	/**
	 * The number of operations of the '<em>Placeholder Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_BRICK_OPERATION_COUNT = VIEWABLE_BRICK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.ModelElementBrickImpl <em>Model Element Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.ModelElementBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getModelElementBrick()
	 * @generated
	 */
	int MODEL_ELEMENT_BRICK = 4;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_BRICK__CODEBRICK = VIEWABLE_BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Editable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_BRICK__EDITABLE = VIEWABLE_BRICK__EDITABLE;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_BRICK__HIGHLIGHT = VIEWABLE_BRICK__HIGHLIGHT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_BRICK__ELEMENT = VIEWABLE_BRICK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Element Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_BRICK_FEATURE_COUNT = VIEWABLE_BRICK_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_BRICK___GET_TEXT = VIEWABLE_BRICK___GET_TEXT;

	/**
	 * The number of operations of the '<em>Model Element Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_BRICK_OPERATION_COUNT = VIEWABLE_BRICK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.TextBrickImpl <em>Text Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.TextBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getTextBrick()
	 * @generated
	 */
	int TEXT_BRICK = 5;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK__CODEBRICK = VIEWABLE_BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Editable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK__EDITABLE = VIEWABLE_BRICK__EDITABLE;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK__HIGHLIGHT = VIEWABLE_BRICK__HIGHLIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK__TEXT = VIEWABLE_BRICK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK_FEATURE_COUNT = VIEWABLE_BRICK_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK___GET_TEXT = VIEWABLE_BRICK___GET_TEXT;

	/**
	 * The number of operations of the '<em>Text Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BRICK_OPERATION_COUNT = VIEWABLE_BRICK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.IndentBrickImpl <em>Indent Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.IndentBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getIndentBrick()
	 * @generated
	 */
	int INDENT_BRICK = 6;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDENT_BRICK__CODEBRICK = BRICK__CODEBRICK;

	/**
	 * The feature id for the '<em><b>Bricks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDENT_BRICK__BRICKS = BRICK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Indent Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDENT_BRICK_FEATURE_COUNT = BRICK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Indent Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDENT_BRICK_OPERATION_COUNT = BRICK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.LineBreakBrickImpl <em>Line Break Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.LineBreakBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getLineBreakBrick()
	 * @generated
	 */
	int LINE_BREAK_BRICK = 7;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK_BRICK__CODEBRICK = BRICK__CODEBRICK;

	/**
	 * The number of structural features of the '<em>Line Break Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK_BRICK_FEATURE_COUNT = BRICK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Line Break Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK_BRICK_OPERATION_COUNT = BRICK_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.sidiff.completion.ui.codebricks.impl.BlankBrickImpl <em>Blank Brick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.completion.ui.codebricks.impl.BlankBrickImpl
	 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getBlankBrick()
	 * @generated
	 */
	int BLANK_BRICK = 9;

	/**
	 * The feature id for the '<em><b>Codebrick</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLANK_BRICK__CODEBRICK = BRICK__CODEBRICK;

	/**
	 * The number of structural features of the '<em>Blank Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLANK_BRICK_FEATURE_COUNT = BRICK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Blank Brick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLANK_BRICK_OPERATION_COUNT = BRICK_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.Codebricks <em>Codebricks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Codebricks</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Codebricks
	 * @generated
	 */
	EClass getCodebricks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.completion.ui.codebricks.Codebricks#getAlternatives <em>Alternatives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Alternatives</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Codebricks#getAlternatives()
	 * @see #getCodebricks()
	 * @generated
	 */
	EReference getCodebricks_Alternatives();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.completion.ui.codebricks.Codebricks#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Template</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Codebricks#getTemplate()
	 * @see #getCodebricks()
	 * @generated
	 */
	EReference getCodebricks_Template();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.Codebrick <em>Codebrick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Codebrick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Codebrick
	 * @generated
	 */
	EClass getCodebrick();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.completion.ui.codebricks.Codebrick#getBricks <em>Bricks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bricks</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Codebrick#getBricks()
	 * @see #getCodebrick()
	 * @generated
	 */
	EReference getCodebrick_Bricks();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.completion.ui.codebricks.Codebrick#getCodebricks <em>Codebricks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Codebricks</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Codebrick#getCodebricks()
	 * @see #getCodebrick()
	 * @generated
	 */
	EReference getCodebrick_Codebricks();

	/**
	 * Returns the meta object for the '{@link org.sidiff.completion.ui.codebricks.Codebrick#calculateRows() <em>Calculate Rows</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Calculate Rows</em>' operation.
	 * @see org.sidiff.completion.ui.codebricks.Codebrick#calculateRows()
	 * @generated
	 */
	EOperation getCodebrick__CalculateRows();

	/**
	 * Returns the meta object for the '{@link org.sidiff.completion.ui.codebricks.Codebrick#caluclateColumns() <em>Caluclate Columns</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Caluclate Columns</em>' operation.
	 * @see org.sidiff.completion.ui.codebricks.Codebrick#caluclateColumns()
	 * @generated
	 */
	EOperation getCodebrick__CaluclateColumns();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.Brick <em>Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Brick
	 * @generated
	 */
	EClass getBrick();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.completion.ui.codebricks.Brick#getCodebrick <em>Codebrick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Codebrick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.Brick#getCodebrick()
	 * @see #getBrick()
	 * @generated
	 */
	EReference getBrick_Codebrick();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick <em>Placeholder Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placeholder Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.PlaceholderBrick
	 * @generated
	 */
	EClass getPlaceholderBrick();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick#getChoices <em>Choices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Choices</em>'.
	 * @see org.sidiff.completion.ui.codebricks.PlaceholderBrick#getChoices()
	 * @see #getPlaceholderBrick()
	 * @generated
	 */
	EReference getPlaceholderBrick_Choices();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick#isMandatory <em>Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mandatory</em>'.
	 * @see org.sidiff.completion.ui.codebricks.PlaceholderBrick#isMandatory()
	 * @see #getPlaceholderBrick()
	 * @generated
	 */
	EAttribute getPlaceholderBrick_Mandatory();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick#getChoice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Choice</em>'.
	 * @see org.sidiff.completion.ui.codebricks.PlaceholderBrick#getChoice()
	 * @see #getPlaceholderBrick()
	 * @generated
	 */
	EReference getPlaceholderBrick_Choice();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.completion.ui.codebricks.PlaceholderBrick#getRemainingChoices <em>Remaining Choices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Remaining Choices</em>'.
	 * @see org.sidiff.completion.ui.codebricks.PlaceholderBrick#getRemainingChoices()
	 * @see #getPlaceholderBrick()
	 * @generated
	 */
	EReference getPlaceholderBrick_RemainingChoices();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.ModelElementBrick <em>Model Element Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ModelElementBrick
	 * @generated
	 */
	EClass getModelElementBrick();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.completion.ui.codebricks.ModelElementBrick#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ModelElementBrick#getElement()
	 * @see #getModelElementBrick()
	 * @generated
	 */
	EReference getModelElementBrick_Element();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.TextBrick <em>Text Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.TextBrick
	 * @generated
	 */
	EClass getTextBrick();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.completion.ui.codebricks.TextBrick#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.sidiff.completion.ui.codebricks.TextBrick#getText()
	 * @see #getTextBrick()
	 * @generated
	 */
	EAttribute getTextBrick_Text();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.IndentBrick <em>Indent Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Indent Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.IndentBrick
	 * @generated
	 */
	EClass getIndentBrick();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.completion.ui.codebricks.IndentBrick#getBricks <em>Bricks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bricks</em>'.
	 * @see org.sidiff.completion.ui.codebricks.IndentBrick#getBricks()
	 * @see #getIndentBrick()
	 * @generated
	 */
	EAttribute getIndentBrick_Bricks();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.LineBreakBrick <em>Line Break Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Break Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.LineBreakBrick
	 * @generated
	 */
	EClass getLineBreakBrick();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.ViewableBrick <em>Viewable Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Viewable Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ViewableBrick
	 * @generated
	 */
	EClass getViewableBrick();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.completion.ui.codebricks.ViewableBrick#isEditable <em>Editable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Editable</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ViewableBrick#isEditable()
	 * @see #getViewableBrick()
	 * @generated
	 */
	EAttribute getViewableBrick_Editable();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.completion.ui.codebricks.ViewableBrick#isHighlight <em>Highlight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Highlight</em>'.
	 * @see org.sidiff.completion.ui.codebricks.ViewableBrick#isHighlight()
	 * @see #getViewableBrick()
	 * @generated
	 */
	EAttribute getViewableBrick_Highlight();

	/**
	 * Returns the meta object for the '{@link org.sidiff.completion.ui.codebricks.ViewableBrick#getText() <em>Get Text</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Text</em>' operation.
	 * @see org.sidiff.completion.ui.codebricks.ViewableBrick#getText()
	 * @generated
	 */
	EOperation getViewableBrick__GetText();

	/**
	 * Returns the meta object for class '{@link org.sidiff.completion.ui.codebricks.BlankBrick <em>Blank Brick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blank Brick</em>'.
	 * @see org.sidiff.completion.ui.codebricks.BlankBrick
	 * @generated
	 */
	EClass getBlankBrick();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CodebricksFactory getCodebricksFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.CodebricksImpl <em>Codebricks</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getCodebricks()
		 * @generated
		 */
		EClass CODEBRICKS = eINSTANCE.getCodebricks();

		/**
		 * The meta object literal for the '<em><b>Alternatives</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODEBRICKS__ALTERNATIVES = eINSTANCE.getCodebricks_Alternatives();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODEBRICKS__TEMPLATE = eINSTANCE.getCodebricks_Template();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.CodebrickImpl <em>Codebrick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getCodebrick()
		 * @generated
		 */
		EClass CODEBRICK = eINSTANCE.getCodebrick();

		/**
		 * The meta object literal for the '<em><b>Bricks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODEBRICK__BRICKS = eINSTANCE.getCodebrick_Bricks();

		/**
		 * The meta object literal for the '<em><b>Codebricks</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODEBRICK__CODEBRICKS = eINSTANCE.getCodebrick_Codebricks();

		/**
		 * The meta object literal for the '<em><b>Calculate Rows</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CODEBRICK___CALCULATE_ROWS = eINSTANCE.getCodebrick__CalculateRows();

		/**
		 * The meta object literal for the '<em><b>Caluclate Columns</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CODEBRICK___CALUCLATE_COLUMNS = eINSTANCE.getCodebrick__CaluclateColumns();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.Brick <em>Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.Brick
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getBrick()
		 * @generated
		 */
		EClass BRICK = eINSTANCE.getBrick();

		/**
		 * The meta object literal for the '<em><b>Codebrick</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRICK__CODEBRICK = eINSTANCE.getBrick_Codebrick();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl <em>Placeholder Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.PlaceholderBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getPlaceholderBrick()
		 * @generated
		 */
		EClass PLACEHOLDER_BRICK = eINSTANCE.getPlaceholderBrick();

		/**
		 * The meta object literal for the '<em><b>Choices</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACEHOLDER_BRICK__CHOICES = eINSTANCE.getPlaceholderBrick_Choices();

		/**
		 * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACEHOLDER_BRICK__MANDATORY = eINSTANCE.getPlaceholderBrick_Mandatory();

		/**
		 * The meta object literal for the '<em><b>Choice</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACEHOLDER_BRICK__CHOICE = eINSTANCE.getPlaceholderBrick_Choice();

		/**
		 * The meta object literal for the '<em><b>Remaining Choices</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACEHOLDER_BRICK__REMAINING_CHOICES = eINSTANCE.getPlaceholderBrick_RemainingChoices();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.ModelElementBrickImpl <em>Model Element Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.ModelElementBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getModelElementBrick()
		 * @generated
		 */
		EClass MODEL_ELEMENT_BRICK = eINSTANCE.getModelElementBrick();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_BRICK__ELEMENT = eINSTANCE.getModelElementBrick_Element();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.TextBrickImpl <em>Text Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.TextBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getTextBrick()
		 * @generated
		 */
		EClass TEXT_BRICK = eINSTANCE.getTextBrick();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_BRICK__TEXT = eINSTANCE.getTextBrick_Text();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.IndentBrickImpl <em>Indent Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.IndentBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getIndentBrick()
		 * @generated
		 */
		EClass INDENT_BRICK = eINSTANCE.getIndentBrick();

		/**
		 * The meta object literal for the '<em><b>Bricks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDENT_BRICK__BRICKS = eINSTANCE.getIndentBrick_Bricks();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.LineBreakBrickImpl <em>Line Break Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.LineBreakBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getLineBreakBrick()
		 * @generated
		 */
		EClass LINE_BREAK_BRICK = eINSTANCE.getLineBreakBrick();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.ViewableBrick <em>Viewable Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.ViewableBrick
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getViewableBrick()
		 * @generated
		 */
		EClass VIEWABLE_BRICK = eINSTANCE.getViewableBrick();

		/**
		 * The meta object literal for the '<em><b>Editable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWABLE_BRICK__EDITABLE = eINSTANCE.getViewableBrick_Editable();

		/**
		 * The meta object literal for the '<em><b>Highlight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWABLE_BRICK__HIGHLIGHT = eINSTANCE.getViewableBrick_Highlight();

		/**
		 * The meta object literal for the '<em><b>Get Text</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VIEWABLE_BRICK___GET_TEXT = eINSTANCE.getViewableBrick__GetText();

		/**
		 * The meta object literal for the '{@link org.sidiff.completion.ui.codebricks.impl.BlankBrickImpl <em>Blank Brick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.completion.ui.codebricks.impl.BlankBrickImpl
		 * @see org.sidiff.completion.ui.codebricks.impl.CodebricksPackageImpl#getBlankBrick()
		 * @generated
		 */
		EClass BLANK_BRICK = eINSTANCE.getBlankBrick();

	}

} //CodebricksPackage
