package org.sidiff.consistency.repair.lifting.complement;

import static org.sidiff.consistency.repair.validation.test.library.ConsistencyRuleLibrary.getConsistencyRuleLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
import org.sidiff.consistency.repair.validation.fix.Repair;
import org.sidiff.consistency.repair.validation.fix.Repair.RepairType;
import org.sidiff.consistency.repair.validation.test.library.ConsistencyRuleLibrary;
import org.sidiff.consistency.repair.validation.util.BatchValidationIterator;

public class AbstractRepairFilter {

	private Map<EObject, List<Repair>> repairs = new HashMap<>();
	
	public AbstractRepairFilter(Resource model) {
		ConsistencyRuleLibrary cruleLibrary = getConsistencyRuleLibrary(EMFModelAccess.getDocumentType(model));
		
		BatchValidationIterator validationIterator = 
				new BatchValidationIterator(model, cruleLibrary.getConsistencyRules());
		validationIterator.setShowPositiveResults(false);
		validationIterator.setCleanupRepairTree(false);
		
		// Collect all abstract repair actions:
		validationIterator.forEachRemaining(validation -> {
			addRepair(validation.getRepair());
		});
	}
	
	private void addRepair(IRepairDecision root) {
		
		for (IRepairDecision child : root.getChildDecisions()) {
			if (child instanceof Repair) {
				EObject context = ((Repair) child).getContext();
				List<Repair> repairsPerObject = repairs.get(context);
				
				if (repairsPerObject == null) {
					repairsPerObject = new ArrayList<>(5);
					repairs.put(context, repairsPerObject);
				}
				
				repairsPerObject.add((Repair) child);
			} else {
				addRepair(child);
			}
		}
	}
	
	public boolean isRepair(RepairType type, EObject context, EStructuralFeature feature) {
		List<Repair> repairsPerObject = repairs.get(context);
		
		if (repairsPerObject != null) {
			for (Repair repair : repairsPerObject) {
				if (repair.getType().equals(type) && (repair.getFeature().equals(feature))) {
					return true;
				}
			}
		}
		
		return false;
	}
}
