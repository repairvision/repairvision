package org.sidiff.revision.ui.editors.highlighting.internal.tree;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class SelectionControllerTreeViewer {

	private static SelectionControllerTreeViewer instance;
	
	private List<EObject> selected = new ArrayList<>();
	
	private Set<TreeViewer> treeViewersWithDecorations = new HashSet<>();

	public static SelectionControllerTreeViewer getInstance() {
		if (instance == null) {
			instance = new SelectionControllerTreeViewer();
		}
		return instance;
	}
	
	public List<EObject> getSelected() {
		return selected;
	}
	
	public synchronized void setSelection(List<EObject> selected) {
		
		// Set new selection:
		this.selected = selected;
		
		// Start the highlighting:
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				try {
					highlightTreeEditors();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void highlightTreeEditors() {
		
		// Clear old selection:
		for (TreeViewer treeViewer : treeViewersWithDecorations) {
			try {
				// Remove WrapperLabelProvider
				IBaseLabelProvider labelProvider = treeViewer.getLabelProvider();
				
				if (labelProvider instanceof WrapperLabelProvider) {
					treeViewer.setLabelProvider(((WrapperLabelProvider) labelProvider).getLabelProvider());
				}
				
				treeViewer.refresh();
			} catch (Exception e) {
				// do nothing as widget is disposed and will be cleared soon
			}
		}
		treeViewersWithDecorations.clear();

		// Set new selection:
		for (TreeEditorSelection treeEditor : findTreeEditors()) {
			Viewer viewer = treeEditor.editor.getViewer();

			if (viewer instanceof TreeViewer) {
				TreeViewer treeViewer = (TreeViewer) viewer;
				IBaseLabelProvider labelProvider = treeViewer.getLabelProvider();

				// Wrap the original label provider with one that highlights the selected elements:
				if (!(labelProvider instanceof WrapperLabelProvider)) {
					WrapperLabelProvider wrapper = new WrapperLabelProvider(
							(ILabelProvider) labelProvider, treeEditor.selection);
					treeViewer.setLabelProvider(wrapper);
				}

				treeViewersWithDecorations.add(treeViewer);

				// Show the elements in the tree:
				for (EObject selectedObject : treeEditor.selection) {
					treeViewer.reveal(selectedObject);
					treeViewer.update(selectedObject, null);
				}
			}
		}
	}

	private List<TreeEditorSelection> findTreeEditors() {
		List<TreeEditorSelection> editors = new ArrayList<>();

		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(window == null) {
			return editors;
		}

		// Search all opened editors in the workbench:
		for (IEditorReference editorReference : window.getActivePage()
				.getEditorReferences()) {
			IEditorPart editor = editorReference.getEditor(false);

			if (editor instanceof IViewerProvider) {

				try {
					if (editor != null
							&& (editor instanceof IEditingDomainProvider 
									|| editor instanceof IDiagramWorkbenchPart
									|| editor.getClass().getMethod("getEditingDomain", (Class<?>[]) null) != null)) {

						// Try everything to get the editor resources:
						Collection<Resource> editorResources = null;

						if (editor instanceof IEditingDomainProvider) {
							EditingDomain editingDomain = ((IEditingDomainProvider) editor).getEditingDomain();
							editorResources = editingDomain.getResourceSet().getResources();
						} else if (editor instanceof IDiagramWorkbenchPart) {
							editorResources = ((IDiagramWorkbenchPart) editor).getDiagram()
									.eResource().getResourceSet().getResources();
						} else {
							EditingDomain domain = (EditingDomain) editor.getClass()
									.getMethod("getEditingDomain", (Class<?>[]) null).invoke(editor);
							editorResources = domain.getResourceSet().getResources();
						}

						// Compare resources by URIs:
						List<EObject> editorSelected = new ArrayList<EObject>();

						for (EObject selectedObject : selected) {
							
							// NOTE: Otherwise there is no URI fragment!
							if (selectedObject.eResource() != null) {
								String selectedObjectFragment = EcoreUtil.getURI(selectedObject).fragment();
								
								if (!selectedObjectFragment.isEmpty()) {
									for (Resource resource : editorResources) {
										EObject result = resource.getEObject(selectedObjectFragment);
										
										if (result != null) {
											editorSelected.add(result);
										}
									}
								}
							}
						}

						if (!editorSelected.isEmpty()) {
							TreeEditorSelection selection = new TreeEditorSelection();
							selection.editor = (IViewerProvider) editor;
							selection.selection = editorSelected;
							editors.add(selection);
						}
					}
				} catch (SecurityException e) {
				} catch (NoSuchMethodException e) {
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {
				} catch (InvocationTargetException e) {
				}
			}
		}

		return editors;
	}

	private static class TreeEditorSelection {
		public IViewerProvider editor;
		public List<EObject> selection;

	}
}
