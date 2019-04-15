package org.sidiff.common.emf.nsregistry;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.sidiff.common.io.IOUtil;
import org.sidiff.common.io.MapLoader;



/**
 * Offers a local namespace registry
 * 
 * The local namespace registry nsRegistry is an instance of the EPackageRegistryImpl and
 * delegates uris that are not found locally to the ePackage.Registry as fallback-mechanism
 * 
 * Advantages of this approach vs custom implementations (e.g. Map<String,Epackage)
 * 
 * - no re-implementation of functionality 
 * - nsRegistry uses automatically Epackage.Registry as fallback when an uri can't be found locally 
 * - allows access to all standard functionality of EPackageRegistryImpl
 * 
 * @author Pit Pietsch
 * 
 */

// TODO: Review, JavaDoc
@Deprecated
public abstract class NSRegistry {

	private static EPackageRegistryImpl nsRegistry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);

	public static final String NS_TYPENAME_SEPERATOR = "::";
	public static final String NS_CLASSNAME_SEPERATOR = "\\.";

	/**
	 * This method returns the local EPackageRegistryImpl nsRegistry and allows direct access to its functionality.
	 * 
	 * @return {@link EPackageRegistryImpl}
	 */
	public static EPackageRegistryImpl getRegistry() {
		return nsRegistry;
	}

	
	
	
	 //*************************Registering & Unregistering of uriAliases *********************** 
	
	/**
	 * This method registers an EPackage under the specified URI in the local nsRegistry
	 * 
	 * Note that the ePackage my not be known to the EPackage.Registry
	 * 
	 * @param uri
	 *            the uri for the model
	 * @param ePackage
	 *            the model that will be registered under the uri
	 */
	public static void registerNamespace(String uri, EPackage ePackage) {
		nsRegistry.put(uri, ePackage);
	}

	/**
	 * This method registers an existing uri under an additional handle.
	 * 
	 * E.g. namespace = "short" & uri = "http://www.sidiff.org/my.namespace.is.way.way.too.long" will register the EPackage for URI under the handle "short".
	 * 
	 * Note that the handle will only be stored in the local nsRegistry and can't be resolved if the EPackage.Registry is queried directly
	 * 
	 * @param urialias
	 *            the new additional handle for the URI
	 * @param uri
	 *            the already existing URI of the model
	 */
	public static void registerName(String uriAlias, String uri) {

		//uri must already be registered with nsRegsitry or EPackage.Registry
		EPackage ePackage = nsRegistry.getEPackage(uri);
		
		if (ePackage == null)
				throw new NamespaceNotFoundException("No EPackage registered under uri '" + uri +"'");
		
		nsRegistry.put(uriAlias, nsRegistry.getEPackage(uri));
	}

	/**
	 * This method registers an existing URIs under additional handles as specified within the map
	 * 
	 * Note that the handle will only be stored in the local nsRegistry and can't be resolved if the EPackage.Registry is queried directly
	 * 
	 * @param map
	 *             the URI-Identifier-Map to parse and register
	 */
	public static void registerNames(String identifierMapName) {

		EPackage ePackage = null;
		
		for (Entry<String, String> entry : MapLoader.parseMapFromStream("URI-Identifier-Map", IOUtil.getInputStream(identifierMapName)).entrySet()) {
			
			//uri must already be registered with nsRegsitry or EPackage.Registry
			 ePackage = nsRegistry.getEPackage(entry.getValue());
			
			if (ePackage == null)
					throw new NamespaceNotFoundException("No EPackage registered under uri '" + entry.getValue() +"'");
			
			nsRegistry.put(entry.getKey(), ePackage);
		}
	}

	
	/**
	 * This method unregisters an URI/Model from the local nsRegistry
	 * 
	 * @param uri
	 *            the URI to unregister
	 * @return the ePackage stored for the URI or null if is the URI is not registered
	 */
	public static void unregisterName(String uriAlias) {
		nsRegistry.remove(uriAlias);
	}
	

	/**
	 * This method unregisters additional handles for URIs as specified within the map
	 * 
	 * 
	 * @param map
	 *            the URI-Identifier-Map to parse and unregister
	 */
	public static void unregisterNames(String identifierMapName)
	{
		for (Entry<String, String> entry : MapLoader.parseMapFromStream("URI-Identifier-Map", IOUtil.getInputStream(identifierMapName)).entrySet()) {

			nsRegistry.remove(entry.getKey());
		}
	}

	/**
	 * This method unregisters all URIs & Models from the local nsRegistry
	 */
	public static void unregisterAllNames() {
		nsRegistry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
	}

	
	 //*************************LookUp Functionality *********************** 
	
	/**
	 * This method looks up and returns the EPackage for the given URI
	 * 
	 * @param uri
	 *            the URI to look up
	 * @return the ePackage stored for the URI or null if is the URI is not registered
	 */
	public static EPackage getPackage(String uriAlias) {
		
		EPackage ePackage = nsRegistry.getEPackage(uriAlias);
		
		if (ePackage == null)
			throw new NamespaceNotFoundException("No EPackage registered under uri '" + uriAlias +"'");

		return  ePackage;
	}
	
	
	
	/**
	 * This method looks up the given namespace and returns the given class if it exists
	 * Note that when a relative addressing is used the uriAlias has to be valid!
	 * Note that when a ns identifier is used, the uriAlias will be ignored
	 * 
	 * Syntax
	 *   uriAlias, typeString
	 *	"http://www.sidiff.org/org.sidiff.uml.model/classes","UMLClass";
	 *  "http://www.sidiff.org/org.sidiff.uml.model","classes.UMLClass" --> relative adressing
	 *  "ignoredUri","http://www.sidiff.org/org.sidiff.uml.model::classes.UMLClass" --> ns identifier used
	 * 
	 * @param uri
	 *            the URI to look up
	 * @param className
	 *            the classname to look up
	 * @return the EClass specified by URI and Classname
	 */
	public static EClass getClass(String uriAlias, String typeString) {

		String[] tokenizedTypeString = null;
		String[] tokenizedClassName = null; 
		String className = null;
		EPackage ePackage = null;
		
		//ns-idenfier is used?
		tokenizedTypeString = typeString.split(NS_TYPENAME_SEPERATOR);
		if (tokenizedTypeString.length == 2)
		{
			uriAlias = tokenizedTypeString[0];
			typeString = tokenizedTypeString[1];
			
		}
		
		tokenizedClassName = typeString.split(NS_CLASSNAME_SEPERATOR);
			
		className = tokenizedClassName[tokenizedClassName.length-1];
			
		if(tokenizedClassName.length > 1) //relative addressing used -> resolve package
			{				
				ePackage = resolvePackage(uriAlias, tokenizedClassName);
			}
					
		//ePackage == null? --> no relative adressing used, so look up uriAlias! 
		if (ePackage == null) ePackage = nsRegistry.getEPackage(uriAlias);
		
		//ePackage still null? --> uri not registered! 
		if (ePackage == null)
			throw new NamespaceNotFoundException("No EPackage registered under uri '" + uriAlias +"'");
		
		//delegate lookup to getClass(ePackage,classname)
		return getClass(ePackage, className);
		
			
	}

	/**
	 * This method looks up a typestring with ns-Identifier and tests if the specified Class 
	 * exists. The typename seperator is specified in NS_TYPENAME_SEPERATOR
	 * 
	 * Syntax: 	uriAlias::TypePath
	 * 			"http://www.sidiff.org/org.sidiff.uml.model::classes.UMLClass");"
	 * 			"classes::UMLClass"
	 * 
	 * @param typeString
	 *            the URI and Classname to look up
	 * @return the EClass specified by URI and Classname
	 */
	public static EClass getClass(String typeString) {

		String[] tokenizedTypeString = typeString.split(NS_TYPENAME_SEPERATOR);

		// condition typestring well formed
		assert (tokenizedTypeString.length == 2) : "Malformed Typestring '" + typeString + "'";

		//delegate lookup to getClass(uriAlias,classname)
		return getClass(tokenizedTypeString[0], tokenizedTypeString[1]);
	}

	
	/**
	 * This method looks up a Class classname in the given ePackage and returns the ECLass.
	 * 
	 * @param ePackage
	 *            the ePackage to look up the class "classname"
	 * @param classname
	 *            the classname 
	 * @return the EClass specified by ePackage and Classname
	 */

	public static EClass getClass(EPackage ePackage, String className) {

		EClass eClass = (EClass) ePackage.getEClassifier(className); 
		
		//class not found
		if (eClass == null)
			throw new NamespaceException("No Classifier '" + className + "' known in EPackage '" + ePackage.getNsURI() +"'");

		return eClass;

	}
		
	/*
	 * resolves a EPackage when relative addressing is used
	 */
	private static EPackage resolvePackage(String uriAlias, String[] tokenizedClassName)
	{
		EPackage basePackage = nsRegistry.getEPackage(uriAlias);
		EPackage curPackage = null;
		
		//uriAlias valid?
		if (basePackage == null)
			throw new NamespaceNotFoundException("No EPackage registered under uri '" + uriAlias +"'");
				
		for (int i = 0; i < tokenizedClassName.length-1; i++)
		{
			for (EPackage e : basePackage.getESubpackages())
			{
				if (e.getName().equals(tokenizedClassName[i]))
					curPackage = e;
			}
			
			//no package found --> invalid uriAlias
			if (curPackage == null)
				throw new NamespaceNotFoundException("No EPackage registered under uri '" + uriAlias +"'");
			
			basePackage = curPackage;
			curPackage = null;
		}
		
		return basePackage;
	}
}


/** 
 * 
 * Beispiele: (sind inhaltlich alle gleich!)
 *
 * 
 * getClass("http://com.etasgroup.sidiff.datamodel/specification/blockdiagram/operators","Add"); 
 * 	-> done
 * 
 * getClass("http://com.etasgroup.sidiff.datamodel","specification.blockdiagram.operators.Add"); 
 * 	->done
 * 
 * getClass(null,"ascet-operators:Add"); 
 * -> use getClass("ascet-operators:Add");
 * 
 * getClass(null,"http://com.etasgroup.sidiff.datamodel:specification.blockdiagram.operators.Add");
 * -> use getClass("http://com.etasgroup.sidiff.datamodel:specification.blockdiagram.operators.Add")
 * 
 * getClass("http://org.sidiff.umlclass","ascet-operators:Add");
 * -> done. can also be handled by getClass("ascet-operators:Add")
 *
 *
 * getClass(String className); // base-uri:rel.classs
 * -> done
 *
 */