package org.sidiff.revision.repair.ui.debugger.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.sidiff.revision.common.emf.ItemProviderUtil;
import org.sidiff.revision.repair.ui.debugger.ITreeItem;

public class ModelElementItem implements ITreeItem {

	private ITreeItem parent;
	
	private String coloring;
	
	private EObject element;

	public ModelElementItem(ITreeItem parent, String coloring, EObject element) {
		this.parent = parent;
		this.coloring = coloring;
		this.element = element;
	}

	@Override
	public Image getIcon() {
		return (Image) ItemProviderUtil.getImageByObject(element);
	}

	@Override
	public String getText() {
		return "[" + coloring + "] " + ItemProviderUtil.getTextByObject(element);
	}

	@Override
	public ITreeItem getParent() {
		return parent;
	}
	
	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public ITreeItem[] getChildren() {
		return new ITreeItem[0];
	}
}
