package org.sidiff.repair.history.generator.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;

public class HistoryUtil {

	public static Resource load(ResourceSet resourceSet, URI uri, URIHandler uriHandler) {
		try {
			if (uriHandler != null) {
				resourceSet.getLoadOptions().put(XMIResource.OPTION_URI_HANDLER, uriHandler);
			}
			resourceSet.getLoadOptions().put(XMIResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
			resourceSet.getLoadOptions().put(XMIResource.OPTION_PROCESS_DANGLING_HREF, XMIResource.OPTION_PROCESS_DANGLING_HREF_RECORD);
			
			return resourceSet.getResource(uri, true);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static Resource load(ResourceSet resourceSet, URI uri) {
		return load(resourceSet, uri, null);
	}
}
