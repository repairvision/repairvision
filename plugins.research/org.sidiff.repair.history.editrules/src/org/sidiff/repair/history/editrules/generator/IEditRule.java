package org.sidiff.repair.history.editrules.generator;

public interface IEditRule {
	
	String getName();
	
	int getChangeCount();
	
	EditRuleSignature getSignature();
	
	boolean isEqualEditRule(IEditRule otherEditRule);
}
