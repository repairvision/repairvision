package org.sidiff.difference.symmetric.graphviewer.content.symmetric;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingNode;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.Change;

import javafx.scene.paint.Color;

public class AddObjectNode extends MatchingNode implements IChangeNode {

	protected AddObject addObject;
	
	public AddObjectNode(AddObject addObject) {
		super();
		this.addObject = addObject;
	}

	public AddObject getAddObject() {
		return addObject;
	}
	
	public void setAddObject(AddObject addObject) {
		this.addObject = addObject;
	}
	
	@Override
	public EClass getType() {
		if (addObject.getObj() != null) {
			return addObject.getObj().eClass();
		} else {
			return null;
		}
	}

	@Override
	public List<EObject> getElements() {
		return Collections.singletonList(addObject.getObj());
	}
	
	@Override
	public int getElementCount() {
		return ((addObject != null) && (addObject.getObj() != null)) ? 1 : 0;
	}
	
	@Override
	public EObject getRepresentativeElement() {
		return addObject.getObj();
	}
	
	@Override
	public Change getChange() {
		return addObject;
	}
	
	@Override
	public Color getBorderColor() {
		return Color.web("0x00c800", 1.0);
	}
	
	@Override
	public Color getBackgroundColor() {
		return Color.web("0xddffdd", 1.0);
	}
}
