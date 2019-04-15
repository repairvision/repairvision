package org.sidiff.candidates;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * this util check the registry for registered candidateservices.
 * 
 * @author vdueck
 *
 */
public class CandidatesUtil {

	private static ICandidates instance = null;

	public static Set<ICandidates> getAvailableCandidatesServices() {
		Set<ICandidates> candidateServices = new HashSet<ICandidates>();

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(ICandidates.EXTENSION_POINT_ID)) {
			try {
				ICandidates candidateService = (ICandidates) configurationElement.createExecutableExtension("class");
				candidateServices.add(candidateService);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return candidateServices;
	}

	public static ICandidates getAvailableCandidatesService(String candidateServiceID) {
		ICandidates candidateService = null;

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(ICandidates.EXTENSION_POINT_ID)) {
			try {
				ICandidates candidateServicetmp = (ICandidates) configurationElement.createExecutableExtension("class");
				if (candidateServicetmp.getServiceID().trim().equals(candidateServiceID)) {
					candidateService = candidateServicetmp;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return candidateService;
	}

	public static void setCandidateServiceInstance(ICandidates csi) {
		instance = csi;
	}

	public static ICandidates getCandidatesServiceInstance() {
		if (instance != null) {
			return instance;
		} else
			instance = getAvailableCandidatesServices().iterator().next();
		return instance;
	}

}
