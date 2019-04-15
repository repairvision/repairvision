package org.sidiff.common.emf.derivation;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.sidiff.common.collections.DefaultComparators;

class CachedFeatureDeterminator implements FeatureDeterminator<EObject,Object> {

	private FeatureDeterminator<?,?> uncachedFeatureDeterminator = null;
	private Map<EObject,Object> cachedValues = null;
	
	CachedFeatureDeterminator(FeatureDeterminator<?,?> uncachedFeatureDeterminator) {
		this.uncachedFeatureDeterminator = uncachedFeatureDeterminator;
		this.cachedValues = new TreeMap<EObject, Object>(DefaultComparators.getHashComparator(EObject.class));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object compute(EObject holder) {
		
		Object result = null;
		if(this.cachedValues.containsKey(holder)){
			result = this.cachedValues.get(holder);
		} else {
			 result = ((FeatureDeterminator<EObject, Object>)uncachedFeatureDeterminator).compute(holder);
			this.cachedValues.put(holder, result); 
		}
		return result;
	}

	@Override
	public int getClassifierID() {
		return this.uncachedFeatureDeterminator.getClassifierID();
	}

	@Override
	public int getFeatureID() {
		return this.uncachedFeatureDeterminator.getFeatureID();
	}

	@Override
	public EPackage getPackage() {
		return this.uncachedFeatureDeterminator.getPackage();
	}

}
