package org.sidiff.common.emf.access.path.impl;

import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.*;
import org.sidiff.common.emf.access.path.impl.EMFPathAccessorImpl.StrategyImpl;

/**
 * Implements SliceAccessStrategyImpl.
 * 
 * @see SliceAccessStrategyImpl
 * 
 * @author Sven Wenzel
 */
class SliceAccessStrategyImpl implements SliceAccessStrategy, StrategyImpl<List<Collection<EObject>>> {

	@Override
	public List<Collection<EObject>> evaluate(EObject start, EMFPath path) {
		assert (path instanceof EMFPathImpl) : "Illegal argument! Invalid Path implemention";
		List<Collection<EObject>> result = new ArrayList<Collection<EObject>>();
		EMFPathImpl pathImpl = (EMFPathImpl) path;
		Collection<EObject> stepResult = Collections.singleton(start);
		for (EMFPathStepImpl step : pathImpl) {
			stepResult = step.evaluateStep(stepResult);
			result.add(stepResult);
		}
		return result;
	}
}
