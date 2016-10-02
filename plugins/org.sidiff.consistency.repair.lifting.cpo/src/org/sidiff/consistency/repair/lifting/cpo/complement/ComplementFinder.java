package org.sidiff.consistency.repair.lifting.cpo.complement;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isPreservedNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.cpo.CPOComplementConstructor;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeCreateMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeDeleteMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;
import org.sidiff.difference.lifting.recognitionengine.IRecognitionEngine;
import org.sidiff.difference.rulebase.RecognitionRule;
import org.sidiff.difference.rulebase.Trace;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.rulebase.EditRule;
import org.sidiff.editrule.rulebase.RuleBaseItem;

public class ComplementFinder {
	
	/**
	 * The (Henshin) engine which applies the rules.
	 */
	private EngineImpl engine;

	/**
	 * The working graph, i.e. the actual version of the model.
	 */
	private EGraph graphModelB;

	private IRecognitionEngine recognitionEngine;
	
	private ILiftingRuleBase rulebase;
	
	private Collection<Rule> subEditRules;
	
	private Collection<Rule> sourceEditRules;
	
	private SymmetricDifference difference;
	
	private Map<Rule, Collection<ComplementRule>> complements = new HashMap<>();

	public ComplementFinder(
			IRecognitionEngine recognitionEngine,
			ILiftingRuleBase rulebase,
			Collection<Rule> subEditRules, 
			Collection<Rule> sourceEditRules,
			SymmetricDifference difference) {
		
		this.recognitionEngine = recognitionEngine;
		this.rulebase = rulebase;
		this.subEditRules = subEditRules;
		this.sourceEditRules = sourceEditRules;
		this.difference = difference;
		
		this.graphModelB = new EGraphImpl(difference.getModelB());
		this.engine = new EngineImpl();
		
		calculateComplementRules();
	}
	
	private void calculateComplementRules() {
		
		// Get mappings: SCS -> RR + Match -> EO
		Set<RuleApplication> ruleApplications = recognitionEngine.getRecognitionRuleApplications();
		Map<SemanticChangeSet, RuleApplication>  recognitionMatches = getRecognitionMatches(ruleApplications);
		Map<Rule, EditRule> recognition2editRules = getRecognition2EditRules();
		
		for (SemanticChangeSet scs : difference.getChangeSets()) {
			
			RuleApplication subRRApplication = recognitionMatches.get(scs);
			Rule subRRUnit = subRRApplication.getRule();
			Match subRRMatch = subRRApplication.getCompleteMatch();
			
			EditRule subEditRule = recognition2editRules.get(subRRUnit);
			Rule subEOUnit = (Rule) subEditRule.getExecuteMainUnit().getSubUnits(false).get(0);
			
			// Is sub-rule (source-rule otherwise)
			if (subEditRules.contains(subEOUnit)) {
				
				// Translate recognition to edit rule matching:
				List<EditRuleMatch> subEOMatch = createEditRuleMatch(subEditRule, subEOUnit, subRRMatch);
				
				// TODO[Precalculate]: Find corresponding source rule:
				for (Rule sourceEditRule : sourceEditRules) {
					CPOComplementConstructor complementConstructor = new CPOComplementConstructor(
							sourceEditRule, engine, graphModelB);

					Collection<ComplementRule> newSourceComplements = complementConstructor
							.createComplementRule(subEOUnit, subEOMatch);

					if ((newSourceComplements != null) && (!newSourceComplements.isEmpty())) {
						Collection<ComplementRule> sourceComplements = complements.get(sourceEditRule);

						if (sourceComplements == null) {
							sourceComplements = new ArrayList<>();
						}

						sourceComplements.addAll(newSourceComplements);
						complements.put(sourceEditRule, sourceComplements);
					}
				}
			}
		}
	}
	
