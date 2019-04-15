package org.sidiff.common.emf.access.path.axis;

import java.util.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;

public class Parent extends EMFAxis {

	public Parent(String argumentString) {
		super(argumentString);
	}

	@Override
	public Collection<EObject> evaluateAxis(Collection<EObject> contextObjects) {
		
		List<EObject> result = new LinkedList<EObject>();
		for(EObject contextObject : contextObjects){
			if(contextObject.eContainer()!=null){
				result.add(contextObject.eContainer());
			}
		}
		return result;
	}

	@Override
	public void initAxis(EMFPathStepImpl step) {
	}

	@Override
	public EClass resultType() {
		// This axis cannot determ a result type. The resulttype is implied by the Step!
		return null;
	}

}
