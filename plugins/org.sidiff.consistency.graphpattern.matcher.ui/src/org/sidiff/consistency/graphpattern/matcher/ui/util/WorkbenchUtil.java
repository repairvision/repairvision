package org.sidiff.consistency.graphpattern.matcher.ui.util;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class WorkbenchUtil {

	public static String TOOL_NAME = "Pattern Matching Engine";
	
	public static void showView(String id) {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(id);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
	
	public static void showMessage(String message) {
		MessageDialog.openInformation(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				TOOL_NAME + ": ",
				message);
	}
}
