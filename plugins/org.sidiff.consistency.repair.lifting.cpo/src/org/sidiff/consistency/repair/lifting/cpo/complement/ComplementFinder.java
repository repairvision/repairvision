package org.sidiff.consistency.repair.lifting.cpo.complement;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isPreservedNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
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
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeCreateMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeDeleteMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;
import org.sidiff.consistency.repair.complement.construction.subrule.SubRuleComplementConstructor;
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
	
	private EngineImpl engine;
	
	private EGraph graph;

	public ComplementFinder(
			ILiftingRuleBase subEditRuleBase, 
			RecognitionEngine recognitionEngine,
			Collection<Rule> sourceEditRules,
			SymmetricDifference difference) {
		
		this.subEditRuleBase = subEditRuleBase;
		this.recognitionEngine = recognitionEngine;
		this.sourceEditRules = sourceEditRules;
		this.difference = difference;
		
		// TODO: Use the graph from the recognition engine!?
		this.engine = new EngineImpl();
		this.graph = new EGraphImpl(difference.getModelB());
		
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
			
			// TODO[Precalculate]:Find corresponding source rule:
			for (Rule sourceEditRule : sourceEditRules) {
				SubRuleComplementConstructor complementConstructor = 
						new SubRuleComplementConstructor(sourceEditRule, engine, graph);

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

		for (Trace trace : editRule.getEditRuleAttachment(RecognitionRule.class).getTracesA()) {
			Node editRuleNode = trace.getEditRuleTrace();
			
			// EO-Delete-Nodes:
			if (isDeletionNode(editRuleNode)) {
				editRuleMatch.add(new EditRuleNodeSingleMatch(
						editRuleNode, Type.DELETE, rrMatch.getNodeTarget(editRuleNode)));
				
				// EO-Delete-Edges:
				for (Edge outgoing : editRuleNode.getOutgoing()) {
					editRuleMatch.add(new EditRuleEdgeDeleteMatch(outgoing, 
							rrMatch.getNodeTarget(editRuleNode),
							rrMatch.getNodeTarget(outgoing.getTarget())));
				}
			}
		}
		
		for (Trace trace : editRule.getEditRuleAttachment(RecognitionRule.class).getTracesB()) {
			Node editRuleNode = trace.getEditRuleTrace();
			
			// EO-Create-Nodes:
			if (isCreationNode(editRuleNode)) {
				editRuleMatch.add(new EditRuleNodeSingleMatch(
						editRuleNode, Type.CREATE, rrMatch.getNodeTarget(editRuleNode)));
				
				// EO-Create-Edges:
				for (Edge outgoing : editRuleNode.getOutgoing()) {
					editRuleMatch.add(new EditRuleEdgeCreateMatch(outgoing, 
							rrMatch.getNodeTarget(editRuleNode),
							rrMatch.getNodeTarget(outgoing.getTarget())));
				}
			}
			
			// EO-Preserve-Nodes:
			else if (isPreservedNode(editRuleNode)) {
				editRuleMatch.add(new EditRuleNodeSingleMatch(
						editRuleNode, Type.PRESERVE, rrMatch.getNodeTarget(editRuleNode)));
				
				for (Edge outgoing : editRuleNode.getOutgoing()) {
					
					// EO-Delete-Edges:
					if (isDeletionEdge(outgoing)) {
						editRuleMatch.add(new EditRuleEdgeDeleteMatch(outgoing, 
								rrMatch.getNodeTarget(editRuleNode),
								rrMatch.getNodeTarget(outgoing.getTarget())));
					}
					
					// EO-Create-Edges:
					else if (isCreationEdge(outgoing)) {
						editRuleMatch.add(new EditRuleEdgeCreateMatch(outgoing, 
								rrMatch.getNodeTarget(editRuleNode),
								rrMatch.getNodeTarget(outgoing.getTarget())));
					}
				}
			}
		}
		
		return editRuleMatch;
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
