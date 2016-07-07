package org.sidiff.consistency.repair.validation.fix;

public class Sequence extends NodeRepairDecision  {

	public static Sequence nextSequence(IRepairDecision parent) {
		
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
	public String containerToString() {
		return "(+)Sequence@" + Integer.toHexString(hashCode()) + ":";
	}
	
	@Override
	public String toString() {
		return containerToString() + "\n" + childrenToString();
	}
}
