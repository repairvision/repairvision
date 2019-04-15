package org.sidiff.common.emf.access;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.EMFUtil;

/**
 * Utility to checks if two external elements are equal. 
 * They are considered equal, if they are both external and have the same URI.
 * Otherwise they are considered different. 
 * 
 * Elements are considered to be internal, if they belong to one of the given resources.
 * 
 * @author wenzel
 *
 */
public enum ExternalObjectComparison {

	Equal,
	Different,
	BothInternal;
	
	public static ExternalObjectComparison compare(EObject obj1, EObject obj2, Resource... resources) {
		assert(resources.length>0):"No resources given!";
		boolean ext1 = true;
		boolean ext2 = true;
		
		for (int i = 0; i<resources.length; i++) {
			if (ext1 && obj1.eResource()==resources[i]) {
				ext1 = false;
			}
			if (ext2 && obj2.eResource()==resources[i]) {
				ext2 = false;
			}
			if (!ext1 && !ext2)
				break;
		}
		
		if (ext1 && ext2 && EMFUtil.getEObjectURI(obj1).equals(EMFUtil.getEObjectURI(obj2)))
			return Equal;
		
		if (!ext1 && !ext2)
			return BothInternal;
		
		return Different;
	}
	
}
