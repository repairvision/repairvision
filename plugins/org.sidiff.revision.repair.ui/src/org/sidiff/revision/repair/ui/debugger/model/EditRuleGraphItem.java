package org.sidiff.revision.repair.ui.debugger.model;

import java.util.Collection;

import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionEdge;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionNode;
import org.sidiff.revision.repair.ui.Activator;
import org.sidiff.revision.repair.ui.debugger.ITreeItem;

public class EditRuleGraphItem implements ITreeItem {
	
	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();

	private DebuggingSnapshotItem snapshot;
	
	private String editRuleName;
	
	private ITreeItem[] graphElements;
	
	public EditRuleGraphItem(DebuggingSnapshotItem snapshot, String editRuleName, Collection<ActionNode> nodes, Collection<ActionEdge> edges) {
		this.snapshot = snapshot;
		this.editRuleName = editRuleName;
		this.graphElements = new ITreeItem[nodes.size() + edges.size()];
		
		int graphElementIndex = 0;
		
		for (ActionNode node : nodes) {
			graphElements[graphElementIndex++] = new EditRuleNodeItem(this, node);
		}
		
		for (ActionEdge edge : edges) {
			graphElements[graphElementIndex++] = new EditRuleEdgeItem(this, edge);
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
		return graphElements.length > 0;
	}
	
	@Override
	public ITreeItem[] getChildren() {
		return graphElements;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (ITreeItem graphElement : graphElements) {
			string.append(graphElement.getText() + "\n");
		}
		
		return string.toString();
	}
}
