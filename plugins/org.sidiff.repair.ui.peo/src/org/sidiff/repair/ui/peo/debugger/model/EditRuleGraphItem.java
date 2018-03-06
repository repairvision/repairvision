package org.sidiff.repair.ui.peo.debugger.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.tree.ITreeItem;
import org.sidiff.editrule.recognition.pattern.graph.ActionEdge;
import org.sidiff.editrule.recognition.pattern.graph.ActionNode;
import org.sidiff.repair.ui.peo.Activator;

public class EditRuleGraphItem implements ITreeItem {
	
	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();

	private DebuggingSnapshotItem snapshot;
	
	private String editRuleName;
	
	private List<EditRuleNodeItem> nodes = new ArrayList<>();
	
	private List<EditRuleEdgeItem> edges = new ArrayList<>();
	
	public EditRuleGraphItem(DebuggingSnapshotItem snapshot, String editRuleName, Collection<ActionNode> nodes, Collection<ActionEdge> edges) {
		this.snapshot = snapshot;
		this.editRuleName = editRuleName;
		
		for (ActionNode node : nodes) {
			this.nodes.add(new EditRuleNodeItem(this, node));
		}
		
		for (ActionEdge edge : edges) {
			this.edges.add(new EditRuleEdgeItem(this, edge));
		}
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Edit Rule [" + editRuleName + "]";
	}

	@Override
	public ITreeItem getParent() {
		return snapshot;
	}

	@Override
	public boolean hasChildren() {
		return nodes.size() + edges.size() > 0;
	}
	
	@Override
	public ITreeItem[] getChildren() {
		ITreeItem[] children = new ITreeItem[nodes.size() + edges.size()];
		
		for (int i = 0; i < nodes.size(); i++) {
			children[i] = nodes.get(0);
		}
		
		for (int i = nodes.size(); i < edges.size() + edges.size(); i++) {
			children[i] = edges.get(i);
		}
		
		return children;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (EditRuleNodeItem node : nodes) {
			string.append(node.toString() + "\n");
		}
		
		for (EditRuleEdgeItem edge : edges) {
			string.append(edge.toString() + "\n");
		}
		
		return string.toString();
	}
}
