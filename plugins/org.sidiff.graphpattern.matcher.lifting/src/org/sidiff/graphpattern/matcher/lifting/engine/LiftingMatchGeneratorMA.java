package org.sidiff.graphpattern.matcher.lifting.engine;

import org.sidiff.graphpattern.matcher.lifting.atomics.AtomicLiftingPatternFactory;
import org.sidiff.graphpattern.matching.BasicMatchValidation;
import org.sidiff.graphpattern.matching.IMatchValidation;
import org.sidiff.graphpattern.matching.algorithms.PartialMatchGeneratorMA;
import org.sidiff.graphpattern.matching.selection.IAtomicPatternFactory;

public class LiftingMatchGeneratorMA extends PartialMatchGeneratorMA {

	protected IAtomicPatternFactory atomicPatternFactory;
	
	protected IMatchValidation matchValidation;
	
	public LiftingMatchGeneratorMA() {
		atomicPatternFactory = new AtomicLiftingPatternFactory();
		matchValidation = new BasicMatchValidation();
	}
	
	@Override
	public IAtomicPatternFactory getAtomicPatternFactory() {
		return atomicPatternFactory;
	}

	@Override
	public IMatchValidation getMatchValidation() {
		return matchValidation;
	}
}
