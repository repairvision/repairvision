package org.sidiff.editrule.partialmatcher.complement;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.repair.api.matching.EditOperationMatching;
import org.sidiff.repair.validation.IConstraint;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.Repair;
import org.sidiff.repair.validation.fix.Repair.RepairType;
import org.sidiff.repair.validation.util.BatchValidationIterator;
import org.sidiff.repair.validation.util.Validation;
import org.sidiff.validation.constraint.library.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.library.util.ConstraintLibraryUtil;

public class AbstractRepairFilter {

	private Map<EClass, Map<EObject, List<Repair>>> repairs = new HashMap<>();
	
	private List<Validation> validations = new ArrayList<>();

	public AbstractRepairFilter(Resource model, boolean storeValidation) {
		List<IConstraint> consistencyRules = new ArrayList<>();
		
		for (String docType : EMFModelAccess.getDocumentTypes(model, Scope.RESOURCE)) {
			consistencyRules.addAll(ConstraintLibraryUtil.getConsistencyRules(
					ConstraintLibraryRegistry.getLibraries(docType)));
		}

		BatchValidationIterator validationIterator = new BatchValidationIterator(
				model, consistencyRules, false, true, false);

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

			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EClass sourceContextType = ((Edge) change).getSource().getType();
				EReference referenceType = ((Edge) change).getType();

				// Delete:
				if (change.getGraph().isLhs()) {
					if (isRepair(RepairType.DELETE, sourceContextType, referenceType)) {
						return true;
					}
					
					// Repair which deletes the root element of a validation:
					if (referenceType.isContainment() && (referenceType.getEOpposite() == null)) {
						EClass targetContextType = ((Edge) change).getTarget().getType();
						
						if (isRepair(RepairType.DELETE, targetContextType, referenceType)) {
							return true;
						}
					}
				}

				// Create:
				else if (change.getGraph().isRhs()) {
					if (isRepair(RepairType.ADD, sourceContextType, referenceType)) {
						return true;
					}
				}

				else {
					assert false : "We should never get here...!";
				}
			}
			
			else if (change instanceof Attribute) {
				EClass contextType = ((Attribute) change).getNode().getType();
				EAttribute attributeType = ((Attribute) change).getType();
				
				if (isRepair(RepairType.MODIFY, contextType, attributeType)) {
					return true;
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

			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EReference referenceType = ((Edge) change).getType();
				
				// Get the context object of the edge:
				Node sourceContextNode = getLHS(((Edge) change).getSource());
				EObject sourceContextObject = prematch.getMatch().getNodeTarget(sourceContextNode);
				
				if (sourceContextObject != null) {
					
					// Delete:
					if (change.getGraph().isLhs()) {
						if (isRepair(RepairType.DELETE, sourceContextObject, referenceType)) {
							return true;
						}
						
						// Repair which deletes the root element of a validation:
						if (referenceType.isContainment() && (referenceType.getEOpposite() == null)) {
							
							// Get the context object of the edge:
							Node targetContextNode = getLHS(((Edge) change).getTarget());
							EObject targetContextObject = prematch.getMatch().getNodeTarget(targetContextNode);
							
							if (isRepair(RepairType.DELETE, targetContextObject, referenceType)) {
								return true;
							}
						}
					}
					
					// Create:
					else if (change.getGraph().isRhs()) {
						if (isRepair(RepairType.ADD, sourceContextObject, referenceType)) {
							return true;
						}
					}
					
					else {
						assert false : "We should never get here...!";
					}
				}
			}
			
			else if (change instanceof Attribute) {
				EAttribute attributeType = ((Attribute) change).getType();
				
				// Get the context object of the edge:
				Node contextNode = getLHS(((Attribute) change).getNode());
				EObject contextObject = prematch.getMatch().getNodeTarget(contextNode);
				
				if (contextObject != null) {
					if (isRepair(RepairType.MODIFY, contextObject, attributeType)) {
						return true;
					}
				}
			}
		}

		return false;
	}
}
