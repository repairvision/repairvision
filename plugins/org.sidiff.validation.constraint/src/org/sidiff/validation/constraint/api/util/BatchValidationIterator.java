package org.sidiff.validation.constraint.api.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.repair.validation.IConstraint;
import org.sidiff.repair.validation.fix.IRepairDecision;

public class BatchValidationIterator implements Iterator<Validation> {

	private Map<EClass, List<IConstraint>> rules = new HashMap<>();
	
	private LinkedList<Validation> next = new LinkedList<>();
	
	private boolean showPositiveResults = true;
	
	private boolean showNegativeResults = true;
	
	private boolean cleanupRepairTree = true;
	
	public BatchValidationIterator(
			Resource modelResource, List<IConstraint> consistencyRules,
			boolean showPositiveResults, 
			boolean showNegativeResults,
			boolean cleanupRepairTree) {
		
		this.showPositiveResults = showPositiveResults;
		this.showNegativeResults = showNegativeResults;
		this.cleanupRepairTree = cleanupRepairTree;
		
		// Index constraints by type:
		for (IConstraint consistencyRule : consistencyRules) {
			addConstraintForType(consistencyRule.getContextType(), consistencyRule);
		}
		
		// Search inconsistencies:
		findAll(modelResource);
	}
	
	public BatchValidationIterator(Resource modelResource, List<IConstraint> consistencyRules) {
		this(modelResource, consistencyRules, true, true, true);
	}
	
	private void addConstraintForType(EClass type, IConstraint consistencyRule) {
		
		if (!rules.containsKey(type)) {
			rules.put(type, new LinkedList<>());
		}
		
		rules.get(type).add(consistencyRule);
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
			return tmp_next;
		} else {
			throw new NoSuchElementException();
		}
	}
	
	private void findAll(Resource modelResource) {
		Iterator<EObject> modelIterator = modelResource.getAllContents();
		
		while (modelIterator.hasNext()) {
			EObject modelElement = modelIterator.next();
			
			evaluate(modelElement, modelElement.eClass());
			
			for (EClass superType : modelElement.eClass().getEAllSuperTypes()) {
				evaluate(modelElement, superType);
			}
		}
	}
	
	private void evaluate(EObject modelElement, EClass constraintContextType) {
		
		if (rules.containsKey(constraintContextType)) {
			for (IConstraint crule : rules.get(constraintContextType)) {
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
