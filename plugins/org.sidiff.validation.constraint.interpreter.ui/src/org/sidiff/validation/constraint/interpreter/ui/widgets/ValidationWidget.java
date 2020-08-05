package org.sidiff.validation.constraint.interpreter.ui.widgets;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.sidiff.revision.common.ui.widgets.IDisposableControl;
import org.sidiff.revision.common.ui.widgets.IUnsetableControl;
import org.sidiff.revision.impact.changetree.change.actions.ObjectChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.StructuralFeatureChangeAction;
import org.sidiff.revision.ui.editors.highlighting.EditorHighlighting;
import org.sidiff.revision.ui.editors.highlighting.ISelectionHighlightingAdapter;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.interpreter.ui.provider.RepairTreeContentProvider;
import org.sidiff.validation.constraint.interpreter.ui.provider.RepairTreeLabelProvider;

public class ValidationWidget implements IUnsetableControl, IDisposableControl {

	/**
	 * Shows the abstract repairs.
	 */
	private CheckboxTreeViewer viewer_validation;

	/**
	 * Editor decoration.
	 */
	private ISelectionHighlightingAdapter decorationAdapter;
	
	public void createControls(Composite parent) {
		
		// Validation-Viewer:
		Composite composite_viewer_validation = new Composite(parent, SWT.BORDER);
		composite_viewer_validation.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		viewer_validation = new CheckboxTreeViewer(composite_viewer_validation, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer_validation.setContentProvider(new RepairTreeContentProvider());
		viewer_validation.setLabelProvider(new RepairTreeLabelProvider());
		
		// Setup validation highlighting:
		decorationAdapter = new ISelectionHighlightingAdapter() {
			
			@Override
			public Iterator<EObject> getElements(ISelection selection) {
				
				if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
					Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
					
					if (selectedElement instanceof Validation) {
						Validation validation = (Validation) selectedElement;
						return Collections.singletonList(validation.getContext()).iterator();
					}
					
					else if (selectedElement instanceof StructuralFeatureChangeAction) {
						StructuralFeatureChangeAction repair = (StructuralFeatureChangeAction) selectedElement;
						return Collections.singletonList(repair.getContext()).iterator();
					}
					
					else if (selectedElement instanceof ObjectChangeAction) {
						ObjectChangeAction repair = (ObjectChangeAction) selectedElement;
						return Collections.singletonList(repair.getObject()).iterator();
					}
				}
				
				return null;
			}
		};
		EditorHighlighting.getInstance().registerAdapter(decorationAdapter);
		viewer_validation.addSelectionChangedListener(EditorHighlighting.getInstance().getSelectionChangedListener());
		
		// Double click action:
		viewer_validation.addDoubleClickListener(event -> {
			ISelection selection = event.getSelection();

			if (selection instanceof IStructuredSelection) {
				Object item = ((IStructuredSelection) selection).getFirstElement();

				if (item == null) {
					return;
				}
				if (viewer_validation.getExpandedState(item)) {
					viewer_validation.collapseToLevel(item, 1);
				}
				else {
					viewer_validation.expandToLevel(item, 1);
				}
			}
		});
	}
	
	public CheckboxTreeViewer getViewer() {
		return viewer_validation;
	}
	
	public void setInput(Object input) {
		viewer_validation.setInput(input);
	}
	
	@Override
	public void clear() {
		viewer_validation.setInput(null);
	}

	@Override
	public void dispose() {
		EditorHighlighting.getInstance().deregisterAdapter(decorationAdapter);
	}
}
