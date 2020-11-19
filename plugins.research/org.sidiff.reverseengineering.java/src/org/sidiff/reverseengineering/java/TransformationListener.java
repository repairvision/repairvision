package org.sidiff.reverseengineering.java;

import org.eclipse.core.resources.IResource;

public interface TransformationListener {

	/**
	 * @param resource The transformed Java type resource.
	 * @param trace    Tracing information of the transformation.
	 */
	void typeModelCreated(IResource resource, TransformationTrace trace);

	/**
	 * @param resources The removed workspace resources.
	 */
	void typeModelRemoved(IResource resource);
}
