package org.sidiff.common.emf.modelstorage;

import java.io.*;
import java.util.*;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.io.IOUtil;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.common.util.StringUtil;

/**
 * @author Maik Schmidt
 *
 */
public class ModelStorage {

	private static final String ECORE_MAPPING_PROPERTY = "ECORE_MAPPING";
	private static final String FORCE_TRANSFORMATION_PROPERTY = "FORCE_TRANSFORMATION";
	private static final String IGNORE_SUFFIX_PROPERTY = "IGNORE_SUFFIX";
	
	private static final ModelStorage instance = new ModelStorage();
	
	private static final String URI_ID_SEPERATOR = "::";
	private static final char EXTENSION_SEPERATOR = '.';
	public static final String ECORE_INSTANCE_MODEL_SUFFIX = EXTENSION_SEPERATOR+"xmi";
	public static final String ECORE_MODEL_SUFFIX = EXTENSION_SEPERATOR+"ecore";
	public static final String NATIVE_MODEL_SUFFIX = EXTENSION_SEPERATOR+"smf"+ECORE_INSTANCE_MODEL_SUFFIX;
	private static final String TEMP_RESOURCE_PREFIX = "SiDiff_";

	private static final int LOADERCHECK_READ_AHEAD = 1000;
	private static boolean ALWAYS_FORCE_TRANSFORMATION = false;
		
	
	private static final Map<String,Object> LOAD_OPTIONS = new HashMap<String, Object>();
	private static final Map<String,Object> SAVE_OPTIONS = new HashMap<String, Object>();
	
	private int internalModelID = 0;
	
	private ResourceSet globalResourceSet = null;
	private Map<String, Resource> models = null;
	private Map<String,Set<Loader>> loadersByExtension = null;
	private Map<Class<? extends Loader>,Loader> loadersByClass = null;
	private Set<String> nativeSuffixes = null;
	
	static{
		// Properties
		if(System.getProperty(FORCE_TRANSFORMATION_PROPERTY)!=null
		&& System.getProperty(FORCE_TRANSFORMATION_PROPERTY).equalsIgnoreCase(Boolean.TRUE.toString())){
			assert(LogUtil.log(LogEvent.DEBUG, "FORCE_TRANSFORMATION ENABLED"));
			ALWAYS_FORCE_TRANSFORMATION=true;
		}
		
		if(System.getProperty(ECORE_MAPPING_PROPERTY)!=null
		&& System.getProperty(ECORE_MAPPING_PROPERTY).equalsIgnoreCase(Boolean.TRUE.toString())){
			assert(LogUtil.log(LogEvent.DEBUG, "MAPPINGS ENABLED"));
			SAVE_OPTIONS.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		}
		
		// Default Load/Save options
		//SAVE_OPTIONS.put(XMIResource.OPTION_ZIP,  Boolean.TRUE);
		//LOAD_OPTIONS.put(XMIResource.OPTION_ZIP,  Boolean.TRUE);
	}
	
	private ModelStorage(){
		
		// Common ResourceSet
		this.globalResourceSet = new ResourceSetImpl();
		this.globalResourceSet.setPackageRegistry(EPackage.Registry.INSTANCE);
		
		// Known/Managed Models
		this.models= new TreeMap<String, Resource>();
		
		// Loader Management
		this.loadersByExtension= new TreeMap<String, Set<Loader>>();
		this.loadersByClass= new HashMap<Class<? extends Loader>,Loader>();
		this.nativeSuffixes = new HashSet<String>();
		
		// Build-in native Suffixes, do not generaly allow .xmi! 
		nativeSuffixes.add(NATIVE_MODEL_SUFFIX);
		nativeSuffixes.add(ECORE_MODEL_SUFFIX);
	}
	
	/**
	 * <i>Singleton!</i>
	 * 
	 * @return The only one instance of the model storage in the system.
	 */
	public static ModelStorage getInstance(){
		
		return instance;
	}
	
