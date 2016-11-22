package org.sidiff.consistency.repair.ui.peo.ruleselection;

import org.sidiff.consistency.repair.api.peo.PEORepairFacadeFP;
import org.sidiff.consistency.repair.ui.presentation.IRepairPresentation;

public class PEORepairPresentationFP implements IRepairPresentation {

	@Override
	public PEORepairRuleSelectionUI getRepairPresentation() {
		
		// Create application logic:
		PEORepairApplication application = new PEORepairApplication();
		application.initialize(new PEORepairFacadeFP());
		
		// Create UI:
		PEORepairRuleSelectionUI repairUI = new PEORepairRuleSelectionUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
