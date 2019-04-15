//TODO Review, Asserts, Doku
package org.sidiff.common.emf.access.path.axis;

import java.util.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.path.impl.EMFPathStepImpl;

public class Descendant extends EMFAxis {

	public Descendant(String argumentString) {
		super(argumentString);
		System.err.println("Be careful! The Descendant axis is completely untested. It might partly be unimplemented.");
	}

	@Override
	public Collection<EObject> evaluateAxis(Collection<EObject> contextObjects) {
		List<EObject> result = new LinkedList<EObject>();
		for (EObject contextObject : contextObjects) {
			result.addAll(getDescendants(contextObject));
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

	private Collection<EObject> getDescendants(EObject object) {

		List<EObject> result = new LinkedList<EObject>();
		for (EClass type : EMFModelAccess.getChildrenTypes(object)) {
			for (EObject child : EMFModelAccess.getChildren(object, type)) {
				result.add(child);
				result.addAll(getDescendants(child));
			}
		}
		return result;
	}
}
