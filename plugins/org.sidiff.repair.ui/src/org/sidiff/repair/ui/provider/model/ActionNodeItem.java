package org.sidiff.repair.ui.provider.model;

import org.eclipse.emf.henshin.model.Node;
import org.eclipse.swt.graphics.Image;
import org.sidiff.repair.ui.Activator;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;

public class ActionNodeItem extends ActionItem  {

	protected static Image IMG_ADD_OBJECT = Activator.getImageDescriptor("icons/add_object.png").createImage();
	
	protected static Image IMG_REMOVE_OBJECT = Activator.getImageDescriptor("icons/remove_object.png").createImage();
	
	protected static Image IMG_PRESERVE_OBJECT = Activator.getImageDescriptor("icons/preserve_object.gif").createImage();
	
	public ActionNodeItem(Object parent, Node changeNode) {
		super(parent, ChangePatternUtil.tryLHS(changeNode));
	}
	
	@Override
	public Image getIcon() {
		if (HenshinRuleAnalysisUtilEx.isPreservedNode((Node) changeAction)) {
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
}
