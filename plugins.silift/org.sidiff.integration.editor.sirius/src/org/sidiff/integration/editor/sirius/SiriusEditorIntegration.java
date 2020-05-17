package org.sidiff.integration.editor.sirius;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.diagram.ui.edit.api.part.AbstractBorderedDiagramElementEditPart;
import org.eclipse.sirius.diagram.ui.part.SiriusDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.sidiff.common.utilities.emf.SiriusUtil;
import org.sidiff.integration.editor.extension.DefaultEditorIntegration;

public class SiriusEditorIntegration extends DefaultEditorIntegration {

	@Override
	public boolean supports(IEditorPart editorPart) {
		return editorPart instanceof SiriusDiagramEditor;
	}
	
	@Override
	public List<EObject> getSelectedDomainElements(ISelection selection) {
		List<EObject> selected = new ArrayList<>();
				
		if (selection instanceof StructuredSelection) {
			for (Object element : ((StructuredSelection) selection).toList()) {
				if (element instanceof AbstractBorderedDiagramElementEditPart) {
					EObject modelElement = SiriusUtil.getSemanticElement((AbstractBorderedDiagramElementEditPart) element);
					
					if (modelElement != null) {
						selected.add(modelElement);
					}
				}
			}
		}
		
		return selected;
	}
	
}
