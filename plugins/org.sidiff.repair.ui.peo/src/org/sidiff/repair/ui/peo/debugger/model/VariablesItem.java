package org.sidiff.repair.ui.peo.debugger.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.repair.ui.peo.Activator;

public class VariablesItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private DebuggingSnapshotItem snapshot;
	
	private IRecognitionEngineVariableTag tag;
	
	private List<VariableItem> variables = new ArrayList<>();

	public VariablesItem(DebuggingSnapshotItem snapshot, IRecognitionEngineVariableTag tag, List<NodePattern> variables) {
		this.snapshot = snapshot;
		this.tag = tag;
		
		for (NodePattern variable : variables) {
			this.variables.add(new VariableItem(this, variable));
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
		return variables.toArray(new ITreeItem[0]);
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
