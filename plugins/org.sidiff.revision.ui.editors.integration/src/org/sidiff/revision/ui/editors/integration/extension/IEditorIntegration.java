package org.sidiff.revision.ui.editors.integration.extension;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;

public interface IEditorIntegration {

	String EXTENSION_POINT_ID = "org.sidiff.revision.ui.editors.integration.editor";
	
	String EXTENSION_POINT_ELEMENT= "editor";

	String EXTENSION_POINT_ATTRIBUTE = "class";

	/**
	 * @param editorPart The editor to be integrated.
	 * @return <code>true</code> if the editor part can be integrated by this Editor
	 *         Integration; <code>false</code> otherwise.
	 */
	boolean supports(IEditorPart editorPart);
	
	/**
	 * @param editorPart The editor to be integrated.
	 * @return The Editing of an EditorPart opened by this editor
	 */
	EditingDomain getEditingDomain(IEditorPart editorPart);

	/**
	 * @param editingDomain The editing domain of the editor.
	 * @return The selected model resource (i.e. not the diagram resources).
	 */
	Resource getSelectedResource(IEditorPart editorPart);

	/**
	 * @param selection A selection in the editor, e.g., graphical elements.
	 * @return A list of selected domain elements.
	 */
	List<EObject> getSelectedDomainElements(ISelection selection);

}
