package org.sidiff.historymodel.presentation.handlers;

import java.io.FileNotFoundException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.revision.common.emf.EMFStorage;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;
import org.sidiff.revision.ui.editors.highlighting.EditorHighlighting;

public class FindModelElementByURIHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String modelElementURIString = WorkbenchUtil.askForValue("Model Element URI", 
				URI.createPlatformResourceURI("", false).toString(), null);
		
		if (modelElementURIString != null) {
			
			try {
				ISelection selection = HandlerUtil.getCurrentSelection(event);
				ResourceSet resourceSet = null;
				
				if (!selection.isEmpty() && (selection instanceof IStructuredSelection)) {
					Object selected = ((IStructuredSelection) selection).getFirstElement();
					
					if (selected instanceof EObject) {
						Resource resource = ((EObject) selected).eResource();
						resourceSet = resource.getResourceSet();
						
						// Convert file URI:
						String plugin = URI.createURI(resource.getURI().toPlatformString(true)).segment(0);
						
						if (modelElementURIString.startsWith("file:") && modelElementURIString.contains(plugin)) {
							String platformModelElementURIString = modelElementURIString.substring(
									modelElementURIString.indexOf(plugin), 
									modelElementURIString.length());
							URI platformModelElementURI = URI.createURI(platformModelElementURIString);
							
							platformModelElementURIString = URI.createPlatformResourceURI(
									platformModelElementURI.trimFragment().toString(), false)
									.appendFragment(platformModelElementURI.fragment()).toString();
							
							if (WorkbenchUtil.askQuestion("Convert to: " + platformModelElementURIString + "?")) {
								modelElementURIString = platformModelElementURIString;
							}
						}
					}
				}
				
				if (resourceSet != null) {
					
					URI modelElementURI = URI.createURI(modelElementURIString);
					URI resourceURI = modelElementURI.trimFragment();
					
					// Show the editor:
					WorkbenchUtil.openEditor(EMFStorage.uriToPath(resourceURI));
					
					// Highlight the model element:
					EObject modelElement = resourceSet.getEObject(modelElementURI, true);
					EditorHighlighting.getInstance().setSelection(Collections.singletonList(modelElement));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
