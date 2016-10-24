package org.sidiff.consistency.repair.ui.config;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.sidiff.consistency.repair.ui.presentation.extension.RepairPresentationEntry;
import org.sidiff.consistency.repair.ui.presentation.extension.RepairPresentationLibrary;

public class RepairDectectionEngineProvider implements ISelectionProvider {
	
	public static String DEFAULT = "org.sidiff.consistency.repair.ui.cpo.presentation.fragmented.ruleselection";
	
	private static List<ISelectionChangedListener> listeners = new LinkedList<>();
	
	private static RepairPresentationEntry repairSetup = RepairPresentationLibrary.getEntry(DEFAULT);

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.add(listener);
	}

	@Override
	public ISelection getSelection() {
		return new StructuredSelection(repairSetup);
	}
	
	public RepairPresentationEntry getSelectedEngine() {
		return repairSetup;
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.remove(listener);
	}

	@Override
	public void setSelection(ISelection selection) {
		if (selection instanceof StructuredSelection) {
			Object selectedObject = ((StructuredSelection) selection).getFirstElement();
			
			if (selectedObject instanceof RepairPresentationEntry) {
				repairSetup = (RepairPresentationEntry) selectedObject;
				SelectionChangedEvent event = new SelectionChangedEvent(this, getSelection());
				listeners.forEach(listener -> listener.selectionChanged(event));
			}
		}
	}
}
