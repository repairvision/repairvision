package org.sidiff.repair.history.generator.repository;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;

/**
 * Fixes and resolves URI-References in models.
 * 
 * @author Manuel Ohrndorf
 */
public class RepairURIHandler extends URIHandlerImpl {
	
	private ResourceSet resourceSet;
	
	private Map<String, String> uriMap = new HashMap<>();
	
	private IHistoryRepository repository;
	
	private URI versionFolder;
	
	public RepairURIHandler(ResourceSet resourceSet, URI versionFolder, IHistoryRepository repository) {
		super();
		this.resourceSet = resourceSet;
		this.versionFolder = versionFolder;
		this.repository = repository;
	}
	
	public void clear() {
		uriMap.clear();
	}

	@Override
	public URI resolve(URI uri) {
		
		// Map URI:
		for (String uriPrefix : uriMap.keySet()) {
			String uriString = uri.toString();
			
			if (uriString.startsWith(uriPrefix)) {
				uriString = uriString.replaceFirst(uriPrefix, uriMap.get(uriPrefix));
				uri = URI.createURI(uriString);
				break;
			}
		}
		
		// Fix:
		// ../../../../../../../org.eclipse.emf.ecore/model/Ecore.ecore#//EString
		// platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore#//EString
		if (uri.toString().contains("Ecore.ecore")) {
			uri = URI.createURI("http://www.eclipse.org/emf/2002/Ecore#" + uri.fragment());
		}
		
		// Try default:
		try {
			URI defaultDeresolvedURI = super.resolve(uri);
			EObject obj = resourceSet.getEObject(defaultDeresolvedURI, true);
			
			if (obj != null) {
				return defaultDeresolvedURI;
			}
		} catch (Exception e) {
		}
		
		// Test URI:
		EObject obj = resourceSet.getEObject(uri, false);
		
		if ((obj == null) || (obj.eIsProxy())) {
			
			// Try relative URI:
			URI relative = URI.createURI(uri.fragment());
			obj = resourceSet.getEObject(relative, false);
			
			if (obj != null) {
				return relative;
			} else {
				// Search target model:
				URI resolvedURI = repository.resolveModel(getBaseURI(), uri);
				
				if (resolvedURI != null) {
					try {
						obj = resourceSet.getEObject(resolvedURI.appendFragment(uri.fragment()), true);
					} catch (Exception e) {
					}
					
					if (obj != null) {
						try {
							URI subModelCopy = versionFolder
									.appendSegment(ModelNamingUtil.getModelName(resolvedURI.lastSegment()))
									.appendSegment(repository.formatModelFileName(resolvedURI));
							obj.eResource().setURI(subModelCopy);
							obj.eResource().save(null);
							
							uriMap.put(uri.trimFragment().toString(), subModelCopy.toString());
							
							return resolve(uri);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					} 
				}
					
				// Remove: ../../
				String subModelElementURI = uri.toString();
				
				while (subModelElementURI.startsWith("../")) {
					subModelElementURI = subModelElementURI.substring(3, subModelElementURI.length());
				}
				
				// Remove: protocol
				subModelElementURI = subModelElementURI.replaceFirst("platform:/plugin/", "");
				subModelElementURI = subModelElementURI.replaceFirst("platform:/resource/", "");
				
				System.err.println("Unresolved URI: " + uri);
				uri = URI.createURI(subModelElementURI);
				System.err.println("  -> " + uri);
			}
		}
		
		return uri;
	}
}
