package org.sidiff.revision.repair.ui.debugger.model;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionEdge;
import org.sidiff.revision.repair.ui.Activator;
import org.sidiff.revision.repair.ui.debugger.ITreeItem;

public class EditRuleEdgeItem extends EditRuleGraphElementItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private ITreeItem parent;
	
	private ActionEdge edge;
	
	private DomainItem domainDifference;
	
	public EditRuleEdgeItem(ITreeItem parent, ActionEdge edge) {
		this.parent = parent;
		this.edge = edge;
		
		if (edge.getChange() != null) {
			this.domainDifference = new DomainItem(this, edge.getChange().getChangeNodePattern());
		}
	}
	
	public ActionEdge getEdge() {
		return edge;
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		Edge edge = this.edge.getEditRuleEdge();
		
		return "[" + edge.getSource().getName() + "]" 
				+ " - " + edge.getType().getName() + " -> "
				+ "[" + edge.getTarget().getName() + "]";
	}

	@Override
	public ITreeItem getParent() {
		return parent;
	}
	
	@Override
	public boolean hasChildren() {
		return (domainDifference != null) && domainDifference.hasChildren();
	}

	@Override
	public ITreeItem[] getChildren() {
		if (hasChildren()) {
			return new ITreeItem[] {domainDifference};
		} else {
			return new ITreeItem[0];
		}
	}
	
	@Override
	public String toString() {
		return domainDifference.toString() + "\n";
	}
}
