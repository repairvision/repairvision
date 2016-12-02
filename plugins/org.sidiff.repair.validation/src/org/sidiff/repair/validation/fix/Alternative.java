package org.sidiff.repair.validation.fix;

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
	
	public static void cleanup(IRepairDecision parent, Alternative alternative) {
		
		// Repair tree cosmetics:
		if (parent != alternative) {
			if (alternative.getChildDecisions().size() == 1) {
				parent.removeChildDecision(alternative);
				parent.appendChildDecisions(alternative.getChildDecisions().get(0));
			}
			
			else if (parent instanceof Alternative) {
				parent.removeChildDecision(alternative);
				
				for (IRepairDecision child : alternative.getChildDecisions()) {
					parent.appendChildDecisions(child);
				}
			}
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
