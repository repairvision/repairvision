package org.sidiff.revision.impact.analysis;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Interface for querying model elements by specific change types.
 * 
 * @author Manuel Ohrndorf
 */
public interface PotentialImpactScope {

	/**
	 * @param containingReference The containment reference type that contains the
	 *                            given object (see
	 *                            {@link EObject#eContainmentFeature()}).
	 * @param objectType          The type of the object to be tested.
	 * @param strict              <code>true</code> if the objects type should be
	 *                            matched exactly or <code>false</code> if the given
	 *                            type is a super type of the matchable types.
	 * @return All elements that are in the impact scope of the specified change.
	 */
	Iterator<EObject> onCreateObject(EReference containingReference, EClass objectType, boolean strict);
	
	/**
	 * @param containingReference The containment reference type that contains the
	 *                            given object (see
	 *                            {@link EObject#eContainmentFeature()}).
	 * @param objectType          The type of the object to be tested.
	 * @param strict              <code>true</code> if the objects type should be
	 *                            matched exactly or <code>false</code> if the given
	 *                            type is a super type of the matchable types.
	 * @return All elements that are in the impact scope of the specified change.
	 */
	Iterator<EObject> onDeleteObject(EReference containingReference, EClass objectType, boolean strict);
	
	/**
	 * @param sourceContextType The container/context type of the reference.
	 * @param reference         The reference type to be tested.
	 * @param strict            <code>true</code> if the container/context type
	 *                          should be matched exactly or <code>false</code> if
	 *                          the given type is a super type of the matchable
	 *                          types.
	 * @return All elements that are in the impact scope of the specified change.
	 */
	Iterator<EObject> onCreateReference(EClass contextType, EReference referenceType, boolean strict);
	
	/**
	 * @param sourceContextType The container/context type of the reference.
	 * @param reference         The reference type to be tested.
	 * @param strict            <code>true</code> if the container/context type
	 *                          should be matched exactly or <code>false</code> if
	 *                          the given type is a super type of the matchable
	 *                          types.
	 * @return All elements that are in the impact scope of the specified change.
	 */
	Iterator<EObject> onDeleteReference(EClass contextType, EReference referenceType, boolean strict);
	
	/**
	 * @param sourceContextType The container/context type of the reference.
	 * @param reference         The reference type to be tested.
	 * @param strict            <code>true</code> if the container/context type
	 *                          should be matched exactly or <code>false</code> if
	 *                          the given type is a super type of the matchable
	 *                          types.
	 * @return All elements that are in the impact scope of the specified change.
	 */
	Iterator<EObject> onModifyAttribute(EClass contextType, EAttribute attributeType, boolean strict);

}
