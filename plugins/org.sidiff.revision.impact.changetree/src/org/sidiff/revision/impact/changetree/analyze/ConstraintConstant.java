package org.sidiff.revision.impact.changetree.analyze;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.sidiff.revision.common.utilities.java.JUtil;
import org.sidiff.revision.impact.changetree.IDecisionLeaf;
import org.sidiff.revision.impact.changetree.IDecisionNode;
import org.sidiff.revision.impact.changetree.analyze.ConstraintAction.ConstraintType;

public class ConstraintConstant implements IDecisionLeaf {

	private ConstraintType constraint;
	
	private EClassifier context;
	
	private Object value;

	public ConstraintConstant(ConstraintType constraint, EClassifier context, Object value) {
		this.constraint = constraint;
		this.context = context;
		this.value = value;
	}

	public ConstraintType getConstraint() {
		return constraint;
	}

	public void setConstraint(ConstraintType constraint) {
		this.constraint = constraint;
	}

	public EClassifier getContext() {
		return context;
	}

	public void setContext(EClassifier context) {
		this.context = context;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public int compareTo(IDecisionLeaf leaf) {
		
		if (leaf instanceof ConstraintConstant) {
			ConstraintConstant otherConstraint = (ConstraintConstant) leaf;

			if (this.getConstraint().equals(otherConstraint.getConstraint())) {
				if (this.getContext().equals(otherConstraint.getContext())) {
					if (this.getValue().equals(otherConstraint.getValue())) {
						return 0;
					}
				}
			}
		}
		
		return this.toString().compareTo(leaf.toString());
	}

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
	
	@Override
	public String toString() {
		return "Constraint@" + Integer.toHexString(hashCode()) + ": <" + constraint.name() + " " + context.getName() + " = " + value + ">";
	}

	@Override
	public IDecisionNode deepCopy() {
		return new ConstraintConstant(constraint, context, value);
	}
}
