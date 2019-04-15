package org.sidiff.common.emf.access.path.axis;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;

public class Self extends EMFAxis {

	private EClass context = null;
	
	public Self(String argumentString) {
		super(argumentString);
		if(argumentString!=null){
			throw new IllegalArgumentException("No axis Parameter allowed! ("+argumentString+")");
		}
	}

	@Override
	public Collection<EObject> evaluateAxis(Collection<EObject> contextObjects) {
		
		return contextObjects;
	}

	@Override
	public void initAxis(EMFPathStepImpl step) {
		
		this.context= step.contextType();
	}

	@Override
	public EClass resultType() {

		return this.context;
	}

}
