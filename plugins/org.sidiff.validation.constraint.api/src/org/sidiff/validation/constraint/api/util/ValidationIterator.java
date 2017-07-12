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
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class ValidationIterator implements Iterator<Validation> {

	protected Map<EClass, List<IConstraint>> rules = new HashMap<>();
	
	protected LinkedList<Validation> next = new LinkedList<>();
	
	protected boolean showPositiveResults = true;
	
	protected boolean showNegativeResults = true;
	
	public ValidationIterator(
			Resource modelResource, List<IConstraint> consistencyRules,
			boolean showPositiveResults, 
			boolean showNegativeResults) {
		
		this(showPositiveResults, showNegativeResults);
		init(modelResource, consistencyRules);
	}
	
	protected ValidationIterator(boolean showPositiveResults, boolean showNegativeResults) {
		this.showPositiveResults = showPositiveResults;
		this.showNegativeResults = showNegativeResults;
	}
	
	protected void init(Resource modelResource, List<IConstraint> consistencyRules) {
		
		// Index constraints by type:
		for (IConstraint consistencyRule : consistencyRules) {
			addConstraintForType(consistencyRule.getContextType(), consistencyRule);
		}
		
		// Search inconsistencies:
		findAll(modelResource);
	}
	
	
	protected void addConstraintForType(EClass type, IConstraint consistencyRule) {
		
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
	
	protected void findAll(Resource modelResource) {
		Iterator<EObject> modelIterator = modelResource.getAllContents();
		
		while (modelIterator.hasNext()) {
			EObject modelElement = modelIterator.next();
			
			evaluate(modelElement, modelElement.eClass());
			
			for (EClass superType : modelElement.eClass().getEAllSuperTypes()) {
				evaluate(modelElement, superType);
			}
		}
	}
	
	protected void evaluate(EObject modelElement, EClass constraintContextType) {
		
		if (rules.containsKey(constraintContextType)) {
			for (IConstraint crule : rules.get(constraintContextType)) {
				crule.evaluate(modelElement);
				
				if (reportValidation(crule)) {
					Validation newValidation = new Validation(
							crule,
							crule.getResult(), 
							crule.getContextType(), 
							crule.getContext());
					
					next.add(newValidation);
				}
			}
		}
	}
	
	protected boolean reportValidation(IConstraint crule) {
		return ((crule.getResult() && showPositiveResults) || (!crule.getResult() && showNegativeResults));
	}
}
