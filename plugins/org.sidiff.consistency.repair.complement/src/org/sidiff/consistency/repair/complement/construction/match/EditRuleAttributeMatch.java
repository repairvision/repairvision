package org.sidiff.consistency.repair.complement.construction.match;

import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;

public class EditRuleAttributeMatch extends EditRuleMatch {

	private Attribute attribute;
	
	private Object value;

	public EditRuleAttributeMatch(Attribute attribute, Object value) {
		super(Type.CREATE);
		this.attribute = attribute;
		this.value = value;
		
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
