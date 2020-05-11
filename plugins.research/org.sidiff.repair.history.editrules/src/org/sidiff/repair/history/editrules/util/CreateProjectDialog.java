package org.sidiff.repair.history.editrules.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;

public class CreateProjectDialog {
	
	public static IProject createProject(String projectName) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		
		if (project.exists()) {
			MessageDialog dialog = new MessageDialog(
					null, "Create Project: " + projectName, null, 
					"The project " + projectName + " already exist.",
					MessageDialog.QUESTION,
					new String[] {"Continue", "Cancel"}, 0);
			
			if (dialog.open() != 0) {
				return null;
			}
		}
		
		if (!project.exists()) {
			try {
				project.create(new NullProgressMonitor());
				project.open(new NullProgressMonitor());
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		
		return project;
	}
}
