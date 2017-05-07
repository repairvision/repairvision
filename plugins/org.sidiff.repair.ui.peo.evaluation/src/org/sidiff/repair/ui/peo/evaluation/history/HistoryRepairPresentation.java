package org.sidiff.repair.ui.peo.evaluation.history;

import org.sidiff.repair.api.peo.PEORepairFacade;
import org.sidiff.repair.ui.presentation.IRepairPresentation;

public class HistoryRepairPresentation implements IRepairPresentation {

	@Override
	public HistoryRepairUI getRepairPresentation() {
		
		// Create application logic:
		HistoryRepairApplication application = new HistoryRepairApplication();
		application.initialize(new PEORepairFacade());
		
		// Create UI:
		HistoryRepairUI repairUI = new HistoryRepairUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
