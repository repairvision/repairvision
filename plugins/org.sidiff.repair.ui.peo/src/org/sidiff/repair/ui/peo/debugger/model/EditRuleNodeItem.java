package org.sidiff.repair.ui.peo.debugger.model;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.tree.ITreeItem;
import org.sidiff.editrule.recognition.pattern.graph.ActionNode;
import org.sidiff.repair.ui.peo.Activator;

public class EditRuleNodeItem extends EditRuleGraphElementItem implements ITreeItem  {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private ITreeItem parent;
	
	private ActionNode node;
	
	private DomainItem domainA;
	
	private DomainItem domainB;
	
	private DomainItem difference;
	
	public EditRuleNodeItem(ITreeItem parent, ActionNode node) {
		this.parent = parent;
		this.node = node;
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return node.getEditRuleNode().getName() + " : " + node.getEditRuleNode().getType().getName();
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
		return new ITreeItem[] {domainA, domainB, difference};
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		string.append(domainA.toString() + "\n");
		string.append(domainB.toString() + "\n");
		string.append(difference.toString() + "\n");
		
		return string.toString();
	}
}
