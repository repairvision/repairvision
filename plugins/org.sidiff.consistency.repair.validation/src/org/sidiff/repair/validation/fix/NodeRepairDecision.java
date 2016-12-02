package org.sidiff.repair.validation.fix;

import java.util.LinkedList;
import java.util.List;

public class NodeRepairDecision implements IRepairDecision {
	
	protected List<IRepairDecision> repairs = new LinkedList<>();

	@Override
	public void appendChildDecisions(IRepairDecision... repairs) {
		for (IRepairDecision repair : repairs) {
			this.repairs.add(repair);
		}
	}
	
	@Override
	public void removeChildDecision(IRepairDecision repair) {
		repairs.remove(repair);
	}

	@Override
	public List<IRepairDecision> getChildDecisions() {
		return repairs;
	}
	
	public String toString(int indent) {
		StringBuffer print = new StringBuffer();
		
		// This Container:
		appendIndent(indent, print);
		print.append(containerToString() + "\n");
		
		// Repairs:
		for (IRepairDecision repair : repairs) {
			if (!(repair instanceof NodeRepairDecision)) {
				appendIndent(indent + 2, print);
				print.append(repair + "\n");
			}
		}
		
		// Container:
		for (IRepairDecision repair : repairs) {
			if (repair instanceof NodeRepairDecision) {
				print.append(((NodeRepairDecision) repair).toString(indent + 2));
			}
		}
		
		return print.toString();
	}
	
	private void appendIndent(int indent, StringBuffer print) {
		for (int i = 0; i < indent; i++) {
			print.append(" ");
		}
	}
	
	public String containerToString() {
		return super.toString();
	}
	
	public String childrenToString() {
		StringBuffer print = new StringBuffer();
		
		// Repairs:
		for (IRepairDecision repair : repairs) {
			if (!(repair instanceof NodeRepairDecision)) {
				print.append("  " + repair + "\n");
			}
		}
		
		// Container:
		for (IRepairDecision repair : repairs) {
			if (repair instanceof NodeRepairDecision) {
				print.append(((NodeRepairDecision) repair).toString(2));
			}
		}
		
		return print.toString();
	}
}
