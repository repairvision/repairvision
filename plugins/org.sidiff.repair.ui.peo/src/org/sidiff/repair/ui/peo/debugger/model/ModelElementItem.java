package org.sidiff.repair.ui.peo.debugger.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.sidiff.graphpattern.edit.util.ItemProviderUtil;

public class ModelElementItem implements ITreeItem {

	private ITreeItem parent;
	
	private String coloring;
	
	private EObject element;

	@Override
	public Image getIcon() {
		return (Image) ItemProviderUtil.getImageByObject(element);
	}

	@Override
	public String getText() {
		return "[" + coloring + "]" + ItemProviderUtil.getTextByObject(element);
	}

	@Override
	public ITreeItem getParent() {
		return parent;
	}

	@Override
	public ITreeItem[] getChildren() {
		return new ITreeItem[0];
	}
}
