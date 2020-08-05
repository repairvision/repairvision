package org.sidiff.revision.editrules.recognition.match;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.editrules.impact.util.GraphMatching;

public class RecognitionMatching extends ArrayList<RecognitionMatch> implements GraphMatching {

	private static final long serialVersionUID = 1L;

	private List<Change> changeSet;
	
	public RecognitionMatching(List<Change> changeSet) {
		this.changeSet = changeSet;
	}

	public List<Change> getChangeSet() {
		return changeSet;
	}
	
	@Override
	public EObject getMatch(Node node) {
		for (RecognitionMatch match : this) {
			if (match instanceof RecognitionNodeSingleMatch) {
				if (((RecognitionNodeSingleMatch) match).getNode() == node) {
					return ((RecognitionNodeSingleMatch) match).getModelBElement();
				}
			} else if (match instanceof RecognitionEdgeMatch) {
				Edge edge = ((RecognitionEdgeMatch) match).getEdge();
				
				if (HenshinRuleAnalysisUtil.tryLHS(edge.getSource()) == node) {
					return ((RecognitionEdgeMatch) match).getSrcModelBElement();
				} else if (HenshinRuleAnalysisUtil.tryLHS(edge.getTarget()) == node) {
					return ((RecognitionEdgeMatch) match).getTgtModelBElement();
				}
			} else if (match instanceof RecognitionAttributeMatch) {
				Attribute attribute = ((RecognitionAttributeMatch) match).getAttribute();
				
				if (HenshinRuleAnalysisUtil.tryLHS(attribute.getNode()) == node) {
					return ((RecognitionAttributeMatch) match).getObject();
				}
			}
		}
		return null;
	}
}
