package org.sidiff.repair.ui.peo.debugger.model;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.widgets.ITreeItem;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.repair.ui.peo.Activator;

public class EditRuleNodeItem extends EditRuleGraphElementItem implements ITreeItem  {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private ITreeItem parent;
	
	private NodePattern node;
	
	private DomainItem domainA;
	
	private DomainItem domainB;
	
	private DomainItem difference;
	
	public EditRuleNodeItem(ITreeItem parent, NodePattern node) {
		this.parent = parent;
		this.node = node;
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return node.getName() + " : " + node.getType().getName();
	}

	@Override
	public ITreeItem getParent() {
		return parent;
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
