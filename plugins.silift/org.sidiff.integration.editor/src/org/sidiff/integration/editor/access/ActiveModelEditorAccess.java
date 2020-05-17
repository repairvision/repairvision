package org.sidiff.integration.editor.access;

import org.eclipse.ui.PlatformUI;

public class ActiveModelEditorAccess extends ModelEditorAccess {

	public ActiveModelEditorAccess() {
		super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor());
	}
}
