package org.sidiff.correspondences;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class CorrespondencesUtil {

	public static ICorrespondences getAvailableCorrespondencesService(String correspondenceServiceID) {
		ICorrespondences correspondencesService = null;

		for(ICorrespondences iCorrespondencesService : getAllAvailableCorrespondencesServices()){
			if(iCorrespondencesService.getServiceID().equals(correspondenceServiceID)){
				correspondencesService = iCorrespondencesService;
			}
		}
		return correspondencesService;
	}
	
	public static ICorrespondences getDefaultCorrespondencesService() {
		return getAllAvailableCorrespondencesServices().iterator().next();
	}
	
	public static Set<ICorrespondences> getAllAvailableCorrespondencesServices() {
		Set<ICorrespondences> correspondencesServices = new HashSet<ICorrespondences>();

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				ICorrespondences.EXTENSION_POINT_ID)) {
			try {
				ICorrespondences correspondencesService = (ICorrespondences) configurationElement
						.createExecutableExtension("class");
				correspondencesServices.add(correspondencesService);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return correspondencesServices;
	}
}
