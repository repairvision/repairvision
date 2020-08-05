package org.sidiff.revision.difference.builder;

import java.util.HashSet;
import java.util.Set;

import org.sidiff.revision.common.emf.document.DocumentType;

/**
 * Generic technical difference builder. Accepts any model type and filters nothing domain specific.
 */
public class GenericDifferenceBuilderProvider implements IDifferenceBuilderProvider {

	@Override
	public String getKey() {
		return "GenericDifferenceBuilder";
	}
	
	@Override
	public String getName(){
		return "Generic Difference Builder";
	}	

	@Override
	public Set<String> getDocumentTypes() {
		Set<String> docTypes = new HashSet<String>();
		docTypes.add(DocumentType.GENERIC_DOCUMENT_TYPE);
		return docTypes;
	}

	@Override
	public IDifferenceBuilder createDifferenceBuilder() {
		return new GenericDifferenceBuilder();
	}
}
