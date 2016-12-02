package org.sidiff.graphpattern.matcher.lifting.engine;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.MergeImports;
import org.sidiff.graphpattern.DataStore;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.AbstractPatternMatchingEngine;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphDomainMap;
import org.sidiff.graphpattern.matcher.lifting.util.LiftingGraphIndex;
import org.sidiff.graphpattern.matcher.lifting.util.RecognitionRuleUtil;
import org.sidiff.graphpattern.matching.IMatchGenerator;
import org.sidiff.graphpattern.matching.IMatching;
import org.sidiff.graphpattern.wgraph.store.NavigableMatchesDS;

public abstract class LiftingEngine extends AbstractPatternMatchingEngine<IMatching> {
	
	protected IMatchGenerator<IMatching> matchGenerator;
	
	protected MergeImports mergeImports;

	protected LiftingGraphIndex changeIndex;
	
	protected LiftingGraphDomainMap changeDomainMap;
	
	public LiftingEngine(List<NodePattern> graphPattern, ResourceSet targetModels,
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		super(targetModels);
		
		this.changeIndex = changeIndex;
		this.changeDomainMap = changeDomainMap;
		
		this.matchGenerator = createMatchGenerator();
	}
	
	protected abstract IMatchGenerator<IMatching> createMatchGenerator();
	
	@Override
	public void start() {
		SymmetricDifference difference = RecognitionRuleUtil.getSymmetricDifference(getResourceSet());
		
		// Merge external resources into the difference:
		mergeImports = new MergeImports(difference, Scope.RESOURCE, true);
		mergeImports.merge();
		
		super.start();
	}

	@Override
	public void finish() {
		
		// Unmerge external resources into the difference:
		mergeImports.unmerge();
		
		// Stop the engine:
		super.finish();
	}
	
	@Override
	public DataStore createDataStore() {
		return new NavigableMatchesDS();
	}
	
	@Override
	public IMatchGenerator<IMatching> getMatchGenerator() {
		return matchGenerator;
	}
}
