package org.sidiff.consistency.repair.lifting.engine;

import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.graphpattern.matcher.matching.BasicMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.partial.PartialMatchGenerator;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.IAtomicPatternFactory;
import org.sidiff.consistency.repair.lifting.matching.atomic.AtomicLiftingPatternFactory;
import org.sidiff.consistency.repair.lifting.util.DebuggingHelper;

public class LiftingMatchGenerator extends PartialMatchGenerator {

	protected IAtomicPatternFactory atomicPatternFactory;
	
	protected IMatchValidation matchValidation;
	
	public LiftingMatchGenerator() {
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
