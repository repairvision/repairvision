package org.sidiff.validation.constraint.api.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.impact.changetree.IDecisionNode;
import org.sidiff.revision.impact.changetree.util.DecisionTreeUtil;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class RepairValidationIterator extends ValidationIterator {
	
	protected boolean cleanupRepairTree = true;

	public RepairValidationIterator(
			Iterator<? extends EObject> model, 
			List<IConstraint> consistencyRules,
			boolean cleanupRepairTree) {
		
		super(false, true);
		this.cleanupRepairTree = cleanupRepairTree;
		init(model, consistencyRules);
	}
	
	public boolean isCleanupRepairTree() {
		return cleanupRepairTree;
	}
	
	@Override
	public RepairValidation next() {
		return (RepairValidation) super.next();
	}
	
	protected void evaluate(EObject modelElement, EClass constraintContextType) {
		
		if (rules.containsKey(constraintContextType)) {
			for (IConstraint crule : rules.get(constraintContextType)) {
				crule.evaluate(modelElement);

				if (reportValidation(crule)) {
					IDecisionNode repair = (!crule.getResult()) ? crule.repair() : null;
					repair = cleanupRepairTree ? DecisionTreeUtil.cleanup(repair) : repair;

					RepairValidation newValidation = new RepairValidation(
							crule,
							crule.getResult(), 
							crule.getContextType(), 
							crule.getContext(), 
							repair);

					next.add(newValidation);
				}
			}
		}
	}
}
