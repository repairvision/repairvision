package org.sidiff.common.emf.metamodel.analysis;

import org.eclipse.emf.ecore.*;

/**
 * This class provides convenience methods to query multiplicity invariants of
 * EReferences and inheritance information
 * 
 * @author mrindt
 */
public class EReferenceInfo {

	/**
	 * Checks if the EReference is upper bounded; e.g., [something..5].
	 * @param reference
	 * @return
	 */
	public static boolean isBounded(EReference reference) {
		return reference.getUpperBound() > 0;
	}

	/**
	 * Checks if the EReference is lower bounded; e.g., [1..something].
	 * @param reference
	 * @return true or false
	 */
	public static boolean isRequired(EReference reference) {
		return reference.getLowerBound() > 0;
	}

	/**
	 * Checks if the lower bound and the upper bound of an EReference are equal and greater zero;
	 * e.g., [2..2].
	 * @param reference
	 * @return true or false
	 */
	public static boolean isFixed(EReference reference) {
		return (reference.getLowerBound() == reference.getUpperBound()) && (reference.getUpperBound() > 0);
	}

	/**
	 * Checks if the (upperbound - lowerbound > 0) and the upperbound isBoundend()
	 * and lowerbound isRequired(); e.g. [2..6]
	 * @param reference
	 * @return true or false
	 */
	public static boolean isDoubleBoundedAndMany(EReference reference){
		return ((reference.getUpperBound()!=-1) && (reference.getLowerBound()>0))
				&& (reference.getUpperBound() - reference.getLowerBound() > 0);		
	}
		
	/**
	 * Checks if the EReference or it's EOpposite is a containment.
	 * @param reference
	 * @return true or false
	 */
	public static boolean isContainmentRelated(EReference reference) {
		return (reference.isContainment())
				|| (reference.getEOpposite() != null && reference.getEOpposite().isContainment());
	}
	
	/**
	 * Checks if a given EReference is inherited
	 * @param the EReference
	 * @param concerningEClassifier is the class to check on
	 * @return true if inherited
	 */
	public static boolean isInheritedReference(EReference eRef, EClassifier concerningEClassifier) {
		
		if(concerningEClassifier instanceof EClass) {
			EClass eClass = (EClass) concerningEClassifier;
			return !eClass.getEReferences().contains(eRef);
		}
		
		return true;
	}
}
