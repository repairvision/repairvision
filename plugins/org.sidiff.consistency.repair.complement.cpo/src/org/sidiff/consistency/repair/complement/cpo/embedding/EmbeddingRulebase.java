package org.sidiff.consistency.repair.complement.cpo.embedding;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.henshin.model.Rule;

public class EmbeddingRulebase {
	
	private Map<Rule, Map<Rule, List<RuleEmbedding>>> subRulesToEmbeddings = new HashMap<>();

	public EmbeddingRulebase(Collection<Rule> cpoRules, Collection<Rule> subRules) {
		
		for (Rule subRule : subRules) {
			Map<Rule, List<RuleEmbedding>> cpoRulesToEmbeddings = new HashMap<>();
			subRulesToEmbeddings.put(subRule, cpoRulesToEmbeddings);
			
			for (Rule cpoRule : cpoRules) {
				List<RuleEmbedding> embeddings = RuleEmbeddingCalculator.calculateRuleEmbedding(cpoRule, subRule);
				
				if ((embeddings != null) && !embeddings.isEmpty()) {
					cpoRulesToEmbeddings.put(cpoRule, embeddings);
				}
			}
		}
	}
	
	public Set<Rule> getSuperRules(Rule subRule) {
		return Collections.unmodifiableSet(subRulesToEmbeddings.get(subRule).keySet());
	}
	
	public List<RuleEmbedding> getEmbeddings(Rule superRule, Rule subRule) {
		return Collections.unmodifiableList(subRulesToEmbeddings.get(subRule).get(superRule));
	}
	
	public String print() {
		StringBuffer print = new StringBuffer();
		
		for (Rule subRule : subRulesToEmbeddings.keySet()) {
			print.append("Sub-Rule: " + subRule.getName() + "\n");
			
			for (Rule cpoRule : subRulesToEmbeddings.get(subRule).keySet()) {
				print.append("  CPO: " + cpoRule.getName() + "\n");
			}
		}
		
		return print.toString();
	}
	
	@Override
	public String toString() {
		return print();
	}
}
