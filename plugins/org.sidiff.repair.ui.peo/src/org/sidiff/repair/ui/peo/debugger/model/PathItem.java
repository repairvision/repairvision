package org.sidiff.repair.ui.peo.debugger.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.repair.ui.peo.Activator;

public class PathItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private EditRuleGraphMatchingItem matching;
	
	private List<EditRuleEdgeItem> path = new ArrayList<>();
	
	public PathItem(EditRuleGraphMatchingItem matching, List<EdgePattern> path) {
		this.matching = matching;
		
		for (EdgePattern edge : path) {
			this.path.add(new EditRuleEdgeItem(this, edge));
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
		return path.toArray(new ITreeItem[0]);
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
