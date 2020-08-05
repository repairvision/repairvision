package org.sidiff.repair.history.editrules.learn.resolved;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.generic.matcher.uuid.UUIDMatcherProvider;
import org.sidiff.history.analysis.tracing.InconsistencyTrace;
import org.sidiff.history.revision.IRevision;
import org.sidiff.history.revision.difference.executor.DifferenceExecutor;
import org.sidiff.history.revision.impl.Revision;
import org.sidiff.history.revision.util.SymmetricDifferenceUtil;
import org.sidiff.historymodel.ChangeSet;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.Problem;
import org.sidiff.revision.common.utilities.java.JUtil;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.difference.api.DifferenceFacade;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.difference.matcher.IMatcherProvider;
import org.sidiff.revision.impact.changetree.IDecisionNode;
import org.sidiff.revision.impact.changetree.change.actions.AttributeChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ObjectChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ReferenceChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.StructuralFeatureChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.interpreter.IConstraint;

/*
 * TODO: Es sollte auch ermittelt werden, ob während einer Reparatur 
 * negative Seiteneffekte auftreten, welche aber ebenfalls innerhalb
 * der Differenz bzw. Historie repariert werden.
 */
public class InconsistencyAnalysis {

	private InconsistencyTrace inconsistency;

	public InconsistencyAnalysis(Problem introducedValidationError) {
		this.inconsistency = InconsistencyTrace.createRepairedInconsistency(introducedValidationError, false);
	}
	
	protected Difference calculateDifference(Resource modelA, Resource modelB, IMatcherProvider matcherProvider) {
		
		DifferenceSettings settings = new DifferenceSettings();
		settings.setMatcher(matcherProvider);

		return DifferenceFacade.difference(modelA, modelB, settings);
	}
	
	public List<ChangeSet> getCausingChanges() {
		
		// - aktuellen Reparaturbaum berechnen
		// - alle Undos bezüglich der Differenz H -> I und dem Reparaturbaum berechnen
		// - Statespace Exploration
		//   - (1) jeder Zweig des Reparaturbaums muss untersucht werden
		//      - Alternativen generieren
		//      - nur reine Undo-Alternativen betrachten
		//      - Undo-Alternativen durch Undo-Aktionen aus der Differenz initialisieren
		//   - eine Alternative ausführen -> für Backtracking merken
		//   - erneut validieren
		//   - Undo fortsetzen:
		//     - solange die Inkonsistenz nicht behoben wurde wieder bei (1) beginnen
		//   - Backtracking zur nächsten Undo-Alternative:
		//     - Wenn die Inkonsistenz behoben wurde, die durchgeführten (inversen) Änderungen als
		//       auslösendes Change-Set speichern.
		//     - Wenn keine Undo-Alternativen mehr existieren und die Inkonsistenz nicht behoben wurde, 
		//       dann kann der Zweig des Reparaturbaums verworfen werden. 
		
		// NOTE:
		// - Der selbe Algorithmus wie bei Resolved-Changes -> Differenz invertieren: I -> H
		// - Interessant sind ggf. auch die Anzahl der nötigen Reparaturbäume bis eine Inkonsistenz behoben wurde.
		
		// Calculate inverse difference: historical -> introduced
		Resource historical = inconsistency.getModelHistorical();
		Resource introduced = inconsistency.getModelIntroduced();
		Difference difference = calculateDifference(introduced, historical, new UUIDMatcherProvider());
		
		IRevision revision = new Revision(difference);

		// Explore repairs (undos):
		List<Set<Change>> repairSteps = new ArrayList<>();
		EObject context = inconsistency.getProblemInIntroducedModel().getContextElement();
		IConstraint constraint = inconsistency.getConsistencyRule(ValidationFacade.getConstraints(introduced));
		
		// TODO: Initialization of attribute values!?
		explore(constraint, new ArrayList<>(),
				context, introduced, new Stack<>(),
				difference, revision, 
				repairSteps, new HashSet<>());
		
		// Add implicit repairs:
		addImplicitRepairs(constraint, context, introduced, revision, repairSteps);
		
		return createChangeSets(repairSteps, true);
	}
	
