package org.sidiff.repair.history.editrules.learning;

import static org.sidiff.difference.technical.api.TechnicalDifferenceFacade.deriveTechnicalDifference;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Module;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.editrule.recorder.filter.IAttributeFilter;
import org.sidiff.editrule.recorder.filter.IReferenceFilter;
import org.sidiff.editrule.recorder.handlers.CreateEditRuleHandler;
import org.sidiff.editrule.recorder.util.EditRuleUtil;
import org.sidiff.editrule.recorder.util.HenshinDiagramUtil;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ScopeRecorder;

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
	 * The valid model version.
	 */
	protected Resource modelCurrent;
	
	/**
	 * Matching settings.
	 */
	protected DifferenceSettings matchingSettings;
	
	/**
	 * Mapping from historical model version to resolved model version.
	 */
	protected SymmetricDifference historicalToResolved; 
	
	/**
	 * Difference navigation: historical, resolved
	 */
	protected DifferenceNavigation navigation;
	
	/**
	 * The slicing algorithm.
	 */
	protected DifferenceSlicer slicer;
	
	public LearnEditRule(SymmetricDifference historicalToResolved) {
		
		this.modelHistorical = historicalToResolved.getModelA();
		this.modelCurrent = historicalToResolved.getModelB();
		
		// Index for difference:
		this.navigation = new DifferenceNavigation(historicalToResolved);
	}
	
	public LearnEditRule(DifferenceSettings matchingSettings,
			Resource modelHistorical,
			Resource modelResolved) {
		
		this.modelHistorical = modelHistorical;
		this.modelCurrent = modelResolved;
		
		// Calculate difference: Historical -> Resolved
		this.matchingSettings = matchingSettings;
		
		try {
			historicalToResolved = deriveTechnicalDifference(modelHistorical, modelResolved, matchingSettings);
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		this.navigation = new DifferenceNavigation(historicalToResolved);
	}

	/**
	 * @param modelIntroduced
	 *            (First) occurrence of of the inconsistency.
	 * @param consistencyRule
	 *            The violated consistency rule.
	 */
	public DifferenceSlice learnByResolvedInconsistency(EObject introducedContext, IConstraint consistencyRule) {
		
		try {
			
			// Calculate mapping from introduced model version to resolved model version:
			SymmetricDifference intorducedToResolved = deriveTechnicalDifference(
					introducedContext.eResource(), modelCurrent, matchingSettings);
			
			// Search resolved context element:
			EObject contextResolved = intorducedToResolved.getCorrespondingObjectInB(introducedContext);
			
			// Learn edit-rule:
			return learnByConsistentChange(contextResolved, consistencyRule);
			
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param contextCurrent
	 *            The current model version.
	 * @param consistencyRule
	 *            The validated consistency rule.
	 */
	public DifferenceSlice learnByConsistentChange(EObject contextCurrent, IConstraint consistencyRule) {
		
		// Validation //
		EObject contextHistorical = historicalToResolved.getCorrespondingObjectInA(contextCurrent);
		assert (contextHistorical != null);
		
		// Scope: Historical 
		IScopeRecorder scopeHistorical = new ScopeRecorder();
		consistencyRule.evaluate(contextHistorical, scopeHistorical);
		
		// Scope: Resolved
		IScopeRecorder scopeResolved = new ScopeRecorder();
		consistencyRule.evaluate(contextCurrent, scopeResolved);
		
		return learnByConsistentChange( 
				scopeResolved.getScope(),
				IReferenceFilter.DUMMY, IAttributeFilter.DUMMY,
				scopeResolved.getScope(),
				IReferenceFilter.DUMMY, IAttributeFilter.DUMMY);
	}
	
	/**
	 * @param historicalFragment
	 *            The historical validated fragment.
	 * @param revisedFragment
	 *            The revised validated fragment.
	 */
	public DifferenceSlice learnByConsistentChange(
			Set<EObject> historicalFragment,
			IReferenceFilter historicalReferenceFilter, IAttributeFilter historicalAttributeFilter,
			Set<EObject> revisedFragment, 
			IReferenceFilter revisedReferenceFilter, IAttributeFilter revisedAttributeFilter) {
		
		// Initialize slicing criterion:
		DifferenceSlicingCriterion slicingCriterion = new DifferenceSlicingCriterion();
		
		// Fragment: Historical 
		slicingCriterion.setHistoricalFragment(historicalFragment);
		slicingCriterion.setHistoricalReferenceFilter(historicalReferenceFilter);
		slicingCriterion.setHistoricalAttributeFilter(historicalAttributeFilter);
		
		// Fragment: Revised
		slicingCriterion.setRevisedFragment(revisedFragment);
		slicingCriterion.setRevisedReferenceFilter(revisedReferenceFilter);
		slicingCriterion.setRevisedAttributeFilter(revisedAttributeFilter);
		
		// Difference Slice //
		
		slicer = new DifferenceSlicer(slicingCriterion, navigation);
		return slicer.getSlice();
	}
	
	public DifferenceNavigation getNavigation() {
		return navigation;
	}

	public void setNavigation(DifferenceNavigation navigation) {
		this.navigation = navigation;
	}
	 
	public static String generateName(Validation validation) {
		return validation.getRule().getName() + "_" + EcoreUtil.generateUUID();
	}
	
	public static URI generateURI(String editRuleName, Resource relativeToResource) {
		return relativeToResource.getURI().trimSegments(1)
				.appendSegment(editRuleName + "_execute")
				.appendFileExtension("henshin");
	}
	
	public static Module generateEditRule(String ruleName, DifferenceSlice differenceSlice) {
		Module editRule = CreateEditRuleHandler.createEditRule(ruleName, 
				differenceSlice.getCorrespondences(), differenceSlice.getChanges());
		return editRule;
	}
	
	public static void saveEditRule(Module editRule, URI eoURI, boolean showDiagram, boolean showMessage) {
		
		if (editRule != null) {
			editRule.getImports().addAll(EditRuleUtil.getImports(editRule));
			
			Resource eoRes = new ResourceSetImpl().createResource(eoURI);
			eoRes.getContents().add(editRule);

			try {
				eoRes.save(Collections.emptyMap());
				Resource diagramResource = HenshinDiagramUtil.createDiagram(editRule);
				
				if (showDiagram && HenshinDiagramUtil.maxNodeCount(editRule, 100)) {
					HenshinDiagramUtil.openDiagram(diagramResource);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (showMessage) {
				WorkbenchUtil.showMessage("Edit-Rule saved:\n\n" + eoURI.toPlatformString(true));
			}
		} else {
			if (showMessage) {
				WorkbenchUtil.showError("Could not transform this difference to an edit-rule.");
			}
		}
	}
}
