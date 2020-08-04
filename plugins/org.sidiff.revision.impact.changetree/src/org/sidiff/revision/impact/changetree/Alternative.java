package org.sidiff.revision.impact.changetree;

import java.util.Iterator;
import java.util.List;

import org.sidiff.revision.impact.changetree.util.AlternativeCombinations;

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

	@Override
	public IDecisionBranch deepCopy() {
		Alternative copy = new Alternative();
		
		for (IDecisionNode child : this.getChildDecisions()) {
			copy.getChildDecisions().add(child.deepCopy());
		}
		
		return copy;
	}
}
