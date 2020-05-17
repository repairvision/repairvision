package org.sidiff.revision.repair.api.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.utilities.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.common.utilities.java.JUtil;
import org.sidiff.revision.repair.api.IRepairPlan;

public class ComplementMatching implements IMatching {

	private IRepairPlan repair;
	
	public ComplementMatching(IRepairPlan repair) {
		this.repair = repair;
	}
	
	@Override
	public List<GraphElement> getChanges() {
		return repair.getComplementingChanges();
	}
	
	@Override
	public Iterator<EObject> getMatches(Node node) {
		Node lhsNode = HenshinRuleAnalysisUtil.getLHS(node);
		
		if (lhsNode != null) {
			return repair.getComplementDomain(lhsNode).stream()
					.filter(match -> match != null)
					.iterator();
		}
		return JUtil.emptyIterator();
	}
}
