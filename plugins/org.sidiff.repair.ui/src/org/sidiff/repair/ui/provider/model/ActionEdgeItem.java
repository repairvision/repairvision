package org.sidiff.repair.ui.provider.model;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.swt.graphics.Image;
import org.sidiff.repair.ui.Activator;

public class ActionEdgeItem extends ActionItem {

	protected static Image IMG_ADD_REFERENCE = Activator.getImageDescriptor("icons/add_reference.png").createImage();
	
	protected static Image IMG_REMOVE_REFERENCE = Activator.getImageDescriptor("icons/remove_reference.png").createImage();
	
	public ActionEdgeItem(Object parent, Edge changeEdge) {
		super(parent, changeEdge);
	}
	
	@Override
	public Image getImage() {
		if (changeAction.getGraph().isLhs()) {
			return IMG_REMOVE_REFERENCE;
		} else {
			return IMG_ADD_REFERENCE;
		}
	}
	
	@Override
	public boolean hasChildren(Object element) {
		return true;
	}

	@Override
	public Object[] getChildren() {
		Edge changeEdge = (Edge) changeAction;
		
		ActionNodeItem srcMatch = new ActionNodeItem(this, changeEdge.getSource());
		ActionNodeItem tgtMatch = new ActionNodeItem(this, changeEdge.getTarget());
		
		return new Object[] {srcMatch, tgtMatch};
	}
}
