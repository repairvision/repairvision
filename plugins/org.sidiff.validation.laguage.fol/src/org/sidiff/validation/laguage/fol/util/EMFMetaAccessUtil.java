package org.sidiff.validation.laguage.fol.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.core.plugin.PluginRegistry;

public class EMFMetaAccessUtil {
	
	public static final String GEN_MODEL_EXTENSION_POINT = "org.eclipse.emf.ecore.generated_package";
	
	public static final String GEN_MODEL_EXTENSION_POINT_ELEMENT_PACKAGE = "package";
	
	public static final String GEN_MODEL_EXTENSION_POINT_ATTRIBUTE_URI = "uri";
	
	public static final String GEN_MODEL_EXTENSION_POINT_ATTRIBUTE_CLASS = "class";
	
	public static final String GEN_MODEL_EXTENSION_POINT_ATTRIBUTE_GEN_MODEL = "genModel";

	public static class GenModelExtension {
		
		public String uri;
		public String packageClass;
		public URI genModelURI;
		
		private GenModel genModel; 
		
		public GenModelExtension(String uri, String packageClass, URI genModelURI) {
			this.uri = uri;
			this.packageClass = packageClass;
			this.genModelURI = genModelURI;
		}
		
		public GenModel getGenModel() {
			
			if (genModel == null) {
				Resource res = new ResourceSetImpl().getResource(genModelURI, true);
				
				if (!res.getContents().isEmpty() && (res.getContents().get(0) instanceof GenModel)) {
					this.genModel = (GenModel) res.getContents().get(0);
				}
			}
			
			return genModel;
		}
	}
	
	public static EPackage getEPackage(String nsURI) {
		return getEPackage(nsURI, null);
	}
	
	public static EPackage getEPackage(String nsURI, Map<String, EPackage> workspaceEPackages) {
	
		// Prefer development models in workspace over registered runtime models.
		if ((workspaceEPackages != null) && workspaceEPackages.containsKey(nsURI)) {
			return workspaceEPackages.get(nsURI);
		} else {
			return EPackage.Registry.INSTANCE.getEPackage(nsURI);
		}
	}
	
	public static String getEPackageClass(String nsURI, Map<String, GenModelExtension> workspaceGenModels) {

		// Prefer development models in workspace over registered runtime models.
		if (workspaceGenModels.containsKey(nsURI)) {
			return workspaceGenModels.get(nsURI).packageClass;
		} else {
			for (IConfigurationElement extension : Platform.getExtensionRegistry()
					.getConfigurationElementsFor(GEN_MODEL_EXTENSION_POINT)) {
				if (nsURI.equals(extension.getAttribute(GEN_MODEL_EXTENSION_POINT_ATTRIBUTE_URI))) {
					return extension.getAttribute(GEN_MODEL_EXTENSION_POINT_ATTRIBUTE_CLASS);
				}
			}
		}

		return null;
	}

	public static Set<String> getFileExtensionFromDocumentType(String documentType) {
		GenModel genModel = getGenModelFromDocumentType(documentType);

		if (genModel != null) {
			return genModel.getGenPackages().stream().filter(genPackage -> genPackage.getNSURI().equals(documentType))
					.flatMap(genPackage -> genPackage.getFileExtensionList().stream()).collect(Collectors.toSet());
		}
		
		return Collections.emptySet();
	}
	
	public static GenModel getGenModelFromDocumentType(String documentType) {
		Map<String, URI> genModelLocations = EcorePlugin.getEPackageNsURIToGenModelLocationMap(false);
		
		for (Entry<String, URI> genModelWorkspace : EcorePlugin.getEPackageNsURIToGenModelLocationMap(true).entrySet()) {
			if (!genModelLocations.containsKey(genModelWorkspace.getKey())) {
				genModelLocations.put(genModelWorkspace.getKey(), genModelWorkspace.getValue());
			}
		}
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource genModelResource = resourceSet.getResource(genModelLocations.get(documentType), true);
		
		if(genModelResource != null) {
			GenModel genModel = (GenModel) genModelResource.getContents().iterator().next();
			return genModel;
		}
		return null;
	}
	
	public static String getPluginSymbolicName(String nsURI, Map<String, GenModelExtension> workspaceGenModels) {
		
		// Prefer development models in workspace over registered runtime models.
		if (workspaceGenModels.containsKey(nsURI)) {
			assert workspaceGenModels.get(nsURI).getGenModel().eResource().getURI().isPlatformResource();
			return workspaceGenModels.get(nsURI).getGenModel().eResource().getURI().segment(1);
		} else {
			for (IConfigurationElement extension : Platform.getExtensionRegistry().getConfigurationElementsFor(GEN_MODEL_EXTENSION_POINT)) {
				if (nsURI.equals(extension.getAttribute(GEN_MODEL_EXTENSION_POINT_ATTRIBUTE_URI))) {
					return extension.getContributor().getName();
				}
			}
		}
		
		return null;
	}
	
	public static Map<String, EPackage> getWorkspaceEPackages() {
		Map<String, EPackage> nsURItoPackage = new HashMap<>();
		
		for (GenModelExtension genModel : getWorkspaceGenModels().values()) {
			for (GenPackage genPackage : genModel.getGenModel().getGenPackages()) {
				if (genPackage.getEcorePackage() != null) {
					EPackage ecorePackage = genPackage.getEcorePackage();
					nsURItoPackage.put(genPackage.getNSURI(), ecorePackage);
				}
			}
		}
		
		return nsURItoPackage;
	}
	
	public static Map<String, GenModelExtension> getWorkspaceGenModels() {
		Map<String, GenModelExtension> classToGenModel = new HashMap<>();
		
		IPluginModelBase[] workspacePlugins = PluginRegistry.getWorkspaceModels();

		for (IPluginModelBase workspacePlugin : workspacePlugins) {
			IPluginExtension[] extensions = workspacePlugin.getExtensions().getExtensions();

			for (IPluginExtension extension : extensions) {
				if (GEN_MODEL_EXTENSION_POINT.equals(extension.getPoint())) {
					IPluginObject[] children = extension.getChildren();

					for (IPluginObject child : children) {
						if (GEN_MODEL_EXTENSION_POINT_ELEMENT_PACKAGE.equals(child.getName())) {
							if (child instanceof IPluginElement) {
								String genModelClass = ((IPluginElement) child)
										.getAttribute(GEN_MODEL_EXTENSION_POINT_ATTRIBUTE_CLASS)
										.getValue();
								String genModelURI= ((IPluginElement) child)
										.getAttribute(GEN_MODEL_EXTENSION_POINT_ATTRIBUTE_URI)
										.getValue();

								if ((genModelClass != null) && (!genModelClass.isEmpty()) 
										&& (genModelURI != null) && (!genModelURI.isEmpty())) {
									
									String genModelPath = ((IPluginElement) child)
											.getAttribute(GEN_MODEL_EXTENSION_POINT_ATTRIBUTE_GEN_MODEL)
											.getValue();
									String plugin = workspacePlugin.getBundleDescription().getSymbolicName();
									URI genModelResourceURI = URI.createPlatformResourceURI(plugin + "/"  + genModelPath, true);
									classToGenModel.put(genModelURI, new GenModelExtension(genModelURI, genModelClass, genModelResourceURI));
								}
							}
						}
					}
				}
			}
		}
		
		return classToGenModel;
	}
}
