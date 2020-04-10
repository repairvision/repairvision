package org.sidiff.common.utilities.emf;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

public class MetaModelUtil {

	/**
	 * Is class A assignable to class B (B = A).
	 * 
	 * @param a
	 *            From class A.
	 * @param b
	 *            To class B.
	 * @return <code>true</code> if A is assignable to B; <code>false</code> otherwise.
	 */
	public static boolean isAssignableTo(EClass a, EClass b) {
		return  a.equals(b) || b.equals(EcorePackage.eINSTANCE.getEObject()) || a.getEAllSuperTypes().contains(b);
	}
}
