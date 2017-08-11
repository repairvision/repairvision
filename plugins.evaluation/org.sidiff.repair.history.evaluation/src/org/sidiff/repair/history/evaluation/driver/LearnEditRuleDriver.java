package org.sidiff.repair.history.evaluation.driver;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Module;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.repair.history.editrules.learning.DifferenceSlice;
import org.sidiff.repair.history.editrules.learning.LearnEditRule;
import org.sidiff.repair.history.evaluation.driver.data.HistoryInfo;
import org.sidiff.repair.history.evaluation.driver.data.RepairedInconsistency;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class LearnEditRuleDriver {
	
	public static void learnEditRule(HistoryInfo history, 
			DifferenceSettings differenceSettings, RepairedInconsistency repaired) {
		
		LearnEditRule learnEditRule = new LearnEditRule(differenceSettings, 
				repaired.getModelActual(), repaired.getModelResolved());
		
		EObject invalidContext = repaired.getValidationErrorActualModel().getInvalidElement().get(0);
		IConstraint consistencyRule = repaired.getConsistencyRule(history.getSupportedConsistencyRules());

		DifferenceSlice differenceSlice = learnEditRule.learnByResolvedInconsistency(invalidContext, consistencyRule);

		String editRuleName = LearnEditRule.generateName(invalidContext);
		Module editRule = LearnEditRule.generateEditRule(editRuleName, differenceSlice);
		URI uri = LearnEditRule.generateURI(editRuleName, history.getHistory().eResource());
		LearnEditRule.saveEditRule(editRule, uri, true, true);
	}
}
