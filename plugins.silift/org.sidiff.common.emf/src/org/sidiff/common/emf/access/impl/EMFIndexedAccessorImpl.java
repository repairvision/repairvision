package org.sidiff.common.emf.access.impl;

import java.util.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.collections.DefaultComparators;
import org.sidiff.common.emf.access.EMFReverseAccessor;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.common.util.StatisticsUtil;

/**
 * This is an implementation of a reverse accessor that internally
 * creates an index that maps from each element to all elements referring to it. 
 * @author wenzel
 *
 */
public class EMFIndexedAccessorImpl implements EMFReverseAccessor{

	// Data-structures needed for indexing a--x-->b : b(x)={a1,...,an}
	private Map<Resource,Map<EObject,Map<EReference,Collection<EObject>>>> index = null;
		
	public EMFIndexedAccessorImpl(){
		this.index = new HashMap<Resource, Map<EObject,Map<EReference,Collection<EObject>>>>();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<EObject> getRefers(EObject target, EReference reference) {

		// a--x-->b : b(x)={a1,...,an}
		assert(target!=null) : "Cannot get refers from null";
		assert(reference!=null) : "Cannot get refers by null reference";
		assert(reference==null||reference.getEReferenceType().isSuperTypeOf(target.eClass())) : "Reference cannot point to ("+target.eClass().getName()+") target! ("+reference.getName()+"-->"+reference.getEReferenceType().getName()+")";
		
		Collection<EObject> result = null;
		
		// *********************************************************************
		if(!index.containsKey(target.eResource())){
			createIndex(target.eResource()); // On demand: Create Index for not indexed Resource
		}
		
		Map<EReference,Collection<EObject>> targetIndex = this.index.get(target.eResource()).get(target);
		if(targetIndex!=null){
			result = targetIndex.get(reference);
		}
		result=	(result==null)? Collections.EMPTY_LIST : result;

		return result;
	}
	
	@SuppressWarnings("unchecked")
	private void createIndex(Resource resource) {
		
		assert(!this.index.containsKey(resource)) : "Index already exists! "+resource.getURI();
		StatisticsUtil.getInstance().start(this+":"+resource);

		// ******************* Compute Index **************************************************
		Map<EObject, Map<EReference,Collection<EObject>>> newMap = new TreeMap<EObject, Map<EReference,Collection<EObject>>>(DefaultComparators.getHashComparator(EObject.class));
		this.index.put(resource, newMap);

		TreeIterator<EObject> resourceIterator = resource.getAllContents();
		while(resourceIterator.hasNext()){
			EObject source = resourceIterator.next();
			for(EReference reference : source.eClass().getEAllReferences()){
				if(reference.getEOpposite()==null){
					// Its a directed reference, so create index!
					if(reference.isMany()){
						for(EObject target : (EList<EObject>)source.eGet(reference)){
							addIndexEntry(source,reference,target,(target.eResource()==resource)? newMap : null);
						}
					} else {
						EObject target = (EObject)source.eGet(reference);
						if(target!=null){
							addIndexEntry(source, reference, target,(target.eResource()==resource)? newMap : null);
						}
					}
				}
			}
		}
		
		StatisticsUtil.getInstance().stop(this+":"+resource);
		LogUtil.log(LogEvent.NOTICE, "Index created in "+StatisticsUtil.getInstance().getTime(this+":"+resource)+" ("+resource.getURI()+")");
	}
	
	private void addIndexEntry(EObject source,EReference reference,EObject target,
			Map<EObject, Map<EReference,Collection<EObject>>> index){
		// a--x-->b : b(x)={a1,...,an}
		
		Map<EObject,Map<EReference,Collection<EObject>>> targetResourceIndex = index;
		if(targetResourceIndex==null){
			
			if(target.eResource()!=null && !this.index.containsKey(target.eResource())){ // Anmerkung SW: Es kann vorkommen, dass das Target keine Resource hat, wenn es z.B. in ein externes, nicht geladenes Modell zeigt.
				// target contained in a not indexed resource 
				createIndex(target.eResource());
			} 
			targetResourceIndex = this.index.get(target.eResource());
		}
 
		// Wenn target in externem, nicht geladenen Modell liegt, muss auch kein Index aufgebaut werden.  
		if (targetResourceIndex!=null) {
			Map<EReference,Collection<EObject>> referenceSourceIndex = targetResourceIndex.get(target);
			if(referenceSourceIndex==null){
				referenceSourceIndex = new TreeMap<EReference,Collection<EObject>>(DefaultComparators.getHashComparator(EReference.class));
				targetResourceIndex.put(target,referenceSourceIndex);
			}

			Collection<EObject> sourceSet = referenceSourceIndex.get(reference);
			if(sourceSet==null){
				sourceSet = new HashSet<EObject>();
				referenceSourceIndex.put(reference,sourceSet);
			}
			sourceSet.add(source);
		}
		
	}
	
}
