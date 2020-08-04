package org.sidiff.revision.impact.changetree;

import java.util.Iterator;
import java.util.List;

import org.sidiff.revision.impact.changetree.util.SequenceCombinations;

public class Sequence extends DecisionBranch  {

	public static Sequence nextSequence(IDecisionBranch parent) {
		
		// Repair tree cosmetics:
		if (parent instanceof Sequence) {
			return (Sequence) parent;
		} else {
			Sequence newSequenec = new Sequence();
			parent.appendChildDecisions(newSequenec);
			return newSequenec;
		}
	}

	@Override
	public Iterator<List<? extends IDecisionNode>> combinations() {
		return new SequenceCombinations(this);
	}

	@Override
	public String containerToString() {
		return "(+)Sequence@" + Integer.toHexString(hashCode()) + ":";
	}

	@Override
	public IDecisionBranch deepCopy() {
		Sequence copy = new Sequence();
		
		for (IDecisionNode child : this.getChildDecisions()) {
			copy.getChildDecisions().add(child.deepCopy());
		}
		
		return copy;
	}
}
