package org.sidiff.consistency.repair.ui.peo.ruleselection;

import org.sidiff.consistency.repair.api.peo.PEORepairFacade;
import org.sidiff.consistency.repair.ui.presentation.IRepairPresentation;

public class PEORepairPresentation implements IRepairPresentation {

	@Override
	public PEORepairRuleSelectionUI getRepairPresentation() {
		
		// Create application logic:
		PEORepairApplication application = new PEORepairApplication();
		application.initialize(new PEORepairFacade());
		
		// Create UI:
		PEORepairRuleSelectionUI repairUI = new PEORepairRuleSelectionUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
