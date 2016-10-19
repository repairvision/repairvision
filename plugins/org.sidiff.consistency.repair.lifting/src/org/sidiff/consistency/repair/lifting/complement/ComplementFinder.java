package org.sidiff.consistency.repair.lifting.complement;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.sidiff.common.henshin.view.NodePair;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.matching.partial.NodeMatching;
import org.sidiff.consistency.graphpattern.matcher.matching.partial.PartialMatchGenerator;
import org.sidiff.consistency.repair.complement.construction.ComplementConstructor;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.context.ContextComplementConstructor;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;
import org.sidiff.consistency.repair.lifting.engine.partial.PartialLiftingEngine;
import org.sidiff.consistency.repair.lifting.engine.partial.PartialLiftingEngineFactory;
import org.sidiff.difference.lifting.edit2recognition.traces.TransformationPatterns;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricPackage;

/**
 * Tries to find all complementing operation for a given edit-rule and a model difference. 
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementFinder {

	/**
	 * The difference model types.
	 */
	private static final SymmetricPackage DIFFERENCE_MODEL = SymmetricPackage.eINSTANCE;

	/**
	 * The (Henshin) engine which applies the rules.
	 */
	private EngineImpl engine;

	/**
	 * The working graph, i.e. the actual version of the model.
	 */
	private EGraph graphModelB;

	/**
	 * The resource set which contains model A / B and the difference.
	 */
	private ResourceSet modelDifference;
	
	/**
	 * The difference between model A and B.
	 */
	private SymmetricDifference difference;

	/**
	 * Creates the matching engine.
	 */
	private PartialLiftingEngineFactory liftingEngineFactory = new PartialLiftingEngineFactory();

	/**
	 * @param modelAResource
	 *            The historic model.
	 * @param modelBResource
	 *            The actual model.
	 * @param difference
	 *            The difference between model A and B.
	 */
	public ComplementFinder(Resource modelAResource, Resource modelBResource, SymmetricDifference difference) {
		assert (modelAResource.getResourceSet() == modelBResource.getResourceSet()) 
		&& (modelBResource.getResourceSet() == difference.eResource().getResourceSet());
		
		this.difference = difference;
		this.graphModelB = new EGraphImpl(modelBResource);
		this.modelDifference = difference.eResource().getResourceSet();
		this.engine = new EngineImpl();
	}
	
	/**
	 * @param editRule
	 *            The partially executed edit-rule.
	 * @return All complementing operations for the given edit-rule.
	 */
	public List<ComplementRule> searchComplementRules(Rule editRule) {

		//// Edit to Recognition ////
		Edit2RecognitionRule edit2Recognition = new Edit2RecognitionRule(editRule);
		GraphPattern recognitionRule = edit2Recognition.getRecognitionRule();
		removeSymmetricDifferenceNode(recognitionRule);
		
		//// Lifting ////

		// Create working graph:
		PartialLiftingEngine matchingEngine = liftingEngineFactory.
				createPatternMatchingEngine(recognitionRule, modelDifference);
		matchingEngine.start();

		// TODO: Use IMatchGenerator interface!?
		//Matching:
		PartialMatchGenerator matchGenerator = matchingEngine.getMatchGenerator();

		//// Complement Construction ////
		ComplementConstructor complementConstructor = 
				new ContextComplementConstructor(editRule, engine, graphModelB);

		List<ComplementRule> complements = new ArrayList<>(); 

		// Find partially executed edit-operations:
		for (boolean matchFound = matchGenerator.findNextMatch(); matchFound; matchFound = matchGenerator.findNextMatch()) {
			
			// TODO: Matching-Engine -> Only partial matches:
			if (isPartialMatch(matchGenerator.getVariableMatching())) {
				
				// Translate: Create partial edit-rule match from recognition-rule match:
				List<EditRuleMatch> editRuleMatch = createEditRuleMatch(edit2Recognition, matchingEngine);
				
				// Store new complement rule:
				if (!editRuleMatch.isEmpty()) {
					ComplementRule complementRule = complementConstructor.createComplementRule(editRuleMatch);
					
					if (complementRule != null) {
						complements.add(complementRule);
					}
				}
			} 
			
//			else {
//				System.out.println("Full Match: " + matchGenerator);
//			}
		}
		
		// Clean up matching engine:
		matchingEngine.finish();

		//// Initialize the Complement Transformation Engine /////
		for (ComplementRule complementRule : complements) {
			complementRule.initialize(engine, graphModelB);
		}
		
		return complements;
	}
	
	private void removeSymmetricDifferenceNode(GraphPattern recognitionRule) {
		
		for (Iterator<NodePattern> iterator = recognitionRule.getNodes().iterator(); iterator.hasNext();) {
			NodePattern node = iterator.next();
			
			if (node.getType() == SymmetricPackage.eINSTANCE.getSymmetricDifference()) {
				iterator.remove();
			}
		}
	}

	private boolean isPartialMatch(Map<NodePattern, NodeMatching> matching) {
		for (NodeMatching match : matching.values()) {
			if (match.getMatch() == null) {
				return true;
			}
		}
		return false;
	}

	private List<EditRuleMatch> createEditRuleMatch(
			Edit2RecognitionRule edit2Recognition, 
			PartialLiftingEngine patternMatchingEngine) {

		Rule editRule = edit2Recognition.getEditRule();
		Map<Unit, TransformationPatterns> traceEdit2Recognition = edit2Recognition.getEdit2RecognitionTrace();
		Map<Node, NodePattern> traceHenshinToGraphPattern = edit2Recognition.getHenshinToGraphPatternTrace();
		
		Map<NodePattern, NodeMatching> variableMatching = patternMatchingEngine.getMatchGenerator().getVariableMatching();
//		Map<NodePattern, Set<EdgePattern>> localEvaluation = patternMatchingEngine.getWorkingGraphConstructor().getLocalEvaluation();
		
		// Create edit-operation match:
		List<EditRuleMatch> editRuleMatch = new ArrayList<>();

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

			EObject deleted = getDeletedObject(rrNodePatternA, variableMatching);

			if (deleted != null) {
				EditRuleNodeSingleMatch deleteMatch = new EditRuleNodeSingleMatch(Type.DELETE, eoHenshinNode);
				deleteMatch.setModelBElement(deleted);
				editRuleMatch.add(deleteMatch);
			}
		}

		// EO-Create-Nodes:
		for (Node eoHenshinNode : getRHSMinusLHSNodes(editRule)) {
			NodePair rrHenshinNodeB = traceEdit2Recognition.get(editRule).getTraceB(eoHenshinNode);
			NodePattern rrNodePatternB = traceHenshinToGraphPattern.get(rrHenshinNodeB.getLhsNode());

			EObject created = getCreatedObject(rrNodePatternB, variableMatching);

			if (created != null) {
				EditRuleNodeSingleMatch createMatch = new EditRuleNodeSingleMatch(Type.CREATE, eoHenshinNode);
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
					src_rrNodePatternA, tgt_rrNodePatternA, variableMatching);

			if (deleted != null) {
				EditRuleEdgeMatch deleteMatch = new EditRuleEdgeMatch(Type.DELETE, eoHenshinEdge);
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
					src_rrNodePatternB, tgt_rrNodePatternB, variableMatching);
			
			if (created != null) {
				EditRuleEdgeMatch createMatch = new EditRuleEdgeMatch(Type.CREATE, eoHenshinEdge);
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
			Map<NodePattern, NodeMatching> changes) {

		EObject[] srcAndTgtMatch = null;

		for (NodePattern changeNode : changes.keySet()) {
			if (changeNode.getType() == DIFFERENCE_MODEL.getAddReference()) {
				AddReference change = (AddReference) changes.get(changeNode).getMatch();

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
			Map<NodePattern, NodeMatching> changes) {

		EObject[] srcAndTgtMatch = null;

		for (NodePattern changeNode : changes.keySet()) {
			if (changeNode.getType() == DIFFERENCE_MODEL.getRemoveReference()) {
				RemoveReference change = (RemoveReference) changes.get(changeNode).getMatch();

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

	private EObject getCreatedObject(NodePattern rrNodePatternA, Map<NodePattern, NodeMatching> changes) {
		NodePattern createObjectNode = rrNodePatternA.getIncoming(DIFFERENCE_MODEL.getAddObject_Obj()).getSource();
		AddObject change = (AddObject) changes.get(createObjectNode).getMatch();

		if (change != null) {
			return change.getObj();
		} else {
			return null;
		}
	}

	private EObject getDeletedObject(NodePattern rrNodePatternB, Map<NodePattern, NodeMatching> changes) {
		NodePattern removeObjectNode = rrNodePatternB.getIncoming(DIFFERENCE_MODEL.getRemoveObject_Obj()).getSource();
		RemoveObject change = (RemoveObject) changes.get(removeObjectNode).getMatch();

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