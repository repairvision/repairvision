package org.sidiff.consistency.repair.lifting.cpo.complement;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getChangingAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isPreservedNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleAttributeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeCreateMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeDeleteMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;
import org.sidiff.difference.rulebase.RecognitionRule;
import org.sidiff.difference.rulebase.Trace;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.rulebase.EditRule;

public class RecognitionToEditRuleMatch {

	private SymmetricDifference difference;
	
	public RecognitionToEditRuleMatch(SymmetricDifference difference) {
		this.difference = difference;
	}

	public List<EditRuleMatch> createEditRuleMatch(EditRule editRule, Rule editRuleUnit, Match rrMatch) {
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
		
		// NOTE: The object might have been deleted in model B!
		if (matchB != null) {
			
			// Matching in model B found:
			eoMatch.add(new EditRuleNodeSingleMatch(eoNode, Type.PRESERVE, matchB));
			
			// Create-Attribute:
			for (Attribute attribute : getChangingAttributes(getLHS(eoNode), getRHS(eoNode))) {
				Object value = matchB.eGet(attribute.getType());
				eoMatch.add(new EditRuleAttributeMatch(attribute, value));
			}
		}
		
		// EO-Delete-Edges:
		for (Edge outgoingLHS : getLHS(eoNode).getOutgoing()) {
			if (isDeletionEdge(outgoingLHS)) {
				EditRuleEdgeDeleteMatch eoEdgeMatch = createDeleteEdgeMatch(rrMatch, outgoingLHS, eo2rrTraceA);
				
				if (eoEdgeMatch != null) {
					eoMatch.add(eoEdgeMatch);
				}
			}
		}
		
		// EO-Create-Edges:
		for (Edge outgoingRHS : getRHS(eoNode).getOutgoing()) {
			if (isCreationEdge(outgoingRHS)) {
				EditRuleEdgeCreateMatch eoEdgeMatch = createCreateEdgeMatch(rrMatch, outgoingRHS, eo2rrTraceB);
				
				if (eoEdgeMatch != null) {
					eoMatch.add(eoEdgeMatch);
				}
			}
		}
	}
}
