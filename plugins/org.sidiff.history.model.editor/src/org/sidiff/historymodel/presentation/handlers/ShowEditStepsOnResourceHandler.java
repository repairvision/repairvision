package org.sidiff.historymodel.presentation.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;
import org.sidiff.historymodel.presentation.util.HistoryModelEditorTools;
import org.sidiff.repair.history.evaluation.util.EvaluationUtil;

public class ShowEditStepsOnResourceHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (!selection.isEmpty() && (selection instanceof IStructuredSelection)) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();
			
			if (selected instanceof Problem) {
				Problem inconsistency = (Problem) selected;
				
				if (inconsistency.isIntroduced()) {
					Version beforeIntroduced = EvaluationUtil.getPredecessorRevision(inconsistency.getIntroducedIn());
					Version introduced = inconsistency.getIntroducedIn();
					
					HistoryModelEditorTools.compare(beforeIntroduced.getModel(), introduced.getModel());
				}
				
				if (inconsistency.isResolved()) {
					Version beforeResolved = EvaluationUtil.getPredecessorRevision(inconsistency.getResolvedIn());
					Version resolved = inconsistency.getResolvedIn();
					
					HistoryModelEditorTools.compare(beforeResolved.getModel(), resolved.getModel());
				}
			}
		}
		
		return null;
	}
}
