package org.sidiff.service;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class ServiceUtils {

	public static Set<IService> getServices() {
		Set<IService> services = new HashSet<IService>();

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(IService.EXTENSION_POINT_ID)) {
			try {
				IService service = (IService) configurationElement.createExecutableExtension("class");
				services.add(service);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return services;
	}
}
