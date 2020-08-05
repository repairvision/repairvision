package org.sidiff.revision.common.emf;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * Convenient functions for ecore meta-modeling.
 * 
 * @author Manuel Ohrndorf
 */
public class MetaModelUtil {

	/**
	 * Is class A assignable to class B (B = A).
	 * 
	 * @param a From class A.
	 * @param b To class B.
	 * @return <code>true</code> if A is assignable to B; <code>false</code> otherwise.
	 */
	public static boolean isAssignableTo(EClass a, EClass b) {
		return a.equals(b) || b.equals(EcorePackage.eINSTANCE.getEObject()) || a.getEAllSuperTypes().contains(b);
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

	/**
	 * @param packages All packages to be searched.
	 * @param type     The contained type.
	 * @return All references (of the given packages) that can contain the specified type.
	 */
	public static Set<EReference> getEAllContainers(Collection<EPackage> packages, EClass type) {
		 Set<EReference> containments = new LinkedHashSet<>();
		
		for (EPackage pkg : packages) {
			for (EClassifier classifier : pkg.getEClassifiers()) {
				if (classifier instanceof EClass) {
					for (EReference containment : ((EClass) classifier).getEAllContainments()) {
						if (isAssignableTo(type, (EClass) containment.getEType())) {
							containments.add(containment);
						}
					}
				}
			}
		}
		
		return containments;
	}
	
	/**
	 * @param containerReferences {@link #getEAllContainers(Collection, EClass)}
	 * @return <code>true</code> if there is no container reference or if there is
	 *         just a self-reference; <code>false</code> otherwise.
	 */
	public static boolean isRootContainer(Set<EReference> containerReferences) {
		
		for (EReference eReference : containerReferences) {
			if (eReference.getEType() != eReference.getEContainingClass()) {
				return false;
			}
		}
		
		return true;
	}
	
}
