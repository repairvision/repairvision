package org.sidiff.consistency.repair.api.peo.engine;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.consistency.graphpattern.DataStore;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.AbstractPatternMatchingEngine;
import org.sidiff.consistency.graphpattern.matcher.data.NavigableMatchesDS;
import org.sidiff.consistency.graphpattern.matcher.data.selection.SelectionMatching;
import org.sidiff.consistency.repair.api.peo.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.api.peo.util.LiftingGraphIndex;
import org.sidiff.consistency.repair.api.peo.util.RecognitionRuleUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.MergeImports;

public abstract class LiftingEngine extends AbstractPatternMatchingEngine<SelectionMatching> {
	
	protected LiftingMatchGenerator matchGenerator;
	
	protected MergeImports mergeImports;

	protected LiftingGraphIndex changeIndex;
	
	protected LiftingGraphDomainMap changeDomainMap;
	
	public LiftingEngine(List<NodePattern> graphPattern, ResourceSet targetModels,
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		super(targetModels);
		
		this.changeIndex = changeIndex;
		this.changeDomainMap = changeDomainMap;
		
		this.matchGenerator = new LiftingMatchGenerator();
	}
	
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
	public LiftingMatchGenerator getMatchGenerator() {
		return matchGenerator;
	}
}
