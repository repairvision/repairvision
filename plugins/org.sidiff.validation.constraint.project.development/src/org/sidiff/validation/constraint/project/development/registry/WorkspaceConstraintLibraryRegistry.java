package org.sidiff.validation.constraint.project.development.registry;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.project.ConstraintPlugin;
import org.sidiff.validation.constraint.project.registry.IConstraintLibrary;
import org.sidiff.validation.laguage.fol.util.EMFMetaAccessUtil;

public class WorkspaceConstraintLibraryRegistry {
	
	public static List<IConstraint> getConstraints(Set<String> documentTypes, WorkspaceContext context) {
		cleanUpEMFRegistry();

		List<IConstraint> availableConstraints = new ArrayList<>();

		for (Entry<String, IProject> libraryEntry : getWorkspaceConstraintLibraries().entrySet()) {
			List<IConstraint> constraints = new ArrayList<>();

			try {
				IConstraintLibrary library = loadWorkspaceClass(libraryEntry.getValue(), IConstraintLibrary.class,
						libraryEntry.getKey(), context);

				for (IConstraint constraint : library.getConstraints()) {
					if (documentTypes.contains(constraint.getContextType().getEPackage().getNsURI())) {
						constraints.add(constraint);
					}
				}
			} catch (Throwable t) {
				constraints.clear();
				// t.printStackTrace();
			}
			availableConstraints.addAll(constraints);
		}

		return availableConstraints;
	}

	/**
	 * Clean up framework from loaded workspace models.
	 */
	// TODO: It would be better to control the loading and unloading of models in
	// the workspace ourself. At the moment, the models register themselves as a
	// side effect when they are used. This might cause (uncritical) class cast
	// exceptions on the model factory if the model is reloaded. (A class in java is
	// identified by its classloader and classpath.) Cleaning the models from the
	// EMF registry solves the class cast exceptions.
	private static void cleanUpEMFRegistry() {
		for (String nsURI : EMFMetaAccessUtil.getWorkspaceGenModels().keySet()) {
			EPackage.Registry.INSTANCE.put(nsURI, null);
		}
	}

	private static Map<String, IProject> getWorkspaceConstraintLibraries() {
		Map<String, IProject> libraries = new HashMap<>();

		IPluginModelBase[] workspacePlugins = PluginRegistry.getWorkspaceModels();

		for (IPluginModelBase workspacePlugin : workspacePlugins) {
			IPluginExtension[] extensions = workspacePlugin.getExtensions().getExtensions();
			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(workspacePlugin.getBundleDescription().getSymbolicName());

			for (IPluginExtension extension : extensions) {
				if (ConstraintPlugin.EXTENSION_POINT_ID.equals(extension.getPoint())) {
					IPluginObject[] children = extension.getChildren();

					for (IPluginObject child : children) {
						if (ConstraintPlugin.EXTENSION_POINT_ELEMENT_LIBRARY.equals(child.getName())) {
							if (child instanceof IPluginElement) {
								String constraintLibraryJava = ((IPluginElement) child)
										.getAttribute(ConstraintPlugin.EXTENSION_POINT_ATTRIBUTE_LIBRARY_LIBRARY)
										.getValue();
								libraries.put(constraintLibraryJava, project);
							}
						}
					}
				}
			}
		}

		return libraries;
	}

	public static class WorkspaceContext {

		private WorkspaceClassLoader classLoader;

		public void close() {
			if (classLoader != null) {
				try {
					cleanUpEMFRegistry();
					classLoader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static class WorkspaceClassLoader extends URLClassLoader {

		public WorkspaceClassLoader(ClassLoader parent) {
			super(new URL[0], parent);
		}

		public void add(URL url) {
			if (!contains(url)) {
				super.addURL(url);
			}
		}

		public boolean contains(URL url) {
			for (URL containedURL : getURLs()) {
				if (containedURL.equals(url)) {
					return true;
				}
			}
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	private static <T> T loadWorkspaceClass(IProject project, Class<T> classType, String className,
			WorkspaceContext context) throws CoreException, MalformedURLException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, IOException {

		if (context.classLoader == null) {
			ClassLoader parentClassLoader = Thread.currentThread().getContextClassLoader();
			context.classLoader = new WorkspaceClassLoader(parentClassLoader);
		}

		IJavaProject javaProject = JavaCore.create(project);
		String[] classPathEntries = JavaRuntime.computeDefaultRuntimeClassPath(javaProject);

		for (String classPathEntrie : classPathEntries) {
			IPath path = new Path(classPathEntrie);
			URI uri = path.toFile().toURI();
			URL url = uri.toURL();

			// Other projects in the workspace (not runtime)
			if (project.getWorkspace().getRoot().findContainersForLocationURI(uri).length > 0) {
				context.classLoader.add(url);
			}
		}

		Class<?> loadedClass = context.classLoader.loadClass(className);
		return (T) loadedClass.newInstance();
	}
}
