package org.sidiff.consistency.repair.lifting.cpo.util;

import java.util.Collection;

import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.HenshinModuleAnalysis;
import org.sidiff.common.henshin.HenshinUnitAnalysis;
import org.sidiff.common.henshin.exceptions.NoMainUnitFoundException;
import org.sidiff.difference.rulebase.view.LiftingRuleBase;
import org.sidiff.difference.rulebase.wrapper.EditWrapper2RecognitionWrapper;
import org.sidiff.editrule.rulebase.EditRule;
import org.sidiff.editrule.rulebase.RuleBase;
import org.sidiff.editrule.rulebase.RuleBaseItem;
import org.sidiff.editrule.rulebase.RulebaseFactory;

public class RulebaseUtil {

	public static LiftingRuleBase createRuleBase(Collection<Rule> editRules, String name) {
		LiftingRuleBase rulebaseView = new LiftingRuleBase();
		
		RuleBase rulebase = RulebaseFactory.eINSTANCE.createRuleBase();
		rulebase.setName(name);
		rulebaseView.init(rulebase);
		
		for (Rule subEditRule : editRules) {

			// Add edit rule:
			EditRule editRuleWrapper = createEditRule(subEditRule.getModule());
			RuleBaseItem rulebaseItem = createItem(editRuleWrapper);
			rulebase.getItems().add(rulebaseItem);

			// Transform edit- to recognition-rule:
			try {
				EditWrapper2RecognitionWrapper edit2Recognition = new EditWrapper2RecognitionWrapper();
				edit2Recognition.transform(rulebaseItem);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return rulebaseView;
	}
	
	/**
	 * Initializes a rule base edit rule wrapper.
	 * 
	 * @return an edit rule wrapper.
	 * @throws NoMainUnitFoundException 
	 */
	private static EditRule createEditRule(Module editModule) {

		// Create edit rule
		try {
			EditRule editRule = RulebaseFactory.eINSTANCE.createEditRule();
			editRule.setExecuteMainUnit(HenshinUnitAnalysis.findExecuteMainUnit(editModule));
			editRule.setUseDerivedFeatures(HenshinModuleAnalysis.hasDerivedReferences(editModule));
			
			return editRule;
		} catch (NoMainUnitFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Creates a new rule base item which includes an edit rule.
	 * 
	 * @param editRule
	 *            The Henshin edit-rule.
	 * 
	 * @return A new rule base item.
	 */
	private static RuleBaseItem createItem(EditRule editRule) {
		
		// Create rule base element
		RuleBaseItem item = RulebaseFactory.eINSTANCE.createRuleBaseItem();
		item.setEditRule(editRule);
		
		return item;
	}
}
