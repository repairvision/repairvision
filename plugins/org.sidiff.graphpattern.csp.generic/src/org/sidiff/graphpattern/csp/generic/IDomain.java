package org.sidiff.graphpattern.csp.generic;

public interface IDomain<D> extends Iterable<D> {
	
	void applyRestriction(IVariable<?, D> origin, D value);
	
	void undoRestriction(IVariable<?, D> origin);
	
	boolean isEmpty();
}
