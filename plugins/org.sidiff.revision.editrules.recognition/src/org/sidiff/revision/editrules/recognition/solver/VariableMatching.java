package org.sidiff.revision.editrules.recognition.solver;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.common.utilities.string.StringPrinter;

public class VariableMatching implements IMatching {

	// TODO: Store the matchings in a container and store the global information there... 
	private Map<NodePattern, Variable> nodeToVariables;
	
	// TODO: Store the matchings in a container and store the global information there... 
	private List<NodePattern> variableNodes;
	
	private EObject[] assignment;
	
	private Integer size;
	
	public VariableMatching(
			Map<NodePattern, Variable> nodeToVariables, List<NodePattern> variableNodes,
			EObject[] assignment, Integer size) {

		this.nodeToVariables = nodeToVariables;
		this.variableNodes = variableNodes;
		this.assignment = assignment;
		this.size = size;
	}

	@Override
	public Iterator<EObject> getMatch(NodePattern node) {
		if (nodeToVariables.containsKey(node)) {
			
			// singleton iterator:
			return new Iterator<EObject>() {
				
				private boolean hasNext = true;

				@Override
				public boolean hasNext() {
					return hasNext;
				}

				@Override
				public EObject next() {
					if (hasNext()) {
						hasNext = false;
						return assignment[nodeToVariables.get(node).index];
					} else {
						throw new NoSuchElementException();
					}
				}
			};
		} else {
			
			// empty iterator:
			return new Iterator<EObject>() {

				@Override
				public boolean hasNext() {
					return false;
				}

				@Override
				public EObject next() {
					throw new NoSuchElementException();
				}
			};
		}
	}

	@Override
	public Collection<NodePattern> getNodes() {
		return variableNodes;
	}

	@Override
	public EObject getFirstMatch(NodePattern node) {
		return assignment[nodeToVariables.get(node).index];
	}
	
	@Override
	public String toString() {
		StringPrinter toString = new StringPrinter();
		
		for (int i = 0; i < variableNodes.size(); i++) {
			toString.print(variableNodes.get(i).getName());
			toString.print(": ");
			toString.println(assignment[i]);
		}
		
		return toString.toString();
	}

	@Override
	public boolean isPartialMatching() {
		return assignment.length != size;
	}
}
