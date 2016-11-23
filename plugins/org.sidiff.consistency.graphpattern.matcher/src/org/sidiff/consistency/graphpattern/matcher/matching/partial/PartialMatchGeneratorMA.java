package org.sidiff.consistency.graphpattern.matcher.matching.partial;

import static org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper.getDataStore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.data.NavigableMatchesDS;
import org.sidiff.consistency.graphpattern.matcher.data.selection.MatchSelection;
import org.sidiff.consistency.graphpattern.matcher.matching.AbstractMatchGenerator;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatching;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.MatchSelector;

public abstract class PartialMatchGeneratorMA extends AbstractMatchGenerator<IMatching> {

	private Map<NodePattern, Variable> nodeToVariables = new HashMap<>();
	
	private Variable[] variables;
	
	private List<EObject[]> assignments;
	
	private EObject[] assignment;
	
	private int assignmentCount;
	
	private Variable initialVariable;
	
	private MatchSelector matchSelector;
	
	private EObject placeholder = new EObjectImpl() {};
	
	//-------------------------------------------------
	
	private Map<Variable, Set<EObject>> assigned = new HashMap<>();
	
	//-------------------------------------------------
	
	private class Variable {
		int index;
		NodePattern node;
	}
	
	@Override
	public void initialize(List<NodePattern> graphPattern, List<NodePattern> variableNodes) {
		super.initialize(graphPattern, variableNodes);
		variables = new Variable[variableNodes.size()];
		
		for (int i = 0; i < variableNodes.size(); i++) {
			Variable iVariable = new Variable();
			iVariable.index = i;
			iVariable.node = variableNodes.get(i);
			
			variables[i] = iVariable;
			nodeToVariables.put(iVariable.node, iVariable);
			
			assigned.put(iVariable, new HashSet<>());
		}
	}
	
	@Override
	public void start() {
		super.start();
		initializeDataStore();
		findAssignments();
	}
	
	/**
	 * Initialize data store of all nodes.
	 */
	private void initializeDataStore() {
		for (NodePattern node : graphPattern) {
			NavigableMatchesDS dataStore = getDataStore(node.getEvaluation());
			dataStore.getMatchSelection().clearSelection();
		}
	}
	
	private void findAssignments() {
		assignments = new ArrayList<>();
		assignment = new EObject[variables.length];
		
		long matchingTime = System.currentTimeMillis();
		expandAssignment(0);
		System.out.println("Matching Time: " + (((double) System.currentTimeMillis() - matchingTime) / 1000.0) + "s");
	}
	
	private void expandAssignment(int variableIndex) {
		
		// is extensible?
		if (isExpandable(variableIndex)) {
			
			// get variable domain:
			Variable variable = variables[variableIndex];
			Iterator<EObject> domain = getDomain(variable);
			
			// expand assignment:
			while (domain.hasNext()) {
				EObject value = domain.next();
				
				assignVariable(variable, value);
				expandAssignment(variable.index + 1);
				freeVariable(variable);
			}
			
			// sub-pattern:
			removeVariable(variable);
			expandAssignment(variable.index + 1);
			addVariable(variable);
		} else {
			
			// save actual assignment:
			if (isMaximumAssignment() && isPartialAssignment()) {
				storeAssignment();
			}
		}
	}
	
	private boolean isExpandable(int variableIndex) {
		
		// check if there are any more assignable values:
		boolean assignableValues = false;
		
		if (matchSelector != null) {
			for (int i = variableIndex; i < variables.length; ++i) {
				NavigableMatchesDS dataStore = getDataStore(variables[i].node.getEvaluation());
				MatchSelection matchSelection = dataStore.getMatchSelection();
				
				if (!matchSelection.isEmpty()) {
					assignableValues = true;
					break;
				}
			}
		} else {
			// selection is not yet initialized!
			assignableValues = true;
		}
		
		// check if there any more variables to assign:
		return assignableValues && (variableIndex < variables.length);
//		return (variableIndex < variables.length);
	}
	
