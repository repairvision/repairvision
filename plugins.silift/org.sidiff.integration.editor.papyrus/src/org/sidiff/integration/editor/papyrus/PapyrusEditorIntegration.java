package org.sidiff.integration.editor.papyrus;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.UMLPackage;
import org.sidiff.integration.editor.extension.BasicEditorIntegration;

public class PapyrusEditorIntegration extends BasicEditorIntegration {

	private final String NOTATION_FILE_EXT = "notation";

	public PapyrusEditorIntegration() {
		super("org.eclipse.uml2.uml.editor.presentation.UMLEditorID",
			"org.eclipse.papyrus.infra.core.papyrusEditor",
			UMLPackage.eINSTANCE.getNsURI(), "uml", "di");
	}

	@Override
	protected URI[] getDiagramFiles(URI modelFile) {
		if (modelFileExt.equals(modelFile.fileExtension().toLowerCase())) {
			return new URI[] {
				modelFile.trimFileExtension().appendFileExtension(diagramFileExt),
				modelFile.trimFileExtension().appendFileExtension(NOTATION_FILE_EXT)
			};
		}
		return new URI[0];
	}

	@Override
	public boolean supportsGMFAnimation(URI diagramFile) {
		return false;
	}

	@Override
	protected boolean allowFileCopy(URI diagramFile) {
		return "di".equals(diagramFile.fileExtension()) || super.allowFileCopy(diagramFile);
	}

	@Override
	public EditingDomain getEditingDomain(IEditorPart editorPart) {
		if (editorPart instanceof PapyrusMultiDiagramEditor) {
			PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) editorPart;
			return editor.getEditingDomain();
		}
		return super.getEditingDomain(editorPart);
	}

	@Override
	public Resource getResource(IEditorPart editorPart) {
		if (editorPart instanceof PapyrusMultiDiagramEditor) {
			PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) editorPart;
			return editor.getEditingDomain().getResourceSet().getResources().get(0);
		}
		return super.getResource(editorPart);
	}

	@Override
	public Map<String, String> getFileExtensions() {
		Map<String, String>  extensions = new HashMap<String, String> ();
		extensions.put("notation", this.NOTATION_FILE_EXT);
		extensions.put("diagram", super.diagramFileExt);
		extensions.put("model", super.modelFileExt);
		return extensions;
	}
}
