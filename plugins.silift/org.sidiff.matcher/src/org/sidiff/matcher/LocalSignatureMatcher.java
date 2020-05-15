package org.sidiff.matcher;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.collections.ValueMap;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.utilities.emf.DocumentType;

public abstract class LocalSignatureMatcher extends SignatureBasedMatcher<String> {	

	@Override
	protected ValueMap<String, EObject> calculateSignatures(Resource model) {
		
		ValueMap<String, EObject> idMap = new ValueMap<String, EObject>();
		for (EObject currentObject : EMFUtil.getAllContentAsIterable(model)) {
			//Only do this for unmatched elements
			if(!this.getCorrespondencesService().hasCorrespondences(currentObject)){
				String id = getElementSignature(currentObject);
				if (id != null) {
					//At this point we add all elements (even in case of ambiguous signatures)
					idMap.put(currentObject, id);
				}	
			}
		}
		// If we do not want ambiguous signatures, we remove them now
		if(!allowsAmbiguousSignature()){
			for(String ambiguousID : idMap.getFilledValues(2)){
				System.out.println("Removed Signature: " + ambiguousID + " for objects: " + idMap.getObjects(ambiguousID));
				idMap.remove(ambiguousID);
			}
		}
		return idMap;
		
	}

	@Override
	protected void matchSignatures() {
				
		//We use the "first" ValueMap as starting point.
		ValueMap<String, EObject> correspondenceMap = new ValueMap<String, EObject>();
		Resource firstResource = getModels().iterator().next();
		correspondenceMap.insert(getSignatures().get(firstResource));
		for(Resource res : getSignatures().keySet()){
			if(!res.equals(firstResource))
				correspondenceMap.insert(getSignatures().get(res));
		}
		
		//Now all corresponding elements (minimum 2) are mapped to the same value
		for(String id : correspondenceMap.getFilledValues(2)){			
			
			if(considerCandidatesOnly()){
				//Now we prune all candidates which would penalize the correspondence in size
				//TODO DR: This is just one optimization criteria, this needs to be configurable!
				ValueMap<Integer, EObject> numberOfCandidatesMap = new ValueMap<Integer, EObject>();			
				for(EObject candidate : correspondenceMap.getObjects(id)){
					Set<EObject> otherCandidates = new HashSet<EObject>();
					otherCandidates.addAll(correspondenceMap.getObjects(id));
					otherCandidates.remove(candidate);					
					int numberOfOtherCandidates = 0;
					for(EObject otherCandidate : otherCandidates){
						if(this.getCandidatesService().getCandidates(candidate).contains(otherCandidate))
							numberOfOtherCandidates++;
					}
					numberOfCandidatesMap.put(candidate,numberOfOtherCandidates);
				}
				//As long this is no correspondence regarding the current @see{ICandidates}
				//remove the element with the minimum candidates
				while(!correspondenceMap.getObjects(id).isEmpty() && !this.getCandidatesService().isCandidate(correspondenceMap.getObjects(id).toArray(new EObject[correspondenceMap.getObjects(id).size()]))){
					int minimum = Collections.min(numberOfCandidatesMap.getValues());
					//Remove randomly one
					EObject cand = numberOfCandidatesMap.getObjects(minimum).iterator().next();
					correspondenceMap.removeObject(cand);
					numberOfCandidatesMap.removeObject(cand);
				}
			}
			//We may have a correspondence
			if(correspondenceMap.getObjects(id).size()>=2){
				getCorrespondencesService().addCorrespondence(correspondenceMap.getObjects(id).toArray
						(new EObject[correspondenceMap.getObjects(id).size()]));
				getCandidatesService().removeCandidates(correspondenceMap.getObjects(id).toArray
						(new EObject[correspondenceMap.getObjects(id).size()]));
			}
		}
		
	}
	
	@Override
	public Set<String> getDocumentTypes() {
		Set<String> docTypes = new HashSet<String>();
		docTypes.add(DocumentType.GENERIC_DOCUMENT_TYPE);
		return docTypes;
	}

	@Override
	protected boolean allowsAmbiguousSignature() {
		return false;
	}
	
	protected abstract String getElementSignature(EObject element);
	
	protected abstract boolean considerCandidatesOnly();
}
