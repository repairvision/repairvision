package org.sidiff.editrule.recognition.scope;

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
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.editrule.recognition.util.MatchingHelper;
import org.sidiff.validation.constraint.api.util.IValidationFilter;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.RepairValidationIterator;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionBranch;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;

public class RepairActionFilter {

	/**
	 * Type -> Context -> Repairs
	 */
	private Map<EStructuralFeature, Map<EObject, List<RepairAction>>> repairs = new HashMap<>();
	
	private List<RepairValidation> validations = new ArrayList<>();
	
	public RepairActionFilter(Collection<RepairValidation> validations) {
		for (RepairValidation validation : validations) {
			addRepair(validation.getRepair());
			this.validations.add(validation);
		}
	}
	
	public RepairActionFilter(Resource model, 
			List<IConstraint> consistencyRules, 
			IValidationFilter validationFilter, 
			boolean storeValidation) {

		RepairValidationIterator validationIterator = new RepairValidationIterator(
				model, consistencyRules, validationFilter, true);

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
		} else if (repairDecision instanceof IDecisionBranch) {
			for (IDecisionNode childDecision : ((IDecisionBranch) repairDecision).getChildDecisions()) {
				addRepair(childDecision);
			}
		}
	}
	
	public boolean isRepair(RepairType type, EObject context, EStructuralFeature feature) {
		Map<EObject, List<RepairAction>> repairsPerMetaClass = repairs.get(feature);

		if (repairsPerMetaClass != null) {
			List<RepairAction> repairsPerObject = repairsPerMetaClass.get(context);
			
			if (repairsPerObject != null) {
				for (RepairAction repair : repairsPerObject) {
					if (repair.getType().equals(RepairType.MODIFY) || repair.getType().equals(type)) {
						if (repair.getFeature().equals(feature)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public boolean isRepair(RepairType type, EStructuralFeature feature, EClass contextType, boolean strict) {
		Map<EObject, List<RepairAction>> repairsPerMetaClass = repairs.get(feature);

		if (repairsPerMetaClass != null) {
			for (List<RepairAction> repairsPerObject : repairsPerMetaClass.values()) {
				for (RepairAction repair : repairsPerObject) {
					if (repair.getType().equals(RepairType.MODIFY) || repair.getType().equals(type)) {
						if (repair.getFeature().equals(feature)) {
							EClass repairContextType = repair.getContext().eClass();
							
							if (!strict || contextType.equals(repairContextType)) {
								if (strict || MatchingHelper.isAssignableTo(repairContextType, contextType)) {
									return true;
								}
							}
						}
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
	 * @return <code>true</code> if the changes are potential repairs;
	 *         <code>false</code> otherwise.
	 */
	public boolean filter(Collection<GraphElement> changes, Match prematch) {

		for (GraphElement change : changes) {

			// Abstract repairs consider only edges and attributes:
			if (change instanceof Edge) {
				EReference referenceType = ((Edge) change).getType();
				
				// Get the context object of the edge:
				Node sourceContextNode = getLHS(((Edge) change).getSource());
				EObject sourceContextObject = prematch.getNodeTarget(sourceContextNode);
				
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
							EObject targetContextObject = prematch.getNodeTarget(targetContextNode);
							
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
				EObject contextObject = prematch.getNodeTarget(contextNode);
				
				if (contextObject != null) {
					if (isRepair(RepairType.MODIFY, contextObject, attributeType)) {
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
				EReference referenceType = ((Edge) change).getType();
				EClass sourceContextType = ((Edge) change).getSource().getType();
				boolean strictContextType = isStrictMatchingType(((Edge) change).getSource());
					
				// Delete:
				if (change.getGraph().isLhs()) {
					if (isRepair(RepairType.DELETE, referenceType, sourceContextType, strictContextType)) {
						return true;
					}

					// Repair which deletes the root element of a validation:
					if (referenceType.isContainment() && (referenceType.getEOpposite() == null)) {
						EClass targetContextType = ((Edge) change).getTarget().getType();
						boolean strictTargetContextType = isStrictMatchingType(((Edge) change).getTarget());

						if (isRepair(RepairType.DELETE, referenceType, targetContextType, strictTargetContextType)) {
							return true;
						}
					}
				}

				// Create:
				else if (change.getGraph().isRhs()) {
					if (isRepair(RepairType.CREATE, referenceType, sourceContextType, strictContextType)) {
						return true;
					}
				}

				else {
					assert false : "We should never get here...!";
				}
			}
			
			else if (change instanceof Attribute) {
				EAttribute attributeType = ((Attribute) change).getType();
				EClass contextType = ((Attribute) change).getNode().getType();
				boolean strictContextType = isStrictMatchingType(((Attribute) change).getNode());
				
				if (isRepair(RepairType.MODIFY, attributeType, contextType, strictContextType)) {
					return true;
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
				EReference referenceType = ((Edge) change).getType();
				EClass sourceContextType = ((Edge) change).getSource().getType();
				boolean strictContextType = isStrictMatchingType(((Edge) change).getSource());

				// Delete:
				if (change.getGraph().isLhs()) {
					buildScope(RepairType.DELETE, referenceType, sourceContextType, strictContextType, change, scope);
					
					// Repair which deletes the context element of a validation:
					if (referenceType.isContainment() && (referenceType.getEOpposite() == null)) {
						EClass targetContextType = ((Edge) change).getTarget().getType();
						boolean strictTargetContextType = isStrictMatchingType(((Edge) change).getTarget());
						
						buildScope(RepairType.DELETE, referenceType, targetContextType, strictTargetContextType, change, scope);
					}
				}

				// Create:
				else if (change.getGraph().isRhs()) {
					buildScope(RepairType.CREATE, referenceType, sourceContextType, strictContextType, change, scope);
				}

				else {
					assert false : "We should never get here...!";
				}
			}
			
			else if (change instanceof Attribute) {
				EAttribute attributeType = ((Attribute) change).getType();
				EClass contextType = ((Attribute) change).getNode().getType();
				boolean strictContextType = isStrictMatchingType(((Attribute) change).getNode());
				
				buildScope(RepairType.MODIFY, attributeType, contextType, strictContextType, change, scope);
			}
		}

		return scope;
	}
	
	private void buildScope(
			RepairType type, EStructuralFeature feature, EClass contextType, boolean strict,
			GraphElement change, RepairScope scope) {
		
		Map<EObject, List<RepairAction>> repairsPerMetaClass = repairs.get(feature);

		if (repairsPerMetaClass != null) {
			for (List<RepairAction> repairsPerObject : repairsPerMetaClass.values()) {
				for (RepairAction repair : repairsPerObject) {
					if (repair.getType().equals(RepairType.MODIFY) || repair.getType().equals(type)) {
						if (repair.getFeature().equals(feature)) {
							EClass repairContextType = repair.getContext().eClass();
							
							if (!strict || contextType.equals(repairContextType)) {
								if (strict || MatchingHelper.isAssignableTo(repairContextType, contextType)) {
									scope.add(change, repair.getContext());
								}
							}
						}
					}
				}
			}
		}
	}
	
	private boolean isStrictMatchingType(Node node) {
		return !(node.getType().isAbstract() || node.getType().isInterface()) && HenshinRuleAnalysisUtilEx.isCreationNode(node);
	}
}
