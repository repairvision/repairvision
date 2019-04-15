package org.sidiff.common.stringresolver;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFUtil;

public class GenericStringResolver implements IStringResolver {

	@Override
	public String resolve(EObject eObject) {
		try{
			Object object = eObject.eGet(eObject.eClass().getEStructuralFeature("name"));
			String uuid = EMFUtil.getXmiId(eObject);
			return object.toString() + (uuid != null ? " [" + uuid + "]" : "");
		}catch (NullPointerException e){
			return eObject.toString();
		}
		
	}

	@Override
	public String resolveQualified(EObject eObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canHandleDocType(String docType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDocType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKey() {
		return "GenericStringResolver";
	}

	@Override
	public String getName() {
		return "Generic String Resolver";
	}

}
