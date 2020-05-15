package org.sidiff.common.utilities.emf;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class EMFMetaAccess {

	/**
	 * (Meta-) attributes which are not changeable, derived or transient are
	 * unconsidered while model comparison.
	 * 
	 * @param structualFeatureType
	 *            The attribute to test.
	 * @return <code>true</code> if the attribute is unconsidered while model
	 *         comparison; <code>false</code> otherwise;
	 */
	public static boolean isUnconsideredStructualFeature(EStructuralFeature structualFeatureType) {
		if ((structualFeatureType.isChangeable() == false)
				|| (structualFeatureType.isDerived() == true)
				|| (structualFeatureType.isTransient() == true)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Is class A assignable to class B.
	 * 
	 * @param a
	 *            From class A.
	 * @param b
	 *            To class B.
	 * @return <code>true</code> if A is assignable to B; <code>false</code> otherwise.
	 */
	public static boolean isAssignableTo(EClass a, EClass b) {
		return a.getEAllSuperTypes().contains(b) || a.equals(b) || b.equals(EcorePackage.eINSTANCE.getEObject());
	}
	
	
	/**
	 * Is class A assignable to class B or vice versa.
	 * 
	 * @param a
	 *            Class A
	 * @param b
	 *            Class B
	 * @return <code>true</code> if A is assignable to B or B is assignable to A; <code>false</code> otherwise.
	 */
	public static boolean assignable(EClass a, EClass b) {
		return isAssignableTo(a, b) || isAssignableTo(b, a);
	}
}
