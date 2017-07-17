package org.sidiff.validation.constraint.interpreter.decisiontree;

import java.util.Iterator;
import java.util.List;

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
	
	public static void cleanup(IDecisionBranch parent, Sequence sequence) {
		
		// Repair tree cosmetics:
		if (sequence.getChildDecisions().size() == 1) {
			parent.removeChildDecision(sequence);
			parent.appendChildDecisions(sequence.getChildDecisions().get(0));
		}
		
		else if (parent instanceof Sequence) {
			parent.removeChildDecision(sequence);
			
			for (IDecisionNode child : sequence.getChildDecisions()) {
				parent.appendChildDecisions(child);
			}
		}
	}
	
	@Override
	public String containerToString() {
		return "(+)Sequence@" + Integer.toHexString(hashCode()) + ":";
	}

	@Override
	public Iterator<List<? extends IDecisionNode>> traversal() {
		return new SequenceTraversal(this);
	}
}
