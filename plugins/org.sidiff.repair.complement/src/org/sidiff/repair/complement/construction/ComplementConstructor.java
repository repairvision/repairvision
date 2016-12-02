package org.sidiff.repair.complement.construction;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getChangingAttributes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRemoteAttribute;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isPreservedNode;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.debug.DebugUtil;
import org.sidiff.repair.api.matching.EOAttributeMatch;
import org.sidiff.repair.api.matching.EOEdgeMatch;
import org.sidiff.repair.api.matching.EOMatch;
import org.sidiff.repair.api.matching.EONodeMatch;
import org.sidiff.repair.api.matching.EONodeMultiMatch;
import org.sidiff.repair.api.matching.EONodeSingleMatch;
import org.sidiff.repair.complement.util.ComplementUtil;

/**
 * Constructs the complement-rule = source-rule (-) partial-edit-rule-match
 * 
 * @author Manuel Ohrndorf
 */
public abstract class ComplementConstructor {

	protected Rule sourceRule;
	
	public ComplementConstructor(Rule sourceRule) {
		this.sourceRule = sourceRule;
	}
	
	/**
	 * @param sourceRuleMatching
	 *            A partial (edit-rule) matching of the partially executed source-rule.
	 * @return The rule which complements the partial partially executed
	 *         source-rule or <code>null</code> if the complement-rule could not
	 *         be constructed (e.g. dangling edges, no remaining changes).
	 */
	public ComplementRule createComplementRule(List<EOMatch> sourceRuleMatching) {

		long deriveComplements = System.currentTimeMillis();
		
		// Derive complement rule:
		ComplementRule complement = deriveComplementRule(sourceRuleMatching); 
		
		if (DebugUtil.statistic) {
			System.out.println("########## Derive Complement: " + (System.currentTimeMillis() - deriveComplements) + "ms");
		}
		
		if (complement != null) {
			complement.setSourceMatch(sourceRuleMatching);

			// TODO: ACs
//			// Get unfulfilled application conditions:
//			for (ComplementMatch preMatch : preMatches) {
//				initializeApplicationConditions(complement, preMatch);
//			}
		}
		
		return complement;
	}
	
	private ComplementRule deriveComplementRule(Collection<EOMatch> sourceRuleMatching) {

		// Create copy of the source rule:
		Map<EObject, EObject> copyTrace = ComplementUtil.deepCopy(sourceRule);
		Rule complementRule = (Rule) copyTrace.get(sourceRule);

		// Initialize complement rule:
		ComplementRule complement = createComplementRule(sourceRule, complementRule);

		// Save trace [Source -> Complement]:
		for (Node sourceNode : sourceRule.getLhs().getNodes()) {
			complement.addTrace(sourceNode, (Node) copyTrace.get(sourceNode));
		}
		
		for (Node sourceNode : sourceRule.getRhs().getNodes()) {
			complement.addTrace(sourceNode, (Node) copyTrace.get(sourceNode));
		}
		
		// Substitute already executed edges << delete >> edges:
		for (EOMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EOEdgeMatch) {
				Edge sourceEdge = ((EOEdgeMatch) sourceRuleMatch).getEdge();
				Edge complementEdge = (Edge) copyTrace.get(sourceEdge);
				
				// Delete-Edge:
				if (sourceRuleMatch.getAction().equals(Type.DELETE)) {
					assert isDeletionEdge(complementEdge);
					
					// Remove edge from source-rule:
					ComplementUtil.deleteEdge(complementEdge);
				}
			}
		}
		
