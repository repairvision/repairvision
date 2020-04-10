package org.sidiff.graphpattern.csp.generic.impl.domain;

import org.sidiff.graphpattern.csp.generic.IVariable;

public class ValueRestriction<D> {

	private IVariable<?, D> source;

	private D restrictions;

	public ValueRestriction(IVariable<?, D> source, D restrictions) {
		this.source = source;
		this.restrictions = restrictions;
	}

	public IVariable<?, D> getSource() {
		return source;
	}

	public void setSource(IVariable<?, D> source) {
		this.source = source;
	}

	public D getRestriction() {
		return restrictions;
	}

	public void setRestriction(D restrictions) {
		this.restrictions = restrictions;
	}
}
