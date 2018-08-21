package org.sidiff.historymodel.presentation.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.historymodel.ValidationError;
import org.sidiff.historymodel.Version;
import org.sidiff.historymodel.presentation.util.HistoryModelEditorTools;
import org.sidiff.repair.history.evaluation.util.EvaluationUtil;

public class ShowEditStepsOnResourceSetHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (!selection.isEmpty() && (selection instanceof IStructuredSelection)) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();
			
			if (selected instanceof ValidationError) {
				ValidationError inconsistency = (ValidationError) selected;
				
				Version beforeIntroduced = EvaluationUtil.getPrecessorRevision(inconsistency.getIntroducedIn());
				Version introduced = inconsistency.getIntroducedIn();
				
				HistoryModelEditorTools.compare(
						new ResourceSetImpl().getResource(getModelURI(beforeIntroduced), true).getResourceSet(),
						new ResourceSetImpl().getResource(getModelURI(introduced), true).getResourceSet());
				
				Version beforeResolved = EvaluationUtil.getPrecessorRevision(inconsistency.getResolvedIn());
				Version resolved = inconsistency.getResolvedIn();
				
				HistoryModelEditorTools.compare(
						new ResourceSetImpl().getResource(getModelURI(beforeResolved), true).getResourceSet(),
						new ResourceSetImpl().getResource(getModelURI(resolved), true).getResourceSet());
			}
		}
		
		return null;
	}
	
	private URI getModelURI(Version version) {
		return version.eResource().getURI().trimSegments(1).appendSegments(version.getModelURI().split("/"));
	}
}
