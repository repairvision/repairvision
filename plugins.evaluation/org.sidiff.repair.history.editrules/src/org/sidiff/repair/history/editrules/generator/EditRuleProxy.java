package org.sidiff.repair.history.editrules.generator;

public class EditRuleProxy implements IEditRule {

	protected String name;
	
	protected int changeCount;
	
	protected EditRuleSignature signature;
	
	public EditRuleProxy(IEditRule editRule) {
		this.name = editRule.getName();
		this.changeCount = editRule.getChangeCount();
		this.signature = editRule.getSignature();
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getChangeCount() {
		return changeCount;
	}

	@Override
	public EditRuleSignature getSignature() {
		return signature;
	}

	@Override
	public boolean isEqualEditRule(IEditRule otherEditRule) {
		return otherEditRule.getSignature().equals(getSignature());
	}
}
