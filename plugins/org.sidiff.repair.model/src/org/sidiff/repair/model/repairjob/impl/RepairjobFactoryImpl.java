/**
 */
package org.sidiff.repair.model.repairjob.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sidiff.repair.model.repairjob.Change;
import org.sidiff.repair.model.repairjob.ComplementRule;
import org.sidiff.repair.model.repairjob.EditRule;
import org.sidiff.repair.model.repairjob.Match;
import org.sidiff.repair.model.repairjob.PartialRule;
import org.sidiff.repair.model.repairjob.RepairJob;
import org.sidiff.repair.model.repairjob.RepairMatch;
import org.sidiff.repair.model.repairjob.RepairOperation;
import org.sidiff.repair.model.repairjob.RepairParameter;
import org.sidiff.repair.model.repairjob.RepairjobFactory;
import org.sidiff.repair.model.repairjob.RepairjobPackage;
import org.sidiff.repair.model.repairjob.SubRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RepairjobFactoryImpl extends EFactoryImpl implements RepairjobFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RepairjobFactory init() {
		try {
			RepairjobFactory theRepairjobFactory = (RepairjobFactory)EPackage.Registry.INSTANCE.getEFactory(RepairjobPackage.eNS_URI);
			if (theRepairjobFactory != null) {
				return theRepairjobFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RepairjobFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairjobFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RepairjobPackage.REPAIR_JOB: return createRepairJob();
			case RepairjobPackage.EDIT_RULE: return createEditRule();
			case RepairjobPackage.REPAIR_OPERATION: return createRepairOperation();
			case RepairjobPackage.PARTIAL_RULE: return createPartialRule();
			case RepairjobPackage.SUB_RULE: return createSubRule();
			case RepairjobPackage.COMPLEMENT_RULE: return createComplementRule();
			case RepairjobPackage.REPAIR_MATCH: return createRepairMatch();
			case RepairjobPackage.REPAIR_PARAMETER: return createRepairParameter();
			case RepairjobPackage.CHANGE: return createChange();
			case RepairjobPackage.MATCH: return createMatch();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairJob createRepairJob() {
		RepairJobImpl repairJob = new RepairJobImpl();
		return repairJob;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditRule createEditRule() {
		EditRuleImpl editRule = new EditRuleImpl();
		return editRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairOperation createRepairOperation() {
		RepairOperationImpl repairOperation = new RepairOperationImpl();
		return repairOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartialRule createPartialRule() {
		PartialRuleImpl partialRule = new PartialRuleImpl();
		return partialRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubRule createSubRule() {
		SubRuleImpl subRule = new SubRuleImpl();
		return subRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplementRule createComplementRule() {
		ComplementRuleImpl complementRule = new ComplementRuleImpl();
		return complementRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairMatch createRepairMatch() {
		RepairMatchImpl repairMatch = new RepairMatchImpl();
		return repairMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairParameter createRepairParameter() {
		RepairParameterImpl repairParameter = new RepairParameterImpl();
		return repairParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Change createChange() {
		ChangeImpl change = new ChangeImpl();
		return change;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match createMatch() {
		MatchImpl match = new MatchImpl();
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairjobPackage getRepairjobPackage() {
		return (RepairjobPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RepairjobPackage getPackage() {
		return RepairjobPackage.eINSTANCE;
	}

} //RepairjobFactoryImpl
