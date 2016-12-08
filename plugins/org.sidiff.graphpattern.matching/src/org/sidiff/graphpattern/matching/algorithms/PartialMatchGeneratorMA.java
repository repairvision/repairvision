package org.sidiff.graphpattern.matching.algorithms;

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
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.dependencies.DependencyEvaluation;
import org.sidiff.graphpattern.matching.AbstractMatchGenerator;
import org.sidiff.graphpattern.matching.IMatchGenerator;
import org.sidiff.graphpattern.matching.IMatching;
import org.sidiff.graphpattern.matching.selection.MatchSelector;
import org.sidiff.graphpattern.wgraph.selection.MatchSelection;
import org.sidiff.graphpattern.wgraph.store.NavigableMatchesDS;
import org.sidiff.graphpattern.wgraph.util.WGraph;

/**
 * Concrete implementation of {@link IMatchGenerator}. Iterates through all
 * possible (maximal) partial matches for a given graph.
 * 
 * @author Manuel Ohrndorf
 */
public abstract class PartialMatchGeneratorMA extends AbstractMatchGenerator<IMatching> {

	private Map<NodePattern, Variable> nodeToVariables = new HashMap<>();
	
	private Variable[] variables;
	
	private List<EObject[]> assignments;
	
	private EObject[] assignment;
	
	private Set<EObject> assignmentSet;
	
	private int assignmentCount = 0;
	
	private int falsePositives = 0;
	
	// NOTE: Expand after remove variable might lead to no new matchings! 
	private boolean isNewMatch = false;
	
	private Variable initialVariable;
	
	private EObject placeholder = new EObjectImpl() {};
	
	//-------------------------------------------------
	
	private MatchSelector matchSelector;
	
	private DependencyEvaluation dependencyEvaluation;
	
	//-------------------------------------------------
	
	private boolean GREEDY = false;
	
	private Map<Variable, Set<EObject>> assigned = new HashMap<>();
	
	private boolean LOCAL_MAXIMUM = false;
	
	private int maximumLocalAssignment = -1;
	
	//-------------------------------------------------
	
	private class Variable {
		int index;
		int id;
		NodePattern node;
	}
	
	@Override
	public void initialize(List<NodePattern> graphPattern, List<NodePattern> variableNodes) {
		super.initialize(graphPattern, variableNodes);
		
		// evaluation:
		// TODO: add GraphPattern or DependencyGraph to initialize!
		if (!graphPattern.isEmpty()) {
			dependencyEvaluation = new DependencyEvaluation(graphPattern.get(0).getGraph());
			dependencyEvaluation.start();
		}
		
		// variables:
		variables = new Variable[variableNodes.size()];
		
		for (int i = 0; i < variableNodes.size(); i++) {
			Variable iVariable = new Variable();
			iVariable.index = i;
			iVariable.id = i;
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
			NavigableMatchesDS dataStore = WGraph.getDataStore(node.getEvaluation());
			dataStore.getMatchSelection().clearSelection();
		}
	}
	
	private void findAssignments() {
		assignments = new ArrayList<>();
		assignment = new EObject[variables.length];
		assignmentSet = new HashSet<>();
		
		long matchingTime = System.currentTimeMillis();
		expandAssignment(0, 0);
		System.out.println("Matching Time: " + (((double) System.currentTimeMillis() - matchingTime) / 1000.0) + "s");
		System.out.println("False Positives: " + falsePositives);
		System.out.println("Matchings Found: " + assignments.size());
	}

//	// variableIndex = assignmentCount + placeholderCount
//	private void expandAssignment(int variableIndex) {
//		
//		// is expandable?
//		List<NodePattern> atomicVariables = nextVariables(variableIndex);
//		
//		if (!atomicVariables.isEmpty()) {
//			
//			// create all sub-patterns which include the picked variable(s):
//			appendVariables(atomicVariables, variableIndex);
//			
//			// assign (first) variable:
//			Variable variable = variables[variableIndex];
//			assert (variableIndex == variable.index); // TODO remove
//			
//			Iterator<EObject> domain = getDomain(variable);
//
//			while (domain.hasNext()) {
//				assignVariable(variable, domain.next());
//				boolean couldAssign = true;
//				
//				for (int i = variableIndex + 1; i < variableIndex + atomicVariables.size(); ++i) {
//					couldAssign = coAssignVariable(variables[i]);
//				}
//				
//				if (couldAssign) {
//					expandAssignment(variableIndex + atomicVariables.size());
//				}
//				
//				freeVariable(variable);
//				
//				for (int i = variableIndex + 1; i < variableIndex + atomicVariables.size(); ++i) {
//					coFreeVariable(variables[i]);
//				}
//			}
//			
//			// create all sub-patterns which exclude the picked variable(s):
//			if (canRemoveVariables(variableIndex, atomicVariables)) {
//				removeVariable(atomicVariables);
//				expandAssignment(variableIndex + atomicVariables.size());
//				addVariable(atomicVariables);
//			}
//		} else {
//			
//			// save actual assignment:
//			if (validateAssignment()) {
//				storeAssignment();
//			} else {
//				++falsePositives;
//			}
//		}
//	}
	
