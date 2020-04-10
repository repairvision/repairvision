package org.sidiff.revision.repair.ui.provider.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.swt.graphics.Image;
import org.sidiff.common.utilities.henshin.ChangePatternUtil;
import org.sidiff.revision.repair.ui.Activator;

public class ActionAttributeItem extends ActionItem {

	protected static Image IMG_SET_ATTRIBUTE = Activator.getImageDescriptor("icons/add_reference.png").createImage();
	
	public ActionAttributeItem(Object parent, Attribute changeAttribute) {
		super(parent, changeAttribute);
	}
	
	@Override
	public String getText() {
		return "Set Attribute (type: " + ((Attribute) changeAction).getType().getName() + ", value: " + ((Attribute) changeAction).getValue() + ")";
	}
	
	@Override
	public Image getImage() {
		return IMG_SET_ATTRIBUTE;
	}
	
	@Override
	public boolean hasChildren(Object element) {
		return true;
	}

	@Override
	public Object[] getChildren() {
		Attribute changeAttribute = (Attribute) changeAction;
		Node containingNode = changeAttribute.getNode();
		
		List<Object> values = new ArrayList<>();
		
		for (EObject match : getChangeSetItem().getDomain(ChangePatternUtil.tryLHS(containingNode))) {
			Object value = match.eGet(changeAttribute.getType());
			values.add(match);
			
			if (!values.contains(value)) {
				values.add(value);
			}
		}
		
		return values.toArray();
	}

	@Override
	public Iterator<? extends EObject> getModelElements() {
		Attribute changeAttribute = (Attribute) changeAction;
		Node containingNode = changeAttribute.getNode();
		return Arrays.asList(getChangeSetItem().getDomain(ChangePatternUtil.tryLHS(containingNode))).iterator();
	}
}
