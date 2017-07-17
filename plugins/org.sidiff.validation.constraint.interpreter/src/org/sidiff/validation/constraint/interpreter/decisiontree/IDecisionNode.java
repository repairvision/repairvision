package org.sidiff.validation.constraint.interpreter.decisiontree;

import java.util.Iterator;
import java.util.List;

public interface IDecisionNode {
	
	Iterator<List<? extends IDecisionNode>> traversal();

	String toString(int indent);
}
