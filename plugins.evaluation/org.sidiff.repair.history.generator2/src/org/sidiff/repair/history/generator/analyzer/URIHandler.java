package org.sidiff.repair.history.generator.analyzer;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.sidiff.repair.history.generator.metadata.VersionMetadata;

public class URIHandler extends URIHandlerImpl {

	private  ResourceSetImpl resourceSet;

	private Set<String> modelNames;

	private Map<String, List<VersionMetadata>> modelFiles;

	private Set<String> relatedModelNames = new HashSet<>();

	private Set<String> missingURIs = new HashSet<>();

	public URIHandler(ResourceSetImpl resourceSet, List<File> models, Map<String, List<VersionMetadata>> modelFiles) {
		this.resourceSet = resourceSet;
		this.modelFiles = modelFiles;
		this.modelNames = models.stream().map(File::getName).collect(Collectors.toSet()); 
	}

	@Override
	public URI resolve(URI uri) {
		URI newURI = uri;

		if (uri.toString().contains("Ecore.ecore")) {

			// ../../../../../../../org.eclipse.emf.ecore/model/Ecore.ecore#//EString
			// platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore#//EString
			newURI = URI.createURI("http://www.eclipse.org/emf/2002/Ecore#" + uri.fragment());
		} else {

			// Make URIs to related models relative:
			String modelName = uri.lastSegment();

			if (modelNames.contains(modelName)) {
				newURI = URI.createURI(modelName).appendFragment(uri.fragment());
			} else {
				newURI = findModel(uri);
			}
		}

		return newURI;
	}

	private URI findModel(URI uri) {
		String modelName = uri.lastSegment();
		URI newURI = uri;

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

			newURI = URI.createFileURI(relatedVersion.getHistory().getDatafile().getParent() + "/" + relatedVersion.getLocalFilePath());
			newURI = newURI.appendFragment(uri.fragment());

			relatedModelNames.add(new File(relatedVersion.getLocalFilePath()).getName());
		}

		// Check if model element can be found:
		if (!tryResolve(newURI, true)) {
//			System.err.println(uri);
			missingURIs.add(uri.toString());
			newURI = uri;
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

	@Override
	public URI deresolve(URI uri) {

		if (modelNames.contains(uri.lastSegment()) || relatedModelNames.contains(uri.lastSegment())) {
			return URI.createURI(uri.lastSegment()).appendFragment(uri.fragment());
		}

		return super.resolve(uri);
	}
	
	public Set<String> getMissingURIs() {
		return missingURIs;
	}
}
