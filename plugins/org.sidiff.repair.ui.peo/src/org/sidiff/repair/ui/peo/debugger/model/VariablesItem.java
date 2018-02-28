package org.sidiff.repair.ui.peo.debugger.model;

import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.tree.ITreeItem;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.repair.ui.peo.Activator;

public class VariablesItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private DebuggingSnapshotItem snapshot;
	
	private IRecognitionEngineVariableTag tag;
	
	private VariableItem[] variables;

	public VariablesItem(DebuggingSnapshotItem snapshot, IRecognitionEngineVariableTag tag, List<NodePattern> variables) {
		this.snapshot = snapshot;
		this.tag = tag;
		this.variables = new VariableItem[variables.size()];
		
		for (int i = 0; i < variables.size(); i++) {
			this.variables[i] = new VariableItem(this, variables.get(i));
		}
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Variables [" + tag.toString() + "]";
	}

	@Override
	public ITreeItem getParent() {
		return snapshot;
	}

	@Override
	public ITreeItem[] getChildren() {
		return variables;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		for (VariableItem variableItem : variables) {
			string.append(variableItem.toString());
		}
		
		return string.toString();
	}
}
