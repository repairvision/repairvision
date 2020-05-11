package org.sidiff.validation.constraint.project.builder.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

/**
 * This class defines the nature of an @link{IConstraintLibrary} project.
 * 
 * @author Manuel Ohrndorf
 */
public class ConstraintProjectNature implements IProjectNature {

	/**
	 * ID of this project nature
	 */
	public static final String CONSTRAINT_NATURE_ID = "org.sidiff.validation.constraint.project.builder.constraintnature";
	
	/**
	 * ID of the XText project nature
	 */
	public static final String XTEXT_NATURE_ID = "org.eclipse.xtext.ui.shared.xtextNature";
	
	private IProject project;

	@Override
	public void configure() throws CoreException {
	}

	@Override
	public void deconfigure() throws CoreException {
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}
}