	/**
	 * This method registers a type specific loader at the model storage. 
	 * @param loader
	 * @return {@link <code><b>true</b></code>} if no loader for the specific suffix is registered, else {@link <code><b>false</b></code>}.
	 */
	public boolean registerLoader(Loader loader){
		
		if (this.loadersByClass.put(loader.getClass(), loader) == null) {
			
			// Get loader-set by extension
			Set<Loader> loaderSet = null;
			if (this.loadersByExtension.containsKey(loader.getSuffix())) {
				loaderSet = this.loadersByExtension.get(loader.getSuffix());
			} else {
				loaderSet = new HashSet<Loader>();
				this.loadersByExtension.put(loader.getSuffix(), loaderSet);
			}
			
			// Register Mappings
			Map<String, String> mappings = loader.getSchemaLocationMappings();
			if(mappings!=null){
				// Register Schema Location Mappings
				for(String key : mappings.keySet()){
					URI keyURI = URI.createURI(key);
					URI valueURI = URI.createURI(mappings.get(key));
					if (URIConverter.URI_MAP.containsKey(keyURI)){
						if(!URIConverter.URI_MAP.get(keyURI).equals(valueURI)){
							throw new IllegalArgumentException("Conflicting Mapping:"+key+"->"+URIConverter.URI_MAP.get(key)+"|"+mappings.get(key));
						} // Else same Mapping
					} else {
						URIConverter.URI_MAP.put(keyURI, valueURI);
					}
					if (URIConverter.URI_MAP.containsKey(URI.createURI(key))) {
						System.out.println();
					}
				}
			}
			
			return loaderSet.add(loader);

		} else {
			throw new IllegalArgumentException("Loader already registered!" + loader);
		}
	}
	
	public boolean registerMetaModel(String fileOrResourceName, String instanceFileSuffix){
		
		if(fileOrResourceName!=null&&!fileOrResourceName.equals("")
		 &&instanceFileSuffix!=null&&!instanceFileSuffix.equals("")){
			
			if (fileOrResourceName.endsWith(ECORE_MODEL_SUFFIX)) {
				if (!this.nativeSuffixes.contains(instanceFileSuffix)) {
					globalResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(instanceFileSuffix, new XMIResourceFactoryImpl());
				}
				Resource mmResource = loadEMF(fileOrResourceName, fileOrResourceName);
				if(mmResource.getContents().size()!=1){
					LogUtil.log(LogEvent.WARNING, "Metamodel "+fileOrResourceName+" consists of "+mmResource.getContents().size()+" parts!");
				}
				for(EObject contetnt : EMFUtil.getAllContentAsIterable(mmResource)){
					if(contetnt instanceof EPackage){
						EPackage ePackage = (EPackage)contetnt;
						this.globalResourceSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
						assert(LogUtil.log(LogEvent.DEBUG, "Register: "+ePackage.getNsURI()));
					} 
				}
				return true;
			}
			return false;
		} else {
			throw new IllegalArgumentException(fileOrResourceName+"/"+instanceFileSuffix);
		}
		
	}
	
	/**
	 * Registers the given Adapter Factory to the global ResourceSet. So it provides the Adapter
	 * functionality as provided by the given factory to all objects managed by SiDiff.
	 * 
	 * @see EcoreUtil.getRegisteredAdapter
	 * @see ResourceSet.getAdapterFactories
	 * 
	 * @param factory the factory to register globaly.
	 */
	public void registerAdapterFactory(AdapterFactory factory){
		
		if(!globalResourceSet.getAdapterFactories().contains(factory)){
			this.globalResourceSet.getAdapterFactories().add(factory);
		} else {
			throw new IllegalArgumentException("Factory already registered! "+factory.getClass().getName());
		}
	}
	
	/**
	 * Unregisters the given Adapter Factory from the global ResourceSet. The functionality provided by the
	 * Adapters could not applied to any object managed by SiDiff.
	 * 
	 * @see EcoreUtil.getRegisteredAdapter
	 * @see ResourceSet.getAdapterFactories
	 * 
	 * @param factory the factory to register globaly.
	 */
	public void unregisterAdapterFactory(AdapterFactory factory){
		
		if(globalResourceSet.getAdapterFactories().contains(factory)){
			this.globalResourceSet.getAdapterFactories().remove(factory);
		} else {
			throw new IllegalArgumentException("Factory already registered! "+factory.getClass().getName());
		}
	}
	
