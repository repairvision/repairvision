package org.sidiff.integration.editor.extension;

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
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

public abstract class AbstractEditorIntegration implements IEditorIntegration {

	protected final String defaultEditorId, diagramEditorId;
	private Boolean defaultEditorPresent = null, diagramEditorPresent = null;

	public AbstractEditorIntegration(String defaultEditorId, String diagramEditorId) {
		super();
		this.defaultEditorId = defaultEditorId;
		this.diagramEditorId = diagramEditorId;
	}

	@Override
	public String getDefaultEditorID() {
		return defaultEditorId;
	}

	@Override
	public String getDiagramEditorID() {
		return diagramEditorId;
	}

	@Override
	public boolean isDefaultEditorPresent() {
		if (defaultEditorPresent == null)
			defaultEditorPresent = isEditorPresent(defaultEditorId);
		return defaultEditorPresent;
	}

	@Override
	public boolean isDiagramEditorPresent() {
		if (diagramEditorPresent == null)
			diagramEditorPresent = isEditorPresent(diagramEditorId);
		return diagramEditorPresent;
	}

	private static boolean isEditorPresent(String editorId) {
		if (editorId == null || editorId.isEmpty())
			return false;
		IEditorDescriptor descriptor = (IEditorDescriptor) PlatformUI
				.getWorkbench().getEditorRegistry().findEditor(editorId);
		return (descriptor != null);
	}

	@Override
	public EditingDomain getEditingDomain(IEditorPart editorPart) {
		if (editorPart instanceof IEditingDomainProvider) {
			IEditingDomainProvider editor = (IEditingDomainProvider) editorPart;
			return editor.getEditingDomain();
		}
		throw new UnsupportedOperationException("editorPart does not implement IEditingDomainProvider");
	}

	@Override
	public Resource getResource(IEditorPart editorPart) {
		if (editorPart instanceof IEditingDomainProvider) {
			IEditingDomainProvider editor = (IEditingDomainProvider) editorPart;
			return editor.getEditingDomain().getResourceSet().getResources().get(0);
		}
		throw new UnsupportedOperationException("editorPart does not implement IEditingDomainProvider");
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
