package org.sidiff.history.revision.difference;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;

public interface IRevisionDifference {

	/**
	 * Get all candidates which are compatible with the given change type. This
	 * returns a fresh and modifiable list.
	 * 
	 * @param changeType
	 *            The type of the change ({@link AddObject}, {@link RemoveObject},
	 *            {@link AddReference}, {@link RemoveReference},
	 *            {@link AttributeValueChange})
	 * @param changeDomainType
	 *            The (meta) type of the changed objects ({@link EClass},
	 *            {@link EReference}, {@link EAttribute}).
	 * @return A set of candidates compatible with the change type.
	 */
	List<EObject> getChangeDomain(EClass changeType, EObject changeDomainType);

	/**
	 * Returns the size of the domain for a change type. The returned number equals
	 * the size of the list returned by {@link #getAddObjectDomain(EClass)}. This
	 * method should be used whenever the actual objects are not needed.
	 * 
	 * @param changeType
	 *            The type of the change ({@link AddObject}, {@link RemoveObject},
	 *            {@link AddReference}, {@link RemoveReference},
	 *            {@link AttributeValueChange})
	 * @param changeDomainType
	 *            The type of the changed objects ({@link EClass},
	 *            {@link EReference}, {@link EAttribute}).
	 * @return The count of candidates compatible with the change type.
	 */
	int getChangeDomainSize(EClass changeType, EObject changeDomainType);

	/**
	 * Get all candidates which are compatible with the given change type. This
	 * returns a fresh and modifiable list.
	 * 
	 * @param type
	 *            The type of the added objects.
	 * @return A set of candidates compatible with the type.
	 */
	List<EObject> getAddObjectDomain(EClass type);

	/**
	 * Returns the size of the domain for a change type. The returned number equals
	 * the size of the list returned by {@link #getAddObjectDomain(EClass)}. This
	 * method should be used whenever the actual objects are not needed.
	 * 
	 * @param type
	 *            The type of the added objects.
	 * @return The count of candidates compatible with the change type.
	 */
	int getAddObjectDomainSize(EClass type);

	/**
	 * Get all candidates which are compatible with the given change type. This
	 * returns a fresh and modifiable list.
	 * 
	 * @param type
	 *            The type of the removed objects.
	 * @return A set of candidates compatible with the type.
	 */
	List<EObject> getRemoveObjectDomain(EClass type);

	/**
	 * Returns the size of the domain for a change type. The returned number equals
	 * the size of the list returned by {@link #getRemoveObjectDomain(EClass)}. This
	 * method should be used whenever the actual objects are not needed.
	 * 
	 * @param type
	 *            The type of the removed objects.
	 * @return The count of candidates compatible with the change type.
	 */
	int getRemoveObjectDomainSize(EClass type);

	/**
	 * Get all candidates which are compatible with the given change type. This
	 * returns a fresh and modifiable list.
	 * 
	 * @param type
	 *            The type of the added references.
	 * @return A set of candidates compatible with the type.
	 */
	List<EObject> getAddReferenceDomain(EReference type);

	/**
	 * Returns the size of the domain for a change type. The returned number equals
	 * the size of the list returned by {@link #getAddReferenceDomain(EClass)}. This
	 * method should be used whenever the actual objects are not needed.
	 * 
	 * @param type
	 *            The type of added references.
	 * @return The count of candidates compatible with the change type.
	 */
	int getAddReferenceDomainSize(EReference type);

	/**
	 * Get all candidates which are compatible with the given change type. This
	 * returns a fresh and modifiable list.
	 * 
	 * @param type
	 *            The type of removed references.
	 * @return A set of candidates compatible with the type.
	 */
	List<EObject> getRemoveReferenceDomain(EReference type);

	/**
	 * Returns the size of the domain for a change type. The returned number equals
	 * the size of the list returned by {@link #getRemoveReferenceDomain(EClass)}.
	 * This method should be used whenever the actual objects are not needed.
	 * 
	 * @param type
	 *            The type of the removed references.
	 * @return The count of candidates compatible with the change type.
	 */
	int getRemoveReferenceDomainSize(EReference type);

