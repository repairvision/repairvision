package org.sidiff.history.repository.util;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.common.emf.EMFStorage;

public class ModelRepositoryUtil {

	public static File getModelFile(Resource model) {
		return EMFStorage.uriToFile(model.getURI());
	}
	
	public static File getModelFile(URI model) {
		return EMFStorage.uriToFile(model);
	}
	
	public static URI generateWorkspaceLocation(URI workingCopy, String revision) {
		return workingCopy.trimSegments(1)
				.appendSegment(workingCopy.lastSegment() + ".history.versions")
				.appendSegment("" + revision)
				.appendSegment(workingCopy.lastSegment());
	}
}
