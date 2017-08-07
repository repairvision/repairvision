package org.sidiff.repair.ui.provider.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;

public class Change {
	public GraphElement graphElement;
	public Node[] nodes;
	public EObject[] matches;
}
