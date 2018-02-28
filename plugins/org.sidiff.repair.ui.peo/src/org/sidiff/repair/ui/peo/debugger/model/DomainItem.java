package org.sidiff.repair.ui.peo.debugger.model;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.sidiff.consistency.common.ui.widgets.ITreeItem;
import org.sidiff.editrule.partialmatcher.pattern.domain.Domain;
import org.sidiff.editrule.partialmatcher.pattern.domain.Domain.SelectionType;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.repair.ui.peo.Activator;

public class DomainItem implements ITreeItem {

	private static Image icon = Activator.getImageDescriptor("icons/debug_exc.gif").createImage();
	
	private ITreeItem parent;
	
	private ModelElementItem[] values;
	
	public DomainItem(ITreeItem parent, NodePattern node) {
		this.parent = parent;
		
		// Read domain values:
		Map<EObject, SelectionType> domain = Domain.get(node).getDomain();
		this.values = new ModelElementItem[domain.size()]; 
		int i = 0;
		
		for (Entry<EObject, SelectionType> taggedValue : Domain.get(node).getDomain().entrySet()) {
			values[i] = new ModelElementItem(this, taggedValue.getValue().toString(), taggedValue.getKey());
			++i;
		}
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
		return values;
	}
	
	@Override
	public String toString() {
		return values.toString() + "\n";
	}
}
