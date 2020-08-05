package org.sidiff.repair.history.editrules.learn.scope;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.common.emf.ModelingUtil;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IObjectFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IReferenceFilter;

public class DifferenceSlicer {
	
	/**
	 * RevisionDifference slicing criterion: historical, resolved
	 */
	protected DifferenceSlicingCriterion slicingCriterion;
	
	/**
	 * RevisionDifference navigation: historical, resolved
	 */
	protected DifferenceNavigation navigation;
	
	/**
	 * RevisionDifference slice: historical, resolved
	 */
	protected DifferenceSlice slice;
	
	public DifferenceSlicer(DifferenceSlicingCriterion slicingCriterion, DifferenceNavigation navigation) {
		this.slicingCriterion = slicingCriterion;
		this.navigation = navigation;
	}
	
	public DifferenceSlice getSlice() {
		
		if (slice == null) {
			slice = new DifferenceSlice(navigation.getRevision().getDifference().getSymmetricDifference());
			
			sliceHistoricalModel();
			sliceRevisedModel();
		}
		return slice;
	}

	private void sliceHistoricalModel() {
		Set<EObject> historicalFragment = slicingCriterion.getHistoricalFragment();
		
		// Distance based slice expansion:
		if (slicingCriterion.getHistoricalFragmentDistance() > 0) {
			Map<EObject, Integer> historicalExpandedFragment = new HashMap<>();
			
			for (EObject elementCurrent : slicingCriterion.getHistoricalFragment()) {
				historicalExpandedFragment.put(elementCurrent, 0);
			}
			for (EObject elementCurrent : slicingCriterion.getHistoricalFragment()) {
				expandScope(
						elementCurrent, historicalExpandedFragment, 
						slicingCriterion.getHistoricalFragmentDistance(), 0,
						slicingCriterion.getHistoricalObjectFilter(), slicingCriterion.getHistoricalReferenceFilter());
			}
			
			historicalFragment = historicalExpandedFragment.keySet();
		}
		
		// Collect changes:
		for (EObject elementA : historicalFragment) {
			addCorrespondence(navigation.getCorrespondenceOfModelA(elementA));
			
			// Remove Object/Reference:
			for (Change change : navigation.getLocalChanges(elementA)) {
				if (!filterHistoricalModel(change)) {
					addChange(change, elementA);
				}
			}
		}
	}
	
	private boolean filterHistoricalModel(Change change) {
		
		if (change instanceof RemoveReference) {
			RemoveReference removeReference = (RemoveReference) change;
			return slicingCriterion.getHistoricalReferenceFilter()
					.filter(removeReference.getSrc(), removeReference.getType(), removeReference.getTgt());
		}
		
		else if (change instanceof AttributeValueChange) {
			AttributeValueChange avc = (AttributeValueChange) change;
			return slicingCriterion.getHistoricalAttributeFilter()
					.filter(avc.getObjA(), avc.getObjA().eGet(avc.getType()), avc.getType());
		}
		
		return false;
	}
	
	public void sliceRevisedModel() {
		
		Set<EObject> revisedFragment = slicingCriterion.getRevisedFragment();
		
		// Distance based slice expansion:
		if (slicingCriterion.getHistoricalFragmentDistance() > 0) {
			Map<EObject, Integer> historicalExpandedFragment = new HashMap<>();
			
			for (EObject elementCurrent : slicingCriterion.getHistoricalFragment()) {
				historicalExpandedFragment.put(elementCurrent, 0);
			}
			for (EObject elementCurrent : slicingCriterion.getHistoricalFragment()) {
				expandScope(
						elementCurrent, historicalExpandedFragment, 
						slicingCriterion.getRevisedFragmentDistance(), 0,
						slicingCriterion.getRevisedObjectFilter(), slicingCriterion.getRevisedReferenceFilter());
			}
			
			revisedFragment = historicalExpandedFragment.keySet();
		}
		
		for (EObject elementB : revisedFragment) {
			addCorrespondence(navigation.getCorrespondenceOfModelB(elementB));

			// Add Object/Reference:
			for (Change change : navigation.getLocalChanges(elementB)) {
				if (!filterRevisedModel(change)) {
					addChange(change, elementB);
				}
			}
		}
	}
	
