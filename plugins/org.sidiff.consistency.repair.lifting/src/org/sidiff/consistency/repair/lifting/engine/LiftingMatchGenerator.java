package org.sidiff.consistency.repair.lifting.engine;

import org.sidiff.consistency.graphpattern.matcher.matching.BasicMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.partial.PartialMatchGenerator;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.IAtomicPatternFactory;
import org.sidiff.consistency.repair.lifting.matching.atomic.AtomicLiftingPatternFactory;

public class LiftingMatchGenerator extends PartialMatchGenerator {

	protected IAtomicPatternFactory atomicPatternFactory;
	
	protected IMatchValidation matchValidation;
	
	public LiftingMatchGenerator() {
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
