package org.sidiff.repair.complement.peo.finder;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.Action.Type;
import org.sidiff.common.henshin.view.NodePair;
import org.sidiff.difference.lifting.edit2recognition.traces.TransformationPatterns;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matching.IMatching;
import org.sidiff.repair.api.matching.EOEdgeMatch;
import org.sidiff.repair.api.matching.EOMatch;
import org.sidiff.repair.api.matching.EONodeSingleMatch;

public class Edit2RecognitionMatch {

	/**
	 * The difference model types.
	 */
	private static final SymmetricPackage DIFFERENCE_MODEL = SymmetricPackage.eINSTANCE;
	
	/**
	 * The difference between model A and B.
	 */
	private SymmetricDifference difference;
	
	public Edit2RecognitionMatch(SymmetricDifference difference) {
		this.difference = difference;
	}
	
	public List<EOMatch> createEditRuleMatch(
			Edit2RecognitionRule edit2Recognition, 
			IMatching matching) {

		Rule editRule = edit2Recognition.getEditRule();
		Map<Unit, TransformationPatterns> traceEdit2Recognition = edit2Recognition.getEdit2RecognitionTrace();
		Map<Node, NodePattern> traceHenshinToGraphPattern = edit2Recognition.getHenshinToGraphPatternTrace();
		
//		Map<NodePattern, NodeMatching> variableMatching = patternMatchingEngine.getMatchGenerator().getVariableMatching();
//		Map<NodePattern, Set<EdgePattern>> localEvaluation = patternMatchingEngine.getWorkingGraphConstructor().getLocalEvaluation();
		
		// Create edit-operation match:
		List<EOMatch> editRuleMatch = new ArrayList<>();

//		// TODO: EO-Preserve-Nodes:
//		for (Node eoHenshinNode : getLHSIntersectRHSNodes(editRule)) {
//			CorrespondencePattern correspondencePattern = traceEdit2Recognition.get(editRule)
//					.getCorrespondecePattern(eoHenshinNode);
//			
//			if (correspondencePattern.getNodeB() != null) {
//				NodePair rrHenshinNodeB = correspondencePattern.getNodeB();
//				NodePattern rrNodePatternB = traceHenshinToGraphPattern.get(rrHenshinNodeB.getLhsNode());
//
//				// TODO: Check if the node is in the local evaluation graph of at least one assigned variable node?
//				if (evaluated.contains(rrNodePatternB)) {
//					List<EObject> match = getMatch(rrNodePatternB);
//
//					if (!match.isEmpty()) {
//						editRuleMatch.add(createEditRuleNodeMatch(eoHenshinNode, match, Type.PRESERVE));
//					}
//				}
//			} else {
//				NodePair rrHenshinNodeA = correspondencePattern.getNodeA();
//				NodePattern rrNodePatternA = traceHenshinToGraphPattern.get(rrHenshinNodeA.getLhsNode());
//
//				// TODO: Check if the node is in the local evaluation graph of at least one assigned variable node?
//				if (evaluated.contains(rrNodePatternA)) {
//					List<EObject> matchA = getMatch(rrNodePatternA);
//					List<EObject> matchB = getMatch(rrNodePatternA);
//
//					// Transfer the matches from model A to B:
//					for (EObject modelAObj : matchA) {
//						EObject modelBObj = difference.getCorrespondingObjectInB(modelAObj);
//
//						if (modelBObj != null) {
//							matchB.add(modelBObj);
//						}
//					}
//					
//					if (!matchB.isEmpty()) {
//						editRuleMatch.add(createEditRuleNodeMatch(eoHenshinNode, matchB, Type.PRESERVE));
//					} else {
//						// TODO: The context might have been deleted in model B!
//					}
//				}
//			}
//		}

		// EO-Delete-Nodes:
		for (Node eoHenshinNode : getLHSMinusRHSNodes(editRule)) {
			NodePair rrHenshinNodeA = traceEdit2Recognition.get(editRule).getTraceA(eoHenshinNode);
			NodePattern rrNodePatternA = traceHenshinToGraphPattern.get(rrHenshinNodeA.getLhsNode());

			EObject deleted = getDeletedObject(rrNodePatternA, matching);

			if (deleted != null) {
				EONodeSingleMatch deleteMatch = new EONodeSingleMatch(Type.DELETE, eoHenshinNode);
				deleteMatch.setModelBElement(deleted);
				editRuleMatch.add(deleteMatch);
			}
		}

		// EO-Create-Nodes:
		for (Node eoHenshinNode : getRHSMinusLHSNodes(editRule)) {
			NodePair rrHenshinNodeB = traceEdit2Recognition.get(editRule).getTraceB(eoHenshinNode);
			NodePattern rrNodePatternB = traceHenshinToGraphPattern.get(rrHenshinNodeB.getLhsNode());

			EObject created = getCreatedObject(rrNodePatternB, matching);

			if (created != null) {
				EONodeSingleMatch createMatch = new EONodeSingleMatch(Type.CREATE, eoHenshinNode);
				createMatch.setModelBElement(created);
				editRuleMatch.add(createMatch);
			}
		}

		// EO-Delete-Edges:
		for (Edge eoHenshinEdge : getLHSMinusRHSEdges(editRule)) {
			NodePair src_rrHenshinNodeA = traceEdit2Recognition.get(editRule).getTraceA(eoHenshinEdge.getSource());
			NodePair tgt_rrHenshinNodeA = traceEdit2Recognition.get(editRule).getTraceA(eoHenshinEdge.getTarget());

			NodePattern src_rrNodePatternA = traceHenshinToGraphPattern.get(src_rrHenshinNodeA.getLhsNode());
			NodePattern tgt_rrNodePatternA = traceHenshinToGraphPattern.get(tgt_rrHenshinNodeA.getLhsNode());

			EObject[] deleted = getRemovedReference(eoHenshinEdge.getType(),
					src_rrNodePatternA, tgt_rrNodePatternA, matching);

			if (deleted != null) {
				EOEdgeMatch deleteMatch = new EOEdgeMatch(Type.DELETE, eoHenshinEdge);
				deleteMatch.setSrcModelAElement(deleted[0]);
				deleteMatch.setTgtModelAElement(deleted[1]);
				editRuleMatch.add(deleteMatch);
				
				// Transfer context to model B if possible:
				// NOTE: The context might have been deleted in model B!
				deleteMatch.setSrcModelBElement(difference.getCorrespondingObjectInB(deleted[0]));
				deleteMatch.setTgtModelBElement(difference.getCorrespondingObjectInB(deleted[1]));
			}
		}

		// EO-Create-Edges:
		for (Edge eoHenshinEdge : getRHSMinusLHSEdges(editRule)) {
			NodePair src_rrHenshinNodeB = traceEdit2Recognition.get(editRule).getTraceB(eoHenshinEdge.getSource());
			NodePair tgt_rrHenshinNodeB = traceEdit2Recognition.get(editRule).getTraceB(eoHenshinEdge.getTarget());

			NodePattern src_rrNodePatternB = traceHenshinToGraphPattern.get(src_rrHenshinNodeB.getLhsNode());
			NodePattern tgt_rrNodePatternB = traceHenshinToGraphPattern.get(tgt_rrHenshinNodeB.getLhsNode());

			EObject[] created = getCreateReference(eoHenshinEdge.getType(),
					src_rrNodePatternB, tgt_rrNodePatternB, matching);
			
			if (created != null) {
				EOEdgeMatch createMatch = new EOEdgeMatch(Type.CREATE, eoHenshinEdge);
				createMatch.setSrcModelBElement(created[0]);
				createMatch.setTgtModelBElement(created[1]);
				editRuleMatch.add(createMatch);
				
				// Transfer context to model A if possible:
				// NOTE: The context might have been first created in model B!
				createMatch.setSrcModelAElement(difference.getCorrespondingObjectInA(created[0]));
				createMatch.setTgtModelAElement(difference.getCorrespondingObjectInA(created[1]));
			}
		}
		
		return editRuleMatch;
	}

