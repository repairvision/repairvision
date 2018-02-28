package org.sidiff.repair.ui.peo.debugger.model;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.tree.ITreeItem;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionEdge;
import org.sidiff.repair.ui.peo.Activator;

public class EditRuleEdgeItem extends EditRuleGraphElementItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private ITreeItem parent;
	
	private ActionEdge edge;
	
	private DomainItem difference;
	
	public EditRuleEdgeItem(ITreeItem parent, ActionEdge edge) {
		this.parent = parent;
		this.edge = edge;
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return edge.getEditRuleEdge().getType().getName();
	}

	@Override
	public ITreeItem getParent() {
		return parent;
	}
	
	@Override
	public boolean hasChildren() {
		return true;
	}

	@Override
	public ITreeItem[] getChildren() {
		return new ITreeItem[] {difference};
	}
	
	@Override
	public String toString() {
		return difference.toString() + "\n";
	}
}
