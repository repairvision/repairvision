package org.sidiff.repair.history.generator.analyzer;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.repair.history.generator.metadata.DataSetMetadata;

public class EcoreHistoryBuilderApplication implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		DataSetMetadata dataset = new DataSetMetadata("C:\\evaluation\\");
		
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
	}
}
