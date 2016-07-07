package org.sidiff.consistency.repair.validation.fix;

public class Sequence extends AbstractRepairDecision  {

	@Override
	public String containerToString() {
		return "(+)Sequence@" + Integer.toHexString(hashCode()) + ":";
	}
	
	@Override
	public String toString() {
		return containerToString() + "\n" + childrenToString();
	}
}
