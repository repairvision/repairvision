package org.sidiff.common.henshin;

import static org.sidiff.common.henshin.HenshinMultiRuleAnalysis.getMultiRuleEdges;
import static org.sidiff.common.henshin.HenshinMultiRuleAnalysis.getMultiRuleNodes;
import static org.sidiff.common.henshin.HenshinMultiRuleAnalysis.getMultiRuleParameters;
import static org.sidiff.common.henshin.HenshinMultiRuleAnalysis.getMultiRulePreservedNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyNode;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyParameter;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.findMappingByImage;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getNodeImage;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isLHSEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isLHSNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.view.NodePair;

public class HenshinMultiRuleUtil {
	
	/**
	 * Create multi mapping.
	 * 
	 * @param multiRule
	 *            the multi rule.
	 * @param origin
	 *            the origin of the mapping. That's the kernel node.
	 * @param image
	 *            the image of the mapping. That's the multi node.
	 */
	public static void createMultiMapping(Rule multiRule, NodePair origin, NodePair image) {
		Mapping lhsMapping = HenshinFactory.eINSTANCE.createMapping();
		lhsMapping.setImage(image.getLhsNode());
		lhsMapping.setOrigin(origin.getLhsNode());
		multiRule.getMultiMappings().add(lhsMapping);

		Mapping rhsMapping = HenshinFactory.eINSTANCE.createMapping();
		rhsMapping.setImage(image.getRhsNode());
		rhsMapping.setOrigin(origin.getRhsNode());
		multiRule.getMultiMappings().add(rhsMapping);
	}

	/**
	 * Create multi mapping.
	 * 
	 * @param multiRule
	 *            the multi rule.
	 * @param origin
	 *            the origin of the mapping. That's the kernel node.
	 * @param image
	 *            the image of the mapping. That's the multi node.
	 */
	public static void createMultiMapping(Rule multiRule, Node origin, Node image) {

		if (image.getGraph().isLhs() && origin.getGraph().isLhs()) {

			Mapping lhsMapping = HenshinFactory.eINSTANCE.createMapping();
			lhsMapping.setImage(image);
			lhsMapping.setOrigin(origin);
			multiRule.getMultiMappings().add(lhsMapping);
		}

		if (image.getGraph().isRhs() && origin.getGraph().isRhs()) {

			Mapping rhsMapping = HenshinFactory.eINSTANCE.createMapping();
			rhsMapping.setImage(image);
			rhsMapping.setOrigin(origin);
			multiRule.getMultiMappings().add(rhsMapping);
		}
	}
	
	/**
	 * Copies the given rule (completely) as Multi-Rule including the Multi-Rule embedding.
	 * 
	 * @param kernelRule
	 *            The Kernel-Rule.
	 */
	public static Rule createMultiRule(Rule kernelRule) {
		
		// Create the Multi-Rule:
		Rule multiRule = HenshinFactory.eINSTANCE.createRule();
		Graph lhs = HenshinFactory.eINSTANCE.createGraph("LHS");
		Graph rhs = HenshinFactory.eINSTANCE.createGraph("RHS");
		multiRule.setLhs(lhs);
		multiRule.setRhs(rhs);
		
		kernelRule.getMultiRules().add(multiRule);
		
		// Trace: Origin -> Image
		Map<Node, Node> traces = new HashMap<Node, Node>();
		
		// Nodes (Attributes):
		for (Node kernelNode : kernelRule.getLhs().getNodes()) {
			Node multiNode = copyNode(lhs, kernelNode, true);
			traces.put(kernelNode, multiNode);
		}
		
		for (Node kernelNode : kernelRule.getRhs().getNodes()) {
			Node multiNode = copyNode(rhs, kernelNode, true);
			traces.put(kernelNode, multiNode);
		}
		
		// << preserve >> node mappings:
		for (Mapping mapping : kernelRule.getMappings()) {
			Mapping multiRulePreserveNodeMapping = HenshinFactory.eINSTANCE.createMapping(
					traces.get(mapping.getOrigin()),
					traces.get(mapping.getImage()));
			multiRule.getMappings().add(multiRulePreserveNodeMapping);
		}
		
		// Edges:
		for (Edge kernelEdge : kernelRule.getLhs().getEdges()) {
			copyEdge(kernelEdge, 
					traces.get(kernelEdge.getSource()), 
					traces.get(kernelEdge.getTarget()));
		}
		
		for (Edge kernelEdge : kernelRule.getRhs().getEdges()) {
			copyEdge(kernelEdge, 
					traces.get(kernelEdge.getSource()), 
					traces.get(kernelEdge.getTarget()));
		}
		
		// Parameters:
		for (Parameter kernelParameter : kernelRule.getParameters()) {
			copyParameter(multiRule, kernelParameter);
		}
		
		// Create Multi-Rule mappings:
		for (Entry<Node, Node> trace : traces.entrySet()) {
			Mapping multiRuleMapping = HenshinFactory.eINSTANCE.createMapping(
					trace.getKey(), 
					trace.getValue());
			multiRule.getMultiMappings().add(multiRuleMapping);
		}
		
		return multiRule;
	}
	
