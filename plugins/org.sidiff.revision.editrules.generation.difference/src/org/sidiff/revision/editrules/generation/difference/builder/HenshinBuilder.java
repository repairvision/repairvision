package org.sidiff.revision.editrules.generation.difference.builder;

import static org.sidiff.revision.editrules.generation.difference.util.DifferenceToEditRuleUtil.convertToString;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.diagram.edit.parts.ModuleEditPart;
import org.eclipse.emf.henshin.diagram.part.HenshinDiagramEditorPlugin;
import org.eclipse.emf.henshin.diagram.part.HenshinDiagramEditorUtil;
import org.eclipse.emf.henshin.diagram.part.HenshinVisualIDRegistry;
import org.eclipse.emf.henshin.diagram.part.Messages;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterKind;
import org.eclipse.emf.henshin.model.ParameterMapping;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.SequentialUnit;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.sidiff.revision.common.emf.EMFStorage;
import org.sidiff.revision.common.henshin.HenshinRuleEditUtil;
import org.sidiff.revision.common.henshin.pairs.AttributePair;
import org.sidiff.revision.common.henshin.pairs.EdgePair;
import org.sidiff.revision.common.henshin.pairs.NodePair;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.editrules.generation.difference.util.Pair;

public class HenshinBuilder implements IEditRuleBuilder<Rule, Node, Edge, Attribute> {
	
	private Module module;
	
	private SequentialUnit mainUnit;
	
	private Rule editrule;
	
	@Override
	public String getBuilderName() {
		return "Henshin";
	}
	
	@Override
	public Rule createEditRule(String name) {
		this.module = HenshinFactory.eINSTANCE.createModule();
		module.setName(name);

		this.mainUnit = HenshinFactory.eINSTANCE.createSequentialUnit();
		mainUnit.setName(name);
		module.getUnits().add(mainUnit);

		this.editrule = HenshinFactory.eINSTANCE.createRule(name);
		module.getUnits().add(editrule);
		mainUnit.getSubUnits().add(editrule);

		return editrule;
	}
	
	@Override
	public void finalizeEditRule() {
		editrule.getModule().getImports().addAll(getImports());
	}
	
	private Set<EPackage> getImports() {
		Set<EPackage> imports = new HashSet<>();
		
		editrule.eAllContents().forEachRemaining(element -> {
			if (element instanceof Node) {
				imports.add(((Node) element).getType().getEPackage());
			}
		});
		
		return imports;
	}

	private void createInputParameter(String name) {
		Parameter ruleAddNodeParameter = HenshinFactory.eINSTANCE.createParameter(name);
		ruleAddNodeParameter.setKind(ParameterKind.IN);
		editrule.getParameters().add(ruleAddNodeParameter);
		
		Parameter mainUnitAddOutParameter = HenshinFactory.eINSTANCE.createParameter(name);
		mainUnitAddOutParameter.setKind(ParameterKind.IN);
		mainUnit.getParameters().add(mainUnitAddOutParameter);
		
		ParameterMapping parameterMapping = HenshinFactory.eINSTANCE.createParameterMapping();
		parameterMapping.setSource(mainUnitAddOutParameter);
		parameterMapping.setTarget(ruleAddNodeParameter);
		mainUnit.getParameterMappings().add(parameterMapping);
	}
	
	private void createOutputParameter(String name) {
		Parameter ruleAddNodeParameter = HenshinFactory.eINSTANCE.createParameter(name);
		ruleAddNodeParameter.setKind(ParameterKind.OUT);
		editrule.getParameters().add(ruleAddNodeParameter);
		
		Parameter mainUnitAddOutParameter = HenshinFactory.eINSTANCE.createParameter(name);
		mainUnitAddOutParameter.setKind(ParameterKind.OUT);
		mainUnit.getParameters().add(mainUnitAddOutParameter);
		
		ParameterMapping parameterMapping = HenshinFactory.eINSTANCE.createParameterMapping();
		parameterMapping.setSource(ruleAddNodeParameter);
		parameterMapping.setTarget(mainUnitAddOutParameter);
		mainUnit.getParameterMappings().add(parameterMapping);
	}

