package org.sidiff.common.emf;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.EObjectLocation;

public class EMFResourceUtil {

	public static EObjectLocation locate(Resource model, EObject eObject) {
		// RESOURCE_INTERNAL..?
		if (contains(model, eObject)) {
			return EObjectLocation.RESOURCE_INTERNAL;
		}

		// RESOURCE_SET_INTERNAL..?
		for (Resource r : model.getResourceSet().getResources()) {
			if (r == model) {
				continue;
			}
			if (contains(r, eObject)) {
				return EObjectLocation.RESOURCE_SET_INTERNAL;
			}
		}

		// Must be found in PACKAGE_REGISTRY
		assert (EPackage.Registry.INSTANCE.containsValue(eObject.eClass().getEPackage())) : "" + eObject;
		
		return EObjectLocation.PACKAGE_REGISTRY;
	}

	private static boolean contains(Resource resource, EObject eObject) {
		if(eObject.eResource() == null)
			return false;
		return eObject.eResource().equals(resource);
	}
}
