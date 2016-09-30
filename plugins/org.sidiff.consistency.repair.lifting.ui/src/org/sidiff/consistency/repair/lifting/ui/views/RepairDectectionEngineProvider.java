package org.sidiff.consistency.repair.lifting.ui.views;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

//TODO[Repair Engines]: Add extension point:
public class RepairDectectionEngineProvider implements ISelectionProvider {

	private static RepairDectection repairDectectionEngine = RepairDectection.ConsistencyPreservingEditOperationBasedEngine;
	
	private static List<ISelectionChangedListener> listeners = new LinkedList<>();
	
	public enum RepairDectection {
		ConsistencyPreservingEditOperationBasedEngine,
		PartialEditOperationBasedEngine
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.add(listener);
	}

	@Override
	public ISelection getSelection() {
		return new StructuredSelection(repairDectectionEngine);
	}
	
	public RepairDectection getSelectedEngine() {
		return repairDectectionEngine;
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.remove(listener);
	}

	@Override
	public void setSelection(ISelection selection) {
		if (selection instanceof StructuredSelection) {
			Object selectedObject = ((StructuredSelection) selection).getFirstElement();
			
			if (selectedObject instanceof RepairDectection) {
				repairDectectionEngine = (RepairDectection) selectedObject;
				SelectionChangedEvent event = new SelectionChangedEvent(this, getSelection());
				listeners.forEach(listener -> listener.selectionChanged(event));
			}
		}
	}
}
