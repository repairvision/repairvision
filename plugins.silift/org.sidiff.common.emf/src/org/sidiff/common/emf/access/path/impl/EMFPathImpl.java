package org.sidiff.common.emf.access.path.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.sidiff.common.emf.access.path.EMFPath;

/**
 * Engine specific implementation of a EMF navigation path
 * 
 * @author Maik Schmidt
 *
 */
public class EMFPathImpl implements EMFPath,Iterable<EMFPathStepImpl> {
	
	private EMFPathStepImpl fistStep = null;
	private EMFPathStepImpl lastStep = null;
	
	public EClass getTargetType() {
		return lastStep.resultType();
	}
	
	/**
	 * Initializes the EMFPath by sequentially initializing each path step
	 * 
	 * @param pathContextType the type of the path context
	 * @return the initialized EMFPath
	 */
	public EMFPathImpl initPath(EClass pathContextType) {
		assert(pathContextType!=null) : "Illegal path context: null";
		
		for(EMFPathStepImpl step : this){
			step.initPathStep(pathContextType);
		}
		return this;
	}
	
	/**
	 * Adds a step to the EMFPath
	 * 
	 * @param nextStep the next path step of the EMFPath
	 */
	void addStep(EMFPathStepImpl nextStep){
		
		if(fistStep==null){
			assert(lastStep==null) : "Illegal State/Internal Error 'no fist step, but a last one'";
			fistStep=nextStep;
			lastStep=nextStep;
		} else {
			
			nextStep.ancestorStep=lastStep;
			assert(lastStep.nextStep==null) : "Illegal State/Internal Error 'last step already has a successor'";
			
			lastStep.nextStep=nextStep;
			lastStep=nextStep;
		}
		nextStep.path= this;
	}
	

	@Override
	public Iterator<EMFPathStepImpl> iterator() {
		return new EMFPathStepIterator();
	}
	
	/**
	 * Inner Class that implements an Iterator over the Path navigation steps.
	 * 
	 * @see Iterator
	 * @author Maik Schmidt
	 */
	class EMFPathStepIterator implements Iterator<EMFPathStepImpl>{

		private EMFPathStepImpl currentStep = null;
		
		public EMFPathStepIterator() {
			this.currentStep= EMFPathImpl.this.fistStep;
		}

		@Override
		public boolean hasNext() {
			return (currentStep!=null);
		}

		@Override
		public EMFPathStepImpl next() {
			
			EMFPathStepImpl result = currentStep;
			currentStep=result.nextStep;
			return result;
		}

		@Override
		public void remove() {
			currentStep.ancestorStep=currentStep.ancestorStep.ancestorStep;
			currentStep.ancestorStep.nextStep=currentStep;
		}
		
	}
}
