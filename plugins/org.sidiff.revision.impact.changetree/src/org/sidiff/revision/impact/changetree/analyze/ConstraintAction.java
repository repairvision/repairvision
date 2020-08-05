package org.sidiff.revision.impact.changetree.analyze;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.revision.common.utilities.java.JUtil;
import org.sidiff.revision.impact.changetree.IDecisionLeaf;
import org.sidiff.revision.impact.changetree.IDecisionNode;

public class ConstraintAction implements IDecisionLeaf {

	public enum ConstraintType {
		REQUIRE, FORBID 
	}
	
	private ConstraintType constraint;
	
	private EClass context;
	
	private EStructuralFeature feature;
	
	private EClassifier type;

	public ConstraintAction(ConstraintType constraint, EClass context, EStructuralFeature feature, EClassifier type) {
		this.constraint = constraint;
		this.context = context;
		this.feature = feature;
		this.type = type;
	}
	
	public ConstraintType getConstraint() {
		return constraint;
	}

	public void setConstraint(ConstraintType constraint) {
		this.constraint = constraint;
	}

	public EClass getContext() {
		return context;
	}

	public void setContext(EClass context) {
		this.context = context;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}

	public void setFeature(EStructuralFeature feature) {
		this.feature = feature;
	}

	public EClassifier getType() {
		return type;
	}

	public void setType(EClassifier type) {
		this.type = type;
	}
	
	@Override
	public int compareTo(IDecisionLeaf leaf) {
		
		if (leaf instanceof ConstraintAction) {
			ConstraintAction otherConstraint = (ConstraintAction) leaf;

			if (this.getConstraint().equals(otherConstraint.getConstraint())) {
				if (this.getContext().equals(otherConstraint.getContext())) {
					if (this.getFeature().equals(otherConstraint.getFeature())) {
						if (this.getType().equals(otherConstraint.getType())) {
							return 0;
						}
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
		return "Constraint@" + Integer.toHexString(hashCode()) + ": <" + constraint.name() + " " + context.getName() + "." + feature.getName() + " : " + type.getName() + ">";
	}

	@Override
	public IDecisionNode deepCopy() {
		return new ConstraintAction(constraint, context, feature, type);
	}
}
