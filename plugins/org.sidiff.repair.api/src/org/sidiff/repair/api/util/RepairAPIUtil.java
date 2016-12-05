package org.sidiff.repair.api.util;

import org.eclipse.emf.common.util.URI;

public class RepairAPIUtil {

	public static URI getDifferenceURI(URI modelA, URI modelB) {
		return URI.createURI(
				modelA.trimFileExtension().toString() + "_to_" +
				modelB.trimFileExtension().appendFileExtension(".symmetric").lastSegment());
	}
	
	public static URI getRecognitionRuleURI(URI editRule, String fileExtension) {
		return editRule.trimSegments(1).appendSegment("rr_" + editRule.lastSegment())
				.trimFileExtension().appendFileExtension(fileExtension);
	}
}
