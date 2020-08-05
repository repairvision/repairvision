package org.sidiff.validation.laguage.fol.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.internal.core.project.PDEProject;
import org.eclipse.pde.internal.core.text.DocumentElementNode;
import org.eclipse.pde.internal.core.text.plugin.PluginModel;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.validation.constraint.project.ConstraintPlugin;

@SuppressWarnings("restriction")
public class GeneratorUtil {
	
	public static void createExtensionPoint(String projectName, String library) throws CoreException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		IFile pluginXMLIFile = PDEProject.getPluginXml(project);
		File pluginXMLFile = new File(project.getLocation().toFile().getAbsoluteFile() + "/" + pluginXMLIFile.getProjectRelativePath().toFile().getPath());
		
		IDocumentProvider provider = new TextFileDocumentProvider();
		provider.connect(pluginXMLIFile);
		IDocument document = provider.getDocument(pluginXMLIFile);
		
		PluginModel pluginModel = new PluginModel(document, true);
		
		// load plugin.xml:
		if (pluginXMLFile.exists()) {
			try(InputStream inputStream = new FileInputStream(pluginXMLFile)) {
				pluginModel.load(inputStream, false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// find or create extension:
		IPluginExtension extension = getExtension(pluginModel, ConstraintPlugin.EXTENSION_POINT_ID);
		
		// register new library:
		if (getLibrary(extension, library) == null) {
			IPluginModelFactory factory = pluginModel.getPluginFactory();
			IPluginElement element = factory.createElement(extension);
			element.setName(ConstraintPlugin.EXTENSION_POINT_ELEMENT_LIBRARY);
			element.setAttribute(ConstraintPlugin.EXTENSION_POINT_ATTRIBUTE_LIBRARY_LIBRARY, library);
			extension.add(element);
		}

		// save plugin.xml:
		try (PrintWriter outputStream = new PrintWriter(pluginXMLFile)) {
			IPluginBase pluginBase = pluginModel.getPluginBase(true);
			
			if (pluginBase instanceof DocumentElementNode) {
				String content = ((DocumentElementNode) pluginBase).write(true);
				outputStream.write(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		provider.disconnect(pluginXMLIFile);
		WorkbenchUtil.refreshProject(project);
	}
	
	private static IPluginExtension getExtension(IPluginModelBase model, String pointId) throws CoreException {
		
		// Check for existing
		IPluginExtension[] extensions = model.getPluginBase().getExtensions();
		
		for (IPluginExtension extension : extensions) {
			if (extension.getPoint().equalsIgnoreCase(pointId)) {
				return extension;
			}
		}
		
		// or create new:
		IPluginExtension extension = model.getFactory().createExtension();
		extension.setPoint(pointId);
		model.getPluginBase().add(extension);
		
		return extension;
	}
	
	private static IPluginAttribute getLibrary(IPluginExtension extension, String newLibrary) throws CoreException {
		for (IPluginObject child : extension.getChildren()) {
			if (child.getName().equals(ConstraintPlugin.EXTENSION_POINT_ELEMENT_LIBRARY)) {
				if (child instanceof IPluginElement) {
					IPluginAttribute libraryAttribute = ((IPluginElement) child).getAttribute(ConstraintPlugin.EXTENSION_POINT_ATTRIBUTE_LIBRARY_LIBRARY);
					
					if (libraryAttribute.getValue().equals(newLibrary)) {
						return libraryAttribute;
					}
				}
			}
		}
		return null;
	}
}