	public List<ChangeSet> getResolvedChanges() {
		
		// - aktuellen Reparaturbaum berechnen
		// - alle durchgeführten Reparaturen bezüglich der Differenz I -> R und dem Reparaturbaum berechnen
		// - Statespace Exploration
		//   - (1) jeder Zweig des Reparaturbaums muss untersucht werden
		//      - Alternativen generieren
		//      - nur reine Applied-Alternativen betrachten
		//      - Applied-Alternativen durch Aktionen aus der Differenz initialisieren
		//   - eine Alternative ausführen -> für Backtracking merken
		//   - erneut validieren
		//   - Reparatur fortsetzen:
		//     - solange die Inkonsistenz nicht behoben wurde wieder bei (1) beginnen
		//   - Backtracking zur nächsten Applied-Alternative:
		//     - Wenn die Inkonsistenz behoben wurde, die durchgeführten Änderungen als
		//       auslösendes Change-Set speichern.
		//     - Wenn keine Applied-Alternativen mehr existieren und die Inkonsistenz nicht behoben wurde, 
		//       dann kann der Zweig des Reparaturbaums verworfen werden. 
		
		// Calculate inverse difference: historical -> introduced
		Resource introduced = inconsistency.getModelIntroduced();
		Resource resolved = inconsistency.getModelResolved();
		Difference difference = calculateDifference(introduced, resolved, new UUIDMatcherProvider());
		
		IRevision changeIndex = new Revision(difference);

		// Explore repairs:
		List<Set<Change>> repairSteps = new ArrayList<>();
		EObject context = inconsistency.getProblemInIntroducedModel().getContextElement();
		IConstraint constraint = inconsistency.getConsistencyRule(ValidationFacade.getConstraints(introduced));
		
		// TODO: Initialization of attribute values!?
		explore(constraint, new ArrayList<>(), 
				context, introduced, new Stack<>(),
				difference, changeIndex, 
				repairSteps, new HashSet<>());
		
		// Add implicit repairs:
		addImplicitRepairs(constraint, context, introduced, changeIndex, repairSteps);
		
		return createChangeSets(repairSteps, false);
	}

	protected void explore(
			IConstraint constraint, List<ChangeAction> repairFilter, 
			EObject context, Resource inconsistent, Stack<DifferenceExecutor> exploration,
			Difference difference, IRevision revision, 
			List<Set<Change>> repairSteps, Set<Change> currentRepairStep) {
		
		// Calculate repair alternatives:
		// TODO: Preprocessing: Filter branches with no observable repair actions.
		List<RepairValidation> validations = ValidationFacade.repair(
				JUtil.singeltonIterator(context), 
				Collections.singletonList(constraint));
		
		// NOTE: Only one validation expected!
		assert (validations.size() == 1);
		
		for (RepairValidation validation : validations) {
			validation.cleanUpRepairTree();
			validation.getRepair().combinations().forEachRemaining(repair -> {
				
				// Focus on current repair path -> has new repairs?
				/*
				 * TODO:
				 * 
				 * Alle Reparaturenalternativen die bereits zuvor vorhanden waren und damit
				 * keine logische Fortsetzung der bisherigen Reparatur sind müssen ausgefilter
				 * werden. Korrekt müsste man hier prüfen, dass die aktuelle
				 * Reparaturalternative nicht bereits in einem vorherigen Reparaturbaum
				 * vorhanden war. Durch die aktelle überlappungsprüfung wird ggf. zu viel
				 * ausgefiltert.
				 * 
				 * Anstelle des Filters könnte man auch prüfen, das mindestens eine
				 * Reparaturaktion/Änderung der aktuellen Reparaturalternative von den
				 * vorherigen Reparaturaktionen/Änderungen abh�ngt!?
				 * 
				 */
				if (!overlappingRepairs(repair, repairFilter)) {
					List<List<Change>> observedRepairs = getObservable(repair, revision,  currentRepairStep, exploration);
					
					// Filter combinations with missing observable repair actions:
					if (observedRepairs != null) {
						for (List<Change> observedRepairStep : cartesianProduct(observedRepairs)) {
							
							// Apply observed changes:
							SymmetricDifferenceUtil.addOppositeChanges(revision, observedRepairStep);
							
							DifferenceExecutor differenceExecutor = new DifferenceExecutor(difference, observedRepairStep);
							differenceExecutor.execute();
							exploration.push(differenceExecutor);
							
							currentRepairStep.addAll(observedRepairStep);
							
							// Check if inconsistency is resolved:
							List<Validation> revalidations = Collections.emptyList();
							
							// NOTE: The context might be deleted!
							if (context.eResource() != null) {
								revalidations = ValidationFacade.validate(
										JUtil.singeltonIterator(context),
										Collections.singletonList(constraint));
							}
							
							if (revalidations.isEmpty()) {
								// Remember current repair step:
								Set<Change> finalRepairStep = new HashSet<>(currentRepairStep);
								repairSteps.add(finalRepairStep);
							} else {
								// Next step:
								List<ChangeAction> addedRepairs = addMissingRepairs(validation.getRepair(), repairFilter);
								
								explore(constraint, repairFilter, 
										context, inconsistent, exploration,
										difference, revision, 
										repairSteps, currentRepairStep);
								
								// Backtracking:
								repairFilter.removeAll(addedRepairs);
							}
							
							// Backtracking:
							differenceExecutor.revert();
							exploration.pop();
							currentRepairStep.removeAll(observedRepairStep);

						}
					}	
				}
			});
		}
	}
	
