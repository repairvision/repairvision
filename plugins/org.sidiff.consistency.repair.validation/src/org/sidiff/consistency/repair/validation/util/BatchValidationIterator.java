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

public class BatchValidationIterator implements Iterator<Validation> {

	private Iterator<EObject> modelIterator; 
	
	private Map<EClass, List<ConsistencyRule>> rules = new HashMap<>();
	
	private LinkedList<Validation> next = new LinkedList<>();
	
	private boolean showPositiveResults = true;
	
	private boolean showNegativeResults = true;
	
	private boolean cleanupRepairTree = true;
	
	public BatchValidationIterator(Resource modelResource, List<ConsistencyRule> consistencyRules) {
		this.modelIterator = modelResource.getAllContents();
		
		init(consistencyRules);
	}

	public BatchValidationIterator(
			Resource modelResource, List<ConsistencyRule> consistencyRules,
			boolean showPositiveResults, 
			boolean showNegativeResults,
			boolean cleanupRepairTree) {
		
		this.modelIterator = modelResource.getAllContents();
		this.showPositiveResults = showPositiveResults;
		this.showNegativeResults = showNegativeResults;
		this.cleanupRepairTree = cleanupRepairTree;
		
		init(consistencyRules);
	}

	private void init(List<ConsistencyRule> consistencyRules) {
		
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
	
	public boolean isShowNegativeResults() {
		return showNegativeResults;
	}
	
	public boolean isCleanupRepairTree() {
		return cleanupRepairTree;
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