	/**
	 * This method removes the registration of the referred loader
	 * @param loader
	 * @return {@link <code><b>true</b></code>} if loader for the specific suffix was removed, else {@link <code><b>false</b></code>}.
	 */
	public boolean releaseLoader(Loader loader){
		
		if (this.loadersByClass.remove(loader.getClass()) != null) {

			// Remove from loader-set
			Set<Loader> loaderSet = null;
			if (this.loadersByExtension.containsKey(loader.getSuffix())) {
				loaderSet = this.loadersByExtension.get(loader.getSuffix());
				if (loaderSet.remove(loader)) {
					if (loaderSet.isEmpty()) {
						// Remove empty set
						this.loadersByExtension.remove(loader.getSuffix());
					}
					
					// Unregister Mappings
					Set<String> mappings = loader.getSchemaLocationMappings().keySet();
					for (String mapping : mappings){
						assert(URIConverter.URI_MAP.containsKey(URI.createURI(mapping))) : "Mapping lost: "+mapping;
						
						boolean removeMapping = true;
						for(Loader otherLoader : this.loadersByClass.values()){
							for(String otherMapping : otherLoader.getSchemaLocationMappings().keySet()){
								if(mapping.equals(otherMapping)){
									removeMapping=false;
									break;
								}
							}
							if(!removeMapping){
								break;
							}
						}
						if(removeMapping){
							URIConverter.URI_MAP.remove(URI.createURI(mapping));
						}
					}	
					return true;
				}
			}
			return false;
		} else {
			throw new IllegalArgumentException("Loader not registered!" + loader);
		}	
	}
	
	/**
	 * Loads and registers a EMF-Resource by given URI. The Resource will be available by 
	 * the resource identifying resource URI-String. If a resource with given URI is already
	 * (may registered by an different key) loaded, the instance will just registered with 
	 * unique uri-string.  
	 * 
	 * @param uri The identifying Resource-URI 
	 * @return the corresponding Resource.
	 */
	public Resource loadEMF(URI uri){

		if (!this.models.containsKey(uri.toString())) {
			if (new File(uri.toFileString()).canRead()) {
				this.models.put(uri.toString(), this.globalResourceSet.getResource(uri, true));
			} else {
				LogUtil.log(LogEvent.ERROR, "Cannot read from " + uri);
				throw new IllegalArgumentException("Cannot read from (" + uri + ") !");
			}
		} else {
			if (this.models.get(uri.toString()) != this.globalResourceSet.getResource(uri, true)) {
				throw new IllegalArgumentException("Uri " + uri + " already assigned to different resource!");
			}
		}

		return this.models.get(uri.toString());
	}

	/**
	 * This method loads a EMF model using the XMI format into the model storage
	 * 
	 * @param fileOrResourceName {@link String} containing the file or resource name of the model
	 * 
	 * @return unique identification key of the model as {@link String} or {@link <code>null</code>}
	 */
	public String loadEMF(String fileOrResourceName){
		
		Resource result = loadEMF(fileOrResourceName,null);
		return (result!=null)? result.getURI().toString()+URI_ID_SEPERATOR+internalModelID : null;
	}
	
	/**
	 * This method loads a EMF model using the XMI format into the model storage.
	 * 
	 * @param fileOrResourceName {@link String} containing the file or resource name of the model
	 * @param id {@link String} containing an user definable identifier (e.g.: modelA, modelB, ...)
	 * 
	 * @return {@link Resource} or {@link <code>null</code>}
	 */
	public Resource loadEMF(String fileOrResourceName, String id){

		Resource result = null;
		if(fileOrResourceName!=null){
			if(checkSuffix(fileOrResourceName, this.nativeSuffixes)){
				result=createManagedResource(fileOrResourceName, id,true);// filename!=null! id?
				if (!result.isLoaded()) {
					try {
						result.load(IOUtil.getInputStream(fileOrResourceName), LOAD_OPTIONS);
					} catch (IOException e) {
						LogUtil.log(LogEvent.ERROR, "Error while loading EMF-Model:\n", e);
					}
				}
			} else {
				LogUtil.log(LogEvent.ERROR, "Invalid EMF-Model Filename: '"+fileOrResourceName+"' (one of "+StringUtil.resolve(this.nativeSuffixes)+" Expected!)");
			}
		} else {
			LogUtil.log(LogEvent.ERROR, "Missing EMF-Model Filename!");
		}
		
		// Also resolve all eProxyURIs inside the resource's ResourceSet.
		// This is not done automatically when loading a resource.
		// This was noticed when additional, external resources are referenced
		// or cross referenced (e.g. ProfileApplication references)
		EcoreUtil.resolveAll(result.getResourceSet());
		
		return result;
	}
	
	
	/**
	 * Creates a Resource, containing the given Object.
	 * 
	 * @param from a set of (root) objects, witch should be assigned
	 * to the new Resource
	 *  
	 * @return System generated surrogate-String, identifying the new resource. 
	 */
	public String createResource(EObject... from){
		
		Resource resource = createResource(null,from);
		return resource.getURI().toString()+URI_ID_SEPERATOR+internalModelID;
	}
	
