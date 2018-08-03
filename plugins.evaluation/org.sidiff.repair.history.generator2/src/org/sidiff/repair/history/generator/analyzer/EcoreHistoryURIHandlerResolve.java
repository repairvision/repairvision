package org.sidiff.repair.history.generator.analyzer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;

public class EcoreHistoryURIHandlerResolve extends URIHandlerImpl {

	private Map<String, List<HistoryMetadata>> modelFiles;

	private Map<String, HistoryMetadata> uriMapping = new HashMap<>();
	
	private Set<String> missingURIs = new HashSet<>();

	public EcoreHistoryURIHandlerResolve(Map<String, List<HistoryMetadata>> modelFiles) {
		this.modelFiles = modelFiles;
	}

	@Override
	public URI resolve(URI uri) {

		// Already resolved?:
		if (uriMapping.containsKey(uri.trimFragment().toString())) {
			return uri;
		}
		
		// Filter local URIs:
		if (uri.toString().startsWith("#")) {
			return uri;
		}
		
		// Search model:
		String modelName = uri.lastSegment();
		
		// Try to resolve package URIs:
		if ((modelName != null) && !modelName.endsWith(".ecore")) {
			modelName += ".ecore";
		}

		// Find model in other repository:
		if (modelFiles.containsKey(modelName)) {
			HistoryMetadata coevolvingHistory = null;
			String largestCommonSubstring = "";

			for (HistoryMetadata history : modelFiles.get(modelName)) {
				for (String remoteFilePath : history.getAllRemoteFilePath()) {
					String searchedModel = uri.trimFragment().toString();
					
					StringBuffer commonSubString = new StringBuffer();
					int offset = searchedModel.length() - remoteFilePath.length();
					
					for (int i = searchedModel.length() - 1; (i - offset) >= 0; --i) {
						if (searchedModel.charAt(i) == remoteFilePath.charAt(i - offset)) {
							commonSubString.append(searchedModel.charAt(i));
						} else {
							break;
						}
					}
					
					if (commonSubString.length() > largestCommonSubstring.length()) {
						largestCommonSubstring = commonSubString.toString();
						coevolvingHistory = history;
					}
				}
			}
			
			if (coevolvingHistory != null) {
				uriMapping.put(uri.trimFragment().toString(), coevolvingHistory);
			}
		} else {
//			System.err.println(uri);
			missingURIs.add(uri.toString());
		}

		return uri;
	}
	
	public Set<String> getMissingURIs() {
		return missingURIs;
	}

	public Set<HistoryMetadata> getCoevolvingHistories() {
		return new HashSet<>(uriMapping.values());
	}
	
	public Map<String, HistoryMetadata> getURIMapping() {
		return uriMapping;
	}
	
	public void setURIMapping(Map<String, HistoryMetadata> uriMapping) {
		this.uriMapping = uriMapping;
	}
}
