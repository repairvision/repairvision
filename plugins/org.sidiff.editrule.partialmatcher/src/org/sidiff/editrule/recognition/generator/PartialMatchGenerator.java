package org.sidiff.editrule.recognition.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.editrule.recognition.dependencies.DependencyEvaluation;
import org.sidiff.editrule.recognition.generator.util.FilteredIterator;
import org.sidiff.editrule.recognition.generator.util.Stack;
import org.sidiff.editrule.recognition.pattern.domain.Domain;
import org.sidiff.editrule.recognition.scope.RepairScopeConstraint;
import org.sidiff.editrule.recognition.selection.IMatchSelector;
import org.sidiff.editrule.recognition.util.debug.DebugUtil;
import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.IMatching;

/**
 * Concrete implementation of {@link IMatchGenerator}. Iterates through all
 * possible (maximal) partial matches for a given graph.
 * 
 * @author Manuel Ohrndorf
 */
public class PartialMatchGenerator {

	/**
	 * The nodes which correspond to the matching formula:
	 * <code>match = v_1 x v_2 x ... x v_n</code>
	 */
	protected List<NodePattern> variableNodes;
	
	private Map<NodePattern, Variable> nodeToVariables = new HashMap<>();
	
	private List<EObject[]> results;
	
	//-------------------------------------------------
	
	private VariableSet remainingVariables;
	
	private Stack<Variable> removedVariables;
	
	private Stack<Variable> dependingVariables;
	
	private Stack<Variable> subVariables;
	
	private Stack<EObject> assignments;

	//-------------------------------------------------
	
	/**
	 * NOTE: Expand after remove variable might lead to no new matchings! 
	 */
	private boolean isNewMatch = false;
	
	//-------------------------------------------------
	
	private Variable initialVariable;
	
	private IMatchSelector matchSelector;
	
	private DependencyEvaluation dependencies;
	
	//-------------------------------------------------
	
	private int falsePositives = 0;
	
	//-------------------------------------------------
	
	private boolean MINIMUM_SOLUTION = false;
	
	private int minimumSolutionSize = 1;

	/**
	 * AVOID_NON_MAXIMUM_SOLUTIONS -> globalAssigned
	 */
	private boolean AVOID_NON_MAXIMUM_SOLUTIONS = false;
	
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
	
	private RepairScopeConstraint scope;
	
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
				if (assignVariable(variable, domain.next(), firstVariableOfAtomic)) {
					expandAssignment(next - 1);
				}
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
	
