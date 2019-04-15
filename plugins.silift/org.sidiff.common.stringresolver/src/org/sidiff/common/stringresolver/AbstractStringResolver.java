package org.sidiff.common.stringresolver;

import org.eclipse.emf.ecore.EObject;

/**
 * 
 * @author cpietsch
 *
 */
public abstract class AbstractStringResolver implements IStringResolver {
	
	@Override
	public boolean canHandleDocType(String docType) {
		if(docType.equals(getDocType())){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String resolveQualified(EObject eObject) {
		String res = resolve(eObject);
		EObject eContainer = eObject.eContainer();
		while(eContainer != null){
			res = resolve(eContainer) + "." + res;		
			eContainer = eContainer.eContainer();
		}
		return res;
	}
}
