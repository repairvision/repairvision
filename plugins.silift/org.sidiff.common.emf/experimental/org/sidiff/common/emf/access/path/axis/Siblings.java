//TODO Review, Asserts, Doku
package org.sidiff.common.emf.access.path.axis;

import java.util.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;

public class Siblings extends EMFAxis {

	public Siblings(String argumentString) {
		super(argumentString);
		System.err.println("Be careful! The Siblings axis is completely untested. It might partly be unimplemented.");
	}

	@Override
	public Collection<EObject> evaluateAxis(Collection<EObject> contextObjects) {
		List<EObject> result = new LinkedList<EObject>();
		for (EObject contextObject : contextObjects) {
			result.addAll(EMFModelAccess.getSiblings(contextObject));
		}
		return result;
	}

	@Override
	public void initAxis(EMFPathStepImpl step) {
		// TODO Auto-generated method stub

	}

	@Override
	public EClass resultType() {
		// TODO Auto-generated method stub
		return null;
	}

}
