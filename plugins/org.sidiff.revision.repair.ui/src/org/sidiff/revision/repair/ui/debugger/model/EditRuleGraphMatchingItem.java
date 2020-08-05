package org.sidiff.revision.repair.ui.debugger.model;

import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionNode;
import org.sidiff.revision.repair.ui.Activator;
import org.sidiff.revision.repair.ui.debugger.ITreeItem;

public class EditRuleGraphMatchingItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private DebuggingSnapshotItem snapshotItem;
	
	private PathItem[] paths;
	
	public EditRuleGraphMatchingItem(DebuggingSnapshotItem snapshotItem, List<List<ActionNode>> paths) {
		this.snapshotItem = snapshotItem;
		this.paths = new PathItem[paths.size()];
		
		for (int i = 0; i < paths.size(); i++) {
			this.paths[i] =  new PathItem(this, paths.get(i));
		}
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Matching [" + paths.length + "]";
	}

	@Override
	public ITreeItem getParent() {
		return snapshotItem;
	}
	
	@Override
	public boolean hasChildren() {
		return paths.length > 0;
	}

	@Override
	public ITreeItem[] getChildren() {
		return paths;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (PathItem path : paths) {
			string.append(path.toString() + "\n");
		}
		
		return string.toString();
	}
}
