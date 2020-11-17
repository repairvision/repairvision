package org.sidiff.reverseengineering.java.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.JavaCore;

/**
 * Some convenient functionality to analyze workspace resources. 
 * 
 * @author Manuel Ohrndorf
 */
public class WorkspaceUtil {

	/**
	 * @param project A project of the Eclipse workspace.
	 * @return <code>true</code> if the project is configured as a project with Java nature.
	 * @throws CoreException
	 */
	public static boolean isJavaProject(IProject project) {
		try {
			return project.hasNature(JavaCore.NATURE_ID);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
