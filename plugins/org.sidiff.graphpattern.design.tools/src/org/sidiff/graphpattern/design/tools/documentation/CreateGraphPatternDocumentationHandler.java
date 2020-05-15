package org.sidiff.graphpattern.design.tools.documentation;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.common.utilities.emf.EMFHandlerUtil;
import org.sidiff.common.utilities.ui.util.WorkbenchUtil;
import org.sidiff.graphpattern.Bundle;

public class CreateGraphPatternDocumentationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Bundle graphPatternBundle = EMFHandlerUtil.getSelection(event, Bundle.class);

		if (graphPatternBundle != null) {
			GraphPatternDocumentationCreator creator = new GraphPatternDocumentationCreator(
					WorkbenchUtil.showQuestion("Simplify/Merge tree nodes that contain just one child node?"),
					WorkbenchUtil.showQuestion("Generate diagrams?"), 
					WorkbenchUtil.showQuestion("Embed SVG into HTML?"));
			
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			IResource resource = ((IResource) ((StructuredSelection) selection).getFirstElement());
			
			creator.createDocumentation(resource, graphPatternBundle);
			
			// show new file in workspace:
			try {
				resource.getProject().refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
