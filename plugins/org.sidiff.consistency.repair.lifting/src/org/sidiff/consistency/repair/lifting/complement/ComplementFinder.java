package org.sidiff.consistency.repair.lifting.complement;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSIntersectRHSNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes;
import static org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper.getDataStore;

import java.util.ArrayList;
import java.util.Collection;
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
import org.sidiff.consistency.graphpattern.matcher.IPatternMatchingEngine;
import org.sidiff.consistency.graphpattern.matcher.data.selection.MatchSelection;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.MatchGenerator;
import org.sidiff.consistency.graphpattern.matcher.matching.NodeMatching;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.IAtomicPatternFactory;
import org.sidiff.consistency.repair.complement.construction.ComplementConstructor;
import org.sidiff.consistency.repair.complement.construction.ComplementConstructorCompleteContext;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeCreateMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeDeleteMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMultiMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;
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

		//// Lifting ////

		// Create working graph:
		IPatternMatchingEngine matchingEngine = 
				liftingEngineFactory.createPatternMatchingEngine(recognitionRule, modelDifference);

		matchingEngine.start();

		// Matching:
		IAtomicPatternFactory atomicPatternFactory = matchingEngine.createAtomicPatternFactory();
		IMatchValidation matchValidation = matchingEngine.createMatchValidation();
		List<NodePattern> variableNodes = matchingEngine.getVariableNodes();

		MatchGenerator matchGenerator = new MatchGenerator(
				recognitionRule.getNodes(), variableNodes, atomicPatternFactory, matchValidation);

		//// Complement Construction ////
		ComplementConstructor complementConstructor = 
				new ComplementConstructorCompleteContext(editRule, engine, graphModelB);

		List<ComplementRule> complements = new ArrayList<>(); 

		// Find partially executed edit-operations:
		for (boolean matchFound = matchGenerator.findNextMatch(); matchFound; matchFound = matchGenerator.findNextMatch()) {

			// Translate: Create partial edit-rule match from recognition-rule match:
			Collection<EditRuleMatch> editRuleMatch = createEditRuleMatch(edit2Recognition, matchGenerator);

			// Store new complement rule:
			complements.add(complementConstructor.createComplementRule(editRuleMatch));
		}
		
		//// Initialize the Complement Transformation Engine /////
		for (ComplementRule complementRule : complements) {
			complementRule.initialize(engine, graphModelB);
		}
		
		return complements;
	}

	private Collection<EditRuleMatch> createEditRuleMatch(
			Edit2RecognitionRule edit2Recognition, MatchGenerator matchGenerator) {

		Rule editRule = edit2Recognition.getEditRule();
		Map<Unit, TransformationPatterns> traceEdit2Recognition = edit2Recognition.getEdit2RecognitionTrace();
		Map<Node, NodePattern> traceHenshinToGraphPattern = edit2Recognition.getHenshinToGraphPatternTrace();
		
		// Create edit-operation match:
		Collection<EditRuleMatch> editRuleMatch = new ArrayList<>();

		// EO-Preserve-Nodes:
		for (Node eoHenshinNode : getLHSIntersectRHSNodes(editRule)) {
			NodePair rrHenshinNodeB = traceEdit2Recognition.get(editRule).getTraceB(eoHenshinNode);
			NodePattern rrNodePatternB = traceHenshinToGraphPattern.get(rrHenshinNodeB.getLhsNode());

			List<EObject> match = getMatch(rrNodePatternB);

			if (!match.isEmpty()) {
				editRuleMatch.add(createEditRuleNodeMatch(eoHenshinNode, match, Type.PRESERVE));
			}
		}

		// EO-Delete-Nodes:
		for (Node eoHenshinNode : getLHSMinusRHSNodes(editRule)) {
			NodePair rrHenshinNodeA = traceEdit2Recognition.get(editRule).getTraceA(eoHenshinNode);
			NodePattern rrNodePatternA = traceHenshinToGraphPattern.get(rrHenshinNodeA.getLhsNode());

			EObject deleted = getDeletedObject(rrNodePatternA, matchGenerator.getVariableMatching());

			if (deleted != null) {
				editRuleMatch.add(createEditRuleNodeMatch(eoHenshinNode, deleted, Type.DELETE));
			}
		}

		// EO-Create-Nodes:
		for (Node eoHenshinNode : getRHSMinusLHSNodes(editRule)) {
			NodePair rrHenshinNodeB = traceEdit2Recognition.get(editRule).getTraceB(eoHenshinNode);
			NodePattern rrNodePatternB = traceHenshinToGraphPattern.get(rrHenshinNodeB.getLhsNode());

			EObject created = getCreatedObject(rrNodePatternB, matchGenerator.getVariableMatching());

			if (created != null) {
				editRuleMatch.add(createEditRuleNodeMatch(eoHenshinNode, created, Type.CREATE));
			}
		}

		// EO-Delete-Edges:
		for (Edge eoHenshinEdge : getLHSMinusRHSEdges(editRule)) {
			NodePair src_rrHenshinNodeA = traceEdit2Recognition.get(editRule).getTraceA(eoHenshinEdge.getSource());
			NodePair tgt_rrHenshinNodeA = traceEdit2Recognition.get(editRule).getTraceA(eoHenshinEdge.getTarget());

			NodePattern src_rrNodePatternA = traceHenshinToGraphPattern.get(src_rrHenshinNodeA.getLhsNode());
			NodePattern tgt_rrNodePatternA = traceHenshinToGraphPattern.get(tgt_rrHenshinNodeA.getLhsNode());

			EObject[] deleted = getRemovedReference(eoHenshinEdge.getType(),
					src_rrNodePatternA, tgt_rrNodePatternA, matchGenerator.getVariableMatching());

			if (deleted != null) {
				editRuleMatch.add(new EditRuleEdgeDeleteMatch(eoHenshinEdge, deleted[0], deleted[1]));
			}
		}

		// EO-Create-Edges:
		for (Edge eoHenshinEdge : getRHSMinusLHSEdges(editRule)) {
			NodePair src_rrHenshinNodeB = traceEdit2Recognition.get(editRule).getTraceB(eoHenshinEdge.getSource());
			NodePair tgt_rrHenshinNodeB = traceEdit2Recognition.get(editRule).getTraceB(eoHenshinEdge.getTarget());

			NodePattern src_rrNodePatternB = traceHenshinToGraphPattern.get(src_rrHenshinNodeB.getLhsNode());
			NodePattern tgt_rrNodePatternB = traceHenshinToGraphPattern.get(tgt_rrHenshinNodeB.getLhsNode());

			EObject[] created = getCreateReference(eoHenshinEdge.getType(),
					src_rrNodePatternB, tgt_rrNodePatternB, matchGenerator.getVariableMatching());

			if (created != null) {
				editRuleMatch.add(new EditRuleEdgeCreateMatch(eoHenshinEdge, created[0], created[1]));
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

	private List<EObject> getMatch(NodePattern node) {
		MatchSelection selection = getDataStore(node).getMatchSelection();
		return selection.getMatch();
	}

	private EditRuleNodeMatch createEditRuleNodeMatch(Node node, EObject match, Type type) {
		return new EditRuleNodeSingleMatch(node, type, match);
	}

	private EditRuleNodeMatch createEditRuleNodeMatch(Node node, List<EObject> match, Type type) {
		EditRuleNodeMatch nodeMatch;

		if (match.size() == 1) {
			nodeMatch = new EditRuleNodeSingleMatch(node, type, match.get(0));
		} else {
			nodeMatch = new EditRuleNodeMultiMatch(node, type, match);
		}

		return nodeMatch;
	}
}