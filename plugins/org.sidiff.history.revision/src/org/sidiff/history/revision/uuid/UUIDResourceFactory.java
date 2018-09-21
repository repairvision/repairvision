package org.sidiff.history.revision.uuid;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

public class UUIDResourceFactory extends ResourceFactoryImpl {
	
	@Override
	public Resource createResource(URI uri) {
		return new UUIDResource(uri);
	}
}
