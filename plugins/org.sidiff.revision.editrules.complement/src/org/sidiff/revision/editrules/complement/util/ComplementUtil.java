package org.sidiff.revision.editrules.complement.util;

import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getLHS;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getRHS;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getRemoteAttribute;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getRemoteNode;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.isRHSNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.MappingList;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.revision.common.henshin.HenshinRuleEditUtil;
import org.sidiff.revision.editrules.recognition.match.RecognitionActionMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionAttributeMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionEdgeMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionNodeMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionNodeMultiMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionNodeSingleMatch;

public class ComplementUtil {

	
	/**
	 * Derives the parameter for a rule by a given match.
	 * 
	 * @param rule
	 *            The with the parameters.
	 * @param match
	 *            The (partial) matching.
	 * @return The parameter values associated to {@link Rule#getParameters()}.
	 *         Unknown values will be set to null.
	 */
	public static List<Object> getParameters(Rule rule, Match match) {
		
		// Read attribute values:
		List<Attribute> attributes = new ArrayList<>();
		List<Object> values = new ArrayList<>();
		
		for (Node lhsNode : rule.getLhs().getNodes()) {
			for (Attribute attr : lhsNode.getAttributes()) {
				attributes.add(attr);
				EObject nodeMatch = match.getNodeTarget(attr.getNode());
				
				if (nodeMatch != null) {
					values.add(nodeMatch.eGet(attr.getType()));
				} else {
					values.add(null);
				}
			}
		}
		
		// Derive parameters:
		List<Object> input = new ArrayList<>();
		
		for (Parameter param : rule.getParameters()) {
			for (int i = 0; i < attributes.size(); i++) {
				Attribute attr = attributes.get(i);
				
				if (attr.getValue().equals(param.getName())) {
					Object value = values.get(i);
					
					if (value != null) {
						input.add(value);
						continue;
					}
				}
			}
			input.add(null);
		}
		
		return values;
	}
	
	/**
	 * @param graphElement
	 *            The node/edge/attribute which will be deleted from its graph.
	 */
	public static void deleteGraphElement(GraphElement graphElement) {
		
		if (graphElement instanceof Node) {
			deleteNode((Node) graphElement);
		}
		
		else if (graphElement instanceof Edge) {
			deleteEdge((Edge) graphElement);
		}
		
		else if (graphElement instanceof Attribute) {
			deleteAttribute((Attribute) graphElement);
		} 
		
		else {
			throw new RuntimeException("Unknown Graph-Elment: " + graphElement);
		}
	}

	/**
	 * @param node
	 *            The node which will be deleted from its graph.
	 */
	public static void deleteNode(Node node) {
		EcoreUtil.remove(node);
	}

	/**
	 * @param mapping
	 *            The mapped << preserve >> node.
	 */
	public static void deletePreserveNode(Mapping mapping) {
		EcoreUtil.remove(mapping);
		EcoreUtil.remove(mapping.getImage());
		EcoreUtil.remove(mapping.getOrigin());
	}
	
	/**
	 * Deletes a << preserve >> node -> LHS + RHS + Mapping.
	 * 
	 * @param node
	 *            The node which will be deleted from its graph.
	 * @return The RHS node if the given node was the LHS node; the LHS node otherwise.
	 */
	public static Node deletePreserveNode(Node node) {
		Node lhsNode;
		Node rhsNode;
		Node remoteNode;
		
		if (isRHSNode(node)) {
			rhsNode = node;
			lhsNode = getLHS(rhsNode);
			remoteNode = lhsNode;
		} else {
			lhsNode = node;
			rhsNode = getRHS(lhsNode);
			remoteNode = rhsNode;
		}
		
		EcoreUtil.remove(node.getGraph().getRule().getMappings().get(lhsNode, rhsNode));
		EcoreUtil.remove(lhsNode);
		EcoreUtil.remove(rhsNode);
		
		return remoteNode;
	}
	
	/**
	 * @param node
	 *            The attribute which will be deleted from its node.
	 */
	public static void deleteAttribute(Attribute attribute) {
		EcoreUtil.remove(attribute);
	}

	/**
	 * @param edge
	 *            The edge which will be deleted from its graph.
	 */
	public static void deleteEdge(Edge edge) {
		EcoreUtil.remove(edge);
		edge.getSource().getOutgoing().remove(edge);
		edge.getTarget().getIncoming().remove(edge);
	}
	