	/**
	 * Creates a Resource, containing the given Object.
	 * 
	 * @param from a set of (root) objects, witch should be assigned
	 * to the new Resource
	 *  
	 * @return System generated surrogate-String, identifying the new resource. 
	 */
	public Resource createResource(String id,EObject... from){
		
		Resource result = createManagedResource(id, id,true);

		if(from!=null){
			for(EObject topLevelElement : from){
				result.getContents().add(topLevelElement);
			}
		}
		return result;
	}
	
	/**
	 * Internal Method for creation of a managed ResourceSet
	 * 
	 * Beware: 
	 * -When a id was given, the Resource will be assigned to these id (_must_ be global unique!)
	 * - if no id was given, a id will be created:
	 * 	++ if a filename was given, the id consist of the filename::[internalid]
	 * 	++ if no filename was given a temporary filename is used
	 * 
	 * @param fileOrResourceName the (file)name of the Resource
	 * @param id the designed id of new Resource
	 * 
	 * @return The new, managed Resource
	 */
	private Resource createManagedResource(String filename,String id,boolean register){
		
		Resource result = null;	
		// Create a URI for resource
		URI uri = null;
		if(filename==null){
			// Create Temporary Resource
			File tmpFile = null;
			try {
				tmpFile = File.createTempFile(TEMP_RESOURCE_PREFIX, NATIVE_MODEL_SUFFIX);
			} catch (IOException e) {
				throw new SiDiffRuntimeException(this,"Cannot assign File for temporary resource");
			}	
			uri= URI.createFileURI(tmpFile.getAbsolutePath());
		} else {
			uri = URI.createFileURI(new File(filename).getAbsolutePath());
		}
		
		// Get a resource key
		String key = (id == null) ? uri.toString()+ URI_ID_SEPERATOR+(++internalModelID) : id;
		
		// Create empty resource and add them to managed models
		if(!models.containsKey(key)||!register){
			result = globalResourceSet.createResource(uri);
			if(register){
				models.put(key, result);
			}
		} else {
			LogUtil.log(LogEvent.ERROR, "Cannot register Resource - Key already assigned!" + key);
		}
		
		return result;
	}

	public boolean serialize(String id, String filename){
		boolean result = false;
		
		if(!this.models.containsKey(id)){
			throw new IllegalArgumentException("No model registered for id '"+id+"'");
		}
			
		Resource resource = null;
		Resource originalResource = this.models.get(id);
		// Optional local vars
		Map<Resource,URI> mappedResources = null;
		
		if(filename==null){
			// Store Model 
			resource = originalResource;
		} else {
			// Create a copy and serialize
			resource = createManagedResource(filename, id, false);
			resource.getContents().addAll(originalResource.getContents());
		}
		
		if(SAVE_OPTIONS.get(XMIResource.OPTION_SCHEMA_LOCATION)==Boolean.TRUE){
			mappedResources = new HashMap<Resource, URI>();
			// Get all different packages occuring in this resource 
			Collection<?> ePackages = EPackage.Registry.INSTANCE.values();
			for(Object p : ePackages){
				if(p instanceof EPackage){
					EPackage ePackage = (EPackage)p;
					Resource eResource = ePackage.eResource();
					URI uri = URI.createURI(ePackage.getNsURI());
					if(URIConverter.URI_MAP.containsKey(uri)){
						if(!mappedResources.containsKey(eResource)){
							mappedResources.put(eResource, eResource.getURI());
						} else if(!eResource.getURI().equals(URIConverter.INSTANCE.normalize(uri))){
							throw new SiDiffRuntimeException("Ambiguous Resource URI Mapping!",
									"\n Package:",ePackage.getNsURI(),
									"\n Orginal Resource Namespace:",mappedResources.get(eResource),
									"\n Current Resource Namespace:",eResource.getURI(),
									"\n Wanted Mapping",URIConverter.INSTANCE.normalize(uri));
						}
						eResource.setURI(URIConverter.INSTANCE.normalize(uri));    
					}
				}
			}
		}
		
		try {				
			resource.save(SAVE_OPTIONS);
			result=true;
			
		} catch (Exception e) {
			LogUtil.log(LogEvent.WARNING, "Error while writing Model '" + filename + " > " + resource.getURI().toFileString()+"' ", e);
		} finally {
			if (resource!=originalResource) {
				originalResource.getContents().addAll(resource.getContents());
			}
		}
		
		// Cleanup
		if(mappedResources!=null){
			for(Resource eResource : mappedResources.keySet()){
				eResource.setURI(mappedResources.get(eResource));
			}
		}
		return result;
	}
	
