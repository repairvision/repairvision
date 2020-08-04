package org.sidiff.revision.impact.analysis;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Interface for testing specific changes for impact.
 * 
 * @author Manuel Ohrndorf
 */
public interface PotentialImpactAnalysis {

	/**
	 * @param containingReference The containment reference type that contains the
	 *                            given object (see
	 *                            {@link EObject#eContainmentFeature()}).
	 * @param objectType          The type of the object to be tested.
	 * @param strict              <code>true</code> if the objects type should be
	 *                            matched exactly or <code>false</code> if the given
	 *                            type is a super type of the matchable types.
	 * @return <code>true</code> if the creation of the specified object could have
	 *         a potential impact; <code>false</code> otherwise.
	 */
	boolean onCreateObject(EReference containingReference, EClass objectType, boolean strict);

	/**
	 * @param containingReference The containment reference type that contains the
	 *                            given object (see
	 *                            {@link EObject#eContainmentFeature()}).
	 * @param objectType          The type of the object to be tested.
	 * @param strict              <code>true</code> if the objects type should be
	 *                            matched exactly or <code>false</code> if the given
	 *                            type is a super type of the matchable types.
	 * @return <code>true</code> if the deletion of the specified object could have
	 *         a potential impact; <code>false</code> otherwise.
	 */
	boolean onDeleteObject(EReference containingReference, EClass objectType, boolean strict);

	/**
	 * @param sourceContextType The container/context type of the reference.
	 * @param reference         The reference type to be tested.
	 * @param strict            <code>true</code> if the container/context type
	 *                          should be matched exactly or <code>false</code> if
	 *                          the given type is a super type of the matchable
	 *                          types.
	 * @return <code>true</code> if the creation of a reference of the given type
	 *         has an impact; <code>false</code> otherwise.
	 */
	boolean onCreateReference(EClass sourceContextType, EReference reference, boolean strict);

	/**
	 * @param sourceContextType The container/context type of the reference.
	 * @param reference         The reference type to be tested.
	 * @param strict            <code>true</code> if the container/context type
	 *                          should be matched exactly or <code>false</code> if
	 *                          the given type is a super type of the matchable
	 *                          types.
	 * @return <code>true</code> if the deletion of a reference of the given type
	 *         has an impact; <code>false</code> otherwise.
	 */
	boolean onDeleteReference(EClass sourceContextType, EReference reference, boolean strict);

	/**
	 * @param sourceContextType The container/context type of the reference.
	 * @param reference         The reference type to be tested.
	 * @param strict            <code>true</code> if the container/context type
	 *                          should be matched exactly or <code>false</code> if
	 *                          the given type is a super type of the matchable
	 *                          types.
	 * @return <code>true</code> if the modification of an attribute of the given
	 *         type has an impact; <code>false</code> otherwise.
	 */
	boolean onModifyAttribute(EClass containerContextType, EAttribute attribute, boolean strict);
}
