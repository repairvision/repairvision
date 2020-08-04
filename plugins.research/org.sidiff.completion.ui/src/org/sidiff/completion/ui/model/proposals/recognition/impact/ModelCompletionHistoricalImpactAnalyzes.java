package org.sidiff.completion.ui.model.proposals.recognition.impact;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.history.revision.IRevision;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.impact.analysis.ImpactAnalysis;
import org.sidiff.revision.impact.analysis.ImpactAnalyzes;
import org.sidiff.revision.impact.analysis.ImpactScope;
import org.sidiff.revision.impact.analysis.PotentialImpactAnalysis;
import org.sidiff.revision.impact.analysis.PotentialImpactScope;

public class ModelCompletionHistoricalImpactAnalyzes implements ImpactAnalyzes {

	private ModelCompletionHistoricalImpactAnalysis modelCompletionHistoricalImpactAnalysis;
	
	private ModelCompletionImpactScope historicalImpactScope;
	
	public ModelCompletionHistoricalImpactAnalyzes(IRevision difference, List<EObject> context) {
		Set<EObject> contextSet = new LinkedHashSet<>(context);
		List<Change> contextChanges = new ArrayList<>();
		
		for (EObject contextElement : context) {
			contextChanges.addAll(difference.getDifference().getLocalChanges(contextElement));
		}
		
		this.modelCompletionHistoricalImpactAnalysis = new ModelCompletionHistoricalImpactAnalysis(contextChanges);
		this.historicalImpactScope = new ModelCompletionImpactScope(contextSet, modelCompletionHistoricalImpactAnalysis);
	}

	@Override
	public ImpactScope getImpactScope() {
		return historicalImpactScope;
	}

	@Override
	public PotentialImpactAnalysis getPotentialImpactAnalysis() {
		return modelCompletionHistoricalImpactAnalysis;
	}

	@Override
	public PotentialImpactScope getPotentialImpactScope() {
		return historicalImpactScope;
	}

	@Override
	public ImpactAnalysis getImpactAnalysis() {
		return modelCompletionHistoricalImpactAnalysis;
	}
}
