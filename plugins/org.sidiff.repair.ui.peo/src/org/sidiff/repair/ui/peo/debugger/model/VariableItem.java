package org.sidiff.repair.ui.peo.debugger.model;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.widgets.ITreeItem;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.repair.ui.peo.Activator;

public class VariableItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private VariablesItem variableSet;
	
	private EditRuleGraphElementItem graphElement;

	public VariableItem(VariablesItem variableSet, NodePattern node) {
		this.variableSet = variableSet;
		this.graphElement = new EditRuleNodeItem(this, node);
	}
	
	public VariableItem(VariablesItem variableSet, EdgePattern edge) {
		this.variableSet = variableSet;
		this.graphElement = new EditRuleEdgeItem(this, edge);
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Variable: " + graphElement.getText();
	}

	@Override
	public ITreeItem getParent() {
		return variableSet;
	}

	@Override
	public ITreeItem[] getChildren() {
		return new ITreeItem[] {graphElement};
	}
	
	@Override
	public String toString() {
		return graphElement.toString() + "\n";
	}
}
