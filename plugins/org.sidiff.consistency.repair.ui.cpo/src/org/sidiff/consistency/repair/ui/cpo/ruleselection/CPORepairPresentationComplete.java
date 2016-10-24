package org.sidiff.consistency.repair.ui.cpo.ruleselection;

import org.sidiff.consistency.repair.api.cpo.CPORepairFacadeComplete;
import org.sidiff.consistency.repair.ui.presentation.IRepairPresentation;

public class CPORepairPresentationComplete implements IRepairPresentation {

	@Override
	public CPORepairRuleSelectionUI getRepairPresentation() {
		
		// Create application logic:
		CPORepairApplication application = new CPORepairApplication();
		application.initialize(new CPORepairFacadeComplete());
		
		// Create UI:
		CPORepairRuleSelectionUI repairUI = new CPORepairRuleSelectionUI();
		repairUI.initialize(application);
		return repairUI;
	}
}
