package org.sidiff.repair.history.evaluation.oracle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.history.revision.IRevision;
import org.sidiff.repair.api.util.ComplementMatching;
import org.sidiff.repair.api.util.IMatching;
import org.sidiff.repair.api.util.RecognitionMatching;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.impact.PositiveImpactAnalysis;
import org.sidiff.validation.constraint.impact.index.RepairActionIndex;

public class DeveloperIntentionOracle {

	private IRevision currentToResolvedRevision;

	private Set<String> currentToResolvedSignatures;
	
	private Set<String> currentToResolvedContextSignatures;
	
	private boolean matchContext = true;
	
	public DeveloperIntentionOracle(IRevision currentToResolvedRevision) {
		this.currentToResolvedRevision = currentToResolvedRevision;
		
		SymmetricDifference diff = currentToResolvedRevision.getDifference().getSymmetricDifference();
		this.currentToResolvedSignatures = toChangeSignatures(diff);
		this.currentToResolvedContextSignatures = toChangeContextSignatures(diff);
	}
	
	public boolean isHistoricallyObservableUndo(
			RecognitionMatching recognitionMatching,
			Collection<RepairValidation> repairTrees) {
		
		return isHistoricallyObservable(recognitionMatching, repairTrees, true);
	}

	public boolean isHistoricallyObservableRepair(
			ComplementMatching complementMatching,
			Collection<RepairValidation> repairTrees) {
		
		return isHistoricallyObservable(complementMatching, repairTrees, false);
	}
	
	public boolean isHistoricallyObservable(
			IMatching editRuleMatching, Collection<RepairValidation> repairTrees, boolean invertActions) {

		// We check if all action-induced low level changes can be observed
		List<GraphElement> observableChanges = findObservableChanges(editRuleMatching, invertActions);
		
		// NOTE: findObservableChanges() returns null if one change is NOT observable.
		if ((observableChanges == null) || (observableChanges.isEmpty())) {
			return false;
		}

		// NOTE: Since attribute changes are optional -> re-check repair tree overlapping for observable changes:
		PositiveImpactAnalysis impact = new PositiveImpactAnalysis(new RepairActionIndex(repairTrees));
		
		for (GraphElement repairAction : observableChanges) {
			if (repairAction instanceof Attribute) {
				for (EObject match : (Iterable<EObject>) () -> editRuleMatching.getMatches(((Attribute) repairAction).getNode())) {
					if (impact.onModify(match, ((Attribute) repairAction).getType())) {
						return true;
					}
				}
			}
			
			if (repairAction instanceof Edge) {
				Node sourceNode = ChangePatternUtil.tryLHS(((Edge) repairAction).getSource());
				
				if (sourceNode.getGraph().isLhs()) {
					for (EObject match : (Iterable<EObject>) () -> editRuleMatching.getMatches(sourceNode)) {
						if (impact.onDelete(match, ((Edge) repairAction).getType())) {
							return true;
						}
					}
				}
			}
		}

		// All right, observable
		return true;
	}
	
	private List<GraphElement> findObservableChanges(IMatching editRuleMatching, boolean invertActions) {
		List<GraphElement> observableChanges = new ArrayList<>();
		
		for (GraphElement repairAction : editRuleMatching.getChanges()) {
			if (repairAction instanceof Node) {
				Node node = (Node) repairAction;
				
				if (repairAction.getGraph().isLhs()) {
					
					// Delete nodes:
					if (isObservableRemoveObject(node, editRuleMatching, invertActions)) {
						observableChanges.add(node);
					} else {
						return null;
					}
				} else if (repairAction.getGraph().isRhs()) {

					// Create nodes:
					if (isObservableAddObject(node, editRuleMatching, invertActions)) {
						observableChanges.add(node);
					} else {
						return null;
					}
				}
			} else if (repairAction instanceof Edge) {
				Edge edge = (Edge) repairAction;
				
				if (repairAction.getGraph().isLhs()) {
					
					// Delete edges:
					if (isObservableRemoveReference(edge, editRuleMatching, invertActions)) {
						observableChanges.add(edge);
					} else {
						return null;
					}
				} else if (repairAction.getGraph().isRhs()) {
					
					// Create edges:
					if (isObservableAddReference(edge, editRuleMatching, invertActions)) {
						observableChanges.add(edge);
					} else {
						return null;
					}
				}
			} else if (repairAction instanceof Attribute) {
				Attribute attribute = (Attribute) repairAction;
				
				// Attribute value change:
				if (isObservableAttributeValueChange(attribute, editRuleMatching, invertActions)) {
					observableChanges.add(attribute);
				}
			}
		}
		
		// => We found all change actions in the low-level difference!
		return observableChanges;
	}
	
