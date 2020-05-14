package org.sidiff.difference.symmetric.graphviewer.content.symmetric;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingEdge;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingNode;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.Change;

import javafx.scene.paint.Color;

public class AddReferenceEdge extends MatchingEdge implements IChangeNode {
	
	protected AddReference addReference;

	public AddReferenceEdge(AddReference addReference, MatchingNode source, MatchingNode target) {
		super(source, target);
		this.addReference = addReference;
	}
	
	public AddReference getAddReference() {
		return addReference;
	}
	
	public void setAddReference(AddReference addReference) {
		this.addReference = addReference;
	}
	
	@Override
	public List<EReference> getTypes() {
		return Collections.singletonList(addReference.getType());
	}

	@Override
	public List<EObject> getReferences(EReference type) {
		return Collections.singletonList(addReference.getSrc());
	}
	
	@Override
	public Change getChange() {
		return addReference;
	}
	
	@Override
	public Color getBorderColor() {
		return Color.web("0x00c800", 0.3);
	}
	
	@Override
	public Color getDecorationColor() {
		return Color.web("0x00c800", 0.6);
	}
	
	@Override
	public Color getTextColor() {
		return Color.web("0x00c800", 0.6);
	}
}
