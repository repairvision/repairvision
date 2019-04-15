package org.sidiff.common.emf.access.path.conditions;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;
import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;

/**
 * Condition that prohibits that a reference is traversed that has been traversed right before.
 * @author wenzel
 *
 */
public class NoBackstep extends EMFCondition {
	
	private EMFPathStepImpl lastStep = null;
	
	public NoBackstep(String argumentString) {
		
		super(argumentString);
		if(argumentString!=null){
			throw new SiDiffRuntimeException(this,
					"Illegal Argument: '"+argumentString+"' Cannot processed by Condition");
		}
	}

	@Override
	public void initCondition(EMFPathStepImpl step) {
		
		EMFPathStepImpl lastStep = step.getAncestorStep();
		if(lastStep!=null&&step.resultType().isSuperTypeOf(lastStep.resultType())){
			this.lastStep=lastStep;
		} else {
			LogUtil.log(LogEvent.WARNING, 
					"Configuration Error: Impossible backstep from "+step.resultType().getName()+" to "+((lastStep!=null)? lastStep.resultType().getName() : "null"));
		}
	}

	@Override
	public boolean select(EObject item) {
		
		if(lastStep!=null){
			return !lastStep.result().contains(item);
		} 
		return true;
	}


}