	private boolean isObservableRemoveObject(Node node, IMatching editRuleMatching, boolean invertActions) {
		Iterator<EObject> matches = editRuleMatching.getMatches(node);
		
		if (!matchContext || !matches.hasNext()) {
			List<String> signatures = getRemoveObjectSignatures(node.getType(), invertActions);
			
			if (exists(signatures)) {
				return true;
			}
		} else {
			for (EObject match : (Iterable<EObject>) () -> matches) {
				List<String> signatures = getRemoveObjectSignatures(node.getType(), match, invertActions);
				
				if (exists(signatures)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isObservableAddObject(Node node, IMatching editRuleMatching, boolean invertActions) {
		Iterator<EObject> matches = editRuleMatching.getMatches(node);
		
		if (!matchContext || !matches.hasNext()) {
			List<String> signatures = getAddObjectSignatures(node.getType(), invertActions);
			
			if (exists(signatures)) {
				return true;
			}
		} else {
			for (EObject match : (Iterable<EObject>) () -> matches) {
				List<String> signatures = getAddObjectSignatures(node.getType(), match, invertActions);
				
				if (exists(signatures)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isObservableAddReference(Edge edge, IMatching editRuleMatching, boolean invertActions) {
		Iterator<EObject> matches = editRuleMatching.getMatches(edge.getSource());
		
		if (!matchContext || !matches.hasNext()) {
			String signatures = getAddReferenceSignature(edge.getType(), invertActions);
			
			if (exists(signatures)) {
				return true;
			}
		} else {
			for (EObject match : (Iterable<EObject>) () -> matches) {
				String signatures = getAddReferenceSignature(edge.getType(), 
						match,
						null,  // TODO: Consider reference target!
						invertActions);
				
				if (exists(signatures)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isObservableRemoveReference(Edge edge, IMatching editRuleMatching, boolean invertActions) {
		Iterator<EObject> matches = editRuleMatching.getMatches(edge.getSource());
		
		if (!matchContext || !matches.hasNext()) {
			String signatures = getRemoveReferenceSignature(edge.getType(), invertActions);
			
			if (exists(signatures)) {
				return true;
			}
		} else {
			for (EObject match : (Iterable<EObject>) () -> matches) {
				String signatures = getRemoveReferenceSignature(edge.getType(), 
						match,
						null,  // TODO: Consider reference target!
						invertActions);
				
				if (exists(signatures)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isObservableAttributeValueChange(Attribute attribute, IMatching editRuleMatching, boolean invertActions) {

		// Check if the containing node is created or deleted:
		if (isObservableAddObject(attribute.getNode(), editRuleMatching, invertActions)) {
			return true;
		} else {
			Iterator<EObject> matches = editRuleMatching.getMatches(attribute.getNode());
			
			if (!matchContext || !matches.hasNext()) {
				String signatures = getAttributeValueChangeSignature(attribute.getType(), invertActions);
				
				if (exists(signatures)) {
					return true;
				}
			} else {
				for (EObject match : (Iterable<EObject>) () -> matches) {
					String signatures = getAttributeValueChangeSignature(
							attribute.getType(), 
							match, 
							invertActions);
					
					if (exists(signatures)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean exists(String changeSignature) {
		return currentToResolvedSignatures.contains(changeSignature) 
				|| currentToResolvedContextSignatures.contains(changeSignature);
	}
	
	private boolean exists(Collection<String> changeSignatures) {
		return changeSignatures.stream().filter(currentToResolvedSignatures::contains).findAny().isPresent()
				|| changeSignatures.stream().filter(currentToResolvedContextSignatures::contains).findAny().isPresent();
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
	
	private Set<String> toChangeContextSignatures(SymmetricDifference difference) {
		Set<String> changeSignatures = new HashSet<>();
		
		// Create change signature with context on model A: 
		for (Change change : difference.getChanges()) {
			String signature = null;

			// NOTE: AddObject can not be observed on model A.
			
			if (change instanceof RemoveObject) {
				RemoveObject c = (RemoveObject) change;
				signature = getRemoveObjectSignature(c.getObj().eClass(), c.getObj(), false);
			}
			if (change instanceof AddReference) {
				AddReference c = (AddReference) change;
				signature = getAddReferenceSignature(c.getType(), 
						difference.getCorrespondingObjectInA(c.getSrc()), 
						difference.getCorrespondingObjectInA(c.getTgt()),
						false);
			}
			if (change instanceof RemoveReference) {
				RemoveReference c = (RemoveReference) change;
				signature = getRemoveReferenceSignature(c.getType(), c.getSrc(), c.getTgt(), false);
			}
			if (change instanceof AttributeValueChange) {
				AttributeValueChange c = (AttributeValueChange) change;
				signature = getAttributeValueChangeSignature(c.getType(), c.getObjA(), false);
			}
			
			if (signature != null) {
				changeSignatures.add(signature);
			}
		}
		
		return changeSignatures;
	}
	
	private String getAddObjectSignature(EClass type, boolean invert) {
		return getAddObjectSignature(type, null, invert);
	}
	
	private String getAddObjectSignature(EClass type, EObject obj, boolean invert) {
		if (!invert) {
			return  "AddObject_" + getContext(obj) + type.getName();
		} else {
			return getRemoveObjectSignature(type, obj, false);
		}
	}
	
	private List<String> getAddObjectSignatures(EClass type, boolean invert) {
		return getAddObjectSignatures(type, null, invert);
	}
	
	private List<String> getAddObjectSignatures(EClass type, EObject obj, boolean invert) {
		if (!invert) {
			List<String> signatures = new ArrayList<>();
			
			// All concrete type replacements:
			if (type.isAbstract()) {
				for (EClass subtype : currentToResolvedRevision.getMetaModel().getAllSubTypes(type)) {
					if (!subtype.isAbstract()) {
						signatures.add(getAddObjectSignature(subtype, obj, false));
					}
				}
			} else {
				signatures.add(getAddObjectSignature(type, obj, false));
			}
			
			return signatures;
		} else {
			return getRemoveObjectSignatures(type, obj, false);
		}
	}
	
	private String getRemoveObjectSignature(EClass type, boolean invert) {
		return getRemoveObjectSignature(type, null, invert);
	}

	private String getRemoveObjectSignature(EClass type, EObject obj, boolean invert) {
		if (!invert) {
			return  "RemoveObject_" + getContext(obj) + type.getName();
		} else {
			return getAddObjectSignature(type, obj, false);
		}
	}
	
	private List<String> getRemoveObjectSignatures(EClass type, boolean invert) {
		return getRemoveObjectSignatures(type, null, invert);
	}
	
	private List<String> getRemoveObjectSignatures(EClass type, EObject obj, boolean invert) {
		if (!invert) {
			List<String> signatures = new ArrayList<>();
			
			// All concrete type replacements:
			if (type.isAbstract()) {
				for (EClass subtype : currentToResolvedRevision.getMetaModel().getAllSubTypes(type)) {
					if (!subtype.isAbstract()) {
						signatures.add(getRemoveObjectSignature(subtype, obj, false));
					}
				}
			} else {
				signatures.add(getRemoveObjectSignature(type, obj, false));
			}
			
			return signatures;
		} else {
			return getAddObjectSignatures(type, obj, false);
		}
	}
	
	private String getAddReferenceSignature(EReference type, boolean invert) {
		return getAddReferenceSignature(type, null, null, invert);
	}
	
	private String getAddReferenceSignature(EReference type, EObject src, EObject tgt, boolean invert) {
		if (!invert) {
			return  "AddReference_" + getContext(src) + type.getName();
//			return  "AddReference_" + getContext(src) + getContext(tgt) + type.getName(); // TODO: Consider reference target!
		} else {
			return getRemoveReferenceSignature(type, src, tgt, false);
		}
	}
	
	private String getRemoveReferenceSignature(EReference type, boolean invert) {
		return getRemoveReferenceSignature(type, null, null, invert);
	}
	
	private String getRemoveReferenceSignature(EReference type, EObject src, EObject tgt, boolean invert) {
		if (!invert) {
			return  "RemoveReference_" + getContext(src) + type.getName();
//			return  "RemoveReference_" + getContext(src) + getContext(tgt) + type.getName(); // TODO: Consider reference target!
		} else {
			return getAddReferenceSignature(type, src, tgt, false);
		}
	}
	
	private String getAttributeValueChangeSignature(EAttribute type, boolean invert) {
		return getAttributeValueChangeSignature(type, null, invert);
	}
	
	private String getAttributeValueChangeSignature(EAttribute type, EObject obj, boolean invert) {
		return "AttributeValueChange_" + getContext(obj) + type.getName();
	}
	
	private String getContext(EObject obj) {
		if (obj != null) {
			return obj.eResource().getURIFragment(obj) + "_";
		} else {
			return "";
		}
	}
}
