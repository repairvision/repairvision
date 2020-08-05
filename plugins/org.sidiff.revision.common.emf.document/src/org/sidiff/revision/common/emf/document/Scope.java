package org.sidiff.revision.common.emf.document;

/**
 * Just like EMF Compare, we distinguish two comparison modes (which we call
 * scopes, because they ae also relevant for patching and merging). The usual
 * (and default) case is {@link Scope#RESOURCE}.
 * 
 * @author kehrer
 */
public enum Scope {

	RESOURCE, RESOURCE_SET
}
