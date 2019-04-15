package org.sidiff.common.stringresolver;

import org.eclipse.emf.ecore.EObject;

/**
 * A StringResolver is responsible for calculating an appropriate textual
 * representation of an object of a specific document type.
 * 
 * @author cpietsch
 * 
 */
public interface IStringResolver {

	/**
	 * The shared extension point id.
	 */
	public static final String extensionPointID = "org.sidiff.common.stringresolver.string_resolver_extension";

	/**
	 * Resolves the textual representation of the given object
	 * 
	 * @param eObject
	 *            an object of which the textual representation shall be
	 *            resolved
	 * @return a string representation of the object
	 */
	public String resolve(EObject eObject);

	/**
	 * Resolves a qualified textual representation of the given object
	 * 
	 * @param eObject
	 *            an object of which the qualified textual representation shall
	 *            be resolved
	 * @return a qualified string representation of the object
	 */
	public String resolveQualified(EObject eObject);
	/**
	 * checks if the given document type can be handled by the resolver
	 * 
	 * @param docType
	 *            the nsURI of the document type
	 * @return <code>true</code> if the given document type can be handled by
	 *         the resolver, <code>false</code> otherwise.
	 */
	public boolean canHandleDocType(String docType);

	/**
	 * Returns the document type which is supported by the resolver.
	 * 
	 * @return the nsURI of the supported document type
	 */
	public String getDocType();

	/**
	 * Returns the short name (used as a key) of the string resolver.
	 * 
	 * @return the resolver short name (used as key)
	 */
	public String getKey();

	/**
	 * Returns the name of the string resolver.
	 * 
	 * @return the resolver name
	 */
	public String getName();
}
