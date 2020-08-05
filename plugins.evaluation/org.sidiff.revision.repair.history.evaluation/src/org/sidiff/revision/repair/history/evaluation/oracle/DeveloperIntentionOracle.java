package org.sidiff.revision.repair.history.evaluation.oracle;

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
import org.sidiff.graphpattern.attributes.JavaSciptParser;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.api.util.ComplementMatching;
import org.sidiff.revision.api.util.IMatching;
import org.sidiff.revision.api.util.RecognitionMatching;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.repair.impact.RepairActionImpactScope;
import org.sidiff.revision.repair.impact.positive.PositiveImpactAnalysis;
import org.sidiff.validation.constraint.api.util.RepairValidation;

public class DeveloperIntentionOracle {

	private IRevision currentToResolvedRevision;

	private Set<String> currentToResolvedSignatures;
	
	private Set<String> currentToResolvedContextSignatures;
	
	private boolean matchContext = true;
	
	public DeveloperIntentionOracle(IRevision currentToResolvedRevision) {
		this.currentToResolvedRevision = currentToResolvedRevision;
		
		Difference diff = currentToResolvedRevision.getDifference().getSymmetricDifference();
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
		PositiveImpactAnalysis impact = new PositiveImpactAnalysis(new RepairActionImpactScope(repairTrees));
		
		for (GraphElement repairAction : observableChanges) {
			if (repairAction instanceof Attribute) {
				for (EObject match : (Iterable<EObject>) () -> editRuleMatching.getMatches(((Attribute) repairAction).getNode())) {
					if (impact.onModifyAttribute(match, ((Attribute) repairAction).getType())) {
						return true;
					}
				}
			}
			
			if (repairAction instanceof Edge) {
				Node sourceNode = HenshinRuleAnalysisUtil.tryLHS(((Edge) repairAction).getSource());
				
				if (sourceNode.getGraph().isLhs()) {
					for (EObject match : (Iterable<EObject>) () -> editRuleMatching.getMatches(sourceNode)) {
						if (impact.onDeleteReference(match, ((Edge) repairAction).getType())) {
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
				} else {
					// Check if fixed value is already set:
					if (!isConstantAlreadySet(attribute, editRuleMatching, invertActions)) {
						return null;
					}
				}
			}
		}
		
		// => We found all change actions in the low-level difference!
		return observableChanges;
	}
	
	private boolean isObservableRemoveObject(Node node, IMatching editRuleMatching, boolean invertActions) {
		List<String> signatures = getRemoveObjectSignatures(node.getType(), invertActions);

		if (exists(signatures)) {
			if (matchContext) {
				Iterator<EObject> matches = editRuleMatching.getMatches(node);

				if (matches.hasNext()) {
					for (EObject match : (Iterable<EObject>) () -> matches) {
						List<String> contextSignatures = getRemoveObjectSignatures(node.getType(), match, invertActions);

						if (exists(contextSignatures)) {
							return true;
						}
					}
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	private boolean isObservableAddObject(Node node, IMatching editRuleMatching, boolean invertActions) {
		List<String> signatures = getAddObjectSignatures(node.getType(), invertActions);

		if (exists(signatures)) {
			if (matchContext) {
				Iterator<EObject> matches = editRuleMatching.getMatches(node);

				if (matches.hasNext()) {
					for (EObject match : (Iterable<EObject>) () -> matches) {
						List<String> contextSignatures = getAddObjectSignatures(node.getType(), match, invertActions);

						if (exists(contextSignatures)) {
							return true;
						}
					}
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	private boolean isObservableAddReference(Edge edge, IMatching editRuleMatching, boolean invertActions) {
		String signatures = getAddReferenceSignature(edge.getType(), invertActions);
		
		// Check without context:
		if (exists(signatures)) {
			
			// Check context of change:
			if (matchContext) {
				
				// Check source and target context of edge change:
				Iterator<EObject> sourceMatches = editRuleMatching.getMatches(edge.getSource());
				
				// Check source of edge change:
				if (sourceMatches.hasNext()) {
					for (EObject sourceMatch : (Iterable<EObject>) () -> sourceMatches) {
						signatures = getAddReferenceSignature(edge.getType(), 
								sourceMatch,
								null,
								invertActions);
						
						if (exists(signatures)) {
							Iterator<EObject> targetMatches = editRuleMatching.getMatches(edge.getTarget());
							
							// Check target of edge change:
							if (targetMatches.hasNext()) {
								for (EObject targetMatch : (Iterable<EObject>) () -> targetMatches) {
									signatures = getAddReferenceSignature(edge.getType(), 
											sourceMatch,
											targetMatch,
											invertActions);
									
									if (exists(signatures)) {
										// Source and target match found:
										return true;
									}
								}
							} else {
								// Source match found; No target matches to search:
								return true;
							}
						}
					}
					
					// No source and target match found:
					return false;
					
				} else {
					
					// Check (only) target context of edge change:
					Iterator<EObject> targetMatches = editRuleMatching.getMatches(edge.getTarget());
					
					if (targetMatches.hasNext()) {
						for (EObject targetMatch : (Iterable<EObject>) () -> targetMatches) {
							signatures = getAddReferenceSignature(edge.getType(), 
									null,
									targetMatch,
									invertActions);
							
							if (exists(signatures)) {
								// No Target match found:
								return true;
							}
						}
						
						// No target match found:
						return false;
					}
				}
			}
			
			// No context should be matched:
			return true;
		}
		
		// Signature not found:
		return false;
	}
	
	private boolean isObservableRemoveReference(Edge edge, IMatching editRuleMatching, boolean invertActions) {
		String signatures = getRemoveReferenceSignature(edge.getType(), invertActions);
		
		// Check without context:
		if (exists(signatures)) {
			
			// Check context of change:
			if (matchContext) {
				
				// Check source and target context of edge change:
				Iterator<EObject> sourceMatches = editRuleMatching.getMatches(edge.getSource());
				
				// Check source of edge change:
				if (sourceMatches.hasNext()) {
					for (EObject sourceMatch : (Iterable<EObject>) () -> sourceMatches) {
						signatures = getRemoveReferenceSignature(edge.getType(), 
								sourceMatch,
								null,
								invertActions);
						
						if (exists(signatures)) {
							Iterator<EObject> targetMatches = editRuleMatching.getMatches(edge.getTarget());
							
							// Check target of edge change:
							if (targetMatches.hasNext()) {
								for (EObject targetMatch : (Iterable<EObject>) () -> targetMatches) {
									signatures = getRemoveReferenceSignature(edge.getType(), 
											sourceMatch,
											targetMatch,
											invertActions);
									
									if (exists(signatures)) {
										// Source and target match found:
										return true;
									}
								}
							} else {
								// Source match found; No target matches to search:
								return true;
							}
						}
					}
					
					// No source and target match found:
					return false;
					
				} else {
					
					// Check (only) target context of edge change:
					Iterator<EObject> targetMatches = editRuleMatching.getMatches(edge.getTarget());
					
					if (targetMatches.hasNext()) {
						for (EObject targetMatch : (Iterable<EObject>) () -> targetMatches) {
							signatures = getRemoveReferenceSignature(edge.getType(), 
									null,
									targetMatch,
									invertActions);
							
							if (exists(signatures)) {
								// No Target match found:
								return true;
							}
						}
						
						// No target match found:
						return false;
					}
				}
			}
			
			// No context should be matched:
			return true;
		}
		
		// Signature not found:
		return false;
	}
	
	private boolean isObservableAttributeValueChange(Attribute attribute, IMatching editRuleMatching, boolean invertActions) {

		// Check if the containing node is created or deleted:
		if (isObservableAddObject(attribute.getNode(), editRuleMatching, invertActions)) {
			return true;
		} else {
			String signatures = getAttributeValueChangeSignature(attribute.getType(), invertActions);

			if (exists(signatures)) {
				if (matchContext) {
					Iterator<EObject> matches = editRuleMatching.getMatches(attribute.getNode());

					if (matches.hasNext()) {
						for (EObject match : (Iterable<EObject>) () -> matches) {
							String contextSignatures = getAttributeValueChangeSignature(
									attribute.getType(), 
									match,
									JavaSciptParser.getConstant(attribute.getType().getEAttributeType(), attribute.getValue()),
									invertActions);

							if (exists(contextSignatures)) {
								return true;
							}
						}
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	private boolean isConstantAlreadySet(Attribute attribute, IMatching editRuleMatching, boolean invertActions) {
		
		// Check if fixed value is already set:
		Object constant = JavaSciptParser.getConstant(attribute.getType().getEAttributeType(), attribute.getValue());
		
		if (constant != null) {
			if (matchContext) {
				Iterator<EObject> matches = editRuleMatching.getMatches(attribute.getNode());

				if (matches.hasNext()) {
					for (EObject match : (Iterable<EObject>) () -> matches) {
						if (match.eGet(attribute.getType()) == constant) {
							return true;
						}
					}
					return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean exists(String changeSignature) {
		return currentToResolvedSignatures.contains(changeSignature) 
				|| currentToResolvedContextSignatures.contains(changeSignature);
	}
	
	private boolean exists(Collection<String> changeSignatures) {
		return changeSignatures.stream().filter(currentToResolvedSignatures::contains).findAny().isPresent()
				|| changeSignatures.stream().filter(currentToResolvedContextSignatures::contains).findAny().isPresent();
	}
	
	private Set<String> toChangeSignatures(Difference difference) {
		Set<String> changeSignatures = new HashSet<>();
		
		for (Change change : difference.getChanges()) {
			if (change instanceof AddObject) {
				AddObject c = (AddObject) change;
				changeSignatures.add(getAddObjectSignature(c.getObj().eClass(), false));
			}
			if (change instanceof RemoveObject) {
				RemoveObject c = (RemoveObject) change;
				changeSignatures.add(getRemoveObjectSignature(c.getObj().eClass(), false));
			}
			if (change instanceof AddReference) {
				AddReference c = (AddReference) change;
				changeSignatures.add(getAddReferenceSignature(c.getType(), false));
			}
			if (change instanceof RemoveReference) {
				RemoveReference c = (RemoveReference) change;
				changeSignatures.add(getRemoveReferenceSignature(c.getType(), false));
			}
			if (change instanceof AttributeValueChange) {
				AttributeValueChange c = (AttributeValueChange) change;
				changeSignatures.add(getAttributeValueChangeSignature(c.getType(), false));
			}
		}
		
		changeSignatures.remove(null);
		return changeSignatures;
	}
	
	private Set<String> toChangeContextSignatures(Difference difference) {
		Set<String> changeSignatures = new HashSet<>();
		
		// Create change signature with context on model A: 
		for (Change change : difference.getChanges()) {

			// NOTE: AddObject can not be observed on model A.
			
			if (change instanceof RemoveObject) {
				RemoveObject c = (RemoveObject) change;
				changeSignatures.add(getRemoveObjectSignature(c.getObj().eClass(), c.getObj(), false));
			}
			if (change instanceof AddReference) {
				AddReference c = (AddReference) change;
				
				changeSignatures.add(getAddReferenceSignature(c.getType(), 
						difference.getCorrespondingObjectInA(c.getSrc()), 
						difference.getCorrespondingObjectInA(c.getTgt()),
						false));
				
				changeSignatures.add(getAddReferenceSignature(c.getType(), 
						difference.getCorrespondingObjectInA(c.getSrc()), 
						null,
						false));
				
				changeSignatures.add(getAddReferenceSignature(c.getType(), 
						null, 
						difference.getCorrespondingObjectInA(c.getTgt()),
						false));
			}
			if (change instanceof RemoveReference) {
				RemoveReference c = (RemoveReference) change;
				
				changeSignatures.add(getRemoveReferenceSignature(c.getType(), c.getSrc(), c.getTgt(), false));
				changeSignatures.add(getRemoveReferenceSignature(c.getType(), c.getSrc(), null, false));
				changeSignatures.add(getRemoveReferenceSignature(c.getType(), null, c.getTgt(), false));
			}
			if (change instanceof AttributeValueChange) {
				AttributeValueChange c = (AttributeValueChange) change;
				changeSignatures.add(getAttributeValueChangeSignature(c.getType(), c.getObjA(), null, false));
				changeSignatures.add(getAttributeValueChangeSignature(c.getType(), c.getObjA(), c.getObjB().eGet(c.getType()), false));
			}
		}
		
		changeSignatures.remove(null);
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
			return  "AddReference_" + getContext(src) + getContext(tgt) + type.getName();
		} else {
			return getRemoveReferenceSignature(type, src, tgt, false);
		}
	}
	
	private String getRemoveReferenceSignature(EReference type, boolean invert) {
		return getRemoveReferenceSignature(type, null, null, invert);
	}
	
	private String getRemoveReferenceSignature(EReference type, EObject src, EObject tgt, boolean invert) {
		if (!invert) {
			return  "RemoveReference_" + getContext(src) + getContext(tgt) + type.getName();
		} else {
			return getAddReferenceSignature(type, src, tgt, false);
		}
	}
	
	private String getAttributeValueChangeSignature(EAttribute type, boolean invert) {
		return getAttributeValueChangeSignature(type, null, null, invert);
	}
	
	private String getAttributeValueChangeSignature(EAttribute type, EObject obj, Object value, boolean invert) {
		value = (value == null) ? "" : "_" + value;
		return "AttributeValueChange_" + getContext(obj) + value + type.getName();
	}
	
	private String getContext(EObject obj) {
		if (obj != null) {
			if (obj.eResource() != null) {
				return obj.eResource().getURIFragment(obj) + "_";
			}
		}
		
		return "";
	}
}
