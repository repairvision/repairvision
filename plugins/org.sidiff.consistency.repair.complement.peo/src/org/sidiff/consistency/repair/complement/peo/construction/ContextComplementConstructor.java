package org.sidiff.consistency.repair.complement.peo.construction;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.repair.complement.construction.ComplementConstructor;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;

/**
 * Constructs the complement-rule = source-rule (-) partial-edit-rule-match.
 * Requires that the context of the complement-rule can be completely matched.
 * 
 * @author Manuel Ohrndorf
 */
public class ContextComplementConstructor extends ComplementConstructor {

	/**
	 * The (Henshin) engine which applies the rules.
	 */
	private EngineImpl engine;
	
	/**
	 * The working graph, i.e. the actual version of the model.
	 */
	private EGraph graph;
	
	/**
	 * @param sourceRule
	 *            The partially executed edit-rule.
	 * @param engine
	 *            The (Henshin) engine which applies the rules.
	 * @param graph
	 *            The working graph, i.e. the actual version of the model.
	 */
	public ContextComplementConstructor(Rule sourceRule, EngineImpl engine, EGraph graph) {
		super(sourceRule);
		this.engine = engine;
		this.graph = graph;
	}

	@Override
	protected ComplementRule createComplementRule(Rule sourceRule, Rule complementRule) {
		return new ContextComplementRule(sourceRule, complementRule, engine, graph);
	}
}
