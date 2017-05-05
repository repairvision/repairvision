package org.sidiff.editrule.partialmatcher.selection;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.NodePattern;

public interface IMatchSelector {

	void initialSelection(NodePattern selectedNode, EObject selectedMatch);
	
	void selection(NodePattern selectedNode, EObject selectedMatch);
	
	void undoSelection(NodePattern unselectedNode);

}