package org.sidiff.repair.ui.peo.debugger.model;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.tree.ITreeItem;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.repair.ui.peo.Activator;

public class ChangeItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private ChangesItem changeSet;
	
	private EditRuleGraphElementItem graphElement;

	public ChangeItem(ChangesItem changeSet, NodePattern node) {
		this.changeSet = changeSet;
		this.graphElement = new EditRuleNodeItem(this, node);
	}
	
	public ChangeItem(ChangesItem changeSet, EdgePattern edge) {
		this.changeSet = changeSet;
		this.graphElement = new EditRuleEdgeItem(this, edge);
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Change: " + graphElement.getText();
	}

	@Override
	public ITreeItem getParent() {
		return changeSet;
	}
	
	@Override
	public boolean hasChildren() {
		return true;
	}

	@Override
	public ITreeItem[] getChildren() {
		return new ITreeItem[] {graphElement};
	}
	
	@Override
	public String toString() {
		return graphElement.toString() + "\n";
	}
}
