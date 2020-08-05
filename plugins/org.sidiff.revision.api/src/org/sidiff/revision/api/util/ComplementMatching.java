package org.sidiff.revision.api.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.revision.api.ComplementationPlan;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.common.utilities.java.JUtil;

public class ComplementMatching implements IMatching {

	private ComplementationPlan complementationPlan;
	
	public ComplementMatching(ComplementationPlan complementationPlan) {
		this.complementationPlan = complementationPlan;
	}
	
	@Override
	public List<GraphElement> getChanges() {
		return complementationPlan.getComplementingChanges();
	}
	
	@Override
	public Iterator<EObject> getMatches(Node node) {
		Node lhsNode = HenshinRuleAnalysisUtil.getLHS(node);
		
		if (lhsNode != null) {
			return complementationPlan.getComplementDomain(lhsNode).stream()
					.filter(match -> match != null)
					.iterator();
		}
		return JUtil.emptyIterator();
	}
}
