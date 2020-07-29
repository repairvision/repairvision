package org.sidiff.revision.ui.editors.highlighting.internal.gmf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Display;

public class SelectionControllerDiagram {

	private static SelectionControllerDiagram instance;
	
	private List<EObject> selected = new ArrayList<>();

	private List<IDecorator> decorators = new ArrayList<>();

	private Map<EObject, IDecoratorTarget> decoratorTargets = new HashMap<>();

	public static SelectionControllerDiagram getInstance() {
		if (instance == null) {
			instance = new SelectionControllerDiagram();
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
	
	public IDecoratorTarget getPrefferedDecoratorTarget(EObject element) {
		return decoratorTargets.get(element);
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
					highlightDiagrams();
					focusDiagram(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void highlightDiagrams() {
		for(IDecorator decorator : decorators) {
			decorator.refresh();
		}
	}
	
	private void focusDiagram(boolean reveal) {
		
		// Reveal all:
		if (reveal) {
			for(IDecorator decorator : decorators) {
				if (decorator instanceof SelectionDecorator) {
					SelectionDecorator selectionDecorator = (SelectionDecorator) decorator;
					selectionDecorator.reveal();
				}
			}
		}
		
		// Focus first selection:
		for(IDecorator decorator : decorators) {
			if (decorator instanceof SelectionDecorator) {
				SelectionDecorator selectionDecorator = (SelectionDecorator) decorator;
				selectionDecorator.focus();
				break;
			}
		}
	}
}
