package org.sidiff.common.henshin;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.sidiff.common.henshin.exceptions.NoMainUnitFoundException;

public class HenshinUnitAnalysis {

	/**
	 * Returns all rules which are contained/nested in the given unit.
	 * 
	 * @param unit
	 *            the unit containing the rules.
	 * @return all rules of the unit.
	 */
	public static List<Rule> getRules(Unit unit) {
		List<Rule> rules = new ArrayList<Rule>();

		for (Unit subUnit : unit.getSubUnits(true)) {
			if (subUnit instanceof Rule) {
				rules.add((Rule) subUnit);
			}
		}

		return rules;
	}
	
	/**
	 * Searches the main unit of the edit rule.
	 * 
	 * @param editModule
	 *            The edit rule to search.
	 * @return The main unit of the edit rule.
	 * 
	 * @throws NoMainUnitFoundException
	 * @throws NoUnitFoundException
	 */
	public static Unit findExecuteMainUnit(Module editModule) throws NoMainUnitFoundException {
		
		// Needed at least one transformation unit to perform generation
		if (editModule.getUnits().isEmpty()) {
			throw new NoMainUnitFoundException(editModule);
		}
		
		// Search for unit with name mainUnit
		Unit executeMainUnit = editModule.getUnit(INamingConventions.MAIN_UNIT);
		
		if (executeMainUnit == null) {
			throw new NoMainUnitFoundException(editModule);
		}
		
		return executeMainUnit;
	}
}
