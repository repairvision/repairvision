package org.sidiff.revision.editrules.generation.constructors.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.Pattern;

public class EditRuleCollector {

	private Map<GraphPattern, List<Pattern>> editRules;
	
	public EditRuleCollector() {
		this.editRules = new HashMap<>();
	}
	
	public void add(GraphPattern graphPattern, List<Pattern> editRules) {
		this.editRules.merge(graphPattern, editRules, (v1, v2) -> {v1.addAll(v2); return v1;});
	}
	
	public void add(GraphPattern graphPattern, Pattern editRule) {
		List<Pattern> editRulesOfGraphPattern = editRules.get(graphPattern);
		
		if (editRulesOfGraphPattern == null) {
			editRulesOfGraphPattern = new ArrayList<>();
			editRules.put(graphPattern, editRulesOfGraphPattern);
		}
		
		editRulesOfGraphPattern.add(editRule);
	}
	
	public Map<GraphPattern, List<Pattern>> getEditRules() {
		return editRules;
	}
	
	public Iterable<GraphPattern> getRulebase() {
		return () -> editRules.values().stream()
				.flatMap(List<Pattern>::stream)
				.map(Pattern::getGraphs)
				.flatMap(List<GraphPattern>::stream)
				.iterator();
	}
}
