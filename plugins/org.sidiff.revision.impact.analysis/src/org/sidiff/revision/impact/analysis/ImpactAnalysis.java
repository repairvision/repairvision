package org.sidiff.revision.impact.analysis;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Interface for testing changes on specific model elements for impact.
 * 
 * @author Manuel Ohrndorf
 */
public interface ImpactAnalysis {

	/**
	 * @param containingReference The containment reference type that contains the
	 *                            given object (see
	 *                            {@link EObject#eContainmentFeature()}).
	 * @param object              The object to be tested.
	 * @return <code>true</code> if the creation of the object had an impact;
	 *         <code>false</code> otherwise.
	 */
	boolean onCreateObject(EReference containingReference, EObject object);

	/**
	 * @param containingReference The containment reference type that contains the
	 *                            given object (see
	 *                            {@link EObject#eContainmentFeature()}).
	 * @param object              The object to be tested.
	 * @return <code>true</code> if the deletion of the object had an impact;
	 *         <code>false</code> otherwise.
	 */
	boolean onDeleteObject(EReference containingReference, EObject object);

	/**
	 * @param sourceContext The container/context of the reference.
	 * @param reference     The reference type to be tested.
	 * @return <code>true</code> if the creation of a reference of the given type
	 *         has an impact; <code>false</code> otherwise.
	 */
	boolean onCreateReference(EObject sourceContext, EReference reference);

	/**
	 * @param sourceContext The container/context of the reference.
	 * @param reference     The reference type to be tested.
	 * @return <code>true</code> if the deletion of a reference of the given type
	 *         has an impact; <code>false</code> otherwise.
	 */
	boolean onDeleteReference(EObject sourceContext, EReference reference);

	/**
	 * @param containerContext The container/context of the reference.
	 * @param attribute        The attribute type to be tested.
	 * @return <code>true</code> if a modification of the attribute of the given
	 *         type has an impact; <code>false</code> otherwise.
	 */
	boolean onModifyAttribute(EObject containerContext, EAttribute attribute);

}
