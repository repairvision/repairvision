package org.sidiff.common.emf.modelstorage;

import java.io.InputStream;
import java.util.*;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * This is the generic interface for loading models into the model storage.<br>
 * It must be implemented by every type dependent model importer.
 * 
 * @author Maik Schmidt
 *
 */
public interface Loader {
	
	/**
	 * This method translates a model into the internal format of SiDiff  
	 * @param resource a new empty resource
	 * @param data the model as {@link InputStream}
	 */
	public void parse(Resource resource,InputStream data);
	
	/**
	 * This method returns the magic keys of the loader. These keys are regular expressions, which must match to the beginning of the file
	 *  
	 * @return A set of regular expressions
	 */
	public Set<String> getMagicKeys();
	
	/**
	 * This method returns the schema location mapping that will used on demand to enable usage of serialized models.
	 *  
	 * @return A set of regular expressions
	 */
	public Map<String,String> getSchemaLocationMappings();
	
	/**
	 * Method for getting the file suffix, which the model loader supports.
	 * @return File suffix as {@link String}
	 */
	public String getSuffix();
	
	/**
	 * Gets the description of the loader.
	 * @return The description as {@link String}
	 */
	public String getLoaderDescription();
	
}
