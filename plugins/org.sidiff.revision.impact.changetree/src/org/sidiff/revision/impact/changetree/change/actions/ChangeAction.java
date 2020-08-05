package org.sidiff.revision.impact.changetree.change.actions;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.sidiff.revision.common.utilities.java.JUtil;
import org.sidiff.revision.impact.changetree.IDecisionLeaf;
import org.sidiff.revision.impact.changetree.IDecisionNode;

public abstract class ChangeAction implements IDecisionLeaf {

	public enum RepairType {
		DELETE, CREATE, MODIFY
	}
	
	protected RepairType type;
	
	public ChangeAction(RepairType type) {
		this.type = type;
	}
	
	public RepairType getType() {
		return type;
	}
	
	public abstract boolean isAbstract();

	@Override
	public Iterator<? extends IDecisionNode> traversal() {
		return JUtil.singeltonIterator(this);
	}

	@Override
	public Iterator<List<? extends IDecisionNode>> combinations() {
		List<? extends IDecisionNode> leafSingleton = Collections.singletonList(this);
		List<List<? extends IDecisionNode>> leafIterable = Collections.singletonList(leafSingleton);
		return leafIterable.iterator();
	}
	
	@Override
	public String toString(int indent) {
		StringBuffer string = new StringBuffer();
		
		appendIndent(indent, string);
		string.append(toString());
			
		return string.toString();
	}
	
	private void appendIndent(int indent, StringBuffer print) {
		for (int i = 0; i < indent; i++) {
			print.append(" ");
		}
	}

	public abstract String getRepairLabel();
	
}
