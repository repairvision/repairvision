package org.sidiff.revision.editrules.project.development.registry;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.sidiff.revision.editrules.project.registry.RulebaseExtension;

public class WorkspaceRulebaseExtension extends RulebaseExtension {

	private RulebaseExtension runtime;
	
	public WorkspaceRulebaseExtension(String projectName, String runtimeName, String workspaceName, String documentType, String folder) {
		super(projectName, workspaceName, documentType, folder);
		this.runtime = new RulebaseExtension(projectName, runtimeName, documentType, folder);
	}

	public String getRuntimeName() {
		return runtime.getName();
	}
	
	public boolean equalsRuntime(RulebaseExtension runtime) {
		return this.runtime.equals(runtime);
	}
	
	@Override
	public List<URI> getEditRules() {
		List<URI> editRules = new ArrayList<>();
		
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName());
			IResource[] resources = project.getFolder(getFolder()).members();
			
			for (IResource resource : resources) {
				if (resource.getFileExtension().equalsIgnoreCase("henshin")) {
					editRules.add(URI.createPlatformResourceURI(resource.getFullPath().toString(), true));
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return editRules;
	}
}
