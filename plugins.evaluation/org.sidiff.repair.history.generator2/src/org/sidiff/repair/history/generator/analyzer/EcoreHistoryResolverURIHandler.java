package org.sidiff.repair.history.generator.analyzer;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.sidiff.repair.history.generator.metadata.VersionMetadata;

public class EcoreHistoryResolverURIHandler extends URIHandlerImpl {

	private  ResourceSetImpl resourceSet;

	private Set<String> modelNames;

	private Map<String, List<VersionMetadata>> modelFiles;

	private Map<String, URI> uriMapping = new HashMap<>();

	private Set<String> missingURIs = new HashSet<>();

	public EcoreHistoryResolverURIHandler(ResourceSetImpl resourceSet, List<File> models, Map<String, List<VersionMetadata>> modelFiles) {
		this.resourceSet = resourceSet;
		this.modelFiles = modelFiles;
		this.modelNames = models.stream().map(File::getName).collect(Collectors.toSet()); 
	}

	@Override
	public URI resolve(URI uri) {
		URI newURI = uri;
		
		// Make URIs to related models relative:
		String modelName = uri.lastSegment();

		if (modelNames.contains(modelName)) {
			// model in repository:
			newURI = URI.createURI(modelName).appendFragment(uri.fragment());
		} else {
			// models in other repositories:
			newURI = findModel(uri);
		}

		return newURI;
	}

	private URI findModel(URI uri) {
		
		// Lookup URI in mapping:
		if (uriMapping.containsKey(uri.toString())) {
			return uriMapping.get(uri.toString());
		}
		
		// Filter local URIs:
		if (uri.toString().startsWith("#")) {
			missingURIs.add(uri.toString());
			return uri;
		}
		
		// Search model:
		String modelName = uri.lastSegment();
		URI newURI = uri;
		
		// Try to resolve package URIs:
		if ((modelName != null) && !modelName.endsWith(".ecore")) {
			modelName += ".ecore";
		}

		// Find model in other repository:
		if (modelFiles.containsKey(modelName)) {
			VersionMetadata relatedVersion = null;
			String largestCommonSubstring = "";

			for (VersionMetadata version : modelFiles.get(modelName)) {
				String searchedModel = uri.trimFragment().toString();
				String otherModel = version.getRemoteFilePath();
				StringBuffer commonSubString = new StringBuffer();
				int offset = searchedModel.length() - otherModel.length();

				for (int i = searchedModel.length() - 1; (i - offset) >= 0; --i) {
					if (searchedModel.charAt(i) == otherModel.charAt(i - offset)) {
						commonSubString.append(searchedModel.charAt(i));
					} else {
						break;
					}
				}

				if (commonSubString.length() > largestCommonSubstring.length()) {
					largestCommonSubstring = commonSubString.toString();
					relatedVersion = version;
				}
			}

			newURI = URI.createFileURI(new File(relatedVersion.getHistory().getDatafile().getParent() + "/" + relatedVersion.getLocalFilePath()).getAbsolutePath());
			newURI = newURI.appendFragment(uri.fragment());
		}

		// Check if model element can be found:
		if (!tryResolve(newURI, true)) {
//			System.err.println(uri);
			missingURIs.add(uri.toString());
			
//			((EPackage) (new ResourceSetImpl().getResource(URI.createURI("file:/C:/evaluation/modeling.emf.emf/2010-04-28T16-45-53Z_74d4cb3acf33078441ffb9b099917fd5e57b3ca9/XMLType.ecore#//String"), true)).getContents().get(0)).getEClassifier("String");
//			Object t = ((EPackage) resourceSet.getResources().get(1).getContents().get(0)).getEClassifiers();
			
			newURI = uri;
		} else {
			uriMapping.put(uri.toString(), newURI);
		}

		return uri;
	}

	private boolean tryResolve(URI modelURI, boolean loadOnDemand) {
		try {
//			EObject obj = resourceSet.getEObject(modelURI, loadOnDemand);
			EObject obj = new ResourceSetImpl().getEObject(modelURI, loadOnDemand);

			if ((obj != null) && !obj.eIsProxy()) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public URI deresolve(URI uri) {

		// Lookup URI in mapping:
		if (uriMapping.containsKey(uri.toString())) {
			URI mapped = uriMapping.get(uri.toString());
			return URI.createURI(mapped.lastSegment()).appendFragment(mapped.fragment());
		}

		return super.resolve(uri);
	}
	
	public Map<String, URI> getUriMapping() {
		return uriMapping;
	}
	
	public Set<String> getMissingURIs() {
		return missingURIs;
	}
}
