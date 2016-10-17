package org.sidiff.consistency.repair.complement.construction;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isCreationNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isDeletionNode;

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
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleAttributeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMatch;
import org.sidiff.consistency.repair.complement.util.ComplementUtil;

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
	 *         be constructed (e.g. dangling edges).
	 */
	public ComplementRule createComplementRule(List<EditRuleMatch> sourceRuleMatching) {

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
	
	private ComplementRule deriveComplementRule(Collection<EditRuleMatch> sourceRuleMatching) {

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
		for (EditRuleMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EditRuleEdgeMatch) {
				Edge sourceEdge = ((EditRuleEdgeMatch) sourceRuleMatch).getEdge();
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
		for (EditRuleMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EditRuleNodeMatch) {
				Node sourceNode = ((EditRuleNodeMatch) sourceRuleMatch).getNode();
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
		for (EditRuleMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EditRuleEdgeMatch) {
				Edge sourceEdge = ((EditRuleEdgeMatch) sourceRuleMatch).getEdge();
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
		for (EditRuleMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EditRuleAttributeMatch) {
				Attribute sourceAttribute = ((EditRuleAttributeMatch) sourceRuleMatch).getAttribute();
				Attribute complementAttribute = (Attribute) copyTrace.get(sourceAttribute);
				
				// Transform create-attribute to preserve-attribute:
				// FIXME: The attributes should also be passed as a parameter.
				ComplementUtil.makePreserve(complementAttribute);
			}
		}

		return complement;
	}
	
	protected abstract ComplementRule createComplementRule(Rule sourceRule, Rule complementRule);
	
	// TODO: ACs
//	private void initializeApplicationConditions(ComplementRule complement, ComplementMatch preMatch) {
//		Set<NestedCondition> unfulfilledACs = new HashSet<>(sourceRule.getLhs().getNestedConditions());
//		preMatch.setUnfulfilledACs(unfulfilledACs);
//		complement.recheckAllApplicationConditions(preMatch);
//	}
}
