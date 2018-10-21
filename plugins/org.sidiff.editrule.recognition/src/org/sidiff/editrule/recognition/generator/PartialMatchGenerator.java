package org.sidiff.editrule.recognition.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.common.monitor.LogTime;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.editrule.recognition.IMatching;
import org.sidiff.editrule.recognition.dependencies.DependencyEvaluation;
import org.sidiff.editrule.recognition.generator.util.Stack;
import org.sidiff.editrule.recognition.impact.PositiveImpactScopeConstraint;
import org.sidiff.editrule.recognition.pattern.domain.Domain;
import org.sidiff.editrule.recognition.selection.IMatchSelector;
import org.sidiff.editrule.recognition.util.debug.DebugUtil;
import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.NodePattern;

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

	// -------------------------------------------------

	private VariableSet remainingVariables;

	private Stack<Variable> removedVariables;

	private Stack<Variable> dependingVariables;

	private Stack<Variable> subVariables;

	private Stack<EObject> assignments;

	// -------------------------------------------------

	/**
	 * NOTE: Expand after remove variable might lead to no new matchings!
	 */
	private boolean isNewMatch = false;

	// -------------------------------------------------

	private Variable initialVariable;

	private IMatchSelector matchSelector;

	private DependencyEvaluation dependencies;

	// -------------------------------------------------

	private int falsePositives = 0;

	// -------------------------------------------------

	private boolean MINIMUM_SOLUTION = false;

	private int minimumSolutionSize = 1;

	private PositiveImpactScopeConstraint repairScope;
	
	private PositiveImpactScopeConstraint overwriteScope;

	// -------------------------------------------------
	// Main Algorithm:
	// -------------------------------------------------

	private void expandAssignment(int unassigned) {

		// is expandable?
		int next = (unassigned == 0) ? pickAndAppendVariable() : unassigned;

		if (next != 0) {
			boolean firstVariableOfAtomic = (unassigned == 0);

			Variable variable = subVariables.get(assignments.size());
			Iterator<EObject> domain = getDomain(variable);
			boolean domainIsEmpty = !domain.hasNext();

			// ensure atomic dependencies:
			if ((unassigned > 0) && domainIsEmpty)
				return;

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

				if (estimateSolutionSize() >= minimumSolutionSize) {
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
			IMatchSelector matchSelector,
			DependencyEvaluation dependencies,
			PositiveImpactScopeConstraint repairScope,
			PositiveImpactScopeConstraint overwriteScope) {

		// evaluation:
		this.variableNodes = variableNodes;
		this.matchSelector = matchSelector;
		
		// constraints:
		this.dependencies = dependencies;
		this.repairScope = repairScope;
		this.overwriteScope = overwriteScope;

		assignments = new Stack<EObject>(variableNodes.size());

		// dependencies:
		dependencies.start();

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
		}
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
			Domain domain = Domain.get(node.getMatching());
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

	private Iterator<EObject> getDomain(Variable variable) {
		Domain domain = Domain.get(variable.node.getMatching());

		if (matchSelector != null) {

			// domain based on restricted working graph:
			return domain.iterator();
		} else {

			// no initial selection:
			return domain.iterator();
		}
	}

	private boolean assignVariable(Variable variable, EObject value, boolean firstVariableOfAtomic) {

		// store assignment:
		assignments.push(value);

		// -------------------------------------------------
		// Restrict Working Graph
		// -------------------------------------------------

		if (initialVariable == null) {
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
			Domain domain = Domain.get(remainingVariable.node.getMatching());
			domain.restriction(variable.node, value);
		}
		// -------------------------------------------------

		// -------------------------------------------------
		// Test for scope
		// -------------------------------------------------

		// NOTE: Needs only to be checked after the selection has changed!
		if (firstVariableOfAtomic) {
			if ((repairScope != null) && !repairScope.test()) {
				return false;
			}
		}

		// -------------------------------------------------

		// new match created!
		isNewMatch = true;
		return true;
	}

	private void freeVariable(Variable variable) {

		// new initial sub-matching:
		if (variable == initialVariable) {
			initialVariable = null;
		}

		// unset assignment:
		assignments.pop();

		// -------------------------------------------------
		// Restrict Working Graph
		// -------------------------------------------------

		// NOTE: undo the restriction in reverse order (injectivity, selection)!

		// ensure injectivity:
		for (Variable remainingVariable : remainingVariables) {
			Domain domain = Domain.get(remainingVariable.node.getMatching());
			domain.undoRestriction(variable.node);
		}

		// undo restriction on all nodes (full graph):
		matchSelector.undoSelection(variable.node);
		// -------------------------------------------------

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
		if (MINIMUM_SOLUTION) {

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
		if (MINIMUM_SOLUTION) {
			for (int i = 0; i < cleared; ++i) {
				Variable clearedVariable = removedVariables.pop();
				remainingVariables.add(clearedVariable);
			}
		}
	}

	private int estimateSolutionSize() {
		if (MINIMUM_SOLUTION) {
			return subVariables.size() + remainingVariables.size();
		}
		return Integer.MAX_VALUE;
	}

	private boolean validateAssignment() {
		return (!MINIMUM_SOLUTION || (assignments.size() >= minimumSolutionSize)) 
				&& isNewMatch
				&& (isPartialAssignment() || isOverwritingRepair()) 
				&& isMaximumAssignment();
	}

	private boolean isPartialAssignment() {
		return (assignments.size() != variableNodes.size()) && (assignments.size() != 0);
	}
	
	private boolean isOverwritingRepair() {
		return overwriteScope.test();
	}

	private boolean isMaximumAssignment() {

		for (int i = 0; i < dependingVariables.size(); ++i) {
			NodePattern node = dependingVariables.get(i).node;

			if (dependencies.canRemove(node)) {
				Domain domain = Domain.get(node.getMatching());

				if (!domain.isEmpty()) {
					return false;
				}
			}
		}

		return true;
	}

	private void storeAssignment() {
		EObject[] assignments = new EObject[variableNodes.size()];
		results.add(assignments);

		for (int i = 0; i < this.assignments.size(); i++) {
			Variable variable = subVariables.get(i);
			EObject value = this.assignments.get(i);

			assert (variable.node.getType() == value.eClass());
			assignments[variable.index] = value;
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
					return new VariableMatching(nodeToVariables, variableNodes,
							assignmentIterator.next(), isPartialAssignment());
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

	/**
	 * @param minimumSolutionSize
	 *            The minimum size of the solutions to be found or 1.
	 */
	public void setMinimumSolutionSize(int minimumSolutionSize) {
		if (minimumSolutionSize > 1) {
			this.MINIMUM_SOLUTION = true;
			this.minimumSolutionSize = minimumSolutionSize;
		} else {
			this.MINIMUM_SOLUTION = false;
			this.minimumSolutionSize = 1;
		}
	}

	/**
	 * @return The minimum size of the solutions to be found.
	 */
	public int getMinimumSolutionSize() {
		return minimumSolutionSize;
	}

	@SuppressWarnings("unused")
	private String printAssignment() {
		StringBuffer print = new StringBuffer();

		for (int i = 0; i < subVariables.size(); ++i) {

			// Node:
			NodePattern node = subVariables.get(i).node;

			print.append("[" + i + "] Name: " + node.getName());
			print.append(", Type: " + node.getType().getName());

			// TODO: Generic... incident edges...
			if (node.getType() == SymmetricPackage.eINSTANCE.getAddObject()) {
				print.append(", Obj: "
						+ node.getOutgoing(SymmetricPackage.eINSTANCE.getAddObject_Obj()).getTarget().getName());
			}

			else if (node.getType() == SymmetricPackage.eINSTANCE.getRemoveObject()) {
				print.append(", Obj: "
						+ node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveObject_Obj()).getTarget().getName());
			}

			else if (node.getType() == SymmetricPackage.eINSTANCE.getAddReference()) {
				print.append(", Src: "
						+ node.getOutgoing(SymmetricPackage.eINSTANCE.getAddReference_Src()).getTarget().getName());
				print.append(", Tgt: "
						+ node.getOutgoing(SymmetricPackage.eINSTANCE.getAddReference_Tgt()).getTarget().getName());
			}

			else if (node.getType() == SymmetricPackage.eINSTANCE.getRemoveReference()) {
				print.append(", Src: "
						+ node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveReference_Src()).getTarget().getName());
				print.append(", Tgt: "
						+ node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveReference_Tgt()).getTarget().getName());
			}

			else if (node.getType() == SymmetricPackage.eINSTANCE.getAttributeValueChange()) {
				print.append(", ObjA: " + node.getOutgoing(SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjA())
						.getTarget().getName());
				print.append(", ObjB: " + node.getOutgoing(SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjB())
						.getTarget().getName());
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
						print.append(
								"  ObjA: " + value.eGet(SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjA()));
						print.append("\n");
						print.append(
								"  ObjB: " + value.eGet(SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjB()));
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
