package org.sidiff.editrule.partialmatcher.scope;

import java.util.Collections;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.view.AttributePair;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.repair.api.matching.EditOperationMatching;

public class SettingAttributeFilter {

	public static boolean filterSettingAttributes(Rule complementRule, 
			EditOperationMatching prematch, RepairActionFilter repairActionFilter) {
		
		// Keep only the given attributes in the complement rule:
		// Get all << set >> attributes in << create >> nodes:
		for(Attribute complementAttribute : ChangePatternUtil.getSettingAttributes(complementRule)) {
			
			// Remove only input parameters -> filter constant values:
			if (complementRule.getParameter(complementAttribute.getValue()) != null) {
				if (!repairActionFilter.filter(Collections.singletonList(complementAttribute), prematch)) {
					complementAttribute.getNode().getAttributes().remove(complementAttribute);
				}
			}
		}
		
		// Get all << set >> attributes in << preserve >> nodes:
		for(AttributePair complementAttributePair : ChangePatternUtil.getChangingAttributes(complementRule)) {
			Attribute complementAttribute = complementAttributePair.getRhsAttribute();
			
			// Remove only input parameters -> filter constant values:
			if (complementRule.getParameter(complementAttribute.getValue()) != null) {
				if (!repairActionFilter.filter(Collections.singletonList(complementAttribute), prematch)) {
					complementAttribute.getNode().getAttributes().remove(complementAttribute);
				}
			}
		}

		return true;
	}
}
