package org.sidiff.consistency.repair.validation.terms.functions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.consistency.repair.validation.terms.Term;

public class Get extends Function {

	protected Term start;
	
	protected EStructuralFeature feature;
	
	public Get(Term start, EStructuralFeature feature) {
		super();
		this.start = start;
		this.feature = feature;
	}

	@Override
	public Object evaluate() {
		value = ((EObject) start.evaluate()).eGet(feature);
		return value;
	}
}
