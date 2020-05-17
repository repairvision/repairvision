package org.sidiff.integration.editor.papyrus;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.sidiff.integration.editor.extension.DefaultEditorIntegration;

public class PapyrusEditorIntegration extends DefaultEditorIntegration {

	@Override
	public boolean supports(IEditorPart editorPart) {
		return editorPart instanceof PapyrusMultiDiagramEditor;
	}
	
	@Override
	public EditingDomain getEditingDomain(IEditorPart editorPart) {
		if (editorPart instanceof PapyrusMultiDiagramEditor) {
			PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) editorPart;
			return editor.getEditingDomain();
		}
		return null;
	}
}