	private boolean filterRevisedModel(Change change) {
		
		if (change instanceof AddReference) {
			AddReference addReference = (AddReference) change;
			return slicingCriterion.getRevisedReferenceFilter()
					.filter(addReference.getSrc(), addReference.getType(), addReference.getTgt());
		}

		else if (change instanceof AttributeValueChange) {
			AttributeValueChange avc = (AttributeValueChange) change;
			return slicingCriterion.getRevisedAttributeFilter()
					.filter(avc.getObjB(), avc.getObjB().eGet(avc.getType()), avc.getType());
		}
		
		return false;
	}
	
	private void addCorrespondence(Correspondence correspondence) {
		if (correspondence != null) {
			slice.addCorrespondence(correspondence);
		}
	}
	
	private boolean addChange(Change change, EObject source) {
		
		if (change != null) {
			boolean hasChanged = slice.addChange(change);
			
			if (source != null) {
				if ((change instanceof AddReference) || (change instanceof RemoveReference)) {
					EObject target = null;
					
					if (DifferenceNavigation.getChangeSource(change) == source) {
						// Check for target:
						target = DifferenceNavigation.getChangeTarget(change);
					} else {
						// Check for source:
						target = DifferenceNavigation.getChangeSource(change);
					}
					
					addCorrespondence(navigation.getCorrespondence(target));
					addChange(navigation.getChangeObject(target), target);
					
				} else if ((change instanceof AddObject) || (change instanceof RemoveObject)) {
					
					if (slicingCriterion.isAddFirstChangedContainer() || slicingCriterion.isAddAllChangedContainers()) {
						Iterator<EObject> rootPathIterator = ModelingUtil.getRootPath(source);
						
						while (rootPathIterator.hasNext()) {
							EObject container = rootPathIterator.next();
							Change containerChange = navigation.getChangeObject(container);
							
							// Containment:
							Change containerReference = navigation.getContainerReferenceChange(change);
							
							if (containerReference != null) {
								slice.addChange(containerReference);
							}
							
							Change containmentReference = navigation.getContainmentReferenceChange(change);
							
							if (containerReference != null) {
								slice.addChange(containmentReference);
							}
							
							// Container node:
							if (containerChange != null) {
								if (slicingCriterion.isAddFirstChangedContainer()) {
									slice.addChange(containerChange);
									
									if (!slicingCriterion.isAddAllChangedContainers()) {
										break;
									}
								}
							} else {
								if (slicingCriterion.isAddFirstCorrespondingContainer()) {
									addCorrespondence(navigation.getCorrespondence(container));
									
									if (!slicingCriterion.isAddAllCorrespondingContainers()) {
										break;
									}
								}
							}
						} 
					}
				}
			}
			return hasChanged;
		}
		return false;
	}
	
	private void expandScope(
			EObject scopeElement, Map<EObject, Integer> expandedScope,
			int maxDistance, int distance,
			IObjectFilter objectFilter, IReferenceFilter referenceFilter) {
		
		if (distance < maxDistance) {
				
			// Outgoing references:
			for (EReference reference : scopeElement.eClass().getEAllReferences()) {
				if (!slicingCriterion.getReferenceBlacklist().contains(reference)) {
					for (EObject target : navigation.getTargets(scopeElement, reference, false)) {
						
						if (!slicingCriterion.getClassBlacklist().contains(target.eClass())) {
							if (!objectFilter.filter(target)) {
								if (!referenceFilter.filter(scopeElement, reference, target)) {
									int lastTargetDistance = expandedScope.getOrDefault(target, -1);
									
									// Optimization: Reached target object on a shorter path?
									if (lastTargetDistance < (distance + 1)) {
										expandedScope.put(target, (distance + 1));
										expandScope(
												target, expandedScope, 
												maxDistance, (distance + 1),
												objectFilter, referenceFilter);
									}
								}
							}
						}
					}
				}
			}

			// Incoming references:
			for (EReference reference : navigation.getRevision().getMetaModel().getAllIncomingReferences(scopeElement.eClass())) {
				if (!slicingCriterion.getReferenceBlacklist().contains(reference)) {
					for (EObject target : navigation.getTargets(scopeElement, reference, true)) {
						if (!slicingCriterion.getClassBlacklist().contains(target.eClass())) {
							if (!objectFilter.filter(target)) {
								if (!referenceFilter.filter(scopeElement, reference, target)) {
									int lastTargetDistance = expandedScope.getOrDefault(target, -1);
									
									// Optimization: Reached target object on a shorter path?
									if ((distance + 1) < lastTargetDistance) {
										expandedScope.put(target, (distance + 1));
										expandScope(
												target, expandedScope,
												maxDistance, (distance + 1), 
												objectFilter, referenceFilter);
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
