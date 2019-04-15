package org.sidiff.common.emf.access.path.impl;

import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.*;
import org.sidiff.common.emf.access.path.impl.EMFPathAccessorImpl.StrategyImpl;

/**
 * Implements CollectorAccessStrategy.
 * 
 * @see CollectorAccessStrategy
 * 
 * @author Sven Wenzel
 */
class CollectorAccessStrategyImpl implements CollectorAccessStrategy, StrategyImpl<Collection<EObject>> {

	@Override
	public Collection<EObject> evaluate(EObject start, EMFPath path) {
		assert (path instanceof EMFPathImpl) : "Illegal argument! Invalid Path implemention";
		Collection<EObject> result = new ArrayList<EObject>();
		EMFPathImpl pathImpl = (EMFPathImpl) path;
		Collection<EObject> stepResult = Collections.singleton(start);
		for (EMFPathStepImpl step : pathImpl) {
			stepResult = step.evaluateStep(stepResult);
			result.addAll(stepResult);
		}
		return result;
	}
}
