package org.sidiff.graphpattern.tools.model2graph;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.consistency.common.ui.util.WorkbenchUtil;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil;

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
					
					GraphPatternGeneratorUtil.saveBundle(patternURI, bundle);
				}
			}
		} else {
			WorkbenchUtil.showError("Nothing Selected!");
		}
		
		return null;
	}
	
	protected ModelToGraphPatternDefinitonFactory getDefinitionFactory() {
		return new ModelToGraphPatternDefinitonFactory();
	}
}
