package org.sidiff.revision.common.emf.document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * A model represents a specific document type, which is defined by a
 * meta-model. The document type is represented by the namespace URI of the
 * meta-model ({@link EPackage}).
 * 
 * @author Manuel Ohrndorf
 */
public class DocumentType {
	
	/**
	 * Constant that represents a "generic document type". If functions that are
	 * usually designed for a specific document type (e.g., matchers or
	 * technical difference builders) are generic in the sense that they can
	 * handle any document type, the y can indicate this genericity by using
	 * this constant as supported document type.
	 */
	public static final String GENERIC_DOCUMENT_TYPE = "generic";

	public static final String SEPARATOR = ";";

	/**
	 * @param documentTypes A composition of meta-models.
	 * @return The characteristic document type of the composed meta-model.
	 */
	public static String getDocumentType(List<String> documentTypes) {
		return documentTypes.get(0);
	}

	/**
	 * @param eObject a model element.
	 * @return The document type of the model of the given element.
	 */
	public static String getDocumentType(EObject object) {
		EPackage pkg = object.eClass().getEPackage();

		while (pkg != null && pkg.getESuperPackage() != null) {
			pkg = pkg.getESuperPackage();
		}

		return getDocumentType(pkg);
	}

	/**
	 * @param pkg A meta-model.
	 * @return The document type of the meta-model.
	 */
	public static String getDocumentType(EPackage pkg) {
		return pkg.getNsURI();
	}

	/**
	 * @param resource A resource that contains a model.
	 * @return The document type of the contained model.
	 */
	public static String getDocumentType(Resource resource) {
		if (!resource.getContents().isEmpty()) {
			return getDocumentType(resource.getContents().get(0));
		}
	
		return null;
	}

	/**
	 * @param documentType A document type.
	 * @return The registered meta-model of the document type.
	 */
	public static List<EPackage> getDocumentTypes(String documentType) {
		if (documentType.contains(SEPARATOR)) {
			List<EPackage> packages = new ArrayList<>();
	
			for (String containedDocumentType : documentType.split(SEPARATOR)) {
				packages.addAll(getDocumentTypes(containedDocumentType));
			}
	
			return packages;
		} else {
			EPackage pkg = EPackage.Registry.INSTANCE.getEPackage(documentType);
	
			if (pkg != null) {
				return Collections.singletonList(pkg);
			} else {
				return Collections.emptyList();
			}
		}
	}

	/**
	 * @param documentTypes A composition of meta-models.
	 * @return The document type of the composed meta-model.
	 */
	public static String getDocumentTypes(List<String> documentTypes) {
		StringBuilder serializedDocumentType = new StringBuilder();
	
		for (String documentType : documentTypes) {
			serializedDocumentType.append(documentType);
			serializedDocumentType.append(SEPARATOR);
		}
	
		return serializedDocumentType.substring(0, serializedDocumentType.length() - 1);
	}

	/**
	 * @param resource A resource that contains a model.
	 * @param scope    Defines the resource scope.
	 * @return The document type of the contained models within the given scope.
	 */
	public static Set<String> getDocumentTypes(Resource resource, Scope scope) {
		List<Resource> resources = new ArrayList<Resource>();
		
		if (scope == Scope.RESOURCE_SET) {
			resources.addAll(resource.getResourceSet().getResources());
		} else {
			resources.add(resource);
		}
	
		// Collect all document types
		Set<String> documentTypes = new HashSet<String>();
		
		for (Resource otherResource : resources) {
			documentTypes.add(getDocumentType(otherResource));
		}
	
		return documentTypes;
	}

	/**
	 * @return All registered document types.
	 */
	public static Set<String> getAvailableDocumentTypes() {
		return Collections.unmodifiableSet(EcorePlugin.getEPackageNsURIToGenModelLocationMap(false).keySet());
	}

	/**
	 * Matches attributes which are not changeable, derived or transient.
	 * 
	 * @param structualFeatureType The attribute to test.
	 * @return <code>true</code> if the not changeable, derived or transient;
	 *         <code>false</code> otherwise;
	 */
	public static boolean isUnconsideredStructualFeature(EStructuralFeature structualFeatureType) {
		return ((structualFeatureType.isChangeable() == false)
				|| (structualFeatureType.isDerived() == true)
				|| (structualFeatureType.isTransient() == true));
	}
}