	/**
	 * This method tries to import the model into the model storage by searching for a suitable loader.
	 * @param fileName name of the model file as {@link String}
	 * @return identification key of the model as {@link String} or {@link <code>null</code>}
	 */
	public String importEMF(String fileName){
		assert(fileName!=null&&!fileName.equals("")):"Invalid Filename!";
		
		Resource result = importEMF(fileName,null);
		return (result!=null)? result.getURI().toString()+URI_ID_SEPERATOR+internalModelID : null;
	}
	
	/**
	 * This method tries to import the model with an user definable <code><b>id</b></code> into the model storage by searching for a suitable loader.
	 * @param fileName name of the model file as {@link String}
	 * @param id {@link String} containing an user definable identifier (e.g.: modelA, modelB, ...)
	 * @return {@link Resource} or {@link <code>null</code>}
	 */
	public Resource importEMF(String fileName,String id){
		assert(fileName!=null&&!fileName.equals("")):"Invalid Filename!";
		
		File internalModel = new File(fileName+NATIVE_MODEL_SUFFIX);

		if(internalModel.exists() && !ALWAYS_FORCE_TRANSFORMATION){
			LogUtil.log(LogEvent.NOTICE, "Using precompiled Model -> '",fileName+NATIVE_MODEL_SUFFIX,"' to load '"+fileName,"'");
			return loadEMF(internalModel.getAbsolutePath(),id);
		} else {
			return importEMF(fileName, id, getUsableLoader(fileName));
		}
	
	}
	
	/**
	 * This method tries to import the model into the model storage with the given loader. 
	 * @param fileName name of the model file as {@link String}
	 * @param loaderclass name of the class file containing an appropriate loader
	 * @return identification key of the model as {@link String} or {@link <code>null</code>}
	 */
	public String importEMFWith(String fileName,Class<? extends Loader> loaderclass){
		assert(fileName!=null&&!fileName.equals("")):"Invalid Filename!";
		
		Resource result = importEMF(fileName,null,this.loadersByClass.get(loaderclass));
		return (result!=null)? result.getURI().toString()+URI_ID_SEPERATOR+internalModelID : null;
	}
	/**
	 * This method tries to import the model under an user definable <code><b>id</b></code> into the model storage with the given loader.  
	 * @param fileName name of the model file as {@link String}
	 * @param id {@link String} containing an user definable identifier (e.g.: modelA, modelB, ...)
	 * @param loaderclass name of the class file containing an appropriate loader 
	 * @return {@link Resource} or {@link <code>null</code>}
	 */
	public Resource importEMFWith(String fileName,String id,Class<? extends Loader> loaderclass){
		assert(fileName!=null&&!fileName.equals("")):"Invalid Filename!";
		
		return importEMF(fileName,id,this.loadersByClass.get(loaderclass));
	}
	
	/**
	 * This method returns a loaded model from the model storage using <code><b>key</b></code> as identifier.
	 * @param key the identifier as {@link String}
	 * @return {@link Resource}
	 */
	public Resource getModel(String key){
	
		if(this.models.containsKey(key)){
			return this.models.get(key);
		} else {
			throw new IllegalArgumentException("No model found -> Invalid Handle:"+key);
		}
	}
	
	/**
	 * This method removes a loaded model from the model storage using <code><b>key</b></code> as identifier.
	 * @param key the identifier as {@link String}
	 */
	public void releaseModel(String key){
		Resource r = this.models.get(key);
		if(r != null){
			r.unload();
			globalResourceSet.getResources().remove(r);
			this.models.remove(key);
		} else {
			throw new IllegalArgumentException("No model found -> Invalid Handle:"+key);
		}
	}
	
	/**
	 * This method checks if an appropriate loader is registered.
	 * @param fileName name of the model file as {@link String}
	 * @return {@link <code><b>true</b></code>} if a loader for the file exists, else {@link <code><b>false</b></code>}.
	 */
	public boolean canHandle(String fileName){
	
		return getUsableLoader(fileName)!=null;
	}
	
	
	
	public Set<String> getSupportedSuffixes(){
		
		Set<String> result = new HashSet<String>();
		result.addAll(this.loadersByExtension.keySet());
		result.addAll(this.nativeSuffixes);
		
		return result;
	}

