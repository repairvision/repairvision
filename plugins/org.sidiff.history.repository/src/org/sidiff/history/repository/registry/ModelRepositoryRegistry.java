package org.sidiff.history.repository.registry;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.history.repository.IModelRepository;
import org.sidiff.history.repository.IModelRepositoryConnector;

/**
 * Convenience functions to manage {@link IModelRepository} extensions.
 * 
 * @author Manuel Ohrndorf
 */
public class ModelRepositoryRegistry {
		
		/**
		 * The {@link IModelRepository} extension point identifier.
		 */
		public static final String EXTENSION_POINT_ID = "org.sidiff.history.repository.connector";
		
		/**
		 * {@link IModelRepository} extension cache.
		 */
		private static Map<IModelRepository, IModelRepositoryConnector> library = readExtensionPoints();
		
		/**
		 * @return All registered {@link IModelRepository} extensions.
		 */
		private static Map<IModelRepository, IModelRepositoryConnector> readExtensionPoints() {
			
			Map<IModelRepository, IModelRepositoryConnector> library = new LinkedHashMap<>();
			
			for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
					.getConfigurationElementsFor(EXTENSION_POINT_ID)) {

				try {
					IModelRepository repository = (IModelRepository) configurationElement.createExecutableExtension("repository");
					IModelRepositoryConnector connector = (IModelRepositoryConnector) configurationElement.createExecutableExtension("connector");
					library.put(repository, connector);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
			
			return library;
		}
		
		/**
		 * @return All registered {@link IModelRepository} extensions.
		 */
		public static Map<IModelRepository, IModelRepositoryConnector> getRepositories() {
			return library;
		}
		
		public static IModelRepository getRepository(Resource resource) {
			return getRepository(resource.getURI());
		}
		
		public static IModelRepository getRepository(URI resource) {
			for (Entry<IModelRepository, IModelRepositoryConnector> repositoryEntry : getRepositories().entrySet()) {
				if (repositoryEntry.getValue().canHandle(resource)) {
					return repositoryEntry.getKey();
				}
			}
			return null;
		}
		
		public static IModelRepositoryConnector getConnector(IModelRepository repository) {
			return getRepositories().get(repository);
		}
}
