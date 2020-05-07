package org.sidiff.revision.editrules.project.development.registry;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.sidiff.revision.editrules.project.RuleBasePlugin;

/**
 * Searches all Rulebases in the current active workspace (development time).
 * 
 * @author Manuel Ohrndorf
 */
public class WorkspaceRulebaseRegistry {

	/**
	 * @param annotation A annotation appended to rulebase name.
	 * @return All rulebase extensions within the actual workspace.
	 */
	public static List<WorkspaceRulebaseExtension> getRulebases(String annotation) {
		List<WorkspaceRulebaseExtension> rulebases = new ArrayList<>();
		IPluginModelBase[] workspacePlugins = PluginRegistry.getWorkspaceModels();

		for (IPluginModelBase workspacePlugin : workspacePlugins) {
			IPluginExtension[] extensions = workspacePlugin.getExtensions().getExtensions();
			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(workspacePlugin.getBundleDescription().getSymbolicName());

			for (IPluginExtension extension : extensions) {
				if (RuleBasePlugin.EXTENSION_POINT_ID.equals(extension.getPoint())) {
					IPluginObject[] children = extension.getChildren();

					for (IPluginObject child : children) {
						if (RuleBasePlugin.EXTENSION_POINT_ELEMENT_RULEBASE.equals(child.getName())) {
							if (child instanceof IPluginElement) {
								IPluginElement element = (IPluginElement) child;
								
								String name = element
										.getAttribute(RuleBasePlugin.EXTENSION_POINT_ATTRIBUTE_RULEBASE_NAME)
										.getValue();
								
								String documentType = element
										.getAttribute(RuleBasePlugin.EXTENSION_POINT_ATTRIBUTE_RULEBASE_DOCUMENT_TYPE)
										.getValue();
								
								String folder = element
										.getAttribute(RuleBasePlugin.EXTENSION_POINT_ATTRIBUTE_RULEBASE_FOLDER)
										.getValue();
								
								rulebases.add(new WorkspaceRulebaseExtension(project.getName(), name, name + annotation, documentType, folder));
							}
						}
					}
				}
			}
		}

		return rulebases;
	}
}
