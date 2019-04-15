package org.sidiff.common.emf.access;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * 
 * @author cpietsch
 *
 */
public class EMFGenModelAccess {
	
	private static final Map<String, URI> NS_URI_MAP = EcorePlugin.getEPackageNsURIToGenModelLocationMap(false);
	
	public static GenModel getGenModelFromDocumentType(String documentType) {
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource genModelResource = resourceSet.getResource(NS_URI_MAP.get(documentType), true);
		if(genModelResource != null) {
			GenModel genModel = (GenModel) genModelResource.getContents().iterator().next();
			return genModel;
		}
		return null;
	}
	
	public static Set<String> getFileExtensionFromDocumentType(String documentType) {
		GenModel genModel = getGenModelFromDocumentType(documentType);
		if(genModel != null) {
			
			return genModel.getGenPackages().stream().filter(genPackage -> genPackage.getNSURI().equals(documentType))
					.flatMap(genPackage -> genPackage.getFileExtensionList().stream()).collect(Collectors.toSet());
		}
		return Collections.emptySet();
	}
}
