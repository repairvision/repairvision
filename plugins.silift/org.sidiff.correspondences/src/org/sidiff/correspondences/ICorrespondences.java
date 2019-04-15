package org.sidiff.correspondences;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.service.IService;

public interface ICorrespondences extends IService {
	public static final String EXTENSION_POINT_ID = "org.sidiff.correspondences.extensionpoint";
	public static final String SERVICE_ID = "ICorrespondences";

	/**
	 * Creates a correspondence between the given elements.
	 * 
	 * @param elements
	 * @throws Exception
	 */
	public void addCorrespondence(EObject... elements);

	/**
	 * Checks whether the given element has correspondences or not.
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean hasCorrespondences(EObject element);

	/**
	 * Checks whether the given elements do correspond or not.
	 * 
	 * @param elements
	 * @return
	 */
	public boolean isCorresponding(EObject... elements);

	/**
	 * Returns all "other" elements of a correspondence. I.e. all
	 * correspondences except the given element.
	 * 
	 * Returns an empty Collection, if the element has no correspondences.
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public Collection<EObject> getCorrespondences(EObject element);

	/**
	 * Returns all elements of the given model that have a correspondence
	 */
	public Collection<EObject> getElementsWithCorrespondences(Resource model);

	/**
	 * Returns all elements of the given model that do not have a correspondence
	 */
	public Collection<EObject> getElementsWithoutCorrespondences(Resource model);

	/**
	 * Removes the given correspondence
	 * 
	 * @param elements
	 * @throws Exception
	 */
	public void removeCorrespondence(EObject... elements);	

	/**
	 * Removes element from correspondence
	 * 
	 * @param element
	 * @throws Exception
	 */
	public void removeFromCorrespondence(EObject element);

	void init(Collection<Resource> models);
	
	public boolean canHandle(Collection<Resource> models);

}
