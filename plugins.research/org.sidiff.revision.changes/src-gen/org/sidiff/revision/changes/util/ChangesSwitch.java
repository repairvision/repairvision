/**
 */
package org.sidiff.revision.changes.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sidiff.revision.changes.*;

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
 * @see org.sidiff.revision.changes.ChangesPackage
 * @generated
 */
public class ChangesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ChangesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangesSwitch() {
		if (modelPackage == null) {
			modelPackage = ChangesPackage.eINSTANCE;
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
		case ChangesPackage.CHANGE_SET: {
			ChangeSet changeSet = (ChangeSet) theEObject;
			T result = caseChangeSet(changeSet);
			if (result == null)
				result = caseChangeContext(changeSet);
			if (result == null)
				result = caseNodeChangeContext(changeSet);
			if (result == null)
				result = caseEdgeChangeContext(changeSet);
			if (result == null)
				result = caseAttributeChangeContext(changeSet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.NODE_CHANGE_CONTEXT: {
			NodeChangeContext nodeChangeContext = (NodeChangeContext) theEObject;
			T result = caseNodeChangeContext(nodeChangeContext);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.ATTRIBUTE_CHANGE_CONTEXT: {
			AttributeChangeContext attributeChangeContext = (AttributeChangeContext) theEObject;
			T result = caseAttributeChangeContext(attributeChangeContext);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.EDGE_CHANGE_CONTEXT: {
			EdgeChangeContext edgeChangeContext = (EdgeChangeContext) theEObject;
			T result = caseEdgeChangeContext(edgeChangeContext);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.CHANGE: {
			Change change = (Change) theEObject;
			T result = caseChange(change);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.NODE_CHANGE: {
			NodeChange nodeChange = (NodeChange) theEObject;
			T result = caseNodeChange(nodeChange);
			if (result == null)
				result = caseChange(nodeChange);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.ATTRIBUTE_CHANGE: {
			AttributeChange attributeChange = (AttributeChange) theEObject;
			T result = caseAttributeChange(attributeChange);
			if (result == null)
				result = caseChange(attributeChange);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.EDGE_CHANGE: {
			EdgeChange edgeChange = (EdgeChange) theEObject;
			T result = caseEdgeChange(edgeChange);
			if (result == null)
				result = caseChange(edgeChange);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.CHANGE_CONTEXT: {
			ChangeContext changeContext = (ChangeContext) theEObject;
			T result = caseChangeContext(changeContext);
			if (result == null)
				result = caseNodeChangeContext(changeContext);
			if (result == null)
				result = caseEdgeChangeContext(changeContext);
			if (result == null)
				result = caseAttributeChangeContext(changeContext);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Change Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Change Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChangeSet(ChangeSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Change Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Change Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeChangeContext(NodeChangeContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Change Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Change Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeChangeContext(AttributeChangeContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Change Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Change Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeChangeContext(EdgeChangeContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChange(Change object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeChange(NodeChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeChange(AttributeChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeChange(EdgeChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Change Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Change Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChangeContext(ChangeContext object) {
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

} //ChangesSwitch
