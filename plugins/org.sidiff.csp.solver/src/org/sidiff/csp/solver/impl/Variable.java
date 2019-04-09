package org.sidiff.csp.solver.impl;

import org.sidiff.csp.solver.IConstraintSatisfactionProblem;
import org.sidiff.csp.solver.IDomain;
import org.sidiff.csp.solver.IVariable;

public class Variable<R, D> implements IVariable<R, D> {
	
	protected IConstraintSatisfactionProblem<R, D> csp;
	
	protected R subject;
	
	protected int index = -1;
	
	protected boolean removable = true;
	
	protected IDomain<D> domain;
	
	protected D value;
	
	public Variable(R subject, IDomain<D> domain) {
		this.subject = subject;
		this.domain = domain;
	}
	
	public Variable(R subject, IDomain<D> domain, boolean removable) {
		super();
		this.subject = subject;
		this.domain = domain;
		this.removable = removable;
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
		
		// TODO: Check for restrictions (if assign() can fail)!
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
		
		// TODO: Calculate restrictions of all other variable domains 
		//       based on the currently assigned value!
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
		
		// TODO: Undo restrictions of all other variable domains 
		//       based on the currently assigned value!
	}
	
	public String toString() {
		return "#" + index + ": "+ value;
	}
}
