package org.sidiff.consistency.repair.lifting.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.AbstractPatternMatchingEngine;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.tools.CrossReferencer;
import org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper;
import org.sidiff.consistency.repair.lifting.matching.LiftingCrossReferencer;
import org.sidiff.consistency.repair.lifting.matching.LiftingMatchValidation;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphDomainMap;
import org.sidiff.consistency.repair.lifting.util.LiftingGraphIndex;
import org.sidiff.consistency.repair.lifting.util.RecognitionRuleUtil;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.MergeImports;

public abstract class LiftingEngine extends AbstractPatternMatchingEngine {

	protected LiftingGraphIndex changeIndex;
	
	protected LiftingGraphDomainMap changeDomainMap;
	
	protected MatchingHelper matchingHelper;
	
	protected MergeImports mergeImports;
	
	public LiftingEngine(GraphPattern graphPattern, ResourceSet targetModels,
			LiftingGraphIndex changeIndex, LiftingGraphDomainMap changeDomainMap) {
		super(graphPattern, targetModels);
		
		this.changeIndex = changeIndex;
		this.changeDomainMap = changeDomainMap;
	}
	
	protected Collection<NodePattern> getChangeNodePatterns() {
		List <NodePattern> changeNodes = new ArrayList<>();
		
		getAllNodePatterns().forEachRemaining(node -> {
			if (RecognitionRuleUtil.isChangeNode(node)) {
				changeNodes.add(node);
			}
		});
		
		return changeNodes;
	}
	
	@Override
	public void start() {
		SymmetricDifference difference = RecognitionRuleUtil.getSymmetricDifference(getResourceSet());
		
		// Merge external resources into the difference:
		mergeImports = new MergeImports(difference, Scope.RESOURCE, true);
		mergeImports.merge();
		
		// Create matching helper:
		CrossReferencer crossReferencer = new LiftingCrossReferencer(getResourceSet(), changeIndex, changeDomainMap);
		this.matchingHelper = new MatchingHelper(crossReferencer);
		
		super.start();
	}

	@Override
	public void stop() {
		
		// Unmerge external resources into the difference:
		mergeImports.unmerge();
		
		// Stop the engine:
		super.stop();
	}
	
	@Override
	public IMatchValidation createMatchValidation() {
		return new LiftingMatchValidation();
	}
	
	public LiftingGraphIndex getChangeIndex() {
		return changeIndex;
	}
	
	public LiftingGraphDomainMap getChangeDomainMap() {
		return changeDomainMap;
	}
}
