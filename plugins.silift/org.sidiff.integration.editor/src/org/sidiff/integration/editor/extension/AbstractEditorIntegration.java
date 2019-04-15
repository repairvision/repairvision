package org.sidiff.integration.editor.extension;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
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
}
