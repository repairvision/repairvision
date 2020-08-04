package org.sidiff.revision.repair.history.evaluation.ui;

import org.sidiff.revision.repair.api.RepairFacade;
import org.sidiff.revision.repair.ui.presentation.IRepairPresentation;

public class HistoryRepairPresentation implements IRepairPresentation {

	@Override
	public HistoryRepairUI getRepairPresentation() {
		
		// Create application logic:
		HistoryRepairApplication application = new HistoryRepairApplication();
		application.initialize(new RepairFacade());
		
		// Create UI:
		HistoryRepairUI repairUI = new HistoryRepairUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
