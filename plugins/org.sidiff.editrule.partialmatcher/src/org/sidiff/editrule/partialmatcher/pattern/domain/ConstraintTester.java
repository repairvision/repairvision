package org.sidiff.editrule.partialmatcher.pattern.domain;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.editrule.partialmatcher.util.MatchingHelper;

public class ConstraintTester {

	public static boolean check(Domain domain, EObject object) {
		
		// Check types!
		if (!MatchingHelper.isAssignableTo(object.eClass(), domain.getType())) {
			return false;
		}
		
		// Check constant attributes!
		for (AttributeConstant attribute : domain.getAttributes()) {
			Object instanceValue = object.eGet(attribute.getType());
			
			if (!attribute.getValue().equals(instanceValue)) {
				return false;
			}
		}
	
		return true;
	}
}
