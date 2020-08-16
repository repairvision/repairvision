package org.sidiff.generic.matcher.adapter.sidiff;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.extension.IExtension.Description;
import org.sidiff.revision.common.emf.document.DocumentType;
import org.sidiff.revision.difference.matcher.IConfigurableMatcherProvider;
import org.sidiff.revision.difference.matcher.IMatcher;
import org.sidiff.revision.difference.matcher.IMatcherProvider;

public class SiDiffMatcherProviderAdapter implements IMatcherProvider, IConfigurableMatcherProvider {

	private IConfigurationElement sidiffMatcherExtension;
	
	private String sidiffKey;
	
	private String key;
	
	private String sidiffName;
	
	private String name;
	
	private Set<String> sidiffDocumentTypes;
	
	private Set<String> documentTypes;
	
	private Map<String, Object> configuration;
	
	public SiDiffMatcherProviderAdapter(IConfigurationElement matcherExtension) {
		this.sidiffMatcherExtension = matcherExtension;
		
		org.sidiff.matcher.IMatcher sidiffMatcher = createSiDiffMatcher();
		
		this.sidiffKey = sidiffMatcher.getKey();
		this.key = "SiDiff_" + sidiffKey;
		this.sidiffName = sidiffMatcher.getName();
		this.name = "[SiDiff] " + sidiffName;
		this.sidiffDocumentTypes = sidiffMatcher.getDocumentTypes();
		this.documentTypes = new HashSet<>(sidiffDocumentTypes);
		
		if (sidiffMatcher.getConfiguration() != null) {
			this.configuration = sidiffMatcher.getConfiguration().getOptions();
		}
		
		if (documentTypes.remove(EMFModelAccess.GENERIC_DOCUMENT_TYPE)) {
			documentTypes.add(DocumentType.GENERIC_DOCUMENT_TYPE);
		}
		
	}

	@Override
	public String getKey() {
		return key;
	}
	
	public String getSiDiffKey() {
		return sidiffKey;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public String getSiDiffName() {
		return sidiffName;
	}

	@Override
	public Set<String> getDocumentTypes() {
		return Collections.unmodifiableSet(documentTypes);
	}
	
	public Set<String> getSiDiffDocumentTypes() {
		return sidiffDocumentTypes;
	}

	@Override
	public IMatcher createMatcher() {
		return new SiDiffMatcherAdapter(createSiDiffMatcher());
	}

	private org.sidiff.matcher.IMatcher createSiDiffMatcher() {
		Description<org.sidiff.matcher.IMatcher> description = org.sidiff.matcher.IMatcher.DESCRIPTION;
		org.sidiff.matcher.IMatcher sidiffMatcher = description.createExecutableExtension(sidiffMatcherExtension).get();
		
		if (configuration != null) {
			sidiffMatcher.getConfiguration().setOptions(configuration);
		}
		
		return sidiffMatcher;
	}

	@Override
	public Map<String, Object> getConfiguration() {
		return Collections.unmodifiableMap(configuration);
	}
}
