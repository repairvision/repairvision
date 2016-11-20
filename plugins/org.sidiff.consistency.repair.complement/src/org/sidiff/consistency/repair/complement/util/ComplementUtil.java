package org.sidiff.consistency.repair.complement.util;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.*;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRemoteNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isRHSNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
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
import org.sidiff.consistency.repair.api.matching.EOAttributeMatch;
import org.sidiff.consistency.repair.api.matching.EOEdgeMatch;
import org.sidiff.consistency.repair.api.matching.EOMatch;
import org.sidiff.consistency.repair.api.matching.EONodeMatch;
import org.sidiff.consistency.repair.api.matching.EONodeMultiMatch;
import org.sidiff.consistency.repair.api.matching.EONodeSingleMatch;

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
	 * Creates a deep copy (i.e. full tree content) of the given object.
	 * 
	 * @param original
	 *            The root object which will be copied.
	 * @return The copy trace: Original -> Copy
	 */
	public static Map<EObject, EObject> deepCopy(EObject original) {

		// Copier = Map: Original -> Copy
		Copier copier = new Copier();

		// Root:
		copier.copy(original);

		// References:
		copier.copyReferences();

		return copier;
	}
	
	/**
	 * @param copy
	 *            The copied object.
	 * @param copyTrace
	 *            The copy trace: Original -> Copy
	 * @return The original object.
	 */
	public static EObject getReverseTrace(EObject copy, Map<EObject, EObject> copyTrace) {
		
		for (Entry<EObject, EObject> trace : copyTrace.entrySet()) {
			if (trace.getValue() == copy) {
				return trace.getKey();
			}
		}
		
		return null;
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
		
		Node remoteNode = getRemoteNode(mappings, node);
		assert (remoteNode != null);
		
		copyAttribute(remoteNode, attribute);
	}

	/**
	 * @param edge
	 *            The edge that becomes a << preserve >> edge.
	 */
	public static void makePreserve(Edge edge) {
		MappingList mappings = edge.getGraph().getRule().getMappings();
		Node source = getRemoteNode(mappings, edge.getSource());
		Node target = getRemoteNode(mappings, edge.getTarget());

		if (source == null) {
			makePreserve(source);
		}

		if (target == null) {
			makePreserve(target);
		}

		copyEdge(edge, source, target);
	}

	/**
	 * @param node
	 *            The nodes that becomes a << preserve >> node.
	 */
	public static void makePreserve(Node node) {
		Rule rule = node.getGraph().getRule();

		if (isRHSNode(node)) {
			Node copiedNode = copyNode(rule.getLhs(), node, true);
			Mapping mapping = HenshinFactory.eINSTANCE.createMapping(copiedNode, node);
			rule.getMappings().add(mapping);
		} else {
			Node copiedNode = copyNode(rule.getRhs(), node, true);
			Mapping mapping = HenshinFactory.eINSTANCE.createMapping(node, copiedNode);
			rule.getMappings().add(mapping);
		}
	}

	/**
	 * @param match
	 *            A list of matches.
	 * @return A readable string of the matching.
	 */
	public static String printEditRuleMatch(Collection<EOMatch> match) {
		StringBuffer print = new StringBuffer();

		for (EOMatch editRuleMatch : match) {
			print.append("Match <");
			print.append(editRuleMatch.getAction().toString());

			if (editRuleMatch instanceof EONodeMatch) {
				print.append(", " + ((EONodeMatch) editRuleMatch).getNode());

				if (editRuleMatch instanceof EONodeSingleMatch) {
					print.append(", " + ((EONodeSingleMatch) editRuleMatch).getModelBElement());
				}

				else if (editRuleMatch instanceof EONodeMultiMatch) {
					print.append(", {");

					for (EObject modelElement : ((EONodeMultiMatch) editRuleMatch).getModelBElements()) {
						print.append(", " + modelElement);
					}

					print.append("}");
				}
			}

			else if (editRuleMatch instanceof EOEdgeMatch) {
				print.append(", " + ((EOEdgeMatch) editRuleMatch).getEdge());

				print.append(", SRC: " + ((EOEdgeMatch) editRuleMatch).getSrcModelBElement());
				print.append(", TGT: " + ((EOEdgeMatch) editRuleMatch).getTgtModelBElement());
			}
			
			else if (editRuleMatch instanceof EOAttributeMatch) {
				print.append(", " + ((EOAttributeMatch) editRuleMatch).getAttribute());
				print.append(", VALUE: " + ((EOAttributeMatch) editRuleMatch).getValue());
			}

			print.append("\n");
		}

		return print.toString();
	}
}
