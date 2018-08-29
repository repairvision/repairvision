package org.sidiff.history.revision.util;

import org.eclipse.emf.common.util.URI;

public class RevisionUtil {

	public static URI getDifferenceURI(URI modelA, URI modelB) {
		return URI.createURI(
				modelA.trimFileExtension().toString() + "_to_" +
				modelB.trimFileExtension().appendFileExtension(".symmetric").lastSegment());
	}
}