	private List<EditRuleMatch> createEditRuleMatch(EditRule editRule, Rule editRuleUnit, Match rrMatch) {
		// NOTE: Since this is complete match we can derive the edge matchings from the node matchings!
		
		// Create edit-operation match:
		List<EditRuleMatch> editRuleMatch = new ArrayList<>();
		Set<Node> donePreserveNodes = new HashSet<>();
		
		Map<Node, Node> eo2rrTraceA = getEdit2RecognitionTraceA(editRule);
		Map<Node, Node> eo2rrTraceB = getEdit2RecognitionTraceB(editRule);
		
		for (Trace trace : editRule.getEditRuleAttachment(RecognitionRule.class).getTracesA()) {
			Node editRuleNode = trace.getEditRuleTrace();
			
			// EO-Delete-Nodes:
			if (isDeletionNode(editRuleNode)) {
				createDeleteNodeMatch(editRuleMatch, editRuleNode, rrMatch, eo2rrTraceA, eo2rrTraceB);
			}
			
			// EO-Preserve-Nodes:
			else if (isPreservedNode(editRuleNode)) {
				createPreserveNodeMatch(editRuleMatch, editRuleNode, rrMatch, eo2rrTraceA, eo2rrTraceB);
				donePreserveNodes.add(editRuleNode);
			}
		}
		
		for (Trace trace : editRule.getEditRuleAttachment(RecognitionRule.class).getTracesB()) {
			Node editRuleNode = trace.getEditRuleTrace();
			
			// EO-Create-Nodes:
			if (isCreationNode(editRuleNode)) {
				createCreateNodeMatch(editRuleMatch, editRuleNode, rrMatch, eo2rrTraceA, eo2rrTraceB);
			}
			
			// EO-Preserve-Nodes:
			else if (!donePreserveNodes.contains(editRuleNode) && isPreservedNode(editRuleNode)) {
				createPreserveNodeMatch(editRuleMatch, editRuleNode, rrMatch, eo2rrTraceA, eo2rrTraceB);
			}
		}
		
		return editRuleMatch;
	}
	
	private Map<Node, Node> getEdit2RecognitionTraceA(EditRule editRule) {
		Map<Node, Node> trace = new HashMap<>();
		
		for (Trace traceA : editRule.getEditRuleAttachment(RecognitionRule.class).getTracesA()) {
			trace.put(traceA.getEditRuleTrace(), traceA.getRecognitionRuleTrace());
		}
		
		return trace;
	}
	
	
	private Map<Node, Node> getEdit2RecognitionTraceB(EditRule editRule) {
		Map<Node, Node> trace = new HashMap<>();
		
		for (Trace traceB : editRule.getEditRuleAttachment(RecognitionRule.class).getTracesB()) {
			trace.put(traceB.getEditRuleTrace(), traceB.getRecognitionRuleTrace());
		}
		
		return trace;
	}
	
	private void createDeleteNodeMatch(
			List<EditRuleMatch> eoMatch, Node eoNode, 
			Match rrMatch, Map<Node, Node> eo2rrTraceA, Map<Node, Node> eo2rrTraceB) {
		
		EObject matchA = rrMatch.getNodeTarget(eo2rrTraceA.get(eoNode));
		eoMatch.add(new EditRuleNodeSingleMatch(eoNode, Type.DELETE, matchA));
		
		// EO-Delete-Edges:
		for (Edge outgoing : eoNode.getOutgoing()) {
			EditRuleEdgeDeleteMatch eoEdgeMatch = createDeleteEdgeMatch(rrMatch, outgoing, eo2rrTraceA);
			
			if (eoEdgeMatch != null) {
				eoMatch.add(eoEdgeMatch);
			}
		}
	}
	
	private EditRuleEdgeDeleteMatch createDeleteEdgeMatch(Match rrMatch, Edge eoEdge, Map<Node, Node> eo2rrTraceA) {
		EObject srcMatchA = rrMatch.getNodeTarget(eo2rrTraceA.get(eoEdge.getSource()));
		EObject tgtMatchA = rrMatch.getNodeTarget(eo2rrTraceA.get(eoEdge.getTarget()));
		
		EObject srcMatchB = difference.getCorrespondingObjectInB(srcMatchA);
		EObject tgtMatchB = difference.getCorrespondingObjectInB(tgtMatchA);

		// NOTE: The context might have been deleted in model B!
		// srcMatchB == null and/or tgtMatchB == null
		return new EditRuleEdgeDeleteMatch(eoEdge, srcMatchB, tgtMatchB);
	}
	
	private void createCreateNodeMatch(
			List<EditRuleMatch> eoMatch, Node eoNode, 
			Match rrMatch, Map<Node, Node> eo2rrTraceA, Map<Node, Node> eo2rrTraceB) {
		
		EObject matchB = rrMatch.getNodeTarget(eo2rrTraceB.get(eoNode));
		eoMatch.add(new EditRuleNodeSingleMatch(eoNode, Type.CREATE, matchB));
		
		// EO-Create-Edges:
		for (Edge outgoing : eoNode.getOutgoing()) {
			EditRuleEdgeCreateMatch eoEdgeMatch = createCreateEdgeMatch(rrMatch, outgoing, eo2rrTraceB);
			
			if (eoEdgeMatch != null) {
				eoMatch.add(eoEdgeMatch);
			}
		}
	}
	
