/**
 */
package org.sidiff.revision.difference.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferencePackage;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;

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
 * @see org.sidiff.revision.difference.DifferencePackage
 * @generated
 */
public class DifferenceSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DifferencePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DifferenceSwitch() {
		if (modelPackage == null) {
			modelPackage = DifferencePackage.eINSTANCE;
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
			case DifferencePackage.DIFFERENCE: {
				Difference difference = (Difference)theEObject;
				T result = caseDifference(difference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DifferencePackage.CORRESPONDENCE: {
				Correspondence correspondence = (Correspondence)theEObject;
				T result = caseCorrespondence(correspondence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DifferencePackage.CHANGE: {
				Change change = (Change)theEObject;
				T result = caseChange(change);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DifferencePackage.ADD_OBJECT: {
				AddObject addObject = (AddObject)theEObject;
				T result = caseAddObject(addObject);
				if (result == null) result = caseChange(addObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DifferencePackage.REMOVE_OBJECT: {
				RemoveObject removeObject = (RemoveObject)theEObject;
				T result = caseRemoveObject(removeObject);
				if (result == null) result = caseChange(removeObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DifferencePackage.ADD_REFERENCE: {
				AddReference addReference = (AddReference)theEObject;
				T result = caseAddReference(addReference);
				if (result == null) result = caseChange(addReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DifferencePackage.REMOVE_REFERENCE: {
				RemoveReference removeReference = (RemoveReference)theEObject;
				T result = caseRemoveReference(removeReference);
				if (result == null) result = caseChange(removeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DifferencePackage.ATTRIBUTE_VALUE_CHANGE: {
				AttributeValueChange attributeValueChange = (AttributeValueChange)theEObject;
				T result = caseAttributeValueChange(attributeValueChange);
				if (result == null) result = caseChange(attributeValueChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Difference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Difference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDifference(Difference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Correspondence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Correspondence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorrespondence(Correspondence object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Add Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddObject(AddObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveObject(RemoveObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddReference(AddReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveReference(RemoveReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueChange(AttributeValueChange object) {
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

} //DifferenceSwitch