	private Iterator<EObject> getDomain(Variable variable) {
		
		if (matchSelector != null) {
			// domain based on restricted working graph:
			NavigableMatchesDS dataStore = getDataStore(variable.node.getEvaluation());
			MatchSelection matchSelection = dataStore.getMatchSelection();
			
			// [HEURISTIC]: only elements that were not assigned yet:
			// TODO: filter iterator - no list copy
			List<EObject> match = matchSelection.getMatch();
			match.removeAll(assigned.get(variable));
			return match.iterator();

			// all possible matchings:
			// return matchSelection.getSelectedMatches();
		} else {
			// no initial selection:
			NavigableMatchesDS dataStore = getDataStore(variable.node.getEvaluation());
			return dataStore.getMatchIterator();
		}
	}
	
	private void assignVariable(Variable variable, EObject value) {
		
		// initialize new sub-matching:
		if (matchSelector == null) {
			initialVariable = variable;
			matchSelector = new MatchSelector(
					getAtomicPatternFactory(), graphPattern, 
					variable.node, value);
		}
		
		// store assignment:
		assignment[variable.index] = value;
		
		// restrict working graph:
		matchSelector.selectMatch(variable.node, value);
		
		// count assignments:
		++assignmentCount;
		
		// store assigned values:
		assigned.get(variable).add(value);
	}
	
	private void freeVariable(Variable freeVariable) {
		
		// new initial sub-matching:
		if (freeVariable == initialVariable) {
			initialVariable = null;
			matchSelector = null;
		}
		
		// unset assignment:
		assignment[freeVariable.index] = null;

		// undo restriction on all nodes (full graph):
		for (NodePattern node : graphPattern) {
			NavigableMatchesDS nodeDS = getDataStore(node.getEvaluation());
			nodeDS.getMatchSelection().undoRestrictSelection(freeVariable.node);	
		}
		
		// count assignments:
		--assignmentCount;
	}
	
	private void removeVariable(Variable variable) {
		assignment[variable.index] = placeholder;
	}
	
	private void addVariable(Variable variable) {
		assignment[variable.index] = null;
	}
	
	private boolean isMaximumAssignment() {
		
		for (int i = 0; i < assignment.length; ++i) {
			EObject value = assignment[i]; 
					
			if (value == placeholder) {
				NavigableMatchesDS nodeDS = getDataStore(variables[i].node.getEvaluation());
				
				if (!nodeDS.getMatchSelection().isEmpty()) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private void storeAssignment() {
		EObject[] assignment = new EObject[this.assignment.length];
		assignments.add(assignment);
		
		for (int i = 0; i < this.assignment.length; i++) {
			EObject value = this.assignment[i];
			
			if (value != placeholder) {
				assignment[i] = value;
			}
		}
	}
	
	private boolean isPartialAssignment() {
		return assignmentCount != variables.length;
	}

	@Override
	public Iterator<IMatching> getResults() {
		return new Iterator<IMatching>() {

			private Iterator<EObject[]> assignmentIterator = assignments.listIterator();
			
			@Override
			public boolean hasNext() {
				return assignmentIterator.hasNext();
			}

			@Override
			public IMatching next() {
				if (hasNext()) {
					return new IMatching() {
						
						private EObject[] assignment = assignmentIterator.next();
						
						@Override
						public Iterator<EObject> getMatch(NodePattern node) {
							if (nodeToVariables.containsKey(node)) {
								return Collections.singletonList(assignment[nodeToVariables.get(node).index]).iterator();
							} else {
								List<EObject> emptyEList = Collections.emptyList();
								return emptyEList.iterator();
							}
						}

						@Override
						public Collection<NodePattern> getNodes() {
							return getVariableNodes();
						}

						@Override
						public EObject getFirstMatch(NodePattern node) {
							return assignment[nodeToVariables.get(node).index];
						}
					};
				} else {
					throw new NoSuchElementException();
				}
			}
		};
	}
}
