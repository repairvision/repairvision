package org.sidiff.graphpattern.tools.editrules.csp;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;

import org.sidiff.graphpattern.Extendable;
import org.sidiff.graphpattern.Stereotype;

public class EditRulePatternUtil {
	
	public static boolean checkStereotypeCompatibility(Stereotype subEditRule, Stereotype fullEditRule) {
		return 		(subEditRule.equals(preserve) && fullEditRule.equals(create))		// create->use
			 	||	(subEditRule.equals(preserve) && fullEditRule.equals(delete))		// use->delete
			 	||	(subEditRule.equals(preserve) && fullEditRule.equals(preserve))
			 	||	(subEditRule.equals(delete) && fullEditRule.equals(delete))
			 	||	(subEditRule.equals(create) && fullEditRule.equals(create));
	}
	
	public static boolean isChange(Extendable element) {
		return element.getStereotypes().contains(delete) || element.getStereotypes().contains(create);
	}
	
	public static boolean isContext(Extendable element) {
		return element.getStereotypes().contains(preserve);
	}
}
