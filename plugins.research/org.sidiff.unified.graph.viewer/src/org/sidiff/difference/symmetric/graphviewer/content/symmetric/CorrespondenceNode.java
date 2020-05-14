package org.sidiff.difference.symmetric.graphviewer.content.symmetric;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingNode;
import org.sidiff.revision.difference.Correspondence;

import javafx.scene.paint.Color;

public class CorrespondenceNode extends MatchingNode {

	protected Correspondence correspondence;
	
	public CorrespondenceNode(Correspondence correspondence) {
		super();
		this.correspondence = correspondence;
	}
	
	public Correspondence getCorrespondence() {
		return correspondence;
	}
	
	public void setCorrespondence(Correspondence correspondence) {
		this.correspondence = correspondence;
	}

	@Override
	public EClass getType() {
		if (correspondence.getMatchedA() != null) {
			return correspondence.getMatchedB().eClass();
		} else {
			return null;
		}
	}

	@Override
	public List<EObject> getElements() {
		List<EObject> corresponding = new ArrayList<>(2);
		corresponding.add(correspondence.getMatchedA());
		corresponding.add(correspondence.getMatchedB());
		return corresponding;
	}
	
	@Override
	public int getElementCount() {
		if ((correspondence.getMatchedA() != null) && (correspondence.getMatchedB() != null)) {
			return (correspondence.getMatchedA() != correspondence.getMatchedB()) ? 2 : 1;
		}
		else if ((correspondence.getMatchedA() != null) || (correspondence.getMatchedB() != null)) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public EObject getRepresentativeElement() {
		return correspondence.getMatchedB();
	}

	@Override
	public Color getBorderColor() {
		return Color.web("0x808080", 1.0);
	}
	
	@Override
	public Color getBackgroundColor() {
		return Color.web("0xeeeeee", 1.0);
	}
}
