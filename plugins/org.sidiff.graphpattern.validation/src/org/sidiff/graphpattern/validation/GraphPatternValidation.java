package org.sidiff.graphpattern.validation;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;

public class GraphPatternValidation {

	// OCLinEcore validation depends on: 
	// plug-in: org.eclipse.ocl.ecore.pivot
	// feature: org.eclipse.ocl.unified.core
	// https://wiki.eclipse.org/OCL/OCLinEcore
	
	public static boolean validate(IResource resource, EObject eObject) {
		return WorkbenchUtil.validateEMFResource(resource, eObject);
	}
}