	@Override
	public Node createDeleteNode(String name, EClass type) {
		return HenshinRuleEditUtil.createNode(editrule.getLhs(), name, type);
	}

	@Override
	public Edge createDeleteEdge(Node source, Node target, EReference type) {
		return HenshinRuleEditUtil.createEdge(editrule.getLhs(), source, type, target);
	}

	@Override
	public Attribute createDeleteAttribute(Node node, EAttribute type, Object value) {
		return HenshinRuleEditUtil.createAttribute(node, type, convertToString(type, value));
	}

	@Override
	public Node createCreateNode(String name, EClass type) {
		Node createNode = HenshinRuleEditUtil.createNode(editrule.getRhs(), name, type);
		createOutputParameter(name);
		return createNode;
	}

	@Override
	public Edge createCreateEdge(Node source, Node target, EReference type) {
		return HenshinRuleEditUtil.createEdge(editrule.getRhs(), source, type, target);
	}
	
	@Override
	public Attribute createCreateAttribute(Node node, EAttribute type, Object value) {
		return HenshinRuleEditUtil.createAttribute(node, type, convertToString(type, value));
	}

	@Override
	public Pair<Node> createPreservedNode(String name, EClass type) {
		NodePair preserveNode = HenshinRuleEditUtil.createPreservedNode(editrule, name, type);
		Pair<Node> result = new Pair<Node>(preserveNode.getLhsNode(), preserveNode.getRhsNode());
		
		createInputParameter(name);
		
		return result;
	}

	@Override
	public Pair<Edge> createPreservedEdge(Pair<Node> source, EReference type, Pair<Node> target) {
		NodePair preserveSrcNode = new NodePair(
				source.getLhs(), source.getRhs());
		NodePair preserveTgtNode = new NodePair(
				target.getLhs(), target.getRhs());

		EdgePair preserveEdge = HenshinRuleEditUtil.createPreservedEdge(editrule, preserveSrcNode, type, preserveTgtNode);
		
		return new Pair<Edge>(preserveEdge.getLhsEdge(), preserveEdge.getRhsEdge());
	}
	
	@Override
	public Pair<Attribute> createPreserveAttribute(Pair<Node> node, EAttribute type, Object value) {
		AttributePair preserveAttribute = HenshinRuleEditUtil.createPreservedAttribute(new NodePair(
				node.getLhs(), node.getRhs()), type, convertToString(type, value));
		
		return new Pair<Attribute>(preserveAttribute.getLhsAttribute(), preserveAttribute.getRhsAttribute()); 
	}

	@Override
	public Pair<Attribute> createAttributeValueChange(Pair<Node> node, EAttribute type, Object valueA, Object valueB) {
		Attribute attributeA = HenshinRuleEditUtil.createAttribute(node.getLhs(), type, convertToString(type, valueA));
		Attribute attributeB = HenshinRuleEditUtil.createAttribute(node.getRhs(), type, convertToString(type, valueB));
		return new Pair<Attribute>(attributeA, attributeB);
	}

	@Override
	public Node getNodeLhs(String name) {
		return editrule.getLhs().getNode(name);
	}
	
	@Override
	public Node getNodeRhs(String name) {
		return editrule.getRhs().getNode(name);
	}

	@Override
	public void setNodeType(Node node, EClass type) {
		node.setType(type);
	}

	@Override
	public Attribute getAttribute(Node node, EAttribute type) {
		return node.getAttribute(type);
	}

	@Override
	public void setAttributeType(Attribute attribute, EAttribute type) {
		attribute.setType(type);
	}

	@Override
	public void setAttributeNode(Attribute attribute, Node node) {
		attribute.setNode(node);
	}

	@Override
	public void setAttributeValue(Attribute attribute, Object value) {
		attribute.setValue(convertToString(attribute.getType(), value));
	}

