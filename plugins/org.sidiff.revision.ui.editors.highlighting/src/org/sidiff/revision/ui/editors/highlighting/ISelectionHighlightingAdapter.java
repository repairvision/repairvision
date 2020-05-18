package org.sidiff.revision.ui.editors.highlighting;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * A highlighting adapters that convert a selection to highlightable model elements.
 * 
 * @author Manuel Ohrndorf
 */
public interface ISelectionHighlightingAdapter {
	
	/**
	 * Empty iteration.
	 */
	public static Iterator<? extends EObject> EMPTY_ITERATOR = new Iterator<EObject>() {

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public EObject next() {
			throw new NoSuchElementException();
		}
	};
	
	/**
	 * @param selection
	 *            The actual selection to highlight.
	 * @return A model element iterator or <code>null</code>.
	 */
	Iterator<? extends EObject> getElements(ISelection selection);
	
	/**
	 * Convenience function to convert a selection.
	 * 
	 * @param selection A (structured) selection.
	 * @return The first selected element.
	 */
	public static Object getFirstElement(ISelection selection) {

		if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
			return ((IStructuredSelection) selection).getFirstElement();
		}
		
		return null;
	}
	
	/**
	 * Convenience function to convert a selection.
	 * 
	 * @param selection A (structured) selection.
	 * @return The selected elements.
	 */
	@SuppressWarnings("unchecked")
	public static List<? extends Object> getAllElement(ISelection selection) {

		if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
			return ((IStructuredSelection) selection).toList();
		}
		
		return null;
	}
}
