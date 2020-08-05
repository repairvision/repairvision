package org.sidiff.revision.repair.ui.debugger.model;

import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionNode;
import org.sidiff.revision.repair.ui.Activator;
import org.sidiff.revision.repair.ui.debugger.ITreeItem;

public class PathItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private EditRuleGraphMatchingItem matching;
	
	private EditRuleNodeItem[] path;
	
	public PathItem(EditRuleGraphMatchingItem matching, List<ActionNode> path) {
		this.matching = matching;
		this.path = new EditRuleNodeItem[path.size()];
		
		for (int i = 0; i < path.size(); i++) {
			this.path[i] = new EditRuleNodeItem(this, path.get(i));
		}
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		StringBuffer pathText = new StringBuffer("Path:");
		
		for (EditRuleNodeItem editRuleNodeItem : path) {
			
			if (editRuleNodeItem != path[0]) {
				pathText.append(",");
			}
			
			pathText.append(" " + editRuleNodeItem.getNode().getEditRuleNode().getName());
		}
		
		return pathText.toString();
	}

	@Override
	public ITreeItem getParent() {
		return matching;
	}
	
	@Override
	public boolean hasChildren() {
		return path.length > 0;
	}

	@Override
	public ITreeItem[] getChildren() {
		return path;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (EditRuleNodeItem node : path) {
			string.append(node.toString() + "\n");
		}
		
		return string.toString();
	}
}
