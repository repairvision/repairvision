package org.sidiff.consistency.repair.complement.construction.subrule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.full.ComplementConstructorFullContext;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeCreateMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeDeleteMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMultiMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;

/**
 * Convert sub-rule match to partial super-rule match and constructs the
 * complement-rule = super-rule (-) partial-edit-rule-match.
 * 
 * @author Manuel Ohrndorf
 */
public class SubRuleComplementConstructor extends ComplementConstructorFullContext {

	public SubRuleComplementConstructor(Rule sourceRule, EngineImpl engine, EGraph graph) {
		super(sourceRule, engine, graph);
	}

	public Collection<ComplementRule> createComplementRule(Rule subRule, Collection<EditRuleMatch> subRuleMatch) {
		Collection<ComplementRule> complementRules = new ArrayList<>();
		
		// Calculate rule embedding:
		for (RuleEmbedding embedding : RuleEmbeddingCalculator.calculateRuleEmbedding(sourceRule, subRule)) {
			// Convert sub-rule match to partial super-rule match:
			List<EditRuleMatch> superRuleMatch = convertToPartialMatch(embedding, subRuleMatch);
			
			// Create the complement = super - sub:
			complementRules.add(createComplementRule(superRuleMatch));
		}
		
		return complementRules;
	}

	private List<EditRuleMatch> convertToPartialMatch(
			RuleEmbedding embedding, Collection<EditRuleMatch> subEditRuleMatching) {

		List<EditRuleMatch> superEditRuleMatch = new ArrayList<>();
		
		for (EditRuleMatch subEditRuleMatch : subEditRuleMatching) {
			
			// Node-Matches:
			if (subEditRuleMatch instanceof EditRuleNodeMatch) {
				Node subRuleNode = ((EditRuleNodeMatch) subEditRuleMatch).getNode();
				Node superRuleNode = embedding.getSuperRuleNode(subRuleNode);
				
				if (subEditRuleMatch instanceof EditRuleNodeSingleMatch) {
					EObject match = ((EditRuleNodeSingleMatch) subEditRuleMatch).getModelElement();
					
					EditRuleNodeMatch superEditRuleNodeMatch = new  EditRuleNodeSingleMatch(
							superRuleNode, subEditRuleMatch.getAction(), match);
					superEditRuleMatch.add(superEditRuleNodeMatch);
				}
				
				else  if (subEditRuleMatch instanceof EditRuleNodeMultiMatch) {
					Collection<EObject> matches = ((EditRuleNodeMultiMatch) subEditRuleMatch).getModelElements();

					EditRuleNodeMatch superEditRuleNodeMatch = new  EditRuleNodeMultiMatch(
							superRuleNode, subEditRuleMatch.getAction(), matches);
					superEditRuleMatch.add(superEditRuleNodeMatch);
				}
			}
			
			// Edge-Matches:
			else if (subEditRuleMatch instanceof EditRuleEdgeMatch) {
				Edge subRuleEdge = ((EditRuleEdgeMatch) subEditRuleMatch).getEdge();
				Edge superRuleEdge = embedding.getSuperRuleEdge(subRuleEdge);
				
				EObject srcMatch = ((EditRuleEdgeMatch) subEditRuleMatch).getSrcModelElement();
				EObject tgtMatch = ((EditRuleEdgeMatch) subEditRuleMatch).getTgtModelElement();
				
				EditRuleEdgeMatch superEditRuleNodeMatch = null;
				
				if (subEditRuleMatch instanceof EditRuleEdgeDeleteMatch) {
					superEditRuleNodeMatch = new  EditRuleEdgeDeleteMatch(superRuleEdge, srcMatch, tgtMatch);
				}
				
				else if (subEditRuleMatch instanceof EditRuleEdgeCreateMatch) {
					superEditRuleNodeMatch = new  EditRuleEdgeCreateMatch(superRuleEdge, srcMatch, tgtMatch);
				}
				
				assert (superEditRuleNodeMatch != null);
				superEditRuleMatch.add(superEditRuleNodeMatch);
			}
		}
		
		return superEditRuleMatch;
	}
}
