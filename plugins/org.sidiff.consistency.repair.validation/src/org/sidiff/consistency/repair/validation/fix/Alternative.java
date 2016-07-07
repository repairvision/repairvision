package org.sidiff.consistency.repair.validation.fix;

public class Alternative extends AbstractRepairDecision {
	
	@Override
	public String containerToString() {
		return "(*)Alternative@" + Integer.toHexString(hashCode()) + ":";
	}
	
	@Override
	public String toString() {
		return containerToString() + "\n" + childrenToString();
	}
}
