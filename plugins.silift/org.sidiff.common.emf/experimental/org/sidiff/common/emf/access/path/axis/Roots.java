//TODO Review, Asserts, Doku
package org.sidiff.common.emf.access.path.axis;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;

public class Roots extends EMFAxis {

	public Roots(String argumentString) {
		super(argumentString);
		System.err.println("Be careful! The Roots axis is completely untested. It might partly be unimplemented.");
	}

	@Override
	public Collection<EObject> evaluateAxis(Collection<EObject> contextObjects) {
		// TODO Auto-generated method stub
		return null;
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
