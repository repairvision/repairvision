package org.sidiff.repair.ui.peo.evaluation.recording;

import static org.sidiff.difference.technical.api.TechnicalDifferenceFacade.deriveTechnicalDifference;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Module;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.ui.WorkbenchUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.editrule.recorder.handlers.CreateEditRuleHandler;
import org.sidiff.editrule.recorder.handlers.util.EditRuleUtil;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.repair.validation.IConstraint;
import org.sidiff.repair.validation.IScopeRecorder;
import org.sidiff.repair.validation.ScopeRecorder;

/**
 * Learns an edit rule from a resolved inconsistency.
 * 
 * @author Manuel Ohrndorf
 */
public class LearnEditRule {
	
	/**
	 * Consistent historical model version.
	 */
	protected Resource modelHistorical;
	
	/**
	 * (First) occurrence of of the inconsistency. 
	 */
	protected Resource modelIntroduced;
	
	/**
	 * The fixed model version.
	 */
	protected Resource modelResolved;
	
	/**
	 * Difference slice: historical, resolved
	 */
	protected DifferenceSlice slice;
	
	/**
	 * Difference slicing criterion: historical, resolved
	 */
	protected DifferenceSlicingCriterion slicingCriterion;
	
	/**
	 * Difference navigation: historical, resolved
	 */
	protected DifferenceNavigation navigation;
	
	/**
	 * Matching settings.
	 */
	protected DifferenceSettings matchingSettings;
	
	/**
	 * Mapping from introduced model version to resolved model version.
	 */
	protected SymmetricDifference intorducedToResolved; 
	