	// variableIndex = assignmentCount + placeholderCount
	private void expandAssignment(int variableIndex, int atomicSize) {
		
		// is expandable?
		List<NodePattern> atomicVariables = null;
		
		if (atomicSize == 0) {
			atomicVariables = new ArrayList<>(nextVariables(variableIndex));
			atomicSize = atomicVariables.size();
			
			if (!atomicVariables.isEmpty()) {
				appendVariables(atomicVariables, variableIndex);
			}
		}
		
		if (atomicSize != 0) {
			
			// create all sub-patterns which include the picked variable(s):
			Variable variable = variables[variableIndex];
			assert (variableIndex == variable.index); // TODO remove
			Iterator<EObject> domain = getDomain(variable);

			while (domain.hasNext()) {
				assignVariable(variable, domain.next());
				expandAssignment(variableIndex + 1, atomicSize - 1);
				freeVariable(variable);
			}
			
			// create all sub-patterns which exclude the picked variable(s):
			if (atomicVariables != null && canRemoveVariables(variableIndex, atomicVariables)) {
				removeVariable(atomicVariables);
				expandAssignment(variableIndex + atomicVariables.size(), 0);
				addVariable(atomicVariables);
			}
		} else {
			
			// save actual assignment:
			if (validateAssignment()) {
				storeAssignment();
			} else {
				++falsePositives;
			}
		}
	}

	// TODO: map nodes to atomic variables
	// oder eine Variable kann mehrere Knoten repräsentieren
	private List<NodePattern> nextVariables(int variableIndex) {
		
		// check if there any more variables to assign:
		if (variableIndex < variables.length) {
			
			for (int i = variableIndex; i < variables.length; ++i) {
				NodePattern node = variables[i].node;

				// is currently independent variable?
				if (dependencyEvaluation.canRemove(node)) {
					NavigableMatchesDS dataStore = WGraph.getDataStore(node.getEvaluation());

					// can expand the actual matching?
					if (matchSelector != null) {
						if (!dataStore.getMatchSelection().isEmpty()) {
							return dependencyEvaluation.getAtomic(node);
						}
					} else {
						if (!dataStore.isEmptyMatch()) {
							// if (GREEDY) TODO: filter already selected...
							return dependencyEvaluation.getAtomic(node);
						}
					}
				}
			}
		}
		
		return Collections.emptyList();
	}
	
	private void appendVariables(List<NodePattern> atomicVariables, int variableIndex) {
		for (NodePattern node : atomicVariables) {
			Variable actualVariable = nodeToVariables.get(node);
			int actualVariableIndex = actualVariable.index;
			
			variables[variableIndex].index = actualVariableIndex;
			variables[actualVariableIndex] = variables[variableIndex];
			
			variables[variableIndex] = actualVariable;
			actualVariable.index =variableIndex;
			
			++variableIndex;
		}
	}
	
