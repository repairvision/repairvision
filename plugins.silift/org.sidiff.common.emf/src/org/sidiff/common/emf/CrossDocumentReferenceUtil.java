package org.sidiff.common.emf;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentsEList.FeatureIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.sidiff.common.emf.exceptions.CrossDocumentReferenceUnresolvableException;

/**
 * This class provides loading methods for resources which contain cross document references
 * (dependencies to other external resources) in the platform:/resource URI schemes.
 * 
 * @author mrindt
 *
 */
public class CrossDocumentReferenceUtil {

	
	/**
	 * This method can load a resource which has direct or indirect
	 * cross document references to other resources.
	 * It maps unresolvable resources to given file:/-URIs by file names.
	 *
	 * @param fileSchemaURI
	 * 		  The file:/-Schema URI of the resource to load
	 * @param crossReferencedFileURIs
	 * 		  The known file:/-Schema URIs to the cross referenced documents.
	 * @return
	 * 		  The result ResouceSet with loaded and resolved documents
	 * @throws CrossDocumentReferenceUnresolvableException
	 */
	public static ResourceSet loadResourceWithCrossDocumentReferences(
			URI fileSchemaURI,
			Set<URI> crossReferencedFileURIs) throws CrossDocumentReferenceUnresolvableException {

		// Register arbitrary file extensions in the resource factory
		// to be able to load any Resource
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());

		// Obtain a new resource set, its URIConverter and URIMap
		ResourceSet resSet = new ResourceSetImpl();
		URIConverter uriConverter = resSet.getURIConverter();
		Map<URI,URI> uriMap = uriConverter.getURIMap();

		// Create the resource (to find out all eProxyURIs)
		Resource resource = resSet.getResource(fileSchemaURI, true);

		// In case there are still unresolvable eObjects..
		if(!findEProxyModelURIs(resource).isEmpty()) {
			boolean inDepthEProxySearchFinished = false;
			while(inDepthEProxySearchFinished==false) {

				Set<URI> eProxyURIs = findEProxyModelURIs(resource);
				for(URI proxyURI: eProxyURIs) {
					boolean resolvable = false;
					
					// ..take last segment of proxyURI to identify necessary absolute
					// cross-document ref file:/ URI and map it onto it
					String representativeSegmentsOfEProxyURI = proxyURI.lastSegment();
					for(URI crossReferencedFileURI: crossReferencedFileURIs) {
						if(crossReferencedFileURI.path().toString().endsWith(representativeSegmentsOfEProxyURI)) {
							uriMap.put(proxyURI,crossReferencedFileURI);
							resolvable = true;
							break;
						}
					}
					if(resolvable==false) {
						throw new CrossDocumentReferenceUnresolvableException(proxyURI, uriMap);
					}
				}

				// Previously recognized resources must be cleared and unloaded in order to
				// load them again now with necessary URI mappings
				// (resolveAll does not overwrite existing, out dated references)
				resSet.getResources().clear();
				resource.unload();
				resource = resSet.getResource(fileSchemaURI, true);

				// manually demand resolution of all proxyURIs mapped so far
				EcoreUtil.resolveAll(resSet);

				// check if the remaining eProxy URIs are the same as the ones which should
				// have been resolvable according to previous steps in this method but
				// actually can't be resolved due to different issues:
				Set<URI> remainingUnresolvableEProxies = findEProxyModelURIs(resource);
				if(eProxyURIs.equals(remainingUnresolvableEProxies)) {
					throw new CrossDocumentReferenceUnresolvableException(remainingUnresolvableEProxies, uriMap);
				}

				// check if after the recent resolution there are still old or new eProxies left
				// (inside encapsulated resources of the main resource)
				if(remainingUnresolvableEProxies.isEmpty()) {
					inDepthEProxySearchFinished = true;			
				}	
			}

		}
		
