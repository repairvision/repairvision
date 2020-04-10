package org.sidiff.repair.history.editrules.ui;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.sidiff.history.analysis.tracing.InconsistencyTrace;
import org.sidiff.historymodel.Problem;
import org.sidiff.repair.history.editrules.driver.LearnEditRuleDriver;
import org.sidiff.revision.repair.history.evaluation.ui.HistoryRepairApplication;

public class HistoryEditRuleLearnApplication extends HistoryRepairApplication {

	public void learnEditRule(Problem selection) {
		
		calculation = new Job("Learn Edit Rule") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				InconsistencyTrace repaired = InconsistencyTrace.createRepairedInconsistency(selection, true);
				LearnEditRuleDriver.learnEditRule(history.getHistory(), history.getSupportedConsistencyRules(), getMatchingSettings(), repaired);
				return Status.OK_STATUS;
			}
		};
		
		calculation.schedule();
	}
}
