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
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
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
import org.sidiff.difference.lifting.recognitionengine.ruleapplication.RecognitionEngine;
import org.sidiff.difference.rulebase.RecognitionRule;
import org.sidiff.difference.rulebase.Trace;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.rulebase.EditRule;
import org.sidiff.editrule.rulebase.RuleBaseItem;

public class ComplementFinder {

	private ILiftingRuleBase subEditRuleBase;
	
	private RecognitionEngine recognitionEngine;
	
	private Collection<Rule> sourceEditRules;
	
	private SymmetricDifference difference;
	
	private Map<Rule, Collection<ComplementRule>> complements = new HashMap<>();

	public ComplementFinder(
			ILiftingRuleBase subEditRuleBase, 
			RecognitionEngine recognitionEngine,
			Collection<Rule> sourceEditRules,
			SymmetricDifference difference) {
		
		this.subEditRuleBase = subEditRuleBase;
		this.recognitionEngine = recognitionEngine;
		this.sourceEditRules = sourceEditRules;
		this.difference = difference;
		
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
			
			// Translate recognition to edit rule matching:
			List<EditRuleMatch> subEOMatch = createEditRuleMatch(subEditRule, subEOUnit, subRRMatch);
			
			// TODO[Precalculate]: Find corresponding source rule:
			for (Rule sourceEditRule : sourceEditRules) {
				CPOComplementConstructor complementConstructor = new CPOComplementConstructor(sourceEditRule);

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
	
	private List<EditRuleMatch> createEditRuleMatch(EditRule editRule, Rule editRuleUnit, Match rrMatch) {
		// NOTE: Since this is complete match we can derive the edge matchings from the node matchings!
		
		// Create edit-operation match:
		List<EditRuleMatch> editRuleMatch = new ArrayList<>();
		Set<Node> donePreserveNodes = new HashSet<>();
		
		Map<Node, Node> eo2rrTrace = getEdit2RecognitionTrace(editRule);
		
		for (Trace trace : editRule.getEditRuleAttachment(RecognitionRule.class).getTracesA()) {
			Node editRuleNode = trace.getEditRuleTrace();
			
			// EO-Delete-Nodes:
			if (isDeletionNode(editRuleNode)) {
				createDeleteNodeMatch(editRuleMatch, editRuleNode, rrMatch, eo2rrTrace);
			}
			
			// EO-Preserve-Nodes:
			else if (isPreservedNode(editRuleNode)) {
				createPreserveNodeMatch(editRuleMatch, editRuleNode, rrMatch, eo2rrTrace);
				donePreserveNodes.add(editRuleNode);
			}
		}
		
		for (Trace trace : editRule.getEditRuleAttachment(RecognitionRule.class).getTracesB()) {
			Node editRuleNode = trace.getEditRuleTrace();
			
			// EO-Create-Nodes:
			if (isCreationNode(editRuleNode)) {
				createCreateNodeMatch(editRuleMatch, editRuleNode, rrMatch, eo2rrTrace);
			}
			
			// EO-Preserve-Nodes:
			else if (!donePreserveNodes.contains(editRuleNode) && isPreservedNode(editRuleNode)) {
				createPreserveNodeMatch(editRuleMatch, editRuleNode, rrMatch, eo2rrTrace);
			}
		}
		
		return editRuleMatch;
	}
	
	private Map<Node, Node> getEdit2RecognitionTrace(EditRule editRule) {
		Map<Node, Node> trace = new HashMap<>();
		
		for (Trace traceA : editRule.getEditRuleAttachment(RecognitionRule.class).getTracesA()) {
			trace.put(traceA.getEditRuleTrace(), traceA.getRecognitionRuleTrace());
		}
		
		for (Trace traceB : editRule.getEditRuleAttachment(RecognitionRule.class).getTracesB()) {
			trace.put(traceB.getEditRuleTrace(), traceB.getRecognitionRuleTrace());
		}
		
		return trace;
	}
	
	private void createDeleteNodeMatch(
			List<EditRuleMatch> eoMatch, Node eoNode, 
			Match rrMatch, Map<Node, Node> eo2rrTrace) {
		
		eoMatch.add(new EditRuleNodeSingleMatch(
				eoNode, Type.DELETE, rrMatch.getNodeTarget(eo2rrTrace.get(eoNode))));
		
		// EO-Delete-Edges:
		for (Edge outgoing : eoNode.getOutgoing()) {
			eoMatch.add(new EditRuleEdgeDeleteMatch(outgoing, 
					rrMatch.getNodeTarget(eo2rrTrace.get(outgoing.getSource())),
					rrMatch.getNodeTarget(eo2rrTrace.get(outgoing.getTarget()))));
		}
	}
	
	private void createCreateNodeMatch(
			List<EditRuleMatch> eoMatch, Node eoNode, 
			Match rrMatch, Map<Node, Node> eo2rrTrace) {
		
		eoMatch.add(new EditRuleNodeSingleMatch(
				eoNode, Type.CREATE, rrMatch.getNodeTarget(eo2rrTrace.get(eoNode))));
		
		// EO-Create-Edges:
		for (Edge outgoing : eoNode.getOutgoing()) {
			eoMatch.add(new EditRuleEdgeCreateMatch(outgoing, 
					rrMatch.getNodeTarget(eo2rrTrace.get(outgoing.getSource())),
					rrMatch.getNodeTarget(eo2rrTrace.get(outgoing.getTarget()))));
		}
	}
	
	private void createPreserveNodeMatch(
			List<EditRuleMatch> eoMatch, Node eoNode, 
			Match rrMatch, Map<Node, Node> eo2rrTrace) {
		
		// NOTE: The trace of a preserve node is (normally) be saved as LHS node trace.
		
		eoMatch.add(new EditRuleNodeSingleMatch(
				eoNode, Type.PRESERVE, rrMatch.getNodeTarget(eo2rrTrace.get(getLHS(eoNode)))));
		
		for (Edge outgoingLHS : getLHS(eoNode).getOutgoing()) {
			// EO-Delete-Edges:
			if (isDeletionEdge(outgoingLHS)) {
				eoMatch.add(new EditRuleEdgeDeleteMatch(outgoingLHS, 
						rrMatch.getNodeTarget(eo2rrTrace.get(outgoingLHS.getSource())),
						rrMatch.getNodeTarget(eo2rrTrace.get(outgoingLHS.getTarget()))));
			}
		}
		
		for (Edge outgoingRHS : getRHS(eoNode).getOutgoing()) {
			// EO-Create-Edges:
			if (isCreationEdge(outgoingRHS)) {
				eoMatch.add(new EditRuleEdgeCreateMatch(outgoingRHS, 
						rrMatch.getNodeTarget(eo2rrTrace.get(getLHS(eoNode))),
						rrMatch.getNodeTarget(eo2rrTrace.get(getLHS(outgoingRHS.getTarget())))));
			}
		}
	}
	
	/**
	 * @return Recognition-Rule -> Edit-Rules
	 */
	private Map<Rule, EditRule> getRecognition2EditRules() {
		Map<Rule, EditRule> editRules = new HashMap<>();
		
		for (RuleBaseItem item : subEditRuleBase.getRuleBase().getItems()) {
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
