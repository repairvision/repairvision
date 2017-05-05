package org.sidiff.common.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class WorkbenchUtil {

	public static void showView(String id) {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(id);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	public static IViewPart getView(String id) {
		IViewReference viewReferences[] = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getViewReferences();
		
		for (IViewReference viewReference : viewReferences) {
			if (id.equals(viewReference.getId())) {
				return viewReference.getView(false);
			}
		}

		return null;
	}

	public static void showMessage(String message) {
		MessageDialog.openInformation(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getTitle(),
				message);
	}
	
	public static void showError(String message) {
		MessageDialog.openError(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getTitle(),
				message);
	}
}
