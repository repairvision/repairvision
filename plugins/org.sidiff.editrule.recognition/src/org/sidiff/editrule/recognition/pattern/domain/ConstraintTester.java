package org.sidiff.editrule.recognition.pattern.domain;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.common.emf.MetaModelUtil;

public class ConstraintTester {

	public static boolean check(Domain domain, EObject object) {
		
		// Check types!
		if (!MetaModelUtil.isAssignableTo(object.eClass(), domain.getType())) {
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
