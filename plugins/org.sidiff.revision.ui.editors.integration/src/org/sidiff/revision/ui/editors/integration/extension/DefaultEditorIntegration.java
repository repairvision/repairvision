package org.sidiff.revision.ui.editors.integration.extension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;

public class DefaultEditorIntegration implements IEditorIntegration {

	private static DefaultEditorIntegration instances;

	public static DefaultEditorIntegration getInstance() {
		if(instances == null) {
			instances = new DefaultEditorIntegration();
		}
		return instances;
	}
	
	@Override
	public boolean supports(IEditorPart editorPart) {
		return editorPart instanceof IEditingDomainProvider;
	}

	@Override
	public EditingDomain getEditingDomain(IEditorPart editorPart) {
		if (editorPart instanceof IEditingDomainProvider) {
			IEditingDomainProvider editor = (IEditingDomainProvider) editorPart;
			return editor.getEditingDomain();
		}
		return null;
	}
	
	@Override
	public Resource getSelectedResource(IEditorPart editorPart) {
		ISelection selection = editorPart.getSite().getSelectionProvider().getSelection();
		List<EObject> selectedModelElements = getSelectedDomainElements(selection);
		
		if (!selectedModelElements.isEmpty()) {
			return selectedModelElements.get(0).eResource();
		}
		
		return null;
	}
	
	@Override
	public List<EObject> getSelectedDomainElements(ISelection selection) {
		
		// https://wiki.eclipse.org/Papyrus/Papyrus_Developer_Guide/How_To_Code_Examples#How_to_Get_the_Current_Selection_from_Java_code
		// https://wiki.eclipse.org/Papyrus/Papyrus_Developer_Guide/How_To_Code_Examples#How_to_adapt_a_Graphical_Object_to_underlying_Domain_.28UML.29
		if ((selection != null) && !selection.isEmpty() && (selection instanceof IStructuredSelection)) {
			List<EObject> selected = new ArrayList<EObject>();

			for (Object selectedObject : ((IStructuredSelection) selection).toArray()) {
				EObject element = null;
				
				if (selectedObject instanceof IAdaptable) {
					element = ((IAdaptable) selectedObject).getAdapter(EObject.class);
				}
				if (element == null) {
					element = Platform.getAdapterManager().getAdapter(selectedObject, EObject.class);
				}
				if (element != null) {
					selected.add(element);
				}
			}
			return selected;
		}
		return Collections.emptyList();
	}
}
