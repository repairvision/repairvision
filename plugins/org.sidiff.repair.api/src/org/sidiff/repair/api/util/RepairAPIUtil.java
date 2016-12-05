package org.sidiff.repair.api.util;

import org.eclipse.emf.common.util.URI;

public class RepairAPIUtil {

	public static URI getDifferenceURI(URI modelA, URI modelB) {
		return URI.createURI(
				modelA.trimFileExtension().toString() + "_to_" +
				modelB.trimFileExtension().appendFileExtension(".symmetric").lastSegment());
	}
}
