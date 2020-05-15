package org.sidiff.repair.history.editrules.driver;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.history.analysis.tracing.InconsistencyTrace;
import org.sidiff.historymodel.History;
import org.sidiff.repair.history.editrules.generator.EditRule;
import org.sidiff.repair.history.editrules.learn.scope.LearnEditRule;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.derivation.api.TechnicalDifferenceFacade;
import org.sidiff.revision.difference.derivation.api.settings.DifferenceSettings;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ScopeRecorder;

public class LearnEditRuleDriver {
	
	public static void learnEditRule(
			History history, List<IConstraint> supportedConsistencyRules,
			DifferenceSettings differenceSettings, InconsistencyTrace repaired) {
		
		Difference historicalToResolved = calcualteDifference(true,
				repaired.getModelHistorical(), repaired.getModelResolved(), differenceSettings);

		Difference actualToResolved = calcualteDifference(true,
				repaired.getModelCurrent(), repaired.getModelResolved(), differenceSettings);

		Difference actualToHistorical = calcualteDifference(true,
				repaired.getModelCurrent(), repaired.getModelHistorical(), differenceSettings);
		
		// Validation:
		EObject actualInvalidContext = repaired.getProblemCurrentModel().getContextElement();
		IConstraint constraint = repaired.getConsistencyRule(supportedConsistencyRules);

		EObject historicalInvalidContext = actualToHistorical.getCorrespondingObjectInB(actualInvalidContext);
		EObject resolvedInvalidContext = actualToResolved.getCorrespondingObjectInB(actualInvalidContext);

		// Validation historical:
		IScopeRecorder historicalFragment = IScopeRecorder.DUMMY;

		if (historicalInvalidContext != null) {
			historicalFragment = new ScopeRecorder();
			constraint.evaluate(historicalInvalidContext, historicalFragment);
		}

		// Validation resolved:
		IScopeRecorder resolvedFragment = IScopeRecorder.DUMMY;

		if (resolvedInvalidContext != null) {
			resolvedFragment = new ScopeRecorder();
			constraint.evaluate(resolvedInvalidContext, resolvedFragment);
		}

		// Learn edit rule:
		if ((historicalFragment != IScopeRecorder.DUMMY) || (resolvedFragment != IScopeRecorder.DUMMY)) {
			String editRuleName = LearnEditRule.generateName(actualInvalidContext);
			EditRule editRule = new EditRule(
					editRuleName, historicalToResolved, 
					historicalFragment, resolvedFragment);
			URI uri = LearnEditRule.generateURI(editRuleName, history.eResource());
			editRule.saveEditRule(uri, true);
		} else {
			WorkbenchUtil.showError("Inconsistency trace could not be found!");
		}
	}
	
	private static Difference calcualteDifference(
			boolean ignoreNoCorrespondences,
			Resource modelA, Resource modelB,
			DifferenceSettings differenceSettings) {
		
		Difference difference = TechnicalDifferenceFacade.deriveTechnicalDifference(
				modelA, modelB, differenceSettings);
		return difference;
	}
}
