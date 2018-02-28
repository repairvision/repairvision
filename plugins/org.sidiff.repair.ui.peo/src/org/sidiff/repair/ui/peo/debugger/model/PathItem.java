package org.sidiff.repair.ui.peo.debugger.model;

import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.widgets.ITreeItem;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.repair.ui.peo.Activator;

public class PathItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private EditRuleGraphMatchingItem matching;
	
	private EditRuleEdgeItem[] path;
	
	public PathItem(EditRuleGraphMatchingItem matching, List<EdgePattern> path) {
		this.matching = matching;
		this.path = new EditRuleEdgeItem[path.size()];
		
		for (int i = 0; i < path.size(); i++) {
			this.path[i] = new EditRuleEdgeItem(this, path.get(i));
		}
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Path";
	}

	@Override
	public ITreeItem getParent() {
		return matching;
	}

	@Override
	public ITreeItem[] getChildren() {
		return path;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (EditRuleEdgeItem edge : path) {
			string.append(edge.toString() + "\n");
		}
		
		return string.toString();
	}
}
