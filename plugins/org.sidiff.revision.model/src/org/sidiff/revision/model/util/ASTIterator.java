package org.sidiff.revision.model.util;

import java.util.Iterator;
import java.util.LinkedList;

import org.sidiff.revision.model.ModelAST;

public class ASTIterator implements Iterator<Object> {

	private ModelAST modelAST;
	
	private LinkedList<Iterator<?>> trace = new LinkedList<>();
	
	public ASTIterator(ModelAST modelAST) {
		this.modelAST = modelAST;
		this.trace.add(modelAST.children(modelAST));
	}
	
	@Override
	public boolean hasNext() {
		return trace.getLast().hasNext();
	}

	@Override
	public Object next() {
		
		// Get next element:
		Object next = trace.getLast().next();
		
		if (!trace.getLast().hasNext()) {
			trace.removeLast();
		}
		
		// DFS:
		Iterator<?> children = modelAST.children(next);
		
		if (children != null) {
			trace.add(children);
		}
		
		return next;
	}

}
