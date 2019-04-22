package org.sidiff.repair.history.editrules.ui;

import org.sidiff.repair.api.peo.PEORepairFacade;
import org.sidiff.repair.ui.presentation.IRepairPresentation;

public class HistoryEditRuleLearnPresentation implements IRepairPresentation {

	@Override
	public HistoryEditRuleLearnUI getRepairPresentation() {
		
		// Create application logic:
		HistoryEditRuleLearnApplication application = new HistoryEditRuleLearnApplication();
		application.initialize(new PEORepairFacade());
		
		// Create UI:
		HistoryEditRuleLearnUI repairUI = new HistoryEditRuleLearnUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
