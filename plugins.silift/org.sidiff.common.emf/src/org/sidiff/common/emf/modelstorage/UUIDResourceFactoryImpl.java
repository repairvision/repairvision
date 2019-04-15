package org.sidiff.common.emf.modelstorage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

public class UUIDResourceFactoryImpl extends ResourceFactoryImpl {

	@Override
	public Resource createResource(URI uri) {
		return new UUIDResource(uri);
	}

}
