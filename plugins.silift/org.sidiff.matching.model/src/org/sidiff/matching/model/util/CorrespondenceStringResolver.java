package org.sidiff.matching.model.util;


import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.util.StringResolver;
import org.sidiff.common.util.StringUtil;
import org.sidiff.matching.model.Correspondence;


/**
 * Erzeugt eine String-Repraesentation einer Correspondence
 */
public class CorrespondenceStringResolver implements StringResolver {

	@Override
	public Class<?> dedicatedClass() {

		return Correspondence.class;
	}

	@Override
	public String resolve(Object obj) {
		assert (obj instanceof Correspondence) : "Object not a Correspondence!";
		
		StringBuffer result = new StringBuffer();
		Correspondence corr = (Correspondence)obj;
		int depth = CorrespondenceModelStringUtil.computeDepth((EObject) obj);
		
		StringUtil.appendIndentation(result, depth, true);
		result.append("------Correspondence-----");
		
		StringUtil.appendIndentation(result, depth, true);
		result.append("Matched Nodes: ");
		CorrespondenceModelStringUtil.appendSomething(result, depth, corr.getMatchedA(), corr.getMatchedB());
		
		StringUtil.appendIndentation(result, depth, true);
		result.append("Containment Correspondences: ");
		CorrespondenceModelStringUtil.appendSomething(result, depth, corr.getContainmentCorrespondences());
			
		return result.toString();
	}
}
