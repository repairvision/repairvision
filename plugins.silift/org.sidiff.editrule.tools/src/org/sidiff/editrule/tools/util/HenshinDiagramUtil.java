package org.sidiff.editrule.tools.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.diagram.edit.parts.ModuleEditPart;
import org.eclipse.emf.henshin.diagram.part.HenshinDiagramEditorPlugin;
import org.eclipse.emf.henshin.diagram.part.HenshinDiagramEditorUtil;
import org.eclipse.emf.henshin.diagram.part.HenshinVisualIDRegistry;
import org.eclipse.emf.henshin.diagram.part.Messages;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.PartInitException;
import org.sidiff.common.emf.modelstorage.EMFStorage;

public class HenshinDiagramUtil {

	public static Resource createDiagram(Module editRule) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(editRule);
		
		if (editingDomain == null) {
			ResourceSet rss = editRule.eResource().getResourceSet();
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rss);
		}
		
		// Get diagram path:
		URI modelURI = EMFStorage.uriToPlatformUri(EcoreUtil.getURI(editRule));

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
				int diagramVID = HenshinVisualIDRegistry.getDiagramVisualID(editRule);

				if (diagramVID != ModuleEditPart.VISUAL_ID) {
					return CommandResult.newErrorCommandResult(Messages.HenshinNewDiagramFileWizard_IncorrectRootError);
				}

				Diagram diagram = ViewService.createDiagram(editRule, ModuleEditPart.MODEL_ID,
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
		
		return diagramResource;
	}
	
	public static void openDiagram(Resource diagramResource) {
		try {
			HenshinDiagramEditorUtil.openDiagram(diagramResource);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean maxNodeCount(Module editRule, int maxNodeCount) {
		Integer nodeCount = 0;
		
		for (Iterator<EObject> iterator = editRule.eAllContents(); iterator.hasNext();) {
			EObject element = iterator.next();
			
			if (element instanceof Node) {
				++nodeCount;
				
				if (nodeCount > maxNodeCount) {
					return false;
				}
			}
		}
		
		return true;
	}
}
