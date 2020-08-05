package org.sidiff.revision.editrules.complement.construction;

import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getLHS;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getRHS;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getRemoteAttribute;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.isCreationEdge;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.isCreationNode;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.isDeletionEdge;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.isDeletionNode;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.isPreservedNode;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterKind;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.graphpattern.attributes.JavaSciptParser;
import org.sidiff.revision.common.emf.ModelingUtil;
import org.sidiff.revision.common.henshin.HenshinChangesUtil;
import org.sidiff.revision.common.utilities.java.JUtil;
import org.sidiff.revision.editrules.complement.util.ComplementUtil;
import org.sidiff.revision.editrules.recognition.match.RecognitionAttributeMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionEdgeMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionMatching;
import org.sidiff.revision.editrules.recognition.match.RecognitionNodeMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionNodeMultiMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionNodeSingleMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionParameterMatch;

/**
 * Constructs the complement-rule = recognized-rule (-) partial-edit-rule-match
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementConstructor {
	
	public static final boolean DEBUG = false;
	
	/**
	 * @param recognitionMatch
	 *            A partial (edit-rule) matching of the partially executed
	 *            source-rule.
	 * @param recognizedChangeSet 
	 * @return The rule which complements the partial partially executed
	 *         source-rule or <code>null</code> if the complement-rule could not
	 *         be constructed (e.g. dangling edges, no remaining changes).
	 */
	public ComplementRule createComplementRule(Rule recognizedRule, RecognitionMatching recognitionMatch) {

		long deriveComplements = System.currentTimeMillis();
		
		// Derive complement rule:
		ComplementRule complement = deriveComplementRule(recognizedRule, recognitionMatch); 
		
		if (DEBUG) {
			System.out.println("########## Derive Complement: " + (System.currentTimeMillis() - deriveComplements) + "ms");
		}
		
		return complement;
	}
	
	protected ComplementRule deriveComplementRule(Rule recognizedRule, RecognitionMatching recognitionMatch) {

		// Create copy of the source rule:
		Map<EObject, EObject> copyTrace = ModelingUtil.deepCopy(recognizedRule);
		Rule complementRule = (Rule) copyTrace.get(recognizedRule);

		// Initialize complement rule:
		ComplementRule complement = new ComplementRule(recognizedRule, recognitionMatch, complementRule);

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
		
		if (!substituteApplicationConditions(recognitionMatch, copyTrace, complement)) {
			return null;
		}
		
		//  No remaining changes -> empty complement rule!
		if (!hasChange(complementRule)) {
			return null;
		}
		
//		if (!isValid(complementRule)) {
//			System.err.println("Validation Failed: " + complementRule.getName());
//		}

		return complement;
	}

	@SuppressWarnings("unused")
	private boolean isValid(Rule complementRule) {
		
		for (EObject element : JUtil.iterable(() -> complementRule.eAllContents())) {
			if (element instanceof Node) {
				
				// Check for proper containment:
				for (Edge outgoing : ((Node) element).getOutgoing()) {
					if (outgoing.eContainer() == null) {
						return false;
					}
					if (outgoing.getTarget().eContainer() == null) {
						return false;
					}
				}
			}
		}
		
		return true;
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
						// TODO: Generate name if name is null!?
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
						
						if (DEBUG) {
							System.out.println("Dangling Edges: " + complementNode 
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
	
	protected boolean substituteApplicationConditions(List<RecognitionMatch> recognitionMatch,
			Map<EObject, EObject> copyTrace, ComplementRule complement) {
		
		// Search unconnected application conditions:
		for (NestedCondition condition : complement.getComplementRule().getLhs().getNestedConditions()) {
			for (Mapping mapping : condition.getMappings()) {
				if (mapping.getOrigin().eContainer() == null) {
					EcoreUtil.remove(condition);
					break;
				}
			}
		}
		
		return true;
	}

	protected boolean checkVariableBindings(Collection<RecognitionMatch> recognitionMatch, Attribute attribute) {
		for(String variable : JavaSciptParser.getVariables(attribute.getType().getEAttributeType(), attribute.getValue())) {
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
					if (isSeparatedContextNode(getLHS(complementNode), getRHS(complementNode))) {
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
						if (isSeparatedContextNode(getLHS(complementSrcNode), getRHS(complementSrcNode))) {
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
						if (isSeparatedContextNode(getLHS(complementTgtNode), getRHS(complementTgtNode))) {
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
	
	private boolean isSeparatedContextNode(Node lhsComplementNode, Node rhsComplementNode) {
		return lhsComplementNode.getOutgoing().isEmpty() 
				&& lhsComplementNode.getIncoming().isEmpty()
				&& rhsComplementNode.getOutgoing().isEmpty() 
				&& rhsComplementNode.getIncoming().isEmpty()
				&& HenshinChangesUtil.getChangingAttributes(lhsComplementNode).isEmpty();
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
				Attribute remoteAttribute = getRemoteAttribute(rule.getMappings(), attribute);
				
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
