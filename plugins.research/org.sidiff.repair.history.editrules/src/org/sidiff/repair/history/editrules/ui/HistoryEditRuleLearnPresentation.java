package org.sidiff.repair.history.editrules.ui;

import org.sidiff.revision.repair.api.RepairFacade;
import org.sidiff.revision.ui.presentation.ComplementationPresentation;

public class HistoryEditRuleLearnPresentation implements ComplementationPresentation {

	@Override
	public HistoryEditRuleLearnUI getComplementationPresentation() {
		
		// Create application logic:
		HistoryEditRuleLearnApplication application = new HistoryEditRuleLearnApplication();
		application.initialize(new RepairFacade());
		
		// Create UI:
		HistoryEditRuleLearnUI repairUI = new HistoryEditRuleLearnUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
