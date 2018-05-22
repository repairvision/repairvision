package org.sidiff.repair.ui.provider.model;

import org.eclipse.emf.henshin.model.GraphElement;
import org.sidiff.repair.ui.provider.IHighlightableElement;

public abstract class ActionItem implements IItemProvider, IHighlightableElement {

	protected Object parent;
	
	protected GraphElement changeAction;
	
	public ActionItem(Object parent, GraphElement changeAction) {
		this.changeAction = changeAction;
		this.parent = parent;
	}

	@Override
	public String getText() {
		return changeAction.toString();
	}
	
	@Override
	public Object getParent() {
		return parent;
	}

	public ChangeSetItem getChangeSetItem() {
		Object parent = getParent(); 
		
		while ((parent != null) && (parent instanceof IItemProvider)) {
			if (parent instanceof ChangeSetItem) {
				return (ChangeSetItem) parent;
			} else {
				parent = ((IItemProvider) parent).getParent();
			}
		}
		
		return null;
	}
}
