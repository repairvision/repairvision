package org.sidiff.consistency.repair.lifting.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.consistency.graphpattern.DataStore;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.AbstractPatternMatchingEngine;
import org.sidiff.consistency.graphpattern.matcher.data.NavigableMatchesDS;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.IAtomicPatternFactory;
import org.sidiff.consistency.graphpattern.matcher.tools.CrossReferencer;
import org.sidiff.consistency.repair.lifting.matching.LiftingCrossReferencer;
import org.sidiff.consistency.repair.lifting.matching.atomic.AtomicLiftingPatternFactory;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphIndex;
import org.sidiff.consistency.repair.lifting.util.RecognitionRuleUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.MergeImports;

public abstract class LiftingEngine extends AbstractPatternMatchingEngine {
	
	protected MergeImports mergeImports;

	protected LiftingGraphIndex changeIndex;
	
	protected LiftingGraphDomainMap changeDomainMap;
	
	protected CrossReferencer crossReferencer;
	
	protected IAtomicPatternFactory atomicPatternFactory;
	
	public LiftingEngine(List<NodePattern> graphPattern, ResourceSet targetModels,
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		super(graphPattern, targetModels);
		
		this.changeIndex = changeIndex;
		this.changeDomainMap = changeDomainMap;
	}
	
	protected Collection<NodePattern> getChangeNodePatterns() {
		List <NodePattern> changeNodes = new ArrayList<>();
		
		for (NodePattern node : getGraphPattern()) {
			if (RecognitionRuleUtil.isChangeNode(node)) {
				changeNodes.add(node);
			}
		}
		
		return changeNodes;
	}
	
	@Override
	public void start() {
		SymmetricDifference difference = RecognitionRuleUtil.getSymmetricDifference(getResourceSet());
		
		// Merge external resources into the difference:
		mergeImports = new MergeImports(difference, Scope.RESOURCE, true);
		mergeImports.merge();
		
		// Create matching helper:
		crossReferencer = new LiftingCrossReferencer(getResourceSet(), changeIndex, changeDomainMap);
		atomicPatternFactory = new AtomicLiftingPatternFactory();
		
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
	public CrossReferencer getCrossReferencer() {
		return crossReferencer;
	}
	
	@Override
	public IAtomicPatternFactory getAtomicPatternFactory() {
		return atomicPatternFactory;
	}
	
	public LiftingGraphIndex getChangeIndex() {
		return changeIndex;
	}
	
	public LiftingGraphDomainMap getChangeDomainMap() {
		return changeDomainMap;
	}
}