	private List<List<Change>> getObservable(List<? extends IDecisionNode> repair, 
			IRevision revision, Set<Change> changeFilter, 
			Collection<DifferenceExecutor> exploration) {
		
		List<List<Change>> observableRepair = new ArrayList<>();
		
		for (IDecisionNode node : repair) {
			if (node instanceof ChangeAction) {
				ChangeAction changeAction = (ChangeAction) node; 
				List<Change> observedRepair = getObservable(changeAction, revision, changeFilter, exploration);
				
				if (!observedRepair.isEmpty()) {
					observableRepair.add(observedRepair);
				} else {
					return null;
				}
			} else {
				throw new RuntimeException("Unsupported repair action!");
			}
		}
		
		return observableRepair;
	}
	
	private List<Change> getObservable(ChangeAction changeAction, 
			IRevision revision, Set<Change> changeFilter, 
			Collection<DifferenceExecutor> exploration) {
		
		List<Change> observedRepair = new ArrayList<>();
		
		EObject repairContextA = null;
		
		if (changeAction instanceof StructuralFeatureChangeAction) {
			repairContextA = ((StructuralFeatureChangeAction) changeAction).getContext();
		} else if (changeAction instanceof ObjectChangeAction) {
			repairContextA = ((ObjectChangeAction) changeAction).getObject();
		}
		
		for (Change localChange : revision.getDifference().getLocalChanges(repairContextA)) {
			if (!changeFilter.contains(localChange)) {
				
				if ((localChange instanceof RemoveReference) && (changeAction instanceof ReferenceChangeAction)){
					ReferenceChangeAction referenceChangeAction = (ReferenceChangeAction) changeAction;
					
					if (referenceChangeAction.getType().equals(RepairType.DELETE) || referenceChangeAction.getType().equals(RepairType.MODIFY)) {
						if (referenceChangeAction.getFeature().equals(((RemoveReference) localChange).getType())) {
							if (referenceChangeAction.getContext() == ((RemoveReference) localChange).getSrc()) {
								observedRepair.add(localChange);
							}
						}
					}
				}
				
				else if ((localChange instanceof AttributeValueChange) && (changeAction instanceof AttributeChangeAction)) {
					AttributeChangeAction attributeChangeAction = (AttributeChangeAction) changeAction;
					
					if (attributeChangeAction.getType().equals(RepairType.MODIFY)) {
						if (attributeChangeAction.getFeature().equals(((AttributeValueChange) localChange).getType())) {
							observedRepair.add(localChange);
						}
					}
				}
				
				else if ((localChange instanceof RemoveObject) && (changeAction instanceof ObjectChangeAction)){
					ObjectChangeAction objectChangeAction = (ObjectChangeAction) changeAction;
					
					if (objectChangeAction.getType().equals(RepairType.DELETE) || objectChangeAction.getType().equals(RepairType.MODIFY)) {
						if (objectChangeAction.getObject().equals(((RemoveObject) localChange).getObj())) {
							observedRepair.add(localChange);
						}
					}
				}
			}
		}
		
		EObject repairContextB = getCorrespondingObjectInB(repairContextA, revision, exploration);
		
		if (repairContextB != null) {
			for (Change localChange : revision.getDifference().getLocalChanges(repairContextB)) {
				if (!changeFilter.contains(localChange)) {
					
					if ((localChange instanceof AddReference) && (changeAction instanceof ReferenceChangeAction)) {
						ReferenceChangeAction referenceChangeAction = (ReferenceChangeAction) changeAction;
						
						if (referenceChangeAction.getType().equals(RepairType.CREATE) || referenceChangeAction.getType().equals(RepairType.MODIFY)) {
							if (referenceChangeAction.getFeature().equals(((AddReference) localChange).getType())) {
								if (repairContextB == ((AddReference) localChange).getSrc()) {
									observedRepair.add(localChange);
								}
							}
						}
					}
					
					else if ((localChange instanceof AddObject) && (changeAction instanceof ObjectChangeAction)){
						ObjectChangeAction objectChangeAction = (ObjectChangeAction) changeAction;
						
						if (objectChangeAction.getType().equals(RepairType.CREATE) || objectChangeAction.getType().equals(RepairType.MODIFY)) {
							if (objectChangeAction.getObject().equals(((AddObject) localChange).getObj())) {
								observedRepair.add(localChange);
							}
						}
					}
				}
			}
		}
		
		return observedRepair;
	}
	
