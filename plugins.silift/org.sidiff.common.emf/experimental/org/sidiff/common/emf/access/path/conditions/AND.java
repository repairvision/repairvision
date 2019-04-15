//TODO Review, Asserts, Doku
package org.sidiff.common.emf.access.path.conditions;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;
import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.util.NestedParameterUtil;
import org.sidiff.common.util.ReflectionUtil;

public class AND extends EMFCondition {
	
	private static final String CONDITION_PREFIX = "org.sidiff.common.emf.access.path.conditions.";
	
	//AND[Condition1[..];Condition2[...]]
	EMFCondition condition1 = null;
	EMFCondition condition2 = null;

	public AND(String argumentString) {
		super(argumentString);

		String[] conditions = argumentString.split(";");
		if(conditions[0]!=null){
			condition1 = createCondition(conditions[0]);
		}
		if(conditions[0]!=null){
			condition2 = createCondition(conditions[1]);
		}
	}

	@Override
	public void initCondition(EMFPathStepImpl step) {
		condition1.initCondition(step);
		condition2.initCondition(step);
	}

	@Override
	public boolean select(EObject item) {
		return (condition1.select(item) && condition2.select(item));
	}

	private EMFCondition createCondition(String conditionString){
		assert(conditionString!=null);
		
		EMFCondition condition = null;
		
		if(NestedParameterUtil.getParameterSegments(conditionString).length==1){
			condition = ReflectionUtil.createInstance(CONDITION_PREFIX+NestedParameterUtil.getTopLevelParameterString(conditionString),EMFCondition.class,
					(NestedParameterUtil.hasNestedParameter(conditionString))? NestedParameterUtil.splitCompositeParamter(conditionString)[1] : null);
		} else {
			throw new SiDiffRuntimeException("Illegal Argument:",conditionString);
		}
		
		return condition;
	}
}
