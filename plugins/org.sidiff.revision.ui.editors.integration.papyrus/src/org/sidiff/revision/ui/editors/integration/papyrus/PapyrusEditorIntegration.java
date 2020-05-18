package org.sidiff.revision.ui.editors.integration.papyrus;

import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.sidiff.revision.ui.editors.integration.extension.DefaultEditorIntegration;

public class PapyrusEditorIntegration extends DefaultEditorIntegration {

	@Override
	public boolean supports(IEditorPart editorPart) {
		return editorPart instanceof PapyrusMultiDiagramEditor;
	}
	
}
