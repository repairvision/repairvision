/**
 */
package org.sidiff.repair.model.repairjob.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sidiff.repair.model.repairjob.*;

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
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage
 * @generated
 */
public class RepairjobSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RepairjobPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairjobSwitch() {
		if (modelPackage == null) {
			modelPackage = RepairjobPackage.eINSTANCE;
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
			case RepairjobPackage.REPAIR_JOB: {
				RepairJob repairJob = (RepairJob)theEObject;
				T result = caseRepairJob(repairJob);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepairjobPackage.EDIT_RULE: {
				EditRule editRule = (EditRule)theEObject;
				T result = caseEditRule(editRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepairjobPackage.REPAIR_OPERATION: {
				RepairOperation repairOperation = (RepairOperation)theEObject;
				T result = caseRepairOperation(repairOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepairjobPackage.PARTIAL_RULE: {
				PartialRule partialRule = (PartialRule)theEObject;
				T result = casePartialRule(partialRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepairjobPackage.SUB_RULE: {
				SubRule subRule = (SubRule)theEObject;
				T result = caseSubRule(subRule);
				if (result == null) result = casePartialRule(subRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepairjobPackage.COMPLEMENT_RULE: {
				ComplementRule complementRule = (ComplementRule)theEObject;
				T result = caseComplementRule(complementRule);
				if (result == null) result = casePartialRule(complementRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepairjobPackage.REPAIR: {
				Repair repair = (Repair)theEObject;
				T result = caseRepair(repair);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepairjobPackage.REPAIR_MATCH: {
				RepairMatch repairMatch = (RepairMatch)theEObject;
				T result = caseRepairMatch(repairMatch);
				if (result == null) result = caseRepair(repairMatch);
				if (result == null) result = caseMatch(repairMatch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepairjobPackage.REPAIR_PARAMETER: {
				RepairParameter repairParameter = (RepairParameter)theEObject;
				T result = caseRepairParameter(repairParameter);
				if (result == null) result = caseRepair(repairParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepairjobPackage.CHANGE: {
				Change change = (Change)theEObject;
				T result = caseChange(change);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RepairjobPackage.MATCH: {
				Match match = (Match)theEObject;
				T result = caseMatch(match);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repair Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repair Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepairJob(RepairJob object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edit Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edit Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditRule(EditRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repair Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repair Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepairOperation(RepairOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partial Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partial Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartialRule(PartialRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubRule(SubRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complement Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complement Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplementRule(ComplementRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repair</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repair</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepair(Repair object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repair Match</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repair Match</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepairMatch(RepairMatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repair Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repair Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepairParameter(RepairParameter object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Match</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatch(Match object) {
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

} //RepairjobSwitch
