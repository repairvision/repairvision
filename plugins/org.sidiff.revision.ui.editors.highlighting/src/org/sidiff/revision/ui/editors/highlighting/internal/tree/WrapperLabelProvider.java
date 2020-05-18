package org.sidiff.revision.ui.editors.highlighting.internal.tree;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

public class WrapperLabelProvider implements ILabelProvider, IColorProvider {

	private ILabelProvider labelProvider;
	
	private List<EObject> treeDecorations;
	
	public WrapperLabelProvider(ILabelProvider labelProvider, List<EObject> treeDecorations) {
		super();
		this.labelProvider = labelProvider;
		this.treeDecorations = treeDecorations;
	}
	
	public ILabelProvider getLabelProvider() {
		return labelProvider;
	}

	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	public List<EObject> getTreeDecorations() {
		return treeDecorations;
	}

	public void setTreeDecorations(List<EObject> treeDecorations) {
		this.treeDecorations = treeDecorations;
	}

	@Override
	public Color getForeground(Object element) {
		if (treeDecorations.contains(element)) {
			return new Color(null, 232, 72, 72);
		}
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		return null;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		labelProvider.addListener(listener);
	}

	@Override
	public void dispose() {
		labelProvider.dispose();
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return labelProvider.isLabelProperty(element, property);
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		labelProvider.removeListener(listener);
	}

	@Override
	public Image getImage(Object element) {
		return labelProvider.getImage(element);
	}

	@Override
	public String getText(Object element) {
		return labelProvider.getText(element);
	}
}
