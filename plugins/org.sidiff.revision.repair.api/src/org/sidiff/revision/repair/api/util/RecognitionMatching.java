package org.sidiff.revision.repair.api.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.common.utilities.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.common.utilities.java.JUtil;
import org.sidiff.revision.repair.api.IRepairPlan;

public class RecognitionMatching implements IMatching {

	private IRepairPlan repair;
	
	public RecognitionMatching(IRepairPlan repair) {
		this.repair = repair;
	}
	
	@Override
	public List<GraphElement> getChanges() {
		return repair.getRecognizedChanges();
	}
	
	@Override
	public Iterator<EObject> getMatches(Node node) {
		Node lhsNode = HenshinRuleAnalysisUtil.getLHS(node);
		
		if (lhsNode != null) {
			return repair.getRecognitionDomain(lhsNode).stream()
					.map(match -> match[1])
					.filter(match -> match != null)
					.iterator();
		}
		return JUtil.emptyIterator();
	}
}