	/**
	 * Internal Method to perform import operation. 
	 * The imported Model becomes {filename}.smf.xmi as URI.
	 * 
	 * @param fileName filename of the foreign Model.
	 * @param id designed id of the imported Model.
	 * @param loader the loader that should be used.
	 * @return the new Model containing Resource.
	 */
	private Resource importEMF(String fileName,String id,Loader loader){
	
		Resource result = null;
		
		boolean ignoreSuffix = System.getProperty(IGNORE_SUFFIX_PROPERTY)!=null && System.getProperty(IGNORE_SUFFIX_PROPERTY).equalsIgnoreCase(Boolean.TRUE.toString());
		
		if(fileName!=null){
			if (loader != null){
				if (ignoreSuffix || fileName.endsWith(loader.getSuffix())){
					InputStream istream = IOUtil.getInputStreamFromFile(fileName);
					if (istream != null) {
						result = createManagedResource(fileName + NATIVE_MODEL_SUFFIX, id,true);
						try {
							LogUtil.log(LogEvent.NOTICE, "Importing ", fileName, " using ", loader.getLoaderDescription());
							loader.parse(result, istream);		
							
							// Also resolve all eProxyURIs inside the resource's ResourceSet.
							// This is not done automatically when loading a resource.
							// This was noticed when additional, external resources are referenced
							// or cross referenced (e.g. ProfileApplication references)
							EcoreUtil.resolveAll(result.getResourceSet());
														
							if(!serialize((id==null)? result.getURI()+URI_ID_SEPERATOR+internalModelID : id, null)){
								LogUtil.log(LogEvent.WARNING, "Error while writing Model '" + fileName + " > " + result.getURI().toFileString()+"'");
							}
						} catch (Exception e) {
							LogUtil.log(LogEvent.ERROR, "Error while importing Model '" + fileName + "'\n", e);
						}
					} else {
						LogUtil.log(LogEvent.ERROR, "No datastream (File not found:" + fileName);
					}
				} else {
					LogUtil.log(LogEvent.ERROR, "Invalid Input-Model Filename: '" + fileName + "' (Wrong extension, " + loader.getSuffix() + " Expected!)");
				}
			} else {
				// Try to load native instance...
				if(checkSuffix(fileName, this.nativeSuffixes)){
					result=loadEMF(fileName,id);
				} else {
					LogUtil.log(LogEvent.ERROR, "Missing loader for '"+fileName+"'");
				}
			}
		} else {
			LogUtil.log(LogEvent.ERROR, "Missing Input-Model Filename!");
		}
		return result;
	}

	private Loader getUsableLoader(String fileName){
		

		String suffix = (fileName.lastIndexOf(EXTENSION_SEPERATOR)>0)? fileName.substring(fileName.lastIndexOf(EXTENSION_SEPERATOR)+1) : fileName;
		String data = IOUtil.readFromStream(IOUtil.getInputStreamFromFile(fileName), LOADERCHECK_READ_AHEAD);
		data = data.replaceAll("\n", "").replace("\r", "");
		Loader usableLoader = null;
		Set<Loader> loaderSet = null;
		
		if(System.getProperty(IGNORE_SUFFIX_PROPERTY)!=null
		&& System.getProperty(IGNORE_SUFFIX_PROPERTY).equalsIgnoreCase(Boolean.TRUE.toString())){
			loaderSet = new HashSet<Loader>();
			for(Set<Loader> loaders : loadersByExtension.values()){
				loaderSet.addAll(loaders);
			}
		} else {
			loaderSet = loadersByExtension.get(suffix);
		}
		
		if (loaderSet != null) {
			for (Loader loader : loaderSet) {
				usableLoader = loader;
				for (String magigKey : loader.getMagicKeys()) {
					if (data == null || !data.matches(magigKey)) {
						usableLoader = null;
						break;
					}
				}
				if (usableLoader != null) {
					break;
				}
			}
		}
		if(usableLoader==null){
			assert(LogUtil.log(LogEvent.DEBUG, "No usable loader found for '"+fileName+"'"));
		}
		
		return usableLoader;
	}

	private boolean checkSuffix(String fileOrResourceName, Collection<String> suffixes){
		for(String suffix : suffixes){
			if(fileOrResourceName.endsWith(suffix)){
				return true;
			}
		}
		return false;
	}
	
	public void dump(){
		System.out.println("*****************************************");
		System.out.println(models.keySet());
		for (Resource r : globalResourceSet.getResources()) {
			System.out.println(r);
		}
		System.out.println("*****************************************");
	}
	
}
