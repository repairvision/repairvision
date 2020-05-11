package org.sidiff.revision.difference.derivation;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.difference.symmetric.SymmetricDifference;

/**
 * This interface belongs to the 'org.sidiff.revision.difference.derivation' extension
 * point. This extension point is used to add a new technical difference builder
 * to the lifting engine. A plug-in that adds this extension point has to
 * implement this interface.
 * 
 * A generic implementation is given by
 * {@link GenericTechnicalDifferenceBuilder}
 */
public interface ITechnicalDifferenceBuilder {
	/**
	 * The shared extension point id.
	 */
	public static final String extensionPointID = "org.sidiff.revision.difference.derivation.technical_difference_builder_extension";

	/**
	 * Returns the description name of the technical difference builder.
	 * 
	 * @return the technical difference builder name.
	 */
	public String getName();
	
	/**
	 * Returns the short name (used as a key) of the technical difference builder.
	 * 
	 * @return the technical difference builder short name (used as key).
	 */
	public String getKey();

	/**
	 * @return the document types the technical difference builder is primarily
	 *         implemented for.
	 */
	public Set<String> getDocumentTypes();
	
	/**
	 * Derives the technical difference. A default implementation is given by
	 * the abstract class {@link AbstractTechnicalDifferenceBuilder}
	 * 
	 * @param difference
	 * @return {@link SymmetricDifference}
	 */
	public SymmetricDifference deriveTechDiff(SymmetricDifference difference, Scope scope);

	/**
	 * Returns whether this technical difference builder can handle models with
	 * the given documentTypes.
	 * 
	 * @param documentTypes
	 * @return
	 */
	public boolean canHandleDocTypes(Set<String> documentTypes);
	
	/**
	 * Returns whether this technical difference builder can handle the given models
	 * 
	 * @param modelA
	 * @param modelB
	 * @return
	 */
	public boolean canHandleModels(Resource modelA, Resource modelB);

}
