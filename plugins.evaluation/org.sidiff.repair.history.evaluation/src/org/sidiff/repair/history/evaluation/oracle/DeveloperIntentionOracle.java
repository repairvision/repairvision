package org.sidiff.repair.history.evaluation.oracle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.recognition.impact.GraphActionImpactUtil;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.impact.PositiveImpactAnalysis;
import org.sidiff.validation.constraint.impact.index.RepairActionIndex;

public class DeveloperIntentionOracle {

	private Set<String> currentToResolvedSignatures;
	
	public DeveloperIntentionOracle(SymmetricDifference currentToResolvedDifference) {
		this.currentToResolvedSignatures = toChangeSignatures(currentToResolvedDifference);
	}
	
	public boolean isHistoricallyObservableUndo(
			List<GraphElement> recognizedChanges, List<Match> matches,
			Collection<RepairValidation> repairTrees) {
		
		return isHistoricallyObservable(recognizedChanges, matches, repairTrees, true);
	}

	public boolean isHistoricallyObservableRepair(
			List<GraphElement> complementingChanges, List<Match> matches,
			Collection<RepairValidation> repairTrees) {
		
		return isHistoricallyObservable(complementingChanges, matches, repairTrees, false);
	}
	
	public boolean isHistoricallyObservable(
			List<GraphElement> repair, List<Match> matches, 
			Collection<RepairValidation> repairTrees, boolean invertActions) {

		// We check if all action-induced low level changes can be observed
		List<GraphElement> observableChanges = findObservableChanges(repair, currentToResolvedSignatures, invertActions);
		
		if (observableChanges == null) {
			return false;
		}

		// NOTE: Since attribute changes are optional -> re-check repair tree overlapping for observable changes:
		PositiveImpactAnalysis impact = new PositiveImpactAnalysis(new RepairActionIndex(repairTrees));
		
		for (Match preMatch : matches) {
			if (GraphActionImpactUtil.real(impact, observableChanges, preMatch)) {
				return true;
			}
		}

		// All right, observable
		return true;
	}
	
	private Set<String> toChangeSignatures(SymmetricDifference difference) {
		Set<String> changeSignatures = new HashSet<>();
		
		for (Change change : difference.getChanges()) {
			String signature = null;
			
			if (change instanceof AddObject) {
				AddObject c = (AddObject) change;
				signature = getAddObjectSignature(c.getObj().eClass(), false);
			}
			if (change instanceof RemoveObject) {
				RemoveObject c = (RemoveObject) change;
				signature = getRemoveObjectSignature(c.getObj().eClass(), false);
			}
			if (change instanceof AddReference) {
				AddReference c = (AddReference) change;
				signature = getAddReferenceSignature(c.getType(), false);
			}
			if (change instanceof RemoveReference) {
				RemoveReference c = (RemoveReference) change;
				signature = getRemoveReferenceSignature(c.getType(), false);
			}
			if (change instanceof AttributeValueChange) {
				AttributeValueChange c = (AttributeValueChange) change;
				signature = getAttributeValueChangeSignature(c.getType(), false);
			}
			
			if (signature != null) {
				changeSignatures.add(signature);
			}
		}
		
		return changeSignatures;
	}

	private List<GraphElement> findObservableChanges(List<GraphElement> repair, Set<String> difference, boolean invertActions) {
		List<GraphElement> observableChanges = new ArrayList<>();
		
		for (GraphElement repairAction : repair) {
			if (repairAction instanceof Node) {
				Node node = (Node) repairAction;
				
				if (repairAction.getGraph().isLhs()) {

					// Delete nodes:
					String signature = getRemoveObjectSignature(node.getType(), invertActions);
					
					if (difference.contains(signature)) {
						observableChanges.add(node);
					} else {
						return null;
					}
				} else if (repairAction.getGraph().isRhs()) {

					// Create nodes:
					String signature = getAddObjectSignature(node.getType(), invertActions);
					
					if (difference.contains(signature)) {
						observableChanges.add(node);
					} else {
						return null;
					}
				}
			} else if (repairAction instanceof Edge) {
				Edge edge = (Edge) repairAction;
				
				if (repairAction.getGraph().isLhs()) {
					
					// Delete edges:
					String signature = getRemoveReferenceSignature(edge.getType(), invertActions);
					
					if (difference.contains(signature)) {
						observableChanges.add(edge);
					} else {
						return null;
					}
				} else if (repairAction.getGraph().isRhs()) {
					
					// Create edges:
					String signature = getAddReferenceSignature(edge.getType(), invertActions);
					
					if (difference.contains(signature)) {
						observableChanges.add(edge);
					} else {
						return null;
					}
				}
			} else if (repairAction instanceof Attribute) {
				Attribute attribute = (Attribute) repairAction;
				
				// Is fix value change?
				if (attribute.getGraph().getRule().getParameter(attribute.getValue()) == null) {
					String signature = getAttributeValueChangeSignature(attribute.getType(), invertActions);
					
					if (!difference.contains(signature)) {
						return null;
					}
				}
				
				// NOTE: Variable attribute changes are optional.
				observableChanges.add(attribute);
			}
		}
		
		// => We found all change actions in the low-level difference!
		return observableChanges;
	}
	
	
	private String getAddObjectSignature(EClass type, boolean invert) {
		if (!invert) {
			return  "AddObject_" + type.getName();
		} else {
			return getRemoveObjectSignature(type, false);
		}
	}
	
	private String getRemoveObjectSignature(EClass type, boolean invert) {
		if (!invert) {
			return  "RemoveObject_" + type.getName();
		} else {
			return getAddObjectSignature(type, false);
		}
	}
	
	private String getAddReferenceSignature(EReference type, boolean invert) {
		if (!invert) {
			return  "AddReference_" + type.getName();
		} else {
			return getRemoveReferenceSignature(type, false);
		}
	}
	
	private String getRemoveReferenceSignature(EReference type, boolean invert) {
		if (!invert) {
			return  "RemoveReference_" + type.getName();
		} else {
			return getAddReferenceSignature(type, false);
		}
	}
	
	private String getAttributeValueChangeSignature(EAttribute type, boolean invert) {
		return "AttributeValueChange_" + type.getName();
	}
}
