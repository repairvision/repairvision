package org.sidiff.repair.ui.peo.debugger.model;

import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.tree.ITreeItem;
import org.sidiff.editrule.partialmatcher.RecognitionEngineMonitor.IChangeTag;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePattern;
import org.sidiff.repair.ui.peo.Activator;

public class ChangesItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private DebuggingSnapshotItem snapshot;
	
	private IChangeTag tag;
	
	private ChangeItem[] changes;

	public ChangesItem(DebuggingSnapshotItem snapshot, IChangeTag tag, List<ChangePattern> changes) {
		this.snapshot = snapshot;
		this.tag = tag;
		this.changes = new ChangeItem[changes.size()];
		
		for (int i = 0; i < changes.size(); i++) {
			this.changes[i] = new ChangeItem(this, changes.get(i));
		}
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Changes [" + tag.toString() + "]";
	}

	@Override
	public ITreeItem getParent() {
		return snapshot;
	}
	
	@Override
	public boolean hasChildren() {
		return changes.length > 0;
	}

	@Override
	public ITreeItem[] getChildren() {
		return changes;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (ChangeItem changeItem : changes) {
			string.append(changeItem.toString());
		}
		
		return string.toString();
	}
}
