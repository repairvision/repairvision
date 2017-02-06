/**
 */
package org.sidiff.repair.model.repairjob.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.repair.model.repairjob.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage
 * @generated
 */
public class RepairjobAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RepairjobPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairjobAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RepairjobPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepairjobSwitch<Adapter> modelSwitch =
		new RepairjobSwitch<Adapter>() {
			@Override
			public Adapter caseRepairJob(RepairJob object) {
				return createRepairJobAdapter();
			}
			@Override
			public Adapter caseEditRule(EditRule object) {
				return createEditRuleAdapter();
			}
			@Override
			public Adapter caseRepairOperation(RepairOperation object) {
				return createRepairOperationAdapter();
			}
			@Override
			public Adapter casePartialRule(PartialRule object) {
				return createPartialRuleAdapter();
			}
			@Override
			public Adapter caseSubRule(SubRule object) {
				return createSubRuleAdapter();
			}
			@Override
			public Adapter caseComplementRule(ComplementRule object) {
				return createComplementRuleAdapter();
			}
			@Override
			public Adapter caseRepair(Repair object) {
				return createRepairAdapter();
			}
			@Override
			public Adapter caseRepairMatch(RepairMatch object) {
				return createRepairMatchAdapter();
			}
			@Override
			public Adapter caseRepairParameter(RepairParameter object) {
				return createRepairParameterAdapter();
			}
			@Override
			public Adapter caseChange(Change object) {
				return createChangeAdapter();
			}
			@Override
			public Adapter caseMatch(Match object) {
				return createMatchAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.repair.model.repairjob.RepairJob <em>Repair Job</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.repair.model.repairjob.RepairJob
	 * @generated
	 */
	public Adapter createRepairJobAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.repair.model.repairjob.EditRule <em>Edit Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.repair.model.repairjob.EditRule
	 * @generated
	 */
	public Adapter createEditRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.repair.model.repairjob.RepairOperation <em>Repair Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.repair.model.repairjob.RepairOperation
	 * @generated
	 */
	public Adapter createRepairOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.repair.model.repairjob.PartialRule <em>Partial Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.repair.model.repairjob.PartialRule
	 * @generated
	 */
	public Adapter createPartialRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.repair.model.repairjob.SubRule <em>Sub Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.repair.model.repairjob.SubRule
	 * @generated
	 */
	public Adapter createSubRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.repair.model.repairjob.ComplementRule <em>Complement Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.repair.model.repairjob.ComplementRule
	 * @generated
	 */
	public Adapter createComplementRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.repair.model.repairjob.Repair <em>Repair</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.repair.model.repairjob.Repair
	 * @generated
	 */
	public Adapter createRepairAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.repair.model.repairjob.RepairMatch <em>Repair Match</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.repair.model.repairjob.RepairMatch
	 * @generated
	 */
	public Adapter createRepairMatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.repair.model.repairjob.RepairParameter <em>Repair Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.repair.model.repairjob.RepairParameter
	 * @generated
	 */
	public Adapter createRepairParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.repair.model.repairjob.Change <em>Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.repair.model.repairjob.Change
	 * @generated
	 */
	public Adapter createChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.repair.model.repairjob.Match <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.repair.model.repairjob.Match
	 * @generated
	 */
	public Adapter createMatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RepairjobAdapterFactory