	private EObject getCorrespondingObjectInB(EObject objA, 
			IRevision revision, 
			Collection<DifferenceExecutor> explorations) {
		
		Correspondence correspondence = revision.getDifference().getCorrespondenceA(objA);
		
		if (correspondence != null) {
			return correspondence.getMatchedB();
		} else {
			
			for (DifferenceExecutor exploration : explorations) {
				EObject objB = exploration.getCorrespondingObjectInB(objA);
				
				if (objB != null) {
					return objB;
				}
			}
		}
		
		return null;
	}
	
	private <T> List<List<T>> cartesianProduct(List<List<T>> lists) {
	    List<List<T>> cartesianProduct = new ArrayList<List<T>>();
	    
	    if (lists.size() == 0) {
	        cartesianProduct.add(new ArrayList<T>());
	        return cartesianProduct;
	    } else {
	        List<T> firstList = lists.get(0);
	        List<List<T>> remainingLists = cartesianProduct(lists.subList(1, lists.size()));
	        
	        for (T condition : firstList) {
	            for (List<T> remainingList : remainingLists) {
	                ArrayList<T> resultList = new ArrayList<T>();
	                resultList.add(condition);
	                resultList.addAll(remainingList);
	                cartesianProduct.add(resultList);
	            }
	        }
	    }
	    return cartesianProduct;
	}
	
