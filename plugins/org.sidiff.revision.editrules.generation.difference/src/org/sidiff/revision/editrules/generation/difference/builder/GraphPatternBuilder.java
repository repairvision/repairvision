package org.sidiff.revision.editrules.generation.difference.builder;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;
import static org.sidiff.revision.editrules.generation.difference.util.DifferenceToEditRuleUtil.convertToString;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.design.tools.diagram.ModelDiagramCreator;
import org.sidiff.graphpattern.util.GraphPatternConstants;
import org.sidiff.revision.common.emf.EMFStorage;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.editrules.generation.difference.util.Pair;

public class GraphPatternBuilder implements IEditRuleBuilder<GraphPattern, NodePattern, EdgePattern, AttributePattern> {

	private static GraphpatternFactory factory = GraphpatternFactory.eINSTANCE;
	
	private Bundle bundle;
	
	private Pattern pattern;
	
	private GraphPattern editrule;
	
	@Override
	public String getBuilderName() {
		return "Graph Pattern (with stereotypes)";
	}
	
	@Override
	public GraphPattern createEditRule(String name) {

		this.bundle = factory.createBundle();
		bundle.setName(name);
		
		this.pattern = factory.createPattern();
		pattern.setName(name);
		bundle.getPatterns().add(pattern);
		
		this.editrule = factory.createGraphPattern();
		editrule.setName(name);
		pattern.getGraphs().add(editrule);
		
		return editrule;
	}

	@Override
	public void finalizeEditRule() {
		bundle.getDomains().addAll(getImports());
	}
	
	private Set<EPackage> getImports() {
		Set<EPackage> imports = new HashSet<>();
		
		editrule.eAllContents().forEachRemaining(element -> {
			if (element instanceof NodePattern) {
				imports.add(((NodePattern) element).getType().getEPackage());
			}
		});
		
		return imports;
	}

	@Override
	public NodePattern createDeleteNode(String name, EClass type) {
		return factory.createNodePattern(editrule, name, type, delete);
	}

	@Override
	public EdgePattern createDeleteEdge(NodePattern source, NodePattern target, EReference type) {
		return factory.createEdgePattern(source, type, target, delete);
	}

	@Override
	public AttributePattern createDeleteAttribute(NodePattern node, EAttribute type, Object value) {
		return factory.createAttributePattern(node, type, convertToString(type, value), delete);
	}

	@Override
	public NodePattern createCreateNode(String name, EClass type) {
		return factory.createNodePattern(editrule, name, type, create);
	}

	@Override
	public EdgePattern createCreateEdge(NodePattern source, NodePattern target, EReference type) {
		return factory.createEdgePattern(source, type, target, create);
	}

	@Override
	public AttributePattern createCreateAttribute(NodePattern node, EAttribute type, Object value) {
		return factory.createAttributePattern(node, type, convertToString(type, value), create);
	}

	@Override
	public Pair<NodePattern> createPreservedNode(String name, EClass type) {
		NodePattern node = factory.createNodePattern(editrule, name, type, preserve);
		return new Pair<NodePattern>(node, node);
	}

	@Override
	public Pair<EdgePattern> createPreservedEdge(Pair<NodePattern> source, EReference type, Pair<NodePattern> target) {
		EdgePattern edge = factory.createEdgePattern(source.getLhs(), type, target.getLhs(), preserve);
		return new Pair<EdgePattern>(edge, edge);
	}

	@Override
	public Pair<AttributePattern> createPreserveAttribute(Pair<NodePattern> node, EAttribute type, Object value) {
		AttributePattern attribute = factory.createAttributePattern(node.getLhs(), type, convertToString(type, value), preserve);
		return new Pair<AttributePattern>(attribute, attribute);
	}

	@Override
	public Pair<AttributePattern> createAttributeValueChange(Pair<NodePattern> node, EAttribute type, Object valueA, Object valueB) {
		AttributePattern attributeA = factory.createAttributePattern(node.getLhs(), type, convertToString(type, valueA), create);
		AttributePattern attributeB = factory.createAttributePattern(node.getLhs(), type, convertToString(type, valueA), delete);
		return new Pair<AttributePattern>(attributeA, attributeB);
	}

	@Override
	public NodePattern getNodeLhs(String name) {
		return editrule.getNode(name);
	}

	@Override
	public NodePattern getNodeRhs(String name) {
		return editrule.getNode(name);
	}

	@Override
	public void setNodeType(NodePattern node, EClass type) {
		node.setType(type);
	}

	@Override
	public AttributePattern getAttribute(NodePattern node, EAttribute type) {
		return node.getAttribute(type);
	}

	@Override
	public void setAttributeType(AttributePattern attribute, EAttribute type) {
		attribute.setType(type);
	}

	@Override
	public void setAttributeNode(AttributePattern attribute, NodePattern node) {
		attribute.setNode(node);
	}

	@Override
	public void setAttributeValue(AttributePattern attribute, Object value) {
		attribute.setValue(convertToString(attribute.getType(), value));
	}

	@Override
	public EdgePattern getEdge(NodePattern source, EReference type, NodePattern target) {
		return source.getOutgoing(type, target);
	}

	@Override
	public void setEdgeType(EdgePattern edge, EReference type) {
		edge.setType(type);
	}

	@Override
	public void setEdgeSource(EdgePattern edge, NodePattern source) {
		edge.setSource(source);
	}

	@Override
	public void setEdgeTarget(EdgePattern edge, NodePattern target) {
		edge.setTarget(target);
	}

	@Override
	public int sizeNodes() {
		return editrule.getNodes().size();
	}

	@Override
	public int sizeEdges() {
		return editrule.getNodes().stream().map(NodePattern::getOutgoings).mapToInt(List::size).sum();
	}

	@Override
	public int sizeAttributes() {
		return editrule.getNodes().stream().map(NodePattern::getAttributes).mapToInt(List::size).sum();
	}

	@Override
	public Resource createResource(URI folder, String fileNameWithoutExtension) {
		URI uri = folder.appendSegment(fileNameWithoutExtension).appendFileExtension(GraphPatternConstants.FILE_EXTENSION);
		Resource resource = new ResourceSetImpl().createResource(uri);
		resource.getContents().add(bundle);
		return resource;
	}

	@Override
	public URI createRepresentation() {
		try {
			ModelDiagramCreator modelDiagramCreator = new ModelDiagramCreator(bundle, new NullProgressMonitor());
			modelDiagramCreator.createRepresentations(new NullProgressMonitor());
			return modelDiagramCreator.getDiagramFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void openRepresentation(URI diagram) {
		try {
			WorkbenchUtil.openEditor(EMFStorage.uriToPath(diagram));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
