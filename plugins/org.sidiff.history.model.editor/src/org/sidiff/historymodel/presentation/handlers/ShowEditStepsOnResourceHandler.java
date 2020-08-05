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
import org.sidiff.revision.common.ui.workbench.WorkbenchUtil;

public class ShowEditStepsOnResourceHandler extends AbstractHandler {

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
					
					HistoryModelEditorTools.compare(beforeIntroduced.getModel(), introduced.getModel());
				} else {
					WorkbenchUtil.showMessage("No introducing edit step found!");
				}
				
				if (inconsistency.isResolved()) {
					Version beforeResolved = inconsistency.getResolvedIn().getPredecessor();
					Version resolved = inconsistency.getResolvedIn();
					
					HistoryModelEditorTools.compare(beforeResolved.getModel(), resolved.getModel());
				} else {
					WorkbenchUtil.showMessage("No resolving edit step found!");
				}
			}
		}
		
		return null;
	}
}
