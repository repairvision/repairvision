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
		URI deresolvedURI = uri.deresolve(baseURI, true, true, false);

		// Local URI?
		if (deresolvedURI.toString().startsWith("#")) {
			return deresolvedURI;
		}
		
		// Lookup URI in mapping:
		if (uriMapping.containsKey(uri.trimFragment().toString())) {
			VersionMetadata selectedVersion = selectedVersions.get(uriMapping.get(uri.trimFragment().toString()));
			deresolvedURI = URI.createURI(selectedVersion.getFileName());
			
			if (uri.fragment() != null) {
				deresolvedURI = deresolvedURI.appendFragment(uri.fragment());
			}
			
			return deresolvedURI;
		}

		return super.deresolve(uri);
	}
	
	public Map<HistoryMetadata, VersionMetadata> getSelectedVersions() {
		return selectedVersions;
	}
	
	public void setSelectedVersions(Map<HistoryMetadata, VersionMetadata> selectedVersions) {
		this.selectedVersions = selectedVersions;
	}
}
