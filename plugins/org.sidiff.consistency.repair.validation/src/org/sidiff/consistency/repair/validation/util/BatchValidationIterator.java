package org.sidiff.consistency.repair.validation.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.consistency.repair.validation.ConsistencyRule;
import org.sidiff.consistency.repair.validation.fix.IRepairDecision;
import org.sidiff.consistency.repair.validation.terms.Variable;

public class BatchValidationIterator implements Iterator<BatchValidationIterator.Validation> {

	private Iterator<EObject> modelIterator; 
	
	private Map<EClass, List<ConsistencyRule>> rules = new HashMap<>();
	
	private LinkedList<Validation> next = new LinkedList<>();
	
	private boolean showPositiveResults = true;
	
	private boolean showNegativeResults = true;
	
	private boolean cleanupRepairTree = true;
	
	public class Validation {
		private ConsistencyRule rule;
		private boolean result;
		private EClass contextType;
		private Variable context;
		private IRepairDecision repair;
		
		public Validation(
				ConsistencyRule rule, boolean result, 
				EClass contextType, Variable context, 
				IRepairDecision repair) {
			
			this.rule = rule;
			this.result = result;
			this.contextType = contextType;
			this.context = context;
			this.repair = repair;
		}
		
		public ConsistencyRule getRule() {
			return rule;
		}

		public boolean getResult() {
			return result;
		}
		
		public EClass getContextType() {
			return contextType;
		}
		
		public Variable getContext() {
			return context;
		}
		
		public IRepairDecision getRepair() {
			return repair;
		}
	}
	
	public BatchValidationIterator(Resource modelResource, List<ConsistencyRule> consistencyRules) {
		this.modelIterator = modelResource.getAllContents();
		
		for (ConsistencyRule consistencyRule : consistencyRules) {
			
			if (!rules.containsKey(consistencyRule.getContextType())) {
				rules.put(consistencyRule.getContextType(), new LinkedList<>());
			}
			
			rules.get(consistencyRule.getContextType()).add(consistencyRule);
		}

		// Initialize iteration:
		findNext();
	}

	public boolean isShowPositiveResults() {
		return showPositiveResults;
	}

	public void setShowPositiveResults(boolean showPositiveResults) {
		this.showPositiveResults = showPositiveResults;
	}

	public boolean isShowNegativeResults() {
		return showNegativeResults;
	}

	public void setShowNegativeResults(boolean showNegativeResults) {
		this.showNegativeResults = showNegativeResults;
	}

	@Override
	public boolean hasNext() {
		return !next.isEmpty();
	}

	@Override
	public Validation next() {
		
		if (hasNext()) {
			Validation tmp_next = next.pollFirst();
			findNext();
			return tmp_next;
		} else {
			throw new NoSuchElementException();
		}
	}
	
	private void findNext() {
		
		while (modelIterator.hasNext()) {
			EObject modelElement = modelIterator.next();
			
			if (rules.containsKey(modelElement.eClass())) {
				for (ConsistencyRule crule : rules.get(modelElement.eClass())) {
					crule.evaluate(modelElement);
					
					if ((crule.getResult() && showPositiveResults) || (!crule.getResult() && showNegativeResults)) {
						IRepairDecision repair = (!crule.getResult()) ? crule.repair() : null;
						repair = cleanupRepairTree ? ValidationUtil.cleanup(repair) : repair;
						
						Validation newValidation = new Validation(
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
}
