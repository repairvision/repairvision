package org.sidiff.revision.repair.ui.peo.ruleselection;

import org.sidiff.revision.repair.api.peo.PEORepairFacade;
import org.sidiff.revision.repair.ui.presentation.IRepairPresentation;

public class RuleSelectionRepairPresentation implements IRepairPresentation {

	@Override
	public RuleSelectionRepairUI getRepairPresentation() {
		
		// Create application logic:
		RuleSelectionRepairApplication application = new RuleSelectionRepairApplication();
		application.initialize(new PEORepairFacade());
		
		// Create UI:
		RuleSelectionRepairUI repairUI = new RuleSelectionRepairUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
