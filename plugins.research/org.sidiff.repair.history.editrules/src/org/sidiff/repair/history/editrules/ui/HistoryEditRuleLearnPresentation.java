package org.sidiff.repair.history.editrules.ui;

import org.sidiff.revision.repair.api.RepairFacade;
import org.sidiff.revision.repair.ui.presentation.IRepairPresentation;

public class HistoryEditRuleLearnPresentation implements IRepairPresentation {

	@Override
	public HistoryEditRuleLearnUI getRepairPresentation() {
		
		// Create application logic:
		HistoryEditRuleLearnApplication application = new HistoryEditRuleLearnApplication();
		application.initialize(new RepairFacade());
		
		// Create UI:
		HistoryEditRuleLearnUI repairUI = new HistoryEditRuleLearnUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
