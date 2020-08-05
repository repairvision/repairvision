package org.sidiff.graphpattern.tools.model2graph.handler;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.tools.model2graph.FolderToBundleTransformation;
import org.sidiff.graphpattern.tools.model2graph.ModelToGraphPatternDefiniton;
import org.sidiff.graphpattern.tools.model2graph.ModelToGraphPatternFactory;
import org.sidiff.graphpattern.tools.model2graph.ModelToGraphPatternTransformation;
import org.sidiff.revision.common.emf.EMFHandlerUtil;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;

public class ModelToGraphPatternHandler extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if ((!selection.isEmpty()) && (selection instanceof IStructuredSelection)) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();
			
			if ((selected != null) && (selected instanceof IResource)) {
				Bundle bundle = null;
				
				if (selected instanceof IFolder) {
					String fileExtension = WorkbenchUtil.askForValue("File Extension:", "", (input) -> {
						if (input.isEmpty()) {
							return "Enter a file extension!";
						} else {
							return null;
						}
					});
					bundle = new FolderToBundleTransformation(
							Collections.singleton(fileExtension),
							getFactory()).toBundle((IFolder) selected);
				} else if (selected instanceof IFile) {
					ModelToGraphPatternFactory factory = getFactory();
					Resource modelFile = factory.loadModel((IFile) selected);
					ModelToGraphPatternDefiniton definition = factory.createDefinition(modelFile);
					ModelToGraphPatternTransformation transformation = factory.createTransformation(definition);
					
					bundle = transformation.toBundle(modelFile);
				}
				
				// save pattern:
				if (bundle != null) {
					URI patternURI = EMFHandlerUtil.getURI((IResource) selected).appendFileExtension("graphpattern");
					String path = WorkbenchUtil.askForValue("Save As:", patternURI.toString(), (input) -> null);
					
					if ((path != null) && (!path.equals(patternURI.toString()))) {
						patternURI = URI.createURI(path);
					}
					
					saveBundle(patternURI, bundle);
				}
			}
		} else {
			WorkbenchUtil.showError("Nothing Selected!");
		}
		
		return null;
	}
	
	protected void saveBundle(URI patternURI, Bundle bundle) {
		Resource patternResource = new ResourceSetImpl().createResource(patternURI);
		patternResource.getContents().add(bundle);

		try {
			patternResource.save(Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected ModelToGraphPatternFactory getFactory() {
		return new ModelToGraphPatternFactory();
	}
}
