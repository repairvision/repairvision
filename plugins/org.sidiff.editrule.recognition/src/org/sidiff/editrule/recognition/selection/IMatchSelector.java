package org.sidiff.editrule.recognition.selection;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.NodePattern;

public interface IMatchSelector {

	/**
	 * The first selection for the search pattern.
	 * 
	 * @param selectedNode
	 *            The node that should be selected.
	 * @param selectedMatch
	 *            The match for the selected node.
	 */
	void initialSelection(NodePattern selectedNode, EObject selectedMatch);

	/**
	 * All subsequent
	 * ({@link IMatchSelector#initialSelection(NodePattern, EObject)}) selections
	 * for the search pattern.
	 * 
	 * @param selectedNode
	 *            The node that should be selected.
	 * @param selectedMatch
	 *            The match for the selected node.
	 */
	void selection(NodePattern selectedNode, EObject selectedMatch);

	/**
	 * Undo last selection of the search pattern.
	 * 
	 * @param unselectedNode
	 *            The last selected node.
	 */
	void undoSelection(NodePattern unselectedNode);
}