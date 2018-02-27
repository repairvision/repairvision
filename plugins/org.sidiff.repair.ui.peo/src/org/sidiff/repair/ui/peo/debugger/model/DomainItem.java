package org.sidiff.repair.ui.peo.debugger.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.sidiff.repair.ui.peo.Activator;

public class DomainItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private ITreeItem parent;
	
	private List<ModelElementItem> values = new ArrayList<>();
	
	public DomainItem(ITreeItem parent) {
		this.parent = parent;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getText() {
		return "Domain";
	}

	@Override
	public ITreeItem getParent() {
		return parent;
	}

	@Override
	public ITreeItem[] getChildren() {
		return values.toArray(new ITreeItem[0]);
	}
	
	@Override
	public String toString() {
		return values.toString() + "\n";
	}
}
