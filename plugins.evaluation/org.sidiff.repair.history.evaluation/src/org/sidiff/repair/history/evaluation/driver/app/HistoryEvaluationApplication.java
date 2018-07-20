package org.sidiff.repair.history.evaluation.driver.app;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class HistoryEvaluationApplication implements IApplication {

	// Export products/evaluation-driver.product
	// (If needed: update Contents/Add Required Plug-ins)
	// 
	// Run headless product from plugins folder (system independent):
	// java -jar org.eclipse.equinox.launcher_1.4.0.v20161219-1356.jar -application org.sidiff.repair.history.evaluation.driver -consoleLog -noExit first second last
	// 
	// or
	//
	// Run headless product with launcher (system dependent):
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