	/**
	 * Get all candidates which are compatible with the given change type. This
	 * returns a fresh and modifiable list.
	 * 
	 * @param type
	 *            The type of the changed attribute.
	 * @return A set of candidates compatible with the change type.
	 */
	List<EObject> getAttributeValueChangeDomain(EAttribute type);

	/**
	 * Returns the size of the domain for a change type. The returned number equals
	 * the size of the list returned by
	 * {@link #getAttributeValueChangeDomain(EClass)}. This method should be used
	 * whenever the actual objects are not needed.
	 * 
	 * @param type
	 *            The type of the changed attribute.
	 * @return The count of candidates compatible with the change type.
	 */
	int getAttributeValueChangeDomainSize(EAttribute type);

	/**
	 * @return All meta-model types used by the corresponding difference.
	 */
	Set<EStructuralFeature> getTypeNodes();

	/**
	 * @param element
	 *            An element of the model.
	 * @return All adjacent local changes to this model element.
	 */
	Collection<Change> getLocalChanges(EObject element);

	/**
	 * @param change
	 *            A reference change.
	 * @return The opposite change or <code>null</code>.
	 */
	Change getOppositeChange(Change change);

	/**
	 * @param element
	 *            An element of the model.
	 * @param reference
	 *            Type of the incident (model <-> change) edge (e.g.
	 *            DifferencePackage.eINSTANCE.getAddObject_Obj()).
	 * @param changeType
	 *            The class type of the change (e.g.AddObject.class).
	 * @return All adjacent local changes to this model element which are incident
	 *         with the given edge.
	 */
	<C extends Change> Iterator<C> getLocalChanges(EObject element, EReference reference, Class<C> changeType);

	/**
	 * @param element
	 *            An element of the model.
	 * @return The add/remove object annotation or <code>null</code>.
	 */
	Change getObjectChange(EObject element);

	/**
	 * @param element
	 *            An element of the model.
	 * @param attributeType
	 *            The type of the attribute.
	 * @return The attribute value change annotation or <code>null</code>.
	 */
	AttributeValueChange getAttributeChange(EObject element, EAttribute attributeType);

	/**
	 * @param element
	 *            An element of the model.
	 * @param referenceType The type of the reference.
	 * @return All add/remove reference annotation or <code>null</code>.
	 */
	<C extends Change> Iterator<C> getReferenceChanges(EObject element, EReference referenceType);

	/**
	 * @param modelElement
	 *            The element of model A or model B.
	 * @param correspondenceReference
	 *            Model A:
	 *            {@link DifferencePackage.eINSTANCE.getCorrespondence_MatchedA())} /
	 *            Model B:
	 *            {@link DifferencePackage.eINSTANCE.getCorrespondence_MatchedA()}.
	 * @return The correspondence of the model A/B object or <code>null</code>.
	 */
	Correspondence getCorrespondence(EObject modelElement, EReference correspondenceReference);

	/**
	 * @param modelElement
	 *            The element of model A.
	 * @return The correspondence of the model A/B object or <code>null</code>.
	 */
	Correspondence getCorrespondenceA(EObject modelElement);

	/**
	 * @param modelElement
	 *            The element of model B.
	 * @return The correspondence of the model A object or <code>null</code>.
	 */
	EObject getCorrespondingObjectInA(EObject objectInB);

	/**
	 * @param modelElement
	 *            The element of model B.
	 * @return The correspondence of the model A/B object or <code>null</code>.
	 */
	Correspondence getCorrespondenceB(EObject modelElement);

	/**
	 * @param modelElement
	 *            The element of model A.
	 * @return The correspondence of the model B object or <code>null</code>.
	 */
	EObject getCorrespondingObjectInB(EObject objectInA);

	/**
	 * @return The corresponding difference.
	 */
	Difference getSymmetricDifference();

	/**
	 * @return All changes of the difference
	 */
	List<Change> getChanges();
}
