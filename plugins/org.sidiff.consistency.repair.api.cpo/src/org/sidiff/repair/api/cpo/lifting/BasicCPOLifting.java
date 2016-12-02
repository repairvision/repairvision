package org.sidiff.repair.api.cpo.lifting;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.difference.lifting.recognitionengine.IRecognitionEngine;
import org.sidiff.difference.rulebase.view.ILiftingRuleBase;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.repair.api.cpo.CPORepairSettings;

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
	 * @param settings
	 *            The settings for the repair calculation.
	 */
	public abstract void findSubEditRules(Resource modelA, Resource modelB, CPORepairSettings settings);
	
	
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
