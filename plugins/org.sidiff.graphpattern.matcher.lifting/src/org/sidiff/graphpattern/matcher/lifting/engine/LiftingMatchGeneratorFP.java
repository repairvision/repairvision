package org.sidiff.graphpattern.matcher.lifting.engine;

import org.sidiff.debug.DebugUtil;
import org.sidiff.graphpattern.matcher.lifting.atomics.AtomicLiftingPatternFactory;
import org.sidiff.graphpattern.matcher.lifting.util.DebuggingHelper;
import org.sidiff.graphpattern.matching.BasicMatchValidation;
import org.sidiff.graphpattern.matching.IMatchValidation;
import org.sidiff.graphpattern.matching.algorithms.PartialMatchGeneratorFP;
import org.sidiff.graphpattern.matching.selection.IAtomicPatternFactory;

public class LiftingMatchGeneratorFP extends PartialMatchGeneratorFP {

	protected IAtomicPatternFactory atomicPatternFactory;
	
	protected IMatchValidation matchValidation;
	
	public LiftingMatchGeneratorFP() {
		atomicPatternFactory = new AtomicLiftingPatternFactory();
		matchValidation = new BasicMatchValidation();
	}
	
	@Override
	public boolean findNextMatch() {
		boolean result = super.findNextMatch();
		
		DebugUtil.check(
				() -> DebuggingHelper.test_selection_atomicPatterns(graphPattern), 
				"Check on atomic lifting patterns failed!");
		
		return result;
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