	private EditRuleEdgeCreateMatch createCreateEdgeMatch(Match rrMatch, Edge eoEdge, Map<Node, Node> eo2rrTraceB) {
		EObject srcMatchB = rrMatch.getNodeTarget(eo2rrTraceB.get(tryLHS(eoEdge.getSource())));
		EObject tgtMatchB = rrMatch.getNodeTarget(eo2rrTraceB.get(tryLHS(eoEdge.getTarget())));
		
		return new EditRuleEdgeCreateMatch(eoEdge, srcMatchB, tgtMatchB);
	}
	
	private Node tryLHS(Node node) {
		Node lhs = getLHS(node);
		
		if (lhs != null) {
			return lhs;
		} else {
			return node;
		}
	}
	
	private void createPreserveNodeMatch(
			List<EditRuleMatch> eoMatch, Node eoNode, 
			Match rrMatch, Map<Node, Node> eo2rrTraceA, Map<Node, Node> eo2rrTraceB) {
		
		// NOTE: The trace of a preserve node is (normally) be saved as LHS node trace.
		
		EObject matchB = null;
		
		if (eo2rrTraceB.containsKey(eoNode)) {
			matchB = rrMatch.getNodeTarget(eo2rrTraceB.get(eoNode));
		} else {
			EObject matchA = rrMatch.getNodeTarget(eo2rrTraceA.get(eoNode));
			matchB = difference.getCorrespondingObjectInB(matchA);
		}
		
		if (matchB != null) {
			eoMatch.add(new EditRuleNodeSingleMatch(eoNode, Type.PRESERVE, matchB));
		}
		
		for (Edge outgoingLHS : getLHS(eoNode).getOutgoing()) {
			// EO-Delete-Edges:
			if (isDeletionEdge(outgoingLHS)) {
				EditRuleEdgeDeleteMatch eoEdgeMatch = createDeleteEdgeMatch(rrMatch, outgoingLHS, eo2rrTraceA);
				
				if (eoEdgeMatch != null) {
					eoMatch.add(eoEdgeMatch);
				}
			}
		}
		
		for (Edge outgoingRHS : getRHS(eoNode).getOutgoing()) {
			// EO-Create-Edges:
			if (isCreationEdge(outgoingRHS)) {
				EditRuleEdgeCreateMatch eoEdgeMatch = createCreateEdgeMatch(rrMatch, outgoingRHS, eo2rrTraceB);
				
				if (eoEdgeMatch != null) {
					eoMatch.add(eoEdgeMatch);
				}
			}
		}
	}
	
	/**
	 * @return Recognition-Rule -> Edit-Rules
	 */
	private Map<Rule, EditRule> getRecognition2EditRules() {
		Map<Rule, EditRule> editRules = new HashMap<>();
		
		for (RuleBaseItem item : rulebase.getRuleBase().getItems()) {
			editRules.put((Rule) item.getEditRuleAttachment(
					RecognitionRule.class).getRecognitionMainUnit(),
					item.getEditRule());
		}
		
		return editRules;
	}
	
	private Map<SemanticChangeSet, RuleApplication> getRecognitionMatches(
			Collection<RuleApplication> ruleApplications) {
		
		Map<SemanticChangeSet, RuleApplication> rrMatches = new HashMap<>();
		
		for (RuleApplication ruleApplication : ruleApplications) {
			rrMatches.put(getSemanticChangeSet(ruleApplication), ruleApplication);
		}
		
		return rrMatches;
	}
	
	private SemanticChangeSet getSemanticChangeSet(RuleApplication recognitionRuleApp) {
		Collection<EObject> values = recognitionRuleApp.getResultMatch().getNodeTargets();
		
		for (EObject eObject : values) {
			if (eObject instanceof SemanticChangeSet) {
				return (SemanticChangeSet) eObject;
			}
		}

		return null;
	}
	
	public Collection<Rule> getSourceRules() {
		return complements.keySet();
	}

	public Collection<ComplementRule> getComplementRules(Rule cpEditRule) {
		return complements.getOrDefault(cpEditRule, Collections.emptySet());
	}
}
