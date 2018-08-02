package org.sidiff.repair.history.generator.analyzer;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.metadata.VersionMetadata;

public class EcoreHistoryURIHandlerDeresolve extends URIHandlerImpl  {

	private Map<String, HistoryMetadata> uriMapping = new HashMap<>();
	
	private Map<HistoryMetadata, VersionMetadata> selectedVersions = new HashMap<>();

	public EcoreHistoryURIHandlerDeresolve(Map<String, HistoryMetadata> uriMapping) {
		super();
		this.uriMapping = uriMapping;
	}
	
	@Override
	public URI resolve(URI uri) {
		return uri;
	}
	
	@Override
	public URI deresolve(URI uri) {

		// Lookup URI in mapping:
		if (uriMapping.containsKey(uri.toString())) {
			VersionMetadata selectedVersion = selectedVersions.get(uriMapping.get(uri.toString()));
			return URI.createURI(selectedVersion.getFileName()).appendFragment(uri.fragment());
		}

		return super.resolve(uri);
	}
	
	public Map<HistoryMetadata, VersionMetadata> getSelectedVersions() {
		return selectedVersions;
	}
	
	public void setSelectedVersions(Map<HistoryMetadata, VersionMetadata> selectedVersions) {
		this.selectedVersions = selectedVersions;
	}
}
