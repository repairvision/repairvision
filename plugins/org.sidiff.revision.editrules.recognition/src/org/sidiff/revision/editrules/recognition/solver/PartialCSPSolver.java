package org.sidiff.revision.editrules.recognition.solver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.sidiff.graphpattern.DependencyNode;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.common.utilities.java.JUtil;
import org.sidiff.revision.difference.DifferencePackage;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionLogger;
import org.sidiff.revision.editrules.recognition.dependencies.DependencyEvaluation;
import org.sidiff.revision.editrules.recognition.impact.ImpactScopeConstraint;
import org.sidiff.revision.editrules.recognition.match.RecognitionMatching;
import org.sidiff.revision.editrules.recognition.match.util.RecognitionMatchCreator;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain.SelectionType;
import org.sidiff.revision.editrules.recognition.selection.IMatchSelector;
import org.sidiff.revision.editrules.recognition.solver.util.Stack;

/**
 * Concrete implementation of {@link IMatchGenerator}. Iterates through all
 * possible (maximal) partial matches for a given graph.
 * 
 * @author Manuel Ohrndorf
 */
public class PartialCSPSolver {

	/**
	 * The nodes which correspond to the matching formula:
	 * <code>match = v_1 x v_2 x ... x v_n</code>
	 */
	protected List<NodePattern> variableNodes;

	private Map<NodePattern, Variable> nodeToVariables = new HashMap<>();

	// -------------------------------------------------
	
	private RecognitionMatchCreator matchCreator;

	private List<RecognitionMatching> matchings;
	
	private IMatching matchingAdapter = new IMatching() {
		
		@Override
		public boolean isPartialMatching() {
			return isPartialAssignment();
		}
		
		@Override
		public Collection<NodePattern> getNodes() {
			return nodeToVariables.keySet();
		}
		
		@Override
		public Iterator<EObject> getMatch(NodePattern node) {
			return JUtil.singeltonIterator(getFirstMatch(node));
		}
		
		@Override
		public EObject getFirstMatch(NodePattern node) {
			
			// TODO: Indexed solution:
			Variable variable = nodeToVariables.get(node);
			
			for (int i = 0; i < assignments.size(); i++) {
				Variable assignedVariable = subVariables.get(i);
				
				if (assignedVariable == variable) {
					EObject value = assignments.get(i);
					return value;
				}
			}
			
			return null;
		}
	};
	
	// -------------------------------------------------

	private VariableSet remainingVariables;

	private Stack<Variable> removedVariables;

	private Stack<Variable> dependingVariables;

	private Stack<Variable> subVariables;

	private Stack<EObject> assignments;
	
	private Set<EObject> assigned;
	
	private final static EObject NULL = EcoreFactory.eINSTANCE.createEObject();

	// -------------------------------------------------

	/**
	 * NOTE: Expand after remove variable might lead to no new matchings!
	 */
	private boolean isNewMatch = false;

	// -------------------------------------------------

	private Variable initialVariable;

	private IMatchSelector matchSelector;

	private DependencyEvaluation dependencies;
	
	private Comparator<NodePattern> domainSizeComperator = new Comparator<NodePattern>() {

		@Override
		public int compare(NodePattern n1, NodePattern n2) {
			// TODO: Use current domain size based on current restrictions.
			return Domain.get(n1).size() - Domain.get(n2).size();
		}
		
	};

	// -------------------------------------------------

	private int falsePositives = 0;

	// -------------------------------------------------

	private boolean MINIMUM_SOLUTION = false;

	private int minimumSolutionSize = 1;

	private ImpactScopeConstraint currentScope;
	
	private ImpactScopeConstraint attributeScope;
	
	private ImpactScopeConstraint historicalScope;
	
	// -------------------------------------------------
	
	private RecognitionLogger logger;

	// -------------------------------------------------
	// Main Algorithm:
	// -------------------------------------------------

	// NOTE (Print Matching): org.sidiff.editrule.recognition.util.debug.StringUtil.printSelections(((org.sidiff.graphpattern.GraphPattern) variableNodes.get(0).eContainer()).getNodes())
	// NOTE (Debug Matching): org.sidiff.editrule.recognition.util.debug.DebugUtil.getDomains(((org.sidiff.graphpattern.GraphPattern) variableNodes.get(0).eContainer()).getNodes())
	// NOTE (Debug Recognition Pattern): org.sidiff.editrule.recognition.util.debug.DebugUtil.getDomains((Object) this, "matchSelector", "recognitionPattern")
	
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
//					debug_checkAssignmentAndDomainConsistency();
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
	
