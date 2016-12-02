package org.sidiff.repair.ui.peo.ruleselection;

import org.sidiff.repair.api.peo.PEORepairFacadeMA;
import org.sidiff.repair.ui.presentation.IRepairPresentation;

public class PEORepairPresentationMA implements IRepairPresentation {

	@Override
	public PEORepairRuleSelectionUI getRepairPresentation() {
		
		// Create application logic:
		PEORepairApplication application = new PEORepairApplication();
		application.initialize(new PEORepairFacadeMA());
		
		// Create UI:
		PEORepairRuleSelectionUI repairUI = new PEORepairRuleSelectionUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