	@Override
	public Edge getEdge(Node source, EReference type, Node target) {
		return source.getOutgoing(type, target);
	}

	@Override
	public void setEdgeType(Edge edge, EReference type) {
		edge.setType(type);
	}

	@Override
	public void setEdgeSource(Edge edge, Node source) {
		edge.setSource(source);
	}

	@Override
	public void setEdgeTarget(Edge edge, Node target) {
		edge.setTarget(target);
	}

	@Override
	public int sizeNodes() {
		return editrule.getLhs().getNodes().size() + editrule.getRhs().getNodes().size() ;
	}

	@Override
	public int sizeEdges() {
		return editrule.getLhs().getEdges().size() + editrule.getRhs().getEdges().size() ;
	}

	@Override
	public int sizeAttributes() {
		return (editrule.getLhs().getNodes().stream().map(Node::getAttributes).mapToInt(List::size).sum()
				+ editrule.getRhs().getNodes().stream().map(Node::getAttributes).mapToInt(List::size).sum());
	}

	@Override
	public Resource createResource(URI folder, String fileNameWithoutExtension) {
		URI uri = folder.appendSegment(fileNameWithoutExtension).appendFileExtension("henshin");
		Resource resource = new ResourceSetImpl().createResource(uri);
		resource.getContents().add(module);
		return resource;
	}
	
	@Override
	public URI createRepresentation() {
		Module module = editrule.getModule();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(module);
		
		if (editingDomain == null) {
			ResourceSet rss = module.eResource().getResourceSet();
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rss);
		}
		
		// Get diagram path:
		URI modelURI = EMFStorage.uriToPlatformUri(EcoreUtil.getURI(module));

		String projectName = modelURI.segment(1);
		String path = modelURI.trimFragment().trimSegments(1).toString()
				.replaceFirst("platform:/resource/" + projectName, "");
		String diagramName = modelURI.trimFileExtension().lastSegment() + ".henshin_diagram";

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(projectName);
		IFile diagramFile = null;
		
		if (!path.isEmpty()) {
			IFolder folder = project.getFolder(path);
			diagramFile = folder.getFile(diagramName);
		} else {
			diagramFile = project.getFile(diagramName);
		}
		
		if (!diagramFile.exists()) {
			try {
				byte[] bytes = "".getBytes();
			    InputStream source = new ByteArrayInputStream(bytes);
				diagramFile.create(source, IResource.NONE, null);
			} catch (CoreException e1) {
				e1.printStackTrace();
			}
		}

		LinkedList<IFile> affectedFiles = new LinkedList<IFile>();
		HenshinDiagramEditorUtil.setCharset(diagramFile);
		affectedFiles.add(diagramFile);

		URI diagramModelURI = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		ResourceSet resourceSet = editingDomain.getResourceSet();
		Resource diagramResource = resourceSet.createResource(diagramModelURI);

		AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain,
				Messages.HenshinNewDiagramFileWizard_InitDiagramCommand, affectedFiles) {

			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				int diagramVID = HenshinVisualIDRegistry.getDiagramVisualID(module);

				if (diagramVID != ModuleEditPart.VISUAL_ID) {
					return CommandResult.newErrorCommandResult(Messages.HenshinNewDiagramFileWizard_IncorrectRootError);
				}

				Diagram diagram = ViewService.createDiagram(module, ModuleEditPart.MODEL_ID,
						HenshinDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				diagramResource.getContents().add(diagram);

				return CommandResult.newOKCommandResult();
			}
		};

		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
			diagramResource.save(HenshinDiagramEditorUtil.getSaveOptions());
		} catch (ExecutionException e) {
			HenshinDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
		} catch (IOException e) {
			HenshinDiagramEditorPlugin.getInstance().logError("Save operation failed for: " + diagramModelURI, e); //$NON-NLS-1$
		}
		
		return diagramResource.getURI();
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
