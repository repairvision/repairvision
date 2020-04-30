package org.sidiff.revision.editrules.project.builder.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.profile.constraints.util.ConstraintProfileUtil;
import org.sidiff.revision.editrules.project.RuleBasePlugin;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.project.ConstraintPlugin;
import org.sidiff.validation.constraint.project.library.IConstraintLibrary;
import org.sidiff.validation.laguage.fol.util.EMFMetaAccessUtil;

public class RuleBaseBuilderUtils {

	public static String getEditRuleFolder() {
		return RuleBasePlugin.EDIT_RULE_FOLDER + "/";
	}
	
	public static String getExampleFolder() {
		return RuleBasePlugin.EXAMPLE_FOLDER + "/";
	}
	
	public static  String getExampleFolder(Bundle patternBundle) {
		return RuleBasePlugin.EXAMPLE_FOLDER + "/" + patternBundle.getName();
	}
	
	public static String getPatternPath(Pattern pattern) {
		StringBuilder patternPath = new StringBuilder();
		patternPath.append(pattern.getName());
		patternPath.append("/");
		
		while (pattern.eContainer() instanceof Pattern) {
			pattern = (Pattern) pattern.eContainer();
			patternPath.insert(0, "/");
			patternPath.insert(0, pattern.getName());
		}
		
		return patternPath.toString();
	}
	
	public static void createEditRuleFolders(IProject project, IProgressMonitor monitor) throws CoreException {
		WorkbenchUtil.createFolder(project, getEditRuleFolder(), monitor);
	}
	
	public static void createExampleFolders(Bundle patternBundle, IProject project, IProgressMonitor monitor) throws CoreException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 2);
		
		String exampleFolder = getExampleFolder();
		WorkbenchUtil.createFolder(project, exampleFolder, subMonitor.split(1));
		
		// Convert Constraint-Pattern tree to folder structure:
		for (EObject element : (Iterable<EObject>) () -> patternBundle.eResource().getAllContents()) {
			if (element instanceof Pattern) {
				if ((element instanceof Bundle) || ConstraintProfileUtil.isConstraint((Pattern) element)) {
					String patternFolder = getPatternPath((Pattern) element);
					WorkbenchUtil.createFolder(project,  exampleFolder + patternFolder, subMonitor.split(1));
				}
			}
		}
	}
	
	public static List<IConstraint> getWorkspaceConstraints(Set<String> documentTypes, WorkspaceContext context) {
		cleanUpEMFRegistry(); // from old loaded workspace classes
		
		List<IConstraint> availableConstraints = new ArrayList<>();
		
		for (Entry<String, IProject> libraryEntry: getWorkspaceConstraintLibraries().entrySet()) {
			List<IConstraint> constraints = new ArrayList<>();
			
			try {
				IConstraintLibrary library = loadWorkspaceClass(
						libraryEntry.getValue(), IConstraintLibrary.class, libraryEntry.getKey(), context);

				for (IConstraint constraint : library.getConstraints()) {
					if (documentTypes.contains(constraint.getContextType().getEPackage().getNsURI())) {
						constraints.add(constraint);
					}
				}
			} catch (Throwable t) {
				constraints.clear();
				//t.printStackTrace();
			}
			availableConstraints.addAll(constraints);
		}
		
		return availableConstraints;
	}
	
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
					classLoader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static class WorkspaceClassLoader extends URLClassLoader{
		
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

		ClassLoader parentClassLoader = Thread.currentThread().getContextClassLoader();
		
		@SuppressWarnings("resource")
		WorkspaceClassLoader workspaceClassLoader = new WorkspaceClassLoader(parentClassLoader);
		context.classLoader = workspaceClassLoader;
		
		IJavaProject javaProject = JavaCore.create(project);
		String[] classPathEntries = JavaRuntime.computeDefaultRuntimeClassPath(javaProject);

		for (String classPathEntrie : classPathEntries) {
			IPath path = new Path(classPathEntrie);
			URI uri = path.toFile().toURI();
			URL url = uri.toURL();

			// Other projects in the workspace (not runtime)
			if (project.getWorkspace().getRoot().findContainersForLocationURI(uri).length > 0) {
				workspaceClassLoader.add(url);
			}
		}
		
		Class<?> loadedClass = workspaceClassLoader.loadClass(className);
		return (T) loadedClass.newInstance();
	}
}
