package org.sidiff.revision.repair.impact;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.revision.impact.analysis.ImpactScope;
import org.sidiff.revision.impact.changetree.IDecisionBranch;
import org.sidiff.revision.impact.changetree.IDecisionNode;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ObjectChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.StructuralFeatureChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.RepairValidationIterator;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class RepairActionImpactScope implements ImpactScope {

	/**
	 * Type -> Context -> Repairs:
	 */
	private Map<EStructuralFeature, Map<EObject, List<ChangeAction>>> repairs = new HashMap<>();
	
	/**
	 * All context elements:
	 */
	private Set<EObject> scope = new HashSet<>();
	
	/**
	 * Repair Trees:
	 */
	private List<RepairValidation> validations = new ArrayList<>();
	
	public RepairActionImpactScope(Collection<RepairValidation> validations) {
		for (RepairValidation validation : validations) {
			addRepair(validation.getRepair());
			this.validations.add(validation);
		}
	}
	
	public RepairActionImpactScope(
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
		if (repairDecision instanceof StructuralFeatureChangeAction) {
			EObject context = ((StructuralFeatureChangeAction) repairDecision).getContext();
			EStructuralFeature type = ((StructuralFeatureChangeAction) repairDecision).getFeature();
			addRepair(type, context, (ChangeAction) repairDecision);
		} else if (repairDecision instanceof ObjectChangeAction) {
			EObject object = ((ObjectChangeAction) repairDecision).getObject();
			EReference containingReference = ((ObjectChangeAction) repairDecision).getContainingReference();
			addRepair(containingReference, object, (ChangeAction) repairDecision);
		} else if (repairDecision instanceof IDecisionBranch) {
			for (IDecisionNode childDecision : ((IDecisionBranch) repairDecision).getChildDecisions()) {
				addRepair(childDecision);
			}
		}
	}
	
	private void addRepair(EStructuralFeature feature, EObject object, ChangeAction repair) {

		// Per meta-class:
		Map<EObject, List<ChangeAction>> repairsOfFeature = repairs.get(feature);

		if (repairsOfFeature == null) {
			repairsOfFeature = new HashMap<>();
			repairs.put(feature, repairsOfFeature);
		}

		// Per repair:
		List<ChangeAction> repairsOfContext = repairsOfFeature.get(object);

		if (repairsOfContext == null) {
			repairsOfContext = new ArrayList<>(5);
			repairsOfFeature.put(object, repairsOfContext);
		}

		repairsOfContext.add(repair);

		// Store context element:
		scope.add(object);
	}

	public Map<EObject, List<ChangeAction>> getRepairActions(EStructuralFeature structuralFeature) {
		return repairs.get(structuralFeature);
	}
	
	@Override
	public Set<EObject> getScope() {
		return scope;
	}
	
	public boolean isObjectRepair(RepairType type, EReference containingReference, EClass objectType, boolean strict) {
		Map<EObject, List<ChangeAction>> repairsOfFeature = getRepairActions(containingReference);
		
		if (repairsOfFeature != null) {
			for (List<ChangeAction> repairsOfContext : repairsOfFeature.values()) {
				if (matchObjectRepair(repairsOfContext, type, containingReference, objectType, strict)) {
					return true;
				}
			}
		}
	
		return false;
	}

	public Iterator<EObject> getObjectRepairs(RepairType type, EReference containingReference, EClass objectType, boolean strict) {
		Map<EObject, List<ChangeAction>> repairsOfFeature = getRepairActions(containingReference);
		
		if (repairsOfFeature != null) {
			return repairsOfFeature.entrySet().stream()
					.filter(entry -> matchObjectRepair(entry.getValue(), type, containingReference, objectType, strict))
					.map(Map.Entry::getKey).iterator();
		} else {
			return Collections.emptyIterator();
		}
	}
	
	protected boolean matchObjectRepair(List<ChangeAction> repairs, RepairType type, EReference containingReference, EClass objectType, boolean strict) {
		for (ChangeAction repair : repairs) {
			if (repair instanceof ObjectChangeAction) {
				return ((ObjectChangeAction) repair).match(type, containingReference, objectType, strict);
			}
		}
		return false;
	}

	public boolean isStructuralFeatureRepair(RepairType type, EClass contextType, EStructuralFeature feature, boolean strict) {
		Map<EObject, List<ChangeAction>> repairsOfFeature = getRepairActions(feature);

		if (repairsOfFeature != null) {
			for (List<ChangeAction> repairsOfContext : repairsOfFeature.values()) {
				if (matchStructuralFeatureRepair(repairsOfContext, type, contextType, feature, strict)) {
					return true;
				}
			}
		}

		return false;
	}
	
	public Iterator<EObject> getStructuralFeatureRepairs(RepairType type, EClass contextType, EStructuralFeature feature, boolean strict) {
		Map<EObject, List<ChangeAction>> repairsOfFeature = getRepairActions(feature);
		
		if (repairsOfFeature != null) {
			return repairsOfFeature.entrySet().stream()
					.filter(entry -> matchStructuralFeatureRepair(entry.getValue(), type, contextType, feature, strict))
					.map(Map.Entry::getKey).iterator();
		} else {
			return Collections.emptyIterator();
		}
	}
	
	protected boolean matchStructuralFeatureRepair(List<ChangeAction> repairs, RepairType type, EClass contextType, EStructuralFeature feature, boolean strict) {
		for (ChangeAction repair : repairs) {
			if (repair instanceof StructuralFeatureChangeAction) {
				return ((StructuralFeatureChangeAction) repair).match(type, contextType, feature, strict);
			}
		}
		return false;
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
		
		Set<ChangeAction> repairSet = repairs.values().stream()
				.flatMap((objToRepairs) -> objToRepairs.values().stream())
				.flatMap(List::stream).collect(Collectors.toSet());
		
		for (ChangeAction changeAction : repairSet) {
			toString.append(" ");
			toString.append(changeAction);
			toString.append("\n");
		}
		
		return toString.toString();
	}
}

