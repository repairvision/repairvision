package org.sidiff.common.emf.exceptions;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

@SuppressWarnings("serial")
public class CrossDocumentReferenceUnresolvableException extends Exception {

	public CrossDocumentReferenceUnresolvableException(URI proxyURI, Map<URI,URI> mapped) {
		super("Unresovable URI: " + proxyURI
				+ "\n The URIMap of the ResourceSet misses the correct absolute file:/ URIs to which the cross document references should be resolved."
				+ "\n Extend the list of input cross referenced document file URIs with the required"
				+ "absolute file:/ path onto which the respective eProxyURIs should be resolved."
				+ "\n currently mapped are the follwing URIs:"
				+ "\n: " + mapped.toString());
	}

	public CrossDocumentReferenceUnresolvableException(Set<URI> unresolvableResources, Map<URI,URI> mapped) {
		super("The URIMap of the ResourceSet still misses the correct absolute file:/ URIs to which the cross document references should be resolved."
			  + "Either some URIs are badly mapped or there are ambiguities in URI usage or the resouces have dependencies to further resources"
			  + " which have not been mapped."
			  + "\n The resources which can't be resolved (themselves or because of further missing dependencies) are:"
			  + "\n " + unresolvableResources.toString()
			  + "\n The URIMap contains the following entries:"
			  + "\n: " + mapped.toString());
	}
}
