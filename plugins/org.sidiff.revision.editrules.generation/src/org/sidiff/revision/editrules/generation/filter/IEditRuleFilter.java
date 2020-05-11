package org.sidiff.revision.editrules.generation.filter;

import java.util.List;

import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.Pattern;

/**
 * General interface for filtering of edit rules during edit rule generation.
 * 
 * @author Manuel Ohrndorf
 */
public interface IEditRuleFilter {

	/**
	 * @param editOperation The edit operation (Pattern) which contains the name and
	 *                      parameters signature.
	 * @param editRule      The edit rule (GraphPattern) which contains the graph
	 *                      edit actions.
	 * @return <code>true</code> if the rule should be filtered; <code>false</code>
	 *         otherwise.
	 */
	boolean filter(Pattern editOperation, GraphPattern editRule, Iterable<GraphPattern> rulebase);
	
	/**
	 * @param editRuleFilter All filters to be checked.
	 * @param editOperation  The edit operation (Pattern) which contains the name
	 *                       and parameters signature.
	 * @param editRule       The edit rule (GraphPattern) which contains the graph
	 *                       edit actions.
	 * @return <code>true</code> if the rule should be filtered; <code>false</code>
	 *         otherwise.
	 */
	static boolean filter(List<IEditRuleFilter> editRuleFilter, Pattern editOperation, GraphPattern editRule, Iterable<GraphPattern> rulebase) {
		for (IEditRuleFilter filter : editRuleFilter) {
			if (filter.filter(editOperation, editRule, rulebase)) {
				return true;
			}
		}
		return false;
	}
}
