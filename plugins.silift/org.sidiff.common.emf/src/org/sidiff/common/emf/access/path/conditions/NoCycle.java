package org.sidiff.common.emf.access.path.conditions;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;
import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;

/**
 * Condition that prohibits that cycles are traversed.
 * @author wenzel
 *
 */
public class NoCycle extends EMFCondition {

	private Collection<EMFPathStepImpl> possibleCyclesOnPath = null;
	
	public NoCycle(String argumentString) {
		
		super(argumentString);
		if(argumentString!=null){
			throw new SiDiffRuntimeException(this,
					"Illegal Argument: '"+argumentString+"' Cannot processed by Condition");
		}
	}

	@Override
	public void initCondition(EMFPathStepImpl step) {
		
		EMFPathStepImpl currentStep = step;
		this.possibleCyclesOnPath = new LinkedList<EMFPathStepImpl>();
		
		while(currentStep.getAncestorStep()!=null){
			currentStep = currentStep.getAncestorStep();
			if(currentStep.resultType().isSuperTypeOf(step.resultType())){
				// Hier merken wir uns alle stellen, an denen es potentiell zu zyklen kommen kann
				this.possibleCyclesOnPath.add(currentStep);
			}	
		}
		 if(this.possibleCyclesOnPath.isEmpty()) {
			LogUtil.log(LogEvent.WARNING, 
					"Configuration Error: No Possible cycles found! "+step);
		}
		
	}

	@Override
	public boolean select(EObject item) {
		
		for(EMFPathStepImpl step : this.possibleCyclesOnPath){
			if(step.result().contains(item)) return false;
		}
		return true;
	}

}
