package org.sidiff.revision.difference.derivation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.utilities.emf.DocumentType;
import org.sidiff.revision.difference.Difference;

/**
 * Incremental technical difference builder which must be initialized with a
 * list of ITechnicalDifferenceBuilders. When the difference is derived, this
 * incremental difference builder invokes all sub-builders in the order which is
 * given by the list of technical difference builders.
 * 
 * Please note that each sub-builder must ensure that it derives only those
 * low-level changes that refer to types which are supported by this technical
 * difference builder.
 * 
 * Note also that this technical difference builder is not registered via an
 * extension point and will not be shown in the SiLift UI. So far, it is only
 * usable via API.
 * 
 * 
 * @author kehrer
 */
public class IncrementalTechnicalDifferenceBuilder implements ITechnicalDifferenceBuilder {

	public static final String NAME = "Incremental Technical Difference Builder";

	/**
	 * The list of technical difference builders which will be executed in the
	 * order given by the List.
	 */
	private List<ITechnicalDifferenceBuilder> tdBuilders;

	/**
	 * Constructs a new incremental technical difference builder based on a list
	 * of sub-builders. These sub-builders will be executed in the order given
	 * by the list.
	 * 
	 * @param tdBuilders
	 */
	public IncrementalTechnicalDifferenceBuilder(List<ITechnicalDifferenceBuilder> tdBuilders) {
		super();
		this.tdBuilders = tdBuilders;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public Difference deriveTechDiff(Difference difference, Scope scope) {
		Resource modelA = difference.getModelA();
		Resource modelB = difference.getModelB();
		
		for (int i = 0; i < tdBuilders.size(); i++) {
			ITechnicalDifferenceBuilder nextBuilder = tdBuilders.get(i);

			if (nextBuilder.canHandleModels(modelA, modelB)) {
				nextBuilder.deriveTechDiff(difference, scope);
			} else {
			}
		}
		
		return difference;
	}

	@Override
	public Set<String> getDocumentTypes() {
		Set<String> docTypes = new HashSet<String>();
		for(ITechnicalDifferenceBuilder builder : tdBuilders){
			docTypes.addAll(builder.getDocumentTypes());
		}
		return docTypes;
	}

	@Override
	public String getKey() {
		return getClass().getName();
	}

	@Override
	public boolean canHandleDocTypes(Set<String> documentTypes) {
		return getDocumentTypes().containsAll(documentTypes);
	}

	@Override
	public boolean canHandleModels(Resource modelA, Resource modelB) {
		Set<String> docTypes = DocumentType.getDocumentTypes(modelA, Scope.RESOURCE_SET);
		docTypes.addAll(DocumentType.getDocumentTypes(modelB, Scope.RESOURCE_SET));

		return canHandleDocTypes(docTypes);
	}

	public List<ITechnicalDifferenceBuilder> getTechnicalDifferenceBuilders() {
		return tdBuilders;
	}
}
