package org.sidiff.difference.symmetric.graphviewer.content.symmetric;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingEdge;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingNode;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.RemoveReference;

import javafx.scene.paint.Color;

public class RemoveReferenceEdge extends MatchingEdge implements IChangeNode {
	
	protected RemoveReference removeReference;

	public RemoveReferenceEdge(RemoveReference removeReference, MatchingNode source, MatchingNode target) {
		super(source, target);
		this.removeReference = removeReference;
	}
	
	public RemoveReference getRemoveReference() {
		return removeReference;
	}
	
	public void setRemoveReference(RemoveReference removeReference) {
		this.removeReference = removeReference;
	}
	
	@Override
	public List<EReference> getTypes() {
		return Collections.singletonList(removeReference.getType());
	}

	@Override
	public List<EObject> getReferences(EReference type) {
		return Collections.singletonList(removeReference.getSrc());
	}
	
	@Override
	public Change getChange() {
		return removeReference;
	}
	
	@Override
	public Color getBorderColor() {
		return Color.web("0xff0000", 0.3);
	}
	
	@Override
	public Color getDecorationColor() {
		return Color.web("0xff0000", 0.6);
	}
	
	@Override
	public Color getTextColor() {
		return Color.web("0xff0000", 0.6);
	}
}
