package org.sidiff.repair.history.editrules.driver;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.ui.util.UIUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricFactory;
import org.sidiff.history.analysis.tracing.InconsistencyTrace;
import org.sidiff.historymodel.History;
import org.sidiff.matching.model.Matching;
import org.sidiff.matching.model.MatchingModelFactory;
import org.sidiff.repair.history.editrules.generator.EditRule;
import org.sidiff.repair.history.editrules.learn.scope.LearnEditRule;
import org.sidiff.revision.difference.derivation.api.TechnicalDifferenceFacade;
import org.sidiff.revision.difference.derivation.api.settings.DifferenceSettings;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.interpreter.scope.IScopeRecorder;
import org.sidiff.validation.constraint.interpreter.scope.ScopeRecorder;

public class LearnEditRuleDriver {
	
	public static void learnEditRule(
			History history, List<IConstraint> supportedConsistencyRules,
			DifferenceSettings differenceSettings, InconsistencyTrace repaired) {
		
		SymmetricDifference historicalToResolved = calcualteDifference(true,
				repaired.getModelHistorical(), repaired.getModelResolved(), differenceSettings);

		SymmetricDifference actualToResolved = calcualteDifference(true,
				repaired.getModelCurrent(), repaired.getModelResolved(), differenceSettings);

		SymmetricDifference actualToHistorical = calcualteDifference(true,
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
			UIUtil.showError("Inconsistency trace could not be found!");
		}
	}
	
	private static SymmetricDifference calcualteDifference(
			boolean ignoreNoCorrespondences,
			Resource modelA, Resource modelB,
			DifferenceSettings differenceSettings) {
		
		try {
			SymmetricDifference difference = TechnicalDifferenceFacade.deriveTechnicalDifference(
					modelA, modelB, differenceSettings);
			return difference;
		} catch (InvalidModelException e) {
			UIUtil.showError("Invalid Models:\n" + "  " + modelA + "\n" + "  " + modelB + "\n");
		} catch (NoCorrespondencesException e) {
			if (!ignoreNoCorrespondences) {
				UIUtil.showError("No Correspondences Found:\n" + "  " + modelA + "\n" + "  " + modelB + "\n");
			}
		}
		
		// Empty difference:
		Matching matching = MatchingModelFactory.eINSTANCE.createMatching();
		matching.setEResourceA(modelA);
		matching.setEResourceB(modelB);
		matching.setUriA(modelA.getURI().toString());
		matching.setUriB(modelB.getURI().toString());
		
		SymmetricDifference symmetricDifference = SymmetricFactory.eINSTANCE.createSymmetricDifference();
		symmetricDifference.setMatching(matching);
		symmetricDifference.setUriModelA(modelA.getURI().toString());
		symmetricDifference.setUriModelB(modelB.getURI().toString());
		
		return symmetricDifference;
	}
}
