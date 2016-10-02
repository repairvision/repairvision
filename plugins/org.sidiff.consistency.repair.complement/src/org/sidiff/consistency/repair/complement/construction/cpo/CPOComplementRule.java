package org.sidiff.consistency.repair.complement.construction.cpo;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;

public class CPOComplementRule extends ComplementRule  {

	public CPOComplementRule(Rule sourceRule, Rule complementRule, EngineImpl engine, EGraph graph) {
		super(sourceRule, complementRule);
		initialize(engine, graph);
	}

	@Override
	protected List<ComplementMatch> createComplementMatches(List<EditRuleMatch> partialSourceMatch) {
		
		// Create complement pre-match by partial source-rule match:
		Match complementPreMatche = new MatchImpl(complementRule);
		
		for (EditRuleMatch sourceMatch : partialSourceMatch) {
			
			// NOTE: The matching unambiguously in CPO approach (regarding EditRuleNodeMultiMatch):
			if (sourceMatch instanceof EditRuleNodeSingleMatch) {
				if (!sourceMatch.getAction().equals(Type.DELETE)) {
					EditRuleNodeSingleMatch nodeMatch = (EditRuleNodeSingleMatch) sourceMatch;
					Node complementNode = getLHS(getTrace(nodeMatch.getNode()));
					
					if (complementNode != null) {
						complementPreMatche.setNodeTarget(complementNode, nodeMatch.getModelElement());
					}
				}
			}
		}
		
		// Check context rule (with restricted working graph):
		ArrayList<ComplementMatch> complementMatches = new ArrayList<>();
		Iterator<Match> matchFinder = getEngine().findMatches(complementRule, getGraph(), complementPreMatche).iterator();
		
		while (matchFinder.hasNext()) {
			Match nextMatch = matchFinder.next();
			
			// Create complement pre-match:
			ComplementMatch nextComplementMatch = new ComplementMatch(new HashMap<>());
			complementMatches.add(nextComplementMatch);
			
			for (Node complementNode : complementRule.getLhs().getNodes()) {
				nextComplementMatch.getNodeMatches().put(complementNode, nextMatch.getNodeTarget(complementNode));
			}
		}
		
		complementMatches.trimToSize();
		return complementMatches;
	}
}
