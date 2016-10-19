package org.sidiff.consistency.repair.complement.util;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyAttribute;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRemoteNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isRHSNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
import org.sidiff.consistency.repair.complement.construction.match.EditRuleAttributeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMultiMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;

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
	public static String printEditRuleMatch(Collection<EditRuleMatch> match) {
		StringBuffer print = new StringBuffer();

		for (EditRuleMatch editRuleMatch : match) {
			print.append("Match <");
			print.append(editRuleMatch.getAction().toString());

			if (editRuleMatch instanceof EditRuleNodeMatch) {
				print.append(", " + ((EditRuleNodeMatch) editRuleMatch).getNode());

				if (editRuleMatch instanceof EditRuleNodeSingleMatch) {
					print.append(", " + ((EditRuleNodeSingleMatch) editRuleMatch).getModelBElement());
				}

				else if (editRuleMatch instanceof EditRuleNodeMultiMatch) {
					print.append(", {");

					for (EObject modelElement : ((EditRuleNodeMultiMatch) editRuleMatch).getModelBElements()) {
						print.append(", " + modelElement);
					}

					print.append("}");
				}
			}

			else if (editRuleMatch instanceof EditRuleEdgeMatch) {
				print.append(", " + ((EditRuleEdgeMatch) editRuleMatch).getEdge());

				print.append(", SRC: " + ((EditRuleEdgeMatch) editRuleMatch).getSrcModelBElement());
				print.append(", TGT: " + ((EditRuleEdgeMatch) editRuleMatch).getTgtModelBElement());
			}
			
			else if (editRuleMatch instanceof EditRuleAttributeMatch) {
				print.append(", " + ((EditRuleAttributeMatch) editRuleMatch).getAttribute());
				print.append(", VALUE: " + ((EditRuleAttributeMatch) editRuleMatch).getValue());
			}

			print.append("\n");
		}

		return print.toString();
	}
}