	private Iterator<EObject> getDomain(Variable variable) {
		
		if (matchSelector != null) {
			
			// domain based on restricted working graph:
			NavigableMatchesDS dataStore = WGraph.getDataStore(variable.node.getEvaluation());
			MatchSelection matchSelection = dataStore.getMatchSelection();
			
			// all actually selected matchings:
			return matchSelection.getSelectedMatches();
		} else {
			
			// no initial selection:
			if (GREEDY) {
				// [HEURISTIC]: only elements that were not assigned yet:
				return new FilteredIterator(
						WGraph.getDataStore(variable.node.getEvaluation()).getMatchIterator(), 
						assigned.get(variable));
			} else {
				NavigableMatchesDS dataStore = WGraph.getDataStore(variable.node.getEvaluation());
				return dataStore.getMatchIterator();
			}
		}
	}
	
	// TODO: Wenn mehrere Variablen im selben atomaren Pattern liegen (z.B. AddObject und Container/Containment),
	// dann ist eine weitere Selektion (Pathselektion) eigentlich überflüssig!
	// -> intern für atomares Pattern merken oder mehrere Variablen gleichzeitig festlegen!
	
	private boolean coAssignVariable(Variable variable) {
		NavigableMatchesDS nodeDS = WGraph.getDataStore(variable.node.getEvaluation());
		Iterator<EObject> it = nodeDS.getMatchSelection().getSelectedMatches();
		
		if (it.hasNext()) {
			EObject value = it.next();
			assert !it.hasNext(); // FIXME
			
			// store assignment:
			assignment[variable.index] = value;
			assignmentSet.add(value);
			
			// ensure injectivity:
			for (int i = variable.index + 1; i < variables.length; i++) {
				NavigableMatchesDS otherNodeDS = WGraph.getDataStore(variables[i].node.getEvaluation());
				otherNodeDS.getMatchSelection().restrictSelection(variable.node, value);
			}
			
			// count assignments:
			++assignmentCount;
		} else {
			return false;
		}
		
		
		return true;
	}
	
	private void assignVariable(Variable variable, EObject value) {
		
		// initialize new sub-matching:
		if (matchSelector == null) {
			maximumLocalAssignment = -1;
			initialVariable = variable;
			matchSelector = new MatchSelector(
					getAtomicPatternFactory(), graphPattern, 
					variable.node, value);
		}
		
		// store assignment:
		assignment[variable.index] = value;
		assignmentSet.add(value);
		
		//-------------------------------------------------
		// Restrict Working Graph
		//-------------------------------------------------
		
		// select value:
		matchSelector.selectMatch(variable.node, value);
		
		// ensure injectivity:
		for (int i = variable.index + 1; i < variables.length; i++) {
			NavigableMatchesDS nodeDS = WGraph.getDataStore(variables[i].node.getEvaluation());
			nodeDS.getMatchSelection().restrictSelection(variable.node, value);
		}
		//-------------------------------------------------
		
		// update dependencies:
		dependencyEvaluation.remove(variable.node);
		
		// count assignments:
		++assignmentCount;
		
		// new match created!
		isNewMatch = true;
	}
	
	private void coFreeVariable(Variable variable) {
		
		if (assignment[variable.index] != null) {
			
			// unset assignment:
			assignmentSet.remove(assignment[variable.index]);
			assignment[variable.index] = null;
			
			// undo restriction on all nodes (full graph):
			for (NodePattern node : graphPattern) {
				NavigableMatchesDS nodeDS = WGraph.getDataStore(node.getEvaluation());
				nodeDS.getMatchSelection().undoRestrictSelection(variable.node);	
			}
			
			// count assignments:
			--assignmentCount;
		}
	}
	
	private void freeVariable(Variable variable) {
		
		// new initial sub-matching:
		if (variable == initialVariable) {
			initialVariable = null;
			matchSelector = null;
		}
		
		// unset assignment:
		assignmentSet.remove(assignment[variable.index]); // FIXME ???
		assignment[variable.index] = null;

		//-------------------------------------------------
		// Restrict Working Graph
		//-------------------------------------------------
		
		// NOTE: undo the restriction in reverse order (injectivity, selection)!
		
		// ensure injectivity:
		for (int i = variable.index + 1; i < variables.length; i++) {
			NavigableMatchesDS nodeDS = WGraph.getDataStore(variables[i].node.getEvaluation());
			nodeDS.getMatchSelection().undoRestrictSelection(variable.node);
		}
		
		// undo restriction on all nodes (full graph):
		for (NodePattern node : graphPattern) {
			NavigableMatchesDS nodeDS = WGraph.getDataStore(node.getEvaluation());
			nodeDS.getMatchSelection().undoRestrictSelection(variable.node);	
		}
		//-------------------------------------------------
		
		// update dependencies:
//		Assert.isTrue(dependencyEvaluation.add(variables[variable.index].node));
		dependencyEvaluation.add(variables[variable.index].node);
		
		// count assignments:
		--assignmentCount;
		
		// reverted to old match!
		isNewMatch = false;
	}
	
