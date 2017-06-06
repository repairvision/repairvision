package org.sidiff.editrule.partialmatcher.scope;

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
import org.sidiff.consistency.common.emf.DocumentType;
import org.sidiff.repair.api.matching.EditOperationMatching;
import org.sidiff.repair.validation.IConstraint;
import org.sidiff.repair.validation.fix.IRepairDecision;
import org.sidiff.repair.validation.fix.RepairAction;
import org.sidiff.repair.validation.fix.RepairAction.RepairType;
import org.sidiff.validation.constraint.api.library.ConstraintLibraryRegistry;
import org.sidiff.validation.constraint.api.library.util.ConstraintLibraryUtil;
import org.sidiff.validation.constraint.api.util.BatchValidationIterator;
import org.sidiff.validation.constraint.api.util.Validation;

public class RepairActionFilter {

	private Map<EClass, Map<EObject, List<RepairAction>>> repairs = new HashMap<>();
	
	private List<Validation> validations = new ArrayList<>();

	public RepairActionFilter(Resource model, boolean storeValidation) {
		List<IConstraint> consistencyRules = ConstraintLibraryUtil.getConsistencyRules(
				ConstraintLibraryRegistry.getLibraries(DocumentType.getDocumentType(model)));

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
		if (repairDecision instanceof RepairAction) {
			EObject context = ((RepairAction) repairDecision).getContext();

			// Per meta-class:
			Map<EObject, List<RepairAction>> repairsPerMetaClass = repairs.get(context.eClass());

			if (repairsPerMetaClass == null) {
				repairsPerMetaClass = new HashMap<>();
				repairs.put(context.eClass(), repairsPerMetaClass);
			}

			// Per repair:
			List<RepairAction> repairsPerObject = repairsPerMetaClass.get(context);

			if (repairsPerObject == null) {
				repairsPerObject = new ArrayList<>(5);
				repairsPerMetaClass.put(context, repairsPerObject);
			}

			repairsPerObject.add((RepairAction) repairDecision);
		} else {
			for (IRepairDecision childDecision : repairDecision.getChildDecisions()) {
				addRepair(childDecision);
			}
		}
	}
	
	public boolean isRepair(RepairType type, EObject context, EStructuralFeature feature) {
		Map<EObject, List<RepairAction>> repairsPerMetaClass = repairs.get(context.eClass());

		if (repairsPerMetaClass != null) {
			List<RepairAction> repairsPerObject = repairsPerMetaClass.get(context);
			
			if (repairsPerObject != null) {
				for (RepairAction repair : repairsPerObject) {
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
		Map<EObject, List<RepairAction>> repairsPerMetaClass = repairs.get(contextType);

		if (repairsPerMetaClass != null) {
			for (List<RepairAction> repairsPerObject : repairsPerMetaClass.values()) {
				for (RepairAction repair : repairsPerObject) {
					if ((repair.getType().equals(RepairType.MODIFY) || repair.getType().equals(type))
							&& (repair.getFeature().equals(feature))) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean isRepair(
			RepairType type, EClass contextType, EStructuralFeature feature, 
			GraphElement change, RepairScope scope) {
		
		Map<EObject, List<RepairAction>> repairsPerMetaClass = repairs.get(contextType);
		boolean isRepair = false;
		
		if (repairsPerMetaClass != null) {
			for (List<RepairAction> repairsPerObject : repairsPerMetaClass.values()) {
				for (RepairAction repair : repairsPerObject) {
					if ((repair.getType().equals(RepairType.MODIFY) || repair.getType().equals(type))
							&& (repair.getFeature().equals(feature))) {
						isRepair = true;
						scope.add(change, repair.getContext());
					}
				}
			}
		}

		return isRepair;
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
					if (isRepair(RepairType.CREATE, sourceContextType, referenceType)) {
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
						if (isRepair(RepairType.CREATE, sourceContextObject, referenceType)) {
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
	
	public RepairScope getScope(Collection<GraphElement> changes) {
		RepairScope scope = new RepairScope();

		for (GraphElement change : changes) {

			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EClass sourceContextType = ((Edge) change).getSource().getType();
				EReference referenceType = ((Edge) change).getType();

				// Delete:
				if (change.getGraph().isLhs()) {
					isRepair(RepairType.DELETE, sourceContextType, referenceType, change, scope);
					
					// Repair which deletes the root element of a validation:
					if (referenceType.isContainment() && (referenceType.getEOpposite() == null)) {
						EClass targetContextType = ((Edge) change).getTarget().getType();
						isRepair(RepairType.DELETE, targetContextType, referenceType, change, scope);
					}
				}

				// Create:
				else if (change.getGraph().isRhs()) {
					isRepair(RepairType.CREATE, sourceContextType, referenceType, change, scope);
				}

				else {
					assert false : "We should never get here...!";
				}
			}
			
			else if (change instanceof Attribute) {
				EClass contextType = ((Attribute) change).getNode().getType();
				EAttribute attributeType = ((Attribute) change).getType();
				isRepair(RepairType.MODIFY, contextType, attributeType, change, scope);
			}
		}

		return scope;
	}
}
