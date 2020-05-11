package org.sidiff.revision.repair.history.retrieval.ecore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.sidiff.revision.repair.history.retrieval.metadata.HistoryMetadata;
import org.sidiff.revision.repair.history.retrieval.metadata.VersionMetadata;

public class EcoreHistoryURIHandlerResolve extends URIHandlerImpl {
	
	private VersionMetadata baseVersion;

	private Map<String, List<HistoryMetadata>> modelFiles;

	private Map<String, HistoryMetadata> uriMapping = new HashMap<>();
	
	private Set<String> missingURIs = new HashSet<>();

	public EcoreHistoryURIHandlerResolve(VersionMetadata baseVersion, Map<String, List<HistoryMetadata>> modelFiles) {
		this.baseVersion = baseVersion;
		this.modelFiles = modelFiles;
	}

	@Override
	public URI resolve(URI uri) {

//		if (uri.toString().contains("http://www.eclipse.org/emf/2002/Ecore#//EBoolean")) {
//			System.out.println(uri);
//		}
		
		// Already resolved?:
		if (uriMapping.containsKey(uri.trimFragment().toString())) {
			return uri;
		}
		
		// Filter local URIs:
		if (uri.toString().startsWith("#")) {
			return uri;
		}
		
		// Search model:
		String modelPath = uri.trimFragment().toString();
		String modelName = uri.lastSegment();
		
		// Try to resolve package URIs:
		if (!modelFiles.containsKey(modelPath)) {
			if ((modelName != null) && !modelName.endsWith(".ecore")) {
				modelName += ".ecore";
				modelPath += ".ecore";
			}
		}

		// Find model in other repository:
		List<HistoryMetadata> matchingHistories = 
				  modelFiles.containsKey(modelPath) ? modelFiles.get(modelPath) 
				: modelFiles.containsKey(modelName) ? modelFiles.get(modelName) 
				: Collections.emptyList();
		
		if (!matchingHistories.isEmpty()) {
			List<HistoryMetadata> potentialCoevolvingHistories = new ArrayList<>();
			String largestCommonPostfix = "";

			for (HistoryMetadata history : matchingHistories) {
				for (String remoteFilePath : history.getAllRemoteFilePath()) {
					StringBuilder searchedModel = new StringBuilder(modelPath).reverse();
					StringBuilder model = new StringBuilder(remoteFilePath).reverse();
					
					StringBuffer commonSubString = new StringBuffer();

					for (int i = 0; i < Math.min(searchedModel.length(), model.length()); ++i) {
						if (searchedModel.charAt(i) == model.charAt(i)) {
							commonSubString.append(searchedModel.charAt(i));
						} else {
							break;
						}
					}
					
					if (commonSubString.length() >= largestCommonPostfix.length()) {
						if (commonSubString.length() > largestCommonPostfix.length()) {
							largestCommonPostfix = commonSubString.reverse().toString();
							potentialCoevolvingHistories.clear();
						}
						potentialCoevolvingHistories.add(history);
					}
				}
			}
			
			if (!potentialCoevolvingHistories.isEmpty()) {
				HistoryMetadata coevolvingHistory = potentialCoevolvingHistories.get(0);
				
				// If model URI is not unique, prefer a models from the same repository:
				if (potentialCoevolvingHistories.size() > 0) {
					String baseRepository = baseVersion.getHistory().getRepositoryURL();
					
					for (HistoryMetadata historyMetadata : potentialCoevolvingHistories) {
						if (historyMetadata.getRepositoryURL().equals(baseRepository)) {
							coevolvingHistory = historyMetadata;
						}
					}
				}
				
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
