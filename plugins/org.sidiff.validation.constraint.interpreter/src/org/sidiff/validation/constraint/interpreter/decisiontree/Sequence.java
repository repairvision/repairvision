package org.sidiff.validation.constraint.interpreter.decisiontree;

public class Sequence extends DecisionNode  {

	public static Sequence nextSequence(IDecisionNode parent) {
		
		// Repair tree cosmetics:
		if (parent instanceof Sequence) {
			return (Sequence) parent;
		} else {
			Sequence newSequenec = new Sequence();
			parent.appendChildDecisions(newSequenec);
			return newSequenec;
		}
	}
	
	public static void cleanup(IDecisionNode parent, Sequence sequence) {
		
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
	public String toString() {
		return containerToString() + "\n" + childrenToString();
	}
}
