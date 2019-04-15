package org.sidiff.integration.eclipse;

import org.eclipse.ui.IStartup;

public class SidiffShotgun implements IStartup {

	@Override
	public void earlyStartup() {
		BundleHandler.getInstance().startBundles();
	}

}
