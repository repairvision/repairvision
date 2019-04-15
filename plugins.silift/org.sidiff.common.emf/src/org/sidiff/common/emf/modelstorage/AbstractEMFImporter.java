package org.sidiff.common.emf.modelstorage;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * This loader imports native EMF models. The models are basically
 * copied during import. The Loader is used to register the URI mappings
 * and to support the loading of files with a suffix different than ".xmi"
 * 
 * @author wenzel
 *
 */
public abstract class AbstractEMFImporter implements Loader {

	@Override
	public void parse(Resource resource, InputStream data) {
		try {
			resource.load(data, null);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public Set<String> getMagicKeys() {
		return Collections.singleton(".*");
	}

}
