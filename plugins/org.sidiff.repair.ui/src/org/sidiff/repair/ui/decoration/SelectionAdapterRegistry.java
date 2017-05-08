package org.sidiff.repair.ui.decoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.sidiff.repair.api.IRepair;
import org.sidiff.repair.ui.provider.RepairContentProvider.Change;

public class SelectionAdapterRegistry {
	
	private static List<ISelectionAdapter> adapters = new LinkedList<>();
	
	public static void registerAdapter(ISelectionAdapter adapter) {
		adapters.add(adapter);
	}
	
	public static void deregisterAdapter(ISelectionAdapter adapter) {
		adapters.remove(adapter);
	}

	public static List<EObject> getElements(ISelection selection) {
		List<EObject> elements = new ArrayList<>();
		
		if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
			Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
			
			if (selectedElement instanceof EObject) {
				if (!elements.contains((EObject) selectedElement)) {
					elements.add((EObject) selectedElement);
				}
			}
			
			// TODO: Move to RepairSelectionAdapter!
			else if (selectedElement instanceof IRepair) {
				return Collections.unmodifiableList(((IRepair) selectedElement)
						.getRepairPreMatch().getMatch().getNodeTargets());
			}
			
			else if (selectedElement instanceof Change) {
				// FIXME: Needs a XMI-ID copy for the complement-rule!
				return Collections.singletonList(((Change) selectedElement).graphElement);
			}
		}
		
		// Check registered adapter:
		for (ISelectionAdapter adapter : adapters) {
			Iterator<EObject> modelIterator = adapter.getElements(selection);
			
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
