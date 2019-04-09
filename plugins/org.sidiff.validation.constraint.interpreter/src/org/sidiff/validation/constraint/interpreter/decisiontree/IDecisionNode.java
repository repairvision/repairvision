package org.sidiff.validation.constraint.interpreter.decisiontree;

import java.util.Iterator;
import java.util.List;

public interface IDecisionNode {
	
	Iterator<? extends IDecisionNode> traversal();
	
	Iterator<List<? extends IDecisionNode>> combinations();

	String toString(int indent);
}
