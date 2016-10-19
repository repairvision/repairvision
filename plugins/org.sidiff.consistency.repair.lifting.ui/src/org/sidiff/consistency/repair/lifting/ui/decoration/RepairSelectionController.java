package org.sidiff.consistency.repair.lifting.ui.decoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.INullSelectionListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;

public class RepairSelectionController implements ISelectionListener, ISelectionChangedListener, INullSelectionListener {

	private static RepairSelectionController instance;
	
	private List<EObject> selected = new ArrayList<>();

	private List<IDecorator> decorators = new ArrayList<>();

	private Map<EObject, IDecoratorTarget> decoratorTargets = new HashMap<>();

	public static RepairSelectionController getInstance() {
		if (instance == null) {
			instance = new RepairSelectionController();
		}
		return instance;
	}

	public void unregisterDecorator(IDecorator decorator) {
		decorators.remove(decorator);
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
	
	private void setSelection(ISelection selection) {
		selected = SelectionAdapter.getElements(selection);		
		doHighlight();
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		setSelection(selection);
	}
	
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		setSelection(event.getSelection());
	}
	
	private void doHighlight() {
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
}
