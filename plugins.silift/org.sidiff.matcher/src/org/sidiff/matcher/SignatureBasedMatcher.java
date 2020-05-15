package org.sidiff.matcher;

import java.util.Collection;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.collections.DefaultComparators;
import org.sidiff.common.collections.ValueMap;
import org.sidiff.common.utilities.emf.Scope;

public abstract class SignatureBasedMatcher<T> extends BaseMatcher {
	
	private TreeMap<Resource,ValueMap<T, EObject>> signatureValues = null;

	@Override
	protected void init(Collection<Resource> models, Scope scope) {
		super.init(models,scope);		
		signatureValues = new TreeMap<Resource, ValueMap<T,EObject>>(DefaultComparators.getHashComparator(Resource.class));
	}	
	
	@Override
	public void match(){
		for(Resource model :  getModels()){			
			if(scope.equals(Scope.RESOURCE_SET)){
				for(Resource r : model.getResourceSet().getResources()){
					ValueMap<T,EObject> vm = calculateSignatures(r);
					this.signatureValues.put(r, vm);
				}
			}else{
				ValueMap<T,EObject> vm = calculateSignatures(model);
				this.signatureValues.put(model, vm);
			}
			
		}
		matchSignatures();
	}
	
	protected abstract ValueMap<T,EObject> calculateSignatures(Resource model);
	
	protected abstract void matchSignatures();
	
	protected abstract boolean allowsAmbiguousSignature();

	// ---------- Getter and Setter Methods----------
	
	public TreeMap<Resource,ValueMap<T, EObject>> getSignatures(){
		return signatureValues;
	}
	

	
}
