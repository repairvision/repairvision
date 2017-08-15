package org.sidiff.validation.constraint.interpreter.decisiontree;

import java.util.Iterator;
import java.util.List;

public class Alternative extends DecisionBranch {
	
	public static Alternative nextAlternative(IDecisionBranch parent) {
		
		// Repair tree cosmetics:
		if (parent instanceof Alternative) {
			return (Alternative) parent;
		} else {
			Alternative newAlternative = new Alternative();
			parent.appendChildDecisions(newAlternative);
			return newAlternative;
		}
	}
	
	@Override
	public String containerToString() {
		return "(*)Alternative@" + Integer.toHexString(hashCode()) + ":";
	}

	@Override
	public Iterator<List<? extends IDecisionNode>> combinations() {
		return new AlternativeCombinations(this);
	}
}
