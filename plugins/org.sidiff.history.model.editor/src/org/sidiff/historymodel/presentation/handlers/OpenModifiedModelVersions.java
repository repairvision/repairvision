package org.sidiff.historymodel.presentation.handlers;

import java.io.FileNotFoundException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.common.ui.util.UIUtil;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;
import org.sidiff.repair.history.evaluation.util.EvaluationUtil;

public class OpenModifiedModelVersions extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (!selection.isEmpty() && (selection instanceof IStructuredSelection)) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();
			
			if (selected instanceof Problem) {
				Problem inconsistency = (Problem) selected;
				
				Version beforeIntroduced = EvaluationUtil.getPredecessorRevision(inconsistency.getIntroducedIn());
				Version introduced = inconsistency.getIntroducedIn();
				Version beforeResolved = EvaluationUtil.getPredecessorRevision(inconsistency.getResolvedIn());
				Version resolved = inconsistency.getResolvedIn();
				
				if (beforeIntroduced != null) {
					try {
						UIUtil.openEditor(EMFStorage.uriToPath(beforeIntroduced.getModel().getURI()));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				
				if (introduced != null) {
					try {
						UIUtil.openEditor(EMFStorage.uriToPath(introduced.getModel().getURI()));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				
				if (beforeResolved != null) {
					try {
						UIUtil.openEditor(EMFStorage.uriToPath(beforeResolved.getModel().getURI()));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				
				if (resolved != null) {
					try {
						UIUtil.openEditor(EMFStorage.uriToPath(resolved.getModel().getURI()));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return null;
	}

}
