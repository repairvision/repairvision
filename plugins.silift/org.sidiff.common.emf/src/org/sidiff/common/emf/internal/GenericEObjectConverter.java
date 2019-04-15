package org.sidiff.common.emf.internal;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.modelstorage.ModelStorage;
import org.sidiff.common.util.ObjectConverter;

public class GenericEObjectConverter implements ObjectConverter {

	@Override
	public Class<?> getType() {
		return EObject.class;
	}

	@Override
	public String marshal(Object object) {
		assert (object instanceof EObject) : "Using EObjectConverter with no EObject!";
		EObject eObject = (EObject) object;
		
		return EcoreUtil.getURI(eObject).toString();
	}

	@Override
	public Object unmarshal(String string) {
		URI uri = URI.createURI(string);
		String path = uri.toFileString();
		String fragment = uri.fragment();

		Resource resource = ModelStorage.getInstance().loadEMF(URI.createFileURI(path));
		return resource.getEObject(fragment);
	}

}
