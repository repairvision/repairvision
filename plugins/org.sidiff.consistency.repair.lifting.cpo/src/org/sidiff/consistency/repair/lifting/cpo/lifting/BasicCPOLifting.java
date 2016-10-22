package org.sidiff.consistency.repair.lifting.cpo.lifting;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.difference.lifting.recognitionengine.IRecognitionEngine;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;

public abstract class BasicCPOLifting {

	protected SymmetricDifference difference;
	
	protected IRecognitionEngine recognitionEngine;
	
	protected ILiftingRuleBase rulebases_sub;
	
	protected ILiftingRuleBase rulebase_cpo;

	/**
	 * Search for partially executed edit-operation which might cause an
	 * inconsistency. A repair complements such a partial edit-operation.
	 * 
	 * @param modelA
	 *            The historic model.
	 * @param modelB
	 *            The actual model.
	 * @param subEditRules
	 *            All edit-rules which are to be investigated for partial executions.
	 * @param cpEditRules
	 *            All consistency-preserving edit-operations.
	 * @param documentType
	 * @param settings
	 *            The settings for the difference calculation.
	 */
	public abstract void findSubEditRules(
			Resource modelA, Resource modelB, 
			Collection<Rule> subEditRules, Collection<Rule> cpEditRules, 
			String documentType, DifferenceSettings settings);
	
	
	public SymmetricDifference getDifference() {
		return difference;
	}

	public IRecognitionEngine getRecognitionEngine() {
		return recognitionEngine;
	}

	public ILiftingRuleBase getRulebasesSub() {
		return rulebases_sub;
	}

	public ILiftingRuleBase getRulebaseCPO() {
		return rulebase_cpo;
	}
}
