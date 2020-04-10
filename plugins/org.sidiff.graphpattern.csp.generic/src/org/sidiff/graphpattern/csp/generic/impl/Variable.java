package org.sidiff.graphpattern.csp.generic.impl;

import org.sidiff.graphpattern.csp.generic.IConstraintSatisfactionProblem;
import org.sidiff.graphpattern.csp.generic.IDomain;
import org.sidiff.graphpattern.csp.generic.IVariable;

public class Variable<R, D> implements IVariable<R, D> {
	
	protected IConstraintSatisfactionProblem<R, D> csp;
	
	protected R subject;
	
	protected int index = -1;
	
	protected boolean removable = true;
	
	protected boolean maximize = false;
	
	protected IDomain<D> domain;
	
	protected D value;
	
	/**
	 * @param subject   The subject that is represented by this variable.
	 * @param domain    All values that could be assigned to this variable.
	 * @param removable <code>true</code> if this variable can be removed from the
	 *                  CSP to find a (partial) solution.
	 * @param maximize  <code>true</code> if this variable must be assigned if a
	 *                  value is available, i.e. the solution should be maximized
	 *                  for this variable; <code>false</code> otherwise.
	 */
	public Variable(R subject, IDomain<D> domain, boolean removable, boolean maximize) {
		super();
		this.subject = subject;
		this.domain = domain;
		this.removable = removable;
		this.maximize = maximize;
	}

	@Override
	public void setCSP(IConstraintSatisfactionProblem<R, D> csp) {
		this.csp = csp;
	}
	
	@Override
	public R getSubject() {
		return subject;
	}
	
	@Override
	public int getIndex() {
		return index;
	}
	
	@Override
	public void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public boolean isRemovable() {
		return removable;
	}
	
	@Override
	public void setRemovable(boolean removable) {
		this.removable = removable;
	}
	
	@Override
	public boolean isMaximizeSolution() {
		return this.maximize;
	}
	
	@Override
	public void setMaximizeSolution(boolean maximize) {
		this.maximize = maximize;
	}
	
	@Override
	public IDomain<D> getDomain() {
		return domain;
	}
	
	@Override
	public D getValue() {
		return value;
	}
	
	@Override
	public boolean isAssignable() {
		
		// necessary condition:
		return !domain.isEmpty();
		
		// TODO[Subclasses]: Check for restrictions (if assign() can fail)!
	}

	@Override
	public boolean assign(D value) {
		this.value = value;
		return applyRestrictions();
	}
	
	@Override
	public void free() {
		undoRestrictions();
		this.value = null;
	}
	
	@Override
	public boolean applyRestrictions() {
		
		if (csp.isSearchInjectiveSolutions()) {
			
			// restrict value for all potentially pickable variable domains:
			csp.getVariables().getPotential().forEachRemaining(variable -> {
				variable.getDomain().applyRestriction(this, value);
			});
		} else {
			
			// restrict this variable domain to assigned value:
			domain.applyRestriction(this, value);
		}
		
		// TODO[Subclasses]: Calculate restrictions of all other variable domains 
		//                   based on the currently assigned value!
		return true;
	}
	
	@Override
	public void undoRestrictions() {
		
		if (csp.isSearchInjectiveSolutions()) {
			
			// restrict value for all potentially pickable variable domains:
			// TODO: Check performance of this implementation!
			csp.getVariables().getPotential().forEachRemaining(variable -> {
				variable.getDomain().undoRestriction(this);
			});
		} else {
			
			// undo variable restriction domain to assigned value:
			domain.undoRestriction(this);
		}
		
		// TODO[Subclasses]: Undo restrictions of all other variable domains 
		//                   based on the currently assigned value!
	}
	
	public String toString() {
		return "#" + index + ": "+ value;
	}
}
