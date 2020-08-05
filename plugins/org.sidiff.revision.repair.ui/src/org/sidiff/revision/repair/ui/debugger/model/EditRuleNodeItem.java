package org.sidiff.revision.repair.ui.debugger.model;

import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionNode;
import org.sidiff.revision.repair.ui.Activator;
import org.sidiff.revision.repair.ui.debugger.ITreeItem;

public class EditRuleNodeItem extends EditRuleGraphElementItem implements ITreeItem  {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private ITreeItem parent;
	
	private ActionNode node;
	
	private DomainItem domainA;
	
	private DomainItem domainB;
	
	private DomainItem domainDifference;
	
	public EditRuleNodeItem(ITreeItem parent, ActionNode node) {
		this.parent = parent;
		this.node = node;
		
		this.domainA = new DomainItem(this, node.getNodePatternA());
		this.domainB = new DomainItem(this, node.getNodePatternB());
		this.domainDifference = new DomainItem(this, node.getCorrespondence());
	}
	
	public ActionNode getNode() {
		return node;
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
		return domainA.hasChildren() || domainB.hasChildren() || domainDifference.hasChildren();
	}

	@Override
	public ITreeItem[] getChildren() {
		return new ITreeItem[] {domainA, domainB, domainDifference};
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		string.append(domainA.toString() + "\n");
		string.append(domainB.toString() + "\n");
		string.append(domainDifference.toString() + "\n");
		
		return string.toString();
	}
}