	/**
	 * @param attribute
	 *            The attribute that becomes a << preserve >> attribute.
	 */
	public static void makePreserve(Attribute attribute) {
		Node node = attribute.getNode();
		Rule rule = node.getGraph().getRule();
		MappingList mappings = rule.getMappings();
		
		// attribute value change x -> y:
		Attribute remoteAttribute = getRemoteAttribute(mappings, attribute);
		
		if (remoteAttribute != null) {
			remoteAttribute.getNode().getAttributes().remove(remoteAttribute);
		}
		
		// make attribute preserve:
		Node remoteNode = getRemoteNode(mappings, node);
		assert (remoteNode != null);
		
		HenshinRuleEditUtil.copyAttribute(remoteNode, attribute);
	}

	/**
	 * @param edge
	 *            The edge that becomes a << preserve >> edge.
	 * @return The copied edge.
	 */
	public static Edge makePreserve(Edge edge) {
		MappingList mappings = edge.getGraph().getRule().getMappings();
		Node remoteSource = getRemoteNode(mappings, edge.getSource());
		Node remoteTarget = getRemoteNode(mappings, edge.getTarget());

		if (remoteSource == null) {
			remoteSource = makePreserve(edge.getSource(), false);
		}

		if (remoteTarget == null) {
			remoteTarget = makePreserve(edge.getTarget(), false);
		}

		return HenshinRuleEditUtil.copyEdge(edge, remoteSource, remoteTarget);
	}

	/**
	 * @param node
	 *            The nodes that becomes a << preserve >> node.
	 * @param attributes
	 *            Make all attributes << preserve >>.
	 * @return The copied nodes.
	 */
	public static Node makePreserve(Node node, boolean attributes) {
		Rule rule = node.getGraph().getRule();

		if (isRHSNode(node)) {
			Node copiedNode = HenshinRuleEditUtil.copyNode(rule.getLhs(), node, attributes);
			Mapping mapping = HenshinFactory.eINSTANCE.createMapping(copiedNode, node);
			rule.getMappings().add(mapping);
			return copiedNode;
		} else {
			Node copiedNode = HenshinRuleEditUtil.copyNode(rule.getRhs(), node, attributes);
			Mapping mapping = HenshinFactory.eINSTANCE.createMapping(node, copiedNode);
			rule.getMappings().add(mapping);
			return copiedNode;
		}
	}

	/**
	 * @param match
	 *            A list of matches.
	 * @return A readable string of the matching.
	 */
	public static String printEditRuleMatch(Collection<RecognitionMatch> match) {
		StringBuffer print = new StringBuffer();

		for (RecognitionMatch editRuleMatch : match) {
			print.append("Match <");
			
			if (editRuleMatch instanceof RecognitionActionMatch) {
				print.append(((RecognitionActionMatch) editRuleMatch).getAction().toString());
			}

			if (editRuleMatch instanceof RecognitionNodeMatch) {
				print.append(", " + ((RecognitionNodeMatch) editRuleMatch).getNode());

				if (editRuleMatch instanceof RecognitionNodeSingleMatch) {
					print.append(", " + ((RecognitionNodeSingleMatch) editRuleMatch).getModelBElement());
				}

				else if (editRuleMatch instanceof RecognitionNodeMultiMatch) {
					print.append(", {");

					for (EObject modelElement : ((RecognitionNodeMultiMatch) editRuleMatch).getModelBElements()) {
						print.append(", " + modelElement);
					}

					print.append("}");
				}
			}

			else if (editRuleMatch instanceof RecognitionEdgeMatch) {
				print.append(", " + ((RecognitionEdgeMatch) editRuleMatch).getEdge());

				print.append(", SRC: " + ((RecognitionEdgeMatch) editRuleMatch).getSrcModelBElement());
				print.append(", TGT: " + ((RecognitionEdgeMatch) editRuleMatch).getTgtModelBElement());
			}
			
			else if (editRuleMatch instanceof RecognitionAttributeMatch) {
				print.append(", " + ((RecognitionAttributeMatch) editRuleMatch).getAttribute());
				print.append(", VALUE: " + ((RecognitionAttributeMatch) editRuleMatch).getValue());
			}

			print.append("\n");
		}

		return print.toString();
	}
}
