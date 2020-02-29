package org.sidiff.integration.editor.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.sidiff.integration.editor.access.DefaultEditorIntegration;
import org.sidiff.integration.editor.access.IntegrationEditorAccess;
import org.sidiff.integration.editor.extension.IEditorIntegration;

/**
 * Creates a snapshot of the currently active model editor.
 * 
 * @author Manuel Ohrndorf
 */
public class ModelEditorAccess {

	private IEditorPart editor;
	
	private IEditorIntegration editorIntegration;
	
	private EditingDomain editingDomain;
	
	private Resource modelResource;

	public ModelEditorAccess(IEditorPart editor) {
		this.editor = editor;
		
		if (editor != null) {
			getModelAccess();
		}
	}
	
	private void getModelAccess() {
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		
		if (editor == null) {
			return;
		}
		
		// check for editor integration extension (supported models):
		for (IEditorIntegration editorIntegration : IntegrationEditorAccess.getInstance().getIntegrationEditors()) {
			try {
				EditingDomain editingDomain = editorIntegration.getEditingDomain(editor);
				
				if (editingDomain != null) {
					for (Resource resource : editingDomain.getResourceSet().getResources()) {
						if (editorIntegration.supportsModel(resource.getURI())) {
							this.editorIntegration = editorIntegration;
							this.modelResource = resource;
							this.editingDomain = editingDomain;
							return;
						}
					}
				}
			} catch (Exception e) {
			}
		}
		
		// check for editor integration extension:
		for (IEditorIntegration editorIntegration : IntegrationEditorAccess.getInstance().getIntegrationEditors()) {
			try {
				EditingDomain editingDomain = editorIntegration.getEditingDomain(editor);
				
				if (editingDomain != null) {
					if (!editingDomain.getResourceSet().getResources().isEmpty()) {
						this.editorIntegration = editorIntegration;
						this.modelResource = editingDomain.getResourceSet().getResources().get(0);
						this.editingDomain = editingDomain;
						return;
					}
				}
			} catch (Exception e) {
			}
		}
		
		// get by reflection:
		for (Method method : editor.getClass().getMethods()) {
			if (method.getName().equals("getEditingDomain") && method.getReturnType().equals(EditingDomain.class)) {
				try {
					EditingDomain editingDomain = (EditingDomain) method.invoke(editor);
					
					if (editingDomain != null) {
						for (Resource resource : editingDomain.getResourceSet().getResources()) {
							this.editorIntegration = null;
							this.modelResource = resource;
							this.editingDomain = editingDomain;
							
							if (modelResource != null) {
								try {
									this.editorIntegration = DefaultEditorIntegration.getInstance(modelResource.getURI());
								} catch (Exception e) {
								}
							}
							
							return;
						}
					}
				} catch (Exception e) {
				}
			}
		}
	
		// get editor file input:
		if (editor.getEditorInput() instanceof FileEditorInput) {
			try {
				IFile file = ((FileEditorInput) editor.getEditorInput()).getFile();
				URI fileURI = URI.createFileURI(file.getLocation().toFile().getAbsolutePath());
				Resource resource = new ResourceSetImpl().getResource(fileURI, true);
				
				if ((resource != null) && (!resource.getContents().isEmpty())) {
					this.editorIntegration = null;
					this.modelResource = resource;
					this.editingDomain = null;
					
					if (modelResource != null) {
						try {
							this.editorIntegration = DefaultEditorIntegration.getInstance(modelResource.getURI());
						} catch (Exception e) {
						}
					}
					
					if (editorIntegration != null) {
						try {
							this.editingDomain = editorIntegration.getEditingDomain(editor);
						} catch (Exception e) {
						}
					}
					
					return;
				}
			} catch (Exception e) {
			}
		}
		
		// not found...
		this.editorIntegration = null;
		this.modelResource = null;
		this.editingDomain = null;
	}
	
	public IEditorPart getEditor() {
		return editor;
	}
	
	public IEditorIntegration getEditorIntegration() {
		return editorIntegration;
	}
	
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	public Resource getModelResource() {
		return modelResource;
	}
	
	public ISelection getEditorSelection() {
		if (editor != null) {
			return editor.getEditorSite().getSelectionProvider().getSelection();
		} else {
			return new ISelection() {
				public boolean isEmpty() {
					return true;
				}
			};
		}
	}
	
	public List<EObject> getModelSelection() {
		if (editorIntegration != null) {
			return editorIntegration.getSelectedDomainElements(getEditorSelection());
		} else {
			return getSelectedDomainElements(getEditorSelection());
		}
	}
	
	private List<EObject> getSelectedDomainElements(ISelection selection) {
		
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
