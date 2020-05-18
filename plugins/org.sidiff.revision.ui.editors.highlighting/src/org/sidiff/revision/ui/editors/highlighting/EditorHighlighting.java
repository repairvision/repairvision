package org.sidiff.revision.ui.editors.highlighting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.INullSelectionListener;
import org.eclipse.ui.ISelectionListener;
import org.sidiff.revision.ui.editors.highlighting.internal.SelectionController;

/**
 * Singleton ({@link #getInstance()}) which registers the highlighting adapters
 * ({@link ISelectionHighlightingAdapter}) that convert a selection to model
 * elements. The highlighting is triggered by a selection listener
 * ({@link #getSelectionListener()}, {@link #getSelectionChangedListener()},
 * {@link #getNullSelectionListener()})
 * 
 * @author Manuel Ohrndorf
 */
public class EditorHighlighting {

	private static EditorHighlighting instance;

	private List<ISelectionHighlightingAdapter> adapters = new LinkedList<>();

	/**
	 * @return The singleton of the highlighting registry.
	 */
	public static EditorHighlighting getInstance() {
		if (instance == null) {
			instance = new EditorHighlighting();
		}
		return instance;
	}

	/**
	 * @param adapter
	 *            The highlighting adapters that convert a selection to model
	 *            elements.
	 */
	public void registerAdapter(ISelectionHighlightingAdapter adapter) {
		adapters.add(adapter);
	}

	/**
	 * @param adapter
	 *            The highlighting adapters that convert a selection to model
	 *            elements.
	 */
	public void deregisterAdapter(ISelectionHighlightingAdapter adapter) {
		adapters.remove(adapter);
	}

	/**
	 * @return A listener that can be registered to a viewer. All selections
	 *         will be converted to model elements that will be highlighted.
	 */
	public ISelectionListener getSelectionListener() {
		return SelectionController.getInstance();
	}

	/**
	 * @return A listener that can be registered to a viewer. All selections
	 *         will be converted to model elements that will be highlighted.
	 */
	public ISelectionChangedListener getSelectionChangedListener() {
		return SelectionController.getInstance();
	}

	/**
	 * @return A listener that can be registered to a viewer. All selections
	 *         will be converted to model elements that will be highlighted.
	 */
	public INullSelectionListener getNullSelectionListener() {
		return SelectionController.getInstance();
	}

	/**
	 * @return The current selection.
	 */
	public List<EObject> getSelection() {
		return SelectionController.getInstance().getSelected();
	}

	/**
	 * Overwrites the actual selection (listener).
	 * 
	 * @param selected
	 *            A new selection.
	 * 
	 * @see #getSelectionListener()
	 * @see #getSelectionChangedListener()
	 * @see #getNullSelectionListener()
	 */
	public void setSelection(List<EObject> selected) {
		SelectionController.getInstance().setSelection(selected);
	}

	/**
	 * @param selection
	 *            The selection that will be appended.
	 */
	public void appendSelection(List<EObject> selection) {
		SelectionController.getInstance().appendSelection(selection);
	}

	/**
	 * @param selection
	 *            A UI selection.
	 * @return The selected model elements that will be highlighted.
	 */
	public List<EObject> getElements(ISelection selection) {
		List<EObject> elements = new ArrayList<>();

		if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
			Object selectedElement = ((IStructuredSelection) selection).getFirstElement();

			if (selectedElement instanceof EObject) {
				if (!elements.contains((EObject) selectedElement)) {
					elements.add((EObject) selectedElement);
				}
			}
		}

		// Check registered adapter:
		for (ISelectionHighlightingAdapter adapter : adapters) {
			Iterator<? extends EObject> modelIterator = adapter.getElements(selection);

			if (modelIterator != null) {
				modelIterator.forEachRemaining(element -> {
					if (!elements.contains(element)) {
						elements.add(element);
					}
				});
			}
		}

		return elements;
	}
}