	private void addImplicitRepairs(
			IConstraint constraint, EObject context, Resource inconsistent,
			IRevision revision, List<Set<Change>> introducedChangeSets) {
		
		List<RepairValidation> validations = ValidationFacade.repair(
				JUtil.singeltonIterator(context),
				Collections.singletonList(constraint));
		
		// NOTE: Only one validation expected!
		assert (validations.size() == 1);
		
		for (Set<Change> changeSet : introducedChangeSets) {
			for (Change change : changeSet.toArray(new Change[0])) {
				for (Change subsequentChange : SymmetricDifferenceUtil.getSubsequentChanges(revision, change)) {
					
					if (!changeSet.contains(subsequentChange)) {
						
						for (RepairValidation validation : validations) {
							Iterator<? extends IDecisionNode> repairTree = validation.getRepair().traversal();
							
							while (repairTree.hasNext()) {
								IDecisionNode repairTreeNode = repairTree.next();
								
								if (repairTreeNode instanceof ChangeAction) {
									List<Change> observables = getObservable(
											(ChangeAction) repairTreeNode,
											revision, Collections.emptySet(),
											Collections.emptyList());
									
									for (Change observable : observables) {
										if (observable == subsequentChange) {
											changeSet.add(subsequentChange);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private List<ChangeSet> createChangeSets(List<Set<Change>> changeSets, boolean invert) {
		List<ChangeSet> eChangeSets = new ArrayList<>();
		
		for (Set<Change> changeSet : changeSets) {
			ChangeSet eChangeSet = HistoryModelFactory.eINSTANCE.createChangeSet();
			eChangeSets.add(eChangeSet);
			
			for (Change change : changeSet) {
				if (invert) {
					eChangeSet.getChanges().add(SymmetricDifferenceUtil.invertChange(change));
				} else {
					eChangeSet.getChanges().add(SymmetricDifferenceUtil.copyChange(change));
				}
			}
		}
		
		return eChangeSets;
	}
	
	
	private List<ChangeAction> addMissingRepairs(IDecisionNode repairTree, List<ChangeAction> repairs) {
		List<ChangeAction> missingRepairs = new ArrayList<>();
		
		repairTree.traversal().forEachRemaining(decision -> {
			if (decision instanceof ChangeAction) {
				ChangeAction repair = (ChangeAction) decision;
				
				if (!containsRepair(repairs, repair)) {
					repairs.add(repair);
					missingRepairs.add(repair);
				}
			}
		});
		
		return missingRepairs;
	}
	
	private boolean overlappingRepairs(List<? extends IDecisionNode> repair, List<? extends IDecisionNode> repairsB) {
		
		for (IDecisionNode repairA : repair) {
			if (repairA instanceof ChangeAction) {
				for (IDecisionNode repairB : repairsB) {
					if (repairB instanceof ChangeAction) {
						if (equalsRepair((ChangeAction) repairA, (ChangeAction) repairB)) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean containsRepair(List<ChangeAction> repairs, ChangeAction repair) {
		
		for (ChangeAction otherRepair : repairs) {
			if (equalsRepair(repair, otherRepair)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean equalsRepair(ChangeAction repairA, ChangeAction repairB) {
		
		if ((repairA instanceof ReferenceChangeAction) && (repairB instanceof ReferenceChangeAction)) {
			ReferenceChangeAction structuralRepairA = (ReferenceChangeAction) repairA;
			ReferenceChangeAction structuralRepairB = (ReferenceChangeAction) repairB;
			
			if (structuralRepairA.getType().equals(structuralRepairB.getType())) {
				if (structuralRepairA.getContext().equals(structuralRepairB.getContext())) {
					if (structuralRepairA.getFeature().equals(structuralRepairB.getFeature())) {
						if (structuralRepairA.getTarget().equals(structuralRepairB.getTarget())) {
							return true;
						}
					}
				}
			}
		} else if ((repairA instanceof AttributeChangeAction) && (repairB instanceof AttributeChangeAction)) {
			AttributeChangeAction structuralRepairA = (AttributeChangeAction) repairA;
			AttributeChangeAction structuralRepairB = (AttributeChangeAction) repairB;
			
			if (structuralRepairA.getType().equals(structuralRepairB.getType())) {
				if (structuralRepairA.getContext().equals(structuralRepairB.getContext())) {
					if (structuralRepairA.getFeature().equals(structuralRepairB.getFeature())) {
						if (structuralRepairA.getValue().equals(structuralRepairB.getValue())) {
							return true;
						}
					}
				}
			}
		}  else if ((repairA instanceof ObjectChangeAction) && (repairB instanceof ObjectChangeAction)) {
			ObjectChangeAction objectRepairA = (ObjectChangeAction) repairA;
			ObjectChangeAction objectRepairB = (ObjectChangeAction) repairB;
			
			if (objectRepairA.getType().equals(objectRepairB.getType())) {
				if (objectRepairA.getContainingReference().equals(objectRepairB.getContainingReference())) {
					if (objectRepairA.getObjectType().equals(objectRepairB.getObjectType())) {
						if (objectRepairA.getObject().equals(objectRepairB.getObject())) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}
}
