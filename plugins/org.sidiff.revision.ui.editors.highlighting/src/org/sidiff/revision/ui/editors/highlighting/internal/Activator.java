package org.sidiff.revision.ui.editors.highlighting.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.sidiff.revision.ui.editors.highlighting.internal.gmf.SelectionDecorationFigure;

public class Activator implements BundleActivator {

	private static BundleContext context;

	public static BundleContext getContext() {
		return context;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		Activator.context = context;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		Activator.context = null;

		// free resources
		SelectionDecorationFigure.dispose();
	}
}
