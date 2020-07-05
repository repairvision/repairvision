package org.sidiff.validation.constraint.impact.repair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.RepairValidationIterator;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.RepairAction;

public class RepairActionIndex {

	/**
	 * Type -> Context -> Repairs:
	 */
	private Map<EStructuralFeature, Map<EObject, List<RepairAction>>> repairs = new HashMap<>();
	
	/**
	 * All context elements:
	 */
	private Set<EObject> scope = new HashSet<>();
	
	/**
	 * Repair Trees:
	 */
	private List<RepairValidation> validations = new ArrayList<>();
	
	public RepairActionIndex(Collection<RepairValidation> validations) {
		for (RepairValidation validation : validations) {
			addRepair(validation.getRepair());
			this.validations.add(validation);
		}
	}
	
	public RepairActionIndex(
			Iterator<? extends EObject> model, 
			List<IConstraint> consistencyRules,
			boolean storeValidation) {

		RepairValidationIterator validationIterator = new RepairValidationIterator(
				model, consistencyRules, true);

		// Collect all abstract repair actions:
		validationIterator.forEachRemaining(validation -> {
			if (!validation.getResult()) {
				addRepair(((RepairValidation) validation).getRepair());
				
				if (storeValidation) {
					validations.add((RepairValidation) validation);
				}
			}
		});
	}
	
	public List<RepairValidation> getValidations() {
		return validations;
	}

	private void addRepair(IDecisionNode repairDecision) {
		if (repairDecision instanceof RepairAction) {
			EObject context = ((RepairAction) repairDecision).getContext();
			EStructuralFeature type = ((RepairAction) repairDecision).getFeature();

			// Per meta-class:
			Map<EObject, List<RepairAction>> repairsPerMetaClass = repairs.get(type);

			if (repairsPerMetaClass == null) {
				repairsPerMetaClass = new HashMap<>();
				repairs.put(type, repairsPerMetaClass);
			}

			// Per repair:
			List<RepairAction> repairsPerObject = repairsPerMetaClass.get(context);

			if (repairsPerObject == null) {
				repairsPerObject = new ArrayList<>(5);
				repairsPerMetaClass.put(context, repairsPerObject);
			}

			repairsPerObject.add((RepairAction) repairDecision);
			
			// Store context element:
			scope.add(context);
			
		} else if (repairDecision instanceof IDecisionBranch) {
			for (IDecisionNode childDecision : ((IDecisionBranch) repairDecision).getChildDecisions()) {
				addRepair(childDecision);
			}
		}
	}

	public Map<EObject, List<RepairAction>> getRepairActions(EStructuralFeature structuralFeature) {
		return repairs.get(structuralFeature);
	}
	
	public Set<EObject> getScope() {
		return scope;
	}
	
	@Override
	public String toString() {
		StringBuilder toString = new StringBuilder(super.toString());
		toString.append("\n");
		
		toString.append("Repair Scope (Context Elements):\n");
		
		for (EObject contextElement : scope) {
			toString.append(" ");
			toString.append(contextElement);
			toString.append("\n");
		}
		
		toString.append("Repair Actions:\n");
		
		Set<RepairAction> repairSet = repairs.values().stream()
				.flatMap((objToRepairs) -> objToRepairs.values().stream())
				.flatMap(List::stream).collect(Collectors.toSet());
		
		for (RepairAction repairAction : repairSet) {
			toString.append(" ");
			toString.append(repairAction);
			toString.append("\n");
		}
		
		return toString.toString();
	}
}