	/**
	 * Merge Multi-Rule B into Multi-Rule A by moving all Multi-Rule parts of Multi-Rule B into
	 * Multi-Rule A. Both Multi-Rules must have the same Kernel-Rule. Finally Multi-Rule B will be
	 * removed from the Kernel-Rule.
	 * 
	 * @param multiRuleA
	 *            Multi-Rule A
	 * @param multiRuleB
	 *            Multi-Rule B
	 * @return The merged rule.
	 */
	public static void mergeMultiRules(Rule multiRuleA, Rule multiRuleB) {
		
		assert (multiRuleA.getKernelRule() == multiRuleB.getKernelRule()) : "Both Multi-Rules must have the same Kernel-Rule.";

		// Multi-Rule B Nodes:
		for (Node nodeB : getMultiRuleNodes(multiRuleB)) {
			if (isLHSNode(nodeB)) {
				multiRuleA.getLhs().getNodes().add(nodeB);
			} else {
				multiRuleA.getRhs().getNodes().add(nodeB);
			}
		}
		
		// << preserve >> node mappings:
		for (Mapping mappingB : getMultiRulePreservedNodes(multiRuleB)) {
			multiRuleA.getMappings().add(mappingB);
		}
		
		// Multi-Rule B Edges:
		for (Edge edge : getMultiRuleEdges(multiRuleB)) {
			
			// Which side?
			Graph graph = null;

			if (isLHSEdge(edge)) {
				graph = multiRuleA.getLhs();
			} else {
				graph = multiRuleA.getRhs();

			}
			
			// Move Node:
			graph.getEdges().add(edge);
			
			// Fix glue nodes:
			Mapping srcMappingB = findMappingByImage(multiRuleB.getMultiMappings(), edge.getTarget());
			
			if (srcMappingB != null) {
				// Target node is a glue node:
				Node targetNode = getNodeImage(srcMappingB.getOrigin(), graph,
						multiRuleA.getMultiMappings());
				edge.setTarget(targetNode);
			}
			
			Mapping tgtMappingB = findMappingByImage(multiRuleB.getMultiMappings(), edge.getSource());
			
			if (tgtMappingB != null) {
				// Source node is a glue node:
				Node sourceNode = getNodeImage(tgtMappingB.getOrigin(), graph,
						multiRuleA.getMultiMappings());
				edge.setSource(sourceNode);
			}
		}
		
		// Parameters:
		for (Parameter parameterB : getMultiRuleParameters(multiRuleB)) {
			// Check for already existing parameter:
			if (multiRuleA.getParameter(parameterB.getName()) == null) {
				multiRuleA.getParameters().add(parameterB);
			}
		}
		
		// ***** Remove Multi-Rule B from the Kernel-Rule *****
		EcoreUtil.remove(multiRuleB);
	}
	
	/**
	 * Recreates the embedding of a given Multi-Rule. Please note that most parts (objects) of the
	 * existing Multi-Rule will be replaced, i.e. the rule, LHS/RHS graphs, embedded nodes / edges /
	 * attributes / parameters. Only the not embedded parts of the Multi-Rule will remain in the
	 * recalculated Multi-Rule.
	 * 
	 * @param multiRule
	 *            The Multi-Rule to process.
	 */
	public static void recreateMultiRuleEmbedding(Rule multiRule) {
		
		// Create an embedded copy of the Multi-Rule:
		Rule embeddedMultiRule = createMultiRule(multiRule.getKernelRule());
		embeddedMultiRule.setName(multiRule.getName());
		embeddedMultiRule.setDescription(multiRule.getDescription());
		embeddedMultiRule.setInjectiveMatching(multiRule.isInjectiveMatching());
		embeddedMultiRule.setCheckDangling(multiRule.isCheckDangling());
		embeddedMultiRule.setActivated(multiRule.isActivated());
		
		// Merge the old Multi-Rule into the embedding:
		mergeMultiRules(embeddedMultiRule, multiRule);
	}
}
