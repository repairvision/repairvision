package org.sidiff.revision.repair.ui.application.integrated;

import org.sidiff.revision.repair.api.RepairFacade;
import org.sidiff.revision.ui.presentation.ComplementationPresentation;

public class IntegratedRepairPresentation implements ComplementationPresentation {

	@Override
	public IntegratedRepairUI getComplementationPresentation() {
		
		// Create application logic:
		IntegratedRepairApplication application = new IntegratedRepairApplication();
		application.initialize(new RepairFacade());
		
		// Create UI:
		IntegratedRepairUI repairUI = new IntegratedRepairUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
