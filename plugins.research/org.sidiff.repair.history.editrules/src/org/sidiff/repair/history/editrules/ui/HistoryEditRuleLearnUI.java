package org.sidiff.repair.history.editrules.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.sidiff.historymodel.Problem;
import org.sidiff.repair.history.editrules.Activator;
import org.sidiff.revision.repair.history.evaluation.ui.HistoryRepairUI;

public class HistoryEditRuleLearnUI extends HistoryRepairUI {
	
	@Override
	public void createLocalToolBar(IToolBarManager manager) {
		super.createLocalToolBar(manager);
		
		// Edit-Rule Recorder //
		
		Action recordEditRule = new Action() {
			@Override
			public void run() {
				ISelection selection = historyInconsistenciesViewer.getSelection();
				
				if (selection instanceof IStructuredSelection) {
					for (Object selected : ((IStructuredSelection) selection).toList()) {
						if (selected instanceof Problem) {
							getApplication().learnEditRule((Problem) selected);
						}
					}
				}
			}
		};
		
		recordEditRule.setText("Learn Edit-Rule");
		recordEditRule.setToolTipText("Learn Edit-Rule");
		recordEditRule.setImageDescriptor(Activator.getImageDescriptor("icons/cat-icon.png"));
		
		manager.add(new Separator());
		manager.add(recordEditRule);
		manager.add(new Separator());
	}
	
	@Override
	public HistoryEditRuleLearnApplication getApplication() {
		return (HistoryEditRuleLearnApplication) super.getApplication();
	}
}
