package org.sidiff.candidates.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.collections.ClassificationUtil;
import org.sidiff.common.collections.ValueMap;


public abstract class TypeCandidates implements ICandidates {

	protected Collection<Resource> models = null;

	protected Map<Resource,ValueMap<EClass, EObject>> candidates;

	@Override
	public void init(Collection<Resource> models) {


			this.candidates = new HashMap<Resource, ValueMap<EClass,EObject>>();
			this.models = models;

			for (Iterator<Resource> iterator = models.iterator(); iterator.hasNext();) {
				Resource resource = (Resource) iterator.next();
				Map<EClass, Set<EObject>> typeMap;
				List<EObject> allElements = new ArrayList<EObject>();
				
				for(EObject obj : (Iterable<EObject>) () -> resource.getAllContents()){
					allElements.add(obj);
				}
				typeMap = ClassificationUtil.classifiedSets(allElements, EMFClassifiers.ELEMENT_BY_CLASS);
				ValueMap<EClass, EObject> types = new ValueMap<EClass, EObject>();
				for(EClass type : typeMap.keySet()){
					for(EObject obj : typeMap.get(type)){
						types.put(obj, type);
					}
				}
				this.candidates.put(resource, types);
		}

	}	



	@Override
	public void reset() {
		this.models = null;
		this.candidates = null;
	}

	@Override
	public boolean hasCandidates(EObject element) throws Exception {
		
		return getCandidates(element).size() > 0;
		
	}

	@Override
	public void addCandidate(EObject candidate) {
		
		Resource originatingModel = candidate.eResource();
		EClass candidateType = candidate.eClass();
		this.candidates.get(originatingModel).put(candidate, candidateType);		
		
	}

	@Override
	public void removeCandidate(EObject candidate) {
		
		Resource originatingModel = candidate.eResource();
		this.candidates.get(originatingModel).containsObject(candidate);
		this.candidates.get(originatingModel).removeObject(candidate);		
	}
	

	@Override
	public void removeCandidates(EObject... candidates) {
		for(EObject candidate : candidates){
			removeCandidate(candidate);
		}
		
	}
	

}