	// TODO: by length
	private void removeVariable(List<NodePattern> atomicVariables) {
//		assignment[variable.index] = placeholder;
		
		for (NodePattern node : atomicVariables) {
			assignment[nodeToVariables.get(node).index] = placeholder;
		}
	}
	
	private boolean canRemoveVariables(int variableIndex, List<NodePattern> removed) {
		int removedSize = removed.size();
		
		// Check if variable(s) could be removed?
		if (removedSize > 0) {
			
			// filter empty patterns:
			if ((variableIndex + removedSize) < variables.length) {
				
				// Do not remove already assigned variables!
				for (int i = 0; i < removedSize; i++) {
					Variable removedVariable = nodeToVariables.get(removed.get(i));
					
					if (removedVariable.index < variableIndex) {
						return false;
					}
				}
				
				if (LOCAL_MAXIMUM) {
					// [Heuristic]: Search until the maximum assignment in this initial selection is found:
					if (maximumLocalAssignment(variableIndex + removedSize) >= maximumLocalAssignment) {
						return true;
					}
				} else {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private int maximumLocalAssignment(int freeVariables) {
		int maxPossibleAssignments = assignmentCount;

		for (int i = freeVariables; i < assignment.length; ++i) {
			EObject value = assignment[i]; 
			
			if (value == null) {
				NavigableMatchesDS nodeDS = WGraph.getDataStore(variables[i].node.getEvaluation());

				if (matchSelector != null) {
					if (!nodeDS.getMatchSelection().isEmpty()) {
						++maxPossibleAssignments;
					}
				} else {
					if (!nodeDS.isEmptyMatch()) {
						++maxPossibleAssignments;
					}
				}
			}
		}
		
		return maxPossibleAssignments;
	}
 
	// TODO: by length
	private void addVariable(List<NodePattern> atomicVariables) {
		// assignment[variable.index] = null;
		
		for (NodePattern node : atomicVariables) {
			assignment[nodeToVariables.get(node).index] = null;
		}
	}
	
	private boolean validateAssignment() {
		return isNewMatch && isPartialAssignment() && isMaximumAssignment() && validateAtomics();
	}
	
	private boolean isPartialAssignment() {
		return (assignmentCount != variables.length) && (assignmentCount != 0);
	}
	
	private boolean isMaximumAssignment() {
		
		for (int i = 0; i < assignment.length; ++i) {
			EObject value = assignment[i]; 
			NodePattern node = variables[i].node;
					
//			if (value == placeholder) {
			if ((value == placeholder) && (dependencyEvaluation.canRemove(node))) {
				NavigableMatchesDS nodeDS = WGraph.getDataStore(node.getEvaluation());
				
				if (!nodeDS.getMatchSelection().isEmpty()) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// TODO: Auf Atomic-Patterns bzw. Dependency-Conjunctions prüfen!
	// => bereits in assignVariable oder bei der Selektion!? 
	private boolean validateAtomics() {
		Set<NodePattern> matched = new HashSet<>();
		
		for (int i = 0; i < assignment.length; i++) {
			EObject value = assignment[i];
			
			if ((value != null) && (value != placeholder)) {
				matched.add(variables[i].node);
			}
		}
		
		for (NodePattern matchedNode : matched) {
			for (NodePattern dependentNode : dependencyEvaluation.getAtomic(matchedNode)) {
				if (!matched.contains(dependentNode)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private void storeAssignment() {
		EObject[] assignment = new EObject[this.assignment.length];
		assignments.add(assignment);
		
		for (int i = 0; i < variables.length; i++) {
			Variable variable = variables[i];
			EObject value = this.assignment[variable.index];
			
			if ((value != placeholder) && (value != null)) {
				assert (variable.node.getType() == value.eClass());
				assignment[variable.id] = value;
				
				// [Heuristic]: store assigned values:
				assigned.get(variable).add(value);
			}
		}
		
		// [Heuristic]: store new maximum assignment?
		maximumLocalAssignment = Math.max(maximumLocalAssignment, assignmentCount);
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
											return assignment[nodeToVariables.get(node).id];
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
							return getVariableNodes();
						}

						@Override
						public EObject getFirstMatch(NodePattern node) {
							return assignment[nodeToVariables.get(node).id];
						}
					};
				} else {
					throw new NoSuchElementException();
				}
			}
		};
	}
	
	@SuppressWarnings("unused")
	private String printAssignment() {
		StringBuffer print = new StringBuffer();
		
		for (int i = 0; i < variables.length; ++i) {
			
			// Node:
			NodePattern node =  variables[i].node;
			
			print.append("[" + i + "] Name: " + node.getName());
			print.append(", Type: " + node.getType().getName());
			
			// TODO: Generic... incident edges...
			if (node.getType() == SymmetricPackage.eINSTANCE.getAddObject()) {
				print.append(", Obj: " + node.getOutgoing(SymmetricPackage.eINSTANCE.getAddObject_Obj()).getTarget().getName());
			}
			
			else if (node.getType() == SymmetricPackage.eINSTANCE.getRemoveObject()) {
				print.append(", Obj: " + node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveObject_Obj()).getTarget().getName());
			}
			
			else if (node.getType() == SymmetricPackage.eINSTANCE.getAddReference()) {
				print.append(", Src: " + node.getOutgoing(SymmetricPackage.eINSTANCE.getAddReference_Src()).getTarget().getName());
				print.append(", Tgt: " + node.getOutgoing(SymmetricPackage.eINSTANCE.getAddReference_Tgt()).getTarget().getName());
			}
			
			else if (node.getType() == SymmetricPackage.eINSTANCE.getRemoveReference()) {
				print.append(", Src: " + node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveReference_Src()).getTarget().getName());
				print.append(", Tgt: " + node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveReference_Tgt()).getTarget().getName());
			}
			
			else if (node.getType() == SymmetricPackage.eINSTANCE.getAttributeValueChange()) {
				print.append(", ObjA: " + node.getOutgoing(SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjA()).getTarget().getName());
				print.append(", ObjB: " + node.getOutgoing(SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjB()).getTarget().getName());
			}
			
			print.append("\n");
			
			// Value:
			EObject value = assignment[i];
			
			print.append("  Value: " + value);
			print.append("\n");
			
			if ((value != null) && (value != placeholder)) {
				if (node.getType() == SymmetricPackage.eINSTANCE.getAddObject()) {
					print.append("  Obj: " + value.eGet(SymmetricPackage.eINSTANCE.getAddObject_Obj()));
					print.append("\n");
				}
				
				else if (node.getType() == SymmetricPackage.eINSTANCE.getRemoveObject()) {
					print.append("  Obj: " + value.eGet(SymmetricPackage.eINSTANCE.getRemoveObject_Obj()));
					print.append("\n");
				}
				
				else if (node.getType() == SymmetricPackage.eINSTANCE.getAddReference()) {
					print.append("  Src: " + value.eGet(SymmetricPackage.eINSTANCE.getAddReference_Src()));
					print.append("\n");
					print.append("  Tgt: " + value.eGet(SymmetricPackage.eINSTANCE.getAddReference_Tgt()));
					print.append("\n");
				}
				
				else if (node.getType() == SymmetricPackage.eINSTANCE.getRemoveReference()) {
					print.append("  Src: " + value.eGet(SymmetricPackage.eINSTANCE.getRemoveReference_Src()));
					print.append("\n");
					print.append("  Tgt: " + value.eGet(SymmetricPackage.eINSTANCE.getRemoveReference_Tgt()));
					print.append("\n");
				}
				
				else if (node.getType() == SymmetricPackage.eINSTANCE.getAttributeValueChange()) {
					print.append("  ObjA: " + value.eGet(SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjA()));
					print.append("\n");
					print.append("  ObjB: " + value.eGet(SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjB()));
					print.append("\n");
				}
			}
		}
		
		return print.toString();
	}
}
