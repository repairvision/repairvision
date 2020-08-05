package org.sidiff.revision.ui.viewer.provider.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.ui.viewer.Activator;

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

	@Override
	public Iterator<? extends EObject> getModelElements() {
		Edge changeEdge = (Edge) changeAction;
		List<EObject> elements = new ArrayList<>();
		
		Arrays.asList(getChangeSetItem().getDomain(changeEdge.getSource())).forEach(elements::add);
		Arrays.asList(getChangeSetItem().getDomain(changeEdge.getTarget())).forEach(elements::add);
		
		return elements.iterator();
	}
}
