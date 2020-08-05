package org.sidiff.revision.ui.viewer.provider.model;

import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.ui.viewer.Activator;

public class ActionNodeItem extends ActionItem {

	protected static Image IMG_ADD_OBJECT = Activator.getImageDescriptor("icons/add_object.png").createImage();
	
	protected static Image IMG_REMOVE_OBJECT = Activator.getImageDescriptor("icons/remove_object.png").createImage();
	
	protected static Image IMG_PRESERVE_OBJECT = Activator.getImageDescriptor("icons/preserve_object.gif").createImage();
	
	public ActionNodeItem(Object parent, Node changeNode) {
		super(parent, HenshinRuleAnalysisUtil.tryLHS(changeNode));
	}
	
	@Override
	public Image getImage() {
		if (HenshinRuleAnalysisUtil.isPreservedNode((Node) changeAction)) {
			return IMG_PRESERVE_OBJECT;
		} else {
			if (changeAction.getGraph().isLhs()) {
				return IMG_REMOVE_OBJECT;
			} else {
				return IMG_ADD_OBJECT;
			}
		}
	}
	
	@Override
	public boolean hasChildren(Object element) {
		return true;
	}
	
	@Override
	public Object[] getChildren() {
		Node changeNode = (Node) changeAction;
		return getChangeSetItem().getDomain(changeNode);
	}

	@Override
	public Iterator<? extends EObject> getModelElements() {
		Node changeNode = (Node) changeAction;
		return Arrays.asList(getChangeSetItem().getDomain(changeNode)).iterator();
	}
}
