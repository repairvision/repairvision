package org.sidiff.common.emf.access.path.impl;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.EMFPath;
import org.sidiff.common.emf.access.path.TargetEvaluationStrategy;
import org.sidiff.common.emf.access.path.impl.EMFPathAccessorImpl.StrategyImpl;

/**
 * Implements TargetEvaluationStrategy.
 * 
 * @see TargetEvaluationStrategy
 * 
 * @author Maik Schmidt
 */
class TargetEvaluationStrategyImpl implements TargetEvaluationStrategy, StrategyImpl<Collection<EObject>> {

	@Override
	public Collection<EObject> evaluate(EObject start, EMFPath path) {
		assert (path instanceof EMFPathImpl) : "Illegal argument! Invalid Path implemention";

		EMFPathImpl pathImpl = (EMFPathImpl) path;
		Collection<EObject> stepResult = Collections.singleton(start);
		for (EMFPathStepImpl step : pathImpl) {
			stepResult = step.evaluateStep(stepResult);
			if(stepResult.isEmpty()){
				break; // Optimized: Skip following steps if current step returns a empty set 
			}
		}
		return stepResult;
	}
}