	public void initialize(
			List<NodePattern> variableNodes, 
			DependencyEvaluation dependencies,
			IMatchSelector matchSelector) {

		// evaluation:
		this.variableNodes = variableNodes;
		this.dependencies = dependencies;
		this.matchSelector = matchSelector;
		
		assignments = new Stack<EObject>(variableNodes.size());
		
		// dependencies:
		dependencies.start();
		
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
		dependingVariables = new Stack<Variable>(variableNodes.size());
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
	
	public void setScope(RepairScopeConstraint scope) {
		this.scope = scope;
	}
	
	public void start() {
		initializeDataStore();
		findAssignments();
	}
	
	/**
	 * Initialize data store of all nodes.
	 */
	private void initializeDataStore() {
		for (NodePattern node : variableNodes) {
			Domain domain = Domain.get(node.getEvaluation());
			domain.clearSelection();
		}
	}
	
	private void findAssignments() {
		results = new ArrayList<>();
		assignments.reset();
		
		LogTime matchingTimer = new LogTime();
		
		expandAssignment(0);
		
		matchingTimer.stop();
		DebugUtil.printMatchingTime(matchingTimer);
		DebugUtil.printFalsePositives(falsePositives);
		DebugUtil.printFoundMatchings(results.size());
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
	
	// FIXME: unstable result!
//	private Variable pickMostUnusedVariable() {
//		Variable mostUnusedVariable = null;
//		int maxUnusedElements = -1;
//		
//		for (DependencyNode independent : dependencies.getActualIndependent()) {
//			for (NodePattern independentNode : independent.getNodes()) {
//				Variable independentVariable = nodeToVariables.get(independentNode);
//				
//				if (remainingVariables.contains(independentVariable)) {
//					Domain domain = Domain.get(independentVariable.node.getEvaluation());
//					int unusedElements = domain.getMatchSize() - globalAssigned.get(independentVariable).size();
//					// NOTE: approximation -> exact -> dataStore.getMatchSelection().getMatch().size()
//					
//					if (unusedElements > maxUnusedElements) {
//						maxUnusedElements = unusedElements;
//						mostUnusedVariable = independentVariable;
//					}
//				} else {
//					// skip atomic dependency:
//					break;
//				}
//					
//			}
//		}
//		
//		return mostUnusedVariable;
//	}
	
	private Iterator<EObject> getDomain(Variable variable) {
		Domain domain = Domain.get(variable.node.getEvaluation());
		
		if (matchSelector != null) {
			
			// domain based on restricted working graph:
			if (LOCAL_GREEDY) {
				// [HEURISTIC]: only elements that were not assigned yet:
				return new FilteredIterator(
						domain.getMatchIterator(), 
						localAssigned.get(variable));
			} else {
				return domain.getMatchIterator();
			}
		} else {
			
			// no initial selection:
			if (GLOBAL_GREEDY) {
				// [HEURISTIC]: only elements that were not assigned yet:
				return new FilteredIterator(
						domain.getMatchIterator(), 
						globalAssigned.get(variable));
			} else {
				return domain.getMatchIterator();
			}
		}
	}
	
	private boolean assignVariable(Variable variable, EObject value, boolean firstVariableOfAtomic) {
		
		// store assignment:
		assignments.push(value);
		
		if (LOCAL_GREEDY) {
			localAssigned.get(variable).add(value);
		}
		
		//-------------------------------------------------
		// Restrict Working Graph
		//-------------------------------------------------
		
		if (initialVariable == null) {
			if (LOCAL_GREEDY) {
				clearLocalAssigned();
			}
			
			initialVariable = variable;
			matchSelector.initialSelection(variable.node, value);
		} else {
			// select value:
			// NOTE: No further selections needed for atomic dependent variables!
			if (firstVariableOfAtomic) {
				matchSelector.selection(variable.node, value);
			}
		}
		
		// ensure injectivity:
		for (Variable remainingVariable : remainingVariables) {
			Domain domain = Domain.get(remainingVariable.node.getEvaluation());
			domain.restriction(variable.node, value);
		}
		//-------------------------------------------------
		
		//-------------------------------------------------
		// Test for scope
		//-------------------------------------------------
		
		// NOTE: Needs only to be checked after the selection has changed!
		if (firstVariableOfAtomic) {
			if ((scope != null) && !scope.test()) {
				return false;
			}
		}
		
		//-------------------------------------------------
		
		// new match created!
		isNewMatch = true;
		return true;
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
		}
		
		// unset assignment:
		assignments.pop();

		//-------------------------------------------------
		// Restrict Working Graph
		//-------------------------------------------------
		
		// NOTE: undo the restriction in reverse order (injectivity, selection)!
		
		// ensure injectivity:
		for (Variable remainingVariable : remainingVariables) {
			Domain domain = Domain.get(remainingVariable.node.getEvaluation());
			domain.undoRestriction(variable.node);
		}
		
		// undo restriction on all nodes (full graph):
		matchSelector.undoSelection(variable.node);
		//-------------------------------------------------
		
		// reverted to old match!
		isNewMatch = false;
	}
	
	private void removeVariable(int count, boolean domainIsEmpty) {
		for (int i = 0; i < count; ++i) {
			Variable atomicVariable = subVariables.pop();
	        removedVariables.push(atomicVariable);
	        
	        if (!domainIsEmpty) {
	        	dependingVariables.push(atomicVariable);
	        }
		}
		dependencies.undoRemoveDependency();
	}
	
	private void addVariable(int count, boolean domainIsEmpty) {
		for (int i = 0; i < count; ++i) {
	          Variable atomicVariable = removedVariables.pop();
	          remainingVariables.add(atomicVariable);
	          
	          if (!domainIsEmpty) {
	        	  dependingVariables.pop();
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
		
		for (int i = 0; i < dependingVariables.size(); ++i) {
			NodePattern node = dependingVariables.get(i).node;
					
			if (dependencies.canRemove(node)) {
				Domain domain = Domain.get(node.getEvaluation());
				
				if (!domain.isEmptyMatch()) {
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
					return new VariableMatching(nodeToVariables, variableNodes, assignmentIterator.next());
				} else {
					throw new NoSuchElementException();
				}
			}
		};
	}
	
	/**
	 * @return All remaining variables to be picked.
	 */
	public Iterator<Variable> getRemainingVariables() {
		return remainingVariables.iterator();
	}
	
	/**
	 * @return All currently removed variables.
	 */
	public Iterator<Variable> getRemovedVariables() {
		return removedVariables.iterator();
	}
	
	/**
	 * @return Variables that are depending from a removed variable.
	 */
	public Iterator<Variable> getDependingVariables() {
		return dependingVariables.iterator();
	}
	
	/**
	 * @return All picked variables.
	 */
	public Iterator<Variable> getSubVariables() {
		return subVariables.iterator();
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
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		string.append("Assignments:\n");
		 
		for (int i = 0; i < subVariables.size(); i++) {
			string.append("  " + subVariables.get(i) + ":\n");
			string.append("    " + assignments.get(i) + "\n");
		}
		
		return string.toString();
	}
}
