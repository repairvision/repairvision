package org.sidiff.common.emf.access.path.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.axis.EMFAxis;
import org.sidiff.common.emf.access.path.conditions.EMFCondition;

public class EMFPathStepImpl {
	
	// Filled by path when Step was added to Path
	EMFPathStepImpl nextStep = null;
	EMFPathStepImpl ancestorStep = null;
	EMFPathImpl path = null;
	
	// Comes with Constructor
	private EMFAxis axis = null;
	private EClass nodeTypeCondition = null;
	private EMFCondition nodePropertyCondition = null;

	// While initialized
	private EClass pathStepContext = null;
	
	// Caches result, needed to realize some evaluation strathegies! e.g. collector, slices
	private Collection<EObject> lastResult = null;
	
	EMFPathStepImpl(EMFAxis axis, EClass nodeTest,EMFCondition condition) {
		
		this.axis = axis;
		this.nodeTypeCondition = nodeTest;
		this.nodePropertyCondition = condition;
	}
	
	void initPathStep(EClass pathContextType){
		
		if(ancestorStep==null){
			// no ancestor, its the first step of a path
			this.pathStepContext=pathContextType;
		} else {
			// relay on previous step
			this.pathStepContext=ancestorStep.resultType();
		}
		
		// init axis
		axis.initAxis(this);
		
		if(nodePropertyCondition!=null){
			nodePropertyCondition.initCondition(this);
		}
	}
	
	public Collection<EObject> evaluateStep(Collection<EObject> context){
		
		this.lastResult = axis.evaluateAxis(context);
		assert(!lastResult.contains(null)) : "Error: axis ("+axis.getClass().getName()+") returns collection containing 'null'!";

		// Remove not well-typed nodes from collection
		if(nodeTypeCondition!=null&&axis.resultType()!=nodeTypeCondition){
			Iterator<EObject> iterator = this.lastResult.iterator();
			while(iterator.hasNext()){
				if(!nodeTypeCondition.isSuperTypeOf(iterator.next().eClass())){
					iterator.remove();
				}
			}
		}
		
		// Check condition 
		if(nodePropertyCondition!=null){
			Iterator<EObject> iterator = this.lastResult.iterator();
			while(iterator.hasNext()){
				if(!nodePropertyCondition.select(iterator.next())){
					iterator.remove();
				}
			}
		}
		
		return this.lastResult;
	}
	
	public Collection<EObject> result(){
		
		return this.lastResult;
	}
	
	/**
	 *  Computes the result type of the whole Step.
	 * 
	 * @return the common type of all object of the step result.
	 */
	public EClass resultType(){
		
		return (nodeTypeCondition!=null)? nodeTypeCondition : axis.resultType();
	}
	
	public EClass contextType(){
		
		return this.pathStepContext;
	}
	
	public EMFPathStepImpl getNextStep(){
		
		return this.nextStep;
	}

	public EMFPathStepImpl getAncestorStep(){
		
		return this.ancestorStep;
	}

}
