package org.sidiff.revision.editrules.generation.constructors;

import java.util.List;

import org.sidiff.graphpattern.Pattern;
import org.sidiff.revision.editrules.generation.constructors.util.EditRuleCollector;
import org.sidiff.revision.editrules.generation.filter.IEditRuleFilter;

/**
 * Constructs the mappings from a pre-state graphs that should be transformed into
 * a post-state graphs.
 * 
 * @author Manuel Ohrndorf
 */
public interface IEditRuleConstructor {

	/**
	 * @param pattern   The graph pattern library.
	 * @param filter    Edit rule filters to be applied.
	 * @param editRules Collects all generated edit rules.
	 */
	void construct(Pattern patterns, List<IEditRuleFilter> filter, EditRuleCollector editRules);
}
