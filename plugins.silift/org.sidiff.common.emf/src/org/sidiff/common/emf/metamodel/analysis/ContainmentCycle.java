package org.sidiff.common.emf.metamodel.analysis;

import java.util.Stack;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;

/**
 * An instance of this class depicts a containment cycle which can be outer or inner.
 * outer = the end of a path points back to the first entry (the origin of a path).
 * inner = the end of a path points back to a previous but not the first entry in the path.
 * 
 * @author mrindt
 *
 */
public class ContainmentCycle {

	/**
	 * Path, which is a stack of pairs [reference, target classifier].
	 * The top-most entry in the stack is the last reachable pair, which consists of the classifier
	 * and a reference, which points back to the first (bottom) entry in the stack.
	 * The entry at the very bottom consists of (null, eClassifier) and marks the origin of the path.
	 */
	private Stack<ContainmentCyclePathStep> path = new  Stack<ContainmentCyclePathStep>();
	
	/**
	 * Constructor
	 * 
	 * @param path
	 * @param containsInnerCircle @see #containsInnerCircle
	 * 
	 */
	public ContainmentCycle(Stack<ContainmentCyclePathStep> path, Boolean containsInnerCircle) {
		this.path = path;
		this.containsInnerCircle = containsInnerCircle;
	}
	
	/**
	 * Set this to true in case there are inner containment cycles which do not point
	 * back to the origin but to other entries in the path.
	 */
	private Boolean containsInnerCircle;
	

	/**
	 * Returns all the path as String
	 * @return
	 */
	public String getPathAsString() {
		
		String message = "";
		for(ContainmentCyclePathStep step: path) {
			EClassifier eClassifier = step.getTargetedEClassifier();
			EReference eRef = step.getTargetingReference();	

			if(eRef==null) { //->origin of the path
				message +="[" + eClassifier.getName() + "]";
			}else{
				message +=" > " + "(" + eRef.getName() +")" + eClassifier.getName();
			}
	
		}
		return message;
	}
	
	/**
	 * Returns true if the containment cycle path has an inner circle,
	 * i.e., if the end of a path points not back to the beginning
	 * but to somewhere else in the path. Inner circle detection has
	 * to be turned on before (@see ContainmentCycle Constructor)
	 * @return
	 */
	public Boolean isInnerCircle() {
		return containsInnerCircle;
	}
	
	/**
	 * Returns the first entry in the path. The first entry
	 * is a ContainmentCyclePathStep comprising just an EClassifier,
	 * from which a path starts.
	 * This ContainmentCyclePathStep does not contain an eReference.
	 * 
	 * @return ContainmentCyclePathStep
	 */
	public ContainmentCyclePathStep getStartingPoint() {
		return path.firstElement();
	}
	
	/**
	 * Returns the last entry in the path. The last entry
	 * is a ContainmentCyclePathStep comprising an EClassifier
	 * equal to or super type of an entry EClassifier in the path.
	 * (Usually the first entry). The ContainmentCyclePathStep
	 * also contains an EReference, by which
	 * this last step EClassifier is targeted.
	 * 
	 * @return ContainmentCyclePathStep
	 */
	public ContainmentCyclePathStep getBackwardPointingStep() {
		return path.lastElement();
	}
	
	/**
	 * Returns all intermediate step between the first entry
	 * (starting point of path) and last entry (end point of path).
	 *
	 * @return ContainmentCyclePathSteps
	 */
	public Stack<ContainmentCyclePathStep> getIntermediateSteps() {
		Stack<ContainmentCyclePathStep> intermediates = new Stack<ContainmentCyclePathStep>();
		
		intermediates.addAll(path);
		intermediates.remove(path.firstElement());
		intermediates.remove(path.lastElement());
		
		return intermediates;
		
	}
	
	/**
	 * Returns the number of steps between the first and the last entry.
	 * 
	 * @return number
	 */
	public Integer getNumberOfIntermediateSteps() {
		return getIntermediateSteps().size();
	}
	
	/**
	 * Checks if the given step is the last intermediate step.
	 * 
	 * @param step
	 * @return true |false
	 */
	public Boolean isLastIntermediateStep(ContainmentCyclePathStep step) {
		int numberOfIntermediates = getNumberOfIntermediateSteps();
		ContainmentCyclePathStep lastIntermediate = getIntermediateSteps().get(numberOfIntermediates-1);
		return lastIntermediate.equals(step);
	}
}
