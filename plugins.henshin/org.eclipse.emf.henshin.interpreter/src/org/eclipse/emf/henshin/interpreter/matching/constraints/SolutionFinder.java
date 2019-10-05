/**
 * <copyright>
 * Copyright (c) 2010-2014 Henshin developers. All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Eclipse Public License v1.0 which 
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */
package org.eclipse.emf.henshin.interpreter.matching.constraints;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.info.RuleInfo;
import org.eclipse.emf.henshin.interpreter.matching.conditions.ApplicationCondition;
import org.eclipse.emf.henshin.interpreter.matching.conditions.ConditionHandler;
import org.eclipse.emf.henshin.model.Node;

/**
 * Solution finder. This is the internal realization of the match finder.
 * 
 * @author Enrico Biermann, Christian Krause
 */
public class SolutionFinder extends ApplicationCondition {
	
	// Attribute condition handler:
	protected final ConditionHandler conditionHandler;

	// Started flag:
	protected boolean started;
	
	// Next solution:
	protected Solution nextSolution;
	
	// Rule to variable mapping:
	public RuleInfo ruleInfo;
		
	/**
	 * Default constructor.
	 * @param graph Target graph.
	 * @param variableDomainMap Variable domain map.
	 * @param conditionHandler Attribute condition handler.
	 */
	public SolutionFinder(EGraph graph, 
			Map<Variable, DomainSlot> variableDomainMap,
			ConditionHandler conditionHandler) {
		super(graph, variableDomainMap);
		this.conditionHandler = conditionHandler;
		this.started = false;
	}
	
	/**
	 * @param ruleInfo Rule mapping informations for debugging.
	 */
	public void setRuleInfo(RuleInfo ruleInfo) {
		this.ruleInfo = ruleInfo;
	}
	
	/**
	 * Find a new solution.
	 * @return <code>true</code> if a new solution was found.
	 */
	public boolean findSolution() {
		
		boolean matchIsPossible = false;
		if (!started) {
			started = true;
			matchIsPossible = true;
		} else {
			int varCount = variables.size();
			for (int i=varCount-1; i>=0; i--) {
				Variable var = variables.get(i);
				if (domainMap.get(var).unlock(var)) {
					matchIsPossible = true;
					break;
				} else {
					domainMap.get(var).clear(var);
				}
			}
		}
		
		if (matchIsPossible) {
			boolean success = findGraph();
			if (success) {
				nextSolution = new Solution(variables, domainMap, conditionHandler);
			}
			return success;
		}
		
		// No solution found.
		return false;
		
	}
	
	/**
	 * Returns the next solution. On consecutive calls other matches will be returned.
	 * @return A solution or <code>null</code> if no match exists.
	 */
	public Solution getNextSolution() {
		if (findSolution()) {
			return nextSolution;
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();

		if (ruleInfo != null) {

			string.append("Assigned Variables:");
			string.append("\n");
			string.append("\n");

			for (int i = 0; i < variables.size(); i++) {
				Variable variable = variables.get(i);
				Node node = ruleInfo.getVariableInfo().getVariableForNode(variable);
				DomainSlot domain = domainMap.get(variable);
				EObject value = domain.getValue();

				if (value != null) {
					string.append("[");
					string.append(i);
					string.append("] ");
					string.append("<<");
					string.append(node.getAction().getType());
					string.append(">> ");
					string.append(node.getName());
					string.append(" : ");
					string.append(node.getType().getName());
					string.append("\n");

					string.append("  ");
					string.append(value);
					string.append("\n");
				}
			}

			string.append("\n");
			string.append("Free Variables:");
			string.append("\n");
			string.append("\n");

			for (int i = 0; i < variables.size(); i++) {
				Variable variable = variables.get(i);
				Node node = ruleInfo.getVariableInfo().getVariableForNode(variable);
				DomainSlot domain = domainMap.get(variable);
				EObject value = domain.getValue();

				if (value == null) {
					string.append("[");
					string.append(i);
					string.append("] ");
					string.append("<<");
					string.append(node.getAction().getType());
					string.append(">> ");
					string.append(node.getName());
					string.append(" : ");
					string.append(node.getType().getName());
					string.append(" (");
					string.append("dangling: ");
					string.append(domain.dangling);
					string.append(" injective: ");
					string.append(domain.injective);
					string.append(")");

					if (domain.getTemporaryDomain() != null) {
						string.append(" (Temporary Domain)");
						string.append("\n");

						for (EObject tmpDomainValue : domain.getTemporaryDomain()) {
							string.append("  ");
							string.append(tmpDomainValue);
							string.append("\n");
						}
					} else if (domain.getDomain() != null) {
						string.append(" (Domain)");
						string.append("\n");

						for (EObject domainValue : domain.getDomain()) {
							string.append("  ");
							string.append(domainValue);
						}
					} else {
						string.append(" (Working Graph Domain)");
						string.append("\n");
						
						List<EObject> workingGraphDomain = graph.getDomain(variable.typeConstraint.type, false);

						if (workingGraphDomain != null) {
							for (EObject domainValue : workingGraphDomain) {
								string.append("  ");
								
								if (domain.injective && domain.usedObjects.contains(domainValue)) {
									string.append("  <<used>> ");
								}
								
								string.append(domainValue);
								string.append("\n");
							}
						}
					}
				}
			}
		}
		
		return string.toString();
	}
}
