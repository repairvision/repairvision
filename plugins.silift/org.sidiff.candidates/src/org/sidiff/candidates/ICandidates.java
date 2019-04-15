package org.sidiff.candidates;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.service.IService;

public interface ICandidates extends IService {
	public static final String EXTENSION_POINT_ID = "org.sidiff.candidates.extensionpoint";
	public static final String SERVICE_ID = "ICandidates";
	
	/**
	 * Checks whether the given candidate object(s) is/are candidate(s) for each other
	 * 
	 * @param candidates
	 * @return
	 * @throws Exception
	 */
	public boolean isCandidate(EObject... candidates);

	/**
	 * Checks whether the given element has candidates. This is equal to the
	 * element being candidate for another element. (hasCandidates == true
	 * implies getCandidates().size() > 0)
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean hasCandidates(EObject element) throws Exception;

	/**
	 * Gets the list of candidates for an element.
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public Collection<EObject> getCandidates(EObject element);	
	
	/**
	 * Adds a candidate
	 * 
	 * @param candidate
	 * @return
	 */
	public void addCandidate(EObject candidate);
	
	/**
	 * Removes a candidate
	 * 
	 * @param candidate
	 * @return
	 */
	public void removeCandidate(EObject candidate);
	
	/**
	 * Removes all candidates
	 * 
	 * @param candidates
	 * @return
	 */
	public void removeCandidates(EObject... candidates);

	
	/**
	 * initialize the Service with the models
	 * 
	 * @param models
	 */
	void init(Collection<Resource> models);
	
	/**
	 * 
	 * @return the id of the candidateservice
	 */
	public String getServiceID();
	
}
