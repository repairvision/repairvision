package org.sidiff.repair.complement.peo.finder;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;
import static org.sidiff.repair.validation.test.library.ConsistencyRuleLibrary.getConsistencyRuleLibrary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.repair.api.matching.EditOperationMatching;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.test.library.ConsistencyRuleLibrary;
import org.sidiff.repair.validation.util.BatchValidationIterator;
import org.sidiff.repair.validation.util.Validation;

public class AbstractRepairFilter {

	private Map<EClass, Map<EObject, List<Repair>>> repairs = new HashMap<>();
	
	private List<Validation> validations = new ArrayList<>();

	public AbstractRepairFilter(Resource model, boolean storeValidation) {
		ConsistencyRuleLibrary cruleLibrary = getConsistencyRuleLibrary(EMFModelAccess.getDocumentType(model));

		BatchValidationIterator validationIterator = new BatchValidationIterator(model,
				cruleLibrary.getConsistencyRules(), false, true, false);

		// Collect all abstract repair actions:
		validationIterator.forEachRemaining(validation -> {
			if (!validation.getResult()) {
				addRepair(validation.getRepair());
				
				if (storeValidation) {
					validations.add(validation);
				}
			}
		});
	}
	
	public List<Validation> getValidations() {
		return validations;
	}

	private void addRepair(IRepairDecision repairDecision) {
		if (repairDecision instanceof Repair) {
			EObject context = ((Repair) repairDecision).getContext();

			// Per meta-class:
			Map<EObject, List<Repair>> repairsPerMetaClass = repairs.get(context.eClass());

			if (repairsPerMetaClass == null) {
				repairsPerMetaClass = new HashMap<>();
				repairs.put(context.eClass(), repairsPerMetaClass);
			}

			// Per repair:
			List<Repair> repairsPerObject = repairsPerMetaClass.get(context);

			if (repairsPerObject == null) {
				repairsPerObject = new ArrayList<>(5);
				repairsPerMetaClass.put(context, repairsPerObject);
			}

			repairsPerObject.add((Repair) repairDecision);
		} else {
			for (IRepairDecision childDecision : repairDecision.getChildDecisions()) {
				addRepair(childDecision);
			}
		}
	}
	
	public boolean isRepair(RepairType type, EObject context, EStructuralFeature feature) {
		Map<EObject, List<Repair>> repairsPerMetaClass = repairs.get(context.eClass());

		if (repairsPerMetaClass != null) {
			List<Repair> repairsPerObject = repairsPerMetaClass.get(context);
			
			if (repairsPerObject != null) {
				for (Repair repair : repairsPerObject) {
					if ((repair.getType().equals(RepairType.MODIFY) || repair.getType().equals(type)) 
							&& (repair.getFeature().equals(feature))) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean isRepair(RepairType type, EClass contextType, EStructuralFeature feature) {
		Map<EObject, List<Repair>> repairsPerMetaClass = repairs.get(contextType);

		if (repairsPerMetaClass != null) {
			for (List<Repair> repairsPerObject : repairsPerMetaClass.values()) {
				for (Repair repair : repairsPerObject) {
					if ((repair.getType().equals(RepairType.MODIFY) || repair.getType().equals(type))
							&& (repair.getFeature().equals(feature))) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * Checks if the set of changes contains at least one abstract repair.
	 * 
	 * @param changes
	 *            The set of changes to test
	 * @return <code>true</code> if the complement rule is a potential repair;
	 *         <code>false</code> otherwise.
	 */
	public boolean filter(Collection<GraphElement> changes) {

		for (GraphElement change : changes) {

			// Abstract repairs only consider edges:
			if (change instanceof Edge) {
				Node contextNode = ((Edge) change).getSource();

				// Delete:
				if (change.getGraph().isLhs()) {
					if (isRepair(RepairType.DELETE, contextNode.getType(), ((Edge) change).getType())) {
						return true;
					}
				}

				// Create:
				else if (change.getGraph().isRhs()) {
					if (isRepair(RepairType.ADD, contextNode.getType(), ((Edge) change).getType())) {
						return true;
					}
				}

				else {
					assert false : "We should never get here...!";
				}
			}
		}

		return false;
	}
	
	/**
	 * Checks if the set of changes contains at least one abstract repair.
	 * 
	 * @param changes
	 *            The set of changes to test
	 * @return <code>true</code> if the complement rule is a potential repair;
	 *         <code>false</code> otherwise.
	 */
	public boolean filter(Collection<GraphElement> changes, EditOperationMatching prematch) {

		for (GraphElement change : changes) {

			// Abstract repairs only consider edges:
			if (change instanceof Edge) {
				
				// Get the context node of the edge:
				Node contextNode = getLHS(((Edge) change).getSource());
				
				if (contextNode == null) {
					contextNode = getLHS(((Edge) change).getTarget());
				}
				
				// Get the context object of the edge:
				EObject contextObject = prematch.getMatch().getNodeTarget(contextNode);
				
				if (contextObject != null) {
					
					// Delete:
					if (change.getGraph().isLhs()) {
						if (isRepair(RepairType.DELETE, contextObject, ((Edge) change).getType())) {
							return true;
						}
					}
					
					// Create:
					else if (change.getGraph().isRhs()) {
						if (isRepair(RepairType.ADD, contextObject, ((Edge) change).getType())) {
							return true;
						}
					}
					
					else {
						assert false : "We should never get here...!";
					}
				}

			}
		}

		return false;
	}
}
