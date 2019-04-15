//TODO Review, Asserts, Doku
package org.sidiff.common.emf.access.path.axis;

import java.util.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;

public class Children extends EMFAxis {
	
	EClass resultType;
	// indicates if a special type of children is specified
	boolean filteredChildren;
	// indicates the special type of children
	EClass filteredClass;

	public Children(String argumentString) {
		super(argumentString);
		filteredChildren = !(argumentString == null);
		System.err.println("Be careful! The Children axis is completely untested. It might partly be unimplemented.");
	}

	@Override
	public Collection<EObject> evaluateAxis(Collection<EObject> contextObjects) {
		List<EObject> result = new LinkedList<EObject>();
		
		if(filteredChildren){
			for (EObject contextObject : contextObjects) 
				for (EObject children : contextObject.eContents())
					if (children.eClass().equals(filteredClass))
						result.add(children);		
		} else {
			for (EObject contextObject : contextObjects) 
				result.addAll(contextObject.eContents());
		}
			
		return result;
	}

	@Override
	public void initAxis(EMFPathStepImpl step) {
		//TODO kann contextType auch null sein?
		EClass contextType = step.contextType();
		resultType = EMFMetaAccess.inferCommonSupertype(contextType);
		List<EClass> childrenClasses = EMFMetaAccess.getChildrenClasses(contextType);
		if(filteredChildren){
			for (EClass childrenClass : childrenClasses) 
				if (childrenClass.getName().equals(argumentString))
						filteredClass = childrenClass;
			assert(filteredClass != null) : "Illegal argument: " + argumentString + " is no possible class of the children of " + contextType.getName() ;
		}
	}

	@Override
	public EClass resultType() {
		return resultType;
	}
}