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
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterKind;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.common.emf.ModelingUtil;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.graphpattern.attributes.JavaSciptParser;
import org.sidiff.repair.complement.matching.RecognitionAttributeMatch;
import org.sidiff.repair.complement.matching.RecognitionEdgeMatch;
import org.sidiff.repair.complement.matching.RecognitionMatch;
import org.sidiff.repair.complement.matching.RecognitionNodeMatch;
import org.sidiff.repair.complement.matching.RecognitionNodeMultiMatch;
import org.sidiff.repair.complement.matching.RecognitionNodeSingleMatch;
import org.sidiff.repair.complement.matching.RecognitionParameterMatch;
import org.sidiff.repair.complement.util.ComplementUtil;

/**
 * Constructs the complement-rule = recognized-rule (-) partial-edit-rule-match
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementConstructor {
	
	/**
	 * @param recognitionMatch
	 *            A partial (edit-rule) matching of the partially executed
	 *            source-rule.
	 * @param recognizedChangeSet 
	 * @return The rule which complements the partial partially executed
	 *         source-rule or <code>null</code> if the complement-rule could not
	 *         be constructed (e.g. dangling edges, no remaining changes).
	 */
	public ComplementRule createComplementRule(Rule recognizedRule, List<RecognitionMatch> recognitionMatch, List<Change> recognizedChangeSet) {

		long deriveComplements = System.currentTimeMillis();
		
		// Derive complement rule:
		ComplementRule complement = deriveComplementRule(recognizedRule, recognitionMatch, recognizedChangeSet); 
		
		if (DebugUtil.statistic) {
			System.out.println("########## Derive Complement: " + (System.currentTimeMillis() - deriveComplements) + "ms");
		}
		
		return complement;
	}
	
	protected ComplementRule deriveComplementRule(Rule recognizedRule, List<RecognitionMatch> recognitionMatch, List<Change> recognizedChangeSeth) {

		// Create copy of the source rule:
		Map<EObject, EObject> copyTrace = ModelingUtil.deepCopy(recognizedRule);
		Rule complementRule = (Rule) copyTrace.get(recognizedRule);

		// Initialize complement rule:
		ComplementRule complement = new ComplementRule(recognizedRule, recognitionMatch, recognizedChangeSeth, complementRule);

		// Save trace [Source -> Complement]:
		for (Node sourceNode : recognizedRule.getLhs().getNodes()) {
			complement.addTrace(sourceNode, (Node) copyTrace.get(sourceNode));
		}
		
		for (Node sourceNode : recognizedRule.getRhs().getNodes()) {
			complement.addTrace(sourceNode, (Node) copyTrace.get(sourceNode));
		}
		
		// Substitute already executed edges << delete >> edges:
		if (!substituteDeleteEdges(recognitionMatch, copyTrace)) {
			return null;
		}
		
		// Substitute already executed << delete >> nodes:
		// NOTE: Remove << delete >> edges before removing << delete >> nodes!
		if (!substituteDeleteNodes(recognitionMatch, copyTrace, complement)) {
			return null;
		}
		
		// Substitute already executed << create >> nodes:
		if (!substituteCreateNodes(complementRule, recognitionMatch, copyTrace)) {
			return null;
		}
		
		// Substitute already executed edges << create >> edges:
		// NOTE: Make << create >> nodes << preserve >> before making << create >> edges << preserve >>!
		// NOTE: << create >> target/source nodes are implicitly set to << preserve >> 
		if (!substituteCreateEdges(recognitionMatch, copyTrace)) {
			return null;
		}
		
		// Substitute already executed << create >> attributes:
		if (!substituteAttributeValueChanges(recognitionMatch, copyTrace)) {
			return null;
		}
		
		// Check for << preserve >> nodes matched in A / not matched in B:
		// NOTE: Sub: Remove Transition Target - Source: Remove-Transition vs. Remove-Transition-Loop
		if (!reduceContext(recognitionMatch, copyTrace, complement)) {
			return null;
		}
		
		//  No remaining changes -> empty complement rule!
		if (!hasChange(complementRule)) {
			return null;
		}

		return complement;
	}

	protected boolean substituteDeleteEdges(Collection<RecognitionMatch> recognitionMatch, Map<EObject, EObject> copyTrace) {
		
		// Substitute already executed edges << delete >> edges:
		for (RecognitionMatch sourceRuleMatch : recognitionMatch) {
			if (sourceRuleMatch instanceof RecognitionEdgeMatch) {
				RecognitionEdgeMatch sourceEdgeMatch = (RecognitionEdgeMatch) sourceRuleMatch;
				
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

	// NOTE: If the complement rule is set, we generate new IN parameters for new context nodes.
	protected boolean substituteCreateNodes(Rule complement, Collection<RecognitionMatch> recognitionMatch,  Map<EObject, EObject> copyTrace) {
		
		// Substitute already executed << create >> nodes:
		for (RecognitionMatch sourceRuleMatch : recognitionMatch) {
			if (sourceRuleMatch instanceof RecognitionNodeMatch) {
				RecognitionNodeMatch sourceNodeMatch = (RecognitionNodeMatch) sourceRuleMatch;
				
				Node sourceNode = sourceNodeMatch.getNode();
				Node complementNode = (Node) copyTrace.get(sourceNode);

				// Create-Node:
				if (sourceNodeMatch.getAction().equals(Type.CREATE)) {
					// FIXME: Should we support this case: node is already << preserve >> in CPO?
//					assert isCreationNode(complementNode);
					
					// Transform create-node to preserve-node:
					if (isCreationNode(complementNode)) {
						ComplementUtil.makePreserve(complementNode, false);
						
						// Create new IN-Parameter:
						if ((complement != null) && (complementNode.getName() != null)) {
							Parameter inParameter = HenshinFactory.eINSTANCE.createParameter(); 
							inParameter.setKind(ParameterKind.IN);
							inParameter.setName(complementNode.getName());
							inParameter.setType(complementNode.getType());
							complement.getParameters().add(inParameter);
						}
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	protected boolean substituteDeleteNodes(Collection<RecognitionMatch> recognitionMatch, 
			Map<EObject, EObject> copyTrace, ComplementRule complement) {
		
		// Substitute already executed << delete >> nodes:
		for (RecognitionMatch sourceRuleMatch : recognitionMatch) {
			if (sourceRuleMatch instanceof RecognitionNodeMatch) {
				RecognitionNodeMatch sourceNodeMatch = (RecognitionNodeMatch) sourceRuleMatch;
				
				Node sourceNode = sourceNodeMatch.getNode();
				Node complementNode = (Node) copyTrace.get(sourceNode);
				
				// Delete-Node:
				if (sourceNodeMatch.getAction().equals(Type.DELETE)) {
					assert isDeletionNode(complementNode);
					
					// Check dangling constraint:
					if (!complementNode.getIncoming().isEmpty() || !complementNode.getOutgoing().isEmpty()) {
						
						if (DebugUtil.isActive) {
							LogUtil.log(LogEvent.NOTICE, "Dangling Edges: " + complementNode 
									+ "\n  (" + complementNode.getGraph().getRule() + ")");
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

	protected boolean substituteCreateEdges(Collection<RecognitionMatch> recognitionMatch, Map<EObject, EObject> copyTrace) {
		
		// Substitute already executed edges << create >> edges:
		for (RecognitionMatch sourceRuleMatch : recognitionMatch) {
			if (sourceRuleMatch instanceof RecognitionEdgeMatch) {
				RecognitionEdgeMatch sourceEdgeMatch = (RecognitionEdgeMatch) sourceRuleMatch;
				
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
	
	protected boolean substituteAttributeValueChanges(Collection<RecognitionMatch> recognitionMatch, Map<EObject, EObject> copyTrace) {
		
		// Substitute already executed << create >> attributes:
		for (RecognitionMatch sourceRuleMatch : recognitionMatch) {
			if (sourceRuleMatch instanceof RecognitionAttributeMatch) {
				Attribute sourceAttribute = ((RecognitionAttributeMatch) sourceRuleMatch).getAttribute();
				Attribute complementAttribute = (Attribute) copyTrace.get(sourceAttribute);
				
				// Transform create-attribute to preserve-attribute:
				if (checkVariableBindings(recognitionMatch, complementAttribute)) {
					ComplementUtil.makePreserve(complementAttribute);
				} else {
					return false;
				}
			}
		}
		
		return true;
	}
	
	protected boolean checkVariableBindings(Collection<RecognitionMatch> recognitionMatch, Attribute attribute) {
		for(String variable : JavaSciptParser.getVariables(attribute.getValue())) {
			if (!findVariableBinding(recognitionMatch, variable)) {
				return false;
			}
		}
		return true;
	}
	
	protected boolean findVariableBinding(Collection<RecognitionMatch> recognitionMatch, String variable) {
		for (RecognitionMatch sourceRuleMatch : recognitionMatch) {
			if (sourceRuleMatch instanceof RecognitionParameterMatch) {
				if (variable.equals(((RecognitionParameterMatch) sourceRuleMatch).getParameter().getName())) {
					return true;
				}
			}
		}
		return false;
	}

	protected boolean reduceContext(Collection<RecognitionMatch> recognitionMatch, 
			Map<EObject, EObject> copyTrace, ComplementRule complement) {
		
		// Check for << preserve >> nodes matched in A / not matched in B:
		// NOTE: Sub: Remove Transition Target - Source: Remove-Transition vs. Remove-Transition-Loop
		for (RecognitionMatch sourceRuleMatch : recognitionMatch) {
			
			// Node matching: No matching in model B?
			if (((sourceRuleMatch instanceof RecognitionNodeSingleMatch) && (((RecognitionNodeSingleMatch) sourceRuleMatch).getModelBElement() == null))
				|| ((sourceRuleMatch instanceof RecognitionNodeMultiMatch) && (((RecognitionNodeMultiMatch) sourceRuleMatch).getModelBElements().isEmpty()))) {

				RecognitionNodeMatch sourceNodeMatch = (RecognitionNodeMatch) sourceRuleMatch;
				
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
			else if (sourceRuleMatch instanceof RecognitionEdgeMatch) {
				RecognitionEdgeMatch sourceEdgeMatch = (RecognitionEdgeMatch) sourceRuleMatch;
				
				if (sourceEdgeMatch.getSrcModelBElement() == null) {
					Node sourceSrcNode = sourceEdgeMatch.getEdge().getSource();
					Node complementSrcNode = (Node) copyTrace.get(sourceSrcNode);
					
					if ((complementSrcNode != null) && (complementSrcNode.eContainer() != null) && isPreservedNode(complementSrcNode)) {
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
					
					if ((complementTgtNode != null) && (complementTgtNode.eContainer() != null) && isPreservedNode(complementTgtNode)) {
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
}
