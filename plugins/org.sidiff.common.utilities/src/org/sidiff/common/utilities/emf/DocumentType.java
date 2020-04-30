package org.sidiff.common.utilities.emf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
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

	public static final String SEPARATOR = ";";

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
	 * @param documentType A document type.
	 * @return The registered meta-model of the document type.
	 */
	public static List<EPackage> getDocumentType(String documentType) {
		if (documentType.contains(SEPARATOR)) {
			List<EPackage> packages = new ArrayList<>();

			for (String containedDocumentType : documentType.split(SEPARATOR)) {
				packages.addAll(getDocumentType(containedDocumentType));
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
	 * @param pkg A meta-model.
	 * @return The document type of the meta-model.
	 */
	public static String getDocumentType(EPackage pkg) {
		return pkg.getNsURI();
	}

	/**
	 * @param documentTypes A composition of meta-models.
	 * @return The document type of the composed meta-model.
	 */
	public static String getDocumentType(List<String> documentTypes) {
		StringBuilder serializedDocumentType = new StringBuilder();

		for (String documentType : documentTypes) {
			serializedDocumentType.append(documentType);
			serializedDocumentType.append(SEPARATOR);
		}

		return serializedDocumentType.substring(0, serializedDocumentType.length() - 1);
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
	 * @return All registered document types.
	 */
	public static Set<String> getAvailableDocumentTypes() {
		return Collections.unmodifiableSet(EcorePlugin.getEPackageNsURIToGenModelLocationMap(false).keySet());
	}
}
