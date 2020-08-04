package org.sidiff.revision.repair.ui.peo.integrated;

import org.sidiff.revision.repair.api.RepairFacade;
import org.sidiff.revision.repair.ui.presentation.IRepairPresentation;

public class IntegratedRepairPresentation implements IRepairPresentation {

	@Override
	public IntegratedRepairUI getRepairPresentation() {
		
		// Create application logic:
		IntegratedRepairApplication application = new IntegratedRepairApplication();
		application.initialize(new RepairFacade());
		
		// Create UI:
		IntegratedRepairUI repairUI = new IntegratedRepairUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
