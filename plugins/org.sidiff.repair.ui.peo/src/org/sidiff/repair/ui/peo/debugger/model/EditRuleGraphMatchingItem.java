package org.sidiff.repair.ui.peo.debugger.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.widgets.ITreeItem;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.repair.ui.peo.Activator;

public class EditRuleGraphMatchingItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private DebuggingSnapshotItem snapshotItem;
	
	private List<PathItem> paths = new ArrayList<>();
	
	public EditRuleGraphMatchingItem(DebuggingSnapshotItem snapshotItem, List<List<EdgePattern>> paths) {
		this.snapshotItem = snapshotItem;
		
		for (List<EdgePattern> path : paths) {
			this.paths.add(new PathItem(this, path));
		}
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Matching [" + paths.size() + "]";
	}

	@Override
	public ITreeItem getParent() {
		return snapshotItem;
	}

	@Override
	public ITreeItem[] getChildren() {
		return paths.toArray(new ITreeItem[0]);
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