	private EObject[] getCreateReference(EReference type,
			NodePattern src_rrNodePatternA, NodePattern tgt_rrNodePatternA,
			IMatching matching) {

		EObject[] srcAndTgtMatch = null;

		for (NodePattern changeNode : matching.getNodes()) {
			if (changeNode.getType() == DIFFERENCE_MODEL.getAddReference()) {
				AddReference change = (AddReference) matching.getFirstMatch(changeNode);

				if ((change != null) && (change.getType() == type)) {
					NodePattern src = changeNode.getOutgoing(DIFFERENCE_MODEL.getAddReference_Src()).getTarget();
					NodePattern tgt = changeNode.getOutgoing(DIFFERENCE_MODEL.getAddReference_Tgt()).getTarget();

					if ((src == src_rrNodePatternA) && (tgt == tgt_rrNodePatternA)) {
						srcAndTgtMatch = new EObject[2];
						srcAndTgtMatch[0] = change.getSrc();
						srcAndTgtMatch[1] = change.getTgt();
					}
				}
			}
		}

		return srcAndTgtMatch;
	}

	private EObject[] getRemovedReference(EReference type,
			NodePattern src_rrNodePatternB, NodePattern tgt_rrNodePatternB,
			IMatching matching) {

		EObject[] srcAndTgtMatch = null;

		for (NodePattern changeNode : matching.getNodes()) {
			if (changeNode.getType() == DIFFERENCE_MODEL.getRemoveReference()) {
				RemoveReference change = (RemoveReference) matching.getFirstMatch(changeNode);

				if ((change != null) && (change.getType() == type)) {
					NodePattern src = changeNode.getOutgoing(DIFFERENCE_MODEL.getRemoveReference_Src()).getTarget();
					NodePattern tgt = changeNode.getOutgoing(DIFFERENCE_MODEL.getRemoveReference_Tgt()).getTarget();

					if ((src == src_rrNodePatternB) && (tgt == tgt_rrNodePatternB)) {
						srcAndTgtMatch = new EObject[2];
						srcAndTgtMatch[0] = change.getSrc();
						srcAndTgtMatch[1] = change.getTgt();
					}
				}
			}
		}

		return srcAndTgtMatch;
	}

	private EObject getCreatedObject(NodePattern rrNodePatternA, IMatching matching) {
		NodePattern createObjectNode = rrNodePatternA.getIncoming(DIFFERENCE_MODEL.getAddObject_Obj()).getSource();
		AddObject change = (AddObject) matching.getFirstMatch(createObjectNode);

		if (change != null) {
			return change.getObj();
		} else {
			return null;
		}
	}

	private EObject getDeletedObject(NodePattern rrNodePatternB, IMatching matching) {
		NodePattern removeObjectNode = rrNodePatternB.getIncoming(DIFFERENCE_MODEL.getRemoveObject_Obj()).getSource();
		RemoveObject change = (RemoveObject) matching.getFirstMatch(removeObjectNode);

		if (change != null) {
			return change.getObj();
		} else {
			return null;
		}
	}

//	private EditRuleNodeMatch createEditRuleNodeMatch(Node node, List<EObject> match, Type type) {
//		EditRuleNodeMatch nodeMatch;
//
//		if (match.size() == 1) {
//			nodeMatch = new EditRuleNodeSingleMatch(node, type, match.get(0));
//		} else {
//			nodeMatch = new EditRuleNodeMultiMatch(node, type, match);
//		}
//
//		return nodeMatch;
//	}
}