		// Substitute already executed nodes:
		for (EOMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EONodeMatch) {
				Node sourceNode = ((EONodeMatch) sourceRuleMatch).getNode();
				Node complementNode = (Node) copyTrace.get(sourceNode);
				
				// Delete-Node:
				if (sourceRuleMatch.getAction().equals(Type.DELETE)) {
					assert isDeletionNode(complementNode);
					
					// Check dangling constraint:
					if (!complementNode.getIncoming().isEmpty() || !complementNode.getOutgoing().isEmpty()) {
						
						if (DebugUtil.isActive) {
							LogUtil.log(LogEvent.NOTICE, "Dangling Edges: " + complementNode + "\n  (" + sourceRule + ")");
						}
						
						return null;
					}
					
					// Remove node from source-rule:
					ComplementUtil.deleteNode(complementNode);
					complement.removeTrace(sourceNode);
				}
				
				// Create-Node:
				else if (sourceRuleMatch.getAction().equals(Type.CREATE)) {
					// FIXME: Should we support this case: node is already << preserve >> in CPO ?
//					assert isCreationNode(complementNode);
					
					if (isCreationNode(complementNode)) {
						
						// Transform create-node to preserve-node:
						ComplementUtil.makePreserve(complementNode);
					} else {
						return null;
					}
				}
			}
		}
		
		// Substitute already executed edges << create >> edges:
		for (EOMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EOEdgeMatch) {
				Edge sourceEdge = ((EOEdgeMatch) sourceRuleMatch).getEdge();
				Edge complementEdge = (Edge) copyTrace.get(sourceEdge);
				
				// Create-Edge:
				if (sourceRuleMatch.getAction().equals(Type.CREATE)) {
					assert isCreationEdge(complementEdge);
					
					// NOTE: << create >> target/source nodes are implicitly set to << preserve >> 
					// FIXME: How to handle << create >> target/source nodes!?
					
					// Transform create-edge to preserve-edge:
					ComplementUtil.makePreserve(complementEdge);
				}
			}
		}
		
		// Substitute already executed edges << create >> attributes:
		for (EOMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EOAttributeMatch) {
				Attribute sourceAttribute = ((EOAttributeMatch) sourceRuleMatch).getAttribute();
				Attribute complementAttribute = (Attribute) copyTrace.get(sourceAttribute);
				
				// Transform create-attribute to preserve-attribute:
				// FIXME: The attributes should also be passed as a parameter.
				ComplementUtil.makePreserve(complementAttribute);
			}
		}
		
		// Check for << preserve >> nodes matched in A / not matched in B:
		// NOTE: Sub: Remove Transition Target - Source: Remove-Transition vs. Remove-Transition-Loop
		for (EOMatch sourceRuleMatch : sourceRuleMatching) {
			
			
			// No matching in model B?
			if (((sourceRuleMatch instanceof EONodeSingleMatch) && (((EONodeSingleMatch) sourceRuleMatch).getModelBElement() == null))
				|| ((sourceRuleMatch instanceof EONodeMultiMatch) && (((EONodeMultiMatch) sourceRuleMatch).getModelBElements().isEmpty()))) {
					
				Node sourceNode = ((EONodeMatch) sourceRuleMatch).getNode();
				Node complementNode = (Node) copyTrace.get(sourceNode);

				// Delete-Node:
				if (sourceRuleMatch.getAction().equals(Type.PRESERVE)) {
					assert isPreservedNode(complementNode);

					// << delete or create >> edge or attribute change => complementing changes on a deleted node!
					// << preserve >> edge => unfulfilled PAC!
					if (!complementNode.getOutgoing().isEmpty() || !complementNode.getIncoming().isEmpty()
							|| !getChangingAttributes(getLHS(complementNode), getRHS(complementNode)).isEmpty()) {
						return null;
					} else {
						// Remove deleted context node:
						ComplementUtil.deletePreserveNode(complementNode);
						complement.removeTrace(getLHS(sourceNode));
						complement.removeTrace(getRHS(sourceNode));
					}
				}
			}
		}
		
		//  No remaining changes -> empty complement rule!
		if (!hasChange(complementRule)) {
			return null;
		}

		return complement;
	}
	
	private boolean hasChange(Rule rule) {
		
		// Has delete nodes:
		if (rule.getLhs().getNodes().size() != rule.getMappings().size()) {
			return true;
		}
		
		// Has create nodes:
		if (rule.getRhs().getNodes().size() != rule.getMappings().size()) {
			return true;
		}
		
		// Has delete or create edges:
		// NOTE: Does not hold for e.g. move = delete + add
		if (rule.getLhs().getEdges().size() != rule.getRhs().getEdges().size()) {
			return true;
		}
		
		// Has attribute value changes:
		for (Node node : rule.getRhs().getNodes()) {
			for (Attribute attribute : node.getAttributes()) {
				Attribute remoteAttribute = getRemoteAttribute(attribute);
				
				if (remoteAttribute == null) {
					return true;
				} else {
					if (!remoteAttribute.getValue().equals(attribute.getValue())) {
						return true;
					}
				}
			}
		}
		
		// Has delete edges:
		for (Edge edge : rule.getLhs().getEdges()) {
			if (isDeletionEdge(edge)) {
				return true;
			}
		}
		
		// Has create edges:
		for (Edge edge : rule.getRhs().getEdges()) {
			if (isCreationEdge(edge)) {
				return true;
			}
		}
		
		return false;
	}
	
	protected abstract ComplementRule createComplementRule(Rule sourceRule, Rule complementRule);
	
	// TODO: ACs
//	private void initializeApplicationConditions(ComplementRule complement, ComplementMatch preMatch) {
//		Set<NestedCondition> unfulfilledACs = new HashSet<>(sourceRule.getLhs().getNestedConditions());
//		preMatch.setUnfulfilledACs(unfulfilledACs);
//		complement.recheckAllApplicationConditions(preMatch);
//	}
}
