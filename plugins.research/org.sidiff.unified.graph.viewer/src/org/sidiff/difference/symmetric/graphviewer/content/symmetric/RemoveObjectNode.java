package org.sidiff.difference.symmetric.graphviewer.content.symmetric;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingNode;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.RemoveObject;

import javafx.scene.paint.Color;

public class RemoveObjectNode extends MatchingNode implements IChangeNode {

	protected RemoveObject removeObject;
	
	public RemoveObjectNode(RemoveObject removeObject) {
		super();
		this.removeObject = removeObject;
	}
	
	public RemoveObject getRemoveObject() {
		return removeObject;
	}
	
	public void setRemoveObject(RemoveObject removeObject) {
		this.removeObject = removeObject;
	}

	@Override
	public EClass getType() {
		if (removeObject.getObj() != null) {
			return removeObject.getObj().eClass();
		} else {
			return null;
		}
	}

	@Override
	public List<EObject> getElements() {
		return Collections.singletonList(removeObject.getObj());
	}
	
	@Override
	public int getElementCount() {
		return ((removeObject != null) && (removeObject.getObj() != null)) ? 1 : 0;
	}
	
	@Override
	public EObject getRepresentativeElement() {
		return removeObject.getObj();
	}
	
	@Override
	public Change getChange() {
		return removeObject;
	}
	
	@Override
	public Color getBorderColor() {
		return Color.web("0xff0000", 1.0);
	}
	
	@Override
	public Color getBackgroundColor() {
		return Color.web("0xffdddd", 1.0);
	}
}
