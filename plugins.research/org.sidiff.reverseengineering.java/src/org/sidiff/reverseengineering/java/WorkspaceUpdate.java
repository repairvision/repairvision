package org.sidiff.reverseengineering.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.sidiff.reverseengineering.java.util.WorkspaceUtil;

public class WorkspaceUpdate {
	
	private IProject project;
	
	private List<IResource> removed = new ArrayList<>();
	
	private List<IResource> modified = new ArrayList<>();
	
	private List<IResource> created = new ArrayList<>();
	
	public WorkspaceUpdate(IProject project) {
		this.project = project;
	}
	
	public IProject getProject() {
		return project;
	}

	public void setProject(IProject project) {
		this.project = project;
	}
	
	public boolean hasRemoved() {
		return (removed != null) && !removed.isEmpty();
	}

	public List<IResource> getRemoved() {
		
		if (removed == null) {
			removed = new ArrayList<>();
		}
		
		return removed;
	}

	public void setRemoved(List<IResource> removed) {
		this.removed = removed;
	}
	
	public boolean hasModified() {
		return (modified != null) && !modified.isEmpty();
	}

	public List<IResource> getModified() {
		
		if (modified == null) {
			modified = new ArrayList<>();
		}
		
		return modified;
	}

	public void setModified(List<IResource> modified) {
		this.modified = modified;
	}
	
	public boolean hasCreated() {
		return (created != null) && !created.isEmpty();
	}

	public List<IResource> getCreated() {
		
		if (created == null) {
			created = new ArrayList<>();
		}
		
		return created;
	}

	public void setCreated(List<IResource> created) {
		this.created = created;
	}

	public static List<WorkspaceUpdate> getWorkspaceProject(String name) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
		List<WorkspaceUpdate> projectUpdate = new ArrayList<>(1);
		
		if (WorkspaceUtil.isJavaProject(project)) {
			projectUpdate.add(new WorkspaceUpdate(project));
		}
		
		return projectUpdate;
	}
	
	public static List<WorkspaceUpdate> getAllWorkspaceProjects() {
		return getAllWorkspaceProjects(Collections.emptySet());
	}

	public static List<WorkspaceUpdate> getAllWorkspaceProjects(Set<String> workspaceProjectsFilter) {
		List<WorkspaceUpdate> workspaceUpdate = new ArrayList<>();
		
		// Get all projects in the workspace
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

		for (IProject project : projects) {
			if (!workspaceProjectsFilter.contains(project.getName())) {
				if (WorkspaceUtil.isJavaProject(project)) {
					WorkspaceUpdate projectWorkspaceUpdate = new WorkspaceUpdate(project);
					
					try {
						projectWorkspaceUpdate.setCreated(getAllWorkspaceJavaSources(project));
					} catch (Throwable e) {
						e.printStackTrace();
					}
					
					workspaceUpdate.add(projectWorkspaceUpdate);
				}
			}
		}
		
		return workspaceUpdate;
	}
	
	public static List<IResource> getAllWorkspaceJavaSources(IProject project) throws JavaModelException {
		IPackageFragment[] packages = JavaCore.create(project).getPackageFragments();
		List<IResource> sources = new ArrayList<>();

		for (IPackageFragment javaPackage : packages) {
				try {
					if (javaPackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
						for (ICompilationUnit compilationUnit : javaPackage.getCompilationUnits()) {
							sources.add(compilationUnit.getResource());
						}
					}
				} catch (Throwable e) {
					e.printStackTrace();
				}
		}
		
		return sources;
	}
}
