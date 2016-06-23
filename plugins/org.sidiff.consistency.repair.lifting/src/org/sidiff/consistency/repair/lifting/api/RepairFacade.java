package org.sidiff.consistency.repair.lifting.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.henshin.model.Rule;

/**
 * API for the repair engine functions.
 * 
 * @author Manuel Ohrndorf
 */
public class RepairFacade {

	public static Map<Rule, List<Repair>> getRepairs(URI modelA, URI modelB, Collection<Rule> editRules) {
		Map<Rule, List<Repair>> repairs = new LinkedHashMap<>();
		
		for (Rule editRule : editRules) {
			List<Repair> repairsPerRule = new ArrayList<>();
			repairs.put(editRule, repairsPerRule);
			
			// TODO
		}
		
		return repairs;
	}
}