	@SuppressWarnings("unused")
	private boolean debug_checkAssignmentAndDomainConsistency() {
		
		if (assignments.size() > subVariables.size()) {
			System.err.println(assignments.size() + " Assignments" + " > " + subVariables.size() + " Variables");
		}
		
		if (assigned.size() != assignments.size()) {
			System.err.println(assignments.size() + " Assignments"  + " != " + assigned.size() + " Assigned");
		}
		
		for (int i = 0; i < assignments.size(); i++) {
			if (!assigned.contains(assignments.get(i))) {
				System.err.println("Missing assigned: " + assignments.get(i));
			}
		}
		
		for (EObject assignedElement : assigned) {
			boolean found = false;
			
			for (int i = 0; i < assignments.size(); i++) {
				if (assignments.get(i) == assignedElement) {
					found = true;
				}
			}
			
			if (!found) {
				System.err.println("Unassigned: " + assignedElement);
			}
		}
		
		for (int i = 0; i < subVariables.size(); i++) {
			EObject assignment = (i < assignments.size()) ? assignments.get(i) : null;
			
			if (assignment != null) {
				if (!SelectionType.isSelected(Domain.get(subVariables.get(i).node.getMatching()).get(assignment))) {
					System.err.println("Variable: " + subVariables.get(i));
					System.err.println("Assignment: " + assignment);
					System.err.println(Domain.get(subVariables.get(i).node.getMatching()));
					
					return false;
				}
			}
		}
		return true;
	}

	public void initialize(
			List<NodePattern> variableNodes,
			IMatchSelector matchSelector,
			RecognitionMatchCreator matchCreator,
			DependencyEvaluation dependencies,
			ImpactScopeConstraint historicalScope,
			ImpactScopeConstraint currentScope,
			ImpactScopeConstraint attributeScope,
			RecognitionLogger logger) {

		// evaluation:
		this.variableNodes = variableNodes;
		this.matchSelector = matchSelector;
		this.matchCreator = matchCreator;
		
		// constraints:
		this.dependencies = dependencies;
		this.historicalScope = historicalScope;
		this.currentScope = currentScope;
		this.attributeScope = attributeScope;
		
		this.logger = logger;

		assignments = new Stack<EObject>(variableNodes.size());
		assigned = new HashSet<>();
		
		matchings = new ArrayList<>();

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
		assignments.reset();

		expandAssignment(0);

		if (logger.isDebugging()) {
			logger.logFalsePositives(falsePositives);
			logger.logFoundMatchings(matchings.size());
		}
	}

