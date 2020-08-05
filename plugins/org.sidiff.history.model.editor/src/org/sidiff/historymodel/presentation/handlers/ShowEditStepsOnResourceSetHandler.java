package org.sidiff.historymodel.presentation.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;
import org.sidiff.historymodel.presentation.util.HistoryModelEditorTools;
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;

public class ShowEditStepsOnResourceSetHandler extends AbstractHandler {
	

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (!selection.isEmpty() && (selection instanceof IStructuredSelection)) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();
			
			if (selected instanceof Problem) {
				Problem inconsistency = (Problem) selected;
				
				if (inconsistency.isIntroduced()) {
					Version beforeIntroduced = inconsistency.getIntroducedIn().getPredecessor();
					Version introduced = inconsistency.getIntroducedIn();
					
					Resource beforeIntroducedResource = new ResourceSetImpl().getResource(getModelURI(beforeIntroduced), true);
					EcoreUtil.resolveAll(beforeIntroducedResource);
					Resource introducedResource = new ResourceSetImpl().getResource(getModelURI(introduced), true);
					EcoreUtil.resolveAll(introducedResource);
					
					HistoryModelEditorTools.compare(
							beforeIntroducedResource.getResourceSet(),
							introducedResource.getResourceSet());
				} else {
					WorkbenchUtil.showMessage("No introducing edit step found!");
				}
				
				if (inconsistency.isResolved()) {
					Version beforeResolved = inconsistency.getResolvedIn().getPredecessor();
					Version resolved = inconsistency.getResolvedIn();
					
					Resource beforeResolvedResource = new ResourceSetImpl().getResource(getModelURI(beforeResolved), true);
					EcoreUtil.resolveAll(beforeResolvedResource);
					Resource resolvedResource = new ResourceSetImpl().getResource(getModelURI(resolved), true);
					EcoreUtil.resolveAll(resolvedResource);
					
					HistoryModelEditorTools.compare(
							beforeResolvedResource.getResourceSet(),
							resolvedResource.getResourceSet());
				} else {
					WorkbenchUtil.showMessage("No resolving edit step found!");
				}
			}
		}
		
		return null;
	}
	
	private URI getModelURI(Version version) {
		return version.eResource().getURI().trimSegments(1).appendSegments(version.getModelURI().split("/"));
	}
}
