package org.sidiff.consistency.graphpattern.matcher.lifting.engine;

import org.sidiff.consistency.graphpattern.matcher.lifting.atomics.AtomicLiftingPatternFactory;
import org.sidiff.consistency.graphpattern.matcher.matching.BasicMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.partial.PartialMatchGeneratorMA;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.IAtomicPatternFactory;

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
