package org.sidiff.revision.impact.changetree.test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.sidiff.revision.common.utilities.java.JUtil;
import org.sidiff.revision.impact.changetree.IDecisionLeaf;
import org.sidiff.revision.impact.changetree.IDecisionNode;

public class StringDecisionLeaf implements IDecisionLeaf {

	private String text;
	
	public StringDecisionLeaf(String text) {
		this.text = text;
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
		string.append(text);
		return string.toString();
	}
	
	private void appendIndent(int indent, StringBuffer print) {
		for (int i = 0; i < indent; i++) {
			print.append(" ");
		}
	}
	
	@Override
	public String toString() {
		return toString(0);
	}

	@Override
	public int compareTo(IDecisionLeaf o) {
		return this.compareTo(o);
	}

	@Override
	public Iterator<? extends IDecisionNode> traversal() {
		return JUtil.singeltonIterator(this);
	}

	@Override
	public IDecisionNode deepCopy() {
		return new StringDecisionLeaf(text);
	}

}
