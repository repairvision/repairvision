/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.difference.symmetric.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.EObjectSet;
import org.sidiff.difference.symmetric.EditRuleMatch;
import org.sidiff.difference.symmetric.FragmentJoin;
import org.sidiff.difference.symmetric.FragmentSplit;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricPackage;

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
 * @see org.sidiff.difference.symmetric.SymmetricPackage
 * @generated
 */
public class SymmetricSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SymmetricPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymmetricSwitch() {
		if (modelPackage == null) {
			modelPackage = SymmetricPackage.eINSTANCE;
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
			case SymmetricPackage.SYMMETRIC_DIFFERENCE: {
				SymmetricDifference symmetricDifference = (SymmetricDifference)theEObject;
				T result = caseSymmetricDifference(symmetricDifference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SymmetricPackage.ADD_OBJECT: {
				AddObject addObject = (AddObject)theEObject;
				T result = caseAddObject(addObject);
				if (result == null) result = caseChange(addObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SymmetricPackage.REMOVE_OBJECT: {
				RemoveObject removeObject = (RemoveObject)theEObject;
				T result = caseRemoveObject(removeObject);
				if (result == null) result = caseChange(removeObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SymmetricPackage.ADD_REFERENCE: {
				AddReference addReference = (AddReference)theEObject;
				T result = caseAddReference(addReference);
				if (result == null) result = caseChange(addReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SymmetricPackage.REMOVE_REFERENCE: {
				RemoveReference removeReference = (RemoveReference)theEObject;
				T result = caseRemoveReference(removeReference);
				if (result == null) result = caseChange(removeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SymmetricPackage.CHANGE: {
				Change change = (Change)theEObject;
				T result = caseChange(change);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SymmetricPackage.SEMANTIC_CHANGE_SET: {
				SemanticChangeSet semanticChangeSet = (SemanticChangeSet)theEObject;
				T result = caseSemanticChangeSet(semanticChangeSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SymmetricPackage.ATTRIBUTE_VALUE_CHANGE: {
				AttributeValueChange attributeValueChange = (AttributeValueChange)theEObject;
				T result = caseAttributeValueChange(attributeValueChange);
				if (result == null) result = caseChange(attributeValueChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SymmetricPackage.ESTRING2_EOBJECT_SET_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, EObjectSet> eString2EObjectSetMap = (Map.Entry<String, EObjectSet>)theEObject;
				T result = caseEString2EObjectSetMap(eString2EObjectSetMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SymmetricPackage.EDIT_RULE_MATCH: {
				EditRuleMatch editRuleMatch = (EditRuleMatch)theEObject;
				T result = caseEditRuleMatch(editRuleMatch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SymmetricPackage.EOBJECT_SET: {
				EObjectSet eObjectSet = (EObjectSet)theEObject;
				T result = caseEObjectSet(eObjectSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SymmetricPackage.FRAGMENT_JOIN: {
				FragmentJoin fragmentJoin = (FragmentJoin)theEObject;
				T result = caseFragmentJoin(fragmentJoin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SymmetricPackage.FRAGMENT_SPLIT: {
				FragmentSplit fragmentSplit = (FragmentSplit)theEObject;
				T result = caseFragmentSplit(fragmentSplit);
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
	public T caseSymmetricDifference(SymmetricDifference object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Change Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Change Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticChangeSet(SemanticChangeSet object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>EString2 EObject Set Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EString2 EObject Set Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEString2EObjectSetMap(Map.Entry<String, EObjectSet> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edit Rule Match</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edit Rule Match</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditRuleMatch(EditRuleMatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEObjectSet(EObjectSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragment Join</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragment Join</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFragmentJoin(FragmentJoin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragment Split</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragment Split</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFragmentSplit(FragmentSplit object) {
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

} //SymmetricSwitch
