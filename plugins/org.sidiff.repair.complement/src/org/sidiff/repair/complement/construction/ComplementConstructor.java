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
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.common.emf.ModelingUtil;
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
	 *            A partial (edit-rule) matching of the partially executed
	 *            source-rule.
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
		}
		
		return complement;
	}
	
	protected ComplementRule deriveComplementRule(Collection<EOMatch> sourceRuleMatching) {

		// Create copy of the source rule:
		Map<EObject, EObject> copyTrace = ModelingUtil.deepCopy(sourceRule);
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
		if (!substituteDeleteEdges(sourceRuleMatching, copyTrace)) {
			return null;
		}
		
		// Substitute already executed << delete >> nodes:
		// NOTE: Remove << delete >> edges before removing << delete >> nodes!
		if (!substituteDeleteNodes(sourceRuleMatching, copyTrace, complement)) {
			return null;
		}
		
		// Substitute already executed << create >> nodes:
		if (!substituteCreateNodes(sourceRuleMatching, copyTrace)) {
			return null;
		}
		
		// Substitute already executed edges << create >> edges:
		// NOTE: Make << create >> nodes << preserve >> before making << create >> edges << preserve >>!
		// NOTE: << create >> target/source nodes are implicitly set to << preserve >> 
		if (!substituteCreateEdges(sourceRuleMatching, copyTrace)) {
			return null;
		}
		
		// Substitute already executed << create >> attributes:
		if (!substituteAttributeValueChanges(sourceRuleMatching, copyTrace)) {
			return null;
		}
		
		// Check for << preserve >> nodes matched in A / not matched in B:
		// NOTE: Sub: Remove Transition Target - Source: Remove-Transition vs. Remove-Transition-Loop
		if (!reduceContext(sourceRuleMatching, copyTrace, complement)) {
			return null;
		}
		
		//  No remaining changes -> empty complement rule!
		if (!hasChange(complementRule)) {
			return null;
		}

		return complement;
	}

	protected boolean substituteDeleteEdges(Collection<EOMatch> sourceRuleMatching, Map<EObject, EObject> copyTrace) {
		
		// Substitute already executed edges << delete >> edges:
		for (EOMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EOEdgeMatch) {
				EOEdgeMatch sourceEdgeMatch = (EOEdgeMatch) sourceRuleMatch;
				
				Edge sourceEdge = sourceEdgeMatch.getEdge();
				Edge complementEdge = (Edge) copyTrace.get(sourceEdge);
				
				// Delete-Edge:
				if (sourceEdgeMatch.getAction().equals(Type.DELETE)) {
					assert isDeletionEdge(complementEdge);
					
					// Remove edge from source-rule:
					ComplementUtil.deleteEdge(complementEdge);
				}
			}
		}
		
		return true;
	}

	protected boolean substituteCreateNodes(Collection<EOMatch> sourceRuleMatching,  Map<EObject, EObject> copyTrace) {
		
		// Substitute already executed << create >> nodes:
		for (EOMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EONodeMatch) {
				EONodeMatch sourceNodeMatch = (EONodeMatch) sourceRuleMatch;
				
				Node sourceNode = sourceNodeMatch.getNode();
				Node complementNode = (Node) copyTrace.get(sourceNode);

				// Create-Node:
				if (sourceNodeMatch.getAction().equals(Type.CREATE)) {
					// FIXME: Should we support this case: node is already << preserve >> in CPO?
//					assert isCreationNode(complementNode);
					
					// Transform create-node to preserve-node:
					if (isCreationNode(complementNode)) {
						ComplementUtil.makePreserve(complementNode);
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	protected boolean substituteDeleteNodes(Collection<EOMatch> sourceRuleMatching, 
			Map<EObject, EObject> copyTrace, ComplementRule complement) {
		
		// Substitute already executed << delete >> nodes:
		for (EOMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EONodeMatch) {
				EONodeMatch sourceNodeMatch = (EONodeMatch) sourceRuleMatch;
				
				Node sourceNode = sourceNodeMatch.getNode();
				Node complementNode = (Node) copyTrace.get(sourceNode);
				
				// Delete-Node:
				if (sourceNodeMatch.getAction().equals(Type.DELETE)) {
					assert isDeletionNode(complementNode);
					
					// Check dangling constraint:
					if (!complementNode.getIncoming().isEmpty() || !complementNode.getOutgoing().isEmpty()) {
						
						if (DebugUtil.isActive) {
							LogUtil.log(LogEvent.NOTICE, "Dangling Edges: " + complementNode + "\n  (" + sourceRule + ")");
						}
						
						return false;
					}
					
					// Remove node from source-rule:
					ComplementUtil.deleteNode(complementNode);
					complement.removeTrace(sourceNode);
				}
			}
		}
		
		return true;
	}

	protected boolean substituteCreateEdges(Collection<EOMatch> sourceRuleMatching, Map<EObject, EObject> copyTrace) {
		
		// Substitute already executed edges << create >> edges:
		for (EOMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EOEdgeMatch) {
				EOEdgeMatch sourceEdgeMatch = (EOEdgeMatch) sourceRuleMatch;
				
				Edge sourceEdge = sourceEdgeMatch.getEdge();
				Edge complementEdge = (Edge) copyTrace.get(sourceEdge);
				
				// Create-Edge:
				if (sourceEdgeMatch.getAction().equals(Type.CREATE)) {
					assert isCreationEdge(complementEdge);
					
					// NOTE: << create >> target/source nodes are implicitly set to << preserve >> 
					// FIXME: How to handle << create >> target/source nodes!?
					
					// Transform create-edge to preserve-edge:
					ComplementUtil.makePreserve(complementEdge);
				}
			}
		}
		
		return true;
	}
	
	protected boolean substituteAttributeValueChanges(Collection<EOMatch> sourceRuleMatching, Map<EObject, EObject> copyTrace) {
		
		// Substitute already executed << create >> attributes:
		for (EOMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EOAttributeMatch) {
				Attribute sourceAttribute = ((EOAttributeMatch) sourceRuleMatch).getAttribute();
				Attribute complementAttribute = (Attribute) copyTrace.get(sourceAttribute);
				
				// Transform create-attribute to preserve-attribute:
				// FIXME: The attributes should also be passed as a parameter.
				ComplementUtil.makePreserve(complementAttribute);
			}
		}
		
		return true;
	}

	protected boolean reduceContext(Collection<EOMatch> sourceRuleMatching, 
			Map<EObject, EObject> copyTrace, ComplementRule complement) {
		
		// Check for << preserve >> nodes matched in A / not matched in B:
		// NOTE: Sub: Remove Transition Target - Source: Remove-Transition vs. Remove-Transition-Loop
		for (EOMatch sourceRuleMatch : sourceRuleMatching) {
			
			// Node matching: No matching in model B?
			if (((sourceRuleMatch instanceof EONodeSingleMatch) && (((EONodeSingleMatch) sourceRuleMatch).getModelBElement() == null))
				|| ((sourceRuleMatch instanceof EONodeMultiMatch) && (((EONodeMultiMatch) sourceRuleMatch).getModelBElements().isEmpty()))) {

				EONodeMatch sourceNodeMatch = (EONodeMatch) sourceRuleMatch;
				
				Node sourceNode = sourceNodeMatch.getNode();
				Node complementNode = (Node) copyTrace.get(sourceNode);

				// Delete-Node:
				if (sourceNodeMatch.getAction().equals(Type.PRESERVE)) {
					assert isPreservedNode(complementNode);

					// << delete or create >> edge or attribute change => complementing changes on a deleted node!
					// << preserve >> edge => unfulfilled PAC!
					if (isSeparatedContextNode(complementNode)) {
						// Remove separated context node:
						complement.removeTrace(getLHS(sourceNode));
						complement.removeTrace(getRHS(sourceNode));
						ComplementUtil.deletePreserveNode(complementNode);
					} else {
						return false;
					}
				}
			}
			
			// Edge matching (source, target): No matching in model B?
			else if (sourceRuleMatch instanceof EOEdgeMatch) {
				EOEdgeMatch sourceEdgeMatch = (EOEdgeMatch) sourceRuleMatch;
				
				if (sourceEdgeMatch.getSrcModelBElement() == null) {
					Node sourceSrcNode = sourceEdgeMatch.getEdge().getSource();
					Node complementSrcNode = (Node) copyTrace.get(sourceSrcNode);
					
					if ((complementSrcNode != null) && isPreservedNode(complementSrcNode)) {
						if (isSeparatedContextNode(complementSrcNode)) {
							// Remove separated context node:
							complement.removeTrace(getLHS(complementSrcNode));
							complement.removeTrace(getRHS(complementSrcNode));
							ComplementUtil.deletePreserveNode(complementSrcNode);
						} else {
							return false;
						}
					}
				}
				
				if (sourceEdgeMatch.getTgtModelBElement() == null) {
					Node sourceTgtNode = sourceEdgeMatch.getEdge().getTarget();
					Node complementTgtNode = (Node) copyTrace.get(sourceTgtNode);
					
					if ((complementTgtNode != null) && isPreservedNode(complementTgtNode)) {
						if (isSeparatedContextNode(complementTgtNode)) {
							// Remove separated context node:
							complement.removeTrace(getLHS(complementTgtNode));
							complement.removeTrace(getRHS(complementTgtNode));
							ComplementUtil.deletePreserveNode(complementTgtNode);
						} else {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
	
	private boolean isSeparatedContextNode(Node complementNode) {
		return complementNode.getOutgoing().isEmpty() && complementNode.getIncoming().isEmpty()
				&& getChangingAttributes(getLHS(complementNode), getRHS(complementNode)).isEmpty();
	}
	
	protected boolean hasChange(Rule rule) {
		
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
}
