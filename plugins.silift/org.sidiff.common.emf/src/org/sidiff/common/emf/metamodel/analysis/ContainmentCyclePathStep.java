package org.sidiff.common.emf.metamodel.analysis;

import java.util.HashMap;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;

/**
 * An instance of this class represents a step in a containment cycle path.
 * It contains an EReference which points to the contained EClassifier.
 * Usually a meta-model let EReferences point mostly to super types.
 * Thus, to cover also sub types as targets and their paths recursively
 * one can keep track of every step for every sub type with this.
 * This class was created for conveniently accessing steps.
 * 
 * @author mrindt
 *
 */
public class ContainmentCyclePathStep {

	/**
	 * The step, mapping an EReference to a target EClassifier.
	 */
	private HashMap<EReference,EClassifier> step = new  HashMap<EReference,EClassifier>();
	
	/**
	 * Constructor.
	 * @param containmentERef
	 * @param targetedEClassifier
	 */
	public ContainmentCyclePathStep(EReference containmentERef, EClassifier targetedEClassifier) {
		
		step.put(containmentERef, targetedEClassifier);
		
	}
	
	/**
	 * Delivers the EReference which point to the EClassifier involved in this step.
	 * Whereas this EClassifier can be a sub type of the EReference's meta model target.
	 * @return
	 */
	public EReference getTargetingReference() {
		return step.entrySet().iterator().next().getKey();
	}
	
	/**
	 * Delivers the targeted EClassifer. Whereas this EClassifier can be a sub type of
	 * the incoming EReference's meta model target.
	 * @return
	 */
	public EClassifier getTargetedEClassifier() {
		return step.entrySet().iterator().next().getValue();
	}
	
}
