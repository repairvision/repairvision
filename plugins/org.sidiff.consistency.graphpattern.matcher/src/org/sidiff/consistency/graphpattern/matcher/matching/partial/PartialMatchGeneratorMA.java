package org.sidiff.consistency.graphpattern.matcher.matching.partial;

import static org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper.getDataStore;

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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.data.NavigableMatchesDS;
import org.sidiff.consistency.graphpattern.matcher.data.selection.MatchSelection;
import org.sidiff.consistency.graphpattern.matcher.matching.AbstractMatchGenerator;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatching;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.MatchSelector;
import org.sidiff.difference.symmetric.SymmetricPackage;

public abstract class PartialMatchGeneratorMA extends AbstractMatchGenerator<IMatching> {

	private Map<NodePattern, Variable> nodeToVariables = new HashMap<>();
	
	private Variable[] variables;
	
	private List<EObject[]> assignments;
	
	private EObject[] assignment;
	
	private int assignmentCount;
	
	private boolean isNewMatch = false;
	
	private Variable initialVariable;
	
	private MatchSelector matchSelector;
	
	private EObject placeholder = new EObjectImpl() {};
	
	//-------------------------------------------------
	
	private Map<Variable, Set<EObject>> assigned = new HashMap<>();
	
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
		System.out.println("Matchings Found: " + assignments.size());
	}
	
	private void expandAssignment(int variableIndex) {
		
		// is expandable?
		int expandableVariableIndex = nextExpandable(variableIndex);
		
		if (expandableVariableIndex != -1) {
			
			// get variable domain:
			Iterator<EObject> domain = getDomain(variableIndex, expandableVariableIndex);
			Variable variable = variables[variableIndex];
			
			assert (variableIndex == variable.index);
			
			// expand assignment:
			while (domain.hasNext()) {
				assignVariable(variable, domain.next());
				expandAssignment(variableIndex + 1);
				freeVariable(variable);
			}
			
			// sub-pattern:
			if (removeVariable(variable)) {
				expandAssignment(variableIndex + 1);
				addVariable(variable);
			}
		} else {
			
			// save actual assignment:
			if (isNewMatch && isMaximumAssignment() && isPartialAssignment()) {
				maximumLocalAssignment = Math.max(maximumLocalAssignment, assignmentCount);
				storeAssignment();
			}
		}
	}
	
	// TODO: replace directly with get Domain?
	private int nextExpandable(int variableIndex) {
		
		// check if there any more variables to assign:
		if (variableIndex < variables.length) {
			
			// check if there are any more assignable values:
			if (matchSelector != null) {
				for (int i = variableIndex; i < variables.length; ++i) {
					NavigableMatchesDS dataStore = getDataStore(variables[i].node.getEvaluation());
					MatchSelection matchSelection = dataStore.getMatchSelection();
					
					if (!matchSelection.isEmpty()) {
						// FIXME: injective
						return i;
						
						
//						// FIXME: replace directly with get Domain!
//						for (Iterator<EObject> iterator = matchSelection.getSelectedMatches(); iterator.hasNext();) {
//							EObject value = iterator.next();
//							
//							if (!assigned.get(variables[i]).contains(value)) {
//								return i;
//							}
//						}
					}
				}
			} else {
				return variableIndex;
			}
		}
		
		return -1;
	}
	
	private Iterator<EObject> getDomain(int variableIndex, int expandableVariableIndex) {
		
		if (matchSelector != null) {
			
			// Switch variables:
			if (variableIndex != expandableVariableIndex) {
				variables[variableIndex].index = expandableVariableIndex;
				variables[expandableVariableIndex].index = variableIndex;
				
				Variable expandableVariable = variables[expandableVariableIndex];
				variables[expandableVariableIndex] = variables[variableIndex];
				variables[variableIndex] = expandableVariable;
			}
			
			// domain based on restricted working graph:
			Variable variable = variables[variableIndex];
			NavigableMatchesDS dataStore = getDataStore(variable.node.getEvaluation());
			MatchSelection matchSelection = dataStore.getMatchSelection();
			
			// TODO: filter iterator - no list copy
			List<EObject> match = matchSelection.getMatch();
			
			// FIXME: nur initial filtern!
			// [HEURISTIC]: only elements that were not assigned yet:
//			match.removeAll(assigned.get(variable));
			
			// Ensure injectivity:
			// TODO: Set of assigned values
			for (int i = 0; i < variableIndex; i++) {
				EObject value = assignment[i];
				
				if (value != placeholder) {
					match.remove(value);
				}
			}

			return match.iterator();
			
			// all possible matchings:
			// return matchSelection.getSelectedMatches();
		} else {
			
			// no initial selection:
			
			// FIXME: by iterator
			// [HEURISTIC]: only elements that were not assigned yet:
			Variable variable = variables[variableIndex];
			List<EObject> match = variables[variableIndex].node.getEvaluation().getMatches();
			match.removeAll(assigned.get(variable));
			return match.iterator();
			
//			NavigableMatchesDS dataStore = getDataStore(variables[variableIndex].node.getEvaluation());
//			return dataStore.getMatchIterator();
		}
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
		
		// restrict working graph:
		matchSelector.selectMatch(variable.node, value);
		
		// count assignments:
		++assignmentCount;
		
		// store assigned values:
		// FIXME: erst speichern, wenn neuer match gefunden wurde!?
		assigned.get(variable).add(value);
		
		// new match created!
		isNewMatch = true;
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
		
		// reverted to old match!
		isNewMatch = false;
	}
	
	private boolean removeVariable(Variable variable) {
		
		if (maxPossibleAssignment(variable.index) >= maximumLocalAssignment) {
			assignment[variable.index] = placeholder;
			return true;
		} else {
			return false;
		}
	}
	
	private int maxPossibleAssignment(int variableIndex) {
		int maxPossibleAssignments = 0;

		for (int i = 0; i < assignment.length; ++i) {
			EObject value = assignment[i]; 
			
			// TODO: variableIndex erst auf placeholder setzen!
			if (i != variableIndex) {
				if (value == null) {
					NavigableMatchesDS nodeDS = getDataStore(variables[i].node.getEvaluation());
					
					if (matchSelector != null) {
						if (!nodeDS.getMatchSelection().isEmpty()) {
							++maxPossibleAssignments;
						}
					} else {
						if (!nodeDS.isEmptyMatch()) {
							++maxPossibleAssignments;
						}
					}
				} else {
					if (value != placeholder) {
						++maxPossibleAssignments;
					}
				}
			}
		}
		
		return maxPossibleAssignments;
	}

	private void addVariable(Variable variable) {
		assignment[variable.index] = null;
	}

	private boolean isMaximumAssignment() {
		
		for (int i = 0; i < assignment.length; ++i) {
			EObject value = assignment[i]; 
					
			// FIXME: müssen null-Werte geprüft werden!?
			if ((value == placeholder) || (value == null)) {
				NavigableMatchesDS nodeDS = getDataStore(variables[i].node.getEvaluation());
				
				if (!nodeDS.getMatchSelection().isEmpty()) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean isPartialAssignment() {
		return (assignmentCount != variables.length) && (assignmentCount != 0);
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
			}
		}
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
