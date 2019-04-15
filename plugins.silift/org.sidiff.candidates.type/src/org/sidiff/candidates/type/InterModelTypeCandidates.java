package org.sidiff.candidates.type;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * This implementation of the TypeCandidates assumes that no two model elements may be candidates
 * to each other, if they are originating from the same model. This may be used in versioning but
 * therefore cannot be used for intra model clone detection.
 * @author dreuling
 *
 */
public class InterModelTypeCandidates extends TypeCandidates {
	
	public static final String SERVICE_ID = "InterModelTypeCandidates";

	@Override
	public boolean isCandidate(EObject... candidates) {
		
		EObject candidate = candidates[0];

		//first check resource
		Resource originatingModel = candidate.eResource();
		for(int i = 1; i < candidates.length; i++){
			if(candidates[i].eResource().equals(originatingModel))
				return false;
		}
		
		Set<EObject> cands = new HashSet<EObject>(Arrays.asList(candidates));
		cands.remove(candidate);
		
		//then type
		if(!getCandidates(candidate).containsAll(cands))
			return false;
		
		return true;
	}


	@Override
	public Collection<EObject> getCandidates(EObject element) {
		
		Resource originatingModel = element.eResource();
		EClass elementType = element.eClass();
		
		Set<EObject> candidates = new HashSet<EObject>();
		for(Resource res : this.candidates.keySet()){
			if(!res.equals(originatingModel)){
				candidates.addAll(this.candidates.get(res).getObjects(elementType));
			}
			
		}
		
		return candidates;
	}


	@Override
	public String getServiceID() {
		return SERVICE_ID;
	}

	@Override
	public String getDescription() {
		return "This implementation of the TypeCandidates assumes that no two model elements may be candidates" + 
				" to each other, if they are originating from the same model.";
	}




}
