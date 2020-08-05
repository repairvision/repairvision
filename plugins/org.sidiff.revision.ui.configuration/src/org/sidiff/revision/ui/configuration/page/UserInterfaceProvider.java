package org.sidiff.revision.ui.configuration.page;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.sidiff.revision.ui.presentation.extension.ComplementationPresentationEntry;
import org.sidiff.revision.ui.presentation.extension.ComplementationPresentationLibrary;

public class UserInterfaceProvider implements ISelectionProvider {
	
	public static String DEFAULT = "org.sidiff.revision.repair.ui.presentation.integrated";
//	public static String DEFAULT = "org.sidiff.revision.repair.ui.presentation.ruleselection";
	
	private static List<ISelectionChangedListener> listeners = new LinkedList<>();
	
	private static ComplementationPresentationEntry complementationPresentation = setDefaultPresentation();

	private static ComplementationPresentationEntry setDefaultPresentation() {
		ComplementationPresentationEntry presentation = ComplementationPresentationLibrary.getEntry(DEFAULT);
		
		if (presentation == null) {
			presentation = ComplementationPresentationLibrary.getEntries().iterator().next();
		}
		
		return presentation;
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	@Override
	public ISelection getSelection() {
		return new StructuredSelection(complementationPresentation);
	}
	
	public ComplementationPresentationEntry getSelectedEngine() {
		return complementationPresentation;
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.remove(listener);
	}

	@Override
	public void setSelection(ISelection selection) {
		if (selection instanceof StructuredSelection) {
			Object selectedObject = ((StructuredSelection) selection).getFirstElement();
			
			if (selectedObject instanceof ComplementationPresentationEntry) {
				complementationPresentation = (ComplementationPresentationEntry) selectedObject;
				SelectionChangedEvent event = new SelectionChangedEvent(this, getSelection());
				listeners.forEach(listener -> listener.selectionChanged(event));
			}
		}
	}
}
