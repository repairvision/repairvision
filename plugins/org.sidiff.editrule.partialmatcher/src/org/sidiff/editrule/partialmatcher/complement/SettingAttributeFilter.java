package org.sidiff.editrule.partialmatcher.complement;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.view.AttributePair;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.editrule.partialmatcher.scope.RepairScope;

public class SettingAttributeFilter {

	public boolean substituteSettingAttributes(Rule complementRule, Match match, RepairScope scope) {
		
		// Keep only the given attributes in the complement rule:
		// Get all << set >> attributes in << create >> nodes:
		for(Attribute complementAttribute : ChangePatternUtil.getSettingAttributes(complementRule)) {
			if (!isRepairableAttributes(complementAttribute, match, scope)) {
				complementAttribute.getNode().getAttributes().remove(complementAttribute);
			}
		}
		
		// Get all << set >> attributes in << preserve >> nodes:
		for(AttributePair complementAttributePair : ChangePatternUtil.getChangingAttributes(complementRule)) {
			Attribute complementAttribute = complementAttributePair.getRhsAttribute();
			
			if (!isRepairableAttributes(complementAttribute, match, scope)) {
				complementAttribute.getNode().getAttributes().remove(complementAttribute);
			}
		}

		return true;
	}
	
	protected boolean isRepairableAttributes(Attribute attribute, Match match, RepairScope scope) {
		
		// TODO!!!
		
		return false;
	}
}
