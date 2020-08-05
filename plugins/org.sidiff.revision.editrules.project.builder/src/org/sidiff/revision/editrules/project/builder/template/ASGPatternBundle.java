package org.sidiff.revision.editrules.project.builder.template;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.design.tools.diagram.ModelDiagramCreator;
import org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes;
import org.sidiff.graphpattern.profile.constraints.util.ConstraintProfileUtil;
import org.sidiff.revision.common.emf.MetaModelUtil;
import org.sidiff.revision.common.utilities.java.StringUtil;
import org.sidiff.revision.editrules.generation.generator.api.EditRuleGenerator;
import org.sidiff.revision.editrules.project.RuleBasePlugin;
import org.sidiff.validation.constraint.interpreter.IConstraint;

public class ASGPatternBundle {

	private Bundle patternBundle;
	
	public ASGPatternBundle(String name, String description) {
		this.patternBundle = GraphpatternFactory.eINSTANCE.createBundle();
		patternBundle.getProfiles().add(ConstraintStereotypes.instance);
		patternBundle.setName(name);
		patternBundle.setDescription(description);
	}
	
	public void addDocumentType(EPackage documentType) {
		patternBundle.getDomains().add(documentType);
	}
	
	public void initializeRelocationEdges() {
		EditRuleGenerator.initializeRelocationEdge(patternBundle);
	}
	
	public void addConstraint(IConstraint constraint, boolean initialize) {
		Pattern constraintPatterns = GraphpatternFactory.eINSTANCE.createPattern();
		constraintPatterns.setName(constraint.getName());
		constraintPatterns.setDescription(constraint.getMessage());
		constraintPatterns.getStereotypes().add(ConstraintStereotypes.constraint);
		patternBundle.getPatterns().add(constraintPatterns);
		
		if (initialize) {
			initializeConstraint(constraintPatterns, constraint);
		}
	}
	
	protected void initializeConstraint(Pattern constraintPatterns, IConstraint constraint) {
		EClass contextType = constraint.getContextType();
		
		for (EReference containment : getEAllContainers(contextType)) {
			createContextElementGraph(constraintPatterns, containment, contextType);
		}
	}

	private Set<EReference> getEAllContainers(EClass contextType) {
		Set<EReference> containerReferences = MetaModelUtil.getEAllContainers(patternBundle.getDomains(), contextType);
		
		if (MetaModelUtil.isRootContainer(containerReferences)) {
			containerReferences.add(GraphpatternPackage.eINSTANCE.getResource_Contents());
		}
		
		return containerReferences;
	}

	protected void createContextElementGraph(Pattern constraintPatterns, EReference containment, EClass contextType) {
		String patternName = getASGPatternName(containment, contextType);
		
		Pattern contextPattern = GraphpatternFactory.eINSTANCE.createPattern();
		contextPattern.setName(patternName);
		contextPattern.setDescription(getASGPatternDescription(containment, contextType));
		constraintPatterns.getPatterns().add(contextPattern);
		
		GraphPattern contextGraphPattern = GraphpatternFactory.eINSTANCE.createGraphPattern();
		contextGraphPattern.setName(patternName);
		contextPattern.getGraphs().add(contextGraphPattern);
		
		NodePattern containerNode = createPositiveStaticNode(containment.getEContainingClass(), contextGraphPattern);
		NodePattern contextNode = createDynamicNode(contextType, contextGraphPattern);
		createEdge(containerNode, containment, contextNode, contextGraphPattern);
	}

	protected String getASGPatternDescription(EReference containment, EClass contextType) {
		return "The ASG pattern with the context node " + contextType.getName()
				+ " which is contained by " + containment.getEContainingClass().getName() + ".";
	}

	protected String getASGPatternName(EReference containment, EClass contextType) {
		return contextType.getName() + "In"
				+ containment.getEContainingClass().getName() + "[" + containment.getName() + "]";
	}
	
	protected NodePattern createDynamicNode(EClass type, GraphPattern parentGraph) {
		return createNode(type, parentGraph);
	}
	
	protected NodePattern createPositiveStaticNode(EClass type, GraphPattern parentGraph) {
		NodePattern node = createNode(type, parentGraph);
		node.getStereotypes().add(ConstraintStereotypes.exists);
		return node;
	}

	protected NodePattern createNode(EClass type, GraphPattern parentGraph) {
		NodePattern node = GraphpatternFactory.eINSTANCE.createNodePattern();
		node.setName(getNodeName(type, parentGraph));
		node.setType(type);
		parentGraph.getNodes().add(node);
		
		return node;
	}

	protected String getNodeName(EClass type, GraphPattern parentGraph) {
		String baseName = StringUtil.toLowerFirst(type.getName());
		int count = 0;
		
		for (NodePattern node : parentGraph.getNodes()) {
			if (node.getName().equals(baseName) || ((count > 0) && node.getName().equals(baseName + count))) {
				++count;
			}
		}
		
		if (count > 0) {
			baseName = baseName + count;
		}
		
		return baseName;
	}
	
	protected EdgePattern createEdge(NodePattern source, EReference type, NodePattern target, GraphPattern parentGraph) {
		EdgePattern edge = GraphpatternFactory.eINSTANCE.createEdgePattern();
		edge.setSource(source);
		edge.setTarget(target);
		edge.setType(type);
		
		return edge;
	}

	public Bundle getPatternBundle() {
		return patternBundle;
	}
	
	public URI save(IProject project) {
		URI patternURI = URI.createPlatformResourceURI(project.getName() + "/" + RuleBasePlugin.GRAPHPATTERN_FILE, true);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(patternURI);
		resource.getContents().add(patternBundle);
		
		try {
			resource.save(Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return patternURI;
	}
	
	public DiagramURI saveWithDiagrams(IProject project, IProgressMonitor monitor) {
		URI modelURI = save(project);
		
		try {
			ModelDiagramCreator createDiagram = new PatternDiagramCreator(patternBundle, monitor);
			URI diagramURI = createDiagram.createRepresentations(monitor);
			
			return new DiagramURI(modelURI, diagramURI);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new DiagramURI(modelURI, null);
	}
	
	private class PatternDiagramCreator extends ModelDiagramCreator {

		public PatternDiagramCreator(EObject modelElement, IProgressMonitor monitor) throws IOException {
			super(modelElement, monitor);
		}
		
		@Override
		protected String getDiagramName(EObject modelElement) {
			
			if (modelElement instanceof GraphPattern) {
				String constraint = ConstraintProfileUtil.getParentConstraint(modelElement).getName();
				String pattern =  ((GraphPattern) modelElement).getName();
				
				return constraint + " - " + pattern;
			}
			
			return super.getDiagramName(modelElement);
		}
	}
	
	public static final class DiagramURI {
		
		public URI modelURI;
		public URI diagramURI;
		
		public DiagramURI(URI modelURI, URI diagramURI) {
			this.modelURI = modelURI;
			this.diagramURI = diagramURI;
		}
	}
}
