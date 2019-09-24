package org.sidiff.graphpattern.profile.henshin_extension.converter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.SubGraph;
import org.sidiff.graphpattern.profile.henshin.converter.GraphPatternToHenshinConverter;
import org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension;
import org.sidiff.graphpattern.profile.henshin_extension.HenshinExtensionFactory;
import org.sidiff.graphpattern.profile.henshin_extension.RuleExtension;

public class GraphPatternToHenshinExtensionConverter extends GraphPatternToHenshinConverter {

	private class HenshinSubGraph extends org.sidiff.graphpattern.profile.henshin_extension.impl.SubGraphImpl {}
	
	private Map<SubGraph, HenshinSubGraph> subGraphTrace = new HashMap<>();
	
	public GraphPatternToHenshinExtensionConverter(Pattern editOperation) {
		super(editOperation);
		convertSubGraphs(editOperation);
	}
	
	private void convertSubGraphs(Pattern editOperation) {
		for (GraphPattern graph : editOperation.getGraphs()) {
			for (SubGraph subGraph : graph.getSubgraphs()) {
				convertSubGraphs(graph, subGraph);
			}
		}
	}
	
	private void convertSubGraphs(GraphPattern parent, SubGraph subGraph) {
		HenshinSubGraph convertedSubGraph = convertSubGraph(subGraph);
		getRule(parent).getSubgraphs().add(convertedSubGraph);
		
		for (SubGraph nestedSubGraph : subGraph.getSubgraphs()) {
			convertSubGraphs(subGraph, nestedSubGraph);
		}
	}
	
	@Override
	public RuleExtension getRule(GraphPattern editRuleGraph) {
		return (RuleExtension) super.getRule(editRuleGraph);
	}
	
	private void convertSubGraphs(SubGraph parent, SubGraph subGraph) {
		HenshinSubGraph convertedSubGraph = convertSubGraph(subGraph);
		
		HenshinSubGraph convertedParent = subGraphTrace.get(parent);
		convertedParent.getSubgraphs().add(convertedSubGraph);
	}
	
	private HenshinSubGraph convertSubGraph(SubGraph subGraph) {
		HenshinSubGraph convertedSubGraph = new HenshinSubGraph();
		convertedSubGraph.setName(subGraph.getName());
		convertedSubGraph.setDescription(subGraph.getDescription());
		convertedSubGraph.getStereotypes().addAll(subGraph.getStereotypes());
		
		for (GraphElement element : subGraph.getElements()) {
			GraphElementExtension graphElementExtension = (GraphElementExtension) getTrace(element);
			convertedSubGraph.getElements().add(graphElementExtension);
		}
		
		subGraphTrace.put(subGraph, convertedSubGraph);
		return convertedSubGraph;
	}
	
	@Override
	protected Rule createRule() {
		return HenshinExtensionFactory.eINSTANCE.createRuleExtension();
	}
	
	@Override
	protected Node createNode() {
		return HenshinExtensionFactory.eINSTANCE.createNodeExtension();
	}
	
	@Override
	protected Edge createEdge() {
		return HenshinExtensionFactory.eINSTANCE.createEdgeExtension();
	}
	
	@Override
	protected Attribute createAttribute() {
		return HenshinExtensionFactory.eINSTANCE.createAttributeExtension();
	}
}
