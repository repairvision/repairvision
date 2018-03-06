package org.sidiff.repair.ui.peo.debugger.model;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.tree.ITreeItem;
import org.sidiff.editrule.recognition.pattern.graph.ChangePattern;
import org.sidiff.repair.ui.peo.Activator;

public class ChangeItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private ChangesItem changeSet;
	
	private DomainItem domain;

	public ChangeItem(ChangesItem changeSet, ChangePattern change) {
		this.changeSet = changeSet;
		this.domain = new DomainItem(this, change.getChangeNodePattern());
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Change: " + domain.getText();
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
		return new ITreeItem[] {domain};
	}
	
	@Override
	public String toString() {
		return domain.toString() + "\n";
	}
}
