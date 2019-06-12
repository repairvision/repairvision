/**
 */
package org.sidiff.completion.ui.codebricks.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sidiff.completion.ui.codebricks.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.sidiff.completion.ui.codebricks.CodebricksPackage
 * @generated
 */
public class CodebricksSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CodebricksPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodebricksSwitch() {
		if (modelPackage == null) {
			modelPackage = CodebricksPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CodebricksPackage.CODEBRICKS: {
				Codebricks codebricks = (Codebricks)theEObject;
				T result = caseCodebricks(codebricks);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodebricksPackage.CODEBRICK: {
				Codebrick codebrick = (Codebrick)theEObject;
				T result = caseCodebrick(codebrick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodebricksPackage.BRICK: {
				Brick brick = (Brick)theEObject;
				T result = caseBrick(brick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodebricksPackage.PLACEHOLDER_BRICK: {
				PlaceholderBrick placeholderBrick = (PlaceholderBrick)theEObject;
				T result = casePlaceholderBrick(placeholderBrick);
				if (result == null) result = caseViewableBrick(placeholderBrick);
				if (result == null) result = caseBrick(placeholderBrick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodebricksPackage.MODEL_ELEMENT_BRICK: {
				ModelElementBrick modelElementBrick = (ModelElementBrick)theEObject;
				T result = caseModelElementBrick(modelElementBrick);
				if (result == null) result = caseViewableBrick(modelElementBrick);
				if (result == null) result = caseBrick(modelElementBrick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodebricksPackage.TEXT_BRICK: {
				TextBrick textBrick = (TextBrick)theEObject;
				T result = caseTextBrick(textBrick);
				if (result == null) result = caseViewableBrick(textBrick);
				if (result == null) result = caseBrick(textBrick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodebricksPackage.INDENT_BRICK: {
				IndentBrick indentBrick = (IndentBrick)theEObject;
				T result = caseIndentBrick(indentBrick);
				if (result == null) result = caseBrick(indentBrick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodebricksPackage.LINE_BREAK_BRICK: {
				LineBreakBrick lineBreakBrick = (LineBreakBrick)theEObject;
				T result = caseLineBreakBrick(lineBreakBrick);
				if (result == null) result = caseBrick(lineBreakBrick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodebricksPackage.VIEWABLE_BRICK: {
				ViewableBrick viewableBrick = (ViewableBrick)theEObject;
				T result = caseViewableBrick(viewableBrick);
				if (result == null) result = caseBrick(viewableBrick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CodebricksPackage.BLANK_BRICK: {
				BlankBrick blankBrick = (BlankBrick)theEObject;
				T result = caseBlankBrick(blankBrick);
				if (result == null) result = caseBrick(blankBrick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Codebricks</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Codebricks</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodebricks(Codebricks object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Codebrick</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Codebrick</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodebrick(Codebrick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Brick</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Brick</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBrick(Brick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Placeholder Brick</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Placeholder Brick</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlaceholderBrick(PlaceholderBrick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element Brick</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element Brick</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementBrick(ModelElementBrick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Brick</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Brick</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextBrick(TextBrick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Indent Brick</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Indent Brick</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndentBrick(IndentBrick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line Break Brick</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Break Brick</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLineBreakBrick(LineBreakBrick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Viewable Brick</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Viewable Brick</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewableBrick(ViewableBrick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Blank Brick</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Blank Brick</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlankBrick(BlankBrick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CodebricksSwitch
