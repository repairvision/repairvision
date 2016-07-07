package org.sidiff.consistency.repair.validation.fix;

public class Alternative extends NodeRepairDecision {
	
	public static Alternative nextAlternative(IRepairDecision parent) {
		
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
	public String toString() {
		return containerToString() + "\n" + childrenToString();
	}
}
