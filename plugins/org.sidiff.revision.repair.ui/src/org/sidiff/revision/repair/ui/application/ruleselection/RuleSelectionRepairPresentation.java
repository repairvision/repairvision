package org.sidiff.revision.repair.ui.application.ruleselection;

import org.sidiff.revision.repair.api.RepairFacade;
import org.sidiff.revision.ui.presentation.ComplementationPresentation;

public class RuleSelectionRepairPresentation implements ComplementationPresentation {

	@Override
	public RuleSelectionRepairUI getComplementationPresentation() {
		
		// Create application logic:
		RuleSelectionRepairApplication application = new RuleSelectionRepairApplication();
		application.initialize(new RepairFacade());
		
		// Create UI:
		RuleSelectionRepairUI repairUI = new RuleSelectionRepairUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
