package org.sidiff.common.henshin;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRules;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;

public class HenshinModuleAnalysis {

	/**
	 * Get all rules of the module (including all rules of sub modules and including nested multi rules).
	 * 
	 * @param module
	 *            the module.
	 * @return all Rules contained by the module in an unmodifiable list.
	 */
	public static EList<Rule> getAllRules(Module module) {
		EList<Rule> rules = new BasicEList<Rule>();
		
		for (Unit unit : module.getUnits()) {
			if (unit instanceof Rule) {
				Rule rule = (Rule) unit;
				rules.add(rule);
				rules.addAll(rule.getAllMultiRules());
			}
		}
		
		for (Module subModule : module.getSubModules()) {
			rules.addAll(getAllRules(subModule));
		}
		
		return ECollections.unmodifiableEList(rules);
	}
	
	/**
	 * Get all kernel rules of the module, including submodules
	 * 
	 * @param module
	 *            the module.
	 * @return all Kernel Rules contained by the module in an unmodifiable list.
	 */
	public static EList<Rule> getAllKernelRules(Module module) {
		EList<Rule> rules = new BasicEList<Rule>();
		
		for (Unit unit : module.getUnits()) {
			if (unit instanceof Rule) {
				Rule rule = (Rule) unit;
				if(!rule.isMultiRule()){
					rules.add(rule);
				}
			}
		}
		
		for (Module subModule : module.getSubModules()) {
			rules.addAll(getAllRules(subModule));
		}
		
		return ECollections.unmodifiableEList(rules);
	}

	/**
	 * Checks if any rule of this module uses derived references.
	 * 
	 * @param editModule
	 *            The module to test.
	 * @return <code>true</code> if any rule of this module uses a derived
	 *         reference; <code>false</code> otherwise.
	 */
	public static boolean hasDerivedReferences(Module editModule) {

		for (Rule rule : getRules(editModule)) {
			for (Edge edge : rule.getLhs().getEdges()) {
				if (edge.getType().isDerived()) {
					return true;
				}
			}
		}

		return false;
	}
}
