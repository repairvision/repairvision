package org.sidiff.repair.history.generator.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.sidiff.history.revision.uuid.UUIDResource;

/**
 * Fixes and resolves URI-References in models.
 * 
 * @author Manuel Ohrndorf
 */
public class RepairURIHandler extends URIHandlerImpl {
	
	private IHistoryRepository repository;
	
	private ResourceSet resourceSet;
	
	private Map<String, String> uriMap = new HashMap<>();
	
	private boolean needsReload = false;
	
	private Set<String> referencedModels = new HashSet<>();
	
	public RepairURIHandler(IHistoryRepository repository) {
		super();
		this.repository = repository;
		this.resourceSet = repository.getResourceSet();
	}
	
	public Resource loadModel(URI modelURI) {
		Resource resource = null;
		
		// -> references model versions changed...
		do {
			setNeedsReload(false);
			resource = new UUIDResource(modelURI, resourceSet);
		} while(isNeedsReload());
		
		modelLoaded();
		return resource;
	}
	
	public void modelLoaded() {
		referencedModels.addAll(uriMap.values());
		uriMap.clear();
		setNeedsReload(false);
	}
	
	public boolean isNeedsReload() {
		return needsReload;
	}
	
	public void setNeedsReload(boolean needsReload) {
		this.needsReload = needsReload;
	}
	
	public Set<String> getReferencedModels() {
		return referencedModels;
	}

	@Override
	public URI resolve(URI uri) {
		URI original = uri;
		
		// Fix:
		// ../../../../../../../org.eclipse.emf.ecore/model/Ecore.ecore#//EString
		// platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore#//EString
		if (uri.toString().contains("Ecore.ecore")) {
			return URI.createURI("http://www.eclipse.org/emf/2002/Ecore#" + uri.fragment());
		}
		
		// Map URI:
		if (!uriMap.isEmpty()) {
			String uriString = null;
			
			// Cut URI:
			if (uri.segmentCount() > 3) {
				uriString =
						uri.segment(uri.segmentCount() - 3) + "/" +
						uri.segment(uri.segmentCount() - 2) + "/"+
						uri.segment(uri.segmentCount() - 1);
			} else {
				uriString = uri.trimFragment().toString();
			}
			
			for (String resourceURI : uriMap.keySet()) {
				if (resourceURI.contains(uriString)) {
					uri = URI.createURI(uriMap.get(resourceURI)).appendFragment(uri.fragment());
					break;
				}
			}
		}
		
		// Try default:
		URI defaultDeresolvedURI = super.resolve(uri);
		
		if (tryResolve(defaultDeresolvedURI, true)) {
			return defaultDeresolvedURI;
		} else {
			// Make relative:
			if ((uri.lastSegment() != null) && getBaseURI().toString().endsWith(uri.lastSegment())) {
				return getBaseURI().appendFragment(uri.fragment());
			// NOTE: The model itself isn't loaded yet!
			// Try relative URI:
//			URI relative = getBaseURI().appendFragment(uri.fragment());
//			
//			if (tryResolve(relative, true)) {
//				return relative;
			} else {
				
				// Search target model:
				URI resolvedURI = repository.resolveModel(getBaseURI(), original);
				
				while (resolvedURI != null) {
					if (tryResolve(resolvedURI, true)) {
						String oldMapping = uriMap.put(
								original.trimFragment().toString(),
								resolvedURI.trimFragment().toString());
						
						// Overwrites mapping?
						if (oldMapping != null) {
							needsReload = true;
							System.out.println(" -> discarded: " + oldMapping);
						}
						
						return resolve(original); // just for testing the mapping...
					} else {
						// Check for other model version:
						resolvedURI = repository.getNextModelVersion(resolvedURI);
					}
				}
			}
					
			// Cleanup URI -> make relative: ../../
			String subModelElementURI = uri.toString();
			
			while (subModelElementURI.startsWith("../")) {
				subModelElementURI = subModelElementURI.substring(3, subModelElementURI.length());
			}
			
			// Remove: protocol
			subModelElementURI = subModelElementURI.replaceFirst("platform:/plugin/", "");
			subModelElementURI = subModelElementURI.replaceFirst("platform:/resource/", "");
			
			System.err.println("Unresolved URI: " + original);
			uri = URI.createURI(subModelElementURI);
			System.err.println("  -> " + uri);
		}
		
		return uri;
	}
	
	private boolean tryResolve(URI modelURI, boolean loadOnDemand) {
		try {
			EObject obj = resourceSet.getEObject(modelURI, loadOnDemand);
			
			if ((obj != null) && !obj.eIsProxy()) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
}
