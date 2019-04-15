package org.sidiff.common.emf.access.path.axis;

import java.util.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.*;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;
import org.sidiff.common.exceptions.SiDiffRuntimeException;

public class Outgoing extends EMFAxis {

	private EReference toReference = null;
	
	public Outgoing(String argumentString) {
		super(argumentString);
	}
	
	@Override
	public void initAxis(EMFPathStepImpl step) {
		EStructuralFeature feature = step.contextType().getEStructuralFeature(argumentString);
		if(feature!=null&&feature instanceof EReference){
			toReference= (EReference)feature;
			if(!toReference.getEReferenceType().isSuperTypeOf(step.resultType())){
				throw new SiDiffRuntimeException("Reference '"+argumentString+"' does not point to '"+step.resultType().getName()+"'");
			}
		} else {
			throw new SiDiffRuntimeException("Reference '"+argumentString+"' not found at '"+step.contextType().getName()+"'");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<EObject> evaluateAxis(Collection<EObject> contextObjects) {
		
		List<EObject> result = new LinkedList<EObject>();

		for(EObject contextObject : contextObjects){
			
			assert(this.toReference.getEContainingClass().isSuperTypeOf(contextObject.eClass())) :
				"Illegal Argument! "+contextObject+" is not a instance of "+this.toReference.getEContainingClass().getName();
			
			if(toReference.isMany()){
				result.addAll((EList<EObject>)contextObject.eGet(toReference));
			} else if (toReference.isRequired()) {
				EObject toAdd = (EObject)contextObject.eGet(toReference);
				assert (toAdd != null): toReference + " is required but " + contextObject + " contains no value!";
				result.add(toAdd);
			} else {
				// value is optional!
				EObject toAdd = (EObject)contextObject.eGet(toReference);
				if (toAdd != null){
					result.add(toAdd);
				}
			}
		}

		return result;
	}

	@Override
	public EClass resultType(){		
		return this.toReference.getEReferenceType();
	}
	
}
