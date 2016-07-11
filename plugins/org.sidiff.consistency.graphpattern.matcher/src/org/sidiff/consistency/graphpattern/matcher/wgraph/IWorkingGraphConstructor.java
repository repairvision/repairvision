package org.sidiff.consistency.graphpattern.matcher.wgraph;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.algorithms.IAlgorithm;

/**
 * Constructs the necessary (minimal) working graph for a given graph pattern.
 * The working graph must contain all objects and references that can be part of
 * matching. Nevertheless, the graph can contain more objects and references.
 * 
 * @author Manuel Ohrndorf
 */
public interface IWorkingGraphConstructor extends IAlgorithm {

	/**
	 * @param graphPattern
	 *            All nodes of the graph pattern that should be matched.
	 * @param variableNodes
	 *            The nodes which correspond to the matching formula:
	 *            <code>match = v_1 x v_2 x ... x v_n</code>
	 * @param variableNodeDomains
	 *            The variable node domains.
	 */
	public void initialize(List<NodePattern> graphPattern, List<NodePattern> variableNodes,
			Map<NodePattern, Collection<EObject>> variableNodeDomains);

	/**
	 * @return All nodes of the graph pattern that should be matched.
	 */
	public List<NodePattern> getGraphPattern();

	/**
	 * @return The nodes which correspond to the matching formula:
	 *         <code>match = v_1 x v_2 x ... x v_n</code>
	 */
	public List<NodePattern> getVariableNodes();
}
