package org.sidiff.repair.history.editrules.learn.scope;

import static org.sidiff.revision.difference.api.DifferenceFacade.difference;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.editrules.generation.difference.DifferenceToEditRule;
import org.sidiff.revision.editrules.generation.difference.builder.HenshinBuilder;
import org.sidiff.revision.editrules.generation.difference.configuration.SymmetricModelDifference;
import org.sidiff.revision.editrules.generation.difference.configuration.TransformationConfiguration;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IAttributeFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IReferenceFilter;
import org.sidiff.revision.editrules.generation.difference.util.DifferenceToEditRuleUtil;
import org.sidiff.revision.impact.changetree.scope.IScopeRecorder;
import org.sidiff.revision.impact.changetree.scope.ScopeRecorder;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.interpreter.IConstraint;

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
	protected Difference historicalToResolved; 
	
	/**
	 * RevisionDifference navigation: historical, resolved
	 */
	protected DifferenceNavigation navigation;
	
	/**
	 * The slicing algorithm.
	 */
	protected DifferenceSlicer slicer;
	
	/**
	 * Graph transformation language binding.
	 */
	protected HenshinBuilder language = new HenshinBuilder();
	
	public LearnEditRule(Difference historicalToResolved) {
		
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
		
		historicalToResolved = difference(modelHistorical, modelResolved, matchingSettings);
		
		this.navigation = new DifferenceNavigation(historicalToResolved);
	}

	/**
	 * @param modelIntroduced
	 *            (First) occurrence of of the inconsistency.
	 * @param consistencyRule
	 *            The violated consistency rule.
	 */
	public DifferenceSlice learnByResolvedInconsistency(EObject invalidContext, IConstraint consistencyRule) {

		// Calculate mapping from introduced model version to resolved model version:
		Difference invalidToResolved = difference(invalidContext.eResource(), modelCurrent, matchingSettings);

		// Search resolved context element:
		EObject contextResolved = invalidToResolved.getCorrespondingObjectInB(invalidContext);

		// Learn edit-rule:
		return learnByConsistentChange(contextResolved, consistencyRule);
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
				IReferenceFilter.FILTER_NONE, IAttributeFilter.FILTER_ALL,
				scopeResolved.getScope(),
				IReferenceFilter.FILTER_NONE, IAttributeFilter.FILTER_ALL);
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
		
		// RevisionDifference Slice //
		
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
		return generateName(validation.getContext());
	}
	
	public static String generateName(Validation validation, String signature) {
		return generateName(validation.getContext(), signature);
	}
	
	public static String generateName(EObject context) {
		return generateName(context, EcoreUtil.generateUUID());
	}
	
	public static String generateName(EObject context, String signature) {
		return context.eClass().getName() + signature;
	}
	
	public static String generateDescription(Validation validation) {
		return validation.getRule().getName();
	}
	
	public static URI getFolder(Resource resource) {
		return resource.getURI().trimSegments(1);
	}
	
	public static URI getFolder(String workspacePath) {
		return URI.createPlatformResourceURI(workspacePath, true);
	}
	
	public Module generateEditRule(String ruleName, DifferenceSlice differenceSlice) {
		SymmetricModelDifference difference = new SymmetricModelDifference(
				historicalToResolved, differenceSlice.getCorrespondences(), differenceSlice.getChanges());
		
		TransformationConfiguration trafoSetup = new TransformationConfiguration(ruleName, difference);
		DifferenceToEditRule<Rule, Node, Edge, Attribute> editRuleRecorder 
			= new DifferenceToEditRule<Rule, Node, Edge, Attribute>(language, trafoSetup);
		return editRuleRecorder.transform().getModule();
	}
	
	public void saveEditRule(Rule editRule, URI folder, String nameWithoutFileExtension, boolean showDiagram, boolean showMessage) {
		
		if (editRule != null) {
			DifferenceToEditRuleUtil.saveEditRule(language, folder, nameWithoutFileExtension, showDiagram, showMessage, 150);
		} else {
			if (showMessage) {
				WorkbenchUtil.showError("Could not transform this difference to an edit-rule.");
			}
		}
	}
}
