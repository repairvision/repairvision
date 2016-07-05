package org.sidiff.consistency.repair.validation.terms.functions;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.consistency.repair.validation.terms.Term;

public class Path extends Function {

	protected Term start;
	
	protected EReference path;
	
	public static Path create(Term start, EReference path) {
		Path newPath = new Path();
		newPath.start = start;
		
		return newPath;
	}

	@Override
	public Collection<EObject> evaluate() {
		value = new ArrayList<EObject>();
		
		for (EObject startObject : start.getValue()) {
			value.add((EObject) startObject.eGet(path));
		}
		
		return value;
	}
}