	public LearnEditRule(DifferenceSettings matchingSettings,
			Resource modelHistorical, 
			Resource modelIntroduced, 
			Resource modelResolved) {
		
		this.modelHistorical = modelHistorical;
		this.modelIntroduced = modelIntroduced;
		this.modelResolved = modelResolved;
		
		// Initialize slicing criterion:
		this.slicingCriterion = new DifferenceSlicingCriterion();
		
		// Calculate difference: Introduced -> Resolved
		try {
			intorducedToResolved = deriveTechnicalDifference(modelIntroduced, modelResolved, matchingSettings);
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		// Calculate difference: Historical -> Resolved
		this.matchingSettings = matchingSettings;
		SymmetricDifference difference = null;
		
		try {
			difference = deriveTechnicalDifference(modelHistorical, modelResolved, matchingSettings);
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		this.slice = new DifferenceSlice(difference);
		this.navigation = new DifferenceNavigation(difference);
	}
	
	public void learn(EObject introducedContext, IConstraint consistencyRule) {
		assert intorducedToResolved.getModelA() == introducedContext.eResource();
		
		// Validation //
		
		EObject contextResolved = intorducedToResolved.getCorrespondingObjectInB(introducedContext);
		EObject contextHistorical = slice.getDifference().getCorrespondingObjectInA(contextResolved);
		
		// Scope: Historical
		IScopeRecorder scopeHistorical = new ScopeRecorder();
		consistencyRule.evaluate(contextHistorical, scopeHistorical);
		
		slicingCriterion.setContextHistorical(contextHistorical);
		slicingCriterion.setScopeHistorical(scopeHistorical.getScope());
		
		// Scope: Resolved
		IScopeRecorder scopeResolved = new ScopeRecorder();
		consistencyRule.evaluate(contextResolved, scopeResolved);
		
		slicingCriterion.setContextResolved(contextResolved);
		slicingCriterion.setScopeResolved(scopeResolved.getScope());
		
		// Expand Scope //
		
		// Historical:
		Map<EObject, Integer> expandedScopeHistorical = new HashMap<>();
		
		for (EObject scopeElementHistorical : scopeHistorical.getScope()) {
			expandedScopeHistorical.put(scopeElementHistorical, 0);
		}
		for (EObject scopeElementHistorical : scopeHistorical.getScope()) {
			expandScope(scopeElementHistorical, expandedScopeHistorical,
					slicingCriterion.getModelHistoricalBlacklist(),
					slicingCriterion.getScopeHistoricalDistance(), 0);
		}
		
		// Resolved:
		Map<EObject, Integer> expandedScopeResolved = new HashMap<>();
		
		for (EObject scopeElementResolved : scopeResolved.getScope()) {
			expandedScopeResolved.put(scopeElementResolved, 0);
		}
		for (EObject scopeElementResolved : scopeResolved.getScope()) {
			expandScope(scopeElementResolved, expandedScopeResolved,
					slicingCriterion.getModelResolvedBlacklist(),
					slicingCriterion.getScopeResolvedDistance(), 0);
		}
		
		// Difference Slice //
		
		sliceDifferenceModelA(expandedScopeHistorical.keySet());
		sliceDifferenceModelB(expandedScopeResolved.keySet());
		
		// Generate the Edit-Rule //
		Module editRule = CreateEditRuleHandler.createEditRule(consistencyRule.getName(), 
				slice.getCorrespondences(), slice.getChanges());
		
		if (editRule != null) {
			editRule.getImports().addAll(EditRuleUtil.getImports(editRule));
			
			URI eoURI = EcoreUtil.getURI(introducedContext).trimSegments(1)
					.appendSegment(editRule.getName() + "_execute")
					.appendFileExtension("henshin");
			Resource eoRes = new ResourceSetImpl().createResource(eoURI);
			eoRes.getContents().add(editRule);

			try {
				eoRes.save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}

			WorkbenchUtil.showMessage("Edit-Rule saved:\n\n" + eoURI.toPlatformString(true));
		} else {
			WorkbenchUtil.showError("Could not transform this difference to an edit-rule.");
		}
	}

	private void expandScope(
			EObject scopeElement, Map<EObject, Integer> expandedScope,
			Set<EObject> blacklist, int maxDistance, int distance) {
		
		if (distance < maxDistance) {
				
			// Outgoing references:
			for (EReference reference : scopeElement.eClass().getEAllReferences()) {
				if (!slicingCriterion.getReferenceBlacklist().contains(reference)) {
					for (Iterator<? extends EObject> iterator 
							= navigation.getTargets(scopeElement, reference, false); iterator.hasNext();) {
						
						EObject target = iterator.next();
						
						if (!slicingCriterion.getClassBlacklist().contains(target.eClass())) {
							if (!blacklist.contains(target)) {
								int lastTargetDistance = expandedScope.getOrDefault(target, -1);
								
								// Optimization: Reached target object on a shorter path?
								if (lastTargetDistance < (distance + 1)) {
									expandedScope.put(target, (distance + 1));
									expandScope(target, expandedScope, blacklist, maxDistance, (distance + 1));
								}
							}
							
						}
					}
				}
				
			}

			// Incoming references:
			for (EReference reference : navigation.getCrossReferencer().getIncomingReferences(scopeElement.eClass())) {
				if (!slicingCriterion.getReferenceBlacklist().contains(reference)) {
					for (Iterator<? extends EObject> iterator 
							= navigation.getTargets(scopeElement, reference, true); iterator.hasNext();) {
						
						EObject target = iterator.next();
						
						if (!slicingCriterion.getClassBlacklist().contains(target.eClass())) {
							int lastTargetDistance = expandedScope.getOrDefault(target, -1);
							
							// Optimization: Reached target object on a shorter path?
							if ((distance + 1) < lastTargetDistance) {
								expandedScope.put(target, (distance + 1));
								expandScope(target, expandedScope,  blacklist, maxDistance, (distance + 1));
							}
						}
					}
				}
			}
		}
	}
	
	private void sliceDifferenceModelA(Set<EObject> scopeA) {
		for (EObject scopeElementA : scopeA) {
			Correspondence correspondence = navigation.getCorrespondenceOfModelA(scopeElementA);
			
			if (correspondence != null) {
				slice.addCorrespondence(correspondence);
			}
			
			slice.addChanges(navigation.getLocalChanges(scopeElementA));
		}
	}
	
	private void sliceDifferenceModelB(Set<EObject> scopeB) {
		for (EObject scopeElementB : scopeB) {
			Correspondence correspondence = navigation.getCorrespondenceOfModelB(scopeElementB);
			
			if (correspondence != null) {
				slice.addCorrespondence(correspondence);
			}
			
			slice.addChanges(navigation.getLocalChanges(scopeElementB));
		}
	}

	public SymmetricDifference getDifference() {
		return slice.getDifference();
	}

	public DifferenceSlice getSlice() {
		return slice;
	}

	public void setSlice(DifferenceSlice slice) {
		this.slice = slice;
	}

	public DifferenceSlicingCriterion getSlicingCriterion() {
		return slicingCriterion;
	}

	public void setSlicingCriterion(DifferenceSlicingCriterion slicingCriterion) {
		this.slicingCriterion = slicingCriterion;
	}

	public DifferenceNavigation getNavigation() {
		return navigation;
	}

	public void setNavigation(DifferenceNavigation navigation) {
		this.navigation = navigation;
	}
}
