package org.sidiff.consistency.repair.lifting.ui.decoration;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.INullSelectionListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

public class RepairSelectionController implements ISelectionListener, ISelectionChangedListener, INullSelectionListener {

	private static RepairSelectionController instance;

	private CountDownLatch highlightingProcess;
	
	private List<EObject> selected = new ArrayList<>();

	private List<IDecorator> decorators = new ArrayList<>();

	private Map<EObject, IDecoratorTarget> decoratorTargets = new HashMap<>();
	
	private Set<TreeViewer> treeViewersWithDecorations = new HashSet<>();

	public static RepairSelectionController getInstance() {
		if (instance == null) {
			instance = new RepairSelectionController();
		}
		return instance;
	}

	public void unregisterDecorator(IDecorator decorator, IDecoratorTarget decoratorTarget) {
		decorators.remove(decorator);
		
		// Remove decorator targets:
		EObject object = null;
		
		for (Entry<EObject, IDecoratorTarget> entry : decoratorTargets.entrySet()) {
			if (entry.getValue().equals(decoratorTarget)) {
				object = entry.getKey();
			}
		}
		
		decoratorTargets.remove(object);
	}

	public void registerDecorator(IDecorator decorator, IDecoratorTarget decoratorTarget) {
		View view = (View) decoratorTarget.getAdapter(View.class);

		if (view.getElement() != null) {
			if (decoratorTargets.containsKey(view.getElement())) {
				View parent = view;
				boolean topMost = false;
				
				if (!(parent instanceof Diagram)) {
					while (!((parent = (View) parent.eContainer()) instanceof Diagram)) {
						if (parent == decoratorTargets.get(view.getElement()).getAdapter(View.class)) {
							topMost = true;
						}
					}
					if (!topMost) {
						decoratorTargets.put(view.getElement(), decoratorTarget);
					}
				}
			} else {
				decoratorTargets.put(view.getElement(), decoratorTarget);
			}
		}
		
		decorators.add(decorator);
	}
	
	public List<EObject> getSelected() {
		return selected;
	}
	
	public IDecoratorTarget getPrefferedDecoratorTarget(EObject element) {
		return decoratorTargets.get(element);
	}
	
	private synchronized void setSelection(ISelection selection) {
		
		// Synchronize previous highlighting:
		if (highlightingProcess != null) {
			try {
				highlightingProcess.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// Set new selection:
		selected = SelectionAdapter.getElements(selection);
		
		// Start the highlighting:
		highlightingProcess = new CountDownLatch(1);
		
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				highlightDiagrams();
				highlightTreeEditors();
				highlightingProcess.countDown();
			}
		});
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		setSelection(selection);
	}
	
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		setSelection(event.getSelection());
	}
	
	private void highlightDiagrams() {
		List<EObject> decoratedViews = new ArrayList<EObject>();
		
		for (int i = 0; i < decorators.size(); i++) {
			IDecorator decorator = decorators.get(i);
			
			if (decorator instanceof RepairSelectionDecorator) {
				View decoratedViewOrNull = ((RepairSelectionDecorator) decorator).decorate();
				if (decoratedViewOrNull != null && !(decoratedViewOrNull instanceof Diagram)) {
					decoratedViews.add(decoratedViewOrNull);
				}
			} else {
				decorator.refresh();
			}
		}
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

		// Search all opened editors in the workbench:
		for (IEditorReference editorReference : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
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
							String selectedObjectFragment = EcoreUtil.getURI(selectedObject).fragment();

							for (Resource resource : editorResources) {
								EObject result = resource.getEObject(selectedObjectFragment);

								if (result != null) {
									editorSelected.add(result);
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
