package org.sidiff.validation.laguage.fol.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.sidiff.validation.laguage.fol.ui.wizard.messages"; //$NON-NLS-1$
	
	public static String FolProjectWizard_Label;
	public static String FolProjectWizard_Description;
	
	static {
	// initialize resource bundle
	NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
