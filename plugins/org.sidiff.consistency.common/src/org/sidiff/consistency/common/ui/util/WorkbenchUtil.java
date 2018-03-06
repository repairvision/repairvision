package org.sidiff.consistency.common.ui.util;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class WorkbenchUtil {

	public static IViewPart showView(String id) {
		try {
			return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(id);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
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
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				MessageDialog.openInformation(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getTitle(),
						message);
			}
		});
	}
	
	public static void showError(String message) {
		Display.getDefault().asyncExec(new Runnable() {
		    @Override
		    public void run() {
				MessageDialog.openError(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getTitle(),
						message);
		    }
		});
	}
	
	public static boolean showQuestion(String question) {
		Boolean[] result = new Boolean[1];
		
		Display.getDefault().syncExec(new Runnable() {
		    @Override
		    public void run() {
		    	MessageBox messageBox = new MessageBox(
		    			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
		    			SWT.ICON_QUESTION | SWT.YES | SWT.NO);
		    	
		    	messageBox.setText(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
		    			.getActivePage().getActivePart().getTitle());
		        messageBox.setMessage(question);
		        
		        if (messageBox.open() == SWT.YES) {
		        	result[0] = true;
		        }
		    }
		});
		
		return result[0];
	}
}
