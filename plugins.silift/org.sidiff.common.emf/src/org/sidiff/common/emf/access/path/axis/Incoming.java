package org.sidiff.common.emf.access.path.axis;

import java.util.*;

import org.eclipse.emf.ecore.*;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;
import org.sidiff.common.exceptions.SiDiffRuntimeException;

public class Incoming extends EMFAxis {

	private EReference fromReference = null;
	
	public Incoming(String argumentString) {
		super(argumentString);
	}
	
	@Override
	public void initAxis(EMFPathStepImpl step) {
		
		EClass expectedResultClass = step.resultType();
		if(expectedResultClass!=null){
		EStructuralFeature feature = expectedResultClass.getEStructuralFeature(argumentString);
		if(feature!=null&&feature instanceof EReference){
			fromReference= (EReference)feature;
			if(!fromReference.getEReferenceType().isSuperTypeOf(step.contextType())){
				throw new SiDiffRuntimeException("Reference '"+argumentString+"' does not point to '"+expectedResultClass.getName()+"'");
			}
		} else {
			// Missing EReference feature 
			throw new SiDiffRuntimeException("Reference '"+argumentString+"' not found at '"+expectedResultClass.getName()+"'");
		}
		} else {
			// Wildcat used?? Impossible in conjunction with reverse-traversal
			throw new SiDiffRuntimeException("Type Wildcat not allowed in conjunction with reverse navigation!",step);
		}

	}

	@Override
	public Collection<EObject> evaluateAxis(Collection<EObject> contextObjects) {
	
		List<EObject> result = new LinkedList<EObject>();
		for(EObject contextObject : contextObjects){
			
			assert(this.fromReference.getEReferenceType().isSuperTypeOf(contextObject.eClass())) :
				"Illegal Argument! "+contextObject+" is not a instance of "+this.fromReference.getEReferenceType().getName();
			
			result.addAll(EMFModelAccess.getRefers(contextObject, fromReference));
		}
		return result;
	}

	@Override
	public EClass resultType() {
		// This axis cannot determ a result type. The resulttype is implied by the Step!
		return null;
	}



}
