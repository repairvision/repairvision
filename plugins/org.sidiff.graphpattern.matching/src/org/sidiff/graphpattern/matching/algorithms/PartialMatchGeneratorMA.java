package org.sidiff.graphpattern.matching.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.dependencies.DependencyEvaluation;
import org.sidiff.graphpattern.matching.AbstractMatchGenerator;
import org.sidiff.graphpattern.matching.IMatchGenerator;
import org.sidiff.graphpattern.matching.IMatching;
import org.sidiff.graphpattern.matching.selection.MatchSelector;
import org.sidiff.graphpattern.matching.util.Stack;
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
	
	private List<EObject[]> results;
	
	//-------------------------------------------------
	
	private VariableSet remainingVariables;
	
	private Stack<Variable> removedVariables;
	
	private Stack<Variable> blockedVariables;
	
	private Stack<Variable> subVariables;
	
	private Stack<EObject> assignments;

	//-------------------------------------------------
	
	/**
	 * NOTE: Expand after remove variable might lead to no new matchings! 
	 */
	private boolean isNewMatch = false;
	
	//-------------------------------------------------
	
	private Variable initialVariable;
	
	private MatchSelector matchSelector;
	
	private DependencyEvaluation dependencies;
	
	//-------------------------------------------------
	
	private int falsePositives = 0;
	
	//-------------------------------------------------
	
	private boolean MINIMUM_SOLUTION = true;
	
	private int minimumSolutionSize = 6;

	/**
	 * AVOID_NON_MAXIMUM_SOLUTIONS -> globalAssigned
	 */
	private boolean AVOID_NON_MAXIMUM_SOLUTIONS = true;
	
	/**
	 * GLOBAL_GREEDY -> globalAssigned
	 */
	private boolean GLOBAL_GREEDY = false;
	
	private Map<Variable, Set<EObject>> globalAssigned;
	
	/**
	 * LOCAL_GREEDY -> localAssigned
	 */
	private boolean LOCAL_GREEDY = false;
	
	private Map<Variable, Set<EObject>> localAssigned;
	
	//-------------------------------------------------
	
	private class Variable {
		int index;
		NodePattern node;
	}
	
	private class VariableSet implements Iterable<Variable> {
		
		private Variable[] variables;
		private int size = 0;
		
		public VariableSet(int capacity) {
			variables = new Variable[capacity];
		}
		
		public void add(Variable variable) {
			variables[variable.index] = variable;
			++size;
		}
		
		public void remove(Variable variable) {
			variables[variable.index] = null;
			--size;
		}
		
		public int size() {
			return size;
		}
		
		public boolean contains(Variable variable) {
			return variables[variable.index] != null;
		}

		@Override
		public Iterator<Variable> iterator() {
			return new Iterator<Variable>() {
				int i = 0;
				int view = 0;
				
				public boolean hasNext() {
					return i < size;
				}

				public Variable next() {
					while (view < variables.length) {
						++view;
						
						if (variables[view - 1] != null) {
							++i;
							return variables[view - 1];
						}
					}
					
					throw new NoSuchElementException();
				}
			};
		}
	}
	
	//-------------------------------------------------
	
	@Override
	public void initialize(List<NodePattern> graphPattern, List<NodePattern> variableNodes) {
		super.initialize(graphPattern, variableNodes);

		// evaluation:
		assignments = new Stack<EObject>(variableNodes.size());
		
		// dependencies:
		// TODO: add GraphPattern or DependencyGraph to initialize!
		if (!graphPattern.isEmpty()) {
			dependencies = new DependencyEvaluation(graphPattern.get(0).getGraph());
			dependencies.start();
		}

		//  [Heuristic]: assignment stores:
		if (GLOBAL_GREEDY || AVOID_NON_MAXIMUM_SOLUTIONS) {
			globalAssigned = new HashMap<>();
		}
		if (LOCAL_GREEDY) {
			localAssigned = new HashMap<>();
		}
		
		// variables:
		remainingVariables = new VariableSet(variableNodes.size());
		removedVariables = new Stack<Variable>(variableNodes.size());
		blockedVariables = new Stack<Variable>(variableNodes.size());
		subVariables = new Stack<Variable>(variableNodes.size());
		
		for (int i = 0; i < variableNodes.size(); i++) {
			Variable iVariable = new Variable();
			iVariable.index = i;
			iVariable.node = variableNodes.get(i);
			
			remainingVariables.add(iVariable);
			nodeToVariables.put(iVariable.node, iVariable);
			
			//  [Heuristic]: assignment stores:
			if (GLOBAL_GREEDY || AVOID_NON_MAXIMUM_SOLUTIONS) {
				globalAssigned.put(iVariable, new HashSet<>());
			}
			if (LOCAL_GREEDY) {
				localAssigned.put(iVariable, new HashSet<>());
			}
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
		results = new ArrayList<>();
		assignments.reset();
		
		long matchingTime = System.currentTimeMillis();
		expandAssignment(0);
		System.out.println("Matching Time: " + (((double) System.currentTimeMillis() - matchingTime) / 1000.0) + "s");
		System.out.println("False Positives: " + falsePositives);
		System.out.println("Matchings Found: " + results.size());
	}
	
	//-------------------------------------------------
	// Main Algorithm:
	//-------------------------------------------------
	
	private void expandAssignment(int unassigned) {
		
		// is expandable?
		int next = (unassigned == 0) ? pickAndAppendVariable() : unassigned;

		if (next != 0) {
			boolean firstVariableOfAtomic = (unassigned == 0);
			
			Variable variable = subVariables.get(assignments.size());
			Iterator<EObject> domain = getDomain(variable);
			boolean domainIsEmpty = !domain.hasNext();
			
			// ensure atomic dependencies:
			if ((unassigned > 0) && domainIsEmpty) return;

			// create all sub-patterns which include the picked variable(s):
			while (domain.hasNext()) {
				assignVariable(variable, domain.next(), firstVariableOfAtomic);
				expandAssignment(next - 1);
				freeVariable(variable);
			}

			// create all sub-patterns which exclude the picked variable(s):
			if (firstVariableOfAtomic) {
				removeVariable(next, domainIsEmpty);
				int cleared = cleanUpVariables(next);
				
				if ((estimateSolutionSize() >= minimumSolutionSize) && (containsUnusedElements())){
					expandAssignment(unassigned);
				}

				undoCleanUp(cleared);
				addVariable(next, domainIsEmpty);
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
	
	private int pickAndAppendVariable() {
		
		// check if there any more variables to assign:
		if (remainingVariables.size() > 0) {
			Variable pickedVariable = pickAnyVariable();
			
			// FIXME: unstable result!
//			if (AVOID_NON_MAXIMUM_SOLUTIONS) {
//				pickedVariable = pickMostUnusedVariable();
//			} else {
//				pickedVariable = pickAnyVariable();
//			}

			if (pickedVariable != null) {
				List<NodePattern> atomicNodes = dependencies.getAtomic(pickedVariable.node);

				for (NodePattern atomicNode : atomicNodes) {
					Variable atomicVariable = nodeToVariables.get(atomicNode);
					subVariables.push(atomicVariable);
					remainingVariables.remove(atomicVariable);
				}

				dependencies.remove(pickedVariable.node);
				return atomicNodes.size();
			}
		}
		
		return 0;
	}
	
	private Variable pickAnyVariable() {
		for (DependencyNode independent : dependencies.getActualIndependent()) {
			Variable independentVariable = nodeToVariables.get(independent.getNodes().get(0));
			
			if (remainingVariables.contains(independentVariable)) {
				return independentVariable;
			}
		}
		return null;
	}
	
	private Variable pickMostUnusedVariable() {
		Variable mostUnusedVariable = null;
		int maxUnusedElements = -1;
		
		for (DependencyNode independent : dependencies.getActualIndependent()) {
			for (NodePattern independentNode : independent.getNodes()) {
				Variable independentVariable = nodeToVariables.get(independentNode);
				
				if (remainingVariables.contains(independentVariable)) {
					NavigableMatchesDS dataStore = WGraph.getDataStore(independentVariable.node.getEvaluation());
					int unusedElements = dataStore.getMatchSize() - globalAssigned.get(independentVariable).size();
					// NOTE: approximation -> exact -> dataStore.getMatchSelection().getMatch().size()
					
					if (unusedElements > maxUnusedElements) {
						maxUnusedElements = unusedElements;
						mostUnusedVariable = independentVariable;
					}
				} else {
					// skip atomic dependency:
					break;
				}
					
			}
		}
		
		return mostUnusedVariable;
	}
	
	private Iterator<EObject> getDomain(Variable variable) {
		NavigableMatchesDS dataStore = WGraph.getDataStore(variable.node.getEvaluation());
		
		if (matchSelector != null) {
			
			// domain based on restricted working graph:
			if (LOCAL_GREEDY) {
				// [HEURISTIC]: only elements that were not assigned yet:
				return new FilteredIterator(
						dataStore.getMatchSelection().getSelectedMatches(), 
						localAssigned.get(variable));
			} else {
				return dataStore.getMatchSelection().getSelectedMatches();
			}
		} else {
			
			// no initial selection:
			if (GLOBAL_GREEDY) {
				// [HEURISTIC]: only elements that were not assigned yet:
				return new FilteredIterator(
						dataStore.getMatchIterator(), 
						globalAssigned.get(variable));
			} else {
				return dataStore.getMatchIterator();
			}
		}
	}
	
	private void assignVariable(Variable variable, EObject value, boolean firstVariableOfAtomic) {
		
		// initialize new sub-matching:
		if (matchSelector == null) {
			if (LOCAL_GREEDY) {
				clearLocalAssigned();
			}
			
			initialVariable = variable;
			matchSelector = new MatchSelector(
					getAtomicPatternFactory(), graphPattern, 
					variable.node, value);
		}
		
		// store assignment:
		assignments.push(value);
		
		if (LOCAL_GREEDY) {
			localAssigned.get(variable).add(value);
		}
		
		//-------------------------------------------------
		// Restrict Working Graph
		//-------------------------------------------------
		
		// select value:
		// NOTE: No further selections needed for atomic dependent variables!
		if (firstVariableOfAtomic) {
			matchSelector.selectMatch(variable.node, value);
		}
		
		// ensure injectivity:
		for (Variable remainingVariable : remainingVariables) {
			NavigableMatchesDS nodeDS = WGraph.getDataStore(remainingVariable.node.getEvaluation());
			nodeDS.getMatchSelection().restrictSelection(variable.node, value);
		}
		//-------------------------------------------------
		
		// new match created!
		isNewMatch = true;
	}
	
	private void clearLocalAssigned() {
		for (Variable variable : localAssigned.keySet()) {
			localAssigned.get(variable).clear();
		}
	}
	
	private void freeVariable(Variable variable) {
		
		// new initial sub-matching:
		if (variable == initialVariable) {
			initialVariable = null;
			matchSelector = null;
		}
		
		// unset assignment:
		assignments.pop();

		//-------------------------------------------------
		// Restrict Working Graph
		//-------------------------------------------------
		
		// NOTE: undo the restriction in reverse order (injectivity, selection)!
		
		// ensure injectivity:
		for (Variable remainingVariable : remainingVariables) {
			NavigableMatchesDS nodeDS = WGraph.getDataStore(remainingVariable.node.getEvaluation());
			nodeDS.getMatchSelection().undoRestrictSelection(variable.node);
		}
		
		// undo restriction on all nodes (full graph):
		for (NodePattern node : graphPattern) {
			NavigableMatchesDS nodeDS = WGraph.getDataStore(node.getEvaluation());
			nodeDS.getMatchSelection().undoRestrictSelection(variable.node);	
		}
		//-------------------------------------------------
		
		// reverted to old match!
		isNewMatch = false;
	}
	
	private void removeVariable(int count, boolean domainIsEmpty) {
		for (int i = 0; i < count; ++i) {
			Variable atomicVariable = subVariables.pop();
	        removedVariables.push(atomicVariable);
	        
	        if (!domainIsEmpty) {
	        	blockedVariables.push(atomicVariable);
	        }
		}
		dependencies.undoRemoveDependency();
	}
	
	private void addVariable(int count, boolean domainIsEmpty) {
		for (int i = 0; i < count; ++i) {
	          Variable atomicVariable = removedVariables.pop();
	          remainingVariables.add(atomicVariable);
	          
	          if (!domainIsEmpty) {
	        	  blockedVariables.pop();
	          }
	     } 
	}
	
	private int cleanUpVariables(int lastRemoved) {
		int cleared = 0;
		
		// remove dependent variables:
		if (MINIMUM_SOLUTION || AVOID_NON_MAXIMUM_SOLUTIONS) {
			
			// NOTE: It is sufficient to check one variable of an atomic patter!
			Set<NodePattern> dependent = dependencies.getDependent(removedVariables.peek().node);
				
			for (Variable remainingVariable : remainingVariables) {
				
				if (dependent.contains(remainingVariable.node) 
						// Remove variables with empty domains -> simplifies size estimation:
						|| ((matchSelector != null) && !getDomain(remainingVariable).hasNext())) {
					
					remainingVariables.remove(remainingVariable);
					removedVariables.push(remainingVariable);
					++cleared;
				}
			}
		}
		
		// remove variables 
		if (AVOID_NON_MAXIMUM_SOLUTIONS) {
			
		}
		
		return cleared;
	}

	private void undoCleanUp(int cleared) {
		if (MINIMUM_SOLUTION || AVOID_NON_MAXIMUM_SOLUTIONS) {
			for (int i = 0; i < cleared; ++i) {
				Variable clearedVariable = removedVariables.pop();
		        remainingVariables.add(clearedVariable);
			}
		}
	}
	
	private boolean containsUnusedElements() {
		if (AVOID_NON_MAXIMUM_SOLUTIONS) {
			for (Variable remainingVariable : remainingVariables) {
				Set<EObject> globalAssignedOfVariable = globalAssigned.get(remainingVariable);

				for (Iterator<EObject> iterator = getDomain(remainingVariable); iterator.hasNext();) {
					if (!globalAssignedOfVariable.contains(iterator.next())) {
						return true;
					}
				}
			}
			return false;
		}
		return true;
	}

	private int estimateSolutionSize() {
		if (MINIMUM_SOLUTION) {
			return subVariables.size() + remainingVariables.size();
		}
		return Integer.MAX_VALUE;
	}
 
	private boolean validateAssignment() {
		return (!MINIMUM_SOLUTION || (assignments.size() >= minimumSolutionSize)) && isNewMatch 
				&& isPartialAssignment() && isMaximumAssignment(); // && validateAtomics();
	}
	
	private boolean isPartialAssignment() {
		return (assignments.size() != remainingVariables.size()) && (assignments.size() != 0);
	}
	
	private boolean isMaximumAssignment() {
		
		for (int i = 0; i < blockedVariables.size(); ++i) {
			NodePattern node = blockedVariables.get(i).node;
					
			if (dependencies.canRemove(node)) {
				NavigableMatchesDS nodeDS = WGraph.getDataStore(node.getEvaluation());
				
				if (!nodeDS.getMatchSelection().isEmpty()) {
					return false;
				}
			}
		}
		
		return true;
	}
	
//	private boolean validateAtomics() {
//		Set<NodePattern> matched = new HashSet<>();
//		
//		for (int i = 0; i < subVariables.size(); i++) {
//			matched.addAll(dependencies.getAtomic(subVariables.get(i).node));
//		}
//		
//		for (NodePattern matchedNode : matched) {
//			for (NodePattern dependentNode : dependencies.getAtomic(matchedNode)) {
//				if (!matched.contains(dependentNode)) {
//					return false;
//				}
//			}
//		}
//		
//		return true;
//	}
	
	private void storeAssignment() {
		EObject[] assignments = new EObject[variableNodes.size()];
		results.add(assignments);
		
		for (int i = 0; i < this.assignments.size(); i++) {
			Variable variable = subVariables.get(i);
			EObject value = this.assignments.get(i);
			
			assert (variable.node.getType() == value.eClass());
			assignments[variable.index] = value;
				
			// [Heuristic]: store assigned values:
			if (GLOBAL_GREEDY || AVOID_NON_MAXIMUM_SOLUTIONS) {
				globalAssigned.get(variable).add(value);
			}
		}
	}
	
	@Override
	public Iterator<IMatching> getResults() {
		return new Iterator<IMatching>() {

			private Iterator<EObject[]> assignmentIterator = results.listIterator();
			
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
	
	@SuppressWarnings("unused")
	private String printAssignment() {
		StringBuffer print = new StringBuffer();
		
		for (int i = 0; i < subVariables.size(); ++i) {
			
			// Node:
			NodePattern node =  subVariables.get(i).node;
			
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
			if (i < assignments.size()) {
				EObject value = assignments.get(i);
				
				print.append("  Value: " + value);
				print.append("\n");
				
				if (value != null) {
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
		}
		
		return print.toString();
	}
}
