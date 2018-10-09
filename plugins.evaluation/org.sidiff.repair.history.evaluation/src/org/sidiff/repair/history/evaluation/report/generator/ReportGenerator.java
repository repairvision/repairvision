package org.sidiff.repair.history.evaluation.report.generator;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class ReportGenerator implements IApplication {
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		new ProjectReportGenerator();
		new InconsistencyReportGenerator();
		new EditRuleReportGenerator();
		
		return IApplication.EXIT_OK;
	}
	
	@Override
	public void stop() {
	}

}
