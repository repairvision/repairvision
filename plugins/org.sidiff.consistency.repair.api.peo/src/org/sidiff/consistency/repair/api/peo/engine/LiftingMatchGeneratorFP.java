package org.sidiff.consistency.repair.api.peo.engine;

import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.graphpattern.matcher.matching.BasicMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.partial.PartialMatchGeneratorFP;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.IAtomicPatternFactory;
import org.sidiff.consistency.repair.api.peo.matching.atomic.AtomicLiftingPatternFactory;
import org.sidiff.consistency.repair.api.peo.util.DebuggingHelper;

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
