package org.sidiff.editrule.partialmatcher.scope;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.view.AttributePair;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.repair.api.matching.EditOperationMatching;
import org.sidiff.repair.complement.util.ComplementUtil;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;

public class SettingAttributeFilter {

	public static void filterSettingAttributes(Rule complementRule, 
			EditOperationMatching prematch, RepairActionFilter repairActionFilter) {
		
		// Keep only the given attributes in the complement rule:
		// Get all << set >> attributes in << create >> nodes:
		for(Attribute complementAttribute : ChangePatternUtil.getSettingAttributes(complementRule)) {
			
			// Remove only input parameters -> filter constant values:
			if (complementRule.getParameter(complementAttribute.getValue()) != null) {
				if (!repairActionFilter.filter(Collections.singletonList(complementAttribute), prematch.getMatch())) {
					complementAttribute.getNode().getAttributes().remove(complementAttribute);
				}
			}
		}
		
		// Get all << set >> attributes in << preserve >> nodes:
		for(AttributePair complementAttributePair : ChangePatternUtil.getChangingAttributes(complementRule)) {
			Attribute complementAttribute = complementAttributePair.getRhsAttribute();
			
			// Remove only input parameters -> filter constant values:
			if (complementRule.getParameter(complementAttribute.getValue()) != null) {
				if (!repairActionFilter.filter(Collections.singletonList(complementAttribute), prematch.getMatch())) {
					complementAttribute.getNode().getAttributes().remove(complementAttribute);
				}
			}
		}
		
		// Substitute already set constant << create >> attributes:
		for (AttributePair attribute : ChangePatternUtil.getChangingAttributes(complementRule)) {

			// Is variable value?
			if (complementRule.getParameter(attribute.getRhsAttribute().getValue()) == null) {
				Node node = HenshinRuleAnalysisUtilEx.getLHS(attribute.getRhsAttribute().getNode());
				EObject match = prematch.getMatch().getNodeTarget(node);

				if (match != null) {
					Object valueB = match.eGet(attribute.getType());
					String valueRHS = attribute.getRhsAttribute().getValue();

					if (valueRHS.startsWith("\"") && valueRHS.endsWith("\"")) {
						valueRHS = valueRHS.substring(1, valueRHS.length() - 1);
					}

					if (valueB.equals(valueRHS)) {
						ComplementUtil.makePreserve(attribute.getRhsAttribute());
					}
				}

			}
		}
	}
}
