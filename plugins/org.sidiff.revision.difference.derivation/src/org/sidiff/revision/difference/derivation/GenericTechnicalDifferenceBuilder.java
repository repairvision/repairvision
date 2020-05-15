package org.sidiff.revision.difference.derivation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.common.utilities.emf.DocumentType;

/**
 * Generic technical difference builder. <br/>
 * Accepts any model type and filters nothing.
 * 
 * @author kehrer
 */
public class GenericTechnicalDifferenceBuilder extends AbstractTechnicalDifferenceBuilder {

	@Override
	protected Set<EClass> getUnconsideredNodeTypes() {
		return Collections.emptySet();
	}

	@Override
	protected Set<EReference> getUnconsideredEdgeTypes() {
		return Collections.emptySet();
	}

	@Override
	protected Set<EAttribute> getUnconsideredAttributeTypes() {
		return Collections.emptySet();
	}
	
	@Override
	protected String getObjectName(EObject obj) {
		return obj.toString();
	}

	@Override
	public Set<String> getDocumentTypes() {
		Set<String> docTypes = new HashSet<String>();
		docTypes.add(DocumentType.GENERIC_DOCUMENT_TYPE);
		return docTypes;
	}
	
	@Override
	protected boolean doProcess(EObject object) {
		return true;
	}
	
	@Override
	public boolean canHandleDocTypes(Set<String> documentTypes) {
		return true;
	}

	@Override
	public String getName(){
		return "Generic Technical Difference Builder";
		
	}	
}