	private int pickAndAppendVariable() {

		// check if there any more variables to assign:
		if (remainingVariables.size() > 0) {
			Variable pickedVariable = pickAnyVariable();

			if (pickedVariable != null) {
				EList<NodePattern> atomicNodes = (EList<NodePattern>) dependencies.getAtomic(pickedVariable.node);
				
				// NOTE: Optimization: Start with the smallest domain size for atomic sub patterns.
				ECollections.sort(atomicNodes, domainSizeComperator);

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
		return domain.iterator();
	}
	
	private boolean assignVariable(Variable variable, EObject value, boolean firstVariableOfAtomic) {
		
		// ensure injectivity:
		if (assigned.add(value)) {
			
			// store assignment:
			assignments.push(value);
		} else {
			
			// just for correct backtracking...
			assigned.add(NULL);
			assignments.push(NULL);
			
			return false;
		}

		// -------------------------------------------------
		// Restrict Working Graph
		// -------------------------------------------------

		if (initialVariable == null) {
			initialVariable = variable;
			matchSelector.initialSelection(variable.node, value);
		} else {
			// select value:
			
			// FIXME: Select atomic patterns in one step: e.g. AddObject, (containment) AddReference
//			// NOTE: No further selections needed for atomic dependent variables!
//			if (firstVariableOfAtomic) { 
				matchSelector.selection(variable.node, value);
//			}
		}

		// FIXME: Preventive restrictions might lead to broken paths in the search space.
		// ensure injectivity:
//		for (Variable remainingVariable : remainingVariables) {
//			Domain domain = Domain.get(remainingVariable.node.getMatching());
//			domain.restriction(variable.node, value);
//		}
		
		// -------------------------------------------------

		// -------------------------------------------------
		// Test for scope
		// -------------------------------------------------

		// FIXME: Select atomic patterns in one step: e.g. AddObject, (containment) AddReference
		//        (Since the scope test is just an optimization, it would be correct anyway.)
		// NOTE: Needs only to be checked after the selection has changed!
//		if (firstVariableOfAtomic) {
			if ((currentScope != null) && !currentScope.test()) {
				return false;
			}
			
			if ((historicalScope != null) && !historicalScope.test()) {
				return false;
			}
//		}

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
		EObject freed = assignments.pop();
		assigned.remove(freed);

		// -------------------------------------------------
		// Restrict Working Graph
		// -------------------------------------------------

		// NOTE: undo the restriction in reverse order (injectivity, selection)!

		// FIXME: Preventive restrictions might lead to broken paths in the search space.
//		// ensure injectivity:
//		for (Variable remainingVariable : remainingVariables) {
//			Domain domain = Domain.get(remainingVariable.node.getMatching());
//			domain.undoRestriction(variable.node);
//		}

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
		return attributeScope.test();
	}

	private boolean isMaximumAssignment() {

		for (int i = 0; i < dependingVariables.size(); ++i) {
			NodePattern node = dependingVariables.get(i).node;

			if (dependencies.canRemove(node)) {
				Domain domain = Domain.get(node.getMatching());

				// NOTE: Already assigned values can be ignored for injective matching. 
				if (!domain.isEmpty(assigned)) {
					return false;
				}
			}
		}

		return true;
	}

	private void storeAssignment() {
		matchings.add(matchCreator.createEditRuleMatch(matchingAdapter));
	}

	public List<RecognitionMatching> getResults() {
		return matchings;
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
			if (node.getType() == DifferencePackage.eINSTANCE.getAddObject()) {
				print.append(", Obj: "
						+ node.getOutgoing(DifferencePackage.eINSTANCE.getAddObject_Obj()).getTarget().getName());
			}

			else if (node.getType() == DifferencePackage.eINSTANCE.getRemoveObject()) {
				print.append(", Obj: "
						+ node.getOutgoing(DifferencePackage.eINSTANCE.getRemoveObject_Obj()).getTarget().getName());
			}

			else if (node.getType() == DifferencePackage.eINSTANCE.getAddReference()) {
				print.append(", Src: "
						+ node.getOutgoing(DifferencePackage.eINSTANCE.getAddReference_Src()).getTarget().getName());
				print.append(", Tgt: "
						+ node.getOutgoing(DifferencePackage.eINSTANCE.getAddReference_Tgt()).getTarget().getName());
			}

			else if (node.getType() == DifferencePackage.eINSTANCE.getRemoveReference()) {
				print.append(", Src: "
						+ node.getOutgoing(DifferencePackage.eINSTANCE.getRemoveReference_Src()).getTarget().getName());
				print.append(", Tgt: "
						+ node.getOutgoing(DifferencePackage.eINSTANCE.getRemoveReference_Tgt()).getTarget().getName());
			}

			else if (node.getType() == DifferencePackage.eINSTANCE.getAttributeValueChange()) {
				print.append(", ObjA: " + node.getOutgoing(DifferencePackage.eINSTANCE.getAttributeValueChange_ObjA())
						.getTarget().getName());
				print.append(", ObjB: " + node.getOutgoing(DifferencePackage.eINSTANCE.getAttributeValueChange_ObjB())
						.getTarget().getName());
			}

			print.append("\n");

			// Value:
			if (i < assignments.size()) {
				EObject value = assignments.get(i);

				print.append("  Value: " + value);
				print.append("\n");

				if (value != null) {
					if (node.getType() == DifferencePackage.eINSTANCE.getAddObject()) {
						print.append("  Obj: " + value.eGet(DifferencePackage.eINSTANCE.getAddObject_Obj()));
						print.append("\n");
					}

					else if (node.getType() == DifferencePackage.eINSTANCE.getRemoveObject()) {
						print.append("  Obj: " + value.eGet(DifferencePackage.eINSTANCE.getRemoveObject_Obj()));
						print.append("\n");
					}

					else if (node.getType() == DifferencePackage.eINSTANCE.getAddReference()) {
						print.append("  Src: " + value.eGet(DifferencePackage.eINSTANCE.getAddReference_Src()));
						print.append("\n");
						print.append("  Tgt: " + value.eGet(DifferencePackage.eINSTANCE.getAddReference_Tgt()));
						print.append("\n");
					}

					else if (node.getType() == DifferencePackage.eINSTANCE.getRemoveReference()) {
						print.append("  Src: " + value.eGet(DifferencePackage.eINSTANCE.getRemoveReference_Src()));
						print.append("\n");
						print.append("  Tgt: " + value.eGet(DifferencePackage.eINSTANCE.getRemoveReference_Tgt()));
						print.append("\n");
					}

					else if (node.getType() == DifferencePackage.eINSTANCE.getAttributeValueChange()) {
						print.append(
								"  ObjA: " + value.eGet(DifferencePackage.eINSTANCE.getAttributeValueChange_ObjA()));
						print.append("\n");
						print.append(
								"  ObjB: " + value.eGet(DifferencePackage.eINSTANCE.getAttributeValueChange_ObjB()));
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
			EObject assignment = (i < assignments.size()) ? assignments.get(i) : null;
			
			string.append("  " + subVariables.get(i) + ":\n");
			string.append("    " + assignment + "\n");
		}
		
		string.append("\nRemoved Variables:\n");
		
		for (int i = 0; i < removedVariables.size(); i++) {
			string.append("  " + removedVariables.get(i) + ":\n");
		}

		return string.toString();
	}
}
