package org.sidiff.repair.history.evaluation.driver.app;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class HistoryEvaluationApplication implements IApplication {

	// Run Headless Product:
	// eclipse -application org.sidiff.repair.history.evaluation.driver -consoleLog -noExit first second last
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("STARTING EVALUATION");
		return null;
	}

	@Override
	public void stop() {
	}
}