		return resSet;

	}
	
	/**
	 * This method finds EProxy URIs inside a resource. In case an EProxyURI
	 * to an EObject turns out to be resolvable along the way
	 * the resolvable EObject will replace the unresolvable EObject in the resource.
	 * 
	 * <br/><b>Note:</b>
	 * In case of a deeper containment hierarchy of multiple, recursively nested resources you need
	 * to make sure that the containing resources are resolved top down in order to find
	 * remaining eProxyURIs with this method.
	 * 
	 * @param resource
	 * @return set of eProxyURIs
	 */
	public static Set<URI> findEProxyModelURIs(Resource resource) {
		
		Set<URI> eProxies = new HashSet<URI>();

		// iterate over all resources and encapsulated resources inside the ResourceSet
		// in order to find any proxy URIs
		TreeIterator<Object> oIt = EcoreUtil.getAllContents(resource.getResourceSet(), true);
		while(oIt.hasNext()) {

			// in case tree object is a resource
			Object object = oIt.next();			
			if(object instanceof Resource) {
				Resource res = (Resource) object;

				for(EObject eObject: EMFUtil.getAllContentAsIterable(res)) {

					// try to resolve and replace EObjects or keep the proxyURI for further investigation
					FeatureIterator featureIt = (FeatureIterator) eObject.eCrossReferences().iterator();
					while(featureIt.hasNext()) {
						EObject targetedEObject = (EObject) featureIt.next();

						if(targetedEObject.eIsProxy()) {
							//try again to resolve it
							EObject problemEObject = EcoreUtil.resolve(targetedEObject, res.getResourceSet());							
							//if still not working, add it to the list for further investigation
							if(problemEObject.eIsProxy()) {
								eProxies.add(((InternalEObject) targetedEObject).eProxyURI().trimFragment());
							}
							//if resolvable: replace eObject with the resolvable one
							else {
								EStructuralFeature feature = featureIt.feature();
								EcoreUtil.replace(eObject, feature, targetedEObject, problemEObject);
							}
						}		
					}					
				}
			}
			// in case tree object is an EObject
			else if(object instanceof EObject) {
				EObject eObject = (EObject) object;

				// try to resolve and replace EObjects or keep the proxyURI for further investigation
				FeatureIterator featureIt = (FeatureIterator) eObject.eCrossReferences().iterator();
				while(featureIt.hasNext()) {
					EObject targetedEObject = (EObject) featureIt.next();

					if(targetedEObject.eIsProxy()) {
						//try again to resolve it
						EObject problemEObject = EcoreUtil.resolve(targetedEObject, eObject.eResource().getResourceSet());							
						//if still not working, add it to the list for further investigation
						if(problemEObject.eIsProxy()) {
							eProxies.add(((InternalEObject) targetedEObject).eProxyURI().trimFragment());
						}
						//if resolvable: replace eObject with the resolvable one
						else {
							EStructuralFeature feature = featureIt.feature();
							EcoreUtil.replace(eObject, feature, targetedEObject, problemEObject);
						}
					}		
				}	
			}		
		}

		return eProxies;
		
	}
	
	/**
	 * This method loads a resource which contains so called <b>cross document references</b>
	 * to other imported resources which are referenced by <b>platform:/resource/ </b>
	 * or <b>platform:/plugin</b> URIs.<br/>
	 * Usually, imported resources are referenced by relative URI paths
	 * (e.i, without leading plugin/platform/file schema prefix).
	 * However, in some cases one has platform:/resource instead which will result in
	 * unresolvable eProxyURIs when the main resource is loaded. In such cases this method can help.
	 * Just make sure you initialize your meta model package beforehand with
	 * <br/>MyMetaModelPackage.eINSTANCE.eClass();
	 * 
	 * <br/>Note: This method will take in <b>absolute file:/ paths to the referenced resources</b>.
	 * <br/>Note: This method will <b>assume that the imported resource files lie in the same folder</b>
	 * as the main resource. If you have differing folders then use a different method, see below
	 *  
	 * @param platformResourceOrPluginURI
	 * 				the platform:/resource or plattform:/plugin URI of the resource to load
	 * @param fileSchemaURI
	 * 				the absolute file:/ URI of the resource to load
	 * @return the resourceSet with the loaded main resource and it's referenced
	 * 		   resources
	 * @throws CrossDocumentReferenceUnresolvableException 
	 * @see #loadResourceWithCrossDocumentReferences(ResourceSet, URI, URI, EPackage, Set)
	 * @deprecated use {@link #loadResourceWithCrossDocumentReferences(URI, Set)} instead
	 */
	@Deprecated
	public static ResourceSet loadResourceWithCrossDocumentReferences(
			URI platformResourceOrPluginURI,
			URI fileSchemaURI) throws CrossDocumentReferenceUnresolvableException {
				
		// Register arbitrary file extensions in the resource factory.
		// Extensions could also be defined separately (e.g.:
		// asymmetric, symmetric, ecore, uml) It is however necessary
		// for later resolution that one defines them all .
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());

		// Obtain a new resource set, its URIConverter and URIMap
		ResourceSet resSet = new ResourceSetImpl();
		URIConverter uriConverter = resSet.getURIConverter();
		Map<URI,URI> uriMap = uriConverter.getURIMap();

		// Map platform resource/plugin URIs to absolute file:/-URIs
		// Firstly, the main resource:
		uriMap.put(platformResourceOrPluginURI, fileSchemaURI);
		
		// Create the resource (to find out all eProxyURIs)
		Resource resource = resSet.getResource(platformResourceOrPluginURI, true);
		
		// In case there are still unresolvable eObjects, start in depth search to
		// find all platform resource/plugin URIs referenced inside the
		// resource and map them onto the respective file:/ URIs
		// Here: all resources are assumed to lie in the same folder.
		String fileDirectoryPath = fileSchemaURI.trimSegments(1).toString() + System.getProperty("file.separator");

		if(!findEProxyModelURIs(resource).isEmpty()) {
			
			boolean inDepthEProxySearchFinished = false;
			while(inDepthEProxySearchFinished==false) {
	
				Set<URI> eProxieURIs = findEProxyModelURIs(resource);
				for(URI proxyURI : eProxieURIs) {
					boolean resolvable = false;
					if(proxyURI.isPlatformResource() || proxyURI.isPlatformPlugin()) {		
						String fileName = proxyURI.trimFragment().lastSegment();								
						String filePath = fileDirectoryPath + fileName;
						File f = new File(filePath.replace("file:/", ""));
						if(f.exists()) {
							uriMap.put(proxyURI,URI.createURI(filePath));
							resolvable = true;
						}
					}
	
					if(resolvable==false) {
						throw new CrossDocumentReferenceUnresolvableException(proxyURI, uriMap);
					}
					
				}
	
				// Previously recognized resources must be cleared and unloaded in order to
				// load them again now with necessary URI mappings
				// (resolveAll does not overwrite existing, out dated references)
				resSet.getResources().clear();
				resource.unload();
				resource = resSet.getResource(platformResourceOrPluginURI, true);
	
				// manually demand resolution of all proxyURIs mapped so far
				EcoreUtil.resolveAll(resSet);	
				
				// check if the remaining eProxy URIs are the same as the ones which should
				// have been resolvable according to previous steps in this method but
				// actually can't be resolved due to different issues:
				Set<URI> remainingUnresolvableEProxies = findEProxyModelURIs(resource);
				if(eProxieURIs.equals(remainingUnresolvableEProxies)) {
					throw new CrossDocumentReferenceUnresolvableException(remainingUnresolvableEProxies, uriMap);
				}
				
				// check if after the recent resolution there are still old or new eProxies left
				// (inside encapsulated resources of the main resource)
				if(remainingUnresolvableEProxies.isEmpty()) {
					inDepthEProxySearchFinished = true;			
				}
				
			}
		}
		
		return resSet;

	}
	
}
