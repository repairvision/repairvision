package org.sidiff.matching.model.util;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.util.StringResolver;
import org.sidiff.common.util.StringUtil;
import org.sidiff.matching.model.Matching;

/**
 * Erzeugt eine String-Repraesentation eines Matchings
 */
public class MatchingStringResolver implements StringResolver {

	@Override
	public Class<?> dedicatedClass() {

		return Matching.class;
	}

	@Override
	public String resolve(Object obj) {
		StringBuffer result = new StringBuffer();
		Matching matching = (Matching) obj;
		int depth = CorrespondenceModelStringUtil.computeDepth((EObject) obj);

		List<EObject> nodesA = EMFUtil.createListFromEAllContents(matching.getEResourceA());
		List<EObject> nodesB = EMFUtil.createListFromEAllContents(matching.getEResourceB());
		List<EObject> matchedA = new LinkedList<EObject>();
		List<EObject> matchedB = new LinkedList<EObject>();
		for (EObject eObject : nodesA) {
			if (!matching.getUnmatchedA().contains(eObject)) {
				matchedA.add(eObject);
			}
		}
		for (EObject eObject : nodesB) {
			if (!matching.getUnmatchedB().contains(eObject)) {
				matchedB.add(eObject);
			}
		}

		StringUtil.appendIndentation(result, depth, true);
		result.append("----------------------------------------------------------------------------------------------------");

		StringUtil.appendIndentation(result, depth, true);
		result.append("Begin of Matching between ");
		result.append(matching.getUriA());
		result.append(" and ");
		result.append(matching.getUriB());

		StringUtil.appendIndentation(result, depth, true);
		result.append("----------------------------------------------------------------------------------------------------");

		StringUtil.appendIndentation(result, depth, true);
		result.append("Unmatched nodes in A: ");
		CorrespondenceModelStringUtil.appendSomething(result, depth, matching.getUnmatchedA());
		StringUtil.appendIndentation(result, depth, true);

		StringUtil.appendIndentation(result, depth, true);
		result.append("Unmatched nodes in B: ");
		CorrespondenceModelStringUtil.appendSomething(result, depth, matching.getUnmatchedB());
		StringUtil.appendIndentation(result, depth, true);

		StringUtil.appendIndentation(result, depth, true);
		result.append("Matched nodes in A: ");
		CorrespondenceModelStringUtil.appendSomething(result, depth, matchedA);
		StringUtil.appendIndentation(result, depth, true);

		StringUtil.appendIndentation(result, depth, true);
		result.append("Matched nodes in B: ");
		CorrespondenceModelStringUtil.appendSomething(result, depth, matchedB);
		StringUtil.appendIndentation(result, depth, true);

		StringUtil.appendIndentation(result, depth, true);
		result.append("Correspondences: ");
		CorrespondenceModelStringUtil.appendSomething(result, depth, matching.getCorrespondences());

		StringUtil.appendIndentation(result, depth, true);
		result.append("----------------------------------------------------------------------------------------------------");
		StringUtil.appendIndentation(result, depth, true);
		result.append("End of Matching");
		StringUtil.appendIndentation(result, depth, true);
		result.append("----------------------------------------------------------------------------------------------------");

		return result.toString();
	}

}