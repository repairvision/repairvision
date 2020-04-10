package org.sidiff.graphpattern.tools.model2graph;

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
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.graphpattern.Bundle;

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
					bundle = new ModelToGraphPattern().convertToBundle((IFolder) selected, fileExtension, getDefinitionFactory());
				} else if (selected instanceof IFile) {
					bundle = new ModelToGraphPattern().convertToBundle((IFile) selected, getDefinitionFactory());
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
	
	protected ModelToGraphPatternDefinitonFactory getDefinitionFactory() {
		return new ModelToGraphPatternDefinitonFactory();
	}
}
