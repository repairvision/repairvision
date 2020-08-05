package org.sidiff.revision.repair.ui.debugger.model;

import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.editrules.recognition.pattern.graph.ChangePattern;
import org.sidiff.revision.repair.ui.Activator;
import org.sidiff.revision.repair.ui.debugger.ITreeItem;

public class ChangeItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private ChangesItem changeSet;
	
	private ChangePattern change;
	
	private DomainItem domain;

	public ChangeItem(ChangesItem changeSet, ChangePattern change) {
		this.changeSet = changeSet;
		this.change = change;
		this.domain = new DomainItem(this, change.getChangeNodePattern());
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Change: " + change.getChangeNodePattern().getName() + " : " + change.getChangeNodePattern().getType().getName();
	}

	@Override
	public ITreeItem getParent() {
		return changeSet;
	}
	
	@Override
	public boolean hasChildren() {
		return domain.hasChildren();
	}

	@Override
	public ITreeItem[] getChildren() {
		if (domain.hasChildren()) {
			return new ITreeItem[] {domain};
		} else {
			return new ITreeItem[0];
		}
	}
	
	@Override
	public String toString() {
		return domain.toString() + "\n";
	}
}
