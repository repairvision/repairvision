package org.sidiff.common.emf.access.path.conditions;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;
import org.sidiff.common.emf.ocl.OCLCondition;
import org.sidiff.common.emf.ocl.OCLUtil;

/**
 * Condition that checks an OCL constraint.
 * @author wenzel
 *
 */
public class OCL extends EMFCondition {

	OCLCondition oclCondition;
	
	public OCL(String argumentString) {
		super(argumentString);
		oclCondition = OCLUtil.createCondition(argumentString,null);
	}

	@Override
	public void initCondition(EMFPathStepImpl step) {
		//oclCondition = OCLUtil.createCondition(argumentString, step.contextType());
	}

	@Override
	public boolean select(EObject item) {
		return oclCondition.check(item);
	}
}