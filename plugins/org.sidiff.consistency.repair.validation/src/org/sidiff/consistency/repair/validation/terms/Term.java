package org.sidiff.consistency.repair.validation.terms;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.repair.validation.NamedElement;

public abstract class Term extends NamedElement  {

	protected Collection<EObject> value;
	
	public  Collection<EObject> getValue() {
		return value;
	}
	
	public abstract Collection<EObject> evaluate();
}
