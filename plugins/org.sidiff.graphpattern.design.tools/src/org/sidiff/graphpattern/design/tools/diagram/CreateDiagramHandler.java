package org.sidiff.graphpattern.design.tools.diagram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.revision.common.emf.EMFHandlerUtil;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;

public class CreateDiagramHandler extends AbstractHandler  {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Object selected = getSelection(event);
		
		if (selected instanceof IFile) {
			Resource resource = EMFHandlerUtil.getSelection(event);
			
			if (!resource.getContents().isEmpty()) {
				selected = resource.getContents().get(0);
			}
		}
		
		if (selected instanceof EObject) {
			IProgressMonitor monitor = new NullProgressMonitor();
			
			// new diagram:
			createDiagram((EObject) selected, WorkbenchUtil.askQuestion("Open diagram editors?"), monitor);
		}
		
		return null;
	}
	
	protected Object getSelection(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (!selection.isEmpty() && (selection instanceof IStructuredSelection)) {
			return ((IStructuredSelection) selection).getFirstElement();
		}
		
		return null;
	}
	
	protected void createDiagram(EObject modelElement, boolean openEditor, IProgressMonitor monitor) {
		
		try {
			ModelDiagramCreator modelDiagramCreator = new ModelDiagramCreator(modelElement, monitor);
			
			// Select diagrams:
			Set<EObject> selection = new HashSet<>(WorkbenchUtil.showSelections("Select diagrams to be created:", 
					new ArrayList<>(modelDiagramCreator.getRepresentations().keySet()), WorkbenchUtil.getEMFLabelProvider()));
			
			// Create diagrams:
			for (Entry<EObject, RepresentationDescription> representation : modelDiagramCreator.getRepresentations().entrySet()) {
				if (selection.contains(representation.getKey())) {
					String name = modelDiagramCreator.createRepresentation(representation.getKey(), representation.getValue(), monitor);
					
					// open editor:
					if (openEditor) {
						modelDiagramCreator.openRepresentation(representation.getValue(), name, monitor);
					}
				}
			}
		} catch (IOException e) {
			WorkbenchUtil.showError(e.getMessage());
		}
	}
}
