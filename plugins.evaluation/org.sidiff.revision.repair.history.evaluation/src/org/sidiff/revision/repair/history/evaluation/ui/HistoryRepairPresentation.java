package org.sidiff.revision.repair.history.evaluation.ui;

import org.sidiff.revision.repair.api.RepairFacade;
import org.sidiff.revision.ui.presentation.ComplementationPresentation;

public class HistoryRepairPresentation implements ComplementationPresentation {

	@Override
	public HistoryRepairUI getComplementationPresentation() {
		
		// Create application logic:
		HistoryRepairApplication application = new HistoryRepairApplication();
		application.initialize(new RepairFacade());
		
		// Create UI:
		HistoryRepairUI repairUI = new HistoryRepairUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
