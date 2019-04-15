package org.sidiff.common.emf.ocl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;

/**
 * Encapsulation of an OCL condition.
 * 
 * @author wenzel
 *
 */
public class OCLCondition {
	
	private EObjectCondition condition;
	private String expression;
	
	OCLCondition(String expression, EObjectCondition condition) {
		this.expression = expression;
		this.condition = condition;
	}
	
	public String getExpression() {
		return expression;
	}

	public boolean check(EObject object) {
		return this.condition.isSatisfied(object);
	}

}
